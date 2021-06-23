class ConsoleBuffer
{
} ;

class Console
{
	protected:
		HANDLE 						m_hConInput ;
		DWORD   					m_dwConSave ;
		HANDLE 						m_hConfile ;
		CONSOLE_SCREEN_BUFFER_INFO	m_sbiScreenInfo ;
	public:
	Console( void ) { }
	void OpenConsole( void )
	{
		g_hConInput = GetStdHandle( STD_INPUT_HANDLE ) ;
		if (g_hConInput == INVALID_HANDLE_VALUE)
			ErrorExit("GetStdHandle");
		// Save the current input mode, to be restored on exit.
		if ( !GetConsoleMode(g_hConInput, &g_dwConSave) )
			ErrorExit("GetConsoleMode");

		// Enable the window and mouse input events.
		DWORD ConMode = ENABLE_WINDOW_INPUT | ENABLE_MOUSE_INPUT;
		if (! SetConsoleMode(g_hConInput, ConMode ) )
			ErrorExit("SetConsoleMode");
		
		// open the console file descriptor to get access to the charinfo buffer
		if ( !( m_hConfile = CreateFileA( "CONOUT$", GENERIC_READ | GENERIC_WRITE , 
				FILE_SHARE_WRITE | FILE_SHARE_READ , NULL, 
				OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL 
				)))
			ErrorExit(" CreateFile" ) ;
		else 
		{
			// load console screeninfo structure
			if( !GetConsoleScreenBufferInfo( m_hConfile, & m_sbiScreenInfo ) )
				ErrorExit( "GetConsoleScreenBufferInfo" ) ;
		}
			
			

	}
	void CloseConsole( void )
	{
		// Restore input mode.
		SetConsoleMode( m_hConInput, m_dwConSave ) ;
	}


	void FlushKeys( void )
	{


		_INPUT_RECORD inputRecord[ 128 ] ;
		unsigned long int eventCount ;


		cout << "Flushing Keys..." << endl ;


		while( PeekConsoleInput( m_hConInput, &inputRecord[0], 128, &eventCount ) && eventCount  )
		{
			//PeekConsoleInput( g_hConInput, &inputRecord[0], 1, &eventCount ) ;
			//cout  << "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b" << eventCount  ;
			cout << "EventType: " << ( inputRecord[eventCount-1].EventType == KEY_EVENT ? "KEY_EVENT" : "OTHER" ) << endl ;
			ReadConsoleInput( g_hConInput, &inputRecord[0], 1, &eventCount ) ;
		}

	}
	VOID ErrorExit (LPSTR lpszMessage)
	{
		fprintf(stderr, "%s\n", lpszMessage);

		// Restore input mode on exit.

		SetConsoleMode( m_hConInput, m_dwConSave ) ;

		ExitProcess(0);
	}
	inline void ClearScreen( void )
	{
		cout << "\x1B[c"  ;
		cout << "\x1B[2J"  ;	//clear screen
	}
	inline void Home( void )
	{
		cout << "\x1B[1;1H" << endl ;	// set cursor position
	}
	inline void HomeColumn( void )
	{
	}
	inline int MaxRow( void )
	{
		return m_sbiScreenInfo.dwSize.Y ;
	} 
	inline int MaxColumn( void )
	{
		return m_sbiScreenInfo.dwSize.X ;
	}
	inline void SetCursor( int row, int column )
	{
		cout << "\x1B[" ;
		cout << column << ';' ;
		cout << row << 'H' ;
	} 
	void WriteString( char* str, unsigned long int x, unsigned long int y )
	{
		COORD coord ;
		coord.X = x ;
		coord.Y = y ;
		unsigned long int wCount ;
		
		WriteConsoleOutputCharacter( m_hConfile, LPCTSTR( str ), strlen( str ),
			coord, &wCount ) ;
			
	}
	void DrawBox( int x, int y, int width, int height ) 
	{
		char str[1024] ;
		str[0] = TL_CORNER ;

		//WriteStringcout << TL_CORNER ;
		for( int i = 1 ; i < width ; ++i )
			str[ i ] = H_BAR ;
		
		str[ width-1 ] = TR_CORNER ;
		str[ width ] = 0 ;
		WriteString( str, x, y) ;	
			

		str[ 0 ] = V_BAR ; str[ 1 ] = 0 ;
		for ( int i = 1 ; i < height ; ++i ) 
		{
			WriteString( str, x, y+i ) ;
			WriteString( str, x+width-1, y+i) ;
		}
		str[0] = BL_CORNER ;

		//WriteStringcout << TL_CORNER ;
		for( int i = 1 ; i < width ; ++i )
			str[ i ] = H_BAR ;
		str[ width-1 ] = BR_CORNER ;
		str[ width ] = 0 ;
		WriteString( str, x, height-1) ;	

	}
	void DrawBorder( void )
	{
		DrawBox( 0, 0, MaxColumn(), MaxRow() ) ;
	}

};

unsigned int g_nLineNdx ;

VOID ErrorExit (LPSTR lpszMessage) ;
void DrawBox( int width, int height ) ;

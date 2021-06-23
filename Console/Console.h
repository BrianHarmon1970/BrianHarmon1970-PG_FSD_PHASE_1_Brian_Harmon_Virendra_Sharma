#ifndef __CONSOLE_H__
#define __CONSOLE_H__
#include <consoleAPI.h>
#include <fileAPI.h>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>
#include <string>

using namespace std ;

// 0xB3-0xDA 
const unsigned char TL_CORNER = 201 ;
const unsigned char TR_CORNER = 187 ;

const unsigned char H_BAR = 205 ;
const unsigned char V_BAR = 186 ;

const unsigned char BL_CORNER = 200 ;
const unsigned char BR_CORNER = 188 ;

// character attributes
//Attribute 	Meaning
/*
FOREGROUND_BLUE 	Text color contains blue.
FOREGROUND_GREEN 	Text color contains green.
FOREGROUND_RED 	Text color contains red.
FOREGROUND_INTENSITY 	Text color is intensified.
BACKGROUND_BLUE 	Background color contains blue.
BACKGROUND_GREEN 	Background color contains green.
BACKGROUND_RED 	Background color contains red.
BACKGROUND_INTENSITY 	Background color is intensified.
COMMON_LVB_LEADING_BYTE 	Leading byte.
COMMON_LVB_TRAILING_BYTE 	Trailing byte.
COMMON_LVB_GRID_HORIZONTAL 	Top horizontal.
COMMON_LVB_GRID_LVERTICAL 	Left vertical.
COMMON_LVB_GRID_RVERTICAL 	Right vertical.
COMMON_LVB_REVERSE_VIDEO 	Reverse foreground and background attributes.
COMMON_LVB_UNDERSCORE 	Underscore.
*/ 

//const int WIDE = 10 ;

class conOutContext
{
protected:
	HANDLE		m_hconOut ;
	WORD		m_nAttribute ;
	CONSOLE_SCREEN_BUFFER_INFO	m_sbiScreenInfo ;
public:
	conOutContext( HANDLE h = NULL ) : m_hconOut( h ) {}
	void setHandle( HANDLE h ) { m_hconOut = h ; }
	void WriteString( const char* str, unsigned long int x, unsigned long int y )
	{
		COORD coord ;
		coord.X = x ;
		coord.Y = y ;
		unsigned long int wCount ;
		
		
		WORD *attr = new WORD[ strlen( str ) + 1 ] ;
		for ( int i = 0 ; i < strlen( str ) ; ++i )
			attr[ i ] = m_nAttribute ;
		
		WriteConsoleOutputCharacter( /*m_hConfile*/m_hconOut, LPCTSTR( str ), ( strlen( str )+x < MaxColumn() ? strlen(str) : MaxColumn()-x ),
			coord, &wCount ) ;
		//WriteConsoleOutputAttribute( m_hConfile, attr  , wCount, coord, &wCount ) ;
		//delete [] attr ;
	}
	void WriteString( string str )
	{ WriteString( str.c_str() ) ; }
	void WriteString( const char* str )
	{
		//COORD coord ;
		//coord.X = x ;
		//coord.Y = y ;
		unsigned long int wCount ;
		
		
		//WORD *attr = new WORD[ strlen( str ) + 1 ] ;
		//for ( int i = 0 ; i < strlen( str ) ; ++i )
		//	attr[ i ] = m_nAttribute ;
		
		WriteConsole( /*m_hConfile*/m_hconOut , LPCTSTR( str ), strlen( str ),
						&wCount, NULL ) ;
		//WriteConsoleOutputAttribute( m_hConfile, attr  , wCount, coord, &wCount ) ;
		//delete [] attr ;
	}
	inline int MaxRow( void )
	{
		return m_sbiScreenInfo.dwSize.Y ;
	} 
	inline int MaxColumn( void )
	{
		return m_sbiScreenInfo.dwSize.X ;
	}
	void SetCursorSize( int size )
	{
		size ;
		CONSOLE_CURSOR_INFO ci ;
		
		ci.dwSize = size ;
		ci.bVisible = true ;
		SetConsoleCursorInfo( m_hconOut, &ci ) ;
	}

} ;

class ConsoleBuffer
{
	HANDLE		m_hScreenBuffer ;
	HANDLE		m_hConsole ;
	CONSOLE_SCREEN_BUFFER_INFO 	m_sbiScreenInfo ;
public:
	ConsoleBuffer( HANDLE h = NULL ) : m_hScreenBuffer( h ) 
	{
		if ( m_hScreenBuffer == NULL )
			m_hScreenBuffer = CreateConsoleScreenBuffer( GENERIC_READ | GENERIC_WRITE , 0, NULL, CONSOLE_TEXTMODE_BUFFER, NULL ) ;
		
	}
	void AttachConsole( HANDLE conHandle = NULL ) 
	{ 
		if ( conHandle != NULL )
		{
			m_hConsole = conHandle ;
		}
		else m_hConsole =  GetStdHandle( STD_INPUT_HANDLE ) ;
		SetConsoleActiveScreenBuffer( m_hScreenBuffer ) ;
	}
	void SetScreenBufferWindow( int x, int y, int w, int h )
	{
		SMALL_RECT window_rectangle ;
		window_rectangle.Left = x ;
		window_rectangle.Top = y ;
		window_rectangle.Right = x+w ;
		window_rectangle.Bottom = y+h ;
		SetConsoleWindowInfo( m_hScreenBuffer, false , &window_rectangle ) ;
		
	}
		
		
	void 	setBufferHandle( HANDLE sbh ) { m_hScreenBuffer = sbh  ; }
	HANDLE getBufferHandle( void ) { return m_hScreenBuffer ; }
		
} ;

class Console
{
	protected:
		HANDLE 						m_hConInput ;
		DWORD   					m_dwConSave ;
		HANDLE 						m_hConfile ;
		HANDLE						m_hConScreenBuffer ;
		HANDLE						m_hConBlankBuffer ;
		CONSOLE_SCREEN_BUFFER_INFO	m_sbiScreenInfo ;
		WORD							m_nAttribute ;
		conOutContext				m_coutContext ;
	public:
	Console( void ) { OpenConsole() ; }
	~Console( ) { CloseConsole() ; }
	HANDLE	getHandle( void ) { return m_hConfile ; }
	HANDLE getBufferHandle( void ) { return m_hConScreenBuffer ; }
	conOutContext& getOutputContext( void ) { return m_coutContext ; }
	void OpenConsole( void )
	{
		m_hConInput = GetStdHandle( STD_INPUT_HANDLE ) ;
		if (m_hConInput == INVALID_HANDLE_VALUE)
			ErrorExit("GetStdHandle");
		// Save the current input mode, to be restored on exit.
		if ( !GetConsoleMode(m_hConInput, &m_dwConSave) )
			ErrorExit("GetConsoleMode");

		// Enable the window and mouse input events.
		DWORD ConMode = ENABLE_WINDOW_INPUT | ENABLE_MOUSE_INPUT;
		if (! SetConsoleMode(m_hConInput, ConMode ) )
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
			
		CreateScreenBuffer() ;

	}
	void CloseConsole( void )
	{
		// Restore input mode.
		SetConsoleMode( m_hConInput, m_dwConSave ) ;
	}
	void CreateScreenBuffer( void )  
	{
		m_hConBlankBuffer = CreateConsoleScreenBuffer( NULL, 0, NULL, CONSOLE_TEXTMODE_BUFFER, NULL ) ;
		m_hConScreenBuffer = CreateConsoleScreenBuffer( GENERIC_READ | GENERIC_WRITE , 0, NULL, CONSOLE_TEXTMODE_BUFFER, NULL ) ;
		SetConsoleActiveScreenBuffer( m_hConScreenBuffer ) ;
		m_coutContext.setHandle( m_hConScreenBuffer ) ;
	}
	void SetScreenBufferWindow( int x, int y, int w, int h )
	{
		SMALL_RECT window_rectangle ;
		window_rectangle.Left = x ;
		window_rectangle.Top = y ;
		window_rectangle.Right = x+w ;
		window_rectangle.Bottom = y+h ;
		SetConsoleWindowInfo( m_hConScreenBuffer, false , &window_rectangle ) ;
		
	}
	
	void ShowBuffer( bool bShow = true )
	{
		if ( bShow == false )
			SetConsoleActiveScreenBuffer( m_hConBlankBuffer ) ;
		else
			SetConsoleActiveScreenBuffer( m_hConScreenBuffer ) ;
	}

	void FlushKeys( void )
	{


		//_INPUT_RECORD inputRecord[ 128 ] ;
		//unsigned long int eventCount ;


		cout << "Flushing Keys..." << endl ;


		//while( PeekConsoleInput( m_hConInput, &inputRecord[0], 128, &eventCount ) && eventCount  )
		//{
		//	//PeekConsoleInput( g_hConInput, &inputRecord[0], 1, &eventCount ) ;
		//	//cout  << "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b" << eventCount  ;
		//	cout << "EventType: " << ( inputRecord[eventCount-1].EventType == KEY_EVENT ? "KEY_EVENT" : "OTHER" ) << endl ;
		//	ReadConsoleInput( m_hConInput, &inputRecord[0], 1, &eventCount ) ;
		//}
		FlushConsoleInputBuffer( m_hConInput ) ;

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
		//cout << "\x1B[" ;
		//cout << column << ';' ;
		//cout << row << 'H' ;
		
		COORD coord ;
		coord.X = column ;
		coord.Y = row ;
		SetConsoleCursorPosition( m_hConfile, coord ) ;
	} 
	void SetAttribute( WORD Attributes )
	{
		m_nAttribute = Attributes  ;
//		SetConsoleTextAttribute( m_hConfile, Attributes ) ;
	}
	void WriteString( const char* str, unsigned long int x, unsigned long int y )
	{
		COORD coord ;
		coord.X = x ;
		coord.Y = y ;
		unsigned long int wCount ;
		
		
		WORD *attr = new WORD[ strlen( str ) + 1 ] ;
		for ( int i = 0 ; i < strlen( str ) ; ++i )
			attr[ i ] = m_nAttribute ;
		
		WriteConsoleOutputCharacter( /*m_hConfile*/m_hConScreenBuffer, LPCTSTR( str ), ( strlen( str )+x < MaxColumn() ? strlen(str) : MaxColumn()-x ),
			coord, &wCount ) ;
		//WriteConsoleOutputAttribute( m_hConfile, attr  , wCount, coord, &wCount ) ;
		//delete [] attr ;
	}
	void WriteString( string str )
	{ WriteString( str.c_str() ) ; }
	void WriteString( const char* str )
	{
		//COORD coord ;
		//coord.X = x ;
		//coord.Y = y ;
		unsigned long int wCount ;
		
		
		//WORD *attr = new WORD[ strlen( str ) + 1 ] ;
		//for ( int i = 0 ; i < strlen( str ) ; ++i )
		//	attr[ i ] = m_nAttribute ;
		
		WriteConsole( /*m_hConfile*/m_hConScreenBuffer , LPCTSTR( str ), strlen( str ),
						&wCount, NULL ) ;
		//WriteConsoleOutputAttribute( m_hConfile, attr  , wCount, coord, &wCount ) ;
		//delete [] attr ;
	}
	void DrawBox( int x, int y, int width, int height ) 
	{
		char str[1024] ;
		str[0] = TL_CORNER ;
		str[1] = 0 ;
		
		//WriteStringcout << TL_CORNER ;
		for( int i = 1 ; i < width ; ++i )
			str[ i ] = H_BAR ;
		
		str[ width ] = TR_CORNER ;
		str[ width + 1 ] = 0 ;
		WriteString( str, x, y) ;	
			

		str[ 0 ] = V_BAR ; str[ 1 ] = 0 ;
		for ( int i = y+1 ; i < y+(height -1 ) ; ++i ) 
		{
			WriteString( str, x, i ) ;
			WriteString( str, x+width, i) ;
		}
		str[0] = BL_CORNER ; str[1] = 0 ;

		//WriteStringcout << TL_CORNER ;
		for( int i = 1 ; i < width ; ++i )
			str[ i ] = H_BAR ;
		str[ width ] = BR_CORNER ;
		str[ width+1 ] = 0 ;
		WriteString( str, x, y+height-1) ;	

	}
	void DrawBorder( void )
	{
		DrawBox( 0, 0, MaxColumn(), MaxRow() ) ;
	}
	HANDLE InputHandle( void ) { return m_hConInput ; } 
	void SetCursorSize( int size )
	{
		size ;
		CONSOLE_CURSOR_INFO ci ;
		
		ci.dwSize = size ;
		ci.bVisible = true ;
		SetConsoleCursorInfo( m_hConfile, &ci ) ;
	}
	string &ReadConsole( string &str, unsigned long size = 1024 ) 
	{
		unsigned long dwCharsRead ;
		::ReadConsole( m_hConInput, (void*)str.c_str(), size, &dwCharsRead, NULL ) ;
		return str ;
	}
};

//unsigned int g_nLineNdx ;

//VOID ErrorExit (LPSTR lpszMessage) ;
//void DrawBox( int width, int height ) ;



#endif // __CONSOLE_H__
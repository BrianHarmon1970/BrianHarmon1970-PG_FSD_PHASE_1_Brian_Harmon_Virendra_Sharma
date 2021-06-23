#include "Console.h"
#include <fstream>
#include <vector>

class File
{
	ifstream	m_fInput ;
	string		m_strFileName ;
	vector<string>		m_vFileLines ;
	
	public:
	File( string filename ) : m_fInput( filename.c_str() )
	{
		m_strFileName = filename ;
		//m_fInput.open( m_strFileName ) ;
		LoadFile() ;
	}
	~File() { m_fInput.close() ; }
	void LoadFile( void ) 
	{
		if ( m_fInput.good() )
		{
			string str ;
			while ( getline( m_fInput, str ) )
			{
				int n ; 
				while( ( n = str.find('\t')) != string::npos )
					str.replace( n, 1, 5-((n+4)%5), ' ' ) ;
				//for ( int i = 0 ; i < str.length() ; ++i )
				//	if ( str[ i ] == '\t'  || str[ i ] == '\n' ) str[ i ] = ' ' ;
				
					
				m_vFileLines.push_back( str )  ;
			}
		}
	};
	vector<string>& Lines( void ) { return m_vFileLines ; }
} ;

class	ConsoleCursor
{
protected:
	HANDLE	m_hConsole ;
	int 	m_nXPosition ;
	int		m_nYPosition ;
	bool	m_bVisible ;
	int 	m_nCursorSize ;
	
	//CONSOLE_CURSOR_INFO_EX m_ciExtendedCursorInfo ;
	
public:
	ConsoleCursor( void ) 
	{
		m_nXPosition = 0 ;
		m_nYPosition = 0 ;
	}
	void AssociateConsole( HANDLE cConsole )
	{
		CONSOLE_CURSOR_INFO	ci ;
		m_hConsole = cConsole ;
		GetConsoleCursorInfo( m_hConsole, &ci ) ;
		m_bVisible = ci.bVisible ;
		m_nCursorSize = ci.dwSize ;
	}
	void SetCursorSize( int size )
	{
		m_nCursorSize = size ;
		CONSOLE_CURSOR_INFO ci ;
		
		ci.dwSize = m_nCursorSize ;
		//ci.bVisible = m_bVisible ;
		ci.bVisible = true ;
		SetConsoleCursorInfo( m_hConsole, &ci ) ;
	}
	inline void SetCursor( int row, int column )
	{
		//cout << "\x1B[" ;
		//cout << column << ';' ;
		//cout << row << 'H' ;
		
		COORD coord ;
		coord.X = column ;
		coord.Y = row ;
		SetConsoleCursorPosition( m_hConsole, coord ) ;
	} 
} ;
	
	
	
class ConsoleEventHandler
{
public:
	virtual void DoUpArrow( void ) = 0 ;
	virtual void DoDownArrow( void ) = 0 ;
	virtual void DoLeftArrow( void ) = 0 ;
	virtual void DoRightArrow( void ) = 0 ;
	virtual void DoEscape( void ) = 0 ;
} ;
class Window : public ConsoleEventHandler 
{
	int 	m_nWindowHeight ;
	int 	m_nWindowWidth ;
	int 	m_nOriginRow ;
	int 	m_nOriginColumn ;
	
	vector<string>	*m_pvstrBufferLines ;
	int		m_nLineNdx  ;
	int		m_nCharNdx  ;
	
	Console*	m_pConsole ;
public:
	Window( int row, int column, int width, int height ) : m_pvstrBufferLines( NULL ) , m_pConsole(NULL)
	{
		m_nOriginRow = row ;
		m_nOriginColumn = column ;
		m_nWindowHeight = height ;
		m_nWindowWidth = width ;
		
		m_nCharNdx = 0 ;
		m_nLineNdx = 0 ;
	}
	~Window() { delete m_pvstrBufferLines ; }
	void Move( int row, int column ) { m_nOriginRow = row ; m_nOriginColumn = column  ; } 
	void Resize( int width , int height ) { m_nWindowHeight = height ; m_nWindowWidth = width  ; }
	
	void SetBuffer( vector<string>& v ) { m_pvstrBufferLines = new vector<string>(v) ; }
	void ScrollViewLeft( int n=1 ) { --m_nCharNdx ; 
									//nCharNdx-- ; 
									m_nCharNdx = ( m_nCharNdx > 0 ?  m_nCharNdx : 0 ) ; }
	void ScrollViewRight( int n=1 ) { //++m_nCharNdx ;
										//nCharNdx++ ;
										m_nCharNdx = ( m_nCharNdx < (*m_pvstrBufferLines)[ m_nLineNdx ].length()-m_nWindowWidth ? 
											++m_nCharNdx : 
												(*m_pvstrBufferLines)[ m_nLineNdx ].length()-m_nWindowWidth ) ;	}
	void ScrollViewUp( int n=1 ) { m_nLineNdx = ( m_nLineNdx > 0 ? m_nLineNdx-1 : m_nLineNdx ) ;  }
	void ScrollViewDown( int n=1 ) { m_nLineNdx = ( m_nLineNdx < m_pvstrBufferLines->size() ? m_nLineNdx+1 : m_nLineNdx ) ;  ; } 
	void SetConsole( Console& c ) { m_pConsole = &c ; }
	void Draw( void ) 
	{ 
		m_pConsole->ShowBuffer( false ) ;
		ClearWindow() ;
		m_pConsole->DrawBox( m_nOriginColumn, m_nOriginRow, 
							 m_nWindowWidth, 
							 m_nWindowHeight ) ; 
	

		for ( int i = 0 ; i < /*inputfile.Lines().size()*/ m_nWindowHeight-2 ; ++i ) 	
		{
			string s = (*m_pvstrBufferLines)[ m_nLineNdx+i ] ;
		
	
			if ( (*m_pvstrBufferLines)[ m_nLineNdx+i ].length() - m_nCharNdx  > m_nWindowWidth-1 )
				s = (*m_pvstrBufferLines)[ m_nLineNdx+i ].substr( 0, m_nWindowWidth-1+m_nCharNdx ) ;	
				//cout << g_nLineNdx+1+i << ": " << s.substr( (s.length() < nCharNdx ? s.length() : nCharNdx )) ;							
		
			m_pConsole->getOutputContext().WriteString( s.substr( (s.length() < m_nCharNdx ? s.length() : m_nCharNdx )).c_str(), m_nOriginColumn+1, m_nOriginRow+ 1 + i ) ;
		}
		m_pConsole->ShowBuffer() ;
	}
	void ClearWindow( void ) 
	{
		char *cbuf = new char[ m_nWindowWidth+1 ] ;
		for  ( int i = 0 ; i < m_nWindowWidth ; ++i ) 
			cbuf[ i ] = ' ' ;
		cbuf[ m_nWindowWidth+1 ] = 0 ;
		
		for ( int i = 0 ; i < m_nWindowHeight ; ++i )
			m_pConsole->getOutputContext().WriteString( cbuf , m_nOriginColumn, m_nOriginRow+i ) ; 
		delete [] cbuf ;
	}
	virtual void DoUpArrow( void ) { ScrollViewUp() ; Draw() ;}
	virtual void DoDownArrow( void ) { ScrollViewDown() ; Draw() ; }
	virtual void DoLeftArrow( void ) { ScrollViewLeft() ; Draw() ; }
	virtual void DoRightArrow( void ) { ScrollViewRight() ; Draw() ; }
	virtual void DoEscape( void ) {}
	
} ;

class ConsoleInputManager
{
	HANDLE	m_hconInput ;
	ConsoleEventHandler	*m_pEvtHandler ;
public:
	ConsoleInputManager( HANDLE conInput ) { m_hconInput = conInput ; } 
	void SetHandler( ConsoleEventHandler *peh ) { m_pEvtHandler = peh ; }
	HANDLE GetHandle( void ) { return m_hconInput ; }
	void ProcessInput( void ) 
	{
		
		_INPUT_RECORD inputRecord[ 128 ] ;
		unsigned long int eventCount ;
		bool	bRunning = true ;
		while( bRunning )
		{
			if ( ReadConsoleInput( m_hconInput, &inputRecord[0], 128, &eventCount ))
			{
				for ( unsigned int i = 0 ; i < eventCount ; ++i )
				{
					if( inputRecord[i].EventType == KEY_EVENT && !inputRecord[i].Event.KeyEvent.bKeyDown )
					{
						
						if( inputRecord[i].Event.KeyEvent.wVirtualKeyCode == VK_ESCAPE/*27*/ )
							bRunning = false ;

						if( inputRecord[i].Event.KeyEvent.wVirtualKeyCode == VK_DOWN/*40*/ )
						{ 
							//nLineNdx = ( g_nLineNdx < m_vstrFileLines.size() ? g_nLineNdx+1 : g_nLineNdx ) ; 
							m_pEvtHandler->DoDownArrow() ;
						}


						if( inputRecord[i].Event.KeyEvent.wVirtualKeyCode == VK_UP/*38*/ )
						{
							//g_nLineNdx = ( g_nLineNdx > 0 ? g_nLineNdx-1 : g_nLineNdx ) ; 
							m_pEvtHandler->DoUpArrow() ;
						}
					
						if( inputRecord[i].Event.KeyEvent.wVirtualKeyCode == VK_RIGHT )
						{
							m_pEvtHandler->DoRightArrow() ;
							//nCharNdx++ ;
							//nCharNdx = ( nCharNdx < m_vstrFileLines[ g_nLineNdx ].length()-nWindowWidth ? 
							//	nCharNdx : 
							//	m_vstrFileLines[ g_nLineNdx ].length()-nWindowWidth ) ;
						}
						if( inputRecord[i].Event.KeyEvent.wVirtualKeyCode == VK_LEFT )
						{ 
							m_pEvtHandler->DoLeftArrow() ;
							//nCharNdx-- ; nCharNdx = ( nCharNdx < 0 ? 0 : nCharNdx ) ; 
						}

					}
				}
			}
			else
			{
					cout << "READ_CONSOLE_ERROR!!" << endl ;
					bRunning = false ;
			}
			
		}
	}
} ;

int main( void )
{
	File inputfile( "TestConsole.cpp" ) ;
	ConsoleCursor	cc ;
	Console c ;
	cc.AssociateConsole( c.InputHandle() ) ;
	cc.SetCursorSize( 50 ) ;
	c.SetCursorSize( 50 ) ;
	
	c.SetAttribute( FOREGROUND_RED | FOREGROUND_GREEN | FOREGROUND_BLUE | BACKGROUND_BLUE | 
		BACKGROUND_GREEN | FOREGROUND_INTENSITY) ;
	Window	w( 1, 1, 80, 24 ) ;
	w.SetBuffer( inputfile.Lines() ) ;
	w.SetConsole( c ) ;
	//w.Draw() ;
	
	ConsoleInputManager conInput( c.InputHandle() ) ;
	conInput.SetHandler( &w ) ;
	c.FlushKeys() ;
	c.SetCursor( 11, 11 ) ; c.getOutputContext().WriteString( "B>S>H>" ) ;
	
	//c.SetScreenBufferWindow( 1, 1, 80, 24 ) ;
	
	ConsoleCursor ccursor ;
	ccursor.AssociateConsole( c.getBufferHandle() ) ;
	ccursor.SetCursorSize( 40 ) ;
	ccursor.SetCursor( 1, 10 ) ;
	conInput.ProcessInput() ; // will block in endless loop processing until ESC detected
	
	
	
	c.SetAttribute( FOREGROUND_RED | FOREGROUND_GREEN | FOREGROUND_BLUE | BACKGROUND_BLUE  ) ;
	//c.SetAttribute( 0xFF ) ;
	c.WriteString(  "Hello World!!!", 20, 30 ) ;
	//c.DrawBox( 0, 0, c.MaxColumn(), c.MaxRow() ) ;
	
	//c.SetAttribute( FOREGROUND_RED | FOREGROUND_GREEN | FOREGROUND_BLUE | BACKGROUND_BLUE | 
	//	BACKGROUND_GREEN | FOREGROUND_INTENSITY) ;
	//for ( int i = 0 ; i < /*inputfile.Lines().size()*/ 20 ; ++i ) 
	//	c.WriteString( inputfile.Lines()[ i ].c_str(), 5, 5+i) ;

	/*w.ScrollViewDown() ;
	w.ScrollViewDown() ;
	w.ScrollViewDown() ;
	w.ScrollViewDown() ;
	w.Draw() ;
	w.Move( 20,20 ) ;
	w.Draw() ;*/
	
	/*string str , str1;
	char buffer [ 128 ] ;
	c.WriteString( "Enter your name:" ) ; cin >> str1 ;
	//cout.flush() ;
	c.ReadConsole( str ) ;
	c.WriteString(  str ) ;
	str = "The End" ;
	c.WriteString( str ) ;*/
	return  0 ; 
}

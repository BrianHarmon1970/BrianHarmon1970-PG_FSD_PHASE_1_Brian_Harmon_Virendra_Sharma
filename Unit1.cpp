//---------------------------------------------------------------------------

#include "SoundAPI.h"

DeviceCollection *g_pDevices ;
Device            	*g_pDevice ;
AudioMeter    		*g_pAudioMeter ;



#include <vcl.h>
#pragma hdrstop



class DeviceInterfaces
{
	Device  	*m_pDevice ;
	AudioMeter  *m_pAudioMeter ;
	AudioEndpointVolumeInterface *m_pEndpointVolume ;
public:
	DeviceInterfaces( Device *d )
	{
		m_pDevice = d ;
		m_pAudioMeter = new AudioMeter( d ) ;
		m_pEndpointVolume = new AudioEndpointVolumeInterface( *d ) ;
	}
	~DeviceInterfaces( void ) { /*delete m_pAudioMeter ;*/ }
	AudioMeter& IFAudioMeter( void ) { return *m_pAudioMeter ; }
	AudioEndpointVolumeInterface& IFEndpointVolume( void )
	{ return( *m_pEndpointVolume ) ; }
	Device&     IFDevice( void ) { return *m_pDevice ; }

};

//DeviceInterfaces *g_pDeviceInterfaces ;
std::vector<DeviceInterfaces*> *g_pDeviceInterfaces ;
DeviceInterfaces *g_pSelectedDevice ;

#include <stdlib>
#include "Unit1.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"
TForm1 *Form1;
//---------------------------------------------------------------------------
__fastcall TForm1::TForm1(TComponent* Owner)
	: TForm(Owner)
{
	g_pDevices = new DeviceCollection ;
	g_pDevices->Initialize() ;
	//g_pDevice = g_pDevices->Devices().at( 4 ) ;
	//g_pAudioMeter = new AudioMeter( g_pDevice ) ;
	g_pDeviceInterfaces = new vector<DeviceInterfaces*> ;


	DeviceInterfaces *DI ;
	for ( unsigned int i = 0 ; i < g_pDevices->Devices().size() ; ++i )
	{
		DI = new DeviceInterfaces( g_pDevices->Devices().at( i )) ;
		DeviceList->AddItem( g_pDevices->Devices().at( i )->Name().data(), NULL ) ;
		g_pDeviceInterfaces->push_back( DI ) ;
		g_pSelectedDevice = DI ;

		AudioEndpointVolumeInterface& ifEpv
				= g_pSelectedDevice->IFEndpointVolume() ;
		//ifEpv.getVolumeRange()
		float min = ifEpv.MinDB() ;
		float max = ifEpv.MaxDB() ;
		ifEpv.SetVolumeLevel( 0, max ) ;
		//g_pSelectedDevice->IFEndpointVolume().SetVolumeLevel( 0, 0.20 ) ;
	}


	DeviceList->SelStart = 4 ;
    DeviceList->ItemIndex = 4 ;
	DeviceList->Update() ;
	


	//g_Devices ;  = new DeviceCollection ;
	//g_Devices.Initialize() ;
}
//---------------------------------------------------------------------------
void __fastcall TForm1::VC0Changed(TObject *Sender)
{
	UnicodeString ustr ;
	ustr = LevelControl0->Position ;

	VolText0->Caption = ustr  ;

	AudioEndpointVolumeInterface& ifEpv
				= g_pSelectedDevice->IFEndpointVolume() ;

	float min = ifEpv.MinDB() ;
	double max = ifEpv.MaxDB() ;
	double v = LevelControl0->Position / (double)100.0 ;
	float vf = (((max)-(min)) * v) + (min)   ;
	//vf = ( (min > vf) ? min : vf ) ;
	//ifEpv.SetVolumeLevel( 0, max ) ;
	ifEpv.SetVolumeLevel( 0, vf ) ;
}
//---------------------------------------------------------------------------


void __fastcall TForm1::VCChanged1(TObject *Sender)
{
	UnicodeString ustr ;
	ustr = LevelControl1->Position ;

	VolText1->Caption = ustr  ;
	AudioEndpointVolumeInterface& ifEpv
				= g_pSelectedDevice->IFEndpointVolume() ;


	//ifEpv.getVolumeRange()
	float min = ifEpv.MinDB() ;
	float max = ifEpv.MaxDB() ;
	float v = LevelControl1->Position / 100.0 ;
	float vf = (((max)-(min)) * v) + (min)   ;
	//vf = ( (min > vf) ? min : vf ) ;
	//ifEpv.SetVolumeLevel( 0, max ) ;
	ifEpv.SetVolumeLevel( 1, vf ) ;
}
//---------------------------------------------------------------------------



void __fastcall TForm1::TimerTick(TObject *Sender)
{

	float fVol0  ;
	float fVol1 ;

	AudioMeter *meter ; //= g_pAudioMeter ;
    meter = &g_pSelectedDevice->IFAudioMeter() ;
	int channelcount = meter->ChannelCount() ;

	if ( channelcount > 0 )
	{
		fVol0 = meter->ChannelsPeakValues( )[ 0 ]  ;
		//LevelControl0->Position = ( 200 * fVol0 ) ;
		LevelMeter0->Position = ( 200 * fVol0) ;


		if ( channelcount > 1 )
		{
			fVol1 = meter->ChannelsPeakValues( )[ 1 ]  ;
			//LevelControl1->Position = ( 200 * fVol1 ) ;
			LevelMeter1->Position =  200 * fVol1 ;
		}
	}
	else
	{
		fVol0 = meter->PeakValue() ;
        //LevelControl0->Position = ( 200 * fVol0 ) ;
		LevelMeter0->Position = ( 200 * fVol0) ;

    }

}
//---------------------------------------------------------------------------

void __fastcall TForm1::DeviceSelected(TObject *Sender)
{
	//DeviceInterfaces *di = (DeviceInterfaces*) Sender ;
	//g_pDevice = &di->IFDevice() ;
	//g_pDeviceInterfaces = di ;
    g_pSelectedDevice = g_pDeviceInterfaces->at( DeviceList->ItemIndex ) ;

}
//---------------------------------------------------------------------------


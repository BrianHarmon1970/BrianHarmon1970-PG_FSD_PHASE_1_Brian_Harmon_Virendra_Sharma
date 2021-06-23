//---------------------------------------------------------------------------

#ifndef Unit1H
#define Unit1H
//---------------------------------------------------------------------------
#include <System.Classes.hpp>
#include <Vcl.Controls.hpp>
#include <Vcl.StdCtrls.hpp>
#include <Vcl.Forms.hpp>
#include <Vcl.ComCtrls.hpp>
#include <Vcl.ToolWin.hpp>
#include <Vcl.ExtCtrls.hpp>
//---------------------------------------------------------------------------

class TForm1 : public TForm
{
__published:	// IDE-managed Components
	TPanel *Panel1;
	TScrollBar *LevelControl0;
	TScrollBar *LevelControl1;
	TComboBox *DeviceList;
	TLabel *VolText0;
	TLabel *VolText1;
	TProgressBar *LevelMeter0;
	TProgressBar *LevelMeter1;
	TTimer *Timer1;
	void __fastcall VC0Changed(TObject *Sender);
	void __fastcall VCChanged1(TObject *Sender);
	void __fastcall TimerTick(TObject *Sender);
	void __fastcall DeviceSelected(TObject *Sender);
private:	// User declarations
public:		// User declarations
	__fastcall TForm1(TComponent* Owner);
};
//---------------------------------------------------------------------------
extern PACKAGE TForm1 *Form1;
//---------------------------------------------------------------------------
#endif

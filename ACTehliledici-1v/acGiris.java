package ac;

import javax.swing.JOptionPane;

import Tehliledici.Elaveler;

public class acGiris  extends Elaveler{
	public static void main(String args[]) {
	}
	
	public static int OxuyucuInt(String Oxuyucu_adi) {
		int Gonderilecek_deyer;
		try { Gonderilecek_deyer = Integer.parseInt(JOptionPane.showInputDialog(null, "Deye Daxil Edin", Oxuyucu_adi, JOptionPane.INFORMATION_MESSAGE)); 
		} catch(Exception e) { Gonderilecek_deyer = 0; Yazdir("\nDaxil Ediyiniz Deyer Reqem Olmalidir <<< acGiris OxuyucuInt XETA"); }
		return Gonderilecek_deyer; 
	}
	public static String Oxuyucu(String Oxuyucu_adi) {
		String Gonderilecek_deyer;
		try { Gonderilecek_deyer= JOptionPane.showInputDialog(null, "Deye Daxil Edin", Oxuyucu_adi, JOptionPane.INFORMATION_MESSAGE); 
		} catch(Exception e ) { Gonderilecek_deyer = "0"; Yazdir("\nDaxil Ediyiniz Deyer String Olmalidir Bir Problem Var <<< acGiris OxuyucuInt XETA"); }
		return Gonderilecek_deyer; 
	}
	public static char Oxuyucu1Char(String Oxuyucu_adi) {
		char Gonderilecek_deyer;
		try { Gonderilecek_deyer= (char) Integer.parseInt(JOptionPane.showInputDialog(null, "Deye Daxil Edin", Oxuyucu_adi, JOptionPane.INFORMATION_MESSAGE));
		} catch(Exception e) { Gonderilecek_deyer = 0; Yazdir("\nDaxil Ediyiniz Deyer Char Olmalidir <<< acGiris OxuyucuInt XETA"); }
		return Gonderilecek_deyer;  
	}
	
}

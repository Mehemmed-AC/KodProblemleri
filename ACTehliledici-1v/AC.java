package Tehliledici;

import java.io.File;
import java.io.IOException;

public class AC extends Elaveler{
	//DEYISGEN 
	public static int x = 0;
    //public static int y = 2;
	public static String AC_Deyisgenler[][] = new String[20][3];
	
	public static boolean gonderilecek_deyer = false;
	
	
	public static String ACDeyisgenDondurucu(String Deyisgen_adi) {
		String Geri_Dondurulen_Deyisgen = "";
		int x = 0 , y = 1;
    	for(int i = 0; i <= 10; i++) {
    		try {
	    		if(AC.AC_Deyisgenler[x][y].equals(null)) {
	    			break;
	    		}
	    		if(AC.AC_Deyisgenler[x][y].equals(Deyisgen_adi)) {
	    			Geri_Dondurulen_Deyisgen += AC.AC_Deyisgenler[x][++y];
	    		}
	    		++x;
    		} catch(NullPointerException e) {
    			break;
    		}
    	}
    	
    	return Geri_Dondurulen_Deyisgen;
	}
    
	public static boolean ACDeyisgenTanimi(String setir, String mod) {
		String Setir = setir.replace(" ", "");
		String ilkalici = Setir.substring(0,  5);
		String ikincialici = "";
		String ucuncualici = "";
		if(ilkalici.equals("reqem")) {
			int son = MetinAxtarici(Setir, '=');
			if(son != -1 ) {
				ikincialici = Setir.substring(5, son);
				int ikinci_son = MetinAxtarici(Setir, ';');
				if(ikinci_son != -1) {
					ucuncualici = Setir.substring(++son, ikinci_son);
				}
			}
			if(ikincialici.equals("") || ucuncualici.equals("")) {
				Yazdir("Deyisgenlerde bir problem var deyiusgen tanimi zamani bir problem oldu");
			} else {
				if(ikincialici.equals("")) {
					Yazdir("\nBOSDUR ");
				}
				if(mod.equalsIgnoreCase("ustglobal")) {
					
					int y = 1;
					AC_Deyisgenler[x][y] = ikincialici;
					AC_Deyisgenler[x][++y] = ucuncualici;
					if(gonderilecek_deyer == false) {	
						File dosya_javasc = new File(ACT.Dosya_Yolu+"DE");
			    	    if (!dosya_javasc.exists()) {
			    	    	if (dosya_javasc.mkdir()) {
			    	    		Yazdir("\nUSTGLOBAL ucun deyisgenler tanimlandi.");
			    	    		gonderilecek_deyer = true;
			    	    	} else { Yazdir("/nQovluq Yaradildiqi Zaman Xeta Basverdi <<< DosyaYazici XETA"); }
			    	    } else { gonderilecek_deyer = false; }
					}
					try { Dosya_yaz(ucuncualici, ACT.Dosya_Yolu+"DE"+ACT.sla+AC_Deyisgenler[x][--y]+".de"); } catch (IOException e) { e.printStackTrace(); }
					 ++x;
				} else {
					if(ikincialici.equals("") || ucuncualici.equals("")) {
						Yazdir("Deyisgenlerde bir problem var deyiusgen tanimi zamani bir problem oldu");
					} else {			
						int y =1;
						AC_Deyisgenler[x][y] = ikincialici;
						AC_Deyisgenler[x][++y] = ucuncualici;
						++x;
					}
				}	
			}	
		} else {
			if(ilkalici.equals("")) {
				Yazdir("Deyisgen Tanimi zamani XETA basverdi");
			}
		}
		return true;
	}
}
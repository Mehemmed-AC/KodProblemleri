package Tehliledici;

import java.io.IOException;
import java.util.Scanner;

/*
 * 
 * BU KOD ICERSINDE JAVA NIN YAZIM QAYDALRINA VE NEZAKET QAYDALARINA 
 * EMEL EDILMESI LAZIMDIR BU KOK HUCEYRE AC TEHLIL EDICININ BIR NECE 
 * ONEMLI TEHLIL EDICI KIMI MERKEZI FONKSIYONLARINI ICERIR 
 * 
 */

public class ACT extends Elaveler{
	
	//UstGlobal fonksiyon ucun yazilmis deyisgenler 
	private static String OXUNAN_MELUMAT;
	public String SAXLAYICI;

	//Dosya Islemleri Ucun
	public  String DOSYA_ADI;
	public static String Dosya_Yolu;
	
	public static String melumat_tutucu = "";
	
	//Char tipli bir karekter Dosya Yolarinda Yolunu bulmak icin isdifade olunur
	public static char sla = '\\';
	
	//OBJECT
	private Scanner oxuyucu;
	
	public String MetinTemizleyici(String Melumat, int Baslanqic, int Son) {

	    String Tutucu_bir = Melumat.substring(0, Baslanqic);
	    String Tutucu_iki = Melumat.substring(2+Son, Melumat.length());
	    	    	
	    return Tutucu_bir+=Tutucu_iki;
	}
	

    public static String ustglobalalici(String deyisgen){
        try{ melumat_tutucu = Dosya_oxu(ACT.Dosya_Yolu+"DE"+ACT.sla+deyisgen+".de");
        } catch(Exception e){ e.printStackTrace(); }   
        return melumat_tutucu;
    }
   
    public static void ustglobalelavedici(String deyisgen,String operation, String Elave_olunan_deyer){
        int islenen_deyer = 0;
        int alinan_deyer = Integer.parseInt(ustglobalalici(deyisgen));
        if(operation.equals("art+")){
            islenen_deyer = alinan_deyer + Integer.parseInt(Elave_olunan_deyer);
        } else if(operation.equals("art-")){
            islenen_deyer = alinan_deyer - Integer.parseInt(Elave_olunan_deyer);
        } else if(operation.equals("art*")){
            islenen_deyer = alinan_deyer * Integer.parseInt(Elave_olunan_deyer);
        } else if(operation.equals("art/")){
            islenen_deyer = alinan_deyer / Integer.parseInt(Elave_olunan_deyer);
        } else {
            islenen_deyer = Integer.parseInt(Elave_olunan_deyer);
        }
        
        try { Dosya_yaz(Integer.toString(islenen_deyer), ACT.Dosya_Yolu+"DE"+ACT.sla+deyisgen+".de"); } catch (Exception e) { }
    }

    public static void ustglobalelavedici(String deyisgen, String operation, String Elave_olunan_deyer){
        String islenen_deyer;
        String alinan_deyer = ustglobalalici(deyisgen);
        if(operation.equals("+")){
            islenen_deyer = alinan_deyer += Elave_olunan_deyer;
        } else {
            islenen_deyer = Elave_olunan_deyer;
        }
        try { Dosya_yaz(islenen_deyer, ACT.Dosya_Yolu+"DE"+ACT.sla+deyisgen+".de"); } catch (Exception e) { }
    }
	
	//Isdifade olunmayib
    private static boolean UstGlobalBasliqYoxylayici(String yoxlayici) {
    	boolean Netice = false;
    	return Netice;
    }
    //Isdifade olunmayib
    private static int UstGlobalOlcuYoxlayici(String yoxlayici) {
    	int olcu = 0;
    	return olcu;
    }
    
    //bu fonksiyon java ve ya c dilinde isdifade edilecek deyisgenleri saxlayar bir
    //deyisgen hem ac hem java hemde ki c dilinde isdifade edilecek
	public boolean UstglobalYoxlayici(String deyer, int baslanqic) {
    	boolean Gonderilecek_deyer = false;		int son = MetinAxtarici(deyer, ':');
    	if(son != -1) {
    		String yoxlayici = (String) deyer.subSequence(++baslanqic, son); 
    		boolean Netice = UstGlobalBasliqYoxylayici(yoxlayici);
    		if(yoxlayici.equals("USTGLOBAL JAVA,C") || yoxlayici.equals("USTGLOBAL JAVA") ||
    				yoxlayici.equals("USTGLOBAL C,JAVA") || yoxlayici.equals("USTGLOBAL C")) {
        		int olcu = UstGlobalOlcuYoxlayici(yoxlayici);
    			try {
    				OXUNAN_MELUMAT = Dosya_oxu(Dosya_Yolu+DOSYA_ADI); SAXLAYICI = Dosya_oxu(Dosya_Yolu+DOSYA_ADI); } catch (IOException e) { Yazdir("\nPROBLEM VAR <<< UstglobalYoxlayici XETA "); }
    				int Baslanqic_Indexi, Bitis_Indexi;
    				Baslanqic_Indexi = MetinAxtarici(OXUNAN_MELUMAT, '<'); Bitis_Indexi = MetinAxtarici(OXUNAN_MELUMAT, '>');
    				
    				//Asagidaki setirde Bitis_Indexi -= 7; Ust global Son setrinin basliqini ayarlamaya yarayir
    				Bitis_Indexi -= 7;
    				
    				//Asagidaki setirde 12+son ifadesi ust global basliqin sonunu ayarlamaya yarayir
    				String ici = OXUNAN_MELUMAT.substring(12+son, Bitis_Indexi);
    				if(yoxlayici.equals("USTGLOBAL JAVA")) {
    					Yazdir("\nUSTGLOBAL	: JAVA UCUN...");
    					oxuyucu = new Scanner(ici);
    					while(oxuyucu.hasNextLine()) {
							String Setir = oxuyucu.nextLine();
							if(Setir.equals("")) {
							} else {
								AC.ACDeyisgenTanimi(Setir,"ustglobal");
							}
    					}
    				} else if(yoxlayici.equals("USTGLOBAL C")) {
    					Yazdir("\nUSTGLOBAL	: C UCUN...");
    					oxuyucu = new Scanner(ici);
    					while(oxuyucu.hasNextLine()) {
    						String Setir = oxuyucu.nextLine();
    						if(Setir.equals("")) {
    						} else {
    							AC.ACDeyisgenTanimi(Setir,"ustglobal");
    						}
    					}
    				} else if(yoxlayici.equals("USTGLOBAL JAVA,C")) {
    					Yazdir("\nUSTGLOBAL	: JAVA VE C UCUN...");
    					oxuyucu = new Scanner(ici);
    					while(oxuyucu.hasNextLine()) {
    						String Setir = oxuyucu.nextLine();
    						if(Setir.equals("")) {	
    						} else {
    							AC.ACDeyisgenTanimi(Setir,"ustglobal");
    						}
    					}
    				} else if(yoxlayici.equals("USTGLOBAL C,JAVA")) {
    					Yazdir("\nUSTGLOBAL	: C VE JAVA UCUN...");
    					oxuyucu = new Scanner(ici);
    					while(oxuyucu.hasNextLine()) {
    						String Setir = oxuyucu.nextLine();
    						if(Setir.equals("")) {
 	   						} else {
    							AC.ACDeyisgenTanimi(Setir,"ustglobal");
    						}
    					}
    				}
    				
    				/*
    				 * Asagidaki stirde Bitis_Indexi += 7; ust hissede deyisilen 
    				 * ayarin tekrar geri dondurulmesi heyata kecirilib  
    				 */
  
    				Bitis_Indexi += 7;

    				String Temizlenen = MetinTemizleyici(OXUNAN_MELUMAT, Baslanqic_Indexi, Bitis_Indexi);
    			
    				try { Dosya_yaz(Temizlenen, Dosya_Yolu+DOSYA_ADI); } catch (IOException e) { Yazdir("\nPROBLEM VAR <<< UstglobalYoxlayici XETA ");  }
    			Gonderilecek_deyer = true;
    		}
    	}  	
    	return Gonderilecek_deyer;
    }
}

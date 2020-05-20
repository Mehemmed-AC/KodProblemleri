package Tehliledici;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import ac.acSystemFayilari;

public class Elaveler {
	//Tanimlanan Object Deyisgenleri
	private static Scanner isdifadeciden_Oxucu;
	
	//Ekrana Yazdirmaq Ucun Yazilmis Methotlar
    protected static void Yazdir(int deyer){ System.out.printf(""+deyer); }
    protected static void Yazdir(char deyer){ System.out.printf(""+deyer); }
    public static void Yazdir(String deyer){ System.out.printf(""+deyer); }
    
    //Isdifadeciden Oxuyan Methotlar 
	static String Isdifadeciden_Oxu() { isdifadeciden_Oxucu = new Scanner(System.in); String Gonderilen_String = isdifadeciden_Oxucu.nextLine(); return Gonderilen_String; }

	//Bu Method Bir Steir Icerisinden Isdenilen Karakteri Axtararaq O'nun Indexini Geri Gonderir
	static int MetinAxtarici(String Metin, String Axtarilacaq_Deyer){ return Metin.lastIndexOf(Axtarilacaq_Deyer); }
    static int MetinAxtarici(String Metin, char Axtarilacaq_Deyer){ return Metin.indexOf(Axtarilacaq_Deyer); }
    
    //Dosya Islemleri Ucun Yazilan Methodleri
    static void Dosya_yaz(String MELUMAT, String Dosya_Yolu_Dosya) throws IOException {
    	BufferedWriter Yazici = null;
		try { Yazici = new BufferedWriter(new FileWriter(Dosya_Yolu_Dosya)); } catch (IOException e) { Yazdir("\n PROBLEM VAR <<< Dosya_yaz.Elaveler XETA "); }
		Yazici.write(MELUMAT);   		     
		Yazici.close();
    }
    static String Dosya_oxu(String Dosya_Yolu_Dosya) throws IOException {
		File Dosya_Ac	= new File(Dosya_Yolu_Dosya);
		FileReader Dosya_oxuyar = null;
		try { Dosya_oxuyar = new FileReader(Dosya_Ac); } catch (FileNotFoundException e1) { e1.printStackTrace(); } 
		char[] String_Donusdurucu = new char[(int) Dosya_Ac.length()];
		try { Dosya_oxuyar.read(String_Donusdurucu); Dosya_oxuyar.close(); } catch (IOException e ) { Yazdir("\n PROBLEM VAR <<< Dosya_oxu.Elaveler XETA "); }	
		String Geri_Dondurulecek = new String(String_Donusdurucu);
    	return Geri_Dondurulecek;
    }
    static boolean SystemFayilarininYoxlanilmasi(String dilin_tipi, String Dosya_Yolu, char sla) {
    	boolean gonderilecek_deyer = false;
    	if(dilin_tipi.equals("java")) {
    		File dosya_javasc = new File(Dosya_Yolu+sla+"javasc");
    	    if (!dosya_javasc.exists()) {
    	    	if (dosya_javasc.mkdir()) {
    	    		Yazdir("\nJava Kodlari Ucun Qovluq Yaradildi.");
    	    		gonderilecek_deyer = true;
    	    	} else {
    	        	Yazdir("/nQovluq Yaradildiqi Zaman Xeta Basverdi <<< DosyaYazici XETA");
    	        }
    	    }
    	    File dosya_ac = new File(Dosya_Yolu+sla+"javasc"+sla+"ac");
    	    if(!dosya_ac.exists()) {
    	    	if(dosya_ac.mkdir()) {
    	    		Yazdir("\nAC System Qovluqu Yaradildi.");
    	    		gonderilecek_deyer = true;
    	    	} else {
    	    		Yazdir("\nQovluq Yaradildiqi Zaman Xeta Basverdi <<< DosyaYazici XETA");
    	    	}
    	    }
    	    File ac_system_fayilari_java_class_1 = new File(Dosya_Yolu+sla+"javasc"+sla+"ac"+sla+"acElaveler.class");
    	    if(!ac_system_fayilari_java_class_1.exists()) {
    	    	PrintWriter writer = null;
				try {
					writer = new PrintWriter(Dosya_Yolu+sla+"javasc"+sla+"acElaveler.java", "UTF-8");
				} catch (FileNotFoundException e) { e.printStackTrace(); } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
				//Ozel Method Yazilmasi lazimdir
				writer.write(acSystemFayilari.SystemFayiliJavaClass2());
    	    	writer.close();
    	    	ACTehliledici.Terminal("javac acElaveler.java", Dosya_Yolu+sla+"javasc");
    	    	ACTehliledici.Terminal("javac -d ./ acElaveler.java", Dosya_Yolu+sla+"javasc");
    	    }   
    	    File ac_system_fayilari_java_class_2 = new File(Dosya_Yolu+sla+"javasc"+sla+"ac"+sla+"acGiris.class");
    	    if(!ac_system_fayilari_java_class_2.exists()) {
    	    	PrintWriter Fayila_Yaz = null;
				try {
					Fayila_Yaz = new PrintWriter(Dosya_Yolu+sla+"javasc"+sla+"acGiris.java", "UTF-8");
				} catch (FileNotFoundException e) { e.printStackTrace(); } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
				//Ozel Method Yazilmasi lazimdir
				Fayila_Yaz.write(acSystemFayilari.SystemFayiliJavaClass1());
				Fayila_Yaz.close();
    	    	ACTehliledici.Terminal("javac acGiris.java", Dosya_Yolu+sla+"javasc");
    	    	ACTehliledici.Terminal("javac -d ./ acGiris.java", Dosya_Yolu+sla+"javasc");    
    	    }
    	} else if(dilin_tipi.contentEquals("c")) {
    		File dosya_csc = new File(Dosya_Yolu+"csc");
    	    if (!dosya_csc.exists()) {
    	    	if (dosya_csc.mkdir()) {
    	    		Yazdir("\nC Kodlari ucun Qovluq Yaradildi.");
    	    		gonderilecek_deyer = true;

    	        } else {
    	        	Yazdir("/nQovluq Yaradildiqi Zaman Xeta Basverdi <<< DosyaYazici XETA");
    	        }
    	    }
    	    File dosya_ac_c_ozel_kitabxana = new File(Dosya_Yolu+"csc"+sla+"ac_c_ozel_kitabxana");
    	    if (!dosya_ac_c_ozel_kitabxana.exists()) {
    	    	if (dosya_ac_c_ozel_kitabxana.mkdir()) {
    	    		Yazdir("\nAC System Qovluqu Yaradildi.");
    	    		gonderilecek_deyer = true;

    	        } else {
    	        	Yazdir("/nQovluq Yaradildiqi Zaman Xeta Basverdi <<< DosyaYazici XETA");
    	        }
    	    }
    	  //C UCUN YAZILMIS JAVA API SYSTEM YOXLANILMASI
        	File dosya_java_c_api_oxuyucuint = new File(Dosya_Yolu+"csc"+sla+"acOxuycuInt.class");
        	if(!dosya_java_c_api_oxuyucuint.exists()) {
        		PrintWriter Fayila_Yaz = null;
    			try {
    				Fayila_Yaz = new PrintWriter(Dosya_Yolu+"csc"+sla+"acOxuycuInt.java", "UTF-8");
    			} catch (FileNotFoundException e) { e.printStackTrace(); } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
    			//Ozel Method Yazilmasi lazimdir
    			Fayila_Yaz.write(ac.acSystemFayilari.SystemFayilariJavaCOxuyucuIntAPI());
    			Fayila_Yaz.close();
    			ACTehliledici.Terminal("javac acOxuycuInt.java", Dosya_Yolu+"csc");

        	}
        	File dosya_java_c_api_oxuyucustring = new File(Dosya_Yolu+"csc"+sla+"acOxuycuString.class");
        	if(!dosya_java_c_api_oxuyucustring.exists()) {
        		PrintWriter Fayila_Yaz = null;
    			try {
    				Fayila_Yaz = new PrintWriter(Dosya_Yolu+"csc"+sla+"acOxuycuString.java", "UTF-8");
    			} catch (FileNotFoundException e) { e.printStackTrace(); } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
    			//Ozel Method Yazilmasi lazimdir
    			Fayila_Yaz.write(ac.acSystemFayilari.SystemFayilariJavaCOxuycuStriungAPI());
    			Fayila_Yaz.close();
    			ACTehliledici.Terminal("javac acOxuycuString.java", Dosya_Yolu+"csc");

        	}
    	    File ac_system_fayilari_c = new File(Dosya_Yolu+sla+"csc"+sla+"ac_c_ozel_kitabxana"+sla+"acos_technology.c");
    	    if(!ac_system_fayilari_c.exists()) {
	    		gonderilecek_deyer = true;

    	    	PrintWriter Fayila_Yaz = null;
				try {
					Fayila_Yaz = new PrintWriter(Dosya_Yolu+sla+"csc"+sla+"ac_c_ozel_kitabxana"+sla+"acos_technology.c", "UTF-8");
				} catch (FileNotFoundException e) { e.printStackTrace(); } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
				//Ozel Method Yazilmasi lazimdir
				if(ACTehliledici.isWindows()) {
					Fayila_Yaz.write(ac.acSystemFayilari.SystemFayiliCWin());
					Fayila_Yaz.close();
				} else {
					Fayila_Yaz.write(ac.acSystemFayilari.SystemFayiliCLi());
					Fayila_Yaz.close();  	    
				}
    	    }
    	    File ac_system_fayilari_c_header = new File(Dosya_Yolu+sla+"csc"+sla+"ac_c_ozel_kitabxana"+sla+"acos_technology.h");
    	    if(!ac_system_fayilari_c_header.exists()) {
	    		gonderilecek_deyer = true;
    	    	PrintWriter Fayila_Yaz = null;
				try {
					Fayila_Yaz = new PrintWriter(Dosya_Yolu+sla+"csc"+sla+"ac_c_ozel_kitabxana"+sla+"acos_technology.h", "UTF-8");
				} catch (FileNotFoundException e) { e.printStackTrace(); } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
				//Ozel Method Yazilmasi lazimdir
				Fayila_Yaz.write(ac.acSystemFayilari.SystemFayiliCHeader());
				Fayila_Yaz.close();
    	    }
    	}
    	
    	return gonderilecek_deyer;
    }
    
    static void SystemFayilarininSilinmesi(String Dosya_Yolu, char sla) {
	    File ac_system_fayilari_c = new File(Dosya_Yolu+sla+"csc"+sla+"ac_c_ozel_kitabxana"+sla+"acos_technology.c");
	    ac_system_fayilari_c.delete();
	    File ac_system_fayilari_h = new File(Dosya_Yolu+sla+"csc"+sla+"ac_c_ozel_kitabxana"+sla+"acos_technology.h");
	    ac_system_fayilari_h.delete();
	    File silinecek_ac_system_fayilari_java_2 = new File(Dosya_Yolu+sla+"javasc"+sla+"acElaveler.java");
        silinecek_ac_system_fayilari_java_2.delete();
        File silinecek_ac_system_fayilari_java_1 = new File(Dosya_Yolu+sla+"javasc"+sla+"acGiris.java");
	    silinecek_ac_system_fayilari_java_1.delete();
        File silinecek_ac_system_fayilari_java_class_1 = new File(Dosya_Yolu+sla+"javasc"+sla+"acElaveler.class");
        silinecek_ac_system_fayilari_java_class_1.delete();
        File silinecek_ac_system_fayilari_java_class_2 = new File(Dosya_Yolu+sla+"javasc"+sla+"acGiris.class");
        silinecek_ac_system_fayilari_java_class_2.delete();
        File silinecek_ac_system_fayilari_c_java_oxuyucuint_api = new File(Dosya_Yolu+sla+"csc"+sla+"acOxuycuInt.java");
        silinecek_ac_system_fayilari_c_java_oxuyucuint_api.delete(); 
        File silinecek_ac_system_fayilari_c_java_oxuyucuiString_api = new File(Dosya_Yolu+sla+"csc"+sla+"acOxuycuString.java");
        silinecek_ac_system_fayilari_c_java_oxuyucuiString_api.delete();   
        
    }
    public static void SystemFayillariSonSilinenler(boolean bayrag, String Dosya_Yolu, char sla) {
    	if(bayrag == true) {
    		//C UCUN YAZILMIS OLAN BIR JAVA API NIN CLASS FAYILINI SILER 
    		File silinecek_ac_system_fayilari_c_java_oxuyucuint_api_class = new File(Dosya_Yolu+sla+"csc"+sla+"acOxuycuInt.class");
            silinecek_ac_system_fayilari_c_java_oxuyucuint_api_class.delete(); 
            File silinecek_ac_system_fayilari_c_java_oxuyucustring_api_class = new File(Dosya_Yolu+sla+"csc"+sla+"acOxuycuString.class");
            silinecek_ac_system_fayilari_c_java_oxuyucustring_api_class.delete(); 
            File silinecek_ac_system_fayilari_oturucu_ac  = new File(Dosya_Yolu+sla+"csc"+sla+"Oturucu.ac");
            silinecek_ac_system_fayilari_oturucu_ac.delete();
    	}
    }
}
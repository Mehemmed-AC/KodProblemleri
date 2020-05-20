package Tehliledici;

import java.io.*;
import java.util.Date;

import javax.swing.JFileChooser;

import ac.acSystemFayilari;

public class ACTehliledici extends Elaveler{
	
	private static ACT act = new ACT();
	
	//Linux
	private static boolean Linux_ORTAMI_UCUN = true;
	
	//Windows 
	private static String Windows_ORTAMI_GONDERDIYI_DEYER = "";
	
	//MetinTehliledici si icersinde isdifade olunan deyisgenler
	static int Dosya_Basliqlarini_Sayaci = 0;
	
	//MetinIcAlici
	public static boolean PROBLEM_BAYRAGI = false;
	public static boolean Gonderilen_Deyer = false;
	public static boolean Problem_MetinIcAlici = false;

	//MetinTemizle
	static String Temizlenen_iceri;
	static boolean Temizleme_Bayragi = false;;
	private static String Temizlenen_bayir = "";
	
	//DosyaYazici si icersinde isdifade olunan deyisgenler
	static boolean BILDIRIS_BAYRAGI_C = true;
	static boolean BILDIRIS_BAYRAGI_JAVA = true;
	
	//BasliqYoxlayici Deyisgenleri
	private boolean bayrag_my = true;
	
	//USTGLOBAL DEYISGENLERI 
	public static boolean ustglobal_bayrag;		
	//public static String OXUNAN_MELUMAT;
	//public static String SAXLAYICI;
	
	//Isled 
	static boolean Baslad = false;
	private static int Dosya_Adlarini_Sayaci = 0;

	//AC DILININ DEYISGENLERI
	private static boolean AC_Yzim_Tehliledici_Ucun_Bayrag = true;
	
	//AC PROGRAMLAMA DILINDE ISDIFADE OLUNACAQ AC TEREFINDEN YAZILAN JAVA KITBXANA LARI
	//private static String ELAVE_EDILECEK_AC_KITABXANALARI = "import ac.acGiris;\n";
	
	//GLOBAL DEYISGENLER
		//ONEMLI BAYRAG DEYISGENLERI
		static boolean dosya_bayrag = false; 
		static int dosya_baslanqic = 0;
		private static boolean Bayrag = true;

		//Deyisgennler
		private static int Dongu = 0;
		
		//STRING DEYISGEN
		static String dosya_MELUMAT;
		//private static String DOSYA_ADI = "";			
		private static String  OS = System.getProperty("os.name").toLowerCase();
			
		//Object 
		private static File DOSYA_ACIR;
	
		//Array 
		private static String[] Dosya_Adlari = new String[10000];
		private static String[]	Dosya_Adlari_Isled = new String[10000];
		
		//int array 
		
		//int 
	
	public static void vaxt() {
		Date Vaxt = new Date();
		Yazdir("["+Vaxt.toString()+"]\n");
	}
	
    public ACTehliledici() {
    	//ACTehliledici nin conustructuru
    }
  
    public static boolean isWindows()	{return (OS.indexOf("win") >= 0);}
	public static boolean isMac()		{return (OS.indexOf("mac") >= 0);}
	public static boolean isUnix()		{return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );}
	public static boolean isSolaris()	{return (OS.indexOf("sunos") >= 0);}
	
	//DUZGUN ISLEYIR TERMINAL BAGLANTI
	static void Terminal(String Emeliyat_Emri, String Islenecek_Qovluq) {	
	        Process Emeliyat = null;	
	        try {
	        	Emeliyat = Runtime.getRuntime().exec(Emeliyat_Emri, null, new File(Islenecek_Qovluq));	
	        	BufferedReader Oxuyucu = new BufferedReader(new InputStreamReader(Emeliyat.getInputStream()));
	        	String Setir = "";
	        	while((Setir = Oxuyucu.readLine()) != null) {
	        		
	        		if(Setir.equals("-")) {
	        			Yazdir("\ninput lazimdir\n");
	    	        	//Emeliyat = Runtime.getRuntime().exec("2");	
	        			
	        			 Oxuyucu = new BufferedReader(new InputStreamReader(Emeliyat.getInputStream()));	        			
	        		}
	        		
	        		Yazdir(Setir + "\n");
	        	}
	       } catch (IOException e) {
			Yazdir("\nBIR PROBLEM VAR... <<< XETA Terminal");
		}
	}
	//ASAQIDAKI STANDAR TERMINAL METODUNAN FERQI C UC7UN YAZILMASIDIR BU HISSEDE UC EDED TERMINAL METODU VAR
	static void COzelTerminal(String Emeliyat_Emri) {
		Process Emeliyat = null; try { Emeliyat = Runtime.getRuntime().exec(Emeliyat_Emri); }
		catch (IOException e) {	Yazdir("BIR PROBLEMK VAR... ??\"ISLEDME ZAMANI\"?? <<<< XETA TERMINAL COozelTerminal"); e.printStackTrace(); }
	    BufferedReader Oxuyucu = new BufferedReader(new InputStreamReader(Emeliyat.getInputStream()));
	    String Oxunan = null;
	    try { while((Oxunan = Oxuyucu.readLine()) != null) { Yazdir(Oxunan); } 
		} catch (IOException e1) { Yazdir("BIR PROBLEMK VAR... ??\"OXUMA ZAMANI\"?? <<<< XETA TERMINAL COozelTerminal"); e1.printStackTrace(); }
	}
	static void Terminal(String Emeliyat_Emri) {	
        Process Emeliyat = null;	
        try {
        	Emeliyat = Runtime.getRuntime().exec(Emeliyat_Emri);		
        	BufferedReader Oxuyucu = new BufferedReader(new InputStreamReader(Emeliyat.getInputStream()));
        	String Setir = "";
        	while((Setir = Oxuyucu.readLine()) != null) { Yazdir(Setir + "\n"); } 
        } catch (IOException e) { e.printStackTrace(); }
	}   
	//Terminal Methodu Sonlandi //
	
    //DUZGUN ISLEYIR | AC Tehlil edicinin oldugu yerdeki ac ve diger dosyalarin gosderen
    static String DosyalarinGosderilmesi() throws IOException, InterruptedException {	
		if (isWindows()) { System.out.println("Windwos Emeliyat Systemi.\n"); Linux_ORTAMI_UCUN = false; Windows_ORTAMI_GONDERDIYI_DEYER = Fayilsec(); }
		 else if (isMac()) { System.out.println("Mac Emeliyat Systemi.\n");    Terminal("ls"); }
		  else if (isUnix()) { System.out.println("Linux Emeliyat Systemi.\n"); act.sla = '/'; Terminal("ls"); }
		   else if (isSolaris()) { System.out.println("Solaris Emeliyat Systemi."); }
		    else { System.out.println("Sizin Emeliyat Systemi Duzgun Bir System Deyil..."); }
		return Windows_ORTAMI_GONDERDIYI_DEYER;
    }
    
    public static String Fayilsec() {
    	String Gonderilen = "";
    	JFileChooser FayilarAcVeSec = new JFileChooser("\\C:");
    	 
    	int returnValue = FayilarAcVeSec.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	File selectedFile = FayilarAcVeSec.getSelectedFile();
        	Gonderilen = selectedFile.getName();
        } else {
        	Yazdir("\nBir Problem Var <<< Fayilsec XETA");
        }     
        
        return Gonderilen;
    }
    
    //AC Tehlil edicinin harda oldugunu gosderer
    static String DosyaYolu() {
		String Dosya_Yolunu_Saxlayan = System.getProperty("user.dir");
		Dosya_Yolunu_Saxlayan += "/";
		String toplanan_netice = "";
		int Baslanqic	= 0;
		int Son			= 0;
		if(isWindows()) {
			for(int Dongu = 0; Dongu <= Dosya_Yolunu_Saxlayan.length(); Dongu++) {
				Baslanqic = MetinAxtarici(Dosya_Yolunu_Saxlayan, '/');
				if(Baslanqic != -1) {
					String Tutucu_Bir = Dosya_Yolunu_Saxlayan.substring(++Baslanqic, Dosya_Yolunu_Saxlayan.length());		
					Dosya_Yolunu_Saxlayan = Tutucu_Bir;
					Son = MetinAxtarici(Tutucu_Bir, '/');
					if(Son != -1) {
						String Tutucu_Iki = Tutucu_Bir.substring(0, Son);	
						toplanan_netice += ("//"+Tutucu_Iki);
					}
				}
			}
			act.Dosya_Yolu = toplanan_netice;
		} else { toplanan_netice = Dosya_Yolunu_Saxlayan; act.Dosya_Yolu = toplanan_netice; }
		return toplanan_netice;
    }
    
    //Terminal Yonlendiriciler
    static void DosyaTehliledici(String Dosya_Adi, String Islenecek_Qovluq) { Terminal(Dosya_Adi, Islenecek_Qovluq); }
    static void DosyaBasladici(String Dosya_Adi_Uzantisiz, String Islenecek_Qovluq) { Terminal(Dosya_Adi_Uzantisiz, Islenecek_Qovluq); }
    
    //Merkezi Basliq Methodu MAIN:fgdg
	public static void main(String[] args) {
		vaxt();
		DosyaYolu();
	
		try { DosyalarinGosderilmesi(); } catch (IOException e) { e.printStackTrace(); } catch (InterruptedException e) { e.printStackTrace(); }
    	
		if(Linux_ORTAMI_UCUN == true) {
    		Yazdir("\nAC Fayilinin Adini Daxil Edin :"); 
    		//DEYISIGLIK A DA a 
    		act.DOSYA_ADI = Isdifadeciden_Oxu(); Yazdir("\n");
    		act.DOSYA_ADI+=".ac";
    	} else {
    		act.DOSYA_ADI = Windows_ORTAMI_GONDERDIYI_DEYER;
    		File fayil = new File(act.DOSYA_ADI);
    		act.Dosya_Yolu = fayil.getAbsoluteFile().getParent()+act.sla;
    	}
		
    	boolean gelen_rapor = DosyaOxuyucu();
    	
    	if(gelen_rapor == true) {
	    	if(Bayrag == true) { 
				MetinIcAlici();
			} else {
				Yazdir("\nProblem <<< MetinIcAlici XETA ");   		
			}
	    
	    	String Temizlenen = (Temizlenen_bayir+=Temizlenen_iceri);
	    	Yazdir("\n\nTemizlenen : "+"\n"+Temizlenen);
	    	Yazdir("\nCixis :\n");
	
	    	if(Baslad == true) {
	    		Isled();
	    	} else {
	    		Yazdir("\nBir Problem Var 'AC fayili icersinde bir programlama dili yazilib ve bir xeta buraxilib' <<< Isled XETA");
	    	}
	    	
	    	if(AC_Yzim_Tehliledici_Ucun_Bayrag == true) {
	    		ACYazimTehliledici();
	    	} else {
	    		
	    	}
	    	
	    	//BU HISE AC FAYILININ AYIRILMIS HISSESINI GERI QAYTARIR
	    	try { Dosya_yaz(act.SAXLAYICI, act.Dosya_Yolu+act.DOSYA_ADI ); } catch (IOException e) { e.printStackTrace(); }
	    	//BU HISE PROGRAMIN SONLANDIQDAN SONRA SILINMESI GEREKEN FAYILARI SILER
	    	SystemFayillariSonSilinenler(true, act.Dosya_Yolu, act.sla);
    	} else {
    		Yazdir("\nBu \""+act.DOSYA_ADI+"\" <<< ac Fayili Sizin Fayilarin arasinda Tapilmadi... Main XETA");
    	}	
    }
	
    //DUZGUN ISLEYIR | METININ DOLU OLUB OLMADIGINI YOXLAYARAQ TEHLILIN BOLUNMASINI YONLENDIRIR
    static boolean Tehliledici_(String MELUMAT, String DOSYA_BUTUN_ICERISI) {
    	if (!MELUMAT.equals("")) {
    		Yazdir("\n		BOS-DEYIL <<< Tehliledici_\n---------------------------------------------------------");
    		Bayrag = MetinTehliledici(MELUMAT, DOSYA_BUTUN_ICERISI); 
    	} else { 
    		Yazdir("\nBOSDUR <<< Tehliledici_");
    	} 	
    	return Bayrag;
    }
 		
	public static String Isled() {
		String MELUMAT = "";
		String Tapilan_Deyer = "";
		int Tapilan_Deyerin_Indexi;
		boolean Bildirsi_Bayragi = false;		
		try { 
			LineNumberReader Setir_Oxuyuc = new LineNumberReader(new InputStreamReader(new FileInputStream(act.DOSYA_ADI), "UTF-8")); 
        	while (((MELUMAT = Setir_Oxuyuc.readLine()) != null) && Setir_Oxuyuc.getLineNumber() <= 1000000){
        		Tapilan_Deyerin_Indexi = MetinAxtarici(MELUMAT, '#');
        		if(Tapilan_Deyerin_Indexi != -1) {
        			Tapilan_Deyer = Character.toString(MELUMAT.charAt(Tapilan_Deyerin_Indexi));
        			if(Tapilan_Deyer.equals("#")) {
        				int son = MetinAxtarici(MELUMAT, ';');
        				if(son != -1) {
            				Dosya_Adlarini_Sayaci++;
            				Bildirsi_Bayragi = true;
        					String Oturucu = MELUMAT.substring(++Tapilan_Deyerin_Indexi, son);
        					Dosya_Adlari_Isled[Dosya_Adlarini_Sayaci] = Oturucu;	
        				}
        			}
        		}        		
            }    	
        	if(Bildirsi_Bayragi == true) {
	        	for(int Dongu = 1; Dongu <= Dosya_Adlari.length; Dongu++ ) {
	        		if(Dosya_Adlari[Dongu] != null) {
	        			for(int Ic_Dongu = 1; Ic_Dongu <= Dosya_Adlari_Isled.length; Ic_Dongu++) {
	        				if(Dosya_Adlari_Isled[Ic_Dongu] != null) {	        				
	        					if(Dosya_Adlari[Dongu].equals(Dosya_Adlari_Isled[Ic_Dongu])) {
	        						int Uzanti = MetinAxtarici(Dosya_Adlari_Isled[Ic_Dongu], '.');
	        						String Uzanti_Tutucu = Dosya_Adlari_Isled[Ic_Dongu].substring(++Uzanti);
	        						if(Uzanti_Tutucu.equals("java")) {
	        							String Dosya_Adi_Uzantisiz = Dosya_Adlari_Isled[Ic_Dongu].substring(0, --Uzanti);
	        							DosyaBasladici("java "+Dosya_Adi_Uzantisiz, "javasc");
	        						} else if(Uzanti_Tutucu.equals("c")) {
	        							String Dosya_Adi_Uzantisiz = Dosya_Adlari_Isled[Ic_Dongu].substring(0, --Uzanti);
	        							if(isUnix()) {
	        							DosyaBasladici("./"+Dosya_Adi_Uzantisiz, "./csc");
	        							} else if(isWindows()) {
	        								COzelTerminal(act.Dosya_Yolu+"csc"+act.sla+Dosya_Adi_Uzantisiz+".exe");
	        							} else {
	        								Yazdir("\nIsletim Systeminde Bir Problem Var");
	        							}
	        						} else {
	        							Yazdir("\n PROBLEM Daxil olunan Uzanti Yanlisdir : "+Uzanti); Yazdir(" <<< Isled XETA");
	        						}
	        					}
	        				} else { break; }
	        			}
	        		}
	        		else { break; }
	        	}
        	}
        	Setir_Oxuyuc.close();
        } catch (FileNotFoundException e) {
        	System.err.println("\nFayil Tapilmadi...	<<< MetinTehliledici XETA.");
        } catch (IOException e) { 
        	System.err.println("\nFayil Tapilmadi...	<<< MetinTehliledici XETA."); 
        }	
		return "";
	}
     
    public static boolean DosyaYazici(String DOSYA_ADI, String DOSYAYA_YAZILACAQ) {
    	boolean PROBLEM_BAYRAGI = false;
    	
    	int Uzanti = MetinAxtarici(DOSYA_ADI, '.');
    	String Cixti_Yoxlayici = DOSYA_ADI.substring(0, Uzanti);
    	String Dosya_Uzantisi = DOSYA_ADI.substring(++Uzanti);
    	
    	if(Dosya_Uzantisi.equals("java")) {	
    		SystemFayilarininYoxlanilmasi("java", act.Dosya_Yolu, act.sla);
    	
    		File Temizlenen_classlar = new File(act.Dosya_Yolu+act.sla+"javasc"+act.sla+Cixti_Yoxlayici+".class");
    		if(Temizlenen_classlar.delete()) { }
    		
    			File DOSYA = new File(act.Dosya_Yolu+act.sla+"javasc"+act.sla+DOSYA_ADI);
    			try {
    				DOSYA.createNewFile();
    				try(BufferedWriter Yazici = new BufferedWriter(new FileWriter(DOSYA))){
    					String ELAVE_EDILECEK_AC_KITABXANALARI = "import ac.acGiris;\n";
    							//+ "import ac.acElaveler;";
    					Yazici.write((ELAVE_EDILECEK_AC_KITABXANALARI+DOSYAYA_YAZILACAQ)+"\n");
    					Yazici.close();
    					if(BILDIRIS_BAYRAGI_JAVA == true) { Yazdir("\nJAVA		: Ugurla .java fayilina yazildi"); }
    						DosyaTehliledici("javac "+DOSYA_ADI, "javasc");
    						File doysa_java_class = new File(act.Dosya_Yolu+act.sla+"javasc"+act.sla+Cixti_Yoxlayici+".class");
    						if(!doysa_java_class.exists()) {
    							Yazdir("\nJAVA		: Tehlili zamani <<< DosyaYazici.DosyaTehliledici PROBLEM VAR");
    						} else {
    							Yazdir("\nJAVA		: Ugurla Tehlil Edildi.");
    						}
    				    BILDIRIS_BAYRAGI_JAVA = false;
    				} catch (IOException e) {
    					Yazdir("\nPROBLEM VAR");
    				}
    			} catch(IOException e) {
    				Yazdir("\nDosya Yaradilarken Xeta Bas Verdi <<< DosyaYazici XETA");
    		}
    		
    	} else if(Dosya_Uzantisi.equals("c")) {// C DOSYA YAZICI VE TEHLIL EDICI ICERSINDEKI DEYISIKLIK SEBEBI WINDOWS ICERSINDEKI STANDART AYARLARDIR
    		SystemFayilarininYoxlanilmasi("c", act.Dosya_Yolu, act.sla);	   
	    	File Temizlenen_cprogramlari = new File(act.Dosya_Yolu+act.sla+"csc"+act.sla+Cixti_Yoxlayici);
	        if(Temizlenen_cprogramlari.delete()) { } 
	        	
	    	File DOSYA = new File(act.Dosya_Yolu+"csc"+act.sla+DOSYA_ADI);
	    	try {
	    		DOSYA.createNewFile();
	    		try(BufferedWriter br = new BufferedWriter(new FileWriter(DOSYA))){  
					if(BILDIRIS_BAYRAGI_C == true) { Yazdir("\nC		: Ugurla .c fayilina yazildi"); }
	    			String ELAVE_EDILECEK_AC_C_KITABXANASI = acSystemFayilari.SystemFayileriCInPackage(isWindows());
	    			br.write(ELAVE_EDILECEK_AC_C_KITABXANASI+DOSYAYA_YAZILACAQ);
	    			br.close();
	    			String Tutucu = DOSYA_ADI.substring(0, --Uzanti);	
	    			/*
	    			 * Windows icersinde DosyaTehliledici problem cixarir Problem N:00078 //Proglem P:"GCC WINDWOS ICERSIDNE YOXDU"
	    			*/
	    			if(isWindows() == true) {
	    				DosyaTehliledici("gcc -o "+Tutucu+" "+DOSYA_ADI, "csc");
		    			File doysa_java_class = new File(act.Dosya_Yolu+act.sla+"csc"+act.sla+Cixti_Yoxlayici+".exe ");
						if(!doysa_java_class.exists()) {
							Yazdir("\nC		: Tehlili zamani <<< DosyaYazici.DosyaTehliledici PROBLEM VAR");
						} else {
							Yazdir("\nC		: Ugurla Tehlil Edildi.");
						}
	    			}else {
		    			DosyaTehliledici("gcc -o "+Tutucu+" "+DOSYA_ADI+" "+"./ac_c_ozel_kitabxana"+act.sla+"acos_technology.c", act.Dosya_Yolu+"csc");
		    			File doysa_java_class = new File(act.Dosya_Yolu+act.sla+"csc"+act.sla+Cixti_Yoxlayici);
						if(!doysa_java_class.exists()) {
							Yazdir("\nC		: Tehlili zamani <<< DosyaYazici.DosyaTehliledici PROBLEM VAR");
						} else {
							Yazdir("\nC		: Ugurla Tehlil Edildi.");
						}
	    			}
	    		BILDIRIS_BAYRAGI_C = false;
	    	} catch (IOException e) {
	    			Yazdir("\nPROBLEM VAR");
	    			
	    		}
	    	} catch(IOException e) {
	    		Yazdir("\nDosya Yaradilarken Xeta Bas Verdi <<< DosyaYazici XETA");
	    	}
    	} else { Yazdir("\nDuzgun Fayil Uzantisi Yazin. <<< DosyaYazici XETA	: PROBLEM	: "+Dosya_Uzantisi); PROBLEM_BAYRAGI = true; }
        SystemFayilarininSilinmesi(act.Dosya_Yolu, act.sla);
	    return PROBLEM_BAYRAGI;
    }
    
  	//DUZGUN ISLEYIR | ILK ISLEYEN METHODUR TEHLIL EDICINI CAGIRIR
    static boolean DosyaOxuyucu(){
        String      OXUNAN_MELUMAT;
        char[]      OXUYUCU_VE_TUTUCU;
        boolean		XETA = false;
        boolean     Xeta = false;
        FileReader  DOSYA_OXU;
       
        try{
        	DOSYA_ACIR          = new File(act.DOSYA_ADI);
            DOSYA_OXU           = new FileReader(DOSYA_ACIR);
            OXUYUCU_VE_TUTUCU   = new char[(int)DOSYA_ACIR.length()];	
            
            //.ac Fayilini varligi yoxlandiqdan sonra Oxuma islemi heyata kecir
            
            try { DOSYA_OXU.read(OXUYUCU_VE_TUTUCU); } catch(IOException e) { e.printStackTrace(); XETA = true; }
            OXUNAN_MELUMAT = new String(OXUYUCU_VE_TUTUCU);
            
            Xeta = Tehliledici_(OXUNAN_MELUMAT, OXUNAN_MELUMAT);   
       
            DOSYA_OXU.close();
        } catch(Exception e) {	if(XETA == true ) { Yazdir("\nFayilnan Bagli Bir Problem Var <<< DosyaOxuyucu XETA"); } }
        return 	Xeta;
    }
      
    //TAM OLARAQ DUZGUNLUK YOXLANISI OLUNMAYIB AMA METIN ISLEMEDE ISDIFADE OLUNACAQ <<< MELUMAT
    static boolean MetinTehliledici(String MELUMAT, String DOSYA_BUTUN_ICERISI) {
       	String	Tapilan_Deyer;
    	int 	Tapilan_Deyerin_Indexi, Tapilan_Deyerin_Indexi_iki;
    
        try { 
			LineNumberReader Setir_Oxuyuc = new LineNumberReader(new InputStreamReader(new FileInputStream(act.DOSYA_ADI), "UTF-8")); 
        	while (((MELUMAT = Setir_Oxuyuc.readLine()) != null) && Setir_Oxuyuc.getLineNumber() <= 10001){
        		Tapilan_Deyerin_Indexi = MetinAxtarici(MELUMAT, '<');
        		Tapilan_Deyerin_Indexi_iki = MetinAxtarici(MELUMAT, '>');
        		
	        	if(Tapilan_Deyerin_Indexi != -1 || Tapilan_Deyerin_Indexi_iki != -1) {
	        		AC_Yzim_Tehliledici_Ucun_Bayrag = false;
	        	}
	        	
	        	if(Tapilan_Deyerin_Indexi != -1){
	        		if(ustglobal_bayrag = true) {
	        			boolean ustglobal_ucun_gelen_deyer = act.UstglobalYoxlayici(MELUMAT, Tapilan_Deyerin_Indexi);
		        		if(ustglobal_ucun_gelen_deyer == true) {
		        			ustglobal_bayrag = true;
		        		}
	        		}
	        		
	        	}
	        	
	        	if(Tapilan_Deyerin_Indexi != -1) {
	        		int index_oturucu = Tapilan_Deyerin_Indexi;
	        		boolean gelen_deyer = BasliqYoxlayici(MELUMAT, ++index_oturucu);
	        		if(gelen_deyer == true) {
	        			Tapilan_Deyer = Character.toString(MELUMAT.charAt(Tapilan_Deyerin_Indexi));
	        			if(Tapilan_Deyer.equals("<")) {
	            			Dosya_Basliqlarini_Sayaci++;
		        			String Oturucu = YazimYoxlayicisi(MELUMAT, 1);
		        			Dosya_Adlari[Dosya_Basliqlarini_Sayaci] = Oturucu;        				
		        			Gonderilen_Deyer = true;
	        			} 
	        		} 
	        	}  	 
        	}
        	Setir_Oxuyuc.close();
        } catch (FileNotFoundException e) {
        	System.err.println("\nFayil Tapilmadi...	<<< MetinTehliledici XETA.");
        	} catch (IOException e) { 
        		System.err.println("\nFayil Tapilmadi...	<<< MetinTehliledici XETA."); 
        		}
    	return Gonderilen_Deyer;
    }
    
    //DUZGU ISLEYIR | VE BIR .ac UZANTI DOSYASI ICERSINDE JAVA VE YA C CODU YAZILIB YAZILMADIGINI YOXLAYARAQ ONLARI TEHLIL EDER
    public static String MetinIcAlici() {
    	Baslad = true;

    	File		Dosya_Acici;
    	FileReader	Fayili_Oxuycu; 
    	char[] Stringe_Donusduruc;
    	
    	String GERI_DONDURULEN = "";
    	String MELUMAT_TUTUCU  = "";
    	String Tapilan_Deyer_Baslanqic;
    	String Tapilan_Deyer_Son;
    	
    	if(Dongu != Dosya_Basliqlarini_Sayaci) {
	    	if(dosya_bayrag == false) {
		    	try {
		    		Dosya_Acici				= new File(act.DOSYA_ADI);
		    		Fayili_Oxuycu			= new FileReader(Dosya_Acici); 
		    		Stringe_Donusduruc		= new char[(int) Dosya_Acici.length()];
		    		try { Fayili_Oxuycu.read(Stringe_Donusduruc); Fayili_Oxuycu.close(); } catch (IOException e ) { e.printStackTrace();  Yazdir("\nPROBLEM VAR"); }		    		
		    		MELUMAT_TUTUCU = new String(Stringe_Donusduruc);		    		
		    		int Tapilan_Deyerler_Baslanqic	= MetinAxtarici(MELUMAT_TUTUCU, '<'); 
		    		int Tapilan_Deyerler_Son		= MetinAxtarici(MELUMAT_TUTUCU, '>'); 
		    		int index_oturucu_basliq = Tapilan_Deyerler_Baslanqic;
		    		
		    		boolean gelen_deyer_baslanqicucun = BasliqYoxlayici(MELUMAT_TUTUCU, ++index_oturucu_basliq);
	    			if(gelen_deyer_baslanqicucun == true) {
	    				//Algoritmayi bura yaza bilersiniz ve ya metodu bura yaza bilersiniz 
	    				Tapilan_Deyerler_Son = MetinSonuYoxlayici(MELUMAT_TUTUCU);	 
	    				try {
	    				Temizlenen_iceri = act.MetinTemizleyici(MELUMAT_TUTUCU, --Tapilan_Deyerler_Baslanqic, Tapilan_Deyerler_Son);
	    				} catch(Exception e) {
	    					Yazdir("\nProgram Icersinde AC Kod yazilmayib...");
	    				}
	    				if(Tapilan_Deyerler_Baslanqic != -1 && Tapilan_Deyerler_Son != -1) {
			    			Tapilan_Deyer_Baslanqic	= Character.toString(MELUMAT_TUTUCU.charAt(Tapilan_Deyerler_Baslanqic));
			    			Tapilan_Deyer_Son		= Character.toString(MELUMAT_TUTUCU.charAt(Tapilan_Deyerler_Son));
			    			if(Tapilan_Deyer_Baslanqic.equals("<") || Tapilan_Deyer_Son.equals(">")) { 
			    				++Dongu;			    			
				    			GERI_DONDURULEN = MELUMAT_TUTUCU.substring(++Tapilan_Deyerler_Baslanqic, 2+Tapilan_Deyerler_Son); 				    				
				    			int Axtarici_Basliq = MetinAxtarici(GERI_DONDURULEN, ':');
				    			int Axtarici_Son = MetinAxtarici(GERI_DONDURULEN, ';');    				
				    			String Oturucu = null;
				    			try {
				    				Oturucu = GERI_DONDURULEN.substring(2+Axtarici_Basliq, Axtarici_Son);
				    			} catch(Exception e) { Problem_MetinIcAlici = true; }
				    			if(Problem_MetinIcAlici != true) {
					    			if(Dosya_Adlari[Dongu].equals(Oturucu)) {
					    				int Oturulecek_Metin_Sonu = MetinSonuYoxlayici(GERI_DONDURULEN);
				    					Oturulecek_Metin_Sonu -= 6;
					    				String Oturulecek_Metin = GERI_DONDURULEN.substring(++Axtarici_Son, Oturulecek_Metin_Sonu);
					    				PROBLEM_BAYRAGI = DosyaYazici(Dosya_Adlari[Dongu], Oturulecek_Metin);	
					    			}			    				
				    				if(PROBLEM_BAYRAGI == false) {
						    			dosya_baslanqic = Tapilan_Deyerler_Son;
						    			dosya_MELUMAT = Temizlenen_iceri;						    			
						    			dosya_bayrag = true;
						    			MetinIcAlici();
				    				} else {
				    					Yazdir("\nBir Problem Var <<< MetinIcAlici Birinci bolum XETA");
				    				}  
				    			}
				    		} else {
				    			GERI_DONDURULEN = "\nYAZI SEHFI"; Yazdir("Yazim Sehfi Var <<< MetinIcAlici XETA");
				    		}
			    		} else {
			    			Yazdir("\nYazim Sehfi <<< MetinIcAlici XETA");
			    		} 
	    			} else {
	    				Temizlenen_bayir = MELUMAT_TUTUCU.substring(0, Tapilan_Deyerler_Baslanqic);	    				
	    				dosya_MELUMAT = MELUMAT_TUTUCU.substring(++Tapilan_Deyerler_Baslanqic);
	    				dosya_bayrag = true;
	    				MetinIcAlici();
	    			}
				} catch (FileNotFoundException e1) { e1.printStackTrace(); Yazdir("\nPROBLEM VAR"); }    	
	    	} else {
	    		int Tapilan_Deyerler_Baslanqic	= MetinAxtarici(dosya_MELUMAT, '<'); 
	    		int Tapilan_Deyerler_Son		= MetinAxtarici(dosya_MELUMAT, '>'); 
	    		int index_oturucu_basliq = Tapilan_Deyerler_Baslanqic;
	    		
	    		boolean gelen_deyer_baslanqicucun = BasliqYoxlayici(dosya_MELUMAT, ++index_oturucu_basliq );
    			if(gelen_deyer_baslanqicucun == true) {
    				//Algoritmayi bura yaza bilersiniz ve ya metodu bura yaza bilersiniz 
    				Tapilan_Deyerler_Son = MetinSonuYoxlayici(dosya_MELUMAT);
    				Temizlenen_iceri = act.MetinTemizleyici(dosya_MELUMAT, --index_oturucu_basliq, Tapilan_Deyerler_Son);
		    		if(Tapilan_Deyerler_Baslanqic != -1 && Tapilan_Deyerler_Son != -1) {		    			
		    			Tapilan_Deyer_Baslanqic	= Character.toString(dosya_MELUMAT.charAt(Tapilan_Deyerler_Baslanqic));
		    			Tapilan_Deyer_Son		= Character.toString(dosya_MELUMAT.charAt(Tapilan_Deyerler_Son));
		    			if(Tapilan_Deyer_Baslanqic.equals("<") || Tapilan_Deyer_Son.equals(">")) { 
		    				++Dongu;
		    				try {
		    				GERI_DONDURULEN = dosya_MELUMAT.substring(++Tapilan_Deyerler_Baslanqic, 2+Tapilan_Deyerler_Son);		    				
		    				} catch(StringIndexOutOfBoundsException e) {
		    					Yazdir("\nProblem Tehliledici Sonlandirildi <<< MetinIcAlici XETA ");
		    					System.exit(0);
		    				}
		    				int Axtarici_Basliq = MetinAxtarici(GERI_DONDURULEN, ':');
		    				int Axtarici_Son = MetinAxtarici(GERI_DONDURULEN, ';');		    				
		    				String Oturucu = "bosdur";
		    				try {
		    					Oturucu = GERI_DONDURULEN.substring(2+Axtarici_Basliq, Axtarici_Son);
		    				} catch(Exception e) { Problem_MetinIcAlici = true; }
		    				if(Problem_MetinIcAlici != true) {
			    				try {
				    				if(Dosya_Adlari[Dongu].equals(Oturucu)) {
				    					int Oturulecek_Metin_Sonu = MetinSonuYoxlayici(GERI_DONDURULEN);
				    					Oturulecek_Metin_Sonu -= 6;
				    					String Oturulecek_Metin = GERI_DONDURULEN.substring(1+Axtarici_Son, Oturulecek_Metin_Sonu);
				    					PROBLEM_BAYRAGI = DosyaYazici(Dosya_Adlari[Dongu], Oturulecek_Metin);
				    				}
			    				} catch(Exception e){Yazdir("\nDosya adlarinda problem var <<< MetinIcAlici XETA"+"\nPROBLEM : "+Oturucu); }
			    				if(PROBLEM_BAYRAGI == false) {
				    				dosya_baslanqic = Tapilan_Deyerler_Son;
				    				dosya_MELUMAT = Temizlenen_iceri;
				    				MetinIcAlici();
			    				} else {
			    					Yazdir("\nBir Problem Var <<< MetinIcAlici Ikinci bolum XETA");
			    				}
			    			} else {
			    				int Temizlene_Deyer_Saxlayici = Temizlenen_iceri.length();
			    				dosya_MELUMAT = Temizlenen_iceri.substring(++Tapilan_Deyerler_Baslanqic, Temizlene_Deyer_Saxlayici);
			    				MetinIcAlici();
			    			}
		    			} else {
		    				GERI_DONDURULEN = "\nYAZI SEHFI"; Yazdir("Yazim Sehfi Var <<< MetinIcAlici XETA");
		    			}
		    		} else {
		    			Yazdir("\nYazim Sehfi <<< MetinIcAlici XETA");
		    		}	
		    	} else {
		    		Temizlenen_bayir += dosya_MELUMAT.substring(0, ++index_oturucu_basliq);
    				dosya_MELUMAT = dosya_MELUMAT.substring(1+Tapilan_Deyerler_Baslanqic);
    				MetinIcAlici();
		    	}
	    	}
    	}
		return "";
    }
    
    public static boolean BasliqYoxlayici(String MELUMAT, int Basliq) {
    	boolean Gonderilecek_deyer = false;    	int Son = MetinAxtarici(MELUMAT, ':');
    	if(Son != -1) {
	    	String Yoxlayici = MELUMAT.substring(Basliq, Son);
	    	if(Yoxlayici.equals("BASLANQIC JAVA")) {
	    		Gonderilecek_deyer = true;
	    	} else if(Yoxlayici.equals("BASLANQIC C")) {
	    		Gonderilecek_deyer = true;
	    	}
    	} else {
    		Gonderilecek_deyer = false;
    	}
    	return Gonderilecek_deyer;
    }
    
    public static int MetinSonuYoxlayici(String Metin) {
 
    	//Integer Deyisgenler
    	int Dondurulen = 0;
    	int Tapilan_Deyerin_Indexi;
    	int Toplanan_Deyer = 0;
    	int DONUS_lIMITI = 0;
    	
    	//Boolean Deyisgenler
    	boolean bayrag = true;
    	
    	//Dongu
    	while(bayrag == true) {
    		++DONUS_lIMITI;
    		Tapilan_Deyerin_Indexi = MetinAxtarici(Metin, '>');
    		if(Tapilan_Deyerin_Indexi != -1) {
    			int deyer_tutucu = Tapilan_Deyerin_Indexi;
    			deyer_tutucu-=6;
    			String Yoxlayici;
    			if(deyer_tutucu <= 6 ) {
    				Yoxlayici = "XETA";
    			} else {
    				Yoxlayici = Metin.substring(deyer_tutucu, Tapilan_Deyerin_Indexi);    		
    			}
    			if(Yoxlayici.equals("SON AC")) {
        			Dondurulen += ((Tapilan_Deyerin_Indexi += Toplanan_Deyer));
    				break;
    			} else {
    				++Dondurulen;
    				Toplanan_Deyer += Tapilan_Deyerin_Indexi;
    				Metin = Metin.substring(++Tapilan_Deyerin_Indexi);
    			}
    		} else {   
    		}
    		if(DONUS_lIMITI == 1000000000) {
    			Yazdir("\nProblem Sonsuz Dongu <<< MetinSonuYoxlayici XETA");
    			break;
    		}
    	} 	
    	return Dondurulen;
    }
    
	//DUZGUN ISLEYIR |
    public static String YazimYoxlayicisi(String MELUMAT_TUTUCU, int Axtarilacaq_Soz_Basliq) {
    	int SON = MetinAxtarici(MELUMAT_TUTUCU, ':'); String Basliq = MELUMAT_TUTUCU.substring(Axtarilacaq_Soz_Basliq, SON);
    	String Gonderilecek = "";
     	if(Basliq.equals("BASLANQIC JAVA")) {
     		int Dosya_Adi_Son = MetinAxtarici(MELUMAT_TUTUCU, ';'); String JAVA_DOSYA_ADI = MELUMAT_TUTUCU.substring(2+SON, Dosya_Adi_Son);
    		if(Dosya_Adi_Son != -1) {
    			//DOSYA_ADI BASQA BIR METHODA GONDERILECEK DUZGUN ISLEYIRE |
    			Gonderilecek = JAVA_DOSYA_ADI;
    		} else { Yazdir("\nJava Dosya Adini Vererken Sonuna ';' QOYMAQI UNUTMAYIN <<< Yazim_Yoxlayicisi XETA\n"); }
    	} else if(Basliq.equals("BASLANQIC C")) {
    		int Dosya_Adi_Son = MetinAxtarici(MELUMAT_TUTUCU, ';'); String JAVA_DOSYA_ADI = MELUMAT_TUTUCU.substring(2+SON, Dosya_Adi_Son);
    		if(Dosya_Adi_Son != -1) {
    			//DOSYA_ADI BASQA BIR METHODA GONDERILECEK DUZGUN ISLEYIRE |
    			Gonderilecek = JAVA_DOSYA_ADI;
    		} else { Yazdir("\nC Dosya Adini Vererken Sonuna ';' QOYMAQI UNUTMAYIN <<< Yazim_Yoxlayicisi XETA\n"); }
    	} else { Yazdir("\nYazim Sehfi Var <<< Yazim_Yoxlayicisi XETA\n");}
     	return Gonderilecek;
    }
    
    public static void ACYazimTehliledici() {
    	Yazdir("\nIsleyir");
    }    
    
    /*
     * 
     */

    //BURASI ACTEHLILEDICI JAVA FAYILININ YANLIZ private YAZILAN FONKSIYONLARI VE YA DA METHODLARININ BASLANQICIDIR
    
    //BURDA ACTEHLILEDICI JAVA FAYILININ YANLIZ private YAZILAN FONKSIYONLARININ VE YA DA METHODLARININ SONUDUR

}
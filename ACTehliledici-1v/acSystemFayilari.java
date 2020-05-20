package ac;

import Tehliledici.ACT;
import Tehliledici.Elaveler;

public class acSystemFayilari {
	
	public static String SystemFayileriCInPackage(boolean Melumat) {
		String Gonderilen = null;
		if(Melumat == true) {
			Gonderilen = "\n#include \"ac_c_ozel_kitabxana\\\\acos_technology.h\"\n"
					+ "#include <stdio.h>\n" + 
					"#include <math.h>\n" + 
					"#include <stdlib.h>\n" + 
					"#include <time.h>\n" + 
					"#include <sys\\\\types.h>\n" + 
					//"#include <sys\\\\wait.h>\n" + 
					"#include <sys\\\\stat.h>\n" + 
					"#include <unistd.h>\n" + 
					"#include <dirent.h>\n" + 
					//"#include <sys\\\\utsname.h>\n" + 
					"#include <string.h>\n";
		} else {
			Gonderilen = "#include \"./ac_c_ozel_kitabxana/acos_technology.h\"\n"
					+ "#include <stdio.h>\n" + 
					"#include <math.h>\n" + 
					"#include <stdlib.h>\n" + 
					"#include <time.h>\n" + 
					"#include <sys/types.h>\n" + 
					"#include <sys/wait.h>\n" + 
					"#include <sys/stat.h>\n" + 
					"#include <unistd.h>\n" + 
					"#include <dirent.h>\n" + 
					"#include <sys/utsname.h>\n" + 
					"#include <string.h>\n";
		}
		return Gonderilen;
	}
	public static String SystemFayiliJavaClass1() {
		return "package ac;\n" + 
				"\n" + 
				"import java.util.Date;\n" + 
				"import javax.swing.JFileChooser;\n" + 
				"import javax.swing.JOptionPane;\n" + 
				"import java.io.*; \n" + 
				"\n" + 
				"import ac.acElaveler;\n" + 
				"\n" + 
				"public class acGiris extends acElaveler{\n" + 
				"public static String st = \"\";\n" + 
				"\n" + 
				"\n" + 
				"private static String  OS = System.getProperty(\"os.name\").toLowerCase();\n" + 
				"public static String S_Dosya_Yolu;\n" + 
				"	public static boolean isWindows()	{return (OS.indexOf(\"win\") >= 0);}\n" + 
				"	public static boolean isMac()		{return (OS.indexOf(\"mac\") >= 0);}\n" + 
				"	public static boolean isUnix()		{return (OS.indexOf(\"nix\") >= 0 || OS.indexOf(\"nux\") >= 0 || OS.indexOf(\"aix\") > 0 );}\n" + 
				"	public static boolean isSolaris()	{return (OS.indexOf(\"sunos\") >= 0);}\n" + 
				"	 static String DosyaYolu() {\n" + 
				"		String Dosya_Yolunu_Saxlayan = System.getProperty(\"user.dir\");\n" + 
				"		Dosya_Yolunu_Saxlayan += \"/\";\n" + 
				"		String toplanan_netice = \"\";\n" + 
				"		int Baslanqic	= 0;\n" + 
				"		int Son			= 0;\n" + 
				"		if(isWindows()) {\n" + 
				"			for(int Dongu = 0; Dongu <= Dosya_Yolunu_Saxlayan.length(); Dongu++) {\n" + 
				"				Baslanqic = MetinAxtarici(Dosya_Yolunu_Saxlayan, '/');\n" + 
				"				if(Baslanqic != -1) {\n" + 
				"					String Tutucu_Bir = Dosya_Yolunu_Saxlayan.substring(++Baslanqic, Dosya_Yolunu_Saxlayan.length());		\n" + 
				"					Dosya_Yolunu_Saxlayan = Tutucu_Bir;\n" + 
				"					Son = MetinAxtarici(Tutucu_Bir, '/');\n" + 
				"					if(Son != -1) {\n" + 
				"						String Tutucu_Iki = Tutucu_Bir.substring(0, Son);	\n" + 
				"						toplanan_netice += (\"//\"+Tutucu_Iki);\n" + 
				"					}\n" + 
				"				}\n" + 
				"			}\n" + 
				"			S_Dosya_Yolu = toplanan_netice;\n" + 
				"		} else { S_Dosya_Yolu = Dosya_Yolunu_Saxlayan; }\n" + 
				"		return toplanan_netice;\n" + 
				"  }	\n" + 
				"    public static String ustglobalalici(String deyisgen){DosyaYolu();\n" + 
				" 	\n" + 
				"       try{\n" + 
				"            File file = new File(\""+ACT.Dosya_Yolu+"DE/\"+deyisgen+\".de\"); \n" + 
				"            BufferedReader reader = new BufferedReader(new FileReader(file));\n" + 
				"            st = reader.readLine();\n" + 
				"            reader.close();\n" + 
				"        } catch(Exception e){\n" + 
				"            e.printStackTrace();\n" + 
				"        }\n" + 
				"        return st;\n" + 
				"    }\n" + 
				"    public static void ustglobalelavedici(String deyisgen,String operation, String Elave_olunan_deyer){\n" + 
				"        int islenen_deyer = 0; DosyaYolu();\n" + 
				"         String str;\n" + 
				"        \n" + 
				"        int alinan_deyer = Integer.parseInt(ustglobalalici(deyisgen));\n" + 
				"        if(operation.equals(\"+\")){\n" + 
				"            islenen_deyer = alinan_deyer + Integer.parseInt(Elave_olunan_deyer);\n" + 
				"        } else if(operation.equals(\"-\")){\n" + 
				"            islenen_deyer = alinan_deyer - Integer.parseInt(Elave_olunan_deyer);\n" + 
				"        } else if(operation.equals(\"*\")){\n" + 
				"            islenen_deyer = alinan_deyer * Integer.parseInt(Elave_olunan_deyer);\n" + 
				"        } else if(operation.equals(\"/\")){\n" + 
				"            islenen_deyer = alinan_deyer / Integer.parseInt(Elave_olunan_deyer);\n" + 
				"        } else {\n" + 
				"            islenen_deyer = Integer.parseInt(Elave_olunan_deyer);\n" + 
				"\n" + 
				"        }\n" + 
				"        File file = new File(\""+ACT.Dosya_Yolu+"DE/\"+deyisgen+\".de\");\n" + 
				"        try {\n" + 
				"            str = Integer.toString(islenen_deyer);\n" + 
				"            BufferedWriter writer = new BufferedWriter(new FileWriter(file));\n" + 
				"            writer.write(str);\n" + 
				"     \n" + 
				"            writer.close();\n" + 
				"        } catch (Exception e) {\n" + 
				"        }\n" + 
				"    }\n" + 
				"    public static void ustglobalelavedici(String deyisgen, String Elave_olunan_deyer){DosyaYolu();\n" + 
				"        String operation = \"n\"; \n" + 
				"        int islenen_deyer;\n" + 
				"         String str;\n" + 
				"        String Dosya_Yolu = S_Dosya_Yolu;\n" + 
				"        int alinan_deyer = Integer.parseInt(ustglobalalici(deyisgen));\n" + 
				"        if(operation.equals(\"+\")){\n" + 
				"            islenen_deyer = alinan_deyer + Integer.parseInt(Elave_olunan_deyer);\n" + 
				"        } else if(operation.equals(\"-\")){\n" + 
				"            islenen_deyer = alinan_deyer - Integer.parseInt(Elave_olunan_deyer);\n" + 
				"        } else if(operation.equals(\"*\")){\n" + 
				"            islenen_deyer = alinan_deyer * Integer.parseInt(Elave_olunan_deyer);\n" + 
				"        } else if(operation.equals(\"/\")){\n" + 
				"            islenen_deyer = alinan_deyer / Integer.parseInt(Elave_olunan_deyer);\n" + 
				"        } else {\n" + 
				"            islenen_deyer = Integer.parseInt(Elave_olunan_deyer);\n" + 
				"\n" + 
				"        }\n" + 
				"        File file = new File(\""+ACT.Dosya_Yolu+"DE/\"+deyisgen+\".de\");\n" + 
				"        try {\n" + 
				"            str = Integer.toString(islenen_deyer);\n" + 
				"            BufferedWriter writer = new BufferedWriter(new FileWriter(file));\n" + 
				"            writer.write(str);\n" + 
				"     \n" + 
				"            writer.close();\n" + 
				"        } catch (Exception e) {\n" + 
				"        }\n" + 
				"}\n" + 
				"public static int OxuyucuInt(String Oxuyucu_adi) {\n" + 
				"		int Gonderilecek_deyer;\n" + 
				"		try {  Gonderilecek_deyer = Integer.parseInt(JOptionPane.showInputDialog(null, \"Deye Daxil Edin\", Oxuyucu_adi, JOptionPane.INFORMATION_MESSAGE)); \n" + 
				"		} catch(Exception e) { Gonderilecek_deyer = 0; Yazdir(\"\\nDaxil Ediyiniz Deyer Reqem Olmalidir <<< acGiris OxuyucuInt XETA\"); }\n" + 
				"		return Gonderilecek_deyer; \n" + 
				"	}\n" + 
				"	public static String Oxuyucu(String Oxuyucu_adi) {\n" + 
				"		String Gonderilecek_deyer;\n" + 
				"		try { Gonderilecek_deyer= JOptionPane.showInputDialog(null, \"Deye Daxil Edin\", Oxuyucu_adi, JOptionPane.INFORMATION_MESSAGE); \n" + 
				"		} catch(Exception e ) { Gonderilecek_deyer = \"0\"; Yazdir(\"\\nDaxil Ediyiniz Deyer String Olmalidir Bir Problem Var <<< acGiris OxuyucuInt XETA\"); }\n" + 
				"		return Gonderilecek_deyer; \n" + 
				"	}\n" + 
				"	public static char Oxuyucu1Char(String Oxuyucu_adi) {\n" + 
				"		char Gonderilecek_deyer;\n" + 
				"		try { Gonderilecek_deyer= (char) Integer.parseInt(JOptionPane.showInputDialog(null, \"Deye Daxil Edin\", Oxuyucu_adi, JOptionPane.INFORMATION_MESSAGE));\n" + 
				"		} catch(Exception e) { Gonderilecek_deyer = 0; Yazdir(\"\\nDaxil Ediyiniz Deyer Char Olmalidir <<< acGiris OxuyucuInt XETA\"); }\n" + 
				"		return Gonderilecek_deyer;  \n" + 
				"	}\n" + 
				"}";
	}
	public static String SystemFayiliJavaClass2() {
		return "package ac;\n" + 
				"\n" + 
				"import java.util.Scanner;\n" + 
				"\n" + 
				"public class acElaveler {\n" + 
				"	//Tanimlanan Object Deyisgenleri\n" + 
				"	private static Scanner isdifadeciden_Oxucu;\n" + 
				"\n" + 
				"	//Ekrana Yazdirmaq Ucun Yazilmis Methotlar\n" + 
				"	public static void Yazdir(int deyer){ System.out.printf(\"\"+deyer); }\n" + 
				"    	public static void Yazdir(char deyer){ System.out.printf(\"\"+deyer); }\n" + 
				"    	public static void Yazdir(String deyer){ System.out.printf(\"\"+deyer); }\n" + 
				"\n" + 
				"    	//Isdifadeciden Oxuyan Methotlar\n" + 
				"	public static String Isdifadeciden_Oxu() { isdifadeciden_Oxucu = new Scanner(System.in); String Gonderilen_String = isdifadeciden_Oxucu.nextLine(); return Gonderilen_String; }\n" + 
				"\n" + 
				"	//Bu Method Bir Steir Icerisinden Isdenilen Karakteri Axtararaq O'nun Indexini Geri Gonderir\n" + 
				"	static int MetinAxtarici(String Metin, String Axtarilacaq_Deyer){ return Metin.lastIndexOf(Axtarilacaq_Deyer); }\n" + 
				"	static int MetinAxtarici(String Metin, char Axtarilacaq_Deyer){ return Metin.indexOf(Axtarilacaq_Deyer); }\n" + 
				"\n" + 
				"\n" + 
				"}";
	}
	public static String SystemFayiliCLi() {
		
		return "#include <stdio.h>\n" + 
				"#include <math.h>\n" + 
				"#include <stdlib.h>\n" + 
				"#include <time.h>\n" + 
				"#include <sys/types.h>\n" + 
				"#include <sys/wait.h>\n" + 
				"#include <sys/stat.h>\n" + 
				"#include <unistd.h>\n" + 
				"#include <dirent.h>\n" + 
				"#include <sys/utsname.h>\n" + 
				"#include <string.h>\n" + 
				"\n" + 
				"#if defined(_WIN32) || defined(_WIN64)\n" + 
				"const char *os = \"Windoze\"; const char *sla = '\\\\';\n" + 
				"#include <direct.h>\n" + 
				"#define GetCurrentDir _getcwd\n" + 
				"#else\n" + 
				"#ifdef __linux\n" + 
				"const char *os = \"Linux\";const char *sla = \"/\";\n" + 
				"#include <unistd.h>\n" + 
				"#define GetCurrentDir getcwd\n" + 
				"#else\n" + 
				"const char *os = \"Unknown\";\n" + 
				"#endif\n" + 
				"#endif\n" + 
				"\n" + 
				"#include \"acos_technology.h\"\n" + 
				"\n" + 
				"#define yoxla if\n" + 
				"#define birde_yoxla else if\n" + 
				"#define netice_yoxdusa else\n" + 
				"#define geri_gonderilen return\n" + 
				"#define davamet continue\n" + 
				"#define kes break\n" + 
				"#define dongu while\n" + 
				"#define sayili_dongu for\n" + 
				"#define ek\n" + 
				"#define deyer_dondurmez void\n" + 
				"#define reqem int\n" + 
				"#define herif char\n" + 
				"\n" + 
				"#define BOS NULL\n" + 
				"\n" + 
				"#define ekrana_yazdir printf\n" + 
				"#define isdifadeciden_oxu scanf\n" + 
				"#define beraberdirmi ==\n" + 
				"#define balaca_beraberdir <=\n" + 
				"#define boyuk_beraberdir >=\n" + 
				"\n" + 
				"deyer_dondurmez acos_kitabxana_melumat(){\n" + 
				"    herif setir_bir[299] = \"\\n#define yoxla if \\n#define birde_yoxla else if \\n#define netice_yoxdusa else \\n#define geri_gonderilen return\";\n" + 
				"    herif setir_iki[299] = \"\\n#define davamet continue\\n#define kes break\\n#define dongu while\\n#define sayili_dongu for\\n#define ek\";\n" + 
				"    herif setir_uc[299] = \"\\n#define deyer_dondurmez void\\n#define reqem int\\n#define herif char\\n#define BOS NULL\\n#define ekrana_yazdir printf\";\n" + 
				"    herif setir_dort[299] = \"\\n#define isdifadeciden_oxu scanf\\n#define beraberdirmi ==\\n#define balaca_beraberdir <=\\n#define boyuk_beraberdir >=\";\n" + 
				"    herif setir_bes[299] = \"\";\n" + 
				"    ekrana_yazdir(\"%s\",setir_bir);\n" + 
				"    ekrana_yazdir(\"%s\",setir_iki);\n" + 
				"    ekrana_yazdir(\"%s\",setir_uc);\n" + 
				"    ekrana_yazdir(\"%s\",setir_dort);\n" + 
				"\n" + 
				"}\n" + 
				"\n" + 
				"//BURASI AC PROGRAMLAMA DILI UCUN AYRILMISDIR AC PROGRAMLMA DILININ SYSTEM FONKSIYONLARI SAXLANILIR\n" + 
				"//AC PROGRAMLAM DILI UCUN AYRILMIS YER BITTI\n" + 
				"\n" + 
				"//Emeliyat systeminin adini yazdirar\n" + 
				"deyer_dondurmez ac_emeliyat_systemi_adi(){\n" + 
				"    ekrana_yazdir(\"\\n %s Emeliyat Systemi.\\n\", os);\n" + 
				"\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez ac_fayilari_gosder(char * emeliyat ){\n" + 
				"    system(emeliyat);\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez ac_dosya_yolu(){\n" + 
				"    char buff[FILENAME_MAX];\n" + 
				"    GetCurrentDir( buff, FILENAME_MAX );\n" + 
				"    printf(\"Current working dir: %s\\n\", buff);\n" + 
				"}\n" + 
				"\n" + 
				"reqem acOxuyucuInt(){\n" + 
				"    system(\"java acOxuycuInt\");\n" + 
				"    reqem geri_dondurulen_int;\n" + 
				"    FILE *deyigen_fayili;\n" + 
				"    deyigen_fayili = fopen(\"Oturucu.ac\", \"r\");\n" + 
				"    fscanf(deyigen_fayili, \"%d\", &geri_dondurulen_int);\n" + 
				"    geri_gonderilen geri_dondurulen_int;\n" + 
				"}\n" + 
				"\n" + 
				"herif * acOxuyucuString(){\n" + 
				"    system(\"java acOxuycuString\");\n" + 
				"    char *geri_dondurulen_String = (char *) malloc(sizeof(char) * 3);\n" + 
				"    FILE *deyigen_fayili;\n" + 
				"    deyigen_fayili = fopen(\"Oturucu.ac\", \"r\");\n" + 
				"    fscanf(deyigen_fayili, \"%[^\\n]\", geri_dondurulen_String);\n" + 
				"    geri_gonderilen geri_dondurulen_String;\n" + 
				"}\n" + 
				"\n" + 
				"//AC PROGRAMLAMA DILININ SYSYTEM KITABXANA FONKSIYONLARI BITTI\n" + 
				"\n" + 
				"//Xeta bilgisi verer <<<ACOS OZEL FONKSIYON>>>\n" + 
				"deyer_dondurmez acos_xeta()\n" + 
				"{\n" + 
				"    herif ACOS_XETA[21] = \" <<< ACOS XETA >>>\\n\";\n" + 
				"    ekrana_yazdir(\"%s\", ACOS_XETA);\n" + 
				"}\n" + 
				"\n" + 
				"//acos Bildirisi verer <<<ACOS OZEL FONKSIYON>>>\n" + 
				"deyer_dondurmez acos_bildirs()\n" + 
				"{\n" + 
				"    herif ACOS_BILDIRIS[12] = \" <--- ACOS\\n\";\n" + 
				"    ekrana_yazdir(\"%s\", ACOS_BILDIRIS);\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez system_adi()\n" + 
				"{\n" + 
				"    ekrana_yazdir(\"%s\", os);\n" + 
				"}\n" + 
				"\n" + 
				"//acos technology terefinden yazilmis sifreleme fonksiyon\n" + 
				"deyer_dondurmez A21()\n" + 
				"{\n" + 
				"    herif deyer_gonder;\n" + 
				"    ekrana_yazdir(\"Mesaji daxil edin : \");\n" + 
				"    dongu('-' != deyer_gonder)\n" + 
				"    {\n" + 
				"        deyer_gonder = getchar();\n" + 
				"        ekrani_temizle();\n" + 
				"        sifrelemealgoritmasi(deyer_gonder);\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez sifrelemealgoritmasi(herif deyer_alan)\n" + 
				"{\n" + 
				"    yoxla(deyer_alan beraberdirmi 'a' || deyer_alan beraberdirmi 'A') { ekrana_yazdir(\"21\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'b' || deyer_alan beraberdirmi 'B') { ekrana_yazdir(\"22\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'c' || deyer_alan beraberdirmi 'C') { ekrana_yazdir(\"23\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'd' || deyer_alan beraberdirmi 'D') { ekrana_yazdir(\"31\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'e' || deyer_alan beraberdirmi 'E') { ekrana_yazdir(\"32\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'f' || deyer_alan beraberdirmi 'F') { ekrana_yazdir(\"33\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'g' || deyer_alan beraberdirmi 'G') { ekrana_yazdir(\"41\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'h' || deyer_alan beraberdirmi 'H') { ekrana_yazdir(\"42\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'i' || deyer_alan beraberdirmi 'I') { ekrana_yazdir(\"43\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'j' || deyer_alan beraberdirmi 'J') { ekrana_yazdir(\"51\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'k' || deyer_alan beraberdirmi 'K') { ekrana_yazdir(\"52\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'l' || deyer_alan beraberdirmi 'L') { ekrana_yazdir(\"53\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'm' || deyer_alan beraberdirmi 'M') { ekrana_yazdir(\"61\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'n' || deyer_alan beraberdirmi 'N') { ekrana_yazdir(\"62\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi '0' || deyer_alan beraberdirmi 'O') { ekrana_yazdir(\"63\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'q' || deyer_alan beraberdirmi 'Q') { ekrana_yazdir(\"71\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'p' || deyer_alan beraberdirmi 'P') { ekrana_yazdir(\"72\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'r' || deyer_alan beraberdirmi 'R') { ekrana_yazdir(\"73\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 's' || deyer_alan beraberdirmi 'D') { ekrana_yazdir(\"74\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 't' || deyer_alan beraberdirmi 'T') { ekrana_yazdir(\"81\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'u' || deyer_alan beraberdirmi 'U') { ekrana_yazdir(\"82\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'v' || deyer_alan beraberdirmi 'V') { ekrana_yazdir(\"83\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'w' || deyer_alan beraberdirmi 'W') { ekrana_yazdir(\"91\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'x' || deyer_alan beraberdirmi 'X') { ekrana_yazdir(\"92\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'y' || deyer_alan beraberdirmi 'Y') { ekrana_yazdir(\"93\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'z' || deyer_alan beraberdirmi 'Z') { ekrana_yazdir(\"94\"); }\n" + 
				"\n" + 
				"    yoxla(deyer_alan beraberdirmi ' ')\n" + 
				"    {\n" + 
				"        ekrana_yazdir(\" \");\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//ikilik taban da daxil olunan sayiyi onluq tabana cevirib ekrana yazar\n" + 
				"deyer_dondurmez ikiliktaban(reqem onluk)\n" + 
				"{\n" + 
				"    reqem Bilinmeyen;\n" + 
				"    yoxla(onluk balaca_beraberdir 255)\n" + 
				"    {\n" + 
				"        Bilinmeyen = 7;\n" + 
				"    }\n" + 
				"    birde_yoxla(onluk balaca_beraberdir 65535)\n" + 
				"    {\n" + 
				"        Bilinmeyen = 15;\n" + 
				"    }\n" + 
				"    birde_yoxla(onluk balaca_beraberdir 2147483647)\n" + 
				"    {\n" + 
				"        Bilinmeyen = 30;\n" + 
				"    }\n" + 
				"    ekrana_yazdir(\"\\nIkilik Sytsem : \");\n" + 
				"    reqem i = Bilinmeyen;\n" + 
				"    sayili_dongu(i; i boyuk_beraberdir 0; i--)\n" + 
				"    {\n" + 
				"        yoxla((onluk & 1 << i) != 0)\n" + 
				"        {\n" + 
				"            ekrana_yazdir(\"1\");\n" + 
				"        }\n" + 
				"        netice_yoxdusa\n" + 
				"        {\n" + 
				"            ekrana_yazdir(\"0\");\n" + 
				"        }\n" + 
				"    }\n" + 
				"    ekrana_yazdir(\" : \");\n" + 
				"}\n" + 
				"\n" + 
				"//onluk alib ikilik systeme ceviren fonksiyon\n" + 
				"deyer_dondurmez onluk_al()\n" + 
				"{\n" + 
				"    reqem oxu;\n" + 
				"    ekrana_yazdir(\"Onluk Systemde deyer daxil edin : \");\n" + 
				"    scanf(\"%d\", &oxu);\n" + 
				"    ikiliktaban(oxu);\n" + 
				"    ekrana_yazdir(\"\\nOnluk System Daxil Olunan Deyer : %d\\n\", oxu);\n" + 
				"}\n" + 
				"\n" + 
				"//herifi ikilik tabana ceviren ve ekrana yazan\n" + 
				"deyer_dondurmez herif_al()\n" + 
				"{\n" + 
				"    reqem alinacaq_herif;\n" + 
				"    dongu(alinacaq_herif boyuk_beraberdir - 1)\n" + 
				"    {\n" + 
				"        alinacaq_herif = getchar();\n" + 
				"        yoxla(alinacaq_herif beraberdirmi ' ')\n" + 
				"        {\n" + 
				"            ekrana_yazdir(\" \");\n" + 
				"            ekrana_yazdir(\"\\n\");\n" + 
				"            davamet;\n" + 
				"        }\n" + 
				"        yoxla(alinacaq_herif beraberdirmi '-' || alinacaq_herif beraberdirmi ' ')\n" + 
				"        {\n" + 
				"            kes;\n" + 
				"        }\n" + 
				"        ikiliktaban(alinacaq_herif);\n" + 
				"        ekrana_yazdir(\" : %c \", putchar(alinacaq_herif));\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//bir cumlenin \"-\" isaretine qeder olan herif ve sozleri tek tek ikilik taban cevirir\n" + 
				"deyer_dondurmez setir_sonu()\n" + 
				"{\n" + 
				"    reqem alinacaq_herif;\n" + 
				"    dongu(alinacaq_herif boyuk_beraberdir - 1)\n" + 
				"    {\n" + 
				"        alinacaq_herif = getchar();\n" + 
				"        yoxla(alinacaq_herif beraberdirmi ' ')\n" + 
				"        {\n" + 
				"            ekrana_yazdir(\" \");\n" + 
				"            davamet;\n" + 
				"        }\n" + 
				"        yoxla(alinacaq_herif beraberdirmi '-')\n" + 
				"        {\n" + 
				"            kes;\n" + 
				"        }\n" + 
				"        reqem onluk = alinacaq_herif;\n" + 
				"        reqem i = 0;\n" + 
				"        sayili_dongu(i = 8; i boyuk_beraberdir 0; i--)\n" + 
				"        {\n" + 
				"            yoxla((onluk & (1 << i)) != 0)\n" + 
				"            {\n" + 
				"                ekrana_yazdir(\"1\");\n" + 
				"            }\n" + 
				"            netice_yoxdusa\n" + 
				"            {\n" + 
				"                ekrana_yazdir(\"0\");\n" + 
				"            }\n" + 
				"        }\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//rasgele onluk sayi secib ikilik tabana ceviren avto bit cevirici\n" + 
				"deyer_dondurmez rasgele()\n" + 
				"{\n" + 
				"    srand(time(BOS));\n" + 
				"    reqem i, n, bilinmeyen_sayi;\n" + 
				"    n = 1;\n" + 
				"    sayili_dongu(i = 0; i < n; i++)\n" + 
				"    {\n" + 
				"        bilinmeyen_sayi = rand() % 1000;\n" + 
				"        ikiliktaban(bilinmeyen_sayi);\n" + 
				"        ekrana_yazdir(\"\\nOnluk System : %d\\n\\n\", bilinmeyen_sayi);\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//Terminal ekranini temizlemek ucun.\n" + 
				"deyer_dondurmez ekrani_temizle()\n" + 
				"{\n" + 
				"    yoxla(os beraberdirmi \"Windwos\")\n" + 
				"    {\n" + 
				"        system(\"cls\");\n" + 
				"    }\n" + 
				"    birde_yoxla(os beraberdirmi \"Linux\")\n" + 
				"    {\n" + 
				"        system(\"clear\");\n" + 
				"    }\n" + 
				"    netice_yoxdusa\n" + 
				"    {\n" + 
				"        system(\"clear\");\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//mod almaq ucun yazilmis fonksiyon\n" + 
				"deyer_dondurmez mod_al(reqem x, reqem y)\n" + 
				"{\n" + 
				"    ekrana_yazdir(\"\\n%d\\n\", x % y);\n" + 
				"}\n" + 
				"\n" + 
				"//kendinden onceki sayiyla toplanib yeni sayi ureten fibonacc serisi\n" + 
				"deyer_dondurmez fibonacci(reqem x)\n" + 
				"{\n" + 
				"    yoxla(x < 20)\n" + 
				"    {\n" + 
				"        reqem a = 0, b = 1, c = 0;\n" + 
				"        ekrana_yazdir(\"%d %d\", a, b);\n" + 
				"        sayili_dongu(reqem y = 1; y balaca_beraberdir x; y++)\n" + 
				"        {\n" + 
				"            c = a + b;\n" + 
				"            ekrana_yazdir(\" %d\", c);\n" + 
				"            a = b;\n" + 
				"            b = c;\n" + 
				"        }\n" + 
				"    }\n" + 
				"    netice_yoxdusa\n" + 
				"    {\n" + 
				"        ekrana_yazdir(\"20 : Deyerinden az bir deyer daxil edin...\");\n" + 
				"        acos_xeta();\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//Hanoi 0.2\n" + 
				"deyer_dondurmez hanoi(reqem disk, herif cubug1, herif cubug2, herif cubug3)\n" + 
				"{\n" + 
				"    yoxla(disk beraberdirmi 1)\n" + 
				"    {\n" + 
				"        ekrana_yazdir(\"Disk cubug %c den cubug %c e tasindi. \", cubug1, cubug3);\n" + 
				"        acos_bildirs();\n" + 
				"    }\n" + 
				"    netice_yoxdusa\n" + 
				"    {\n" + 
				"        hanoi(disk - 1, cubug1, cubug3, cubug2);\n" + 
				"        hanoi(1, cubug1, cubug2, cubug3);\n" + 
				"        hanoi(disk - 1, cubug2, cubug1, cubug3);\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//Hanoi 0.2 baslatmaq ucun yazilmali olan fonksiyon\n" + 
				"deyer_dondurmez hanoi_baslat()\n" + 
				"{\n" + 
				"    reqem disk;\n" + 
				"    ekrana_yazdir(\"Zehmet olmasa disk sayisini daxil edin : \");\n" + 
				"    scanf(\"%d\", &disk);\n" + 
				"    hanoi(disk, '1', '2', '3');\n" + 
				"}\n" + 
				"\n" + 
				"//Azdan coxa dogru siralar\n" + 
				"deyer_dondurmez qabarciq_siralama(reqem HECIM)\n" + 
				"{\n" + 
				"    reqem deyer[HECIM], daxil_olunan_deyer;\n" + 
				"\n" + 
				"    sayili_dongu(reqem dongu_sayi = 0; dongu_sayi < HECIM; dongu_sayi++)\n" + 
				"    {\n" + 
				"        ekrana_yazdir(\"\\nQabarciq siralamaya daxil olunancaq %d deyeri daxil edin : \", HECIM);\n" + 
				"        scanf(\"%d\", &daxil_olunan_deyer);\n" + 
				"        deyer[dongu_sayi] = daxil_olunan_deyer;\n" + 
				"    }\n" + 
				"\n" + 
				"    reqem sayac, tur, tutar;\n" + 
				"\n" + 
				"    ekrana_yazdir(\"Daxil olunan deyerler...\\n\");\n" + 
				"    sayili_dongu(sayac = 0; sayac balaca_beraberdir HECIM - 1; sayac++)\n" + 
				"    {\n" + 
				"        ekrana_yazdir(\"%4d\", deyer[sayac]);\n" + 
				"    }\n" + 
				"\n" + 
				"    sayili_dongu(tur = 1; tur balaca_beraberdir HECIM - 1; tur++)\n" + 
				"\n" + 
				"        sayili_dongu(sayac = 0; sayac balaca_beraberdir HECIM - 2; sayac++)\n" + 
				"            yoxla(deyer[sayac] > deyer[sayac + 1])\n" + 
				"    {\n" + 
				"        tutar = deyer[sayac];\n" + 
				"        deyer[sayac] = deyer[sayac + 1];\n" + 
				"        deyer[sayac + 1] = tutar;\n" + 
				"    }\n" + 
				"\n" + 
				"    ekrana_yazdir(\"\\n\\nAzdan coxa dogru siralanmis deyerler...\\n\");\n" + 
				"    sayili_dongu(sayac = 0; sayac balaca_beraberdir HECIM - 1; sayac++)\n" + 
				"        ekrana_yazdir(\"%4d\", deyer[sayac]);\n" + 
				"\n" + 
				"    acos_bildirs();\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez IS(reqem hundurluk)\n" + 
				"{\n" + 
				"    yoxla(hundurluk beraberdirmi 0)\n" + 
				"    {\n" + 
				"        Dosya();\n" + 
				"        return;\n" + 
				"    }\n" + 
				"    reqem is_nomresi_sag = fork();\n" + 
				"    yoxla(is_nomresi_sag > 0)\n" + 
				"    {\n" + 
				"        //Ata\n" + 
				"        reqem is_nomresi_sol_2 = fork();\n" + 
				"        yoxla(is_nomresi_sol_2 > 0)\n" + 
				"        {\n" + 
				"            //Ata\n" + 
				"            Gozle();\n" + 
				"            ekrana_yazdir(\"Ata Is_nomresi: %d ogul is_nomresi: %d ogul_is_nomresi_2: %d\\n\", getpid(), is_nomresi_sag, is_nomresi_sol_2);\n" + 
				"            fflush(stdout); // Ekran cikti garantisi alinmasi icin\n" + 
				"            Ata(is_nomresi_sag, is_nomresi_sol_2);\n" + 
				"        }\n" + 
				"        birde_yoxla(is_nomresi_sol_2 beraberdirmi 0)\n" + 
				"        {\n" + 
				"            //ogul sol\n" + 
				"            IS(--hundurluk);\n" + 
				"        }\n" + 
				"    }\n" + 
				"    birde_yoxla(is_nomresi_sag beraberdirmi 0)\n" + 
				"    {\n" + 
				"        //ogul sag\n" + 
				"        IS(--hundurluk);\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"reqem Ata(reqem is_nomresi_sol_1, reqem is_nomresi_sag_2)\n" + 
				"{\n" + 
				"    Gozle();\n" + 
				"    herif Dosya_adi_1[20];\n" + 
				"    sprintf(Dosya_adi_1, \"%d.txt\", is_nomresi_sol_1);\n" + 
				"    herif Dosya_adi_2[20];\n" + 
				"    sprintf(Dosya_adi_2, \"%d.txt\", is_nomresi_sag_2);\n" + 
				"    herif Dosya_adi_3[20];\n" + 
				"    sprintf(Dosya_adi_3, \"%d.txt\", getpid());\n" + 
				"    FILE *dosya_sol_1, *dosya_sag_2, *dosya3;\n" + 
				"    dosya_sol_1 = fopen(Dosya_adi_1, \"r\");\n" + 
				"    dosya_sag_2 = fopen(Dosya_adi_2, \"r\");\n" + 
				"    reqem ogul_sol_1, ogul_sag_2;\n" + 
				"    fscanf(dosya_sol_1, \"%d\", &ogul_sol_1);\n" + 
				"    fscanf(dosya_sag_2, \"%d\", &ogul_sag_2);\n" + 
				"    fclose(dosya_sol_1);\n" + 
				"    fclose(dosya_sag_2);\n" + 
				"    dosya3 = fopen(Dosya_adi_3, \"w\");\n" + 
				"    fprintf(dosya3, \" %d \", ogul_sol_1 + ogul_sag_2);\n" + 
				"    fclose(dosya3);\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez Dosya()\n" + 
				"{\n" + 
				"    herif Dosya_adi[20];\n" + 
				"    sprintf(Dosya_adi, \"%d.txt\", getpid());\n" + 
				"    FILE *dosya = fopen(Dosya_adi, \"w\");\n" + 
				"    srand(getpid());\n" + 
				"    fprintf(dosya, \" %d \", (rand() % 100));\n" + 
				"    fclose(dosya);\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez Gozle()\n" + 
				"{\n" + 
				"    wait(NULL);\n" + 
				"}";
	}
	public static String SystemFayiliCWin() {
		
		return "#include <stdio.h>\n" + 
				"#include <math.h>\n" + 
				"#include <stdlib.h>\n" + 
				"#include <time.h>\n" + 
				"#include <sys\\\\types.h>\n" + 
				"#include <sys\\\\wait.h>\n" + 
				"#include <sys\\\\stat.h>\n" + 
				"#include <unistd.h>\n" + 
				"#include <dirent.h>\n" + 
				"#include <sys\\\\utsname.h>\n" + 
				"#include <string.h>\n" + 
				"\n" + 
				"#if defined(_WIN32) || defined(_WIN64)\n" + 
				"const char *os = \"Windoze\"; const char *sla = '\\\\';\n" + 
				"#include <direct.h>\n" + 
				"#define GetCurrentDir _getcwd\n" + 
				"#else\n" + 
				"#ifdef __linux\n" + 
				"const char *os = \"Linux\";const char *sla = \"/\";\n" + 
				"#include <unistd.h>\n" + 
				"#define GetCurrentDir getcwd\n" + 
				"#else\n" + 
				"const char *os = \"Unknown\";\n" + 
				"#endif\n" + 
				"#endif\n" + 
				"\n" + 
				"#include \"acos_technology.h\"\n" + 
				"\n" + 
				"#define yoxla if\n" + 
				"#define birde_yoxla else if\n" + 
				"#define netice_yoxdusa else\n" + 
				"#define geri_gonderilen return\n" + 
				"#define davamet continue\n" + 
				"#define kes break\n" + 
				"#define dongu while\n" + 
				"#define sayili_dongu for\n" + 
				"#define ek\n" + 
				"#define deyer_dondurmez void\n" + 
				"#define reqem int\n" + 
				"#define herif char\n" + 
				"\n" + 
				"#define BOS NULL\n" + 
				"\n" + 
				"#define ekrana_yazdir printf\n" + 
				"#define isdifadeciden_oxu scanf\n" + 
				"#define beraberdirmi ==\n" + 
				"#define balaca_beraberdir <=\n" + 
				"#define boyuk_beraberdir >=\n" + 
				"\n" + 
				"deyer_dondurmez acos_kitabxana_melumat(){\n" + 
				"    herif setir_bir[299] = \"\\n#define yoxla if \\n#define birde_yoxla else if \\n#define netice_yoxdusa else \\n#define geri_gonderilen return\";\n" + 
				"    herif setir_iki[299] = \"\\n#define davamet continue\\n#define kes break\\n#define dongu while\\n#define sayili_dongu for\\n#define ek\";\n" + 
				"    herif setir_uc[299] = \"\\n#define deyer_dondurmez void\\n#define reqem int\\n#define herif char\\n#define BOS NULL\\n#define ekrana_yazdir printf\";\n" + 
				"    herif setir_dort[299] = \"\\n#define isdifadeciden_oxu scanf\\n#define beraberdirmi ==\\n#define balaca_beraberdir <=\\n#define boyuk_beraberdir >=\";\n" + 
				"    herif setir_bes[299] = \"\";\n" + 
				"    ekrana_yazdir(\"%s\",setir_bir);\n" + 
				"    ekrana_yazdir(\"%s\",setir_iki);\n" + 
				"    ekrana_yazdir(\"%s\",setir_uc);\n" + 
				"    ekrana_yazdir(\"%s\",setir_dort);\n" + 
				"\n" + 
				"}\n" + 
				"\n" + 
				"//BURASI AC PROGRAMLAMA DILI UCUN AYRILMISDIR AC PROGRAMLMA DILININ SYSTEM FONKSIYONLARI SAXLANILIR\n" + 
				"//AC PROGRAMLAM DILI UCUN AYRILMIS YER BITTI\n" + 
				"\n" + 
				"//Emeliyat systeminin adini yazdirar\n" + 
				"deyer_dondurmez ac_emeliyat_systemi_adi(){\n" + 
				"    ekrana_yazdir(\"\\n %s Emeliyat Systemi.\\n\", os);\n" + 
				"\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez ac_fayilari_gosder(char * emeliyat ){\n" + 
				"    system(emeliyat);\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez ac_dosya_yolu(){\n" + 
				"    char buff[FILENAME_MAX];\n" + 
				"    GetCurrentDir( buff, FILENAME_MAX );\n" + 
				"    printf(\"Current working dir: %s\\n\", buff);\n" + 
				"}\n" + 
				"\n" + 
				"reqem acOxuyucuInt(){\n" + 
				"    system(\"java acOxuycuInt\");\n" + 
				"    reqem geri_dondurulen_int;\n" + 
				"    FILE *deyigen_fayili;\n" + 
				"    deyigen_fayili = fopen(\"Oturucu.ac\", \"r\");\n" + 
				"    fscanf(deyigen_fayili, \"%d\", &geri_dondurulen_int);\n" + 
				"    geri_gonderilen geri_dondurulen_int;\n" + 
				"}\n" + 
				"\n" + 
				"herif * acOxuyucuString(){\n" + 
				"    system(\"java acOxuycuString\");\n" + 
				"    char *geri_dondurulen_String = (char *) malloc(sizeof(char) * 3);\n" + 
				"    FILE *deyigen_fayili;\n" + 
				"    deyigen_fayili = fopen(\"Oturucu.ac\", \"r\");\n" + 
				"    fscanf(deyigen_fayili, \"%[^\\n]\", geri_dondurulen_String);\n" + 
				"    geri_gonderilen geri_dondurulen_String;\n" + 
				"}\n" + 
				"\n" + 
				"//AC PROGRAMLAMA DILININ SYSYTEM KITABXANA FONKSIYONLARI BITTI\n" + 
				"\n" + 
				"//Xeta bilgisi verer <<<ACOS OZEL FONKSIYON>>>\n" + 
				"deyer_dondurmez acos_xeta()\n" + 
				"{\n" + 
				"    herif ACOS_XETA[21] = \" <<< ACOS XETA >>>\\n\";\n" + 
				"    ekrana_yazdir(\"%s\", ACOS_XETA);\n" + 
				"}\n" + 
				"\n" + 
				"//acos Bildirisi verer <<<ACOS OZEL FONKSIYON>>>\n" + 
				"deyer_dondurmez acos_bildirs()\n" + 
				"{\n" + 
				"    herif ACOS_BILDIRIS[12] = \" <--- ACOS\\n\";\n" + 
				"    ekrana_yazdir(\"%s\", ACOS_BILDIRIS);\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez system_adi()\n" + 
				"{\n" + 
				"    ekrana_yazdir(\"%s\", os);\n" + 
				"}\n" + 
				"\n" + 
				"//acos technology terefinden yazilmis sifreleme fonksiyon\n" + 
				"deyer_dondurmez A21()\n" + 
				"{\n" + 
				"    herif deyer_gonder;\n" + 
				"    ekrana_yazdir(\"Mesaji daxil edin : \");\n" + 
				"    dongu('-' != deyer_gonder)\n" + 
				"    {\n" + 
				"        deyer_gonder = getchar();\n" + 
				"        ekrani_temizle();\n" + 
				"        sifrelemealgoritmasi(deyer_gonder);\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez sifrelemealgoritmasi(herif deyer_alan)\n" + 
				"{\n" + 
				"    yoxla(deyer_alan beraberdirmi 'a' || deyer_alan beraberdirmi 'A') { ekrana_yazdir(\"21\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'b' || deyer_alan beraberdirmi 'B') { ekrana_yazdir(\"22\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'c' || deyer_alan beraberdirmi 'C') { ekrana_yazdir(\"23\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'd' || deyer_alan beraberdirmi 'D') { ekrana_yazdir(\"31\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'e' || deyer_alan beraberdirmi 'E') { ekrana_yazdir(\"32\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'f' || deyer_alan beraberdirmi 'F') { ekrana_yazdir(\"33\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'g' || deyer_alan beraberdirmi 'G') { ekrana_yazdir(\"41\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'h' || deyer_alan beraberdirmi 'H') { ekrana_yazdir(\"42\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'i' || deyer_alan beraberdirmi 'I') { ekrana_yazdir(\"43\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'j' || deyer_alan beraberdirmi 'J') { ekrana_yazdir(\"51\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'k' || deyer_alan beraberdirmi 'K') { ekrana_yazdir(\"52\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'l' || deyer_alan beraberdirmi 'L') { ekrana_yazdir(\"53\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'm' || deyer_alan beraberdirmi 'M') { ekrana_yazdir(\"61\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'n' || deyer_alan beraberdirmi 'N') { ekrana_yazdir(\"62\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi '0' || deyer_alan beraberdirmi 'O') { ekrana_yazdir(\"63\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'q' || deyer_alan beraberdirmi 'Q') { ekrana_yazdir(\"71\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'p' || deyer_alan beraberdirmi 'P') { ekrana_yazdir(\"72\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'r' || deyer_alan beraberdirmi 'R') { ekrana_yazdir(\"73\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 's' || deyer_alan beraberdirmi 'D') { ekrana_yazdir(\"74\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 't' || deyer_alan beraberdirmi 'T') { ekrana_yazdir(\"81\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'u' || deyer_alan beraberdirmi 'U') { ekrana_yazdir(\"82\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'v' || deyer_alan beraberdirmi 'V') { ekrana_yazdir(\"83\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'w' || deyer_alan beraberdirmi 'W') { ekrana_yazdir(\"91\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'x' || deyer_alan beraberdirmi 'X') { ekrana_yazdir(\"92\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'y' || deyer_alan beraberdirmi 'Y') { ekrana_yazdir(\"93\"); }\n" + 
				"    yoxla(deyer_alan beraberdirmi 'z' || deyer_alan beraberdirmi 'Z') { ekrana_yazdir(\"94\"); }\n" + 
				"\n" + 
				"    yoxla(deyer_alan beraberdirmi ' ')\n" + 
				"    {\n" + 
				"        ekrana_yazdir(\" \");\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//ikilik taban da daxil olunan sayiyi onluq tabana cevirib ekrana yazar\n" + 
				"deyer_dondurmez ikiliktaban(reqem onluk)\n" + 
				"{\n" + 
				"    reqem Bilinmeyen;\n" + 
				"    yoxla(onluk balaca_beraberdir 255)\n" + 
				"    {\n" + 
				"        Bilinmeyen = 7;\n" + 
				"    }\n" + 
				"    birde_yoxla(onluk balaca_beraberdir 65535)\n" + 
				"    {\n" + 
				"        Bilinmeyen = 15;\n" + 
				"    }\n" + 
				"    birde_yoxla(onluk balaca_beraberdir 2147483647)\n" + 
				"    {\n" + 
				"        Bilinmeyen = 30;\n" + 
				"    }\n" + 
				"    ekrana_yazdir(\"\\nIkilik Sytsem : \");\n" + 
				"    reqem i = Bilinmeyen;\n" + 
				"    sayili_dongu(i; i boyuk_beraberdir 0; i--)\n" + 
				"    {\n" + 
				"        yoxla((onluk & 1 << i) != 0)\n" + 
				"        {\n" + 
				"            ekrana_yazdir(\"1\");\n" + 
				"        }\n" + 
				"        netice_yoxdusa\n" + 
				"        {\n" + 
				"            ekrana_yazdir(\"0\");\n" + 
				"        }\n" + 
				"    }\n" + 
				"    ekrana_yazdir(\" : \");\n" + 
				"}\n" + 
				"\n" + 
				"//onluk alib ikilik systeme ceviren fonksiyon\n" + 
				"deyer_dondurmez onluk_al()\n" + 
				"{\n" + 
				"    reqem oxu;\n" + 
				"    ekrana_yazdir(\"Onluk Systemde deyer daxil edin : \");\n" + 
				"    scanf(\"%d\", &oxu);\n" + 
				"    ikiliktaban(oxu);\n" + 
				"    ekrana_yazdir(\"\\nOnluk System Daxil Olunan Deyer : %d\\n\", oxu);\n" + 
				"}\n" + 
				"\n" + 
				"//herifi ikilik tabana ceviren ve ekrana yazan\n" + 
				"deyer_dondurmez herif_al()\n" + 
				"{\n" + 
				"    reqem alinacaq_herif;\n" + 
				"    dongu(alinacaq_herif boyuk_beraberdir - 1)\n" + 
				"    {\n" + 
				"        alinacaq_herif = getchar();\n" + 
				"        yoxla(alinacaq_herif beraberdirmi ' ')\n" + 
				"        {\n" + 
				"            ekrana_yazdir(\" \");\n" + 
				"            ekrana_yazdir(\"\\n\");\n" + 
				"            davamet;\n" + 
				"        }\n" + 
				"        yoxla(alinacaq_herif beraberdirmi '-' || alinacaq_herif beraberdirmi ' ')\n" + 
				"        {\n" + 
				"            kes;\n" + 
				"        }\n" + 
				"        ikiliktaban(alinacaq_herif);\n" + 
				"        ekrana_yazdir(\" : %c \", putchar(alinacaq_herif));\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//bir cumlenin \"-\" isaretine qeder olan herif ve sozleri tek tek ikilik taban cevirir\n" + 
				"deyer_dondurmez setir_sonu()\n" + 
				"{\n" + 
				"    reqem alinacaq_herif;\n" + 
				"    dongu(alinacaq_herif boyuk_beraberdir - 1)\n" + 
				"    {\n" + 
				"        alinacaq_herif = getchar();\n" + 
				"        yoxla(alinacaq_herif beraberdirmi ' ')\n" + 
				"        {\n" + 
				"            ekrana_yazdir(\" \");\n" + 
				"            davamet;\n" + 
				"        }\n" + 
				"        yoxla(alinacaq_herif beraberdirmi '-')\n" + 
				"        {\n" + 
				"            kes;\n" + 
				"        }\n" + 
				"        reqem onluk = alinacaq_herif;\n" + 
				"        reqem i = 0;\n" + 
				"        sayili_dongu(i = 8; i boyuk_beraberdir 0; i--)\n" + 
				"        {\n" + 
				"            yoxla((onluk & (1 << i)) != 0)\n" + 
				"            {\n" + 
				"                ekrana_yazdir(\"1\");\n" + 
				"            }\n" + 
				"            netice_yoxdusa\n" + 
				"            {\n" + 
				"                ekrana_yazdir(\"0\");\n" + 
				"            }\n" + 
				"        }\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//rasgele onluk sayi secib ikilik tabana ceviren avto bit cevirici\n" + 
				"deyer_dondurmez rasgele()\n" + 
				"{\n" + 
				"    srand(time(BOS));\n" + 
				"    reqem i, n, bilinmeyen_sayi;\n" + 
				"    n = 1;\n" + 
				"    sayili_dongu(i = 0; i < n; i++)\n" + 
				"    {\n" + 
				"        bilinmeyen_sayi = rand() % 1000;\n" + 
				"        ikiliktaban(bilinmeyen_sayi);\n" + 
				"        ekrana_yazdir(\"\\nOnluk System : %d\\n\\n\", bilinmeyen_sayi);\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//Terminal ekranini temizlemek ucun.\n" + 
				"deyer_dondurmez ekrani_temizle()\n" + 
				"{\n" + 
				"    yoxla(os beraberdirmi \"Windwos\")\n" + 
				"    {\n" + 
				"        system(\"cls\");\n" + 
				"    }\n" + 
				"    birde_yoxla(os beraberdirmi \"Linux\")\n" + 
				"    {\n" + 
				"        system(\"clear\");\n" + 
				"    }\n" + 
				"    netice_yoxdusa\n" + 
				"    {\n" + 
				"        system(\"clear\");\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//mod almaq ucun yazilmis fonksiyon\n" + 
				"deyer_dondurmez mod_al(reqem x, reqem y)\n" + 
				"{\n" + 
				"    ekrana_yazdir(\"\\n%d\\n\", x % y);\n" + 
				"}\n" + 
				"\n" + 
				"//kendinden onceki sayiyla toplanib yeni sayi ureten fibonacc serisi\n" + 
				"deyer_dondurmez fibonacci(reqem x)\n" + 
				"{\n" + 
				"    yoxla(x < 20)\n" + 
				"    {\n" + 
				"        reqem a = 0, b = 1, c = 0;\n" + 
				"        ekrana_yazdir(\"%d %d\", a, b);\n" + 
				"        sayili_dongu(reqem y = 1; y balaca_beraberdir x; y++)\n" + 
				"        {\n" + 
				"            c = a + b;\n" + 
				"            ekrana_yazdir(\" %d\", c);\n" + 
				"            a = b;\n" + 
				"            b = c;\n" + 
				"        }\n" + 
				"    }\n" + 
				"    netice_yoxdusa\n" + 
				"    {\n" + 
				"        ekrana_yazdir(\"20 : Deyerinden az bir deyer daxil edin...\");\n" + 
				"        acos_xeta();\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//Hanoi 0.2\n" + 
				"deyer_dondurmez hanoi(reqem disk, herif cubug1, herif cubug2, herif cubug3)\n" + 
				"{\n" + 
				"    yoxla(disk beraberdirmi 1)\n" + 
				"    {\n" + 
				"        ekrana_yazdir(\"Disk cubug %c den cubug %c e tasindi. \", cubug1, cubug3);\n" + 
				"        acos_bildirs();\n" + 
				"    }\n" + 
				"    netice_yoxdusa\n" + 
				"    {\n" + 
				"        hanoi(disk - 1, cubug1, cubug3, cubug2);\n" + 
				"        hanoi(1, cubug1, cubug2, cubug3);\n" + 
				"        hanoi(disk - 1, cubug2, cubug1, cubug3);\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"//Hanoi 0.2 baslatmaq ucun yazilmali olan fonksiyon\n" + 
				"deyer_dondurmez hanoi_baslat()\n" + 
				"{\n" + 
				"    reqem disk;\n" + 
				"    ekrana_yazdir(\"Zehmet olmasa disk sayisini daxil edin : \");\n" + 
				"    scanf(\"%d\", &disk);\n" + 
				"    hanoi(disk, '1', '2', '3');\n" + 
				"}\n" + 
				"\n" + 
				"//Azdan coxa dogru siralar\n" + 
				"deyer_dondurmez qabarciq_siralama(reqem HECIM)\n" + 
				"{\n" + 
				"    reqem deyer[HECIM], daxil_olunan_deyer;\n" + 
				"\n" + 
				"    sayili_dongu(reqem dongu_sayi = 0; dongu_sayi < HECIM; dongu_sayi++)\n" + 
				"    {\n" + 
				"        ekrana_yazdir(\"\\nQabarciq siralamaya daxil olunancaq %d deyeri daxil edin : \", HECIM);\n" + 
				"        scanf(\"%d\", &daxil_olunan_deyer);\n" + 
				"        deyer[dongu_sayi] = daxil_olunan_deyer;\n" + 
				"    }\n" + 
				"\n" + 
				"    reqem sayac, tur, tutar;\n" + 
				"\n" + 
				"    ekrana_yazdir(\"Daxil olunan deyerler...\\n\");\n" + 
				"    sayili_dongu(sayac = 0; sayac balaca_beraberdir HECIM - 1; sayac++)\n" + 
				"    {\n" + 
				"        ekrana_yazdir(\"%4d\", deyer[sayac]);\n" + 
				"    }\n" + 
				"\n" + 
				"    sayili_dongu(tur = 1; tur balaca_beraberdir HECIM - 1; tur++)\n" + 
				"\n" + 
				"        sayili_dongu(sayac = 0; sayac balaca_beraberdir HECIM - 2; sayac++)\n" + 
				"            yoxla(deyer[sayac] > deyer[sayac + 1])\n" + 
				"    {\n" + 
				"        tutar = deyer[sayac];\n" + 
				"        deyer[sayac] = deyer[sayac + 1];\n" + 
				"        deyer[sayac + 1] = tutar;\n" + 
				"    }\n" + 
				"\n" + 
				"    ekrana_yazdir(\"\\n\\nAzdan coxa dogru siralanmis deyerler...\\n\");\n" + 
				"    sayili_dongu(sayac = 0; sayac balaca_beraberdir HECIM - 1; sayac++)\n" + 
				"        ekrana_yazdir(\"%4d\", deyer[sayac]);\n" + 
				"\n" + 
				"    acos_bildirs();\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez IS(reqem hundurluk)\n" + 
				"{\n" + 
				"    yoxla(hundurluk beraberdirmi 0)\n" + 
				"    {\n" + 
				"        Dosya();\n" + 
				"        return;\n" + 
				"    }\n" + 
				"    reqem is_nomresi_sag = fork();\n" + 
				"    yoxla(is_nomresi_sag > 0)\n" + 
				"    {\n" + 
				"        //Ata\n" + 
				"        reqem is_nomresi_sol_2 = fork();\n" + 
				"        yoxla(is_nomresi_sol_2 > 0)\n" + 
				"        {\n" + 
				"            //Ata\n" + 
				"            Gozle();\n" + 
				"            ekrana_yazdir(\"Ata Is_nomresi: %d ogul is_nomresi: %d ogul_is_nomresi_2: %d\\n\", getpid(), is_nomresi_sag, is_nomresi_sol_2);\n" + 
				"            fflush(stdout); // Ekran cikti garantisi alinmasi icin\n" + 
				"            Ata(is_nomresi_sag, is_nomresi_sol_2);\n" + 
				"        }\n" + 
				"        birde_yoxla(is_nomresi_sol_2 beraberdirmi 0)\n" + 
				"        {\n" + 
				"            //ogul sol\n" + 
				"            IS(--hundurluk);\n" + 
				"        }\n" + 
				"    }\n" + 
				"    birde_yoxla(is_nomresi_sag beraberdirmi 0)\n" + 
				"    {\n" + 
				"        //ogul sag\n" + 
				"        IS(--hundurluk);\n" + 
				"    }\n" + 
				"}\n" + 
				"\n" + 
				"reqem Ata(reqem is_nomresi_sol_1, reqem is_nomresi_sag_2)\n" + 
				"{\n" + 
				"    Gozle();\n" + 
				"    herif Dosya_adi_1[20];\n" + 
				"    sprintf(Dosya_adi_1, \"%d.txt\", is_nomresi_sol_1);\n" + 
				"    herif Dosya_adi_2[20];\n" + 
				"    sprintf(Dosya_adi_2, \"%d.txt\", is_nomresi_sag_2);\n" + 
				"    herif Dosya_adi_3[20];\n" + 
				"    sprintf(Dosya_adi_3, \"%d.txt\", getpid());\n" + 
				"    FILE *dosya_sol_1, *dosya_sag_2, *dosya3;\n" + 
				"    dosya_sol_1 = fopen(Dosya_adi_1, \"r\");\n" + 
				"    dosya_sag_2 = fopen(Dosya_adi_2, \"r\");\n" + 
				"    reqem ogul_sol_1, ogul_sag_2;\n" + 
				"    fscanf(dosya_sol_1, \"%d\", &ogul_sol_1);\n" + 
				"    fscanf(dosya_sag_2, \"%d\", &ogul_sag_2);\n" + 
				"    fclose(dosya_sol_1);\n" + 
				"    fclose(dosya_sag_2);\n" + 
				"    dosya3 = fopen(Dosya_adi_3, \"w\");\n" + 
				"    fprintf(dosya3, \" %d \", ogul_sol_1 + ogul_sag_2);\n" + 
				"    fclose(dosya3);\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez Dosya()\n" + 
				"{\n" + 
				"    herif Dosya_adi[20];\n" + 
				"    sprintf(Dosya_adi, \"%d.txt\", getpid());\n" + 
				"    FILE *dosya = fopen(Dosya_adi, \"w\");\n" + 
				"    srand(getpid());\n" + 
				"    fprintf(dosya, \" %d \", (rand() % 100));\n" + 
				"    fclose(dosya);\n" + 
				"}\n" + 
				"\n" + 
				"deyer_dondurmez Gozle()\n" + 
				"{\n" + 
				"    wait(NULL);\n" + 
				"}";
	}
	public static String SystemFayiliCHeader() {
		return "#ifndef acos_technology\n" + 
				"#define acos_technology\n" + 
				"\n" + 
				"#define baslangic           main\n" + 
				"\n" + 
				"#define yoxla               if\n" + 
				"#define birde_yoxla         else if\n" + 
				"#define netice_yoxdusa      else\n" + 
				"\n" + 
				"#define davamet             continue\n" + 
				"#define kes                 break\n" + 
				"\n" + 
				"#define dongu               while \n" + 
				"#define sayili_dongu        for\n" + 
				"\n" + 
				"#define ekrana_yazdir       printf\n" + 
				"#define isdifadeciden_oxu   scanf\n" + 
				"#define ek\n" + 
				"#define deyer_dondurmez     void\n" + 
				"#define reqem               int\n" + 
				"#define herif               char\n" + 
				"\n" + 
				"#define BOS                 NULL\n" + 
				"\n" + 
				"#define beraberdirmi        ==\n" + 
				"#define balaca_beraberdir   <=\n" + 
				"#define boyuk_beraberdir    >=\n" + 
				"\n" + 
				"deyer_dondurmez acos_kitabxana_melumat();\n" + 
				"\n" + 
				"deyer_dondurmez ikiliktaban(reqem onluk);                                            //Ikilik System \n" + 
				"deyer_dondurmez mod_al(reqem x, reqem y);                                            //mod almaq ucun yazilmis fonksyion\n" + 
				"deyer_dondurmez fibonacci(reqem x);                                                  //fibonacci serisi yaratan fonksiyon  \n" + 
				"deyer_dondurmez hanoi(reqem disk,herif cubug1,herif cubug2,herif cubug3);            //Hanoi Oyunu 0.2\n" + 
				"deyer_dondurmez qabarciq_siralama(reqem HECIM);                                      //Qabarci siralama fonksyonu\n" + 
				"deyer_dondurmez sifrelemealgoritmasi(herif deyer_alan);                              //Sifreleme fonksiyonu\n" + 
				"deyer_dondurmez IS( reqem hundurluk );                                               //\n" + 
				"reqem Ata( reqem is_nomresi_sol_1, reqem is_nomresi_sag_2 );                         //\n" + 
				"\n" + 
				"deyer_dondurmez Dosya();                                                             //\n" + 
				"deyer_dondurmez Gozle();                                                             //\n" + 
				"deyer_dondurmez A21();                                                               //Sifreleme fonksiyonuna deyer gondererek mesaji sifreleyen fonksiyon\n" + 
				"deyer_dondurmez herif_al();                                                          //Herifi Isdifadeciden alar ve Ikilik Systeme cevirer\n" + 
				"deyer_dondurmez setir_sonu();                                                        //Bir Cumlenin  -  isaretine qeder olan herif ve solzeri tek tek ikilik systeme cevirer\n" + 
				"deyer_dondurmez rasgele();                                                           //Rasgele bit cevirici \n" + 
				"deyer_dondurmez ekrani_temizle();                                                    //Terminal ekranini temizleyen fonksiyon\n" + 
				"deyer_dondurmez onluk_al();                                                          //Isdifadeciden onluk systemde reqem alaraq onu ikilik systeme ceviren fonksiyon\n" + 
				"deyer_dondurmez hanoi_baslat();                                                      //Hanoi oyununu baslatmaq ucun yazilmis fonksiyon\n" + 
				"\n" + 
				"//BURASI AC PROGRAMLAMA DILI UCUN AYRILMISDIR AC PROGRAMLMA DILININ SYSTEM FONKSIYONLARININ PROTOTIPI SAXLANILIR\n" + 
				"deyer_dondurmez ac_emeliyat_systemi_adi();\n" + 
				"deyer_dondurmez ac_fayilari_gosder(char * emeliyat );\n" + 
				"deyer_dondurmez ac_dosya_yolu();\n" + 
				"reqem acOxuyucuInt();\n" + 
				"herif * acOxuyucuString();\n" + 
				"//AC PROGRAMLAM DILI UCUN AYRILMIS YER BITTI\n" + 
				"\n" + 
				"#endif";
	}
	//C UCUN YAZILMIS JAVA API CODLARI
	public static String SystemFayilariJavaCOxuyucuIntAPI() {
		return "import java.io.*;\n" + 
				"import javax.swing.JOptionPane;\n" + 
				"\n" + 
				"class acOxuycuInt{\n" + 
				"	public static void main(String args[]) {\n" + 
				"	OxuyucuInt(\"int\");\n" + 
				"}\n" + 
				"	public static int OxuyucuInt(String Oxuyucu_adi) {\n" + 
				"		int Gonderilecek_deyer;\n" + 
				"		try { \n" + 
				"			Gonderilecek_deyer = Integer.parseInt(JOptionPane.showInputDialog(null, \"Deyer Daxil Edin.\", Oxuyucu_adi, JOptionPane.INFORMATION_MESSAGE)); \n" + 
				"		} catch(Exception e) { \n" + 
				"			Gonderilecek_deyer = 0; \n" + 
				"			System.out.println(\"\\nDaxil Ediyiniz Deyer Reqem Olmalidir <<< acGiris OxuyucuInt XETA\"); \n" + 
				"		}\n" + 
				"		try{\n" + 
				"			String a = Integer.toString(Gonderilecek_deyer); \n" + 
				"		File fayil = new File(\"Oturucu.ac\");\n" + 
				"		FileWriter yazici = new FileWriter(fayil);\n" + 
				"		BufferedWriter ol = new BufferedWriter(yazici);\n" + 
				"		ol.write(a);\n" + 
				"		\n" + 
				"		ol.close();\n" + 
				"\n" + 
				"		}catch(Exception e ){\n" + 
				"\n" + 
				"		}\n" + 
				"		return Gonderilecek_deyer;\n" + 
				"	}\n" + 
				"}";
	}
	public static String SystemFayilariJavaCOxuycuStriungAPI() {
		return "import java.io.*;\n" + 
				"import javax.swing.JOptionPane;\n" + 
				"\n" + 
				"class acOxuycuString{\n" + 
				"	public static void main(String args[]) {\n" + 
				"		OxuyucuString(\"String\");\n" + 
				"	}\n" + 
				"	public static String OxuyucuString(String Oxuyucu_adi) {\n" + 
				"		String Gonderilecek_deyer;\n" + 
				"		try { \n" + 
				"			Gonderilecek_deyer = JOptionPane.showInputDialog(null, \"Deyer Daxil Edin.\", Oxuyucu_adi, JOptionPane.INFORMATION_MESSAGE); \n" + 
				"		} catch(Exception e) { \n" + 
				"			Gonderilecek_deyer = \"0\"; \n" + 
				"			System.out.println(\"\\nDaxil Ediyiniz Deyer Reqem Olmalidir <<< acGiris OxuyucuInt XETA\"); \n" + 
				"		}\n" + 
				"		try{\n" + 
				"		File fayil = new File(\"Oturucu.ac\");\n" + 
				"		FileWriter yazici = new FileWriter(fayil);\n" + 
				"		BufferedWriter ol = new BufferedWriter(yazici);\n" + 
				"		ol.write(Gonderilecek_deyer);\n" + 
				"		\n" + 
				"		ol.close();\n" + 
				"\n" + 
				"		}catch(Exception e ){\n" + 
				"\n" + 
				"		}\n" + 
				"		return Gonderilecek_deyer;\n" + 
				"	}\n" + 
				"}";
	}
	
}
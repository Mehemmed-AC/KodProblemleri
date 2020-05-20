package ac;

import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.*; 

import ac.acElaveler;

public class acGiris extends acElaveler{
public static String st = "";


private static String  OS = System.getProperty("os.name").toLowerCase();
public static String S_Dosya_Yolu;
	public static boolean isWindows()	{return (OS.indexOf("win") >= 0);}
	public static boolean isMac()		{return (OS.indexOf("mac") >= 0);}
	public static boolean isUnix()		{return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );}
	public static boolean isSolaris()	{return (OS.indexOf("sunos") >= 0);}
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
			S_Dosya_Yolu = toplanan_netice;
		} else { toplanan_netice = Dosya_Yolunu_Saxlayan; S_Dosya_Yolu = toplanan_netice; }
		return toplanan_netice;
  }	
    public static String ustglobalalici(String deyisgen){
 	
	  String Dosya_Yolu = S_Dosya_Yolu;
     
       try{
            File file = new File(deyisgen+".de"); 
            BufferedReader reader = new BufferedReader(new FileReader(file));
            st = reader.readLine();
            reader.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(st);
        return st;
    }
    public static void ustglobalelavedici(String deyisgen,String operation, String Elave_olunan_deyer){
        int islenen_deyer = 0;
         String str;
        String Dosya_Yolu = S_Dosya_Yolu;
        int alinan_deyer = Integer.parseInt(ustglobalalici(deyisgen));
        if(operation.equals("+")){
            islenen_deyer = alinan_deyer + Integer.parseInt(Elave_olunan_deyer);
        } else if(operation.equals("-")){
            islenen_deyer = alinan_deyer - Integer.parseInt(Elave_olunan_deyer);
        } else if(operation.equals("*")){
            islenen_deyer = alinan_deyer * Integer.parseInt(Elave_olunan_deyer);
        } else if(operation.equals("/")){
            islenen_deyer = alinan_deyer / Integer.parseInt(Elave_olunan_deyer);
        } else {
            islenen_deyer = Integer.parseInt(Elave_olunan_deyer);

        }
        File file = new File(deyisgen+".de");
        try {
            str = Integer.toString(islenen_deyer);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(str);
     
            writer.close();
        } catch (Exception e) {
        }
    }
    public static void ustglobalelavedici(String deyisgen, String Elave_olunan_deyer){
        String operation = "n";
        int islenen_deyer;
         String str;
        String Dosya_Yolu = S_Dosya_Yolu;
        int alinan_deyer = Integer.parseInt(ustglobalalici(deyisgen));
        if(operation.equals("+")){
            islenen_deyer = alinan_deyer + Integer.parseInt(Elave_olunan_deyer);
        } else if(operation.equals("-")){
            islenen_deyer = alinan_deyer - Integer.parseInt(Elave_olunan_deyer);
        } else if(operation.equals("*")){
            islenen_deyer = alinan_deyer * Integer.parseInt(Elave_olunan_deyer);
        } else if(operation.equals("/")){
            islenen_deyer = alinan_deyer / Integer.parseInt(Elave_olunan_deyer);
        } else {
            islenen_deyer = Integer.parseInt(Elave_olunan_deyer);

        }
        File file = new File(Dosya_Yolu+deyisgen+".de");
        try {
            str = Integer.toString(islenen_deyer);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(str);
     
            writer.close();
        } catch (Exception e) {
        }
}
public static int OxuyucuInt(String Oxuyucu_adi) {
		int Gonderilecek_deyer;
		try {  Gonderilecek_deyer = Integer.parseInt(JOptionPane.showInputDialog(null, "Deye Daxil Edin", Oxuyucu_adi, JOptionPane.INFORMATION_MESSAGE)); 
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

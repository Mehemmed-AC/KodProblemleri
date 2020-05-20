package ac;

import java.io.*; 
import java.util.Scanner;

public class acElaveler {
	//Tanimlanan Object Deyisgenleri
	private static Scanner isdifadeciden_Oxucu;

	//Ekrana Yazdirmaq Ucun Yazilmis Methotlar
	public static void Yazdir(int deyer){ System.out.printf(""+deyer); }
    public static void Yazdir(char deyer){ System.out.printf(""+deyer); }
    public static void Yazdir(String deyer){ System.out.printf(""+deyer); }

    //Isdifadeciden Oxuyan Methotlar
	public static String Isdifadeciden_Oxu() { isdifadeciden_Oxucu = new Scanner(System.in); String Gonderilen_String = isdifadeciden_Oxucu.nextLine(); return Gonderilen_String; }

	//Bu Method Bir Steir Icerisinden Isdenilen Karakteri Axtararaq O'nun Indexini Geri Gonderir
	static int MetinAxtarici(String Metin, String Axtarilacaq_Deyer){ return Metin.lastIndexOf(Axtarilacaq_Deyer); }
	static int MetinAxtarici(String Metin, char Axtarilacaq_Deyer){ return Metin.indexOf(Axtarilacaq_Deyer); }


}

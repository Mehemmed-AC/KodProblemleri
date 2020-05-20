#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include <sys/types.h> 
#include <sys/wait.h> 
#include <unistd.h>

#if defined(_WIN32) || defined(_WIN64)
        const char* os = "Windoze";
#else
#ifdef __linux
        const char* os = "Linux";
#else
        const char* os = "Unknown";
#endif
#endif

#include "acos_technology.h"

#define yoxla               if
#define birde_yoxla         else if
#define netice_yoxdusa      else

#define davamet             continue
#define kes                 break

#define dongu               while 
#define sayili_dongu        for

#define ekrana_yazdir       printf
#define isdifadeciden_oxu   scanf
#define ek
#define deyer_dondurmez     void
#define reqem               int
#define herif               char

#define BOS                 NULL

#define beraberdirmi        ==
#define balaca_beraberdir   <=
#define boyuk_beraberdir    >=

//Xeta bilgisi verer <<<ACOS OZEL FONKSIYON>>>
deyer_dondurmez acos_xeta(){
    herif ACOS_XETA[21] = " <<< ACOS XETA >>>\n" ;
    ekrana_yazdir("%s",ACOS_XETA);
}

//acos Bildirisi verer <<<ACOS OZEL FONKSIYON>>>
deyer_dondurmez acos_bildirs(){
    herif ACOS_BILDIRIS[12] = " <--- ACOS\n";
    ekrana_yazdir("%s",ACOS_BILDIRIS);
}

deyer_dondurmez system_adi(){
    ekrana_yazdir("%s",os);
}

//acos technology terefinden yazilmis sifreleme fonksiyon
deyer_dondurmez A21(){
    herif deyer_gonder;
	ekrana_yazdir("Mesaji daxil edin : ");
	dongu('-' != deyer_gonder){
    deyer_gonder = getchar();
	ekrani_temizle();
    sifrelemealgoritmasi(deyer_gonder);	
    }
}

deyer_dondurmez sifrelemealgoritmasi(herif deyer_alan){
    yoxla(deyer_alan beraberdirmi 'a' || deyer_alan beraberdirmi 'A'){ ekrana_yazdir("21"); }
    yoxla(deyer_alan beraberdirmi 'b' || deyer_alan beraberdirmi 'B'){ ekrana_yazdir("22"); }
    yoxla(deyer_alan beraberdirmi 'c' || deyer_alan beraberdirmi 'C'){ ekrana_yazdir("23"); }
    yoxla(deyer_alan beraberdirmi 'd' || deyer_alan beraberdirmi 'D'){ ekrana_yazdir("31"); }
    yoxla(deyer_alan beraberdirmi 'e' || deyer_alan beraberdirmi 'E'){ ekrana_yazdir("32"); }
    yoxla(deyer_alan beraberdirmi 'f' || deyer_alan beraberdirmi 'F'){ ekrana_yazdir("33"); }
    yoxla(deyer_alan beraberdirmi 'g' || deyer_alan beraberdirmi 'G'){ ekrana_yazdir("41"); }
    yoxla(deyer_alan beraberdirmi 'h' || deyer_alan beraberdirmi 'H'){ ekrana_yazdir("42"); }
    yoxla(deyer_alan beraberdirmi 'i' || deyer_alan beraberdirmi 'I'){ ekrana_yazdir("43"); }
    yoxla(deyer_alan beraberdirmi 'j' || deyer_alan beraberdirmi 'J'){ ekrana_yazdir("51"); }
    yoxla(deyer_alan beraberdirmi 'k' || deyer_alan beraberdirmi 'K'){ ekrana_yazdir("52"); }
    yoxla(deyer_alan beraberdirmi 'l' || deyer_alan beraberdirmi 'L'){ ekrana_yazdir("53"); }
    yoxla(deyer_alan beraberdirmi 'm' || deyer_alan beraberdirmi 'M'){ ekrana_yazdir("61"); }
    yoxla(deyer_alan beraberdirmi 'n' || deyer_alan beraberdirmi 'N'){ ekrana_yazdir("62"); }
    yoxla(deyer_alan beraberdirmi '0' || deyer_alan beraberdirmi 'O'){ ekrana_yazdir("63"); }
    yoxla(deyer_alan beraberdirmi 'q' || deyer_alan beraberdirmi 'Q'){ ekrana_yazdir("71"); }
    yoxla(deyer_alan beraberdirmi 'p' || deyer_alan beraberdirmi 'P'){ ekrana_yazdir("72"); }
    yoxla(deyer_alan beraberdirmi 'r' || deyer_alan beraberdirmi 'R'){ ekrana_yazdir("73"); }
    yoxla(deyer_alan beraberdirmi 's' || deyer_alan beraberdirmi 'D'){ ekrana_yazdir("74"); }
    yoxla(deyer_alan beraberdirmi 't' || deyer_alan beraberdirmi 'T'){ ekrana_yazdir("81"); }
    yoxla(deyer_alan beraberdirmi 'u' || deyer_alan beraberdirmi 'U'){ ekrana_yazdir("82"); }
    yoxla(deyer_alan beraberdirmi 'v' || deyer_alan beraberdirmi 'V'){ ekrana_yazdir("83"); }
    yoxla(deyer_alan beraberdirmi 'w' || deyer_alan beraberdirmi 'W'){ ekrana_yazdir("91"); }
    yoxla(deyer_alan beraberdirmi 'x' || deyer_alan beraberdirmi 'X'){ ekrana_yazdir("92"); }
    yoxla(deyer_alan beraberdirmi 'y' || deyer_alan beraberdirmi 'Y'){ ekrana_yazdir("93"); }
    yoxla(deyer_alan beraberdirmi 'z' || deyer_alan beraberdirmi 'Z'){ ekrana_yazdir("94"); }

    yoxla(deyer_alan beraberdirmi ' '){
        ekrana_yazdir(" ");
    }
}

//ikilik taban da daxil olunan sayiyi onluq tabana cevirib ekrana yazar
deyer_dondurmez ikiliktaban(reqem onluk){
    reqem Bilinmeyen;
    yoxla(onluk balaca_beraberdir 255){
        Bilinmeyen = 7;
    }
    birde_yoxla(onluk balaca_beraberdir 65535){
        Bilinmeyen = 15;
    }
    birde_yoxla(onluk balaca_beraberdir 2147483647){
        Bilinmeyen = 30;
    }
    ekrana_yazdir("\nIkilik Sytsem : ");
    reqem i=Bilinmeyen;
    sayili_dongu(i;i boyuk_beraberdir 0;i--){
        yoxla((onluk & 1<<i) != 0){
                ekrana_yazdir("1");
        }netice_yoxdusa{
            ekrana_yazdir("0");
        }
    }
    ekrana_yazdir(" : ");
}

//onluk alib ikilik systeme ceviren fonksiyon
deyer_dondurmez onluk_al(){
	reqem oxu;
    ekrana_yazdir("Onluk Systemde deyer daxil edin : ");
	scanf("%d",&oxu);
	ikiliktaban(oxu);
	ekrana_yazdir("\nOnluk System Daxil Olunan Deyer : %d\n",oxu);
}

//herifi ikilik tabana ceviren ve ekrana yazan
deyer_dondurmez herif_al(){
	reqem alinacaq_herif;
	dongu(alinacaq_herif boyuk_beraberdir -1)
	{
		alinacaq_herif = getchar();
		yoxla(alinacaq_herif beraberdirmi ' ')
		{
			ekrana_yazdir(" ");
			ekrana_yazdir("\n");
			davamet;
		}
		yoxla(alinacaq_herif beraberdirmi '-' || alinacaq_herif beraberdirmi ' ')
		{
			kes;
		}
		ikiliktaban(alinacaq_herif);
        ekrana_yazdir(" : %c ", putchar(alinacaq_herif));
	}
}

//bir cumlenin "-" isaretine qeder olan herif ve sozleri tek tek ikilik taban cevirir
deyer_dondurmez setir_sonu(){
	reqem alinacaq_herif;
	dongu(alinacaq_herif boyuk_beraberdir -1)
	{
		alinacaq_herif = getchar();
		yoxla(alinacaq_herif beraberdirmi ' ')
		{
			ekrana_yazdir(" ");
			davamet;
		}
		yoxla(alinacaq_herif beraberdirmi '-')
		{
			kes;
		}
		reqem onluk = alinacaq_herif;
		reqem i = 0;
		sayili_dongu(i = 8; i boyuk_beraberdir 0; i--){
			yoxla((onluk & (1 << i)) != 0){
				ekrana_yazdir("1");
			}
			netice_yoxdusa{
				ekrana_yazdir("0");
			}
		}
	}
}

//rasgele onluk sayi secib ikilik tabana ceviren avto bit cevirici
deyer_dondurmez rasgele(){
    srand(time(BOS));
    reqem i, n, bilinmeyen_sayi;
    n = 1;
    sayili_dongu( i = 0 ; i < n ; i++ ) {
        bilinmeyen_sayi = rand() % 1000;
        ikiliktaban(bilinmeyen_sayi);
        ekrana_yazdir("\nOnluk System : %d\n\n",bilinmeyen_sayi);
    }
}

//Terminal ekranini temizlemek ucun.
deyer_dondurmez ekrani_temizle(){
    yoxla(os beraberdirmi "Windwos"){
        system("cls");
    } birde_yoxla(os beraberdirmi "Linux"){
        system("clear");
    } netice_yoxdusa{
        system("clear");
    }
}

//mod almaq ucun yazilmis fonksiyon
deyer_dondurmez mod_al(reqem x, reqem y){
	ekrana_yazdir("\n%d\n",x%y);
}

//kendinden onceki sayiyla toplanib yeni sayi ureten fibonacc serisi
deyer_dondurmez fibonacci(reqem x){
    yoxla(x < 20){
	    reqem a = 0, b = 1, c = 0;
	    ekrana_yazdir("%d %d",a,b);
	    sayili_dongu(reqem y = 1; y balaca_beraberdir x; y++){
		    c = a + b;
		    ekrana_yazdir(" %d",c);
		    a=b;
		    b=c;
	    }
    } netice_yoxdusa{
        ekrana_yazdir("20 : Deyerinden az bir deyer daxil edin..."); acos_xeta();
    }
}

//Hanoi 0.2
deyer_dondurmez hanoi(reqem disk,herif cubug1,herif cubug2,herif cubug3){
	yoxla(disk beraberdirmi 1){
		ekrana_yazdir("Disk cubug %c den cubug %c e tasindi. ",cubug1,cubug3); acos_bildirs();
	}
	netice_yoxdusa{
		hanoi(disk-1,cubug1,cubug3,cubug2);
		hanoi(1,cubug1,cubug2,cubug3);
		hanoi(disk-1,cubug2,cubug1,cubug3);
	}
}

//Hanoi 0.2 baslatmaq ucun yazilmali olan fonksiyon
deyer_dondurmez hanoi_baslat(){
	reqem disk;
	ekrana_yazdir("Zehmet olmasa disk sayisini daxil edin : ");
	scanf("%d",&disk);
	hanoi(disk,'1','2','3');
}

//Azdan coxa dogru siralar
deyer_dondurmez qabarciq_siralama(reqem HECIM){
    reqem deyer[HECIM], daxil_olunan_deyer;
   
    sayili_dongu(reqem dongu_sayi = 0; dongu_sayi < HECIM; dongu_sayi++){
        ekrana_yazdir("\nQabarciq siralamaya daxil olunancaq %d deyeri daxil edin : ",HECIM);
        scanf("%d",&daxil_olunan_deyer);
        deyer[dongu_sayi] = daxil_olunan_deyer;
    }
	
    reqem sayac, tur, tutar;

	ekrana_yazdir("Daxil olunan deyerler...\n");
	sayili_dongu(sayac = 0;sayac balaca_beraberdir HECIM-1;sayac++){
		ekrana_yazdir("%4d",deyer[sayac]);
	}

	sayili_dongu(tur = 1; tur balaca_beraberdir HECIM-1;tur++)
	
	sayili_dongu(sayac = 0;sayac balaca_beraberdir HECIM-2;sayac++)
		yoxla(deyer[sayac] > deyer[sayac+1]){
			tutar = deyer[sayac];
			deyer[sayac] = deyer[sayac + 1];
			deyer[sayac + 1] = tutar;
		}
	
	ekrana_yazdir("\n\nAzdan coxa dogru siralanmis deyerler...\n");
	sayili_dongu(sayac = 0;sayac balaca_beraberdir HECIM-1;sayac++)
		ekrana_yazdir("%4d",deyer[sayac]);

	acos_bildirs();
}

deyer_dondurmez IS( reqem hundurluk ){
    yoxla( hundurluk beraberdirmi 0 ) { Dosya(); return; }
    reqem is_nomresi_sag = fork();
    yoxla( is_nomresi_sag > 0 ){
    //Ata
        reqem is_nomresi_sol_2 = fork();
        yoxla( is_nomresi_sol_2 > 0 ){
            //Ata 
            Gozle();
            ekrana_yazdir("Ata Is_nomresi: %d ogul is_nomresi: %d ogul_is_nomresi_2: %d\n",getpid(), is_nomresi_sag, is_nomresi_sol_2);
            fflush(stdout);     // Ekran cikti garantisi alinmasi icin 
            Ata(is_nomresi_sag, is_nomresi_sol_2);
        }
        birde_yoxla( is_nomresi_sol_2 beraberdirmi 0 ){
            //ogul sol
            IS(--hundurluk);
        }
    }
    birde_yoxla( is_nomresi_sag beraberdirmi 0 ){
        //ogul sag
        IS(--hundurluk);

    }
}

reqem Ata( reqem is_nomresi_sol_1, reqem is_nomresi_sag_2 ){
    Gozle();
    herif Dosya_adi_1[20];
    sprintf( Dosya_adi_1,"%d.txt", is_nomresi_sol_1 );
    herif Dosya_adi_2[20];
    sprintf( Dosya_adi_2,"%d.txt", is_nomresi_sag_2 );
    herif Dosya_adi_3[20];
    sprintf( Dosya_adi_3,"%d.txt", getpid() );
    FILE *dosya_sol_1, *dosya_sag_2, *dosya3;
    dosya_sol_1 = fopen( Dosya_adi_1, "r" );
    dosya_sag_2 = fopen( Dosya_adi_2, "r" );
    reqem ogul_sol_1, ogul_sag_2;
    fscanf( dosya_sol_1, "%d", &ogul_sol_1 );
    fscanf( dosya_sag_2, "%d", &ogul_sag_2 );
    fclose( dosya_sol_1 );
    fclose( dosya_sag_2 );
    dosya3 = fopen( Dosya_adi_3, "w" );
    fprintf( dosya3, " %d ", ogul_sol_1 + ogul_sag_2 );
    fclose( dosya3 );
}

deyer_dondurmez Dosya(){
    herif Dosya_adi[20];
    sprintf(Dosya_adi,"%d.txt",getpid());
    FILE *dosya = fopen(Dosya_adi, "w");
    srand(getpid());
    fprintf(dosya," %d ",(rand()%100));
    fclose(dosya);
}

deyer_dondurmez Gozle(){
    wait(NULL);
}

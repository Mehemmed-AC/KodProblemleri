#ifndef acos_technology
#define acos_technology

#define baslangic           main

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

deyer_dondurmez ikiliktaban(reqem onluk);                                            //Ikilik System 
deyer_dondurmez mod_al(reqem x, reqem y);                                            //mod almaq ucun yazilmis fonksyion
deyer_dondurmez fibonacci(reqem x);                                                  //fibonacci serisi yaratan fonksiyon  
deyer_dondurmez hanoi(reqem disk,herif cubug1,herif cubug2,herif cubug3);            //Hanoi Oyunu 0.2
deyer_dondurmez qabarciq_siralama(reqem HECIM);                                      //Qabarci siralama fonksyonu
deyer_dondurmez sifrelemealgoritmasi(herif deyer_alan);                              //Sifreleme fonksiyonu
deyer_dondurmez IS( reqem hundurluk );                                               //
reqem Ata( reqem is_nomresi_sol_1, reqem is_nomresi_sag_2 );                         //

deyer_dondurmez Dosya();                                                             //
deyer_dondurmez Gozle();                                                             //
deyer_dondurmez A21();                                                               //Sifreleme fonksiyonuna deyer gondererek mesaji sifreleyen fonksiyon
deyer_dondurmez herif_al();                                                          //Herifi Isdifadeciden alar ve Ikilik Systeme cevirer
deyer_dondurmez setir_sonu();                                                        //Bir Cumlenin  -  isaretine qeder olan herif ve solzeri tek tek ikilik systeme cevirer
deyer_dondurmez rasgele();                                                           //Rasgele bit cevirici 
deyer_dondurmez ekrani_temizle();                                                    //Terminal ekranini temizleyen fonksiyon
deyer_dondurmez onluk_al();                                                          //Isdifadeciden onluk systemde reqem alaraq onu ikilik systeme ceviren fonksiyon
deyer_dondurmez hanoi_baslat();                                                      //Hanoi oyununu baslatmaq ucun yazilmis fonksiyon

#endif
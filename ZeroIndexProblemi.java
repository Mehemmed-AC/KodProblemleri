//Bu Kod Mbira Muhasib Programindan Alinan Bir Xetali Kodur    
//Bu Koda Bir Xeta Var Yeni Bug Bu Bug LIMIT Deyiseninden Isdiafde Ederek Yaradilan MELUMAT Arrayina
//LIMIT Deyisenini Verer Ken ++ Birdefe Artirmaq Lazimdir 
    
boolean yoxlayici_1 = false;
private void Isci_Tam_Borc_txtMouseClicked(java.awt.event.MouseEvent evt) {                                               
    // TODO add your handling code here:
    IsciWorker IW = new IsciWorker(Muhasib.getUstIsdifadeci(), Muhasib.getSirketAdi());

    int Iscilerin_Toplam_Borcu = (int) SC.HesabIscilerOM();
    this.Isci_Tam_Borc.setText(""+Iscilerin_Toplam_Borcu);
        
    if(yoxlayici_1 == false){
            
        //Bura Bir fonksiyon yazilmasi lazimdir
        //MV.MelumatVerici(null, Melumat_Menu3_Txt, "Isciler Tam Borc List", 100, 56, 83);
        MV.Yazdir(this.Melumat_Menu3_Txt, "Isciler Tam Borc List");
            
        this.Isci_Mass_Gosderici.setVisible(true);
        this.jScrollPane4.setVisible(true);
        this.jScrollPane2.setVisible(true);
        this.Iscileri_Gosderen_Liste.setVisible(true);
        yoxlayici_1 = true;
            
        //array tanimi 
        String[] Ayirici = AyiriciV2(SC);          

        //array uzunluqu vew LIMIT ayirici
        int Uzunluq = Ayirici.length;
        int LIMIT = Integer.parseInt(Ayirici[--Uzunluq]);
        int a = Integer.parseInt(Ayirici[--Uzunluq]);
        try{
            String[] ListTutucu = new String[4+a];
            //Xeta Tam Olaraq Burdadir Asaqi Daki Setirde LIMIT Deyisenini Birdefe Artirmaq Lazimdir
            String[][] MELUMATLAR = new String[2][++LIMIT]; //<<< BUG Bu Deyismis formasidir Evelki Forma >>> String[][] MELUMATLAR = new String[2][LIMIT];
            String[] ISCI_UST_MELUMAT = {"Ad","Mas"};
               
            for(int index = 0; index < LIMIT; index++ ){  
                String ad = IW.getIsciMelumati("IsciAD", Ayirici[0]);
                String mas = IW.getIsciMelumati("IsciMas", Ayirici[0]);
                ListTutucu[0] = ("Ad :"+ad+" Mass :"+mas);
                MELUMATLAR[0][0] = ad; MELUMATLAR[1][0] = mas;
            }      
                           
            ElaveEt(this.Isci_Mass_Gosderici, ISCI_UST_MELUMAT, MELUMATLAR, LIMIT, "Isci Borclar");
            Iscileri_Gosderen_Liste.setModel(new javax.swing.AbstractListModel<String>() {
                @Override
                public int getSize() { return ListTutucu.length; }
                @Override
                public String getElementAt(int i) { return ListTutucu[i]; }
             }); 
        } catch(Exception e){
             Yazdir("Isci Yoxdur Ve Ya Bir Xedta Bas Verdi"+e);
        }
    } else {
        MV.Yazdir(this.Melumat_Menu3_Txt, "");
        yoxlayici_1 = false;
        this.Isci_Mass_Gosderici.setVisible(false);
        this.Iscileri_Gosderen_Liste.setVisible(false);            
     }
}                                  

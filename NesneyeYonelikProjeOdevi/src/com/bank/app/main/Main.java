package com.bank.app.main;

import com.bank.app.service.BankaService;
import com.bank.app.people.Musteri;
import com.bank.app.accounts.*;
import com.bank.app.cards.KrediKarti;


public class Main {

	public static void main(String[] args) {
		
		BankaService servis = new BankaService();  //banka servisi sinifndan bir nesne olusturuldu
		
		Musteri musteri = servis.musteriOlustur("Elifnur", "KACAR", "...@gmail.com", 50052791);  //bir musteri olusturuldu
		
		System.out.println();
		
		servis.hesapAc(musteri, "Vadesiz", 5000);  //vadesiz bir hesap acildi
		servis.hesapAc(musteri, "Yatirim", 10000);   //yatirim hesabi acildi
		
		servis.krediKartiEkle(musteri, 7500, 0);  //kredi karti olusturuldu
		
		System.out.println();
		
		VadesizHesap vadesizHesap = (VadesizHesap) musteri.getHesaplar().get(0);   //hesaplar array listin 0. elemani cagirildi
        YatirimHesabi yatirimHesap = (YatirimHesabi) musteri.getHesaplar().get(1);   //hesaplar array listin 0. elemani cagirildi
        KrediKarti krediKarti = musteri.getKrediKartlari().get(0);  //kredi kartlari array listin 0. elemani cagirildi
		
        //olsturulan hesaplarin bakiyesi yazdirildi
        System.out.println("Vadesiz hesap bakiyesi: " + vadesizHesap.getBakiye() + " TL");
        System.out.println("Yatırım hesap bakiyesi: " + yatirimHesap.getBakiye() + " TL");
        System.out.println("Kredi kartı limiti: " + krediKarti.getLimit() + " TL");
        
        System.out.println();
        
        servis.paraYatir(yatirimHesap, 2000);  //yatirim hesabina 2000 tl yatirildi
        System.out.println("Yatirim hesabi yeni bakiye: " + yatirimHesap.getBakiye() + " TL");
       
        System.out.println();
        
        vadesizHesap.paraTransferi(yatirimHesap, 1000);
        System.out.println("Vaadesiz hesap yeni bakiye: " + vadesizHesap.getBakiye() + " TL");  //5000 tl olan vadesiz hesaptan1000 tl alindi
        System.out.println("Yatirim hesabi yeni bakiye: " + yatirimHesap.getBakiye() + " TL");  //12000 tl olan yatirim hesabina 1000 tl eklendi
        
        System.out.println();
        
        System.out.println("Kredi karti ile 500 TL harcama yapildi");
        krediKarti.setGuncelBorc(500);  // kredi kartina 500 tl borc ekledik
        System.out.println("Kredi karti guncel borc: " + krediKarti.getGuncelBorc() + " TL");
        
        System.out.println("Vadesiz hesaptan kredi karti borcu odendi");
        vadesizHesap.krediKartiBorcOdeme( krediKarti, 500);  //vadesiz hesapta para oldugu icin kredi kartinin 500 tl borcu odendi
        System.out.println("Kredi kartı yeni borc: " + krediKarti.getGuncelBorc() + " TL");
        System.out.println("Vadesiz hesap yeni bakiye: " + vadesizHesap.getBakiye() + " TL");
        
        System.out.println();
        
        musteri.hesapSil(yatirimHesap); //hesap silinmek isteniyor ama icinde para var once o parayi bir vadesiz hesaba atalim
        
        System.out.println("Once yatirim hesabindaki parayi vadesiz hesaba aktaralim");
        vadesizHesap.paraTransferi(yatirimHesap, 1000);  //vadesiz hesaptan yatirim hesabina para transferi yapildi
        System.out.println("Yatirim hesabi yeni bakiye: " + yatirimHesap.getBakiye() + " TL");
        System.out.println("Simdi hesap silindi");
        musteri.hesapSil(yatirimHesap);  //tekarar hesap siinmeye calisiliyor
        
        System.out.println();
        
        if(krediKarti.getGuncelBorc() == 0) {  //kredi kartini silebilmek icin once borcu olup olmadigi kontrol ediliyor
            System.out.println("Borc yok, kart silinebilir.");
            musteri.krediKartiSil(krediKarti);
        } else {
            System.out.println("Once kart borcu odeyin!");
        }
        
        System.out.println();
        //musteri ve guncel hesap bilgileri yazdiriliyor
        System.out.println("Musteri Bilgisi: " + musteri.getAd() + " " + musteri.getSoyad());
        System.out.println("Kalan Hesap Sayisi: " + musteri.getHesaplar().size());
        System.out.println("Kalan Kredi Karti Sayisi: " + musteri.getKrediKartlari().size());
        VadesizHesap kalanHesap = (VadesizHesap) musteri.getHesaplar().get(0);
        System.out.println("Kalan Hesap Bakiyesi: " + kalanHesap.getBakiye() + " TL");
        
		System.out.println("Hesaplar: " + musteri.getHesaplar().size());
		System.out.println("Kredi kartlari: " + musteri.getKrediKartlari().size());
		
		System.out.println();
		
		System.out.println("--toString() ciktilari--");
		System.out.println("Musteri bilgisi: " + musteri.toString());
		System.out.println("Vadesiz hesap: " + vadesizHesap.toString());
		System.out.println("Yatirim hesabi: " + yatirimHesap.toString());
		System.out.println("Kredi karti: " + krediKarti.toString());
		
	}

}

package com.bank.app.service;

import com.bank.app.accounts.*;
import com.bank.app.cards.KrediKarti;
import com.bank.app.people.Musteri;
import com.bank.app.people.BankaPersoneli;

public class BankaService {
	//Musteri olusturma
	public Musteri musteriOlustur(String ad, String soyad, String email, int telefon) {
        Musteri musteri = new Musteri(ad, soyad, email, telefon);  //musteri sinifindan nesne olusturuldu
        musteri.setMusteriNumarasi(musteri.musteriNoUret());   //metot ile random musteri nosu uretildi
        System.out.println("Musteri olusturuldu: "+ ad + " " + soyad);
        return musteri;
    }
	//Musteri adina hesap acma
	public void hesapAc(Musteri musteri, String hesapTuru, double bakiye) {
        musteri.hesapEkle(hesapTuru, bakiye);  
    }
	//Hesaba para yatirma
	public void paraYatir(YatirimHesabi hesap, double miktar) {
        hesap.paraEkle(miktar);
    }
	//Kredi karti ekleme
	public void krediKartiEkle(Musteri musteri, double limit, double guncelBorc) {
        musteri.krediKartiEkle(limit, guncelBorc);
    }
	
	
	
}

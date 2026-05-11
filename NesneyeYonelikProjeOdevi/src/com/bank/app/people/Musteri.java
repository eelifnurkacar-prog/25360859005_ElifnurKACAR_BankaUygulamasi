package com.bank.app.people;

import java.util.ArrayList;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;


public class Musteri extends Kisi {  //Musteri sinif kisi sinifndan miras aldi
	private String musteriNumarasi;
	private ArrayList<BankaHesabi> hesaplar = new ArrayList<>();
	private ArrayList<KrediKarti> krediKartlari = new ArrayList<>();

	public Musteri(String ad,String soyad, String email , int telefonNumarasi) {
		super(ad, soyad, email, telefonNumarasi);   //ust sinifin constucteri alindi
	}
	
	//getter setter metotlari
	public String getMusteriNumarasi() {
        return musteriNumarasi;
    }
	public void setMusteriNumarasi(String musteriNumarasi) {
        this.musteriNumarasi = musteriNumarasi;
    }
	
	public ArrayList<BankaHesabi> getHesaplar() {
        return hesaplar;
    }
	public void setHesaplar(ArrayList<BankaHesabi> hesaplar) {
        this.hesaplar = hesaplar;
    }
	
	public ArrayList<KrediKarti> getKrediKartlari() {
        return krediKartlari;
    }
	public void setKrediKartlari(ArrayList<KrediKarti> krediKartlari) {
        this.krediKartlari = krediKartlari;
    }
	
	public String musteriNoUret() {
		return "Musteri numarasi: " + (int)(Math.random()* 1000);  //Musteri numarasini 0 ile 999 arasinda rastgele olusturur.
	}
	
	//hesap eklemek icin metot
	public void hesapEkle(String hesapTuru , double baslangicBakiye) {
		if(hesapTuru.equals("Vadesiz")) {  //hesap turu vadesizler icin
			BankaHesabi hesap = new VadesizHesap(baslangicBakiye);  //polimorfik bir VadesizHesap nesnesi olusturuldu
			hesaplar.add(hesap);  //olusturulan nesne hesaplar array listine gonderildi
			System.out.println(hesapTuru + " turunde hesap eklendi.");
		}
		else if (hesapTuru.equals("Yatirim")) {  //hesap turu yatirim oolanlar icin
			BankaHesabi hesap = new YatirimHesabi(baslangicBakiye);  //polimorfik bir Yatirim nesnesi olusturldu
			hesaplar.add(hesap); //olusturulan nesne hesaplar array listine eklendi
			System.out.println(hesapTuru + " turunde hesap eklendi.");
		}
		else {
			System.out.println("Lutfen hesap turunu (Vadesiz) veya (Yatirim) olarak belirtin");
		}
	}
	
	//kreei karti eklemek icin metot
	public void krediKartiEkle(double limit , double guncelBakiye) {
		KrediKarti krediKarti = new KrediKarti(limit , guncelBakiye);  //kredi Karti sinifndan bir nesne olusturuldu
		krediKartlari.add(krediKarti);  //kredikartlar array listine eklendi
		System.out.println("Kredi kartiniz olusturuldu.");
	}
	
	//hesap silmek icin metot
	public void hesapSil(BankaHesabi hesap) {
		if(hesap.getBakiye() > 0) {  //hesap simeden once hesapta bakiye olup olmadigini kontrol edildi
			System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
		}
		else {
			hesaplar.remove(hesap);  //hesaplar array listinden hesap silindi
			System.out.println("Banka heasbiniz silindi.");
		}
	}
	
	//Kredi karti hesabi silmek icin metot
	public void krediKartiSil(KrediKarti kart) {
		if(kart.getGuncelBorc() != 0) {  //kartin borcu olup olmadigi kontrol edildi
			System.out.println("Lütfen öncelikle borç ödemesi yapınız");
		}
		else {
			krediKartlari.remove(kart);  //borcu yoksa silindi
			System.out.println("Kredi karti heasbiniz silindi.");
		}
	}
	
	public String toString() {
		return super.toString() + "Musteri no: " + musteriNumarasi ;
	}
}


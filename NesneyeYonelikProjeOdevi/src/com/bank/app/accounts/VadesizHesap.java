package com.bank.app.accounts;

import com.bank.app.cards.KrediKarti;

public class VadesizHesap extends BankaHesabi {  //VadesizHesap sinifi BankaHesabi sinifindan miras aldi

	private String hesapTuru;
	
	public VadesizHesap(double bakiye) {  //VadesizHesap classinin constructeri
		super(bakiye);   //ust sinifin constracturunu cagirdi
		this.hesapTuru = "Vadesiz";  // hesapTuru "Vadesiz" olarak ayarlandi
	}
	
	//getter setter metotlari
	public String getHesapTuru() {
        return hesapTuru;
    }
	public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }
	
	//para transferi icin metot
	public void paraTransferi(BankaHesabi aliciHesap , double miktar) {
		if(this.getBakiye() >= miktar) {   //bakiyede istenilen miktar varsa para transferi gerceklesecek
			this.setBakiye(this.getBakiye() - miktar);  //bakiyeden istenilen miktar dusuldu
			aliciHesap.setBakiye(aliciHesap.getBakiye() + miktar);  //alici hesaba miktar eklendi
			System.out.println(miktar + "kadar transfer yapilmistir");
		}
		else {
			System.out.println("Yetersiz Bakiye!!!");   //bakiye yeterli degil demek ki
		}
	}
	
	//kredi karti borcu odemek icin metot
	public void krediKartiBorcOdeme(KrediKarti kart , double miktar) {
		if(this.getBakiye() >= miktar) {  //hesapta yeterli para var mi ona bakiyor
			this.setBakiye(this.getBakiye() - miktar);  //hesaptan para dusuldu
			kart.setGuncelBorc(kart.getGuncelBorc() - miktar);   //kart borcu azaldi
		}
		System.out.println("Kartin guncel borcu: " + kart.getGuncelBorc());
	}
    public String toString() {
		return "Vadesiz hesap" +" "+ super.toString();
	}
}

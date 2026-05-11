package com.bank.app.accounts;

public class YatirimHesabi extends BankaHesabi { //YatirimHesabi sinifi BankaHesabi sinifindan miras aldi

	private String hesapTuru;
	
	public YatirimHesabi(double bakiye) {
		super(bakiye);   //ust sinifin constructeri cagirildi
		this.hesapTuru = "Yatirim";  //hesap turu Yatirim olarak belirtildi
	}
	
	//getter setter metotlari
	public String getHesapTuru() {
        return hesapTuru;
    }
	public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }
	
	//para eklemek icin metot
	public void paraEkle(double miktar) {
		double yeniBakiye = this.getBakiye() + miktar;  //yeniBakiye diye bir degisken belirtip bunu bakiye+miktar yaptik
		this.setBakiye(yeniBakiye);   //bakiyeyi yeniBakiye olarak degistirdik
		System.out.println(miktar + " miktarinda para hesaba eklendi.");
	}
	
	//para cekmek icin metot
	public void paraCek(BankaHesabi paraCekilenHesap ,double miktar) {
		if (this.getBakiye() >= miktar) {  //bakiyede yeteri kadar para var mi diye kontroledildi
			this.setBakiye(this.getBakiye() - miktar);  //bakiyeden istenilen miktar dusuruldu
            System.out.println(miktar + " TL çekildi.");
        } 
		else 
            System.out.println("Yetersiz Bakiye!!!");
	}
	
    public String toString() {
		return "Yatirim hesabinizda isleriniz gerceklestirildi.";
	}
}

package com.bank.app.accounts;


public class BankaHesabi {

	private String iban;
	private double bakiye;
	
	public BankaHesabi(double bakiye) {  //BankaHesabi sinifinin constructeri
		this.bakiye=bakiye;
		this.iban = ibanUret();  //ibanUret metodu ile random bir iban nosu uretildi
	}
	
	//getter setter metotlari
	public double getBakiye() {
        return bakiye;
    }
	public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }
	public String getIban() {
        return iban;
    }
	public void setIban(String iban) {
        this.iban = iban;
    }
	
	public String ibanUret() {
		return "TR" + String.format("%02d", (int)(Math.random() * 100)) + " " + 
	String.format("%04d", (int)(Math.random() * 10000)) + " " +                  //iban nurasaini gercek bir iban numarasi gibi uretmek icin haneleri ayiricak sekilde ayri ayri sayi urettik
		           String.format("%04d", (int)(Math.random() * 10000)) + " " +   //String.format() i kullanmamizin sebebi bir , iki veya uc haneli sayilarin basina 0 koyup onlari da dort basamaga tamamlamak istmemiz
		           String.format("%04d", (int)(Math.random() * 10000)) + " " +
		           String.format("%04d", (int)(Math.random() * 10000)) + " " +
		           String.format("%04d", (int)(Math.random() * 10000));
	}
	
	
	
	public String toString() {
		return "IBAN: " + iban + "   Bakiye: " + bakiye + "TL";
	}
}

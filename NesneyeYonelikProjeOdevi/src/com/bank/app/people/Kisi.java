package com.bank.app.people;

public class Kisi {
	private String ad;
	private String soyad;
	private String email;
	private long telefonNumarasi;
	
	public Kisi(String ad, String soyad , String email , long telefonNumarasi) { //constructeri
		this.ad=ad;
		this.soyad=soyad;
		this.email=email;
		this.telefonNumarasi=telefonNumarasi;
	}
	
	//getter setter metotlari
	public String getAd() {
        return ad;
    }
	public void setAd(String ad) {
        this.ad = ad;
    }
	public String getSoyad() {
        return soyad;
    }
	public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
	public String getEmail() {
        return email;
    }
	public void setEmail(String email) {
        this.email = email;
    }
	public long getTelefonNumarasi() {
        return telefonNumarasi;
    }
	public void setTelefonNumarasi(int telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }
	
	
	public String toString() {
		return "Adi: " + ad + "   Soyadi: " + soyad + "   emaili: " + email + "   Telefon nosu: "+ telefonNumarasi;
	}

}

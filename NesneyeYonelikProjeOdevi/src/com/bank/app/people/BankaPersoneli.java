package com.bank.app.people;

import java.util.ArrayList;

public class BankaPersoneli extends Kisi {   //BankaPersoneli sinifi kisi sinifindan miras aldi 
	private String personelID;
	private ArrayList<Musteri> musteriler;

	public BankaPersoneli(String ad,String soyad, String email , int telefonNumarasi) {
		super(ad, soyad, email, telefonNumarasi);  //ust sinifn constructerini aldi
	}
	
	//getter setter metotlari
	public String getPersonelID() {
        return personelID;
    }
	public void setPersonelID(String personelID) {
        this.personelID = personelID;
    }
	public ArrayList<Musteri> getMusteriler() {
        return musteriler;
    }
	public void setMusteriler(ArrayList<Musteri> musteriler) {
        this.musteriler = musteriler;
    }
	
	
	public String personelIDUret() {
        return "Personel ID: " + (int)(Math.random() * 1000);   //Personel IDyi 0 ile 999 arasinda rastgele olusturur.
    }
	
	
	public String toString() {
		return super.toString() + "Personel ID: " + personelID + "Musteri sayisi: " + musteriler.size();
	}
}

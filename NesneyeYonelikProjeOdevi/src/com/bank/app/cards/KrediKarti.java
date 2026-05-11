package com.bank.app.cards;

public class KrediKarti {
	private String kartNumarasi;
	private double limit;
	private double guncelBorc;
	private double kullanilabilirLimit;
	
	public KrediKarti(double limit , double guncelBorc) {   //constructeri
		this.limit=limit;
		this.guncelBorc=guncelBorc;
		this.kullanilabilirLimit = limit - guncelBorc;
		this.kartNumarasi = kartNoUret();  //kartNoUret() metodu ile random bir kart no uretildi
	}
	
	//getter setter metotlari
	public String getKartNumarasi() {
        return kartNumarasi;
    }
	public void setKartNumarasi(String kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }
	public double getLimit() {
        return limit;
    }
	public void setLimit(double limit) {
        this.limit = limit;
    }
	public double getGuncelBorc() {
        return guncelBorc;
    }
	public void setGuncelBorc(double guncelBorc) {
        this.guncelBorc = guncelBorc;
    }
	
	
	public String kartNoUret() {

	    return String.format("%04d", (int)(Math.random() * 10000)) + " " +      //kart noyu gercegine uygun olucak sekilde uretildi.
	           String.format("%04d", (int)(Math.random() * 10000)) + " " +      //yine ibamda oldugu gibi String.format() metodundan yararlanildi.
	           String.format("%04d", (int)(Math.random() * 10000)) + " " +
	           String.format("%04d", (int)(Math.random() * 10000));
	}
	
    public String toString() {
		return "Kredi karti no: " + kartNumarasi + "  Limit: " + limit + "TL   Guncel Borc: " + guncelBorc + " TL   Kullanilabilir limit: " + (limit-guncelBorc) + "TL  ";
	}

}

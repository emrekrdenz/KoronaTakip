package application;

import java.time.LocalDate;

public class hastalar {

	String chastaAdi;
	String memleket;
	String chastaMeslek;
	String chastaCinsiyet;
	String chastaAtes;
	String chastaTeshis;
	LocalDate Tarih;
	String muhtarlik;
	String mail;
	

	public hastalar(String chastaAdi, String memleket, String chastaMeslek, String chastaCinsiyet, String chastaAtes,
			String chastaTeshis, LocalDate tarih, String muhtarlik, String mail) {
	
		this.chastaAdi = chastaAdi;
		this.memleket = memleket;
		this.chastaMeslek = chastaMeslek;
		this.chastaCinsiyet = chastaCinsiyet;
		this.chastaAtes = chastaAtes;
		this.chastaTeshis = chastaTeshis;
		Tarih = tarih;
		this.muhtarlik = muhtarlik;
		this.mail = mail;
	}
	
	public String getChastaAdi() {
		return chastaAdi;
	}
	public void setChastaAdi(String chastaAdi) {
		this.chastaAdi = chastaAdi;
	}
	public String getMemleket() {
		return memleket;
	}
	public void setMemleket(String memleket) {
		this.memleket = memleket;
	}
	public String getChastaMeslek() {
		return chastaMeslek;
	}
	public void setChastaMeslek(String chastaMeslek) {
		this.chastaMeslek = chastaMeslek;
	}
	public String getChastaCinsiyet() {
		return chastaCinsiyet;
	}
	public void setChastaCinsiyet(String chastaCinsiyet) {
		this.chastaCinsiyet = chastaCinsiyet;
	}
	public String getChastaAtes() {
		return chastaAtes;
	}
	public void setChastaAtes(String chastaAtes) {
		this.chastaAtes = chastaAtes;
	}
	
	public String getChastaTeshis() {
		return chastaTeshis;
	}
	public void setChastaTeshis(String chastaTeshis) {
		this.chastaTeshis = chastaTeshis;
	}
	public LocalDate getTarih() {
		return Tarih;
	}
	public void setTarih(LocalDate tarih) {
		Tarih = tarih;
	}

	public String getMuhtarlik() {
		return muhtarlik;
	}

	public void setMuhtarlik(String muhtarlik) {
		this.muhtarlik = muhtarlik;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
	
}
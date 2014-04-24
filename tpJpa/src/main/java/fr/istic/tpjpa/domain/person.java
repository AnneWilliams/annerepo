package fr.istic.tpjpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class person implements Serializable {

	private long id;
	private String nom;
	private String prenom;
	private String genre;
	private String mail;
	private Date date_naiss;
	private String profil_fb;
	private List<home> hom = new ArrayList<home>();
	private List<person> amis = new ArrayList<person>();
	List<ElectronicDevice> electro = new ArrayList<ElectronicDevice>();

	public person() {

	}

	public person(String nom, String prenom, String genre, String mail,
			Date date_naiss, String profil_fb) {
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.mail = mail;
		this.date_naiss = date_naiss;
		this.profil_fb = profil_fb;

	}

	public person(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;

	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}

	public String getProfil_fb() {
		return profil_fb;
	}

	public void setProfil_fb(String profil_fb) {
		this.profil_fb = profil_fb;
	}

	@OneToMany(mappedBy = "personn", cascade = CascadeType.PERSIST)
	public List<ElectronicDevice> getElectro() {
		return electro;

	}

	public void setElectro(List<ElectronicDevice> electro) {
		this.electro = electro;
	}

	@OneToMany
	public List<person> getAmis() {
		return amis;
	}

	public void setAmis(List<person> amis) {
		this.amis = amis;
	}

	@OneToMany(mappedBy = "personn", cascade = CascadeType.PERSIST)
	public List<home> getHom() {
		return hom;

	}

	public void setHom(List<home> hom) {
		this.hom = hom;
	}

	@Override
	public String toString() {
		return "person [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", genre=" + genre + ", mail=" + mail + ", date_naiss="
				+ date_naiss + ", profil_fb=" + profil_fb + ", hom=" + hom
				+ ", amis=" + amis + ", electro=" + electro + "]";
	}

}

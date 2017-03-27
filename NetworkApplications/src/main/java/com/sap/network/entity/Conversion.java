/**
 * 
 */
package com.sap.network.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author C5251932
 *
 */

public class Conversion implements Serializable {

	private static final long serialVersionUID = 1L;
	private String bbl;
	private String bb6;
	private String kg;
	private String litre;
	private String gal;
	private String g;
	
	public String getBbl() {
		return bbl;
	}
	public void setBbl(String bbl) {
		this.bbl = bbl;
	}
	public String getBb6() {
		return bb6;
	}
	public void setBb6(String bb6) {
		this.bb6 = bb6;
	}
	public String getKg() {
		return kg;
	}
	public void setKg(String kg) {
		this.kg = kg;
	}
	public String getLitre() {
		return litre;
	}
	public void setLitre(String litre) {
		this.litre = litre;
	}
	public String getGal() {
		return gal;
	}
	public void setGal(String gal) {
		this.gal = gal;
	}
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}

}

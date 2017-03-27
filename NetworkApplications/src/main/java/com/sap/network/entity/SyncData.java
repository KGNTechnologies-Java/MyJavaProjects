/**
 * 
 */
package com.sap.network.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author C5251932
 *
 */
@Entity
@Table(name="SYNCDATA")
public class SyncData implements Serializable{
	private static final long serialVersionUID = 253573055365916895L;	

	@Column(name="MATERIALNUMBER")
	private String materialNo;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="UNITOFMEASURE")
	private String unitOfMeasure;
	
	@Column(name="PRICEUNIT")
	private String priceUnit;
	
	@Column(name="PLANT")
	private String plant;
	
	@Column(name="STOCKLOCATION")
	private String stockLocation;
	
	@Column(name="BPNAME")
	private String bpName;
	
	@Column(name="ENDDATE")
	private String endDate;
	
	@Id
	@Column(name="DOCUMENTNO")
	private String documentNo;

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getStockLocation() {
		return stockLocation;
	}

	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}

	public String getBpName() {
		return bpName;
	}

	public void setBpName(String bpName) {
		this.bpName = bpName;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

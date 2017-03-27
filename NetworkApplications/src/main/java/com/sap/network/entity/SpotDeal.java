/**
 * 
 */
package com.sap.network.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author C5251932
 *
 */

@Entity
@Table(name="SPOTDEAL")
public class SpotDeal implements java.io.Serializable{
	
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
	
	/*@OneToMany(targetEntity=UserSpotDeal.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "SpotDealDocNo", referencedColumnName="DOCUMENTNO")
	private Set<UserSpotDeal> userSpotDeal;	*/
	
	@OneToMany(targetEntity=BidSpotDeal.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "SpotDealDocNo", referencedColumnName="DOCUMENTNO")
	private Set<BidSpotDeal> userSpotDeal;
	
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
/*	public Set<UserSpotDeal> getUserSpotDeal() {
		return userSpotDeal;
	}
	public void setUserSpotDeal(Set<UserSpotDeal> userSpotDeal) {
		this.userSpotDeal = userSpotDeal;
	}*/
	public Set<BidSpotDeal> getUserSpotDeal() {
		return userSpotDeal;
	}
	public void setUserSpotDeal(Set<BidSpotDeal> userSpotDeal) {
		this.userSpotDeal = userSpotDeal;
	}
	

}

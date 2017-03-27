/**
 * 
 */
package com.sap.network.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author C5251932
 *
 */

@Entity
@Table(name = "HANAMARATBL")
public class HanaMaraTable {

	@Id
	@Column(name = "MATNR")
	private String materialNumber;
	@Column(name = "AENAM")
	private String personName;
	@Column(name = "MTART")
	private String materialType;
	@Column(name = "MBRSH")
	private String industrySector;
	@Column(name = "MATKL")
	private String materialGroup;

	public String getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getIndustrySector() {
		return industrySector;
	}

	public void setIndustrySector(String industrySector) {
		this.industrySector = industrySector;
	}

	public String getMaterialGroup() {
		return materialGroup;
	}

	public void setMaterialGroup(String materialGroup) {
		this.materialGroup = materialGroup;
	}

}

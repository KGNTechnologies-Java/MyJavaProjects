/**
 * 
 */
package com.sap.network.serviceintf;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.sap.network.entity.BidSpotDeal;
import com.sap.network.entity.Conversion;
import com.sap.network.entity.HanaMaraTable;
import com.sap.network.entity.NetworkUsers;
import com.sap.network.entity.SpotDeal;

/**
 * @author C5251932
 *
 */
public interface NetworkServiceIntf {
	
	public String getLoginUsers(String userId, String pwd) throws SQLException;
	public Serializable createtUser(NetworkUsers user) throws SQLException;
	public List<SpotDeal> getAllSpotDeal() throws SQLException;
	public Serializable saveSpotDeal(SpotDeal spotDeal) throws Exception;
	public List<BidSpotDeal> getUserSpotDeals(String userId) throws SQLException;
	public List<BidSpotDeal> getBidSpotDeal(String documentNo, String userId) throws SQLException;
	public int updateBidSpotDeal(BidSpotDeal bidSpotDeal) throws Exception;
	public int confirmBidSpotDeal(BidSpotDeal bidSpotDeal) throws Exception;
	public int userConfirmRequest(BidSpotDeal bidSpotDeal) throws Exception;
	public List<HanaMaraTable> getSyncData() throws SQLException;
	public Serializable saveSyncData(List<HanaMaraTable> syncData) throws Exception;
	public List<Conversion> getConversion(String transactionQty, String transactionUnit) throws SQLException;
}

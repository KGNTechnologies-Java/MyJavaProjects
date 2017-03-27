/**
 * 
 */
package com.sap.network.daointf;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.sap.network.entity.SpotDeal;
import com.sap.network.entity.SyncData;
import com.sap.network.entity.BidSpotDeal;
import com.sap.network.entity.HanaMaraTable;
import com.sap.network.entity.NetworkUsers;

/**
 * @author C5251932
 *
 */
public interface NetworkDAOIntf {
	
	public List<NetworkUsers> getLoginUsers() throws SQLException;
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
}

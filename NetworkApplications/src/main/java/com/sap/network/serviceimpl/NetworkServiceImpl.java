/**
 * 
 */
package com.sap.network.serviceimpl;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sap.network.daointf.NetworkDAOIntf;
import com.sap.network.entity.BidSpotDeal;
import com.sap.network.entity.Conversion;
import com.sap.network.entity.HanaMaraTable;
import com.sap.network.entity.NetworkUsers;
import com.sap.network.entity.SpotDeal;
import com.sap.network.serviceintf.NetworkServiceIntf;

/**
 * @author C5251932
 *
 */

@Service("networkServiceIntf")
public class NetworkServiceImpl implements NetworkServiceIntf {
	
	@Autowired
	NetworkDAOIntf networkDAOIntf;
	
	@Transactional
	public List<SpotDeal> getAllSpotDeal() throws SQLException {
		List<SpotDeal> spotDeals = networkDAOIntf.getAllSpotDeal();
		return spotDeals;
	}

	@Transactional
	public Serializable saveSpotDeal(SpotDeal spotDeal) throws Exception {		
		SecureRandom random = new SecureRandom();
		String randomGen = "DOC"+new BigInteger(32, random).toString(32).toUpperCase();
		spotDeal.setDocumentNo(randomGen);
		Serializable spotDeals = networkDAOIntf.saveSpotDeal(spotDeal);	
				
		return spotDeals;
	}

	@Transactional
	public String getLoginUsers(String userId, String pwd) throws SQLException {	
		String returnPage = "";
		List<NetworkUsers> loginUser = networkDAOIntf.getLoginUsers();	
		if(userId != null && pwd != null){
			for(NetworkUsers users : loginUser){
				
				if(userId.equals(users.getEmail()) && pwd.equals(users.getPassword())){
					if("admin".equals(users.getRole())){
						returnPage = "createSpotDeal";
					}else{
						returnPage = "viewSpotDeal";
					}
					
				}
				
			}
			
			if(returnPage == ""){
				returnPage = "login";
			}
		}else{
			returnPage = "login";
		}
		
		
		return returnPage;
	}

	@Transactional
	public Serializable createtUser(NetworkUsers user) throws SQLException {
		Serializable result = networkDAOIntf.createtUser(user);
		return result;
	}

	@Transactional
	public List<BidSpotDeal> getUserSpotDeals(String userId) throws SQLException {
		List<BidSpotDeal> userSpotDeals = networkDAOIntf.getUserSpotDeals(userId);
		return userSpotDeals;
	}

	@Transactional
	public List<BidSpotDeal> getBidSpotDeal(String documentNo, String userId) throws SQLException {
		List<BidSpotDeal> bidSpotdeal = networkDAOIntf.getBidSpotDeal(documentNo, userId);
		return bidSpotdeal;
	}

	@Transactional
	public int updateBidSpotDeal(BidSpotDeal bidSpotDeal) throws Exception {
		int result = networkDAOIntf.updateBidSpotDeal(bidSpotDeal);
		return result;
	}
	
	@Transactional
	public int confirmBidSpotDeal(BidSpotDeal bidSpotDeal) throws Exception {
		int result = networkDAOIntf.confirmBidSpotDeal(bidSpotDeal);
		return result;
	}

	@Transactional
	public int userConfirmRequest(BidSpotDeal bidSpotDeal) throws Exception {
		return networkDAOIntf.userConfirmRequest(bidSpotDeal);
		
	}

	@Transactional
	public List<HanaMaraTable> getSyncData() throws SQLException {
		List<HanaMaraTable> syncData = networkDAOIntf.getSyncData();
		return syncData;
	}

	@Transactional
	public Serializable saveSyncData(List<HanaMaraTable> syncData) throws Exception {
		
		
		Serializable syncDatas = networkDAOIntf.saveSyncData(syncData);
		
		return syncDatas;
	}

	@Override
	public List<Conversion> getConversion(String transactionQty, String transactionUnit) throws SQLException {
		Conversion conv = new Conversion();
		Double qty = Double.parseDouble(transactionQty);
		System.out.println("qty==>"+qty);
		Double bb6qty =  0.99096*qty;
		Double bblqty = 1*qty;
		Double galqty = 41.79*qty;
		Double kgqty = 129.80675*qty;
		Double ltrqty = 158.19236*qty;
		Double gqty = 129806.75*qty;
		System.out.println("gqty==>"+gqty);		
		
		conv.setBb6(bb6qty.toString());
		conv.setBbl(bblqty.toString());
		conv.setGal(galqty.toString());
		conv.setKg(kgqty.toString());
		conv.setLitre(ltrqty.toString());
		conv.setG(gqty.toString());
		List<Conversion> convList = new ArrayList<Conversion>();
		convList.add(conv);
		return convList;
	}


	
}

/**
 * 
 */
package com.sap.network.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
/* Rest controller*/

@RestController
public class NetworkRestController {
	@Autowired
	NetworkServiceIntf networkServiceIntf;	
	
	@RequestMapping(value = "/createSpotdeal", method = RequestMethod.POST, headers = "Accept=application/json")
	public Serializable saveSpotDeal(@RequestBody SpotDeal spotDeal) throws Exception{
		
		Serializable spotDeals = networkServiceIntf.saveSpotDeal(spotDeal);
	    return spotDeals;
	}
	
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public Serializable createtUser(@RequestBody NetworkUsers insertUser) throws SQLException{		
		Serializable insertUsr = networkServiceIntf.createtUser(insertUser);
		return insertUsr;
	}	
	
	@RequestMapping(value = "/getAllSpotDeals", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<SpotDeal> getAllSpotDeal() throws Exception {
		List<SpotDeal> spotDeal = networkServiceIntf.getAllSpotDeal();
		return spotDeal;
	}
	
	@RequestMapping(value = "/userViewSpotDeals",params = {"userId"}, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<BidSpotDeal> getUserSpotDeals(@RequestParam(value="userId") String userId) throws Exception {
		List<BidSpotDeal> userSpotDeals = networkServiceIntf.getUserSpotDeals(userId);
		return userSpotDeals;
	}
	
	@RequestMapping(value = "/getBidSpotDeals",params = {"userId", "documentNo"}, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<BidSpotDeal> getBidSpotDeal(@RequestParam(value="userId") String userId, @RequestParam(value="documentNo") String documentNo, HttpServletRequest request) throws Exception {
		
		request.getSession().setAttribute("userId", userId);
		request.getSession().setAttribute("documentNo", documentNo);
		
		List<BidSpotDeal> bidSpotdeal = new ArrayList<BidSpotDeal>();
		try {
				bidSpotdeal = networkServiceIntf.getBidSpotDeal(documentNo, userId);
		} catch (SQLException e) {
			
		}		
		return bidSpotdeal;
	}
	
	@RequestMapping(value = "/confirmRequest", method = RequestMethod.POST, headers = "Accept=application/json")
	public int userConfirmRequest(@RequestBody BidSpotDeal bidSpotDeal) throws Exception{
		return networkServiceIntf.userConfirmRequest(bidSpotDeal);
	}
	
	@RequestMapping(value = "/bidConfirmSpotDeal", method = RequestMethod.POST, headers = "Accept=application/json")
	public int bidAndConfirmSpotDeal(@RequestBody BidSpotDeal bidSpotDeal) throws Exception{
		int result = 0;
			result = networkServiceIntf.confirmBidSpotDeal(bidSpotDeal);
		return result;
	}
	
	@RequestMapping(value = "/saveSyncData", method = RequestMethod.POST, headers = "Accept=application/json")
	public Serializable saveSyncData(@RequestBody List<HanaMaraTable> syncData) throws Exception{
		
		Serializable syncDatas = networkServiceIntf.saveSyncData(syncData);
	    return syncDatas;
	}
	
	@RequestMapping(value = "/getSyncData", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<HanaMaraTable> getSyncData() throws Exception {
		List<HanaMaraTable> syncData = networkServiceIntf.getSyncData();
		return syncData;
	}
	
	@RequestMapping(value = "/getSfourData", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<HanaMaraTable> getSyncDataFromHCP() throws Exception {
		List<HanaMaraTable> hanaMaraTable = networkServiceIntf.getSyncData();
		return hanaMaraTable;
	}
	
	@RequestMapping(value = "/getConversion",params = {"transactionQty", "transactionUnit"}, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Conversion> getConversion(@RequestParam(value="transactionQty") String transactionQty, @RequestParam(value="transactionUnit") String transactionUnit, HttpServletRequest request) throws Exception {
				System.out.println("transactionQty==>"+transactionQty);
		List<Conversion> conv = new ArrayList<Conversion>();
		try {
			conv = networkServiceIntf.getConversion(transactionQty, transactionUnit);
		} catch (SQLException e) {
			
		}		
		return conv;
	}
	
}

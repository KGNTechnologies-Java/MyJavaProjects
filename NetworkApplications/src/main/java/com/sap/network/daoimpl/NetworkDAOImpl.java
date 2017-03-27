/**
 * 
 */
package com.sap.network.daoimpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sap.network.daointf.NetworkDAOIntf;
import com.sap.network.entity.BidSpotDeal;
import com.sap.network.entity.HanaMaraTable;
import com.sap.network.entity.NetworkUsers;
import com.sap.network.entity.SpotDeal;
import com.sap.network.entity.SyncData;

/**
 * @author C5251932
 *
 */

@Repository
public class NetworkDAOImpl implements NetworkDAOIntf {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<SpotDeal> getAllSpotDeal() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		List<SpotDeal> spotDeals = session.createQuery("from SpotDeal").list();
		return spotDeals;
	}

	public Serializable saveSpotDeal(SpotDeal spotDeal) throws Exception {
		Serializable spotDeals = 0;

		try {
			Session session = this.sessionFactory.getCurrentSession();					
			spotDeals = session.save(spotDeal);			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		

		return spotDeals;
	}

	
	@SuppressWarnings("unchecked")
	public List<NetworkUsers> getLoginUsers() throws SQLException {		
		Session session = this.sessionFactory.getCurrentSession();	
		List<NetworkUsers> loginUser = session.createQuery("from NetworkUsers").list();		
		return loginUser;
	}

	
	public Serializable createtUser(NetworkUsers user) throws SQLException {	
		Session session = this.sessionFactory.getCurrentSession();						
		Serializable result = session.save(user);
		return  result;
	}

	
	@SuppressWarnings("unchecked")
	public List<BidSpotDeal> getUserSpotDeals(String userId) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit  = session.createCriteria(BidSpotDeal.class);
		crit.add(Restrictions.eq("email", userId));
		crit.add(Restrictions.ne("status", "open"));
		List<BidSpotDeal> userSpotDeals = crit.list();
		return userSpotDeals;
	}

	
	@SuppressWarnings("unchecked")
	public List<BidSpotDeal> getBidSpotDeal(String documentNo, String userId) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit  = session.createCriteria(BidSpotDeal.class);
		crit.add(Restrictions.eq("documentNo", documentNo));
		crit.add(Restrictions.eq("email", userId));
		List<BidSpotDeal> bidSpotDeals = crit.list();
		return bidSpotDeals;
	}

	public int updateBidSpotDeal(BidSpotDeal bidSpotDeal) throws Exception {
		int result = 0;
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "Update BidSpotDeal set unitOfMeasure = :unitOfMeasure, quantity = :quantity, priceUnit = :priceUnit, status = :status where documentNo = :documentNo and email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("unitOfMeasure", bidSpotDeal.getUnitOfMeasure());
		query.setParameter("quantity", bidSpotDeal.getQuantity());
		query.setParameter("priceUnit", bidSpotDeal.getPriceUnit());
		query.setParameter("status", bidSpotDeal.getStatus());
		query.setParameter("documentNo", bidSpotDeal.getDocumentNo());
		query.setParameter("email", bidSpotDeal.getEmail());		
		result =query.executeUpdate();
		return result;
	}	
	
	
	@SuppressWarnings("unchecked")
	public int confirmBidSpotDeal(BidSpotDeal bidSpotDeal) throws Exception {
		int result =0;
		int res = 0;
		int qty = 0;
		Session getBidSession = this.sessionFactory.getCurrentSession();
		Criteria crite  = getBidSession.createCriteria(BidSpotDeal.class);
		crite.add(Restrictions.eq("documentNo", bidSpotDeal.getDocumentNo()));			
		List<BidSpotDeal> spotDeals = crite.list();
		if(spotDeals != null){
			for(BidSpotDeal bds : spotDeals){
				qty = bds.getQuantity();
			}
		}
		
		if( qty >=bidSpotDeal.getBiddedQuantity()){
			qty = qty-bidSpotDeal.getBiddedQuantity();
			/* update only quantity based on document no in BidSpotDeal */
			Session session = this.sessionFactory.getCurrentSession();		
			String hql = "Update BidSpotDeal set unitOfMeasure = :unitOfMeasure, quantity = :quantity, biddedQuantity = :biddedQuantity, priceUnit = :priceUnit, status = :status where documentNo = :documentNo and email = :email";
			Query query = session.createQuery(hql);
			query.setParameter("unitOfMeasure", bidSpotDeal.getUnitOfMeasure());
			query.setParameter("quantity", qty);
			query.setParameter("biddedQuantity", bidSpotDeal.getBiddedQuantity());
			query.setParameter("priceUnit", bidSpotDeal.getPriceUnit());
			query.setParameter("status", "Bidded");
			query.setParameter("documentNo", bidSpotDeal.getDocumentNo());
			query.setParameter("email", bidSpotDeal.getEmail());		
			result =query.executeUpdate();
			
			Session updatesession = this.sessionFactory.getCurrentSession();		
			String hqlupdate = "Update BidSpotDeal set  quantity = :quantity where documentNo = :documentNo";
			Query updatequery = updatesession.createQuery(hqlupdate);
			updatequery.setParameter("quantity", qty);
			updatequery.setParameter("documentNo", bidSpotDeal.getDocumentNo());
			res = updatequery.executeUpdate();
			
			
		}else{
			// Quantity is less than bidded quantity
		}
		
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public int userConfirmRequest(BidSpotDeal bidSpotDeal) throws Exception {
		int result = 0;
		int qty = 0;
		int bqty = 0;
		int biddedqty = 0;
		int sqty = 0;
		Session getBidSession = this.sessionFactory.getCurrentSession();
		Criteria crite  = getBidSession.createCriteria(SpotDeal.class);
		crite.add(Restrictions.eq("documentNo", bidSpotDeal.getDocumentNo()));		
		List<SpotDeal> spotDeal = crite.list();
		if(spotDeal != null){
			for(SpotDeal bds : spotDeal){
				qty = bds.getQuantity();
			}
		}
		Session bidSession = this.sessionFactory.getCurrentSession();
		Criteria criteria  = bidSession.createCriteria(BidSpotDeal.class);
		criteria.add(Restrictions.eq("documentNo", bidSpotDeal.getDocumentNo()));			
		List<BidSpotDeal> qspotDeal = criteria.list();		
		if(qspotDeal != null){
			for(BidSpotDeal qbds : qspotDeal){
				bqty = qbds.getQuantity();
				biddedqty = qbds.getBiddedQuantity();
			}
		}
		
		if(qty >= bqty){			
			if(qty == bqty){
				sqty  = bqty;
			}else if(bqty !=0){
				sqty  = bqty;
			}else{
				sqty  = qty;
			}
			
			String docNo = bidSpotDeal.getDocumentNo();		
			Session session = this.sessionFactory.getCurrentSession();
			Criteria crit  = session.createCriteria(SpotDeal.class);
			crit.add(Restrictions.eq("documentNo", docNo));		
			List<SpotDeal> spotDeals = crit.list();
			if(spotDeals != null){
				for(SpotDeal spdeal:spotDeals){
					bidSpotDeal.setDocumentNo(spdeal.getDocumentNo());
					bidSpotDeal.setBpName(spdeal.getBpName());
					bidSpotDeal.setMaterialNo(spdeal.getMaterialNo());
					bidSpotDeal.setPlant(spdeal.getPlant());
					bidSpotDeal.setPriceUnit(spdeal.getPriceUnit());				
					bidSpotDeal.setStockLocation(spdeal.getStockLocation());
					bidSpotDeal.setUnitOfMeasure(spdeal.getUnitOfMeasure());
					bidSpotDeal.setEndDate(spdeal.getEndDate());
				}
			}
			
			
			String hql = "Update BidSpotDeal set status = :status, documentNo = :documentNo, materialNo = :materialNo, quantity = :quantity, biddedQuantity = :biddedQuantity, unitOfMeasure = :unitOfMeasure, priceUnit = :priceUnit, plant = :plant, stockLocation = :stockLocation, bpName = :bpName, endDate = :endDate where  SpotDealDocNo = :spdocno and email = :email and status = :stat";
			Query query = session.createQuery(hql);		
			query.setParameter("spdocno", docNo);
			query.setParameter("stat","open");
			query.setParameter("documentNo", bidSpotDeal.getDocumentNo());
			query.setParameter("email", bidSpotDeal.getEmail());	
			query.setParameter("materialNo", bidSpotDeal.getMaterialNo());
			query.setParameter("quantity",sqty);
			query.setParameter("biddedQuantity",0);	
			query.setParameter("unitOfMeasure", bidSpotDeal.getUnitOfMeasure());
			query.setParameter("priceUnit", bidSpotDeal.getPriceUnit());
			query.setParameter("plant", bidSpotDeal.getPlant());
			query.setParameter("stockLocation", bidSpotDeal.getStockLocation());
			query.setParameter("bpName", bidSpotDeal.getBpName());
			query.setParameter("endDate", bidSpotDeal.getEndDate());
			query.setParameter("status","Yet to bid");
			
			result =query.executeUpdate();
		}	
		
		
		return result;
	}


	@SuppressWarnings("unchecked")
	public List<HanaMaraTable> getSyncData() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		List<HanaMaraTable> syncData = session.createQuery("from HanaMaraTable").list();
		return syncData;
	}

	
	public Serializable saveSyncData(List<HanaMaraTable> syncData) throws Exception {

		Serializable syncDatas = 0;

		try {
			Session session = this.sessionFactory.getCurrentSession();	
			if(syncData.size()>0){
				for(HanaMaraTable saveData : syncData){
					session.saveOrUpdate(saveData);
					syncDatas = 1;	
				}
			}
				
			
		} catch (Exception ex) {
			syncDatas = 0;	
			ex.printStackTrace();
		}
		

		return syncDatas;
	
	}
	
	
}

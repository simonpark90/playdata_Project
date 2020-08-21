package model.dto;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;

import util.PublicCommon;

public class WordDAO {
	
	public static boolean insertContent(WordDTO vo) throws SQLException{
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			em.persist(vo);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			em.close();
		}
		return true;
	}
	
	public static ArrayList<String> getAllContents(String startDate, String endDate) throws SQLException{
		EntityManager em = PublicCommon.getManager();
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = null;
		Date eDate = null;
		try {
			sDate = fm.parse(startDate);
			eDate = fm.parse(endDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		try {
			return (ArrayList<String>)em.createNamedQuery("selectedList").setParameter("startDate", sDate, TemporalType.DATE).setParameter("endDate", eDate, TemporalType.DATE).getResultList();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();		
		} finally {
			em.close();
		}
		return null;
	}
}

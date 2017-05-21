package com.thepsi.appraisalSystem.dao;


import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.thepsi.appraisalSystem.model.TELPP_IMPACT_DETAILS;
import com.thepsi.appraisalSystem.model.TelppImpactReportVO;
import com.thepsi.appraisalSystem.util.AppraisalConstants;

@Repository
@PersistenceContext
public class TelppImpactDaoImpl {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
    public List<TelppImpactReportVO> getEmployeeTelpp() {
		
		logger.info("CLASSNAME:TelppImpactDaoImpl");
		logger.info("METHODNAME:getEmployeeTelpp");
		
		String hql = " select emp.Employees_Id as empCode,"
					  +"emp.Employee_name as employeeName,emp.doj,emp.designation,"
					  +"telpp.IMPACT as impact,telpp.IMPACT2 as impact2,telpp.TELPP as telpp"
					  +" from employee emp"
					  +" inner join TELPP_IMPACT_STATUS telpp on emp.Employees_Id=telpp.EMP_ID"
					  + " order by emp.Employees_Id";

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List <TelppImpactReportVO> empTelppList = session
				.createSQLQuery(hql)
				.addScalar("empCode",new StringType())
				.addScalar("employeeName",new StringType())
				.addScalar("doj",new StringType())
				.addScalar("designation",new StringType())
				.addScalar("impact",new StringType())
				.addScalar("impact2",new StringType())
				.addScalar("telpp",new StringType())
				.setResultTransformer(
				  Transformers.aliasToBean(TelppImpactReportVO.class))
				.list();
		session.close();
		return empTelppList;

	}
    
    
    @SuppressWarnings("unchecked")
	public List<TelppImpactReportVO> doBasicSearch(String groupName,String Designation,
			String empNameSearch) {
    	logger.info("CLASSNAME:TelppImpactDaoImpl");
		logger.info("METHODNAME:doBasicSearch");
		
		String hql = " select emp.Employees_Id as empCode,"
				  +"emp.Employee_name as employeeName,emp.doj,emp.designation,"
				  +"telpp.IMPACT as impact,telpp.IMPACT2 as impact2,telpp.TELPP as telpp"
				  +" from employee emp"
				  +" inner join TELPP_IMPACT_STATUS telpp on emp.Employees_Id=telpp.EMP_ID";
		
		String search_criteria =" where  1=1 ";
		int index = 0;
		if(groupName !=null && groupName!=""){
			search_criteria = search_criteria + " and emp.group_name='"+groupName+"' ";
		}
		
		if(Designation !=null && Designation!="" ){
			search_criteria = search_criteria + " and emp.designation='"+Designation+"' ";
		}
		if( empNameSearch != "")
		{
			search_criteria = search_criteria + "and emp.Employee_name = '"+empNameSearch+"' ";
		}
		search_criteria = search_criteria + "order by emp.Employees_Id";
		hql = hql + search_criteria;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List <TelppImpactReportVO> empTelppList = session
				.createSQLQuery(hql)
				.addScalar("empCode",new StringType())
				.addScalar("employeeName",new StringType())
				.addScalar("doj",new StringType())
				.addScalar("designation",new StringType())
				.addScalar("impact",new StringType())
				.addScalar("impact2",new StringType())
				.addScalar("telpp",new StringType())
				.setResultTransformer(
						Transformers.aliasToBean(TelppImpactReportVO.class))
				.list();
		session.close();
		return empTelppList;
	}
	
}

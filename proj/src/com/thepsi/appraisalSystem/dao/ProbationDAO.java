package com.thepsi.appraisalSystem.dao;

import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.mysql.jdbc.CallableStatement;
import com.thepsi.appraisalSystem.model.Employee;

import com.thepsi.appraisalSystem.model.ProbationData;

import com.thepsi.appraisalSystem.model.User_Role;
import com.thepsi.appraisalSystem.util.AppraisalConstants;
import com.thepsi.appraisalSystem.util.PropertyReader;

@Repository
public class ProbationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<ProbationData> getProbationData(int empId){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProbationData.class);
		criteria.add(Restrictions.eq("empCode", empId));
		List<ProbationData> probationDataList = (List<ProbationData>)criteria.list();
		session.close();
		return probationDataList;
	}
	
	
	public List<Employee> getProbationersList(){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("isProbationer",AppraisalConstants.IS_PROBATIONER));
		//criteria.add(Restrictions.eq("Employee_Type",AppraisalConstants.EMPLOYEE_TYPE_PROBATION));
		criteria.add(Restrictions.eq("leftorg", 0));
		//criteria.addOrder(Order.asc("employeeName"));
		List<Employee> probationersList = null;
		if(criteria.list()!=null)
			probationersList = criteria.list();
		session.close();
		return probationersList;
	}
	
	public List<Employee> getProbationersListForManagers(int empId){
		Session session = sessionFactory.openSession();
		/*Query q = session.createQuery("from Employee as employee ,ProbationDelegationData as data where employee.Employee_Type=:t and employee.leftorg=:l and (employee.manager=:m or (employee.employeeId=data.empCode and data.delegatedTo=:d))");
		q.setParameter("t", AppraisalConstants.EMPLOYEE_TYPE_PROBATION);
		q.setParameter("l", 0);
		q.setParameter("m", empId);
		q.setParameter("d", empId);
		List<Employee> probationersList = new ArrayList();
		Employee employee = new Employee();
		List <Object[]> objects = q.list();
		for(Object[] object:objects){
			employee = (Employee)object[0];
			probationersList.add(employee);
		}
		session.close();
		return probationersList;*/
		
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("isProbationer",AppraisalConstants.IS_PROBATIONER));
		//criteria.add(Restrictions.eq("Employee_Type",AppraisalConstants.EMPLOYEE_TYPE_PROBATION));
		criteria.add(Restrictions.eq("manager",empId));
		criteria.add(Restrictions.eq("leftorg", 0));
		List<Employee> probationersList = null;
		if(criteria.list()!=null)
			probationersList = criteria.list();
		session.close();
		return probationersList;
		
	}
	
	public List<Employee> getProbationersListForGroup(String groupName){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("isProbationer",AppraisalConstants.IS_PROBATIONER));
		//criteria.add(Restrictions.eq("Employee_Type",AppraisalConstants.EMPLOYEE_TYPE_PROBATION));
		criteria.add(Restrictions.eq("groupName",groupName));
		criteria.add(Restrictions.eq("leftorg", 0));
		List<Employee> probationersList = criteria.list();
		session.close();
		return probationersList;
	}
	
	public List<Employee> getProbationCompletedList(){
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee as employee,ProbationData as data where data.empCode=employee.employeeId and (data.form=:f1 or data.form=:f2 ) and data.status=:s");
		q.setParameter("f1", AppraisalConstants.PROBATION_EVALUATION_FORM);
		q.setParameter("f2", AppraisalConstants.PROBATION_FINAL_EVALUATION_FORM);
		q.setParameter("s", AppraisalConstants.STATUS_MANAGEMENT_COMPLETED);
		List<Employee> probationCompletedList = new ArrayList();
			Employee employee = new Employee();
			List <Object[]> objects = q.list();
			for(Object[] object:objects){
				employee = (Employee)object[0];
				probationCompletedList.add(employee);
			}
		
			//remove duplicates if any 
			Set setItems = new LinkedHashSet(probationCompletedList); 
			probationCompletedList.clear(); 
			probationCompletedList.addAll(setItems); 
		
		session.close();
		return probationCompletedList;
	}
	
	public List<Employee> getProbationCompletedListForGroup(String groupName){
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("from Employee as employee,ProbationData as data where data.empCode=employee.employeeId and (data.form=:f1 or data.form=:f2) and data.status=:s and employee.groupName=:g");
		q.setParameter("f1", AppraisalConstants.PROBATION_EVALUATION_FORM);
		q.setParameter("f2", AppraisalConstants.PROBATION_FINAL_EVALUATION_FORM);
		q.setParameter("s", AppraisalConstants.STATUS_MANAGEMENT_COMPLETED);
		q.setParameter("g", groupName);
		List<Employee> probationCompletedList = new ArrayList();
		Employee employee = new Employee();
		List <Object[]> objects = q.list();
		for(Object[] object:objects){
			employee = (Employee)object[0];
			probationCompletedList.add(employee);
		}
		//remove duplicates if any 
		Set setItems = new LinkedHashSet(probationCompletedList); 
		probationCompletedList.clear(); 
		probationCompletedList.addAll(setItems); 
		
		session.close();
		return probationCompletedList;
	}
	
	public List<Employee> getProbationCompletedListForManagers(int empId){
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee as employee,ProbationData as data where data.empCode=employee.employeeId and (data.form=:f1 or data.form=:f2) and data.status=:s and employee.manager=:m");
		q.setParameter("f1", AppraisalConstants.PROBATION_EVALUATION_FORM);
		q.setParameter("f2", AppraisalConstants.PROBATION_FINAL_EVALUATION_FORM);
		q.setParameter("s", AppraisalConstants.STATUS_MANAGEMENT_COMPLETED);
		q.setParameter("m", empId);
		
		List<Employee> probationCompletedList = new ArrayList();
		Employee employee = new Employee();
		List <Object[]> objects =q.list();
		for(Object[] object:objects){
			employee = (Employee)object[0];
			probationCompletedList.add(employee);
		}
		
		//remove duplicates if any 
		Set setItems = new LinkedHashSet(probationCompletedList); 
		probationCompletedList.clear(); 
		probationCompletedList.addAll(setItems); 
		session.close();
		return probationCompletedList;
	}
	
	public List<Employee> getPendingDecisionsListForManagement(){
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee as employee,ProbationData as data where data.empCode=employee.employeeId and (data.form=:f1 and data.status=:s1)");
		q.setParameter("f1", AppraisalConstants.PROBATION_EVALUATION_FORM);
		q.setParameter("s1", AppraisalConstants.STATUS_GH_COMPLETED);
		
		List<Employee> pendingDecisionsList = new ArrayList();
		Employee employee = new Employee();
		List <Object[]> objects = q.list();
		for(Object[] object:objects){
			employee = (Employee)object[0];
			pendingDecisionsList.add(employee);
		}
		session.close();
		return pendingDecisionsList;
	}
	
	public List<Employee> getPendingDecisionsListForHR(){
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee as employee,ProbationData as data where data.empCode=employee.employeeId  and data.form=:f1 and data.status=:s"
				+ " and employee.employeeId not in "
                +"(select distinct empCode from ProbationData where form !=:f2 or form !=:f3 )");
		
		q.setParameter("f1", AppraisalConstants.PROBATION_MID_TERM_FORM);
		q.setParameter("s", AppraisalConstants.STATUS_GH_COMPLETED);
		q.setParameter("f2", AppraisalConstants.PROBATION_EVALUATION_FORM);
		q.setParameter("f3", AppraisalConstants.PROBATION_FINAL_EVALUATION_FORM);
		List<Employee> pendingDecisionsList = new ArrayList();
		Employee employee = new Employee();
		List <Object[]> objects = q.list();
		for(Object[] object:objects){
			employee = (Employee)object[0];
			pendingDecisionsList.add(employee);
		}
		session.close();
		return pendingDecisionsList;
	}
	
	public List<Employee> getPendingDecisionsForManager(int empId){
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee as employee,ProbationData as data where data.empCode=employee.employeeId and employee.manager=:m and"
				+ " ((data.form=:f1 or data.form=:f2 or data.form=:f3 or data.form=:f4 or data.form=:f5 or data.form=:f6 or data.form=:f7) and data.status=:s1)");
		
		q.setParameter("m", empId);
		q.setParameter("f1", AppraisalConstants.PROBATION_MONTH1_FORM);
		q.setParameter("f2", AppraisalConstants.PROBATION_MONTH2_FORM);
		q.setParameter("f3", AppraisalConstants.PROBATION_MONTH3_FORM);
		q.setParameter("f4", AppraisalConstants.PROBATION_MONTH4_FORM);
		q.setParameter("f5", AppraisalConstants.PROBATION_MONTH5_FORM);
		q.setParameter("f6", AppraisalConstants.PROBATION_EXTENTION_MONTH1_FORM);
		q.setParameter("f7", AppraisalConstants.PROBATION_EXTENTION_MONTH2_FORM);
		q.setParameter("s1", AppraisalConstants.STATUS_SELF_COMPLETED);
		List<Employee> pendingDecisionsList = new ArrayList();
		Employee employee = new Employee();
		List <Object[]> objects = q.list();
		for(Object[] object:objects){
			employee = (Employee)object[0];
			pendingDecisionsList.add(employee);
		}
		// for delegations
		q = session.createQuery("from Employee as employee where employee.employeeId in"+
							"(select pd.empCode from ProbationData as pd, ProbationDelegationData as pdd "+
							"where pd.empCode=pdd.empCode and pd.form=pdd.form and pd.status=:s2 and pdd.delegatedTo=:d)");
		q.setParameter("s2", AppraisalConstants.STATUS_SELF_COMPLETED);
		q.setParameter("d", empId);
		List<Employee> employeesList = q.list();
		for(Employee employee1:employeesList){
			pendingDecisionsList.add(employee1);
		}
		session.close();
		return pendingDecisionsList;
	}
	
	public List<Employee> getPendingDecisionsListForGH(String groupName){
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee as employee,ProbationData as data where data.empCode=employee.employeeId and employee.groupName=:g and ( (data.form=:f1 or data.form=:f2 or data.form=:f3 or data.form=:f4) and data.status=:s)");
		q.setParameter("g", groupName);
		q.setParameter("f1", AppraisalConstants.PROBATION_EVALUATION_FORM);
		q.setParameter("f2", AppraisalConstants.PROBATION_MID_TERM_FORM);
		q.setParameter("f3", AppraisalConstants.PROBATION_EXTENSION_FORM);
		q.setParameter("f4", AppraisalConstants.PROBATION_FINAL_EVALUATION_FORM);
		q.setParameter("s", AppraisalConstants.STATUS_MANAGER_COMPLETED);
		List<Employee> pendingDecisionsList = new ArrayList();
		Employee employee = new Employee();
		List <Object[]> objects = q.list();
		for(Object[] object:objects){
			employee = (Employee)object[0];
			pendingDecisionsList.add(employee);
		}
		session.close();
		return pendingDecisionsList;
	}
	
	 public List<String> getGroupNamesUnderGH(int empId){
		 Session session = sessionFactory.openSession();
		 Criteria criteria = session.createCriteria(User_Role.class);
		 criteria.add(Restrictions.eq("empId", empId));
		 criteria.add(Restrictions.eq("roleId", AppraisalConstants.GH_ROLE_ID));
		 criteria.setProjection(Projections.projectionList().add(Projections.property("group")));
		 List<String> groupNames = (List<String>)criteria.list();
		 return groupNames;
	 }
	public List<Employee> getAllEmployees(){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("leftorg", 0));
		//criteria.setProjection(Projections.projectionList().add(Projections.property("employeeId")).add(Projections.property("employeeName")));
		criteria.addOrder(Order.asc("employeeName"));
		List<Employee> employeeList = (List<Employee>)criteria.list();
		session.close();
		return employeeList;
	}
	
	public Employee getEmployeeFromId(int empId){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("employeeId",empId));
		Employee employee = (Employee)criteria.uniqueResult();
		session.close();
		return employee;
	}
	
	public void createProbationEntry(int empId,String form,String status,int rating, int flag){
		
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProbationData.class);
		criteria.add(Restrictions.eq("empCode", empId));
		criteria.add(Restrictions.eq("form", form));
		ProbationData probationData = (ProbationData)criteria.uniqueResult();
		if(probationData!=null)
		{
			probationData.setStatus(status);
			if(flag==1)                              // flag=0 when we do not want to update rating and flag=1 when rating needs to be updated
				probationData.setRating(rating);
			session.saveOrUpdate(probationData);
			session.flush();
		}
		else{
			probationData = new ProbationData();
		    probationData.setEmpCode(empId);
		    probationData.setForm(form);
		    probationData.setStatus(status);
		    probationData.setRating(rating);
		    session.saveOrUpdate(probationData);
		}	
	    session.close();
	}

	

	public List<String> getTimesheetData(int empId,String fromDate) throws Exception{
		
		Session session = sessionFactory.openSession();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		Connection con = sessionImplementor.getJdbcConnectionAccess().obtainConnection();
	
		CallableStatement callableStatement = con.prepareCall("{call getTimesheetsbyEmpCode(?,?)}");
		callableStatement.setInt(1, empId);
		callableStatement.setString(2, fromDate);
	    callableStatement.execute();
	    ResultSet resultSet = callableStatement.getResultSet();
	    List<String> timesheetDataList = new ArrayList();
	    while(resultSet.next()){
	       	timesheetDataList.add(resultSet.getString(1));
	    }
	    return timesheetDataList;
   }
	
	
	
	public String getFormStatus(int empId,String form){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProbationData.class);
		criteria.add(Restrictions.eq("empCode", empId));
		criteria.add(Restrictions.eq("form",form));
		criteria.setProjection(Projections.projectionList().add(Projections.property("status")));
		String status = (String)criteria.uniqueResult();
		session.close();
		if(status!=null)
			return status;
		else
			return null;
	}
	
	
		
		public int getGroupHead(Employee employee){
		 try {
				String groupName = employee.getGroupName();
				String hql = "Select empId from User_Role where group = :group AND roleId = :roleId";
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				Query query = session.createQuery(hql);
				query.setParameter(AppraisalConstants.GROUP, groupName);
				query.setParameter(AppraisalConstants.ROLE_ID, 4);
				int GH_Id = 0;
				if(query.uniqueResult()!=null)
					GH_Id = (int) query.uniqueResult();
				session.getTransaction().commit();
				session.close();
				return GH_Id;
			} catch (Exception e) {
				return 0;
		  }
		}
		public List getHR(){
			String hql = "Select empId from User_Role where group = :group";
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(AppraisalConstants.GROUP, AppraisalConstants.HR_ROLE);
			return query.list();
		}
		
		public List getMgmt(){
			String hql = "Select empId from User_Role where group = :group";
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(AppraisalConstants.GROUP, AppraisalConstants.MGMT_ROLE);
			return query.list();
		}
		public String getCOOEmail(){
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("designation", AppraisalConstants.COO));
			criteria.setProjection(Projections.projectionList().add(Projections.property("Email_ID")));
			String email = null;
			if(criteria.uniqueResult()!=null)
				email = (String)criteria.uniqueResult();
			
			return email;	
		}
	
		
		public String getProbationReminderMailContent(String toName, String form, String probationerName){
			String fileContent = "";
			try{
				PropertyReader propReader = new PropertyReader();
				FileReader fileReader;
				if(probationerName!=null)
					fileReader = new FileReader(propReader.getPROBATION_REMINDER_TO_NEXT_LEVEL_MAIL_CONTENT());
				else
					fileReader = new FileReader(propReader.getPROBATION_REMINDER_MAIL_CONTENT());
			    int i ;
				while((i =  fileReader.read())!=-1){
				   char ch = (char)i;
				   fileContent = fileContent + ch; 
				  }
				fileContent = fileContent.replace("#toName",toName);
				fileContent = fileContent.replace("#form",form);
				fileContent = fileContent.replace("#probationerName", probationerName);
				fileContent = fileContent.replace("#probationAppraisalLink",propReader.getPROBATION_APPRAISAL_LINK());
			} catch (Exception e) {
				logger.info("ClassName: ProbationManager");
				logger.info("MethodName:getProbationFormDelegationtMailContent");
				logger.info("Mail not sent");
				logger.info(e);
			}
			 return fileContent;
			
		}
}

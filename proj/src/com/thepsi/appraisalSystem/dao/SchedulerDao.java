package com.thepsi.appraisalSystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.thepsi.appraisalSystem.model.Employee;
import com.thepsi.appraisalSystem.model.Employee_Manager;
import com.thepsi.appraisalSystem.model.User_Role;
import com.thepsi.appraisalSystem.util.AppraisalConstants;

public class SchedulerDao {
      
private SessionFactory sessionFactory;
	
	
	public SessionFactory getsessionFactory() {
		return sessionFactory;
	}
	public void setsessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
	

	
	/* Added by Aayushi
	 * To get Pending Self Appraisal 
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getPendingSelfAppraisal(int appCycleId)
	{
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: getPendingSelfAppraisal" );

		  String hql = "from  Employee " + 
		  		"where employeeId not in (select EMPID from Appraisal_Details where AppCycleId= ? and AppStatus != ?)" + 
		  		"and Employee_Type = ?" + 
		  		"";
		  Session session = sessionFactory.openSession();
		  logger.info("Finding Pending Self Appraisal Detail");
		  logger.info(hql);
	      session.beginTransaction();
		  
		  List<Employee> List = new ArrayList<Employee>();
		  
		  try{
		  List = session.createQuery(hql)
				  .setParameter(0,appCycleId )
				  .setParameter(1, AppraisalConstants.STATUS_NOT_STARTED)
				  .setParameter(2, AppraisalConstants.PERMANENT)
				  .list();
		  
		  }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		  
		  if (List.size() > 0) {
			  logger.info("Total no of Pending Self Appraisal Form"+List.size());
			  logger.info("close");
			  return List;
				
			} else {
				logger.info("No Self Appraisal Pending");
				return null;
			}
		  
	}

	/* Added by Aayushi
	 * To get Pending Manager Review 
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getPendingManagerReview(int appCycleId)
	{
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: getPendingManagerReview" );
		  
		  
		  /*String hql = "select * from  Employee where employeeId in(" + 
		  		" select manager from  Employee " + 
		  		" where employeeId in (select EMPID from Appraisal_Details where AppCycleId= ? and AppStatus = ?)" + 
		  		" and Employee_Type = ?)" ;*/
		  
		  String hql = " from  Employee " + 
			  		" where employeeId in (select EMPID from Appraisal_Details where AppCycleId = ? and AppStatus = ?)" + 
			  		" and Employee_Type = ?)" ;
		  		
		  Session session = sessionFactory.openSession();
		  logger.info("Finding Pending Manager Review Detail");
		  logger.info(hql);
	      session.beginTransaction();
		  
		  List<Employee> List = new ArrayList<Employee>();
		  
		  try{
		  List = session.createQuery(hql)
				  .setParameter(0,appCycleId )
				  .setParameter(1, AppraisalConstants.STATUS_SELF_COMPLETED)
				  .setParameter(2, AppraisalConstants.PERMANENT)
				  .list();
		  
		  }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		  
		  if (List.size() > 0) {
			  logger.info("Total no of Pending Self Appraisal Form"+List.size());
			  logger.info("close");
			  return List;
				
			} else {
				logger.info("No Self Appraisal Pending");
				return null;
			}
		  
	}
	
	
	/* Added by Aayushi
	 * To get Pending  Review 
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getPendingEmployeeList(int appCycleId, String Status)
	{
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: getPendingEmployeeList" );
		  
		  
		  /*String hql = "select * from  Employee where employeeId in(" + 
		  		" select manager from  Employee " + 
		  		" where employeeId in (select EMPID from Appraisal_Details where AppCycleId= ? and AppStatus = ?)" + 
		  		" and Employee_Type = ?)" ;*/
		  
		  String hql = " from  Employee " + 
			  		" where employeeId in (select EMPID from Appraisal_Details where AppCycleId = ? and AppStatus = ?)" + 
			  		" and Employee_Type = ?" ;
		  		
		  Session session = sessionFactory.openSession();
		  logger.info("Finding Pending Review Detail");
		  logger.info(hql);
	      session.beginTransaction();
		  
		  List<Employee> List = new ArrayList<Employee>();
		  
		  try{
		  List = session.createQuery(hql)
				  .setParameter(0,appCycleId )
				  .setParameter(1, Status)
				  .setParameter(2, AppraisalConstants.PERMANENT)
				  .list();
		  
		  }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		  
		  if (List.size() > 0) {
			  logger.info("Total no of Pending Form For Status:"+Status+" is"+List.size());
			  logger.info("close");
			  return List;
				
			} else {
				logger.info("No  Pending Forms For Status: "+Status);
				return null;
			}		  
	}

	/* Added by Aayushi
	 * To get Pending Manager Review 
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getPendingEmployeeListForManagerReview(int appCycleId, String Status)
	{
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: getPendingEmployeeListForManagerReview" );
		  
		  
		  /*String hql = "select * from  Employee where employeeId in(" + 
		  		" select manager from  Employee " + 
		  		" where employeeId in (select EMPID from Appraisal_Details where AppCycleId= ? and AppStatus = ?)" + 
		  		" and Employee_Type = ?)" ;*/
		  
		  String hql = " from  Employee " + 
			  		" where employeeId in (select EMPID from Appraisal_Details where AppCycleId = ? "
			  		+ " and (AppStatus = ? or AppStatus = ? or AppStatus = ?))" + 
			  		" and Employee_Type = ?" ;
		  		
		  Session session = sessionFactory.openSession();
		  logger.info("Finding Pending Review Detail");
		  logger.info(hql);
	      session.beginTransaction();
		  
		  List<Employee> List = new ArrayList<Employee>();
		  
		  try{
		  List = session.createQuery(hql)
				  .setParameter(0,appCycleId )
				  .setParameter(1, Status)
				  .setParameter(2,AppraisalConstants.STATUS_ADDITIONAL1_COMPLETED)
				  .setParameter(3, AppraisalConstants.STATUS_ADDITIONAL2_COMPLETED)
				  .setParameter(4, AppraisalConstants.PERMANENT)
				  .list();
		  
		  }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		  
		  if (List.size() > 0) {
			  logger.info("Total no of Pending Form For Status:"+Status+" is"+List.size());
			  logger.info("close");
			  return List;
				
			} else {
				logger.info("No  Pending Forms For Status: "+Status);
				return null;
			}	  
	}
	
	/* Added by Aayushi
	 * To get Pending Manager Review 
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getPendingEmployeeListForAdditionalReview(int appCycleId,int empId)
	{
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: getPendingEmployeeListForAdditionalReview" );
		  
		  
		  /*String hql = "select * from  Employee where employeeId in(" + 
		  		" select manager from  Employee " + 
		  		" where employeeId in (select EMPID from Appraisal_Details where AppCycleId= ? and AppStatus = ?)" + 
		  		" and Employee_Type = ?)" ;*/
		  
		  String hql = " from  Employee " + 
			  		" where employeeId in (select EMPID from Appraisal_Details where AppCycleId = ? and AppStatus = ?"
			  		+ " and ((AR_Id = ? or AR2_Id = ?)))" + 
			  		" and Employee_Type = ?" ;
		  		
		  Session session = sessionFactory.openSession();
		  logger.info("Finding Pending Additional Manager Review Detail");
		  logger.info(hql);
	      session.beginTransaction();
		  
		  List<Employee> List = new ArrayList<Employee>();
		  
		  try{
		  List = session.createQuery(hql)
				  .setParameter(0,appCycleId )
				  .setParameter(1, AppraisalConstants.STATUS_SELF_COMPLETED)
				  .setParameter(2, empId)
				  .setParameter(3, empId)
				  .setParameter(4, AppraisalConstants.PERMANENT)
				  .list();
		  
		  }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		  
		  if (List.size() > 0) {
			  logger.info("Total no of Pending Form For Status:"+AppraisalConstants.STATUS_SELF_COMPLETED+" is"+List.size());
			  logger.info("close");
			  return List;
				
			} else {
				logger.info("No  Pending Forms For Status: "+AppraisalConstants.STATUS_SELF_COMPLETED);
				return null;
			}	  
	}

	/* Added by Aayushi
	 * To get All Manager Details 
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getManagerList()
	{
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: getManagerList" );
		  
		  
		  /*String hql = "select * from  Employee where employeeId in(" + 
		  		" select manager from  Employee " + 
		  		" where employeeId in (select EMPID from Appraisal_Details where AppCycleId= ? and AppStatus = ?)" + 
		  		" and Employee_Type = ?)" ;*/
		  
		  String hql = " from  Employee " + 
			  		" where employeeId in (select distinct manager from Employee)" + 
			  		" and Employee_Type = ?" ;
		  		
		  Session session = sessionFactory.openSession();
		  logger.info("Finding Manager Detail");
		  logger.info(hql);
	      session.beginTransaction();
		  
		  List<Employee> List = new ArrayList<Employee>();
		  try{
		  List = session.createQuery(hql)
				 
				  .setParameter(0, AppraisalConstants.PERMANENT)
				  .list();
		  
		  }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		  
		  if (List.size() > 0) {
			  logger.info("Total no of Managers"+" is"+List.size());
			  logger.info("close");
			  return List;
				
			} else {
				logger.info("No  Manager Found");
				return null;
			} 
	}
	
	/* Added by Aayushi
	 * To get Pending Team Review 
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getPendingEmployeeListForTeamReview(int appCycleId, String Status,List<Integer> empList)
	{
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: getPendingEmployeeListForTeamReview" );
		  
		  
		  String hql = " from  Employee " + 
			  		" where employeeId in (select EMPID from Appraisal_Details where AppCycleId = ? and AppStatus = ?)" + 
			  		" and Employee_Type = ?"
			  		+ "  and employeeId in(:idList)" ;
		  		
		  Session session = sessionFactory.openSession();
		  logger.info("Finding Pending Manager Review Detail");
		  logger.info(hql);
	      session.beginTransaction();
		  
		  List<Employee> List = new ArrayList<Employee>();
		  
		  try{
		  List = session.createQuery(hql)
				  .setParameter(0,appCycleId )
				  .setParameter(1, Status)
				  .setParameter(2, AppraisalConstants.PERMANENT)
				  .setParameterList("idList", empList)
				  .list();
		  
		  }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		  
		  if (List.size() > 0) {
			  logger.info("Total no of Pending Form For Status:"+Status+" is"+List.size());
			  logger.info("close");
			  return List;
				
			} else {
				logger.info("No  Pending Forms For Status: "+Status);
				return null;
			}
		  
	}
	/* Added by Aayushi
	 * To get Employee Details from Employee table
	 */
	@SuppressWarnings("unchecked")
	public Employee findEmployeeByEmpId(int EmpId)
	{     
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: findEmployeeByEmpId" );
		 
		  String hql = "from Employee where employeeId=?";
		  Session session = sessionFactory.openSession();
	      session.beginTransaction();
		  
	      List<Employee> empList = new ArrayList<Employee>();
	      try{
		  empList = session.createQuery(hql).setParameter(0, EmpId).list();
		  
	      }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		 
		  if (empList.size() > 0) {
			  logger.info("Employee Found");
			  
			  
				return empList.get(0);
				
			} else {
				logger.info("Employee Not Found");
				return null;
			}
	}

	/* Added by Aayushi
	 * To get Employee Details of ALL AGH/GHfrom Employee table
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> findEmployeeByRoleId(int roleId)
	{     
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: findEmployeeByRoleId" );
		 
		  String hql = "from Employee where employeeId in( select empId from User_Role where roleId = ? )";
		  Session session = sessionFactory.openSession();
	      session.beginTransaction();
		  
	      List<Employee> empList = new ArrayList<Employee>();
	      try{
		  empList = session.createQuery(hql).setParameter(0, roleId).list();
		  
	      }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		 
		  if (empList.size() > 0) {
			  logger.info("Total No of employees for RoleID:" +roleId+" is:"+empList.size());
			  
			  
				return empList;
				
			} else {
				logger.info("Employee Not Found for RoleID:" +roleId);
				return null;
			}

	}

	/* Added by Aayushi
	 * Find employee under manager/AGH  by mangerId
	 */
	
	/*public List<Employee_Manager> findEmployeeUnderAGHByEmpID(int empId)
	{     
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: findEmployeeUnderManagerByEmpID" );
		 
		  String hql = "With cte as ( select Employees_Id, manager,Employee_name  from employee union all select c.Employees_Id,e.manager, c.Employee_name from cte c join employee e on (c.manager=e.Employees_Id)) select * from cte where manager =? option (maxrecursion 0)";
		  Session session = sessionFactory.openSession();
	      session.beginTransaction();
		  
	      List empList = new ArrayList();
	      List<Employee_Manager> emplManager = new ArrayList<Employee_Manager>();
		  
	      try{
	      empList = session.createSQLQuery(hql)
	    		  .addScalar("Employees_Id")
	    		  .addScalar("manager").addScalar("Employee_name").setParameter(0,empId)
	    		  .setResultTransformer( Transformers.aliasToBean(Employee_Manager.class))
	    		  .list();
		  
	     
	      
	      
	      }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		 
		  if (empList.size() > 0) {
			  logger.info("Employee Found under EmpID:"+empId);
			  
			  for(int i=0;i<empList.size();i++)
		      {
		    	  Employee_Manager em =(Employee_Manager)empList.get(i);
		    	  emplManager.add(em);
		      }
				return emplManager;
				
			} else {
				logger.info("Employee Not Found under EmpID:"+empId);
				return null;
			}
		  
   }*/
	
	/* Added by Aayushi
	 * Find employee by groupName
	 */
	@SuppressWarnings("unchecked")
	public List findEmployeeBygroupName(String groupName)
	{     
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: findEmployeeBygroupName" );
		  String hql = "select Employees_Id from employee where group_name = ? and Employee_Type = ?";
		  Session session = sessionFactory.openSession();
	      session.beginTransaction();
		  
	      
		  String empType="Permanent";
		  List empList = new ArrayList();
		  try{
	      empList = session.createSQLQuery(hql).setParameter(0, groupName).setParameter(1, empType).list();
		  }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
	      if (empList.size() > 0) {
			  logger.info("Employee Found For GroupName: "+groupName);
			  return empList;
	      }
	      else
	      {
	    	  logger.info("Employee Not Found For GroupName: "+groupName);
			  return null;
	      }
	      
	}
	
	/* Added by Aayushi
	 * Find employee under manager  by mangerId
	 */
	@SuppressWarnings("unchecked")
	public List<User_Role> findUserRoleByRoleAndEmpId(int empId, int roleId )
	{     
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: findUserRoleByRoleandEmpId" );
		  String hql = " from User_Role where empId = ? and roleId =?";
		  Session session = sessionFactory.openSession();
	      session.beginTransaction();
		  
	      List<User_Role> empList = new ArrayList<>();
		  
		  try{
	      empList = session.createQuery(hql)
	    		  .setParameter(0, empId)
	    		  .setParameter(1, roleId)
	    		  .list();
		  }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
		  
	      if (empList.size() > 0) {
			  logger.info("Total Roles"+empList.size());
			  return empList;
	      }
	      else
	      {
	    	  logger.info("No Role");
			  return null;
	      }      
	}

	/* Added by Aayushi
	 * Find employee under Manager  by empId
	 */
	@SuppressWarnings("unchecked")
	public List findEmployeeUnderManagerDirect(int manager)
	{     
		  logger.info("CLASSNAME: SchedulerDao");
		  logger.info("METHODNAME: findEmployeeUnderManagerDirect" );
		  String hql = "select Employees_Id from employee where manager = ? and Employee_Type =?";
		  Session session = sessionFactory.openSession();
	      session.beginTransaction();
		  
	      
		  String empType="Permanent";
		  List empList = new ArrayList();
		  try{
	      empList = session.createSQLQuery(hql)
	    		  .setParameter(0, manager)
	    		  .setParameter(1, empType).list();
		  }catch(Exception e)
		  {  
			 
			 logger.debug("Error", e); 
		  }finally{
			  session.close(); 
		  }
	      if (empList.size() > 0) {
			  logger.info("Employee Found Under Manager"+manager);
			  return empList;
	      }
	      else
	      {
	    	  logger.info("Employee Not Found Under Manager"+manager);
			  return null;
	      }
	}
}

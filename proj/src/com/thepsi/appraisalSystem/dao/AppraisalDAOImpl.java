package com.thepsi.appraisalSystem.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.thepsi.appraisalSystem.model.Employee;
import com.thepsi.appraisalSystem.model.Employee_Manager;
import com.thepsi.appraisalSystem.model.ManagerDetails;

import com.thepsi.appraisalSystem.model.RoleMaster;
import com.thepsi.appraisalSystem.model.TELPP_IMPACT_DETAILS;
import com.thepsi.appraisalSystem.model.User_Role;
import com.thepsi.appraisalSystem.util.AppraisalConstants;

@Repository
public class AppraisalDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;
	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * public void submitAppraisalCycle(AppraisalCycle appraisalCycle){ Session
	 * session = sessionFactory.openSession(); session.beginTransaction();
	 * session.save(appraisalCycle); session.close(); return; }
	 */

	/*
	 * Added by Aayushi To find Employee from Employee table by EmailId
	 */
	@SuppressWarnings("unchecked")
	public Employee findEmployeeByMailId(String EmailId) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:findEmployeeByMailId");

		String hql = "from Employee where EMail_ID=?";
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		List<Employee> empList = new ArrayList<Employee>();
		empList = session.createQuery(hql).setParameter(0, EmailId).list();

		session.close();

		if (empList.size() > 0) {
			logger.info(empList.get(0).getEmployeeName());
			logger.info(empList.get(0).getDate_of_joining());
			logger.info("close");
			return empList.get(0);

		} else {
			return null;
		}

	}

	/*
	 * Added by Aayushi To check if current Employee is Manager from Employee
	 * table
	 */
	@SuppressWarnings("unchecked")
	public Employee findManagerByEmpId(int EmpId) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:findManagerByEmpId");

		String hql = "from Employee where manager=?";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Employee> empList = new ArrayList<Employee>();
		empList = session.createQuery(hql).setParameter(0, EmpId).list();

		session.close();

		if (empList.size() > 0) {
			logger.info("Manager Found");

			return empList.get(0);

		} else {
			logger.info("Manager Not Found");
			return null;
		}

	}

	/*
	 * Added by Aayushi To find additional Manager Details from
	 * Appraisal_Details table
	 */


	/*
	 * Added by Aayushi To get User_Role from User_Role table
	 */

	@SuppressWarnings("unchecked")
	public List<User_Role> getUserRoleByEmpId(int EmpId) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:getUserRoleByEmpId");

		String hql = "from User_Role where EmpID=?";
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		List<User_Role> empList = new ArrayList<User_Role>();
		empList = session.createQuery(hql).setParameter(0, EmpId).list();

		session.close();

		if (empList.size() > 0) {
			logger.info(empList.size());
			logger.info("User Role");
			logger.info(empList.get(0).getEmpId());
			logger.info(empList.get(0).getRoleId());
			/*
			 * logger.info("Second Role");
			 * logger.info(empList.get(1).getEmpId());
			 * logger.info(empList.get(1).getRoleId());
			 */
			logger.info("close");
			return empList;

		} else {
			logger.info("No User Role");
			return null;
		}
		// return empList;
	}



	/*
	 * Added by Aayushi Called To save APP_USER_ACTION_HISTORY
	 */

	public void createUserRoleTable(User_Role userRole) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:createUserRoleTable");
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(userRole);
		tran.commit();
		session.close();
		return;
	}

	/*
	 * Added by Aayushi To find all employee under Manager from Employee table
	 */
	//vartika
	@SuppressWarnings("unchecked")
	public List<Employee> findEmployeeByManagerID(int empId) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:findEmployeeByManagerName");

        String hql = "from Employee where manager=?";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

        List empList = new ArrayList();
        empList = session.createQuery(hql)
                         .setParameter(0, empId).list();
		session.close();

		if (empList.size() > 0) {
			logger.info("Employee Found");

			return empList;

		} else {
			logger.info("Employee Not Found");
			return null;
		}

	}

	/*
	 * Added by Aayushi To find rating from rating Master table
	 */



	/*
	 * Added by Aayushi Agarwal to Enable Self AppraisalForm Used when SendBack
	 * by user
	 */
	public void enableSelfAppraisalForm(int EmpId, int AppCycleId) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:enableSelfAppraisalForm");
		String hql = "update Appraisal_Details set AppStatus=? and isAppEnabled =? where EMPID=? AND AppCycleId=? ";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql).setParameter(0, AppraisalConstants.STATUS_NOT_STARTED)
				.setParameter(1, AppraisalConstants.SELF_REVIEW_ENABLE).setParameter(2, EmpId)
				.setParameter(3, AppCycleId);
		int i = query.executeUpdate();
		session.getTransaction().commit();
		if (i != 0) {
			logger.info("Successfully Enable Self AppraisalForm");
		}
	}

	/*
	 * Added by Aayushi Agarwal to update Normalized Rating Used when Normalized
	 * Rating is set
	 */
	public void updateNormalizedRating(int EmpId, int AppCycleId, String normalizedRating) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:updateNormalizedRating");
		String hql = "update Appraisal_Details set Normalized_Rating =? where EMPID=? AND AppCycleId=? ";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql).setParameter(0, normalizedRating).setParameter(1, EmpId).setParameter(2,
				AppCycleId);
		int i = query.executeUpdate();
		session.getTransaction().commit();
		if (i != 0) {
			logger.info("Successfully Update Normalized Rating for EmpId:" + EmpId);
		}
	}

	/*
	 * Added by Aayushi Find EmployeeDetails by EmpId
	 */
	@SuppressWarnings("unchecked")
	public Employee findEmployeeByEmpID(int empId) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:findEmployeeByEmpID");

		String hql = "from Employee where Employees_Id=?";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Employee> empList = new ArrayList<Employee>();
		empList = session.createQuery(hql).setParameter(0, empId).list();

		session.close();

		if (empList.size() > 0) {
			logger.info("Employee Found");

			return empList.get(0);

		} else {
			logger.info("Employee Not Found");
			return null;
		}

	}

	/*
	 * Added by Aayushi Find employee under manager by mangerId
	 */
	// vartika
	public List<Employee_Manager> findEmployeeUnderManagerByEmpID(int empId) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:findEmployeeUnderManagerByEmpID");

		//String hql = "With cte as ( select Employees_Id, manager,Employee_name  from employee union all select c.Employees_Id,e.manager, c.Employee_name from cte c join employee e on (c.manager=e.Employees_Id)) select * from cte where manager =? option (maxrecursion 0)";
		String hql = "WITH cte (Employees_Id, manager,Employee_name) as  (SELECT Employees_Id, manager,Employee_name  FROM employee where manager=?  UNION ALL  SELECT  e.Employees_Id, e.Manager, e.Employee_name   FROM employee AS e  INNER JOIN cte ON e.Manager = cte.Employees_Id)  SELECT  Employees_Id, manager,Employee_name FROM cte order by manager  option (maxrecursion 0)";
				
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/*
		 * List empList = new ArrayList(); empList =
		 * session.createSQLQuery(hql).setParameter(0, 135).list();
		 * System.out.println(empList);
		 */

		List empList = session.createSQLQuery(hql).addScalar("Employees_Id").addScalar("manager")
				.addScalar("Employee_name").setParameter(0, empId)
				.setResultTransformer(Transformers.aliasToBean(Employee_Manager.class)).list();
		List<Employee_Manager> emplManager = new ArrayList<Employee_Manager>();

		session.close();

		if (empList.size() > 0) {
			logger.info("Employee Found");

			for (int i = 0; i < empList.size(); i++) {
				Employee_Manager em = (Employee_Manager) empList.get(i);
				emplManager.add(em);
			}
			return emplManager;

		} else {
			logger.info("Employee Not Found");
			return null;
		}

	}


	/*
	 * Added by Aayushi Find employee under manager by mangerId
	 */
	@SuppressWarnings("unchecked")
	public List findEmployeeUnderManagerDirect(int manager) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:findEmployeeUnderManagerDirect");
		String hql = "select Employees_Id from employee where manager = ? and Employee_Type =?";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String empType = "Permanent";

		List empList = session.createSQLQuery(hql).setParameter(0, manager).setParameter(1, empType).list();
		session.close();
		if (empList.size() > 0) {
			logger.info("Employee Found");
			return empList;
		} else {
			logger.info("Employee Not Found");
			return null;
		}

	}

	/*
	 * Added by Aayushi Find employee by groupName
	 */
	@SuppressWarnings("unchecked")
	public List findEmployeeBygroupName(String groupName) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:findEmployeeBygroupName");
		String hql = "select Employees_Id from employee where group_name = ? and Employee_Type = ?";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String empType = "Permanent";

		List empList = session.createSQLQuery(hql).setParameter(0, groupName).setParameter(1, empType).list();
		session.close();
		if (empList.size() > 0) {
			logger.info("Employee Found");
			return empList;
		} else {
			logger.info("Employee Not Found");
			return null;
		}

	}

	/*
	 * Added by Aayushi Find employee under manager by mangerId
	 */
	/*@SuppressWarnings("unchecked")
	public List<Appraisee_Sorted> findEmployeeUnderAGHDesc(int appCycleId, List<Integer> empLists) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:findEmployeeUnderAGHDesc");
		logger.info(empLists);

		
		 * String hql =
		 * "with myQuery as  (select EMPID, EmployeeName, AppStatus ,AppCycleId, asm.StatusID from APPRAISAL_DETAIL ad,APP_STATUS_MASTER asm  where ad.AppStatus = asm.Status and AppCycleId=? ) select e.Employees_Id , e.Employee_name, d.AppStatus ,d.AppCycleId,e.Employee_Type,d.StatusID from employee e  left join myQuery d on e.Employees_Id =d.EMPID  where e.Employee_Type=? and e.Employees_Id in(?) order by d.StatusID desc"
		 * ;
		 
		String hql = "with myQuery as  (select EMPID, EmployeeName, AppStatus ,AppCycleId, asm.StatusID from APPRAISAL_DETAIL ad,APP_STATUS_MASTER asm  where ad.AppStatus = asm.Status and AppCycleId=? )select e.Employees_Id , e.Employee_name, d.AppStatus ,d.AppCycleId,e.Employee_Type,d.StatusID from employee e  left join myQuery d on e.Employees_Id =d.EMPID  where e.Employee_Type=? and e.Employees_Id in(:ids) order by d.StatusID desc";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String empType = "Permanent";

		List empList = session.createSQLQuery(hql).addScalar("Employees_Id").addScalar("Employee_name")
				.addScalar("AppStatus").addScalar("AppCycleId").addScalar("Employee_Type").addScalar("StatusID")
				.setParameter(0, appCycleId).setParameter(1, empType).setParameterList("ids", empLists)
				.setResultTransformer(Transformers.aliasToBean(Appraisee_Sorted.class)).list();

		List<Appraisee_Sorted> emplManager = new ArrayList<Appraisee_Sorted>();
		// logger.info("emplManager"+emplManager);

		session.close();

		if (empList.size() > 0) {
			logger.info("Employee Found");

			for (int i = 0; i < empList.size(); i++) {
				Appraisee_Sorted em = (Appraisee_Sorted) empList.get(i);
				emplManager.add(em);
			}
			return emplManager;

		} else {
			logger.info("Employee Not Found");
			return null;
		}

	}*/

	/*
	 * Added by Aayushi getRoleFrom Role Master
	 */
	@SuppressWarnings("unchecked")
	public RoleMaster getRoleFromRoleMaster(String role) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:getRoleFromRoleMaster");

		String hql = "select RoleID from ROLE_MASTER where Role=?";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List roleList = session.createSQLQuery(hql).addScalar("RoleID").setParameter(0, role)
				.setResultTransformer(Transformers.aliasToBean(RoleMaster.class)).list();

		session.close();

		if (roleList.size() > 0) {
			logger.info("Role ID found");

			RoleMaster roleMaster = new RoleMaster();
			// logger.info("emplManager"+emplManager);

			roleMaster = (RoleMaster) roleList.get(0);
			return roleMaster;

		} else {
			logger.info("Role ID Not found");
			return null;
		}

	}

	/*
	 * Added by Aayushi getTELPP Imapact Info from TELP Master
	 * Updated By Shubhi - added band achieved.
	 */
	@SuppressWarnings("unchecked")
	public TELPP_IMPACT_DETAILS getTELPPImapactInfo(int empId) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:getTELPPImapactInfo");

		String hql = "select TELPP,IMPACT,IMPACT2,BAND_ACHIEVED from TELPP_IMPACT_STATUS where EMP_ID=?";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List telpList = session.createSQLQuery(hql).addScalar("TELPP").addScalar("IMPACT").addScalar("IMPACT2").addScalar("BAND_ACHIEVED")
				.setParameter(0, empId).setResultTransformer(Transformers.aliasToBean(TELPP_IMPACT_DETAILS.class))
				.list();

		session.close();

		if (telpList.size() > 0) {
			logger.info("Telpp List found");

			TELPP_IMPACT_DETAILS telppDetails = new TELPP_IMPACT_DETAILS();
			// logger.info("emplManager"+emplManager);

			telppDetails = (TELPP_IMPACT_DETAILS) telpList.get(0);
			return telppDetails;

		} else {
			logger.info("Telpp List Not found");
			return null;
		}

	}

	/*
	 * Added by Aayushi Find employee under manager by mangerId
	 */
	@SuppressWarnings("unchecked")
	public List<ManagerDetails> getAllManagerList(int manager) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:getAllManagerList");

		String hql = "select distinct Reporting_Manager_Name,manager from employee where manager!=?";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List empList = session.createSQLQuery(hql).addScalar("manager").addScalar("Reporting_Manager_Name")
				.setParameter(0, manager).setResultTransformer(Transformers.aliasToBean(ManagerDetails.class)).list();

		List<ManagerDetails> emplManager = new ArrayList<ManagerDetails>();

		for (int i = 0; i < empList.size(); i++) {
			ManagerDetails em = (ManagerDetails) empList.get(i);
			emplManager.add(em);
		}
		session.close();

		if (emplManager.size() > 0) {
			logger.info("Employee Found");

			return emplManager;

		} else {
			logger.info("Employee Not Found");
			return null;
		}

	}

	/*
	 * Added by Aayushi Find employee by groupName
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeByGroupName(String groupName) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:getEmployeeByGroupName");

		String hql = "from Employee where group_name=?";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Employee> empList = new ArrayList<Employee>();
		empList = session.createQuery(hql).setParameter(0, groupName).list();

		session.close();

		if (empList.size() > 0) {
			logger.info("Employee Found");

			return empList;

		} else {
			logger.info("Employee Not Found");
			return null;
		}
	}

	/*
	 * Added by Aayushi Find employee by EmpId
	 */
	@SuppressWarnings("unchecked")
	public String getEmployeeNameByEmpId(int EmpId) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:getEmployeeNameByEmpId");

		String hql = "select Employee_name from employee where Employees_Id=?";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List empList = new ArrayList();
		empList = session.createSQLQuery(hql).setParameter(0, EmpId).list();

		session.close();

		if (empList.size() > 0) {
			logger.info("Employee Found");

			return (String) empList.get(0);

		} else {
			logger.info("Employee Not Found");
			return null;
		}
	}

	


	@SuppressWarnings("finally")
	public Boolean updateAppraisalCycle(HttpServletRequest request, HttpSession httpSession) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:updateAppraisalCycle");
		Boolean flag = false;
		Session session = null;
		String editFromMonth = (String) httpSession.getAttribute(AppraisalConstants.EDIT_FROM_MONTH);
		String editFromYear = (String) httpSession.getAttribute(AppraisalConstants.EDIT_FROM_YEAR);
		String editToMonth = (String) httpSession.getAttribute(AppraisalConstants.EDIT_TO_MONTH);
		String editToYear = (String) httpSession.getAttribute(AppraisalConstants.EDIT_TO_YEAR);
		String editFromDate = (String) httpSession.getAttribute(AppraisalConstants.EDIT_FROM_DATE);

		String editToDate = request.getParameter("editToDate");
		String editSelfReviewDate = request.getParameter("editSelfReviewDate");
		String editManagerReviewDate = request.getParameter("editManagerReviewDate");
		String editAdditionalReviewDate = request.getParameter("editAdditionalReviewDate");
		String editSecondReviewDate = request.getParameter("editSecondLevelReviewDate");
		String editHRCommentsDate = request.getParameter("editHRCommentsDate");
		String editManagementCommentsDate = request.getParameter("editManagementCommentsDate");

		int Id = (int) httpSession.getAttribute(AppraisalConstants.ID);
		String hql = "update AppraisalCycle set fromMonth = :fromMonth, fromYear = :fromYear,"
				+ "toMonth = :toMonth, toYear = :toYear, fromDate = :fromDate, toDate = :toDate, selfReviewDate = :selfReviewDate,"
				+ "managerReviewDate = :managerReviewDate, additionalReviewDate = :additionalReviewDate, "
				+ "secondLevelReviewDate = :secondLevelReviewDate,  hrCommentsDate = :hrCommentsDate, managementCommentsDate = :managementCommentsDate where id = :id";
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("fromMonth", editFromMonth);
			query.setParameter("fromYear", editFromYear);
			query.setParameter("toMonth", editToMonth);
			query.setParameter("toYear", editToYear);
			query.setParameter("fromDate", editFromDate);
			query.setParameter("toDate", editToDate);
			query.setParameter("selfReviewDate", editSelfReviewDate);
			query.setParameter("managerReviewDate", editManagerReviewDate);
			query.setParameter("additionalReviewDate", editAdditionalReviewDate);
			query.setParameter("secondLevelReviewDate", editSecondReviewDate);
			query.setParameter("hrCommentsDate", editHRCommentsDate);
			query.setParameter("managementCommentsDate", editManagementCommentsDate);
			query.setParameter("id", Id);
			query.executeUpdate();
			session.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			logger.info("ClassName: AppraisalDAOImpl");
			logger.info("MethodName: updateAppraisalCycle");
			logger.info("Appraisal Not updated");
		} finally {
			session.close();
			return flag;
		}
	}

	public void completeAppraisalCycle() {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:completeAppraisalCycle");
		String hql = "update AppraisalCycle set status = :status";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.STATUS, AppraisalConstants.COMPLETE);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return;
	}

	/* To get list of groups */
	public ArrayList<String> getListOfGroups() {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getListOfGroups");
		String hql = "select distinct  groupName from Employee";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		ArrayList<String> listOfGroups = (ArrayList<String>) query.list();
		session.getTransaction().commit();
		session.close();
		return listOfGroups;
	}

	/* To get list of managers by group name */
	public ArrayList<String> getListOfManagersByGroup(String group) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getListOfManagersByGroup");
		String hql = "select distinct Reporting_Manager_Name from Employee where groupName = :groupName";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.GROUP_NAME, group);
		ArrayList<String> listOfManager = (ArrayList<String>) query.list();
		session.getTransaction().commit();
		session.close();
		return listOfManager;

	}

	/* To get list of employee by name */
	@SuppressWarnings("unchecked")
	public List<String> getListOfEmployeeByName(String empName) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getListOfEmployeeByName");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.ilike("employeeName", empName + "%"));
		criteria.setMaxResults(5);
		return criteria.list();
	}


	public ArrayList<String> getListOfStatus() {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getListOfStatus");
		String hql = "select status from AppraisalStatus";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		ArrayList<String> appraisalStatusList = (ArrayList<String>) query.list();
		session.getTransaction().commit();
		session.close();
		return appraisalStatusList;
	}

	public ArrayList<Employee> getAllEmployeesByGroupName(String groupName) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getAllEmployeesByGroupName");
		String hql = "from Employee where groupName = :groupName";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.GROUP_NAME, groupName);
		ArrayList<Employee> employeeList = (ArrayList<Employee>) query.list();
		session.getTransaction().commit();
		session.close();
		return employeeList;

	}

	public ArrayList<Employee> getAppraiseeList(int appCycleId, String groupName) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getAppraiseeList");
		String hql = "from Employee as e where e.employeeId not in ("
				+ "select d.EMPID from Appraisal_Details as d where d.AppCycleId = :appCycleId) and e.Employee_Type = :empType and e.groupName = :groupName";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.EMPLOYEE_TYPE, AppraisalConstants.PERMANENT);
		query.setParameter(AppraisalConstants.APP_CYCLE_ID, appCycleId);
		query.setParameter(AppraisalConstants.GROUP_NAME, groupName);
		ArrayList<Employee> employeeList = (ArrayList<Employee>) query.list();
		session.getTransaction().commit();
		session.close();
		return employeeList;
	}

	public ArrayList<Employee> getAllEmployees() {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getAllEmployees");
		String hql = "from Employee";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		ArrayList<Employee> allEmployees = (ArrayList<Employee>) query.list();
		session.getTransaction().commit();
		session.close();
		return allEmployees;
	}






	public Employee getEmployeeByID(int empId) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getEmployeeByID");
		String hql = "from Employee where employeeId = :empId";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.EMPLOYEE_ID, empId);
		Employee employee = (Employee) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return employee;
	}

	public ArrayList<Employee> getAppraiseeList(int appCycleId) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getAppraiseeList");
		String hql = "from Employee as e where e.employeeId not in ("
				+ "select d.EMPID from Appraisal_Details as d where d.AppCycleId = :appCycleId) and e.Employee_Type = :empType";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.EMPLOYEE_TYPE, AppraisalConstants.PERMANENT);
		query.setParameter(AppraisalConstants.APP_CYCLE_ID, appCycleId);
		ArrayList<Employee> employeeList = (ArrayList<Employee>) query.list();
		session.getTransaction().commit();
		session.close();
		return employeeList;
	}

	public ArrayList<Employee> getAppraiseeListByGroups(int appCycleId, List<String> listOfGroups) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getAppraiseeList");
		String hql = "from Employee as e where e.employeeId not in ("
				+ "select d.EMPID from Appraisal_Details as d where d.AppCycleId = :appCycleId) and e.Employee_Type = :empType and groupName in (:groupName) ";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.EMPLOYEE_TYPE, AppraisalConstants.PERMANENT);
		query.setParameter(AppraisalConstants.APP_CYCLE_ID, appCycleId);
		query.setParameterList(AppraisalConstants.GROUP_NAME,listOfGroups);
		ArrayList<Employee> employeeList = (ArrayList<Employee>) query.list();
		session.getTransaction().commit();
		session.close();
		return employeeList;
	}
	
	

	public ArrayList<Integer> getRoleId(int empId) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getRoleId");
		String hql = "select roleId from User_Role where empId = :empId";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.EMPLOYEE_ID, empId);
		ArrayList<Integer> roleIdList = (ArrayList<Integer>) query.list();
		session.getTransaction().commit();
		session.close();
		return roleIdList;

	}

	public ArrayList<String> getRole(int empId) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getRole");
		ArrayList<Integer> roleList = getRoleId(empId);
		Iterator<Integer> roleIterator = roleList.iterator();
		ArrayList<String> roles = new ArrayList<String>();
		String hql = "select role from Role_Master where roleId = :roleId";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		while (roleIterator.hasNext()) {
			query.setParameter(AppraisalConstants.ROLE_ID, roleIterator.next());
			roles.addAll((ArrayList<String>) query.list());
		}
		session.getTransaction().commit();
		session.close();
		return roles;
	}

	/*
	 * public Employee getEmployeeReporter(Employee appraisee){
	 * logger.info("ClassName:AppraisalDAOImpl");
	 * logger.info("MethodName:getEmployeeReporter"); int managerId =
	 * appraisee.getManager(); ArrayList<String> roles = getRole(managerId);
	 * Employee employee = getEmployeeByID(managerId);
	 * while((!roles.contains((AppraisalConstants.AGH))&&(!roles.contains((
	 * AppraisalConstants.GH))))){ employee =
	 * getEmployeeByID(employee.getManager());
	 * 
	 * roles = getRole(employee.getManager()); } return employee; }
	 */

	/* To get GH of an employee by department */

	public Employee getEmployeeGH(Employee appraisee) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getEmployeeGH");
		/*
		 * Check whether the employee is GH or not if not then GH role will be
		 * full filled by GH of AEG department
		 */
		String hql = null;
		int empId;
		ArrayList<String> roleOfEmployee = getRole(appraisee.getEmployeeId());
		if (roleOfEmployee.contains(AppraisalConstants.GH)) {
			hql = "Select empId from User_Role where group = :group AND roleId = :roleId";
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(AppraisalConstants.GROUP, AppraisalConstants.AEG);
			query.setParameter(AppraisalConstants.ROLE_ID, 4);
			empId = (int) query.uniqueResult();
			session.getTransaction().commit();
			session.close();
		} else {
			String groupName = appraisee.getGroupName();
			hql = "Select empId from User_Role where group = :group AND roleId = :roleId";
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(AppraisalConstants.GROUP, groupName);
			query.setParameter(AppraisalConstants.ROLE_ID, 4);
			empId = (int) query.uniqueResult();
			session.getTransaction().commit();
			session.close();
		}
		Employee groupHead = getEmployeeByID(empId);
		return groupHead;
	}



	public Employee getFirstEmployeeByDesignation(String designation) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getEmployeeByDesignation");
		String hql = "from Employee where replace(designation,' ','') = replace(:designation,' ','')";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.DESIGNATION,designation);
		List employeeList = query.list();
		Employee employee = null;
		if(employeeList!=null&&(!employeeList.isEmpty())){
			employee = (Employee) employeeList.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return employee;

	}

	public ArrayList<Employee> getAllPermanentEmployeesEmails() {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getAllPermanentEmployeesEmails");
		String hql = "from Employee where Employee_Type = :empType";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.EMPLOYEE_TYPE, AppraisalConstants.PERMANENT);
		ArrayList<Employee> employee = (ArrayList<Employee>) query.list();
		session.getTransaction().commit();
		session.close();
		return employee;
	}



	public int getStatusIdByStatus(String status) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getStatusIdByStatus");
		String hql = "Select statusId from AppraisalStatus where status = :status";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.STATUS, status);
		int statusId = (int) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return statusId;
	}

	

	public String getStatusByStatusId(int statusId) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getStatusByStatusId");
		String hql = "select status from AppraisalStatus where statusId = :statusId";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.STATUS_ID, statusId);
		String status = (String) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return status;
	}

	public void changeStatus(int empId, String status, int appCycleId) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:changeStatus");
		System.out.println(empId + status + appCycleId);
		String hql = "update Appraisal_Details set AppStatus = :status, isAppEnabled =  :enableApp where AppCycleId = :appCycleId and EMPID = :empId";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(AppraisalConstants.STATUS, status);
		query.setParameter(AppraisalConstants.ENABLE_APP, 1);
		query.setParameter(AppraisalConstants.EMPLOYEE_ID, empId);
		query.setParameter(AppraisalConstants.APP_CYCLE_ID, appCycleId);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return;
	}

	public ArrayList<Employee_Manager> getAllEmpListByAppCycleId(List<Integer> idList, int appCycleIdInt) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getAllEmployeesUnderGH");

		String hql = "select EMPID as employees_Id, EmployeeName as employee_name from APPRAISAL_DETAIL where AppCycleId = ? and EMPID in (:idList)";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/*
		 * List empList = new ArrayList(); empList =
		 * session.createSQLQuery(hql).setParameter(0, 135).list();
		 * System.out.println(empList);
		 */

		List empList = session.createSQLQuery(hql).addScalar("employees_Id").addScalar("employee_name")
				.setParameter(0, appCycleIdInt).setParameterList("idList", idList)
				.setResultTransformer(Transformers.aliasToBean(Employee_Manager.class)).list();

		ArrayList<Employee_Manager> emplManager = new ArrayList<Employee_Manager>();

		session.close();

		if (empList.size() > 0) {
			logger.info("Employee Found");

			for (int i = 0; i < empList.size(); i++) {
				Employee_Manager em = (Employee_Manager) empList.get(i);
				emplManager.add(em);
			}
			return emplManager;

		} else {
			logger.info("Employee Not Found");
			return null;
		}
	}


	
	public ArrayList<Employee> getAppraiseeListGrpWise(int appCycleId, String grpName, ArrayList<String> listOfGroups) {
		logger.info("ClassName:AppraisalDAOImpl");
		logger.info("MethodName:getAppraiseeListGrpWise");

		logger.info("App Id in getAppraiseeListGrpWise :: " + appCycleId);

		String hql = "from Employee as e where e.employeeId not in ("
				+ "select d.EMPID from Appraisal_Details as d where d.AppCycleId = :appCycleId) and e.Employee_Type = :empType and group_name = :group";

		String hql1 = "from Employee as e where e.employeeId not in ("
				+ "select d.EMPID from Appraisal_Details as d where d.AppCycleId = :appCycleId) and e.Employee_Type = :empType and group_name in (:groupName)";

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query;

		if (grpName.equalsIgnoreCase(AppraisalConstants.ALL_GROUPS)) {
			query = session.createQuery(hql1);
			query.setParameter(AppraisalConstants.EMPLOYEE_TYPE, AppraisalConstants.PERMANENT);
			query.setParameter(AppraisalConstants.APP_CYCLE_ID, appCycleId);
			query.setParameterList(AppraisalConstants.GROUP_NAME,listOfGroups);

		} else {

			query = session.createQuery(hql);
			query.setParameter(AppraisalConstants.EMPLOYEE_TYPE, AppraisalConstants.PERMANENT);
			query.setParameter(AppraisalConstants.APP_CYCLE_ID, appCycleId);
			query.setParameter(AppraisalConstants.GROUP, grpName);
		}

		ArrayList<Employee> employeeList = (ArrayList<Employee>) query.list();
		session.getTransaction().commit();
		session.close();
		return employeeList;
	}




	
	public List<Employee> findManagerReviewerByEmpId(int empId) {
		logger.info("CLASSNAME:AppraisalDAOImpl");
		logger.info("METHODNAME:findManagerReviewerByEmpId");

		String hql = "from Employee where manager in (Select employeeId from Employee where manager = ?)";
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Employee> empList = new ArrayList<Employee>();
		empList = session.createQuery(hql).setParameter(0, empId).list();

		session.close();

		if (empList.size() > 0) {
			logger.info("Manager Found");
			return empList;
		} else {
			logger.info("Manager Not Found");
			return null;
		}
	}

	

public boolean isSubordinates(String empId, int manager) {
		List<Employee> list = findEmployeeByManagerID(manager);
		boolean flag = false;
		for (Employee employee : list) {
			if(employee.getEmployeeId() == Integer.parseInt(empId))
			{	flag=true;
				break;
			}
		}
		return flag;
	}

	public String updateTargetByEmployee(String id, String targetAchieved,
			String empRemarks) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hqlUpdate = "update AppraisalTargets a set a.targetAchieved = :targetAchieved, a.empRemarks= :empRemarks where a.id = :id";
		session.createQuery(hqlUpdate)
		        .setString("empRemarks",empRemarks)
				.setInteger("targetAchieved", Integer.parseInt(targetAchieved))
				.setInteger("id", Integer.parseInt(id)).executeUpdate();
		tx.commit();
		session.close();
		return "success";
	}


	@SuppressWarnings("unchecked")
	public List<String> getDistinctDesignationByGroup(String group)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		if(!group.equals(""))
		{
			criteria.add(Restrictions.eq("groupName",group ));
		}
		criteria.setProjection(Projections.distinct(Projections.property("designation")));
		criteria.addOrder(Order.asc("designation"));
		List <String> designationList = criteria.list();
		tx.commit();
		session.close();
		return designationList;
		
	}
	@SuppressWarnings("unchecked")
	public List<String> getEmployeeListByDesignation(String desig, String group)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		if(!desig.equals(""))
		{
			criteria.add(Restrictions.eq("designation",desig ));
		}
		if(!group.equals(""))
		{
			criteria.add(Restrictions.eq("groupName",group ));
		}
		
		
		ProjectionList p = Projections.projectionList();
		p.add(Projections.property("employeeName"));
		
		criteria.setProjection(p);
		criteria.addOrder(Order.asc("employeeName"));
		List <String> employeeList = (List <String>) criteria.list();
		tx.commit();
		session.close();
		return employeeList;
		
	}

	@SuppressWarnings("unchecked")
	public List<String> getEmployeeList() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("leftorg", 0));
		ProjectionList p = Projections.projectionList();
		p.add(Projections.property("employeeName"));
		criteria.setProjection(p);
		criteria.addOrder(Order.asc("employeeName"));
		List <String> employeeList = (List <String>) criteria.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	


}

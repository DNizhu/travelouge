	package com.thepsi.appraisalSystem.util;

	public class AppraisalConstants {
		
		
		public static final String LOG_NAME = "appraisalSystem";
		public static final String LOGIN_PAGE = "login";
		public static final String INSTRUCTION_PAGE = "instructions";
		public static final String USERNAME_SUFFIX = "@thepsi.com";
		public static final String PROPERTIES_FILENAME = "appraisal.properties";
		public static final String LDAP_URL = "appraisal.ldapServer";
		public static final String LDAP_LDAPCTXFACTRY = "ldap.ldapCtxFactory";
		//public static final String APPRAISAL_CYCLE = "appraisalCycle";
		//public static final String ENABLE = "Enable";
		//public static final String COMMAND = "command";
		/*URL for Controller Classes */
		//public static final String START_APPRAISAL_CYCLE = "/startAppraisalCycle.apr";
		//public static final String SUBMIT_APPRAISAL_CYLE = "/submitAppraisalCycle.apr";
		//public static final String HANDLE_LOGIN = "/handleLogin.apr";
		//public static final String LOGIN = "/login.apr";
		/*JSP File Constants */
		//public static final String START_APPRAISAL_CYCLE_PAGE = "startAppraisalCycle";
		
		
		
		//Added by Aayushi Agarwal
		public static final String LOGOUT_PAGE_URL = "/logout.apr";
		public static final String MANAGER_URL = "/managerReview.apr";
		public static final String MANAGER_REVIEWER_URL = "/managerReviewer.apr";
		public static final String ADDITIONAL_MANAGER_URL = "/addManagerReview.apr";
		//public static final String AGH_URL = "/aghReview.apr";
		public static final String GH_URL = "/ghReview.apr";
		public static final String HR_URL = "/hrReview.apr";
		public static final String MANAGEMENT_URL = "/mgmtReview.apr";
		public static final String ADD_MANAGEMENT_URL = "/addMgmtReview.apr";
		
		public static final String LISTFORM_PAGE = "listForm";
		public static final String LISTFORMGROUPWISE_PAGE = "listFormGroupWise";
		public static final String SELFREVIEW_PAGE = "selfReview";
		public static final String SELFREVIEW_URL = "/selfReview.apr";
		
		public static final String REVIEW_PAGE = "reviewForm";
		public static final String REVIEW_URL = "/reviewForm.apr";
		public static final String REVIEW_FORM_SUBMIT = "submitReviewForm.apr";
		public static final String REVIEW_FORM_SAVED = "saveReviewForm.apr";
		
		public static final String SAVE_SELFREVIEW_URL = "/saveSelfReview.apr";
		public static final String SUBMIT_SELFREVIEW_URL = "/submitSelfReview.apr";
		
		public static final String INSTRUCTIONS_URL = "/instructions.apr";
		public static final String INSTRUCTIONS_PAGE = "/instructions";
		
		public static final String SAMPLE_FORM_URL = "/sampleForm.apr";
		public static final String SAMPLE_FORM_PAGE = "/sampleForm";
		
		/**
		 * pallavi
		 */
		
		public static final String ADD_SKILLS = "addSkill.apr";
		public static final String GET_SPECIALIZATION = "getSpcialization.apr";
		public static final String GET_MAJOR_SKILL = "getMajorSkill.apr";
		public static final String CHECK_SKILL_EXISTS = "checkSkillExists.apr";
		public static final String SAVE_SKILL = "saveSkills.apr";
		public static final String UPDATE_SKILL = "updateSkills.apr";
		public static final String GET_MAJORSKILL_BY_AREA = "getMajorSkillByArea.apr";
		public static final String SKILL_REPORT = "skillReport.apr";
		public static final String GET_BASIC_SEARCH = "getBasicSearch.apr";
		public static final String GET_ADVANCE_SEARCH = "getAdvanceSearch.apr";
		public static final String GET_DESIGNATION = "getDesignationByGroup.apr";
		public static final String GET_EMPLOYEES = "getEmployees.apr";
		public static final String SAVE_MASTER_SKILLS = "saveMasterSkills.apr";
		public static final String GET_MASTER_AREA = "getMasterArea.apr";
		public static final String GET_MASTER_MAJOR_SKILL = "getMasterMajorSkill.apr";
		public static final String GET_MASTER_SPECIALIZATION = "getMasterSpecialization.apr";
		
		public static final String GET_BASIC_SEARCH_TELPP = "getBasicSearchTelpp.apr";
		
		/* Form Status */
		public static final String STATUS_NOT_STARTED = "NOT_STARTED";
		//public static final String STATUS_SELF_PENDING = "SELF_PENDING";
		public static final String STATUS_SELF_COMPLETED = "SELF_COMPLETED";
		//public static final String STATUS_MANAGER_PENDING = "MANAGER_PENDING";
		public static final String STATUS_MANAGER_COMPLETED = "MANAGER_COMPLETED";
		//public static final String STATUS_ADDITIONAL_PENDING = "ADDITIONAL_PENDING";
		public static final String STATUS_ADDITIONAL1_COMPLETED = "AD_REVIEW1_COMPLETED";
		public static final String STATUS_ADDITIONAL2_COMPLETED = "AD_REVIEW2_COMPLETED";
		//public static final String STATUS_AGH_PENDING = "PENDING_PENDING";
		//public static final String STATUS_AGH_COMPLETED = "AGH_COMPLETED";
		//public static final String STATUS_GH_PENDING = "PENDING_PENDING";
		//public static final String STATUS_GH_COMPLETED = "GH_COMPLETED";
		//public static final String STATUS_HR_PENDING = "PENDING_PENDING";
		//public static final String STATUS_HR_COMPLETED = "HR_COMPLETED";
		//public static final String STATUS_MANAGEMENT_PENDING = "MANAGEMENT_PENDING";
		public static final String STATUS_MANAGEMENT_COMPLETED = "MGMT_COMPLETED";
		//public static final String STATUS_ADDITINAL_MANAGEMENT_PENDING = "ADDITIONAL MANAGEMENT_PENDING";
		public static final String STATUS_ADDITIONAL_MANAGEMENT1_COMPLETED = "ADDITIONAL MANAGEMENT1_COMPLETED";
		
		public static final String STATUS_ADDITIONAL_MANAGEMENT2_COMPLETED = "ADDITIONAL MANAGEMENT2_COMPLETED";
		public static final String STATUS_ADDITIONAL_MANAGEMENT3_COMPLETED = "ADDITIONAL MANAGEMENT3_COMPLETED";
		
		public static final String NORMALIZED_FORM_SUBMIT = "submitNormalizeRating.apr";

		public static final String STATUS_GH_COMPLETED = "GH_COMPLETED";
		public static final String STATUS_HR_COMPLETED = "HR_COMPLETED";
		
		/* Self Review Form Status*/
		public static final int SELF_REVIEW_ENABLE = 1;
		public static final int SELF_REVIEW_DISABLE = 0;

		//For Appraisal Notes
		public static final String APP_NOTES_URL = "/appraisalNotes.apr";
		public static final String APP_NOTES_PAGE = "appNotes";
		public static final String SAVE_APP_NOTES_URL = "/saveAppNotes.apr";
		public static final String STATUS_SECOND_LEVEL_REVIEW_COMPLETED = "SECOND_LEVEL_REVIEW_COMPLETED";
		public static final String SECOND_LEVEL_REVIEW_COMPLETED_MAIL_SUBJECT = "Second level review completed by";
		public static final String AVP_HR = "AVP-HR";
		public static final String GH_GROUPS = "ghGroups";

		/*Action Deatils */
		public static final String SELF_REVIEW_SAVED = "SELF_REVIEW_SAVED";
		public static final String SELF_REVIEW_COMPLETED = "SELF_REVIEW_COMPLETED";
		public static final String SENDBACK_BY_MANAGER = "APPRAISEE FORM SENDBACK_BY_MANAGER AND APPRAISEE ID IS";
		public static final String MANAGER_REVIEW_SAVED = "MANAGER_REVIEW_SAVED";
		public static final String MANAGER_REVIEW_COMPLETED = "MANAGER_REVIEW_COMPLETED";
		//public static final String AGH_REVIEW_SAVED = "AGH_REVIEW_SAVED";
		public static final String SECOND_LEVEL_REVIEW_SAVED = "SECOND_LEVEL_REVIEW_SAVED";
		//public static final String AGH_REVIEW_COMPLETED = "AGH_REVIEW_COMPLETED";
		public static final String HR_REVIEW_SAVED = "HR_REVIEW_SAVED";
		public static final String HR_REVIEW_COMPLETED = "HR_REVIEW_COMPLETED";
		//public static final String GH_REVIEW_SAVED = "GH_REVIEW_SAVED";
		//public static final String GH_REVIEW_COMPLETED = "GH_REVIEW_COMPLETED ";
		public static final String MGMT_REVIEW_SAVED = "MGMT_REVIEW_SAVED";
		public static final String MGMT_REVIEW_COMPLETED = "MGMT_REVIEW_COMPLETED";
		public static final String ADDITIONAL_MANAGER1_REVIEW_SAVED = "ADDITIONAL_MANAGER1_REVIEW_SAVED";
		public static final String ADDITIONAL_MANAGER1_REVIEW_COMPLETED = "ADDITIONAL_MANAGER1_REVIEW_COMPLETED";
		public static final String ADDITIONAL_MANAGER2_REVIEW_SAVED = "ADDITIONAL_MANAGER2_REVIEW_SAVED";
		public static final String ADDITIONAL_MANAGER2_REVIEW_COMPLETED = "ADDITIONAL_MANAGER2_REVIEW_COMPLETED";
		public static final String ADDITIONAL_MGMT1_REVIEW_SAVED = "ADDITIONAL_MGMT1_REVIEW_SAVED";
		public static final String ADDITIONAL_MGMT1_REVIEW_COMPLETED = "ADDITIONAL_MGMT1_REVIEW_COMPLETED";
		public static final String ADDITIONAL_MGMT2_REVIEW_SAVED = "ADDITIONAL_MGMT2_REVIEW_SAVED";
		public static final String ADDITIONAL_MGMT2_REVIEW_COMPLETED = "ADDITIONAL_MGMT2_REVIEW_COMPLETED";
		public static final String ADDITIONAL_MGMT3_REVIEW_SAVED = "ADDITIONAL_MGMT3_REVIEW_SAVED";
		public static final String ADDITIONAL_MGMT3_REVIEW_COMPLETED = "ADDITIONAL_MGMT3_REVIEW_COMPLETED";
		
		public static final String APPRAISAL_NOT_STARTED_PAGE = "appraisalNotStarted";
		public static final String SENDBACK_MANAGER_URL = "/sendBackByManager.apr";
		public static final String EDIT_STATUS_URL = "/editStatus.apr";
		public static final String EDIT_STATUS_PAGE = "editStatus";
		
		public static final String AUTHORIZED_PAGE = "authorized";
		
		public static final String MANAGEMENT_GROUP = "Management";
		
		public static final String ADMIN_ROLE = "ADMIN";
		public static final String HR_ROLE = "HR";
		public static final String MGMT_ROLE = "MGMT";
		public static final String GH_ROLE = "GH";
		//public static final String AGH_ROLE = "AGH";
		
		public static final String MULTIPLE_ROLE = "multipleRole";
		public static final String SHOW_RESULT = "Y";
		public static final String CHECKED = "CHECKED";
		
		public static final String YES = "Y";
		public static final String NO = "N";
		
		public static final String MY_REPORT_URL = "/myReport.apr";
		public static final String MY_REPORT_PAGE = "myReport";
		
		/**/
	//Added by Ankush
		public static final String APPRAISAL_CYCLE = "appraisalCycle";
		public static final String ENABLE = "Enable";
		public static final String COMPLETE = "Complete";
		public static final String STATUS = "status";
		public static final String COMMAND = "command";
		public static final String LIST_OF_APPRAISAL_CYCLE = "listOfAppraisalCycle";
		public static final String ERROR_MESSAGE = "errorMessage";
		public static final String LIST_OF_GROUPS = "listOfGroups";
		public static final String ID = "id";
		public static final String GROUP_NAME = "groupName";
		public static final String LIST_OF_STATUS = "listOfStatus";
		public static final String APPRAISAL_DETAIL = "appraisalDetails";
		public static final String STATUS_ID = "statusId";
		public static final String ALL_UNDER_EMPLOYEES = "allUnderEmployees";
		
		public static final String APP_CYCLE = "appCycle";
		public static final String MANAGER_NAME = "managerName";
		public static final String MANAGER = "manager";
		public static final String EMPLOYEE_NAME = "empName";
		public static final String EMPLOYEE_ID = "empId";
		public static final String APPRAISAL_RECORDS = "appraisalRecords";
		public static final String APP_CYCLE_ID = "appCycleId";
		public static final String MR_NAME = "MR_Name";
		public static final String EMPLOYEE = "employeeName";
		public static final String GROUP = "group";
		public static final String ALL_GROUPS = "allGroups";
		public static final String ALL_STATUS = "allStatus";
		public static final String APPRAISAL_STATUS = "appStatus";
		public static final String EMPLOYEES_DETAILS = "employeesDetails";
		public static final String APP_CYCLE_STATUS = "appCycleStatus";
		public static final String UPDATE_REQUEST = "updateRequest";
		public static final String TRUE = "TRUE";
		public static final String FALSE = "FALSE";
		public static final String EDIT_FROM_MONTH = "editFromMonth";
		public static final String EDIT_FROM_YEAR = "editFromYear";
		public static final String EDIT_TO_MONTH = "editToMonth";
		public static final String EDIT_TO_YEAR = "editToYear";
		public static final String ROLE = "role";
		//public static final String AGH = "AGH";
		public static final String HR = "HR";
		public static final String GH = "GH";
		public static final String ADMIN = "AMDIN";
		public static final String MGMT = "MGMT";
		public static final String ROLE_ID = "roleId";
		public static final String COO = "COO";
		public static final String DESIGNATION = "designation";
		public static final String EDIT_FROM_DATE = "editFromDate";
		public static final String PERMANENT = "Permanent";
		public static final String EMPLOYEE_TYPE = "empType";
		public static final String DATA_SUBMISSION = "dataSubmission";
		public static final String DATA_SAVED = "dataSaved";
		public static final String DATA_SUBMITTED_SUCCESSFULLY = "Data Submitted Successfully";
		public static final String ENABLE_APP = "enableApp";
		public static final String ALL_MANAGERS = "allManagers";
		public static final String AEG = "Engineering AEG";
		public static final String LIST_NOT_STARTED_EMPLOYEE = "listOfNotStartedEmployee";
		public static final String LIST_SELF_COMPLETED_EMPLOYEE = "listOfSelfCompletedEmployee";
		public static final String LIST_MANAGER_COMPLETED_EMPLOYEE = "listOfManagerCompletedEmployee";
		public static final String LIST_SECOND_LEVEL_COMPLETED_EMPLOYEE = "listOfSecondLevelCompletedEmployee";
		//public static final String LIST_AGH_COMPLETED_EMPLOYEE = "listOfAghCompletedEmployee";
		
		//public static final String LIST_GH_COMPLETED_EMPLOYEE = "listOfGhCompletedEmployee";
		public static final String LIST_HR_COMPLETED_EMPLOYEE = "listOfHrCompletedEmployee";
		/*Mail Constants */
		public static final String APPRAISAL_MAIL_ADDRESS = "appraisal.mail.address";
		public static final String SELF_APPRAISAL_COMPLETED_PROPERTY = "self.appraisal.completed.file.address";
		public static final String MANAGER_REVIEW_CONTENT_PROPERTY = "manager.review.file.address";
		public static final String MANAGER_SUBMIT_CONTENT_PROPERTY = "manager.second.level.file.address";
		public static final String AR_COMPLETED_CONTENT_PROPERTY = "additional.review.manager.file.address";
		public static final String SL_COMPLETED_CONTENT_PROPERTY = "second.level.hr.file.address";
		//public static final String GH_COMPLETED_MAIL_CONTENT_PROPERTY = "gh.hr.file.address"; 
		//public static final String AGH_COMPLETED_CONTENT_PROPERTY = "agh.gh.file.address";
		public static final String HR_COMPLETED_MAIL_CONTENT_PROPERTY = "hr.mgmt.file.address";
		public static final String MR_TO_ADD_REVIEW_MAIL_CONTENT_PROPERTY = "manager.additional.review.file.address";
		
		
		public static final String SR_COMPLETED_MAIL_SUBJECT = "Self appraisal completed by ";
		public static final String SR_COMPLETED_MAIL_CONTENT = "Self appraisal completed by ";
		
		public static final String KINDLY_VISIT_LINK = "kindly visit on the link";
		public static final String APPRAISAL_SYSTEM_LINK = "appraisal.system.link";
		public static final String MAIL_FROM = "mail.from";
		
		public static final String SEND_BACK_SUBJECT = "Self Review send back by ";
		public static final String SEND_BACK_MAIL_CONTENT = "Your appraisal has been sent back by ";
		
		public static final String MANAGER_COMPLETED_MAIL_SUBJECT = "Manager review completed by ";
		public static final String MANAGER_AR_MAIL_SUBJECT = "Additional appraisal review requested by ";
		public static final String MANAGER_COMPLETED_MAIL_CONTENT = "Manager review completed by ";
		
		public static final String ADDITIONAL_REVIEWER_1__MAIL_SUBJECT = "First additional review completed by ";
		public static final String ADDITIONAL_REVIEWER_1_MAIL_CONTENT = " First addional review completed by ";
		
		public static final String ADDITIONAL_REVIEWER_2__MAIL_SUBJECT = "Second additional review completed by ";
		public static final String ADDITIONAL_REVIEWER_2_MAIL_CONTENT = " Second addional review completed by ";
		
		//public static final String AGH_COMPLETED_MAIL_SUBJECT = "Associate group head review completed by ";
		//public static final String AGH_COMPLETED_MAIL_CONTENT = "Associate group head review completed by ";
		
		public static final String GH_COMPLETED_MAIL_SUBJECT = "Group head review completed by ";
		public static final String GH_COMPLETED_MAIL_CONTENT = "Group head review completed by ";
		
		public static final String HR_COMPLETED_MAIL_SUBJECT = "HR review completed by ";
		public static final String HR_COMPLETED_MAIL_CONTENT = "HR review completed by ";
		
		public static final String MGMT_COMPLETED_MAIL_SUBJECT = "Management review completed by ";
		public static final String MGMT_COMPLETED_MAIL_CONTENT = "Management review completed by ";
		
		public static final String ADDITIONAL_MANAGEMENT_1_COMPLETED_MAIL_SUBJECT = "First additional management review completed by ";
		public static final String ADDITIONAL_MANAGEMENT_1_MAIL_CONTENT = "First additional management review completed by ";
		
		public static final String ADDITIONAL_MANAGEMENT_2_COMPLETED_MAIL_SUBJECT = "Second additional management review completed by ";
		public static final String ADDITIONAL_MANAGEMENT_2_MAIL_CONTENT = "Second additional management review completed by ";
		
		public static final String ADDITIONAL_MANAGEMENT_3_COMPLETED_MAIL_SUBJECT = "Third additional management review completed by ";
		public static final String ADDITIONAL_MANAGEMENT_3_MAIL_CONTENT = "Third additional management review completed by ";
		
		public static final String MAIL_FILE_ADDRESS = "mail.file.address";
		public static final String UPDATE_MAIL_FILE_ADDRESS = "update.mail.file.address";
		public static final String HR_TEAM_MAIL_ADDRESS = "hr.team.mail.address";
		/*URL for Controller Classes */
		public static final String START_APPRAISAL_CYCLE = "/startAppraisalCycle.apr";
		public static final String SUBMIT_APPRAISAL_CYLE = "/submitAppraisalCycle.apr";
		public static final String HANDLE_LOGIN = "/handleLogin.apr";
		public static final String ERROR = "/error.apr";
		public static final String GET_EMPLOYEE_APPRAISAL = "/getDetail.apr";
		public static final String TEAM_REPORT_URL = "teamReport.apr";
		public static final String GET_REPORT = "getReport.apr";
		public static final String GET_LIST_OF_APPRAISEE = "getListOfAppraisee.apr";
		
		public static final String UPDATE_APPRAISAL_CYCLE = "/udpateAppraisalCycle.apr";
		public static final String COMPLETE_APPRAISAL_CYCLE = "/completeAppraisalCycle.apr";
		public static final String RECORDS = "/records.apr";
		public static final String GET_LIST_OF_MANAGER_BY_GROUP = "/getListOfManagerByGroup.apr";
		public static final String GET_LIST_OF_EMPLOYEE_BY_NAME = "/getListOfEmployeeByName.apr";
		public static final String GET_RECORDS = "/getRecords.apr";
		public static final String GET_EMPLOYEES_DETAILS = "/getEmployeesDetails.apr";
		public static final String EDIT_APPRAISAL_CYCLE = "/editAppraisalCycle.apr";
		public static final String FORCE_ENABLE = "/forceEnable.apr";
		public static final String CHANGE_STATUS = "/changeStatus.apr";
		
		public static final String TELPP_IMPACT_REPORT = "getTelppImpact.apr";
		
		
		/*JSP File Constants */
		public static final String START_APPRAISAL_CYCLE_PAGE = "startAppraisalCycle";
		public static final String RECORDS_PAGE = "records";
		public static final String ERROR_PAGE = "error";
			
			//Added by Saurabh
			public static final String NORMALIZE_RATING = "/normalizeRating.apr";
			public static final String NR_PAGE = "normalizeRating";
			public static final String GET_NORMALIZE_RATING = "/getNormalizeRating.apr";
			public static final String USER_ATTR = "employeeDetails";
			public static final String AVOID_URL = "/TravelDesk/handleLogin.apr";
			public static final String FILTER_REDIRECT_URL = "/TravelDesk/";
			public static final String MSPS_LINK = "msps.report.link";
			public static final String MAIL_SMTP_HOST = "mail.smtp.host";
			public static final String LOGIN = "/login.html";
			public static final String ELIGIBLE_PAGE = "eligibility";
			public static final String DASHBOARD = "/dashboard.apr";
			
			
			public static final String DASHBOARD_PAGE = "Dashboard";
			public static final String LIST_OF_STATUS_COUNT = "statusCountList";
			public static final String NOT_STARTED_COUNT = "NotStartedCount";
			public static final String DASHBOARD_POST = "/dashboardPost.apr";
			public static final String FLAG_SR = "SR";
			public static final String FLAG_MR = "MR";
			public static final String FLAG_SLR = "SLR";
			//public static final String FLAG_GH = "GH";
			public static final String LIST_OF_RATINGS = "ratingList";
			
		   //For Reminder Notification Mail
			public static final String SR_PENDING_MAIL_SUBJECT = "Self Appraisal Pending ";
			public static final String REMINDER_SELF ="reminder.self.address";
			public static final String ACTION_SELF_APPRAISAL ="Self Appraisal";
			public static final String MR_PENDING_MAIL_SUBJECT = "Manager Review Pending ";
			public static final String ACTION_MANAGER_REVIEW ="Manager Review";
			//public static final String ACTION_AGH_REVIEW ="AGH Review";
			public static final String ACTION_GH_REVIEW ="GH Review";
			public static final String ACTION_HR_REVIEW ="HR Review";
			public static final String ACTION_MGMT_REVIEW ="Management Review";
			public static final String ACTION_ADD_MANAGER_REVIEW ="Additional Manager Review";
			public static final String ADDITIONAL_REVIEW_PENDING_MAIL_SUBJECT = "Additional Manager Review Pending";
			
			public static final String REMINDER_TEAM ="reminder.team.address";
			//public static final int AGH_ROLE_ID = 5;
			public static final int GH_ROLE_ID = 4;
			public static final int HR_ROLE_ID = 2;
			public static final int MGMT_ROLE_ID = 3;
			//public static final String AGH_PENDING_MAIL_SUBJECT = "AGH Review Pending";
			public static final String GH_PENDING_MAIL_SUBJECT = "GH Review Pending";
			public static final String HR_PENDING_MAIL_SUBJECT = "HR Review Pending";
			public static final String MGMT_PENDING_MAIL_SUBJECT = "Management Review Pending";
			
			/*//For Appraisal Notes
			public static final String APP_NOTES_URL = "/appraisalNotes.apr";
			public static final String APP_NOTES_PAGE = "appNotes";
			public static final String SAVE_APP_NOTES_URL = "/saveAppNotes.apr";
			public static final String STATUS_SECOND_LEVEL_REVIEW_COMPLETED = "SECOND_LEVEL_REVIEW_COMPLETED";
			public static final String SECOND_LEVEL_REVIEW_COMPLETED_MAIL_SUBJECT = "Second level review completed by";
			public static final String AVP_HR = "AVP-HR";
			public static final String GH_GROUPS = "ghGroups";*/
			
			//For Set Target
			public static final String SET_TARGET_URL = "/setTargets.apr";
			public static final String Manager = "Manager";
			public static final String admin = "admin";
			public static final String EMPLOYEE_DETAILS = "employeeDetails";
			public static final String SET_TARGETS = "setTargets";
			public static final String GET_LIST_TARGET = "/getListOfTargetsOfEmployee.apr";
			public static final String DELETE_TARGET = "/deleteTarget.apr";
			public static final String UPDATE_TARGET = "/updateTarget.apr";
			public static final String DESCRIPTION = "description";
			public static final String TARGET_DATE = "targetDate";
			public static final String REMARKS = "remarks";
			public static final String ADD_TARGET = "/addTarget.apr";
			public static final String EMP_ID = "empId";
			public static final String VIEW_TARGET_URL = "/viewTargets.apr";
			public static final String VIEW_TARGETS = "viewTargets";
			public static final String TARGET_ACHIEVED = "targetAchieved";
			public static final int ZERO = 0;
			
			public static final String AVP_ROLE = "AVP";
			public static final String LIST_SUBORDINATES = "listOfSubordinates";
			public static final String LIST_TARGETS = "listOfTargets";
			public static final String UNAUTHORIZED_ACCESS = "unAuthorizedAccess.apr";
			public static final String UNAUTHORIZED_URL = "/unAuthorizedURL.apr";
			public static final String SUBMIT_TARGET = "/submitTarget.apr";
			public static final String NEW_TARGETS_SET = "New targets are set.";
			public static final String TARGETS_UPDATED = "Targets updated";
			public static final String TARGETS_SUBMITTED = "targetsSubmitted";
			public static final String TARGET_SUBMIT_CONTENT_PROPERTY = "target.submit.file.address";
			public static final String TARGET_ACHIEVED_CONTENT_PROPERTY = "target.achieved.file.address";
			public static final String TARGET_UNACHIEVED_CONTENT_PROPERTY = "target.unachieved.file.address";
			public static final String SUBMIT_TARGET_FOR_EMPLOYEE = "/submitTargetByEmployee.apr";
			public static final String EMP_REMARKS = "empRemarks";
			public static final String SUCCESS = "success";
			public static final String CHECK_TARGET_STATUS = "/checkTargetStatus.apr";
			public static final String FAILURE = "failure";
			public static final String TARGET_IS_ACHIEVED = "Target Achieved";
			public static final String TARGET_UNACHIEVED = "Target Unachieved";
			public static final String DISABLE_TARGET = "/changeTargetStatus.apr";
			public static final String TARGET_STATUS = "targetStatus";
			
			/* added by vartika for probation process */
			public static final String VIEW_PROBATION_REVIEW = "viewProbationReview.apr";
			public static final String VIEW_SUBORDINATE_PROBATIONERS = "viewSubordinateProbationers.apr";
			public static final String PROBATION_REVIEW_FORM = "probationReviewForm";
			public static final String SUBORDINATE_PROBATIONERS = "subordinateProbationers";
			public static final String SAVE_GENERAL_COMMENTS_FORM = "saveGeneralCommentsForm.apr";
			public static final String SUBMIT_GENERAL_COMMENTS_FORM = "submitGeneralCommentsForm.apr";
			public static final String SAVE_MONTH_FORM = "saveMonthForm.apr";
			public static final String SUBMIT_MONTH_FORM = "submitMonthForm.apr";
			public static final String SAVE_MID_TERM_FORM = "saveMidTermForm.apr";
			public static final String SUBMIT_MID_TERM_FORM = "submitMidTermForm.apr";
			public static final String SAVE_PROBATION_EVALUATION_FORM = "saveProbationEvaluationForm.apr";
			public static final String SUBMIT_PROBATION_EVALUATION_FORM = "submitProbationEvaluationForm.apr";
			public static final String SAVE_FINAL_PROBATION_EVALUATION_FORM = "saveFinalProbationEvaluationForm.apr";
			public static final String SUBMIT_FINAL_PROBATION_EVALUATION_FORM = "submitFinalProbationEvaluationForm.apr";
			public static final String SAVE_EXTENSION_FORM = "saveExtensionForm.apr";
			public static final String SUBMIT_EXTENSION_FORM = "submitExtensionForm.apr";
			public static final String DELEGATE_MANAGER = "delegateManager.apr";
			
			//public static final String GENERAL_COMMENTS_FORM = "generalCommentsForm.apr";
			public static final String VIEW_PROBATION_MONTHLY_FORM = "viewProbationMonthlyForm.apr";
			//public static final String EMPLOYEE_TYPE_PROBATION = "Probation";
			public static final int IS_PROBATIONER = 1;
			public static final String GENERAL_COMMENTS_FORM_SECTION_PARTICULARS = "Particulars";
			public static final String GENERAL_COMMENTS_FORM_SECTION_ORIENTATION = "Orientation";
			public static final String PROBATION_GENERAL_COMMENTS_FORM = "GENERAL_COMMENTS_FORM";
			public static final String PROBATION_MONTH1_FORM = "MONTH_1_FORM";
			public static final String PROBATION_MONTH2_FORM = "MONTH_2_FORM";
			public static final String PROBATION_MONTH3_FORM = "MONTH_3_FORM";
			public static final String PROBATION_MONTH4_FORM = "MONTH_4_FORM";
			public static final String PROBATION_MONTH5_FORM = "MONTH_5_FORM";
			public static final String PROBATION_MID_TERM_FORM = "MID_TERM_FORM";
			public static final String PROBATION_EVALUATION_FORM = "PROBATION_EVALUATION_FORM";
			
			public static final String PROBATION_EXTENSION_FORM = "EXTENSION_FORM";
			public static final String PROBATION_EXTENTION_MONTH1_FORM = "EXTENSION_MONTH_1_FORM";
			public static final String PROBATION_EXTENTION_MONTH2_FORM = "EXTENSION_MONTH_2_FORM";
			public static final int STATUS_IS_ACTIVE = 1;
			public static final String MID_TERM_FORM_SECTION_MANAGER = "MANAGER";
			public static final String MID_TERM_FORM_SECTION_GH = "GH";
			public static final String PROBATION_EVALUATION_FORM_SECTION_HR = "HR";
			public static final String PROBATION_EVALUATION_FORM_SECTION_MANAGER = "MANAGER";
			public static final String PROBATION_EVALUATION_FORM_SECTION_GH = "GH";
			public static final String PROBATION_EVALUATION_FORM_SECTION_MD_CEO = "MD/CEO";
			public static final String PROBATION_FORM_TYPE_RATING = "Rating";
			public static final String PROBATION_FORM_TYPE_YES_NO = "Y/N";
			public static final String PROBATION_FORM_TYPE_NA = "NA";
			public static final String PROBATION_EXTENSION_FORM_SECTION_MANAGER = "MANAGER";
			public static final String PROBATION_EXTENSION_FORM_SECTION_GH = "GH";
			public static final String PROBATION_EXTENSION_FORM_SECTION_COO = "COO";
			public static final String PROBATION_GENERAL_PARTICULARS_FORM_SECTION = "Particulars";
			public static final String PROBATION_GENERAL_ORIENTATION_FORM_SECTION = "Orientation";
			public static final int PROBATION_EXTENSION_MGMT_DECISION_ID = 9;
			public static final String DATA_DELEGATION = "dataDelegation";
			// MAIL CONSTANTS FOR PROBATION APPRAISAL
			public static final String PROBATION_APPRAISAL_MAIL_ADDRESS = "probation.appraisal.mail.address";
			public static final String PROBATION_APPRAISAL_LINK = "probation.appraisal.link";
			public static final String COO_MAIL_ADDRESS = "coo.mail.address";
			public static final String MGMT_MAIL_ADDRESS = "mgmt.mail.address";
			public static final String PROBATION_FORM_SUBMIT_TO_NEXT_LEVEL_MAIL_CONTENT = "probation.form.submit.to.next.level.mail.content";
			public static final String PROBATION_FINAL_FORM_SUBMIT_MAIL_CONTENT = "probation.final.form.submit.mail.content";
			public static final String PROBATION_FORM_DELEGATION_MAIL_CONTENT = "probation.form.delegation.form.content";
			public static final String PROBATION_REMINDER_MAIL_CONTENT = "probation.reminder.mail.content";
			public static final String PROBATION_REMINDER_TO_NEXT_LEVEL_MAIL_CONTENT = "probation.reminder.to.next.level.mail.content";
			// added by vartika for changes in appraisal
			public static final int IS_ELIGIBLE_FOR_APPRAISAL = 1;
			public static final String PROBATION_PREVIEW_FORM="previewProbationForms";
			public static final String RECOMMENDED_ACTION="Recommended Action";
			public static final int MANAGER_EXTENSION_DECISION_ID=14;
			public static final int GH_EXTENSION_DECISION_ID=18;
			public static final String PROBATION_FINAL_EVALUATION_FORM = "PROBATION_FINAL_EVALUATION_FORM";
	}

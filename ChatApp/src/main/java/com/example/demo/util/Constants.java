/****************************************************************************
 *                              COPYRIGHT NOTICE
*
*                      Copyright(@2006) by Interland Technology Services PVT. LTD **
*
*      This program is used to monitor the stream control and Stop/Start
*      the streams. The program and related materials are confidential and
*      proprietary of Interland Technology Services PVT. LTD and no part of these materials
*      should be reproduced, published in any forms without the written
*      approval of INTERLAND
*
** Project Name         : iPSH
** Program description  : Constants
** Version No           : 1.0.0
** Author               : Adarsh,Harichand,Yadhu
** Date Created         : 06-April-2020
** Modification Log     :   
CRId/ProjectId	Date Modified      	User		         Description		
Prod_1.0.0	               			 
*****************************************************************************/
package com.example.demo.util;

public class Constants {
	
	
	//hotelmanagement
	public final static String USER_ID = "id";
	public final static String USER_NAME = "name";
	public final static String USER_ADDRESS = "address";
	public final static String USER_PHONE_NUMBER = "phoneNumber";
	public final static String USER_DATE = "date";
	public final static String USER_AC_OR_NON_AC = "acOrNonAc";
	public final static String USER_AGE = "age";
	public final static String HOTEL_STATUS = "status";

	
	
	
	
	//common
	//public final static String MESSAGE = "message";
	//public final static String STATUS = "status";
	public final static String DATA = "data";
	public final static String FILE_NAME = "fileName";
	public final static String CONTENT_TYPE = "type";
	public final static String EXCEL_CONTENT_TYPE = "application/vnd.ms-excel";
	public final static String PDF_CONTENT_TYPE = "application/x-pdf";
	public final static String AA_DATA = "aaData";
	public final static String TOTAL_DISPLAY_RECORD = "iTotalDisplayRecords";
	public final static String TOTAL_RECORD = "iTotalRecords";
	public final static String DELETED = "DELETED";
	public final static String DELETE = "DELETE";
	public final static String VERIFIED = "VERIFIED";
	public final static String PROCESSD = "PROCESSD";
	public final static String ALPHA_NUMER_SPACES = "^[a-zA-Z0-9- ]+$";
	public final static String ALPHA_NUMERS = "^[a-zA-Z0-9]+$";
	
	//security user log
	public final static String USER_LOG_SHEET_NAME = "Login Details Report";
	public final static String USER_LOG_MSG_USER_ID = "User ID";
	public final static String USER_LOG_MSG_LOGIN_TIME = "Login Time";
	public final static String USER_LOG_MSG_LOGIN_STATUS = "Login Status";
	public final static String USER_LOG_MSG_REASON = "Reason";
	public final static String USER_LOG_MSG_IP_ADDRESS = "IP Address";
	public final static String USER_LOG_MSG_SYSTEM_DATE = "System Date";
	public final static String USER_LOG_XLS_FILE_NAME = "User_Log.xlsx";
	public final static String USER_LOG_PDF_NAME = "Log Report";
	public final static String USER_LOG_PDF_FILE_NAME = "UserLog.pdf";
	public final static String USER_LOG_FAIL = "Fail";
	public final static String USER_LOG_S = "S";
	public final static String USER_LOG_SUCCESS = "Success";
	public final static String USER_LOG_USER_ID = "userId";
	public final static String USER_LOG_LOG_TIME = "logTime";
	public final static String USER_LOG_REASON = "reason";
	public final static String USER_LOG_STATUS = "logStatus";
	public final static String USER_LOG_SYSTEM_DATE = "sysDate";
	public final static String USER_LOG_IP_ADDRESS = "ipAddress";
	public final static String USER_LOG_SUCCESSFUL = "Successful";
	public final static String USER_LOG_FAILURE = "Failure";
	public final static String USER_LOG_DATE_RANGE = "dateRange";
	public final static String USER_LOG_PK = "pk";
	public final static String USER_LOG_DATE_FORMAT1 = "dd/MM/yyyy";
	public final static String USER_LOG_DATE_FORMAT2 = "dd-MM-yyyy";

	
	//security group
	public final static String GROUP_SCREEN_ID = "SECACGRP";
	public final static String SEC_GRP_SCREEN_NAME = "Security Group";
	public final static String GROUP_ID = "groupId";
	public final static String GROUP_NAME = "groupName";
	public final static String GROUP_HOME_SCREEN = "homeScreen";
	public final static String GROUP_TYPE = "groupType";
	public final static String GROUP_STATUS = "status";
	public final static String GROUP_HOME_URL = "homeUrl";
	public final static String GROUP_EXIST = "Group already exist.";
	public final static String GROUP_CREATED = "Group created successfully.";
	public final static String GROUP_CREATION_FAILED = "Group creation failed.";
	public final static String GROUP_NOT_EXIST = "Group doesn't exist.";
	public final static String GROUP_UPDATED = "Group updated successfully.";
	public final static String GROUP_UPDATE_FAILED = "Group update failed.";
	public final static String GROUP_DELETED = "Group Deleted successfully.";
	public final static String GROUP_DELETE_FAILED = "Group Deletion failed.";
	public final static String GROUP_VERIFIED = "Group Verified successfully.";
	public final static String GROUP_VERIFICATION_FAILED = "Group verification failed.";
	public final static String GROUP_REACTIVATED = "Group Re-Activation successfull.";
	public final static String GROUP_REACTIVATION_FAILED = "Group Re-Activation failed.";
	public final static String GROUP_ALREADY_ACTIVATED = "Group is already Active.";
	public final static String GROUP_CREATOR_AND_VERIFIER_SAME = "Group Creator and Verifier cannot be Same.";
	public final static String GROUP_CREATOR_AND_DELETE_SAME = "Same proscessor and verifier can't Delete.";
	public final static String INTERNAL_SERVER_ERROR = "Server error, contact Admin.";
	
	//security permission
	public final static String PERMISSION_SCREEN_TYPE = "screenType";
	public final static String PERMISSION_SCREEN_ID = "screenId";
	public final static String PERMISSION_SCREEN_NAME = "screenName";
	public final static String PERMISSION_ADD_FLAG = "addFlag";
	public final static String PERMISSION_UPDATE_FLAG = "updateFlag";
	public final static String PERMISSION_DISPLAY_FLAG = "disFlag";
	public final static String PERMISSION_DELETE_FLAG = "delFlag";
	public final static String PERMISSION_VERIFY_FLAG = "verFlag";
	public final static String PERMISSION_CATEGORY_NAME = "categoryName";
	public final static String PERMISSION_CATEGORY_NO = "categoryNo";
	public final static String PERMISSION_NO = "N";
	public final static String PERMISSION_YES = "Y";
	public final static String PERMISSION_GROUP_ID_REGEX_MSG = "Group ID shouldn't contains space or any invalid character";
	public final static String PERMISSION_SCREEN_CREATED = "Screen For Group Created";
	public final static String PERMISSION_GROUP_EXIST = "Already Group is Exist in this Group ID";
	public final static String PERMISSION_GROUP_ARRAY = "groupArr";
	public final static String PERMISSION_DEFAULT_CLIENT_ID = "999";
	public final static String PERMISSION_FUNCTION_FLAG = "A";
	
	//security user
	public final static String USER_NAM="name";
	public final static String USER_USER_ID = "userId";
	public final static String USER_GROUP_ID = "groupId";
	public final static String USER_GROUP_NAME = "groupName";
	public final static String USER_USER_NAME = "id";
	public final static String USER_STATUS = "status";
	public final static String USER_EMAIL_ID = "emailId";
	public final static String USER_CELLPHONE = "cellPhone";
	public final static String USER_NOT_EXIST = "No user record exist for given id";
	public final static String USER_EXIST = "User already exist.";
	public final static String USER_ADMINV = "ADMINV";
	public final static String USER_CRO = "CRO";
	public final static String USER_MSG_USER_TYPE = "S";
	public final static String USER_CREATED = "User created successfully.";
	public final static String USER_CREATION_FAILED = "User creation failed.";
	public final static String USER_UPDATED = "User updated successfully.";
	public final static String USER_UPDATE_FAILED = "User update failed.";
	public final static String USER_DELETED = "User deleted successfully.";
	public final static String USER_DELETION_FAILED = "User deleted failed.";
	public final static String USER_VERIFIED = "Verified Successfully. ";
	public final static String USER_VERIFICATION_FAILED = " Verification failed.";
	public final static String USER_NO_RECORD = "No record to verify";
	public final static String USER_USER_TYPE = "userType";
	public final static String USER_CATEGORY = "userCategory";
	public final static String BANK_ID= "bankId";
	////////////////////////////////////////////////////////////
	
	
	
	public static final String MESSAGE = "message";
	public static final String STATUS = "status";
	

	public static class SERVICES {
		public static final String PAYROLL = "PAYROLL";
		public static final String STATEMENT = "Statement";
		public static final String PAYMENT = "payment";
		public static final String BILL_PAY = "bilpay";
		public static final String DEFAULT = "Default";
	}

	public static class MESSAGE_STATUS {
		public static final String VERIFIED = "VERIFIED";
		public static final String PROCESSED = "PROCESSD";
		public static final String SUCCESS = "SUCCESS";
		public static final String DELETED = "DELETED";
		public static final String DELETE = "DELETE";
		public static final String FAILED = "FAILED";
		public static final String DRAFT = "DRAFT";
		public static final String GENERATED = "GENERATED";
		public static final String RECEIVED = "RECEIVED";
		public static final String REPAIR = "REPAIR";
		public static final String NEW = "NEW";
		public static final String APPROVED = "APPROVED";
		public static final String INITIATED = "INITIATED";
		public static final String COMPLETED = "COMPLETED";
	}

	public static class USERLOG {
		// security user log
		public static final String USER_LOG_SHEET_NAME = "Login Details Report";
		public static final String USER_LOG_MSG_USER_ID = "User ID";
		public static final String USER_LOG_MSG_LOGIN_TIME = "Login Time";
		public static final String USER_LOG_MSG_LOGIN_STATUS = "Login Status";
		public static final String USER_LOG_MSG_REASON = "Reason";
		public static final String USER_LOG_MSG_IP_ADDRESS = "IP Address";
		public static final String USER_LOG_MSG_SYSTEM_DATE = "System Date";
		public static final String USER_LOG_XLS_FILE_NAME = "User_Log.xls";
		public static final String USER_LOG_PDF_NAME = "Log Report";
		public static final String USER_LOG_PDF_FILE_NAME = "UserLog.pdf";
		public static final String USER_LOG_FAIL = "Fail";
		public static final String USER_LOG_S = "S";
		public static final String USER_LOG_SUCCESS = "Success";
		public static final String USER_LOG_USER_ID = "userId";
		public static final String USER_LOG_LOG_TIME = "logTime";
		public static final String USER_LOG_REASON = "reason";
		public static final String USER_LOG_STATUS = "logStatus";
		public static final String USER_LOG_SYSTEM_DATE = "sysDate";
		public static final String USER_LOG_IP_ADDRESS = "ipAddress";
		public static final String USER_LOG_SUCCESSFUL = "Successful";
		public static final String USER_LOG_FAILURE = "Failure";
		public static final String USER_LOG_DATE_RANGE = "dateRange";
		public static final String USER_LOG_PK = "pk";
	}

	public static class GROUP {
		// security group
		public static final String GROUP_ID = "groupId";
		public static final String GROUP_NAME = "groupName";
		public static final String GROUP_HOME_SCREEN = "homeScreen";
		public static final String GROUP_TYPE = "groupType";
		public static final String GROUP_STATUS = "status";
		public static final String GROUP_HOME_URL = "homeUrl";
		public static final String GROUP_EXIST = "Group already exist.";
		public static final String GROUP_CREATED = "Group created successfully.";
		public static final String GROUP_CREATION_FAILED = "Group creation failed.";
		public static final String GROUP_NOT_EXIST = "Group doesn't exist.";
		public static final String GROUP_UPDATED = "Group updated successfully.";
		public static final String GROUP_UPDATE_FAILED = "Group update failed.";
		public static final String GROUP_DELETED = "Group Deleted successfully.";
		public static final String GROUP_DELETE_FAILED = "Group Deletion failed.";
		public static final String GROUP_VERIFIED = "Group Verified successfully.";
		public static final String GROUP_VERIFICATION_FAILED = "Group verification failed.";
		public static final String GROUP_REACTIVATED = "Group Re-Activation successfull.";
		public static final String GROUP_REACTIVATION_FAILED = "Group Re-Activation failed.";
		public static final String GROUP_ALREADY_ACTIVATED = "Group is already Active.";
	}

	public static class PERMISSION {
		// security permission
		public static final String PERMISSION_SCREEN_TYPE = "screenType";
		public static final String PERMISSION_SCREEN_ID = "screenId";
		public static final String PERMISSION_SCREEN_NAME = "screenName";
		public static final String PERMISSION_ADD_FLAG = "addFlag";
		public static final String PERMISSION_UPDATE_FLAG = "updateFlag";
		public static final String PERMISSION_DISPLAY_FLAG = "disFlag";
		public static final String PERMISSION_DELETE_FLAG = "delFlag";
		public static final String PERMISSION_VERIFY_FLAG = "verFlag";
		public static final String PERMISSION_CATEGORY_NAME = "categoryName";
		public static final String PERMISSION_CATEGORY_NO = "categoryNo";
		public static final String PERMISSION_NO = "N";
		public static final String PERMISSION_YES = "Y";
		public static final String PERMISSION_GROUP_ID_REGEX_MSG = "Group ID shouldn't contains space or any invalid character";
		public static final String PERMISSION_SCREEN_CREATED = "Screen For Group Created";
		public static final String PERMISSION_GROUP_EXIST = "Already Group is Exist in this Group ID";
		public static final String PERMISSION_GROUP_ARRAY = "groupArr";
		public static final String PERMISSION_DEFAULT_CLIENT_ID = "999";
		public static final String PERMISSION_FUNCTION_FLAG = "A";
	}

	public static class USER {
		// security user
		public static final String USER_ID="id";
		public static final String USER_USER_ID = "userId";
		public static final String USER_GROUP_ID = "groupId";
		public static final String USER_GROUP_NAME = "groupName";
		public static final String USER_USER_NAME = "userName";
		public static final String USER_STATUS = "status";
		public static final String USER_EMAIL_ID = "emailId";
		public static final String USER_CELLPHONE = "cellPhone";
		public static final String USER_NOT_EXIST = "No user record exist for given id";
		public static final String USER_EXIST = "User already exist.";
		public static final String USER_ADMINV = "ADMINV";
		public static final String USER_CRO = "CRO";
		public static final String USER_MSG_USER_TYPE = "S";
		public static final String USER_CREATED = "User created successfully.";
		public static final String USER_CREATION_FAILED = "User creation failed.";
		public static final String USER_UPDATED = "User updated successfully.";
		public static final String USER_UPDATE_FAILED = "User update failed.";
		public static final String USER_DELETED = "User deleted successfully.";
		public static final String USER_DELETION_FAILED = "User deleted failed.";
		public static final String USER_VERIFIED = "Verified Successfully. ";
		public static final String USER_VERIFICATION_FAILED = " Verification failed.";
		public static final String USER_NO_RECORD = "No record to verify";
		public static final String USER_USER_TYPE = "userType";
		public static final String USER_CATEGORY = "userCategory";
		public static final String VALID_FAILED = "Validation Failed";
		public static final String VALID_CODE = "VALERRCOD";
	}
	
	public static class NOTIFICATION_TYPE {
		public static final String TASK = "TASK";
		public static final String INFO = "INFO";
	}
	public static class SCREEN_ID {
		public static final String SEC_GRP = "SECACGRP";
	}
	
}

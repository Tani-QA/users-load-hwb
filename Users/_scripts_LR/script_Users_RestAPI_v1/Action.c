Action()
{
	lr_output_message("MSG_LOG: Iteration #%s start time= %s", lr_eval_string("{ITERSUM}"),lr_eval_string("{CURRTIME}"));
	
	//to generate URL
	lr_save_string(lr_eval_string("{PROTOCOL}://{HOST}:{PORT}"),"URL");
	lr_output_message("MSG_LOG: URL= %s", lr_eval_string("{URL}"));
	
	//to generate endpoint
	lr_save_string(lr_eval_string("v1/users/"),"GET_USER_ID");
	lr_save_string(lr_eval_string("v1/users"),"POST_USER");
	lr_save_string(lr_eval_string("v1/users"),"GET_USERS");
//	lr_output_message("MSG_LOG: URL= %s", lr_eval_string("{GET_USER_ID}"));
	
	//to generate random mask for LOGIN and PASSWORD
	lr_param_sprintf("login","%s%d", "user", atoi(lr_eval_string("{RANDOM}")));
	lr_param_sprintf("password","%s%d", "pass", atoi(lr_eval_string("{RANDOM}")));
	lr_save_string(lr_eval_string("{login}"),"LOGIN");
	lr_save_string(lr_eval_string("{password}"),"PASSWORD");
	lr_output_message("MSG_LOG: login= %s, password=%s", lr_eval_string("{LOGIN}"),  lr_eval_string("{PASSWORD}"));
	
	
	lr_start_transaction("POST_user");
	
	web_reg_save_param_ex(
	    "ParamName=USER_ID", 
	    "LB=\"id\":", 
	    "RB=,",
	    "Ordinal=1",
	    SEARCH_FILTERS,
	        "Scope=body",
		LAST);
	
	// POST user
	web_rest("POST_user",
		"URL={URL}/{POST_USER}",
		"Method=POST",
		"EncType=raw",
		"Snapshot=t423585.inf",
		"Body={\n"
		"\"login\": \"{LOGIN}\",\n"
		"\"password\": \"{PASSWORD}\"\n"
		"}",
		HEADERS,
		"Name=Content-Type", "Value=application/json", ENDHEADER,
		LAST);
		
	lr_output_message("MSG_LOG: LAST USER_ID= %d", atoi(lr_eval_string("{USER_ID}")));
	
	lr_output_message("MSG_LOG: Transaction POST USER is successfully");
		
	lr_end_transaction("POST_user",LR_AUTO);
	

	lr_think_time(1);
	
	lr_start_transaction("Get_all_users");
	
	// GET users	
	web_rest("GET_users",
		"URL={URL}/{GET_USERS}",
		"Method=GET",
		"Snapshot=t202223.inf",
		LAST);
	
	lr_output_message("MSG_LOG: Transaction GET ALL USERS is successfully");
		
	lr_end_transaction("Get_all_users",LR_AUTO);
	
	lr_think_time(1);
	
	lr_start_transaction("Get_user_id");
	
	// GET user id	
	web_rest("GET_user_id",
		"URL={URL}/{GET_USER_ID}{USER_ID}",
		"Method=GET",
		"Snapshot=t202223.inf",
		LAST);

	lr_output_message("MSG_LOG: Transaction GET USER by LAST CREATED ID is successfully");
		
	lr_end_transaction("Get_user_id",LR_AUTO);
	
	
//	lr_start_transaction("Get_user_id_any");
//	
//	// GET user id	ANY
//	web_rest("GET_user_id",
//		"URL={URL}/{GET_USER_ID}1",
//		"Method=GET",
//		"Snapshot=t202223.inf",
//		LAST);
//	
//	
//	lr_end_transaction("Get_user_id_any",LR_AUTO);
	
	return 0;
}

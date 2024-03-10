vuser_init()
{
	lr_save_timestamp("startTime", "DIGITS=10", LAST ); //lr_output_message(lr_eval_string("{startTime}"));
	lr_output_message("MSG_LOG: START SCRIPT TIME= %s", lr_eval_string("{CURRTIME}"));
		
//	web_reg_save_param_json("Param=Trip1", "QueryString=$..data", SEARCH_FILTERS, "Scope=Body", LAST); //покажет значения
//	web_reg_save_param_json("Param=Response_status", "QueryString=$.status", SEARCH_FILTERS, "Scope=Body", LAST); //покажет статус в ответе
	
	return 0;
}

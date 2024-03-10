vuser_end()
{
	lr_output_message("MSG_LOG: END SCRIPT TIME= %s", lr_eval_string("{CURRTIME}"));
	
	lr_save_timestamp("endTime", "DIGITS=10", LAST );//	lr_output_message(lr_eval_string("{endTime}"));
	
	lr_save_int(atoi(lr_eval_string("{endTime}"))-atoi(lr_eval_string("{startTime}")),"secTime");
	lr_output_message("MSG_LOG: ELAPSED TOTAL SCRIPT TIME, sec: %s", lr_eval_string("{secTime}"));
		
//	lr_save_int(atoi(lr_eval_string("{secTime}"))/atoi(lr_eval_string("{ITERSUM}")),"secAvgTime");
	lr_save_int((atoi(lr_eval_string("{secTime}"))+(atoi(lr_eval_string("{ITERSUM}"))-1))/atoi(lr_eval_string("{ITERSUM}")),"secAvgTime");
	lr_output_message("MSG_LOG: ELAPSED AVERAGE ITERATION SCRIPT TIME, sec: %s", lr_eval_string("{secAvgTime}"));
	
	return 0;
}

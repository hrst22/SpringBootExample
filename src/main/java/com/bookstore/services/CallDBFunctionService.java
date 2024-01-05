/**
 * 
 */
package com.bookstore.services;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

/**
 * @author Harshit Palan
 *
 */
@Service
public class CallDBFunctionService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int callDBFunction() {
		int returnVal = -1;
		SimpleJdbcCall call = new SimpleJdbcCall(this.jdbcTemplate)
				.withSchemaName("test")
				.withFunctionName("new_function");
		
		returnVal = call.executeFunction(Integer.class);
		
		return returnVal;
	}
	
	public String callDBProcedure() {
		String returnVal = null;
		SimpleJdbcCall call = new SimpleJdbcCall(this.jdbcTemplate).withProcedureName("new_procedure");
		SqlParameterSource inOutParams = new MapSqlParameterSource().addValue("returnval", returnVal);
		 
		Map<String, Object> outParams = call.execute(inOutParams);
		
		returnVal = (String) outParams.get("returnval");
		
		return returnVal;
	}
}

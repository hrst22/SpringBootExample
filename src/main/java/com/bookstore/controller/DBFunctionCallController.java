/**
 * 
 */
package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.services.CallDBFunctionService;

/**
 * @author Harshit Palan
 *
 */
@Controller
@RequestMapping("testservice")
public class DBFunctionCallController {
	
	@Autowired
	CallDBFunctionService dbFunServ;
	
	@GetMapping("callfunction")
	public ResponseEntity<Integer> callDBFunction() {
		int retrunVal = dbFunServ.callDBFunction();
		return new ResponseEntity<Integer>(retrunVal, HttpStatus.OK);
		
	}
	
	@GetMapping("callProcedure")
	public ResponseEntity<String> callDBProcedure() {
		String retrunVal = dbFunServ.callDBProcedure();
		return new ResponseEntity<String>(retrunVal, HttpStatus.OK);
		
	}
	
	

}

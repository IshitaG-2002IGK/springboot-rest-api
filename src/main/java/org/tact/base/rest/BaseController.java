package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class BaseController {
	
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public <T> T getCities() {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	
    	List<String> cityLis1 = new LinkedList<String>();
    	cityLis1.add("Waterloo");
    	cityLis1.add("Toronto");
        map.put("Ontario", cityLis1);

    	
    	List<String> cityLis2 = new LinkedList<String>();
    	cityLis2.add("Madurai");
    	cityLis2.add("Chennai");
        map.put("TN", cityLis2);
        
        
        return (T) map;
    
    		
    }
    
    @RequestMapping(value = "/cities/{state}", method = RequestMethod.GET)
    public <T> T findUserById(@PathVariable(value = "state")String state) {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	
    	List<String> cityLis1 = new LinkedList<String>();
    	cityLis1.add("Waterloo");
    	cityLis1.add("Toronto");
        map.put("Ontario", cityLis1);
        
        List<String> cityLis2 = new LinkedList<String>();
    	cityLis2.add("Madurai");
    	cityLis2.add("Chennai");
        map.put("TN", cityLis2);
        
 
        if ((state).equalsIgnoreCase("Ontario")) {
        	return (T) cityLis1;
        }
        
        else if ((state).equalsIgnoreCase("TN")){
        	return (T) cityLis2;
        }
        
        else {
        	return (T) ("NOT FOUND!!");
        }
    }
}
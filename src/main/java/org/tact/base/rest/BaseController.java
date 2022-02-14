
//  Source: https://careydevelopment.us/blog/spring-boot-how-to-use-pathvariable-in-rest-apis


package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    	cityLis2.add("Theni");
    	
    	map.put("Tamilnadu",cityLis2);
        
        return (T) map;
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/cities/{state}", method = RequestMethod.GET)
    public <T> T findUserById(@PathVariable(value = "state") String state) {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	
        if ((state).equalsIgnoreCase("Ontario")) {
        	List<String> onCityList = new LinkedList<String>();
        	onCityList.add("Waterloo");
        	onCityList.add("Toronto");
        	
        	map.put("Ontario", onCityList);
        	
        	return makeHTTPResult(HttpStatus.OK, map);
        }
        
        if ((state).equalsIgnoreCase("Tamilnadu")) {
        	List<String> tnCityList = new LinkedList<String>();
        	tnCityList.add("Madurai");
        	tnCityList.add("Theni");
        	
        	map.put("Tamilnadu",tnCityList);
        	
        	return makeHTTPResult(HttpStatus.OK, map);
        }
        
        List<String> emptyCityList = new LinkedList<String>();
    	emptyCityList.add("Not Found");
    	map.put(state, emptyCityList);
    	
    	return makeHTTPResult(HttpStatus.NOT_FOUND, map);
    }
    
    @SuppressWarnings("unchecked")
	private <T> T makeHTTPResult(HttpStatus status, Map<String, Object> map) {
    	return (T) ResponseEntity.status(status).body(map);
    }
}

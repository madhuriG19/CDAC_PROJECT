package com.app.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Center;
import com.app.service.ICenterService;


@RestController // => @Controller at class level +
	//@ResponseBody annotation added on ret types of all req handling methods
//@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
	@RequestMapping("/center")
	public class CenterController {
		// dependency
		@Autowired
		private ICenterService service;
	

		public CenterController() {
			System.out.println("in ctor of " + getClass().getName());
		}

		// RESTful end point or API end point or API provider
		@GetMapping
		public ResponseEntity<?> listAllCenter() {
			System.out.println("in list all ");
			// invoke service layer's method : controller --> service impl (p) --->JPA
			// repo's impl class(SC)
			List<Center> center = service.getAllCenters();
			if (center.isEmpty())
				// empty  list : set sts code : HTTP 204 (no contents)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// in case of non empty list : OK, send the list
			return  ResponseEntity.ok(center);  //200 ok
		}

		// get prduct details by its name : supplied by clnt using path var
		@GetMapping("/{centerId}")
		public ResponseEntity<?> getCenterDetailsById(@PathVariable int centerId) {
		System.out.println("in get  details " + centerId);
			// invoke service method
			Center centerDetails = service.getCenterDetailsById(centerId);
			// valid name : HTTP 200 , marshalled center details
		if (centerDetails!=null)
		return ResponseEntity.ok(centerDetails);
			// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		  @GetMapping("/{centerName}")
		  public ResponseEntity<?>getCenterDetails(@PathVariable String CenterName) 
		  {
		  System.out.println("in get  details " + CenterName); 
		  // invoke s  method
		  Center Details = service.getCenterDetails(CenterName);
		  //valid name : HTTP 200 , marshalled center details 
		  if (Details!=null)
		  return ResponseEntity.ok(Details); // in case of invalid name : HTTP404
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  }
		 
		
		
		  @PostMapping 
		  public ResponseEntity<?> addCenterDetails(@RequestBody @Valid Center p)
		  {
		  System.out.println("in add center " + p); 
		  
		  try { 
			  Center c =service.addCenterDetails(p); 
			  return  ResponseEntity.ok(c);
		  
		  }
		  catch (RuntimeException e) 
		  {
			  e.printStackTrace(); 
			  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
			  }
		  }
		  
		  
		 @PutMapping("/{centerID}") 
		    public ResponseEntity<?> updateCenterDetails(@PathVariable int centerID, @RequestBody Center p) 
		 {
		  System.out.println("in update " + centerID + " " + p); 
		  try 
		  {
			  Center updatedDetails = service.updateCenterDetails(centerID, p); 
			  return  ResponseEntity.ok(updatedDetails); 
			  } 
		  catch (RuntimeException e)
		  { 
			  e.printStackTrace(); return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  }
		  
		 }
		 @DeleteMapping("/{centerID}")
		 public String deleteCenter(@PathVariable int centerID)
		 {
			 System.out.println("in delete center"+centerID);
			 return service.deleteCenter(centerID);
			 
		 }
		 
	}




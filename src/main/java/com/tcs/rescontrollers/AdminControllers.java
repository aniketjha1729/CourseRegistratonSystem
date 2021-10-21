/**
 * 
 */
package com.tcs.rescontrollers;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import org.springframework.http.ResponseEntity;
import com.tcs.bean.Course;
import com.tcs.exception.UserNotFoundException;
import com.tcs.service.AdminInterFace;
import com.tcs.service.StudentInterFace;

/**
 * @author Aniket
 *
 */
@RestController
@CrossOrigin
public class AdminControllers {
	
	@Autowired
	private AdminInterFace admin;
	
	@RequestMapping(value="/admin/login",method=RequestMethod.POST)
	public ResponseEntity loginAdmin(@QueryParam("adminuserName") String adminuserName,@QueryParam("adminPassword") String adminPassword) throws UserNotFoundException {
		boolean loginStatus = admin.loginAdmin(adminuserName, adminPassword);
		if (loginStatus) {	
			return new ResponseEntity("Login Successful", HttpStatus.OK);
		}else {
			return new ResponseEntity("User Name or Password is incorrect ", HttpStatus.NOT_FOUND);

		}
	}
	
	@RequestMapping(value="/admin/addCourse",method=RequestMethod.POST)
	public Response addCourese(@RequestBody Course course ) {
		List<Course> courseList = admin.viewCourses();
		try {
			admin.addCourse(course,courseList);
			return Response.status(201).entity("Course with courseCode: " + course.getCourseCode() + " added to catalog").build();
		} catch (Exception e) {
			return Response.status(409).entity(e.getMessage()).build();
		}
			
	}
	
	
}
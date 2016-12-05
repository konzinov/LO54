/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.school_manager.subscription;

import com.mysite.entity.Course;
import com.mysite.service.CourseService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author konzinov
 */
@ManagedBean(name = "showCourses")
@RequestScoped
public class showCourses implements Serializable {
    
    
    private List<Course> courses = new ArrayList<Course>();
    private CourseService courseService = new CourseService(Course.class);
    /**
     * Creates a new instance of showCourses
     */
    public showCourses() {
       courses = courseService.getAll();       
    }
    
    @PostConstruct
    public void init(){
   //     courses = courseService.getAll();
        
    }
    
    public List<Course> getCourses(){
        return courses;
    }
    
    
}

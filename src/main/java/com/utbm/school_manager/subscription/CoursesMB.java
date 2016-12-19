/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.school_manager.subscription;

import com.mysite.entity.Course;
import com.mysite.service.CourseService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author konzinov
 */
@ManagedBean(name = "courseMB")
@ViewScoped
public class CoursesMB implements Serializable {
    
    
    private List<Course> courses ;
    private List<Course> filteredCourses ;
    private CourseService courseService = new CourseService(Course.class);
    
    /**
     * Creates a new instance of showCourses
     */
    public CoursesMB() {      
    }
    
    @PostConstruct
    public void init(){
         courses = courseService.getAll(); 
    }
    
    public List<Course> getCourses(){
        return courses;
    }

    public List<Course> getFilteredCourses() {
        return filteredCourses;
    }

    public void setFilteredCourses(List<Course> filteredCourses) {
        this.filteredCourses = filteredCourses;
    }

}

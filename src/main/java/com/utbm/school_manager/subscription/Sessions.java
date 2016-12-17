/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.school_manager.subscription;

import com.mysite.entity.CourseSession;
import com.mysite.service.CourseSessionService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Rémi
 * 
 * 
 * 
 */
@ManagedBean(name = "sessions")
@ApplicationScoped
public class Sessions implements Serializable{
    
    private CourseSessionService courseSessionService = new CourseSessionService(CourseSession.class);
    private Map<String,String> sessionCriteria = new HashMap<String,String>();
    private List<CourseSession> sessionList = new ArrayList<CourseSession>();
    private String courseId;

    public Sessions() {
    }

    public List<CourseSession> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<CourseSession> sessionList) {
        this.sessionList = sessionList;
    }
    
    @PostConstruct
    public void init(){
        sessionCriteria.put("course_id", courseId);
        sessionList = courseSessionService.showSessionFromCriteria(sessionCriteria);
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    public CourseSessionService getCourseSessionService() {
        return courseSessionService;
    }

    public void setCourseSessionService(CourseSessionService courseSessionService) {
        this.courseSessionService = courseSessionService;
    }

    public Map<String, String> getSessionCriteria() {
        return sessionCriteria;
    }

    public void setSessionCriteria(Map<String, String> sessionCriteria) {
        this.sessionCriteria = sessionCriteria;
    }    
}

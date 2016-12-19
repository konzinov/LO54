/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.school_manager.main;

import com.mysite.entity.CourseSession;
import com.mysite.service.CourseSessionService;
import com.utbm.school_manager.subscription.RegisterationMB;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author konzinov
 */
@ManagedBean(name = "home")
@SessionScoped
public class Home implements Serializable{

    /**
     * Creates a new instance of home
     */
    
    private List<CourseSession> incomingSessions;
    private CourseSessionService courseSessionService;
    private CourseSession selectedCourseSession ;
    
   
    public Home() {
        courseSessionService = new CourseSessionService(CourseSession.class);
        selectedCourseSession = new CourseSession();
    }
   
    
    @PostConstruct
    public void init(){
        incomingSessions = courseSessionService.showIncomingSessions();
    }

    public List<CourseSession> getIncomingSessions() {
        return incomingSessions;
    }

    public void setIncomingSessions(List<CourseSession> incomingSessions) {
        this.incomingSessions = incomingSessions;
    }

    public CourseSession getSelectedCourseSession() {
        return selectedCourseSession;
    }

    public void setSelectedCourseSession(CourseSession selectedCourseSession) {
        this.selectedCourseSession = selectedCourseSession;
    }

}

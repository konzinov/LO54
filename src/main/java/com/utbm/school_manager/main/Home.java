/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.school_manager.main;

import com.mysite.entity.CourseSession;
import com.mysite.service.CourseSessionService;
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
    private CourseSessionService courseSessionService = new CourseSessionService(CourseSession.class);
    private CourseSession selectedCourseSession ;
    public Home() {
        
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
    
    public void showRegisterationFrom(){
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        List<String> courseSessionIdValue = new ArrayList<>();
         List<String> courseTitleValue = new ArrayList<>();
         
        courseSessionIdValue.add(""+selectedCourseSession.getId());
        Map<String,List<String>> params = new HashMap<>();
        params.put("courseSessionId",courseSessionIdValue);
        
        courseTitleValue.add(selectedCourseSession.getCourse().getTitle());
        params.put("courseTitle", courseTitleValue);
        RequestContext.getCurrentInstance().openDialog("registerationForm", options, params);
    }
    
    public void onRegisterationComplete(SelectEvent event){
        Boolean registerationStatus = (Boolean) event.getObject();
        if(registerationStatus){
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Registeration successful", "See you!")
                );
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registeration failed", "Please, retry")
                );
        }
    }

    public CourseSession getSelectedCourseSession() {
        return selectedCourseSession;
    }

    public void setSelectedCourseSession(CourseSession selectedCourseSession) {
        this.selectedCourseSession = selectedCourseSession;
    }

 
   
    
    
}

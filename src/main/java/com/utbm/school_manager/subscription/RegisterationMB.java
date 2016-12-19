/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.school_manager.subscription;

import com.mysite.entity.Client;
import com.mysite.entity.Course;
import com.mysite.entity.CourseSession;
import com.mysite.service.ClientService;
import com.mysite.service.CourseSessionService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.Request;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author konzinov
 */
@ManagedBean(name = "registerationMB")
@ViewScoped
public class RegisterationMB implements Serializable{
    
    private Integer sessionId;
    private String courseTitle;
    private Client clientToRegister = new Client();
    private CourseSessionService courseSessionService = new CourseSessionService(CourseSession.class);
    private ClientService clientService = new ClientService(Client.class);

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }


    public Client getClientToRegister() {
        return clientToRegister;
    }

    public void setClientToRegister(Client clientToRegister) {
        this.clientToRegister = clientToRegister;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    
    
    public void registerClient(){
        this.clientToRegister.setCourseSession(courseSessionService.get(this.sessionId));
        Boolean status = true;
        try{
            this.clientService.add(clientToRegister);
        }
        catch(Exception e){
            status = false;
        }
        RequestContext.getCurrentInstance().closeDialog(status);
    }
    
    
    public void showRegisterationFrom(CourseSession selectedCourseSession){
        
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
}

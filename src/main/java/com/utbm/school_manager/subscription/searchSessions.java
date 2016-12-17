/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.school_manager.subscription;

import com.mysite.entity.CourseSession;
import com.mysite.entity.Location;
import com.mysite.service.CourseSessionService;
import com.mysite.service.LocationService;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Rémi
 */
@ManagedBean(name="searchSessions")
@ApplicationScoped
public class searchSessions {
    
    private Date date;
        
    private CourseSessionService courseSessionService = new CourseSessionService(CourseSession.class);
    private Map<String,String> sessionCriteria = new HashMap<String,String>();
    private List<CourseSession> sessionList = new ArrayList<CourseSession>();
    
    private LocationService locationService = new LocationService(Location.class);
    private Location location;
    private List<String> locationList;
    
    private String title;
       
    //Calendar method
    public void onDateSelect(SelectEvent event){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Date selected",format.format(event.getObject())));
    }
    
    public void click(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    //OneMenu method

    @PostConstruct
    public void init(){
        List<Location> tmp_list = locationService.getAll(); 
        for(int i = 0 ; i < tmp_list.size() ; i++){
            locationList.add(tmp_list.get(i).getCity());
        }
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

    public List<CourseSession> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<CourseSession> sessionList) {
        this.sessionList = sessionList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<String> locationList) {
        this.locationList = locationList;
    }
    
    //Button method
    
    public void buttonAction(ActionEvent actionEvent){
        if(date != null){
            sessionCriteria.put("date",date.toString());
        }
        if(location != null){
            sessionCriteria.put("location_id", location.getId().toString());
        }
        //add the title criteria
        
        sessionList = courseSessionService.showSessionFromCriteria(sessionCriteria);
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

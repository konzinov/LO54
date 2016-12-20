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
import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rémi
 */
@ManagedBean(name="searchSessions")
@ViewScoped
public class SearchSessions  implements Serializable{
    
    private Date date;
        
    private CourseSessionService courseSessionService = new CourseSessionService(CourseSession.class);
    private Map<String,String> sessionCriteria = new HashMap<String,String>();
    private LocationService locationService = new LocationService(Location.class);
    private Location location;
    private String title;
    private CourseSession selectedCourseSession = new CourseSession();
    private List<CourseSession> foundSessions = new ArrayList<CourseSession>();
    
       
    public CourseSession getSelectedCourseSession() {
        return selectedCourseSession;
    }

    public void setSelectedCourseSession(CourseSession selectedCourseSession) {
        this.selectedCourseSession = selectedCourseSession;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    

    public List<CourseSession> getFoundSessions() {
        return foundSessions;
    }

    public void setFoundSessions(List<CourseSession> foundSessions) {
        this.foundSessions = foundSessions;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    

    @PostConstruct
    public void init(){
      
    }

    public List<Location> completeLocations(String locationName){
        List<Location> allLocations = locationService.getAll();
        List<Location> filteredLocations = new ArrayList<Location>();
        Iterator<Location> locationIterator = allLocations.iterator();
        while(locationIterator.hasNext()){
            Location currentLocation = locationIterator.next();
            if(currentLocation.getCity().toLowerCase().startsWith(locationName)){
                 filteredLocations.add(currentLocation);
                
            }
        }
        
        return filteredLocations;
    }
    
    public void searchSessions(){
        if(location!=null){
            this.sessionCriteria.put("location_id", location.getId().toString());
        }
        this.sessionCriteria.put("course_title",title);
        if(date!=null){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            this.sessionCriteria.put("date",formatter.format(date));
        }
        foundSessions = courseSessionService.showSessionFromCriteria(sessionCriteria);
    }
}

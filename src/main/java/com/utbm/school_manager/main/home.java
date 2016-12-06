/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.school_manager.main;

import com.mysite.entity.CourseSession;
import com.mysite.service.CourseSessionService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author konzinov
 */
@ManagedBean(name = "home")
@ApplicationScoped
public class home {

    /**
     * Creates a new instance of home
     */
    
    private List<CourseSession> incomingSessions;
    private CourseSessionService courseSessionService = new CourseSessionService(CourseSession.class);
    public home() {
        
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
    
    
}

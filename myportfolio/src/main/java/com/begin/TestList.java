package com.begin;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class TestList implements HttpSessionListener {

    public static final Set<String> activesessions = new HashSet<>();

    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("inside session created : " + se.getSession().getId());
        activesessions.add(se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("inside session destroy :" +  se.getSession().getId());
    }
    
    public static Set<String> getActiveSessions() {
        return activesessions;
    }
	
}

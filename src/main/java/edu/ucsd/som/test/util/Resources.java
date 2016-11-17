/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.ucsd.som.test.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.ucsd.som.service.badgws.auth.BadgIdentity;
import edu.ucsd.som.service.badgws.auth.BadgUser;
import edu.ucsd.som.test.annotation.LoggedInUcsdId;

/**
 * This class uses CDI to alias Java EE resources, such as the persistence context, to CDI beans
 * 
 * <p>
 * Example injection on a managed bean field:
 * </p>
 * 
 * <pre>
 * &#064;Inject
 * private EntityManager em;
 * </pre>
 */
public class Resources {
		
    // use @SuppressWarnings to tell IDE to ignore warnings about field not being referenced directly
/*    @Produces
    @PersistenceContext
    private EntityManager em;*/  
    
    @Produces
    public Log produceLog(InjectionPoint injectionPoint) {
    	return LogFactory.getLog(injectionPoint.getMember().getDeclaringClass().getName());
    }    
        
    @Inject
    private BadgIdentity badgIdentity;
    
    @Produces
    @LoggedInUcsdId
    public Integer getLoggedInUcsdId() {
    	    	
		// TODO verify if this is the correct method to get employeeUcsdId
    	BadgUser user = badgIdentity.getUser();
		Integer ucsdId = Integer.parseInt(user.getLoginName());
    	return ucsdId; 
    }
}
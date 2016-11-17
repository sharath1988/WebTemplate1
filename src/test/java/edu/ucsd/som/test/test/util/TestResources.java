package edu.ucsd.som.test.test.util;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.ucsd.som.test.annotation.LoggedInUcsdId;

/**
 * Test Producer for JUNIT
 * 
 * @author somdev5
 *
 */
public class TestResources {

    // use @SuppressWarnings to tell IDE to ignore warnings about field not being referenced directly
/*    @Produces
    @PersistenceContext
    private EntityManager em;  */

    @Produces
    public Log produceLog(InjectionPoint injectionPoint) {
        return LogFactory.getLog(injectionPoint.getMember().getDeclaringClass().getName());
    }
        
    @Produces
    @LoggedInUcsdId
    public Integer getLoggedInUcsdId() {
    	System.out.println("Using TestResources.java");
    	return new Integer("209166");
    }
}

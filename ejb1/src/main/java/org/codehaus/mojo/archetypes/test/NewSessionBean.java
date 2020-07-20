/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.codehaus.mojo.archetypes.test;

import org.codehaus.mojo.archetypes.test.camel.DistributeOrderDSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author rjh
 */
@Stateless
@LocalBean
public class NewSessionBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewSessionBean.class);


    public NewSessionBean(){
        LOGGER.info("NewSessionBean ctor DistributeOrderDSL");
        try {
            DistributeOrderDSL.camelGo();
        } catch (Exception e) {
            LOGGER.error("NewSessionBean error camel", e);
        }
    }
    public void businessMethod() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public float add(float x, float y) {
        return x + y;
    }

}

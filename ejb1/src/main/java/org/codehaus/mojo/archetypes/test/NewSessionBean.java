/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.codehaus.mojo.archetypes.test;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author rjh
 */
@Stateless
@LocalBean
public class NewSessionBean {

    public void businessMethod() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public float add(float x, float y) {
        return x + y;
    }

}

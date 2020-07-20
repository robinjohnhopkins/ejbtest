/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
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
package org.codehaus.mojo.archetypes.test.controller;

import org.codehaus.mojo.archetypes.test.GreeterEJB;
import org.codehaus.mojo.archetypes.test.NewSessionBean;
import org.codehaus.mojo.archetypes.test.OperationsSessionBeanRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.*;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * A simple managed bean that is used to invoke the GreeterEJB and store the
 * response. The response is obtained by invoking getMessage().
 *
 * see https://www.baeldung.com/java-ee-singleton-session-bean
 *
 *
 */
@Named("greeter")
//@SessionScoped - this one is not created straight away
@Singleton
@Startup
//@DependsOn({"DependentBean1", "DependentBean2"})
//@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER) DEFAULT see @Lock below
//@ConcurrencyManagement(ConcurrencyManagementType.BEAN) use synchronized keyword
public class Greeter implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Greeter.class);

    /** Default value included to remove warning. **/
    private static final long serialVersionUID = 1L;

    public Greeter(){
        LOGGER.info("Greeter ctor");
    }

    /**
     * Injected GreeterEJB client
     */
    @EJB
    private GreeterEJB greeterEJB;

    @EJB
    private NewSessionBean newSessionBean;

    @EJB
    OperationsSessionBeanRemote operationsSessionBeanRemote;


    /**
     * Stores the response from the call to greeterEJB.sayHello(...)
     */
    private String message;


//    private final Map<String, List<String> countryStatesMap = new HashMap<>();
//
//    @Lock(LockType.READ)
//    public List<String> getStates(String country) {
//        return countryStatesMap.get(country);
//    }
//
//    @Lock(LockType.WRITE)
//    public void setStates(String country, List<String> states) {
//        countryStatesMap.put(country, states);
//    }


    /**
     * Invoke greeterEJB.sayHello(...) and store the message
     *
     * @param name
     *            The name of the person to be greeted
     */
    public void setName(String name) {
        message = greeterEJB.sayHello(name);
    }

    /**
     * Get the greeting message, customized with the name of the person to be
     * greeted.
     *
     * @return message. The greeting message.
     */
    public String getMessage() {
        float sum = operationsSessionBeanRemote.add(1.2F, 2.2F);
        return message + sum;
    }

}

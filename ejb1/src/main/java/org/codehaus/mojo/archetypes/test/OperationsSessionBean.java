package org.codehaus.mojo.archetypes.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class OperationsSessionBean implements OperationsSessionBeanRemote {
    static Logger LOGGER = LoggerFactory.getLogger(OperationsSessionBean.class);

    public OperationsSessionBean() {
        LOGGER.info("OperationsSessionBean ctor ");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public float add(float x, float y) {
        return x + y;
    }

    @Override
    public float subtract(float x, float y) {
        return x - y;
    }

    @Override
    public float mutliply(float x, float y) {
        return x * y;
    }

    @Override
    public float divide(float x, float y) {
        return x / y;
    }
}


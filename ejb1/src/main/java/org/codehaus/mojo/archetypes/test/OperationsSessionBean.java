package org.codehaus.mojo.archetypes.test;

import javax.ejb.Stateless;

@Stateless
public class OperationsSessionBean implements OperationsSessionBeanRemote {

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


package org.codehaus.mojo.archetypes.test.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogBean implements Processor {
    static Logger LOG = LoggerFactory.getLogger(MyLogBean.class);
    public void process(Exchange msg) {
        LOG.info("MyLogBean process {}", msg);
    }
    public String hello(String name) {
        LOG.info("MyLogBean hello {}", name);
        System.out.println("MyLogBean " + name);
        return "Hello " + name;
    }
}

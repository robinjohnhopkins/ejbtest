package org.codehaus.mojo.archetypes.test.camel;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {
    private MyLogBean myLogBean = new MyLogBean();

    @Override
    public void configure() throws Exception {
        from("file:/Users/robinjohnhopkins/workspace/ejbtest/cameldata/in?noop=true")
                .choice()
                .when(header("CamelFileName").endsWith(".xml"))
                    .bean(myLogBean, "hello")
                    .to("file:/Users/robinjohnhopkins/workspace/ejbtest/cameldata/outputFolder")
                    //.to("jms:xmlOrders")
                .when(header("CamelFileName").regex("^.*(csv|csl)$"))
                    .to("file:/Users/robinjohnhopkins/workspace/ejbtest/cameldata/outputFolder2")
                .otherwise()
                    .to("file:/Users/robinjohnhopkins/workspace/ejbtest/cameldata/data");


    }

}

package org.codehaus.mojo.archetypes.test.camel;

import org.slf4j.*;
import org.apache.camel.*;
import org.apache.camel.builder.*;

import java.time.Instant;

public class TimerRouteBuilder extends RouteBuilder {
    static Logger LOG = LoggerFactory.getLogger(TimerRouteBuilder.class);
    public void configure() {
        from("timer://timer1?period=60000")
        .process(new Processor() {
            public void process(Exchange msg) {
                String camelFileName = "time"+Instant.now().toString();
                msg.getOut().setBody("made up body " + camelFileName);
                msg.getOut().setHeader("CamelFileAbsolutePath", camelFileName);

                LOG.info("Processing {}", msg);
            }
        })
        .to("file:/Users/robinjohnhopkins/workspace/ejbtest/cameldata/data");;
    }
}

package org.codehaus.mojo.archetypes.test.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.component.bean.RegistryBean;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.camel.builder.xml.XPathBuilder.xpath;

public class DistributeOrderDSL {
    private static final Logger LOGGER = LoggerFactory.getLogger(DistributeOrderDSL.class);

    static CamelContext context = null;
    public static void camelStop() throws Exception {
        if (context != null) {
            context.stop();
            context = null;
        }
    }
    public static void camelGo() throws Exception {
        if (context == null) {
            CamelContext context = new DefaultCamelContext();
            SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
            context.addRoutes(routeBuilder);
            TimerRouteBuilder routeBuilder2 = new TimerRouteBuilder();
            context.addRoutes(routeBuilder2);

            // RegistryBean.getBean();

            context.setTracing(true);
            context.start();
            LOGGER.info("camelGo");
        }

//        CamelContext context = new DefaultCamelContext();
//        SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
//        try {
//            context.addRoutes(new RouteBuilder() {
//                @Override
//                public void configure() throws Exception {
//                    from("direct:DistributeOrderDSL")
//                            .split(xpath("//order[@product='soaps']/items")).to("stream:out");
//
//                    // .to("file:src/main/resources/order/");
//                }
//               context.addRoutes(routeBuilder);
//            });
//            context.start();
//            Thread.sleep(5 * 60 * 1000);
//            ProducerTemplate orderProducerTemplate = context.createProducerTemplate();
//            InputStream orderInputStream = new FileInputStream(ClassLoader.getSystemClassLoader()
//                    .getResource("order.xml").getFile());
//            orderProducerTemplate.sendBody("direct:DistributeOrderDSL", orderInputStream);
//        } finally {
//            context.stop();
//        }
    }
}




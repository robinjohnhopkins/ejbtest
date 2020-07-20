## ear containing ejb and war

## non-rest

http://localhost:8080/smeg/



## rest

http://localhost:8080/smeg/rest/contacts
```
[]
[{"id":1,"name":"bob2","phoneNumber":"123","savedBy":"bill"}]
```


http://localhost:8080/smeg/rest/contacts/test2
 - adds a contact
 
```
 {"id":1,"name":"bob2","phoneNumber":"123","savedBy":"bill"}
```
 
 
 http://localhost:8080/smeg/rest/contacts/greet
 
```
 {"id":1,"name":"Hello bobmeh","phoneNumber":"123","savedBy":"bill"}
```
 
NB: That one shows usage of

```
      @Inject private Greeter greeter;
```
Whereby javaee has instantiated Greeter

        
```
      @EJB
        private GreeterEJB greeterEJB;
 ```
Wherein the war has use of EJB defined in ejb.
        

## jboss-deployment-structure.xml

adding this does not seem to change anything

ear1/src/main/webapp/WEB-INF/jboss-deployment-structure.xml

changing ear1/pom.xml

which DID set smeg as context - causes default context to kick in

e.g.
http://127.0.0.1:8080/webapp1/

http://127.0.0.1:8080/webapp1/rest/contacts/greet

```
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-ear-plugin</artifactId>
                <version>2.3.2</version>
                <!-- configuring the EAR plug-in -->
                <configuration>
                    <!-- Tell Maven we are using Jakarta EE -->
                    <!--<version>7</version>-->
                    <!-- Use Jakarta EE ear libraries as needed. Jakarta EE ear libraries
                        are in easy way to package any libraries needed in the ear, and automatically
                        have any modules (EJB-JARs and WARs) use them -->
                    <defaultLibBundleDir>lib</defaultLibBundleDir>
                    <modules>
                        <!-- Default context root of the web app is /ejb-in-ear-web.
                        If a custom context root is needed, uncomment the following snippet to
                        register our War as a web module and set the contextRoot property -->
                        <!--<webModule>-->
                            <!--<groupId>org.codehaus.mojo.archetypes.test</groupId>-->
                            <!--<artifactId>webapp1</artifactId>-->
                            <!--<contextRoot>/smeg</contextRoot>-->

                        <!--</webModule>-->
                        <!--<ejbModule>-->
                            <!--<groupId>org.codehaus.mojo.archetypes.test</groupId>-->
                            <!--<artifactId>ejb1</artifactId>-->
                        <!--</ejbModule>-->
                    </modules>
                    <outputFileNameMapping>@{artifactId}@@{dashClassifier?}@.@{extension}@</outputFileNameMapping>
                </configuration>
            </plugin>

```

http://127.0.0.1:8080/webapp1/rest/contacts/camel


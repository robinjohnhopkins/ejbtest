## ear containing ejb and war

## non-rest

http://localhost:8080/smeg/



## rest

http://localhost:8080/smeg/rest/contacts
[]
[{"id":1,"name":"bob2","phoneNumber":"123","savedBy":"bill"}]


http://localhost:8080/smeg/rest/contacts/test2
 - adds a contact
 
 {"id":1,"name":"bob2","phoneNumber":"123","savedBy":"bill"}
 
 
 http://localhost:8080/smeg/rest/contacts/greet
 
 {"id":1,"name":"Hello bobmeh","phoneNumber":"123","savedBy":"bill"}
 
 NB: That one shows usage of
    1)     @Inject private Greeter greeter;
        Whereby javaee has instantiated Greeter
        
    2)     @EJB
           private GreeterEJB greeterEJB;
        Wherein the war has use of EJB defined in ejb.
        

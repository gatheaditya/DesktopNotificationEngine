<b>Desktop Notification Engine</b>

Desktop Engine can fetch the Notification from a Endpoint(API) and then add the details from the Endpoint response to the system tray


Download the Source code and add change the Application properties to add the URL to fetch the notification from and add a vm parameter while runing the jar 

<b>-Djava.awt.headless=false</b>

THe Notification is Configured to Trigger Every 5 Sec can be changed by change the cron Expression in the porperties file
for detailed cron expression list please

 TO Build a Jar with properties file ADD the following  to pom.xml and build 
 
```
       <build>
          <resources>
              <resource>
                  <directory>src/main/java</directory>
                  <includes>
                      <include>**/*.properties</include>
                  </includes>
              </resource>
          </resources>
  ```

<b>Desktop Notification Engine</b>

Download the Source code and add change the Application properties to add the URL to fetch the notification from and add a vm parameter while runing the jar 

-Djava.awt.headless=false

 TO Build a Jer with properties file ADD the following  to pom.xml and build the jar
 
 
 <build>
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
            </includes>
        </resource>
    </resources>

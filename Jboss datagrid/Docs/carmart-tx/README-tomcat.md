carmart-tx: Basic Infinispan example with transactions
=================================================================
Author: Tristan Tarrant, Martin Gencur
Level: Intermediate
Technologies: Infinispan, CDI, Transactions
Summary: Shows how to use Infinispan instead of a relational database with transactions enabled.
Product Versions: EWS 2, JDG 6.x

What is it?
-----------

Transactional CarMart is a simple web application that uses Infinispan instead of a relational database.

Users can list cars, add new cars or remove them from the CarMart. Information about each car is stored in a cache. The application also shows cache statistics like stores, hits, retrievals, etc. 

The Transactional CarMart quickstart works in a library mode. All libraries (jar files) are bundled with the application and deployed to the server. Caches are configured programatically and run in the same JVM as the web application.

All operations are done in a transactional context. In order to run the application in JBoss Enterprise Web Server 2 (EWS) or Tomcat 7, the standalone transaction manager from JBoss Transactions is used.

When running this quickstart on JBoss Enterprise Web Server 2 or Tomcat 7, you must use only the "library-tomcat" maven profile.


System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.

The application this project produces is designed to be run on JBoss Enterprise Web Server 2 or Tomcat 7.

 
Configure EWS or Tomcat
-----------------------

Before starting EWS/Tomcat, add the following lines to `conf/tomcat-users.xml` to allow the Maven Tomcat plugin to access the manager application:

        <role rolename="manager-script"/>
        <user username="admin" password="admin" roles="manager-script"/>
        
Configure Maven
---------------

If you have not yet done so, you must [Configure Maven](../../README.md#configure-maven) before testing the quickstarts.


Add a `<server>` element into your Maven settings.xml with `<id>` equal to tomcat and correct credentials:

        <server>
            <id>tomcat</id>
            <username>admin</username>
            <password>admin</password>
        </server>

        
Start EWS or Tomcat
-------------------

1. Open a command line and navigate to the root of the EWS/Tomcat server directory.
2. The following shows the command line to start the server with the web profile:

        For Linux:   $TOMCAT_HOME/bin/catalina.sh run
        For Windows: %TOMCAT_HOME%\bin\catalina.bat run


Build and Deploy the Application in Library Mode
------------------------------------------------

1. Make sure you have started EWS/Tomcat as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn -Plibrary-tomcat clean package tomcat:deploy
        
4. This will deploy `target/jboss-carmart-tx.war` to the running instance of Tomcat/EWS.


Access the application
---------------------

The application will be running at the following URL: <http://localhost:8080/jboss-carmart-tx/>


Undeploy the Archive
--------------------

1. Make sure you have started EWS/Tomcat as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

    `mvn -Plibrary-tomcat tomcat:undeploy `


Test the Application
------------------------------------

If you want to test the application, there are simple Arquillian Selenium tests prepared.
To run these tests on Tomcat:

1. Undeploy the archive as described above
2. Stop Tomcat Server
3. Open a command line and navigate to the root directory of this quickstart.
4. Build the quickstart using:

        mvn clean package -Plibrary-tomcat

5. Type this command to run the tests:

        mvn test -Puitests-tomcat -Dtomcat7home=/path/to/server


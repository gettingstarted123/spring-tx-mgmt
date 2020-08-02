# Getting Started
aaa

### @1 Calling rest service from postman
Use the following URL :
http://localhost:8080/user/create

In the above url /user/create is defined in the 'UserController' class.
NOTE: there is no context ! 

### @2 MySql
##### @2.1Start mySql : ( run below command as administrator ) 
cd C:\construction\tools\mysql-5.7.23-winx64\bin
mysqld.exe 

##### @2.2 Connecting to database using Heidi SQL
Once server has started connect to database using heidi sql :
Connect to database with user as 'root' and no password ! at port 3306 with hostname as 127.0.0.1 and TCP/IP connection 

##### @2.3 Setting up schema and creating user and providing grant to schema 
First create the schema 'tx_mgmt' using below command:
create database tx_mgmt;

Then to use the schema use the below command:
USE tx_mgmt;

Then create a database user with below command:
create user 'tx_user'@'localhost'  identified by 'tx_user';

Finally grant the created user with privieleges to the schema :
GRANT ALL PRIVILEGES ON tx_mgmt.* TO tx_user@localhost

Once connected 
# Problems faced
### @1 Failure at application startup : 'error creating bean with name 'data source' defined in class path resource'
This error occurs because database configuration is not present.
For now to get away from this problem add to the annotation : @SpringBootApplication
Change it to : @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

For now this will allow your code to startup successfully

# Todo
### Logging 
### Exception Handling 
### Data validation 
### Add Postman collection 

# Questions
### why is there no context-root for a spring boot application ?
### how do we define a context-root for a spring boot application ?

# Learnings / Answers 



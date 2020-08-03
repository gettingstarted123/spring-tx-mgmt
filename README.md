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

Then create a database user and password with below command:
create user 'tx_user'@'localhost'  identified by 'tx_user';

Finally grant the created user with privieleges to the schema :
GRANT ALL PRIVILEGES ON tx_mgmt.* TO tx_user@localhost

##### @2.4 Creating the table in the schema:
CREATE TABLE tx_user( user_id INT PRIMARY KEY, first_name VARCHAR(255) , last_name VARCHAR(255));


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
### @1 Configuring Hikari datasource in spring boot 2
We first defined the necessary properties required to connect to database.

Next step is to define a class with @Configuration 
Then write a method that returns a Datasource 
This method is annotated with : @Bean and @ConfigurationProperties 

Here we specify what properties spring boot to read by specifying :  @ConfigurationProperties("spring.datasource")

So spring boot will read properties beginning with spring.datasource 
Ex:
spring.datasource.jdbc-url=jdbc:mysql://127.0.0.1:3306/tx_mgmt?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC

Then we create a DataSource using spring's 'DataSourceBuilder':
DataSourceBuilder.create().build()

So this is how we expose a Datasource created by reading properties defined in application.properties 
Since the method is annotated with @Bean , this datasource is now spring managed 

### @2 Injecting datasource in DAO
Since the datasource is annotated with @Bean , it is a spring managed bean .
As a result we can inject ( autowire ) it in classes that are annotated with stereo types 

So this is how we inject the datasource in Dao class ( @Repository annotated class ) 
@Repository
public class UserDao {
	
	private DataSource dataSource;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
# Conclusion / Takeaway 
### @1 This branch is an example of plain old jdbc Tx mgmt 
Here we use plain old JDBC Tx Mgmt 
From the datasource we obtain a java.sql.Connection 
We then use the traditional way of doing Tx mgmt.




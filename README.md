# Getting Started
aaa

### Reference Documentation
For further reference, please consider the following sections:

# Problems faced
### Failure at application startup : 'error creating bean with name 'datasource' defined in class path resource'
This error occurs because database configuration is not present.
For now to get away from this problem add to the annotation : @SpringBootApplication
Change it to : @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

For now this will allow your code to startup successfully

# Todo
### Logging 
### Exception Handling 
### Data validation 


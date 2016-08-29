# To run

1. Start Mongo DB service by running "mongod.exe" command line. "C:\Program Files\MongoDB\Server\3.2\bin\mongod.exe --dbpath C:\data\db" is required for db creation

2. "mvn clean package" in the project directory. "BUILD SUCCESS" should be returned

3. "mvn spring-boot:run" in the project directory. Error page should be returned from Spring boot Tomcat for URL: http://localhost:8080/

4. http://localhost:8080/metrics/read & http://localhost:8080/metrics/readByTimeRange/{startTime}/{endTime} should give expected results

5. http://localhost:8080/alerts/read & http://localhost:8080/alerts/readByTimeRange/{startTime}/{endTime} should give expected results

6. Run the Emulator and it should create the metrics using the web service

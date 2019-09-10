# WeatherInformationRequest
Weather Information service created as a solar system's forecast service that depends on the positions of the planets within the solar system

# Installation Requirements:
 - Java 1.8
 - Maven


# Hypothesis and Suppositions

* The weather periods are calculated as one single period 

* When no information is found, the weather will still be
the same as the previous day. 

* H2 In-Memory database was used to store data because it's a lightweight database that could handle the requirements asked
for this app. In addition, it shouldn't be so hard to migrate
from H2 to another RDBMS

* One year has 360 days because that's the moment when the planets
reach the starting point again and by definition, one year is the
full orbital period of every planet that belongs to this solar system.

  

# Design Solution

* Using a Chain of Responsibility design pattern to check out
different weather condition rules 
* Using a Strategy Pattern to update report with weather conditions
data.
* Using H2 as a database system
* Using Spring Boot to run the solution
* Using Heroku to deploy my application in the cloud




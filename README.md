# WeatherInformationRequest
Weather Information service created as a solar system's forecast service that depends on the positions of the planets within the solar system

# Installation Requirements:
 - Java 1.8
 - Maven
 - Heroku CLI


# Hypothesis and Suppositions

* The weather periods are calculated as one single period 

* When no information is found, the weather will still be
the same as the previous day. 

* H2 In-Memory database was used to store data because it's a lightweight database that could handle the requirements asked
for this app. In addition, it shouldn't be so hard to migrate from H2 to another RDBMS

* One year has 360 days because that's the moment when the planets
reach the starting point again and by definition, one year is the
full orbital period of every planet that belongs to this solar system.

* The planets orbit goes through 0..3599 considering that range as 10 years ( 360 days * 10 years ).

  

# Design Solution

* Using a Chain of Responsibility design pattern to check out
different weather condition rules ( see Evaluator package )
* Using a Strategy Pattern to update report with weather conditions
data. ( see Report package)
* Using H2 as a database system
* Using Spring Boot to run the solution
* Using Heroku to deploy my application in the cloud

# Problem Solution

* Every geometric problem is solved by classes in Helpers package. 
  ** PlanetsAllignment : we determine whether planets are aligned or not. To pull that off, we calculate on PlanetsAllignment::arePointsColinear if distance difference between two lines are less than a threshold. If that checks out, then we've just found that our planets are colinear. On PlanetAllignment::planetAllignmentTransition we compare between one day and it's previous day if there was a temporary alignment. To calculate that we first find angles between line segments on previous and current days. If the angle sign has changed, then we've just found that at one singular moment between two days, there was an alignment.
  ** TriangleAllignment: we determine wheter planets form a triangle shape with the sun position included inside of it. We use use Path2D.Double library to check if there's a triangle shape and if it contains the sun position. Then we use planetAllignmentTransition::calculatePerimeter to find out the peak of a maximum rain. To pull that off, we compare perimeters among previous, current, and next day. If current's perimeter is the largest, then we've reach a peak of rain.
   
# Deployment
 
  Heroku deployment was used to run this app in the cloud. The way to retrieve data is as follows:
       https://secret-harbor-95544.herokuapp.com/api/forecast/   --> Home Page
       https://secret-harbor-95544.herokuapp.com/api/forecast?day=2 --> Get weather on day 2
       https://secret-harbor-95544.herokuapp.com/api/forecast/report/all --> Get full report for next 10 years 
       https://secret-harbor-95544.herokuapp.com/api/forecast/report/statistics -> Get full statistics asked in the requirements
       
    




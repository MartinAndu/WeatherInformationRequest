# WeatherInformationRequest
Weather Information service created as a solar system's forecast service that depends on the positions of the planets within the solar system

# Installation Requirements:
 - Java 1.8
 - Maven


# Hypothesis and Suppositions

* The weather periods are calculated as one single period 

* H2 In-Memory database was used to store data because it's a lightweight database that could handle the requirements asked
for this app. In addition, it shouldn't be so hard to migrate
from H2 to another RDBMS

* One year has 360 days because that's the moment when the planets
reach the starting point again and by definition, one year is the
full orbital period of every planet that belongs to this solar system.

  

# Design Solution



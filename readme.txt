API will give array of cities matches the string and also unique key against each city

API to get weather of a city via key
http://dataservice.accuweather.com/forecasts/v1/daily/5day/<cityKey>
curl -X GET "http://dataservice.accuweather.com/locations/v1/cities/search?apikey=dNzhdauWYT1CI7A3GykSHhksktduHPXo&q=del"


https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/5day/%7BlocationKey%7D
Note: Iconid will come instead of icon images for weather. Convert the icon id to image url to show image for weather details.
Ex: if icon id is 1, then url will be https://developer.accuweather.com/sites/default/files/01-s.png
Mandatory Tasks:

T1. Design an app which will get the list of cities for the specified search term and display the results.

T2. Click on any city, it should be able to take the user to the details screen that displays the 5 days weather for that city.
Bonus Tasks:

T4. Write Unit Test cases

T5: Dependency Injection

T6: Co-routine/Livedata

T7: Use of compose

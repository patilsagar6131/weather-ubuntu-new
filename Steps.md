Purpose: I noticed that in ubuntu the weather info is getting shown only for big cities in india like delhi, mumbai etc.But what if we need small town weather info. So i have developed this app to fetch and present small towns critical weather info like temperature,pressure, current conditions,min temp, max temp etc.In future i will plan to develop javafx based nicely designed and modular app. But for now this is my first desktop based application.You can reach out to me on linkedin: https://www.linkedin.com/in/sagar-patil-4568b7242/ . Thank You very much.Thanks co pilot and openweather for support.

1. Steps followed : Create a maven project : "mvn archetype:generate -DgroupId=com.sagar.weather   -DartifactId=ubuntu-weather -DarchetypeArtifactId=maven-archetype-quickstart DarchetypeVersion=1.5 -DinteractiveMode=false"
2. Initialize github in this folder : git init  , git add . , git commit -m"Initial commit"
3. Then create a github repo name = "ubuntu-weather"
4. Then run these commands: git remote add origin https://github.com/patilsagar6131/ubuntu-weather.git , git branch -M main, git push -u origin main
5. Implemented WeatherService and created fetchByCity() to make http calls and fetch raw weather, then parseWeather(String json) and then converting it to WeatherResponse object from raw json, fetchWeather a method to make http calls and convert raw response to json object.
6. Created WeatherResponse class and getters and setters.
7. Created constants for url. 
8. Then created WeatherViewModel class to add km/h ℃ hPa for windspeed temeprature and pressure. 
9. Then created WeatherAppUI javafx class to run and display all the fetched weather entities.

To use this app first set "WEATHER_API_KEY" environment variable using command export export WEATHER_API_KEY=your_real_api_key_here in linux and setx WEATHER_API_KEY "your_real_api_key_here" in windows powershell. You can get your api key from openweather website.



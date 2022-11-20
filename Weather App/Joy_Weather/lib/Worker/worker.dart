import 'package:http/http.dart';
import 'dart:convert';

class worker{
  late String location;

  //Constructor
  worker({required this.location})
  {
    location = location;
  }

  late String temperature;
  late String dateTime;
  late String temperatureF;
  late String humidity;
  late String airSpeed;
  late String description;
  late String main;
  late String latitude;
  late String longitude;
  late String icon;

  Future<void> getData() async{
    try{
      Response response = await get(Uri.parse(
          "https://api.openweathermap.org/data/2.5/weather?q=$location&appid=4f1d03903cf646d86a600456788f4f27"));
      Map data = jsonDecode(response.body);

      //Getting Temperature, Humidity
      Map mainData = data['main'];
      double getTemperature = mainData['temp']-273.15;//Kelvin to degree
      // celsius
      double getTemperatureF = (mainData['temp'] - 273.15) * 9/5 + 32;
      //Kelvin To Farhenhit
      int getHumidity = mainData['humidity'];

      //Getting Air Speed
      Map windData = data['wind'];
      double getAirSpeed = windData['speed']/.27777777777778; // m/s to km./h

      //Getting Weather Description and Icon
      List weatherData = data['weather'];
      Map weatherMainData = weatherData[0];
      String getDescription = weatherMainData['description'];
      String getMain = weatherMainData['main'];
      String getIcon = weatherMainData['icon'].toString();


      //Getting latitude longitude
      Map coordData = data['coord'];
      double getLongitude = coordData['lon'];
      double getLatitude = coordData['lat'];

      //Assigning Values
      temperature = getTemperature.toStringAsFixed(1);
      temperatureF = getTemperatureF.toStringAsFixed(2);
      humidity = getHumidity.toString();
      airSpeed = getAirSpeed.toStringAsFixed(1);
      description = getDescription;
      latitude = getLatitude.toStringAsFixed(2);
      longitude = getLongitude.toStringAsFixed(2);
      main = getMain;
      icon = getIcon;
    }catch(e) {
      temperature = "NA";
      humidity = "NA";
      airSpeed ="NA";
      description = "Can not Find Data";
      latitude = "NA";
      longitude = "NA";
      temperatureF = "NA";
      main = "NA";
      icon = "09d";
    }

  }
}


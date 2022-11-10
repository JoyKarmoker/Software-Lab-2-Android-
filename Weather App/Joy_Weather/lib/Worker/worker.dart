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
  late String humidity;
  late String airSpeed;
  late String description;
  late String main;

  Future<void> getData() async{
    Response response = await get(Uri.parse(
        "https://api.openweathermap.org/data/2.5/weather?q=$location&appid=4f1d03903cf646d86a600456788f4f27"));
    Map data = jsonDecode(response.body);

    //Getting Temperature, Humidity
    Map mainData = data['main'];
    double getTemperature = mainData['temp'];
    int getHumidity = mainData['humidity'];

    //Getting Air Speed
    Map windData = data['wind'];
    double getAirSpeed = windData['speed'];

    //Getting Weather Description
    List weatherData = data['weather'];
    Map weatherMainData = weatherData[0];
    String getDescription = weatherMainData['description'];
    String getMain = weatherMainData['main'];

    //Assigning Values
    temperature = getTemperature.toString();
    humidity = getHumidity.toString();
    airSpeed = getAirSpeed.toString();
    description = getDescription;
    main = getMain;

  }
}


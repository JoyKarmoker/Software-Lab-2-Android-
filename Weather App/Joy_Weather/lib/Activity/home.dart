import 'package:flutter/material.dart';
class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);
  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    print("This is home init state");
  }

  @override
  void setState(VoidCallback fn) {
    // TODO: implement setState
    super.setState(fn);
    print("Home Set state called");
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    print("Widget Destroyed");
  }

  @override
  Widget build(BuildContext context) {
    var cityName = ["Dhaka", "Khulna", "Sylhet", "London"];
    Map? info = ModalRoute.of(context)?.settings.arguments as Map;

    return Scaffold(
      body: SafeArea(
        child: Container(
          child: Column(
            children: [
              Container( //Search Container
                padding: EdgeInsets.symmetric(horizontal: 8),
                margin: EdgeInsets.symmetric(horizontal: 24, vertical: 20),
                decoration: BoxDecoration(
                  color: Colors.black12,
                  borderRadius: BorderRadius.circular(24)
                ),
                child: Row(
                  children: [
                    GestureDetector(
                        onTap:() {},
                        child: Container(child: Icon(Icons.search, color: Colors.blueAccent),
                          margin: EdgeInsets.fromLTRB(3, 0, 7, 0),)
                    ),
                    Expanded(
                      child: TextField(
                        decoration: InputDecoration(
                          border: InputBorder.none,
                          hintText: "Search by city name"
                        )
                        
                      ),
                    )
                  ],
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}

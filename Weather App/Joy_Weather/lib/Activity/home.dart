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
    //Map info = ModalRoute.of(context).settings.arguments;
    Map? info = ModalRoute.of(context)?.settings.arguments as Map;

    return Scaffold(
      appBar: AppBar(
        title: Text("Home Activity"),
      ),
      body: Center(child: Column( mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              FloatingActionButton(
                onPressed: () => setState(() { }),
                child: const Icon(Icons.add),
              ),
                  Text(info["temperatureValue"])
                ],
            ),
      )
    );
  }
}

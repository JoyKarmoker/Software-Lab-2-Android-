import 'package:flutter/material.dart';
import 'package:joy_weather/Worker/worker.dart';

class Loading extends StatefulWidget {
  const Loading({Key? key}) : super(key: key);

  @override
  State<Loading> createState() => _LoadingState();
}

class _LoadingState extends State<Loading> {


  void startApp() async
  {
    worker instance =  worker(location: "Rajshahi");
    await instance.getData();
    print('myTag: This is air spped' + instance.airSpeed);
    print('Description' + instance.description);
  }

  @override
  void initState() {
    // TODO: implement initState
    startApp();
    super.initState();

  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(child: Column( mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          ElevatedButton(
            onPressed: () {
              Navigator.pushNamed(context, '/home');
            },
            child: const Text('Go to Home'),
          )
        ],
      ),
      ),
    );
  }
}

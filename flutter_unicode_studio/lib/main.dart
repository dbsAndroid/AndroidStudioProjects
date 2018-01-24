import 'package:flutter/material.dart';

const String words1 = "Almost before we knew it, we had left the ground.";
const String words2 = "A shining crescent far beneath the flying vessel.";
const String words3 = "A red flair silhouetted the jagged edge of a wing.";
const String words4 = "Mist enveloped the ship three hours out from port.";

void main() {
  runApp(new MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Flutter Fonts',
      theme: new ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: new FontsPage(),
    );
  }
}

class FontsPage extends StatefulWidget {
  @override
  _FontsPageState createState() => new _FontsPageState();
}

class _FontsPageState extends State<FontsPage> {
  @override
  Widget build(BuildContext context) {
    // Rock Salt - https://fonts.google.com/specimen/Rock+Salt
    var rockSaltContainer = new Container(
      child: new Column(
        children: <Widget>[
          new Text(
            "Rock Salt",
          ),
          new Text(
            words2,
            textAlign: TextAlign.center,
            style: new TextStyle(
              fontFamily: "Rock Salt",
              fontSize: 17.0,
            ),
          ),
        ],
      ),
      margin: const EdgeInsets.all(10.0),
      padding: const EdgeInsets.all(10.0),
      decoration: new BoxDecoration(
        color: Colors.grey.shade200,
        borderRadius: new BorderRadius.all(new Radius.circular(5.0)),
      ),
    );

    // VT323 - https://fonts.google.com/specimen/VT323
    var v2t323Container = new Container(
      child: new Column(
        children: <Widget>[
          new Text(
            "VT323",
          ),
          new Text(
            words3,
            textAlign: TextAlign.center,
            style: new TextStyle(
              fontFamily: "VT323",
              fontSize: 25.0,
            ),
          ),
        ],
      ),
      margin: const EdgeInsets.all(10.0),
      padding: const EdgeInsets.all(10.0),
      decoration: new BoxDecoration(
        color: Colors.grey.shade200,
        borderRadius: new BorderRadius.all(new Radius.circular(5.0)),
      ),
    );

    // https://fonts.google.com/specimen/Ewert
    var ewertContainer = new Container(
      child: new Column(
        children: <Widget>[
          new Text(
            "Ewert",
          ),
          new Text(
            words4,
            textAlign: TextAlign.center,
            style: new TextStyle(
              fontFamily: "Ewert",
              fontSize: 25.0,
            ),
          ),
        ],
      ),
      margin: const EdgeInsets.all(10.0),
      padding: const EdgeInsets.all(10.0),
      decoration: new BoxDecoration(
        color: Colors.grey.shade200,
        borderRadius: new BorderRadius.all(new Radius.circular(5.0)),
      ),
    );

    // Material Icons font - included with Material Design
    String icons = "";

    // https://material.io/icons/#ic_accessible
    // accessible: &#xE914; or 0xE914 or E914
    icons += "\u{E914}";

    // https://material.io/icons/#ic_error
    // error: &#xE000; or 0xE000 or E000
    icons += "\u{E000}";

    // https://material.io/icons/#ic_fingerprint
    // fingerprint: &#xE90D; or 0xE90D or E90D
    icons += "\u{E90D}";

    // https://material.io/icons/#ic_camera
    // camera: &#xE3AF; or 0xE3AF or E3AF
    icons += "\u{E3AF}";

    // https://material.io/icons/#ic_palette
    // palette: &#xE40A; or 0xE40A or E40A
    icons += "\u{E40A}";

    // https://material.io/icons/#ic_tag_faces
    // tag faces: &#xE420; or 0xE420 or E420
    icons += "\u{E420}";

    // https://material.io/icons/#ic_directions_bike
    // directions bike: &#xE52F; or 0xE52F or E52F
    icons += "\u{E52F}";

    // https://material.io/icons/#ic_airline_seat_recline_extra
    // airline seat recline extra: &#xE636; or 0xE636 or E636
    icons += "\u{E636}";

    // https://material.io/icons/#ic_beach_access
    // beach access: &#xEB3E; or 0xEB3E or EB3E
    icons += "\u{EB3E}";

    // https://material.io/icons/#ic_public
    // public: &#xE80B; or 0xE80B or E80B
    icons += "\u{E80B}";

    // https://material.io/icons/#ic_star
    // star: &#xE838; or 0xE838 or E838
    icons += "\u{E838}";

    var materialIconsContainer = new Container(
      child: new Column(
        children: <Widget>[
          new Text(
            "Material Icons",
          ),
          new Text(
            icons,
            textAlign: TextAlign.center,
            style: new TextStyle(
              inherit: false,
              fontFamily: "MaterialIcons",
              color: Colors.black,
              fontStyle: FontStyle.normal,
              fontSize: 25.0,
            ),
          ),
        ],
      ),
      margin: const EdgeInsets.all(10.0),
      padding: const EdgeInsets.all(10.0),
      decoration: new BoxDecoration(
        color: Colors.grey.shade200,
        borderRadius: new BorderRadius.all(new Radius.circular(5.0)),
      ),
    );

    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Fonts"),
      ),
      body: new ListView(
        children: <Widget>[
          rockSaltContainer,
          v2t323Container,
          ewertContainer,
          materialIconsContainer,
        ],
      ),
    );
  }
}



//import 'package:flutter/material.dart';
//
//void main() => runApp(new MyApp());
//
//class MyApp extends StatelessWidget {
//  // This widget is the root of your application.
//
//
////    var textStyle = const TextStyle(
////    fontFamily: 'Aegyptus',
////  );
//
//  @override
//  Widget build(BuildContext context) {
//    return new MaterialApp(
//      title: 'Flutter Demo',
//      theme: new ThemeData(
//        // This is the theme of your application.
//        //
//        // Try running your application with "flutter run". You'll see the
//        // application has a blue toolbar. Then, without quitting the app, try
//        // changing the primarySwatch below to Colors.green and then invoke
//        // "hot reload" (press the console where you ran "flutter run",
//        // or press Run > Flutter Hot Reload in IntelliJ). Notice that the
//        // counter didn't reset back to zero; the application is not restarted.
//        primarySwatch: Colors.blue,
//      ),
//      home: new MyHomePage(title: 'Flutter Demo Home Page'),
//    );
//  }
//}
//
//class MyHomePage extends StatefulWidget {
//  MyHomePage({Key key, this.title}) : super(key: key);
//
//
////  const textStyle = const TextStyle(
////    fontFamily: 'Aegyptus',
////  );
//
//  // This widget is the home page of your application. It is stateful, meaning
//  // that it has a State object (defined below) that contains fields that affect
//  // how it looks.
//
//  // This class is the configuration for the state. It holds the values (in this
//  // case the title) provided by the parent (in this case the App widget) and
//  // used by the build method of the State. Fields in a Widget subclass are
//  // always marked "final".
//
//  final String title;
//
//  @override
//  _MyHomePageState createState() => new _MyHomePageState();
//}
//
//class _MyHomePageState extends State<MyHomePage> {
//  //int _counter = 0;
//
//  void _incrementCounter() {
//    setState(() {
//      // This call to setState tells the Flutter framework that something has
//      // changed in this State, which causes it to rerun the build method below
//      // so that the display can reflect the updated values. If we changed
//      // _counter without calling setState(), then the build method would not be
//      // called again, and so nothing would appear to happen.
//     // _counter++;
//    });
//  }
//
//  @override
//  Widget build(BuildContext context) {
//
//    var textStyle = const TextStyle(
//      fontFamily: 'Aegyptus',
//    );
//    // This method is rerun every time setState is called, for instance as done
//    // by the _incrementCounter method above.
//    //
//    // The Flutter framework has been optimized to make rerunning build methods
//    // fast, so that you can just rebuild anything that needs updating rather
//    // than having to individually change instances of widgets.
//    return new Scaffold(
//
//      appBar: new AppBar(
//        // Here we take the value from the MyHomePage object that was created by
//        // the App.build method, and use it to set our appbar title.
//        title: new Text(widget.title),
//      ),
//      body: new Center(
//        // Center is a layout widget. It takes a single child and positions it
//        // in the middle of the parent.
//        child: new Column(
//          // Column is also layout widget. It takes a list of children and
//          // arranges them vertically. By default, it sizes itself to fit its
//          // children horizontally, and tries to be as tall as its parent.
//          //
//          // Invoke "debug paint" (press "p" in the console where you ran
//          // "flutter run", or select "Toggle Debug Paint" from the Flutter tool
//          // window in IntelliJ) to see the wireframe for each widget.
//          //
//          // Column has various properties to control how it sizes itself and
//          // how it positions its children. Here we use mainAxisAlignment to
//          // center the children vertically; the main axis here is the vertical
//          // axis because Columns are vertical (the cross axis would be
//          // horizontal).
//          mainAxisAlignment: MainAxisAlignment.center,
//
//          children: <Widget>[
//        //declare txt style
////            const textStyle = const TextStyle(
////                fontFamily: 'Aegyptus',
////            ),
//         //use the text style
////            var egyptText = const Text(
////              'Use the font for this text',
////              style: textStyle,
////            );
//            new Text(
//              //greek lambda, ogham tinne, japanese ka, cjk ideograph 10000, yijing i ching, ethiopic symbol, egyptian eye
//
//            '\n\u03BB \tgreek lambda \n\u1688 \togham tinne \n\u304B \tjapanese ka \n\u4E07 \tcjk ideograph 10,000 \n\u4DC1 \tyijing i ching \n\u1300 \tethiopic symbol \n\u{13080} \tegyptian eye of horus',
//              style: textStyle,
//            ),
//
////            new Text(
////              '\n\nYou have pushed the button this many times:',
////            ),
////            new Text(
////              '$_counter',
////              style: Theme.of(context).textTheme.display1,
////            ),
//          ],
//        ),
//      ),
//      floatingActionButton: new FloatingActionButton(
//        onPressed: _incrementCounter,
//        tooltip: 'Increment',
//        child: new Icon(Icons.add),
//      ), // This trailing comma makes auto-formatting nicer for build methods.
//    );
//  }
//}

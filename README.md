# Bar-LineCharAnimation

### Abstarct
This program takes a file that file extension is appropriate to what is requested from user. This file is decomposed by the program automatically and their datas are stored in some variables to use drawing charts. In addition, the program takes chart type from user to animate chart races. In result, this program makes animated chart races using these data according to user's chart preference.

### Code Execution
This project includes the `TxtFile` and `XmlFile` classes. These classes provide methods to decompose the file and store necessary information in variables. The next step is the drawing process. The user can choose between creating a bar chart or a line chart animation.

Both options share common properties, so a base class called `BarAndLine` is created to store these variables. The `Bar` and `Line` classes inherit from the `BarAndLine` class, allowing them to access the shared variables.

The next step involves adding bars or lines to the chart. Two classes, `BarChart` and `LineChart`, are created for this purpose. These classes have some common properties, so a parent class called `Chart` is created to store these shared properties. The `BarChart` and `LineChart` classes inherit from the `Chart` class and can utilize the data as needed.

The final step is the animation process. The chart is drawn repeatedly based on the year information found in the data. The `AnimatedChart` class is responsible for handling this animation.

![Chart Animation](https://github.com/iremSaral/Bar-LineCharAnimation/assets/92708146/6b362da3-cf75-41c5-9043-41a5dc85ca2b.gif)




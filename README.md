A simple and lightweight graphics library for Kotlin/Java.
It's desinged to be easy-to-use for quick visualizing tasks.

### Usage
Here's how `Vis` can be used:
```Kotlin
showGraphics {
        //center is a property of `Screen` and is a `Point` to the center of it
        circle(center, 300.0)
        // draw a plot. `area` means the entire area of the root screen.
        plot(area, 37.0, 70.0, 0.7)

        // start a simple animation
        startAnimation(duration = 3000, frameRate = 30) {
            // do some animation!
        }
    }
```

### Basics

##### Screen
The `Screen` Class represents an area in the screen that things can be directly drawn on.   
A `root Screen` is automatically created after calling `showGraphics` which initialized graphics and opens a window.   
New Screens can be added within the root Screen or other nested Screens at specified coordinates.   

##### showGraphics
Starts up the the library and opens a window, accepts a lambda which is called when everything is ready:
```Kotlin
showGraphics {
  // can now draw something!
  circle(center, 370.0)
 }
```
It has access the root Screen as receiver (`this`) inside the lambda.

##### Paint
Used to style the drawings on a screen. each sceen has own Paint.
```Kotlin
  showGraphics {
    paint.strokeWidth = 0.3
    paint.color = Color(70, 70, 70, 0xff)
    paint.font = Font(paint.font.color, 10)
}
```
A Paint can also be used when drawing an individual shape only for that shape by passing a Paint to the drawing function:
```Kotlin
  val paint = ...
  line(p(300.0, 300.0), p(700.0, 700.0), paint)
```

##### Coordinates
Coordinates in `Vis` adhere to the standard Cartesian system. This means that (0, 0) represents the bottom-left of the screen, unlike the top-left convention used in many other common frameworks.   
Class `Point(x, y)` is used to represent a single point across the library.   

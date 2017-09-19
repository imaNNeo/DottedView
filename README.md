# DottedView

We can draw dash lines in android in simple way,
but i didn't find simple way to create Dotted Like.
By this library you can make everything you want with Dots.

## 1 - Getting Started

By this instructions you can add this library and i will explain how use it.

<img src="http://ikhoshabi.com/ss/DottedView/main_screenshot.png" width="400">


### Add Maven to your root build.gradle

First of all Add it in your root build.gradle at the end of repositories:

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
	}
}
```

### Add Dependency

Add the dependency to your app build.gradle file

```
dependencies
{
    compile 'com.github.imaNNeoFighT:DottedView:-SNAPSHOT'
}
```

And then sync your gradle and take a tea.


## 2 - About The View
You can simply use this View like other Views in android,
just add ``DottedView`` in your java code or xml.

## View Properties
you can use this properties for make everything you want,
and all af them is arbitary.

* `dv_dotColor`
  by this property you can specify the color of Dots, default value is `#107cff`
  
* `dv_dotSize`
  by this property you can specify the size of Dots, default value is `15dp`
  
* `dv_dotHSpace`
  by this property you can specify Horizontal space of Dots, default value is `10dp`
  
* `dv_dotVSpace`
  by this property you can specify Vertical space of Dots, default value is `10dp`
  
* `dv_dotStrokeColor`
  by this property you can specify Stroke Color of Dots, default value is `#cc1a52`
  
* `dv_dotStrokeWidth`
  by this property you can specify Stroke Size of Dots, default value is `1dp`
  
  




## 3 - Use in Code


### Sample 1

```
<com.neo.dottedview.DottedView
  android:layout_width="match_parent"
  android:layout_height="12dp"
  app:dv_dotSize="12dp"
  app:dv_dotStrokeWidth="0dp"
  app:dv_dotHSpace="4dp"
  app:dv_dotColor="#545454"
  />
```
you will see this output

<img src="http://ikhoshabi.com/ss/DottedView/sample1.png" width="300">








### Sample 2

```
<com.neo.dottedview.DottedView
  android:layout_width="match_parent"
  android:layout_height="8dp"
  app:dv_dotSize="8dp"
  app:dv_dotStrokeWidth="0dp"
  app:dv_dotHSpace="0dp"
  app:dv_dotColor="#ff0000"
  />
```
you will see this output

<img src="http://ikhoshabi.com/ss/DottedView/sample2.png" width="300">








### Sample 3

```
<com.neo.dottedview.DottedView
  android:layout_width="match_parent"
  android:layout_height="28dp"
  app:dv_dotSize="20dp"
  app:dv_dotStrokeWidth="4dp"
  app:dv_dotHSpace="22dp"
  app:dv_dotColor="#fb00ff"
  app:dv_dotStrokeColor="#0dff00"
  />
```
you will see this output

<img src="http://ikhoshabi.com/ss/DottedView/sample3.png" width="300">








### Sample 4

```
<com.neo.dottedview.DottedView
    android:layout_width="match_parent"
    android:layout_height="280dp"
    app:dv_dotSize="18dp"
    app:dv_dotStrokeWidth="4dp"
    app:dv_dotHSpace="0dp"
    app:dv_dotVSpace="18dp"
    app:dv_dotColor="#707070"
    app:dv_dotStrokeColor="#25af7f"
    />
```
you will see this output

<img src="http://ikhoshabi.com/ss/DottedView/sample4.png" width="300">




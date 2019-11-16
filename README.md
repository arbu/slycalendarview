# Sly Calendar View

[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![](https://jitpack.io/v/psinetron/slycalendarview.svg)](https://jitpack.io/#psinetron/slycalendarview)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SlyCalendarView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7354)


A calendar that allows you to select both a single date and a period.
Calendar allows you to change colors programmatically without reference to the theme.

<img src="/images/sample.png" alt="Demo Screen Capture" width="300px" />

## Installation

Step 1. Add the JitPack repository to your build file

```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Step 2. Add the dependency

```groovy
dependencies {
  implementation 'com.github.psinetron:slycalendarview:${version}'
}
```


## Usage

1. Add `MaterialCalendarView` into your layouts or view hierarchy.

```xml
<ru.slybeaver.slycalendarview.SlyCalendarView
        android:id="@+id/slyCalendarView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        />
```

Or show calendar as dialog:
```kotlin
SlyCalendarDialog(context, listener)
        .setSingle(false)
        .show();
```

2. Set a `SlyCalendarDialog.Callback` when you need it
```kotlin 
class MainActivity : AppCompatActivity(), SlyCalendarDialog.Callback {
...

    override fun onCancelled() {
        //Nothing
    }

    override fun onDataSelected(
            firstDate: Calendar?,
            secondDate: Calendar?,
            hours: Int,
            minutes: Int
    ) {

    }
}
```

Or 
```kotlin
val callback: SlyCalendarDialog.Callback = object : SlyCalendarDialog.Callback {
            override fun onCancelled() {}
            override fun onDataSelected(
                    firstDate: Calendar?,
                    secondDate: Calendar?,
                    hours: Int,
                    minutes: Int
            ) {

            }
        }
```

## Customization
Set colors:
```xml
<ru.slybeaver.slycalendarview.SlyCalendarView
        android:id="@+id/slyCalendarView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:backgroundColor="#000000"
        app:headerColor="#ff0000"
        app:firstMonday="true"
        app:textColor="#00ff00"
        app:selectedColor="#0000ff"
        />
```
or 
```kotlin
SlyCalendarDialog(context, listener)
        .setSingle(false)
        .setBackgroundColor(Color.parseColor("#ff0000"))
        .setSelectedTextColor(Color.parseColor("#ffff00"))
        .setSelectedColor(Color.parseColor("#0000ff"))
        .show()
```

Parameters:
```xml
<attr name="backgroundColor" format="color"/>
        <attr name="headerColor" format="color"/>
        <attr name="headerTextColor" format="color"/>
        <attr name="textColor" format="color"/>
        <attr name="selectedColor" format="color"/>
        <attr name="selectedTextColor" format="color"/>
        <attr name="firstMonday" format="boolean"/>
```        

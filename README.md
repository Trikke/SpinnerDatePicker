Spinner DatePicker
-----

## Summary

The old "spinner" style DatePicker for newer devices.

![ScreenShot](https://i.imgur.com/jhg39Tb.png)

## Motivation

The default Material Design DatePicker has poor usability for choosing a date of birth. It seems it is hard for users to find the "year" button and they will often simply swipe left or right through the months in order to find their date of birth. 

![MaterialDesign](https://i.imgur.com/8lmZhbd.png)

The previous Holo DatePicker with sliding NumberPickers is much more suitable for this use case however it is no longer available for Marshmallow devices and up. 

This library is heavily based on the open source Contacts App DatePicker (source code [here](https://android.googlesource.com/platform/packages/apps/ContactsCommon/)) with the addition of being able to style the NumberPickers (the dials/spinners in the DatePicker). 

## Adding styles

The DatePicker is the simple aggregation of three NumberPickers. You can style the DatePicker easily with a NumberPicker style:

    <style name="NumbePickerStyle">
        <item name="android:textSize">22dp</item>
        <item name="android:textColorPrimary">@color/colorAccent</item>
        <item name="android:colorControlNormal" tools:targetApi="lollipop">@color/colorAccent</item>
    </style>

where `colorControlNormal` is the color of the horizontal bars (dividers) in the `NumberPicker`. See [this StackOverflow question](https://stackoverflow.com/q/20148671/5241933)

And then:

        new SpinnerDatePickerDialogBuilder()
                .context(MainActivity.this)
                .callback(MainActivity.this)
                .spinnerTheme(spinnerTheme)
                .year(year)
                .monthOfYear(monthOfYear)
                .dayOfMonth(dayOfMonth)
                .build()
                .show();

The example project should make it clear - get it by cloning the repo.                    
                    
## Usage in a project

Add the following to your **project** level `build.gradle`:
    
   ```gradle
   allprojects {
       repositories {
           maven { url "https://jitpack.io" }
   	   }
   }
   ```

Add this to your **app level** `build.gradle`:
    
   ```gradle
   dependencies {
       compile 'com.github.drawers:SpinnerDatePicker:0.0.8'
   }
   ```             

Philosophy
==========

The aim of this project is to produce a lightweight and robust DatePicker. Hence the library has no external dependencies and no fancy features. Espresso automated UI pesting is performed on the sample project using Firebase test lab. When more funds are available, more devices will be tested.

License
=======

Copyright 2017 David Rawson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

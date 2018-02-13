# APPLICATION NAME
Photo Filter by Jared Conn
This application lets the user of their mobile device select an image from either their gallery or to take a new photo. Colorful image filters can be applied to the image to give the image a new feel. This application accesses android hardware (the camera). Also the application stores files to internal storage, retreives files from storage and makes use of two interacting views.

## System Design 
This application was built using:

Android Studio 3.0.1
Build #AI-171.4443003, built on November 9, 2017
JRE: 1.8.0_152-release-915-b01 amd64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
Windows 7 6.1

This application requires:

Device running Android 5.1 or greater
The application uses a Relative View and an ImageView which fits inside for both of the views so it should be scalable.

Design:

The application allows the user to either choose to take a new photo or choose from the gallery. Based on that decision, the activity is started (either gallery or take new). When the activity is finished, onActivityResult is called. The file is saved and a path to the file is passed to the next activity where the file is displayed in an image view. (see MainActivity.java)


## Usage

Clone this repository and start an exisiting project using my code. Build the code and deploy to your device!
When the app starts, there are two buttons: Choose from Gallery, and, Take Photo. Once you have a photo you'd like to use, select it and then you will be able to select the different color options by clicking the buttons on the bottom of the screen. The rotate button rotates the image 90 degrees at a time. Once you are satisfied with your photo, you can save it to your gallery and keep it forever, or start again! 

Screenshots:



I am still working out the rotations in the color filter code. Some changes need to be made there because after saving an image to the gallery, the images are sometimes oriented sideways or backwards etc. I think I know what I need to do for that.

# Vision
This application uses the camera hardware to capture a photo. It then sends the image to the Google Vision API to guess what the photo is. If google does not guess correctly, the user can enter what they had in mind and see the percent likelihood of Google recognizing that possibility. The product is meant for my personal experience using a Google API. 

## System Design 
This app was build using:
Android Studio 3.0.1
Build #AI-171.4443003, built on November 9, 2017
JRE: 1.8.0_152-release-915-b01 amd64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
Windows 7 6.1

Minimum SDK:
Android 4.0 (IceCreamSandwich) so this baby works on all of em.

Minimum System Requirements:
You will need a device with a camera in order for this app to work.
Optimized for a 10.1 inch tablet however the app will work with some scaling issues on smaller devices

## Usage
Clone this repository and build the application using Android Studio. Paste your Google Vision Api key In PassPhoto.java. 

![alt text](https://github.com/jaredconn/Teaching-MobileApps/blob/master/projects/project%203/source/api.PNG)

Deploy to your device and on build completion and onCreate you will see a button to start the camera. Take a photo and then the highest likelihood guess will be displayed where you can confirm "YES" and thats it or "NO" and you can see what else google guessed. I have not yet implemented this yet, but on the "No" page I want to have a button that gives all of google's guesses so the user can see them without using the log. For now, you can see all of the guesses with the percent likelihood in the Log. (see screenshot)

![alt text](https://github.com/jaredconn/Teaching-MobileApps/blob/master/projects/project%203/source/annotations.PNG)

![alt text](https://github.com/jaredconn/Teaching-MobileApps/blob/master/projects/project%203/source/Screenshot_2018-02-24-13-22-51.png)
![alt text](https://github.com/jaredconn/Teaching-MobileApps/blob/master/projects/project%203/source/Screenshot_2018-02-24-13-23-21.png)


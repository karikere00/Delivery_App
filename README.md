# Delivery_App

Mobile Delivery App (Android OS)

The final iteration of the mobile app created by the CES Gatton Drone Team for the Spring 2023 Semester.

![User Interaction Diagram Image](https://user-images.githubusercontent.com/119607307/235077099-f9758673-be9a-4432-a9f2-0a726827e9b5.jpg)


Explanation of Activities:

MainActivity.java and activity_main.xml:
This activity and xml file compose the “home screen” of the app. The files include support for text boxes that allow users to enter phone numbers and verification codes received via text from Firebase authentication. 

GetLocationActivity.java and activity_get_location.xml:
This activity and xml file compose the “second screen” of the app. The files include support for a button that users would click to send their location to a ground control station with the use of Google Play Services and the Firebase Realtime Database.

FirstInstructionActivity.java and activity_first_instruction.xml:
This activity and xml file compose the “third screen” of the app. The files include a textbox of instructions for the user and a button that can be clicked to allow the user to navigate to the next screen.

SecondInstructionActivity and activity_second_instruction.xml:
This activity and xml file compose the “fourth screen” of the app. The files include a textbox of instructions for the user. It also includes a “next” button that can be clicked to allow the user to navigate to the next screen and a “previous” button that can be clicked to allow the user to navigate to the previous screen.

ThirdInstructionActivity and activity_third_instruction.xml:
This activity and xml file compose the “fifth screen” of the app. The files include a textbox of instructions for the user. It also includes a “next” button that can be clicked to allow the user to navigate to the next screen and a “previous” button that can be clicked to allow the user to navigate to the previous screen.

FourthInstructionActivity and activity_fourth_instruction.xml:
This activity and xml file compose the “sixth screen” of the app. The files include a textbox of instructions for the user. It also includes a “next” button that can be clicked to allow the user to navigate to the next screen and a “previous” button that can be clicked to allow the user to navigate to the previous screen.

Limitations: 
The program has currently only been tested with the Android Studio Emulator. As a result, Firebase and Google Play Services functionality haven’t been tested. The specific Firebase project this app is linked to was a limited-time testing server, so in the future, the app will need to be connected to a new Firebase project. 

Future Plans:
In the future, we plan to test the app using physical Android devices. We also plan on implementing a timer that will be displayed in the app. This timer will allow users to see an estimate of when their drone delivery will arrive. 

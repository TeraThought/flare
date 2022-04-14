![Maven metadata URL](https://img.shields.io/maven-metadata/v?color=%23FF8811&metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fcom%2Fterathought%2Fenchant%2Fflare%2Fmaven-metadata.xml)

![fire](https://oldcofh.github.io/assets/images/thermal-foundation/blaze-powder.gif)

# Flare

Light the way for your app's backend with functional and testable Firebase components.

## Installation
To install Firebase, simply add the following line when using npm (a package manager for JavaScript):

    npm install firebase

## Setup
### Option 1: Add Firebase Using the Firebase Console
Step 1: Create a Firebase Project

Step 2: Register Your App With Firebase

Step 3: Add a Firebase Configuration File

Step 4: Add Firebase SDKs to Your App

### Option 2: Add Firebase Using the Firebase Assistant
Step 1: Open your Android project in Android Studio

a) To make sure that you are using the latest versions of Android Studio and the Firebase Assistant:

    i) On Windows/Linux: Help > Check for updates

    ii) On MacOS: Android Studio > Check for updates

Step 2: Open the Firebase Assistant
a) Go to Tools > Firebase

Step 3: Choose a Firebase Product to Add to Your App
a) Each section will have a tutorial link which will tell you what to do next

Step 4: Sync Your App

Step 5: Follow the Remaining Setup Instructions For Your Selected Firebase Product in the Assistant Pane

Step 6: Add as many other Firebase products as you would like

You can also access different services using instances:

    val auth = FirebaseAuth.instance
    val firestore = FirebaseFirestore.instance
    val storage = FirebaseStorage.instance
    val functions = FirebaseFunctions.instance

## Supported APIs
Flare currently supports Android and iOS. We are planning on adding JavaScript soon. Flare also supports various services.
Authentication, Firestore, Storage, Cloud Functions are currently being supported. But, there is more support coming for other services
in the future.

## Cool APIs
Flare has a very functional API style. It uses Kotlin coroutines and Kotlin Serialization for FireStore,
making your backend app development experience seamless and problem free.
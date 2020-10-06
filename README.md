# PacifySDK React Native Sample

This React Native app demonstrates how to call the native iOS and Android PacifySDKs.  If you are familiar with invoking native code from React Native where you want to use platform specific APIs directly for any reason, that's what we are doing in this sample.  You may want to read about native code bridging for [iOS](https://reactnative.dev/docs/native-modules-ios) and [Android](https://reactnative.dev/docs/native-modules-android).

For more detailed instructions on how to configure the iOS and Android PacifySDKs in the native code, please see the [iOS Sample](https://github.com/pacify-io/pacifysdk-ios-sample) and [Android Sample](https://github.com/pacify-io/pacifysdk-android-sample).

# Setup and running the Sample apps

## iOS

To run iOS, you must be using MacOS and have Xcode installed.  You must have [Cocoapods](https://cocoapods.org/) installed.  Most of the steps here are expanded upon in the [React Native environment setup documentation](https://reactnative.dev/docs/environment-setup).

1. Install nodeJS if you don't have it. `brew install node` or install by your preferred method.
2. Install [Watchman](https://facebook.github.io/watchman/docs/install.html). `brew install watchman` or install by your preferred method.
3. In the root of the project, run `npm install`.
4. cd into the `ios/` directory and run `pod install`. 
5. cd back to the root of the project, and run `npx react-native run-ios`.  This will start up React Native's 'Metro Bundler' and launch a simulator to run the iOS app. 

Optionally, you may also launch Xcode, and run the project from there.

## Android

If you haven't done the iOS set up, you need to do these steps:

1. Install nodeJS if you don't have it. `brew install node` or install by your preferred method.
2. Install [Watchman](https://facebook.github.io/watchman/docs/install.html). `brew install watchman` or install by your preferred method.
3. In the root of the project, run `npm install`.

To run Android, you need to follow the Android setup steps from the React Native documentation for your system [from here](https://reactnative.dev/docs/environment-setup).  Some of the items to make sure to do from the documentation: 

1. you must have JDK 8 or newer installed.  
2. You must install Android Studio, and an appropriate Android SDK.  
3. You must configure an AVD or connect an appropriate Android device to run on. 
4. You must configure environment variables RN depends on, like ANDROID_HOME.

Finally, from the root of the project, run `npx react-native run-android`.  This will start up React Native's 'Metro Bundler', launch your AVD emulator, and run the app on the emulator.

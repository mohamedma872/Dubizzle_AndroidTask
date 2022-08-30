# Dubizzle_AndroidTask
DubizzleTask

A sample app to demonstrate the building of a good, modular and scalable Android app using Kotlin, Android Architecture Components (LiveData, ViewModel & Room), Dagger, RxJava and RxAndroid among others.

# Features
Some of the features of the app include

- **Effective Networking** - Using a combination of Retrofit, Rx, Room and LiveData, we are able to handle networking in the most effective way.

- **Modular** - The app is broken into modules of features and libraries which can be combined to build instant-apps, complete apps or lite version of apps.

- **MVVM architecture** - Using the lifecycle aware viewmodels, the view observes changes in the model / repository.

- **Kotlin** - This app is completely written in Kotlin.

- **Android Architecture Components** - Lifecycle awareness has been achieved using a combination of LiveData, ViewModels and Room.

 - **Dependency Injection** - Common elements like `context`, `networking` interface are injected using Dagger 2.

 - **Feature based packaging** - This screen-wise / feature-wise packaging makes code really easy to read and debug.

![alt text](https://github.com/mohamedma872/Dubizzle_AndroidTask/blob/master/Screen%20Shot%202021-12-26%20at%204.32.08%20AM.png)
![alt text](https://github.com/mohamedma872/Dubizzle_AndroidTask/blob/master/Screen%20Shot%202021-12-26%20at%204.50.23%20AM.png)
![alt text](https://github.com/mohamedma872/Dubizzle_AndroidTask/blob/master/Screen%20Shot%202021-12-26%20at%204.51.15%20AM.png)
![alt text](https://github.com/mohamedma872/Dubizzle_AndroidTask/blob/master/Screen%20Shot%202021-12-26%20at%205.08.29%20AM.png)
![alt text](https://github.com/mohamedma872/Dubizzle_AndroidTask/blob/master/Screen%20Shot%202021-12-26%20at%205.37.39%20PM.png)
![alt text](https://github.com/mohamedma872/Dubizzle_AndroidTask/blob/master/Screen%20Shot%202021-12-27%20at%201.57.34%20PM.png)
![alt text](https://github.com/mohamedma872/Dubizzle_AndroidTask/blob/hilt_integration/Dependency%20Graph.png)


# Testing:
To run all the unit tests, run `./gradlew test`. This would test the repositories and the viewmodels.

To run all the instrumented tests, run  `./gradlew connectedAndroidTest`. This would test the LocalDataSources (Room)

# Build info:
  - Compile SDK - 31
  - MinSDK - 21, Target - 31


# Libraries used
* [Android Support Libraries](https://developer.android.com/topic/libraries/support-library/index.html)
* [Dagger 2](https://google.github.io/dagger/)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Glide](https://github.com/bumptech/glide)
* [Room](https://developer.android.com/topic/libraries/architecture/room.html)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel.html)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html)
* [RxJava](https://github.com/ReactiveX/RxJava)
* [RxAndroid](https://github.com/ReactiveX/RxAndroid)

# License

    Copyright 2021 Mohammed ahmed

    


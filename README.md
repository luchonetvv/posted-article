# PostedArticleApp
## _This project contain una app Android for to consume an API Rest of https://hn.algolia.com that show article recents of many topics._

[![N|Solid](https://i.ibb.co/WPrNtvn/IMAGE-2021-09-06-21-16-28.jpg)](https://hn.algolia.com)

PostedArticleApp is a rest api-consume, mobile-ready, offline-storage compatible, 
Android-Native viewer of articles.

## Features

- Sincronize article with swipe down.
- We persist article in local storage of device.
- View in WebView the URLs of articles.
- Delete a article of list.
- We show the title, the author and elapsed time.

PostedArticleApp is a lightweight Android app based on the formatting conventions that developers naturally use in build to software.

## Tech

PostArticleApp uses a number of open source projects to work properly:

- [Framework Android](https://developer.android.com/) - A Framework serves to be able to write code or develop an application in a simpler way..
- [Retrofit](https://square.github.io/retrofit/) - Retrofit is a REST server client for Android and Java developed by Square, very simple and very easy to learn..
- [Gson](https://github.com/google/gson) - Gson is a Java library that can be used to convert Java Objects into their JSON representation.
- [Navigation](https://developer.android.com/guide/navigation) - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. Android Jetpack's Navigation component helps you implement navigation.
- [Room](https://developer.android.com/training/data-storage/room) - The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.
- [SwipeRefreshLayout](https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout) - SwipeRefreshLayout to add the 'swipe-to-refresh' gesture to a View, enabling the ability to trigger a refresh from swiping down on the view.
- [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) - RecyclerView makes it easy to efficiently display large sets of data.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
- [View Binding](https://developer.android.com/topic/libraries/view-binding) - View binding is a feature that allows you to more easily write code that interacts with views.

And of course PostedArticleApp itself is open source with a [public repository](https://github.com/luchonetvv/posted-article)
 on GitHub.
 
## Requirements

- [Git](https://git-scm.com/) - Git is a free and open source distributed version control system designed to handle everything from small to very large projects with speed and efficiency.
- [Java](https://www.java.com/en/) - Java is a programming language and computing platform first released by Sun Microsystems in 1995. Install Java 8 and Java 11.
- [Android Studio](https://developer.android.com/studio) - Android Studio provides the fastest tools for building apps on every type of Android device. Version Arctic Fox | 2020.3.1 Patch 2.

## Demo

![Demo](https://user-images.githubusercontent.com/1069705/132289650-4316e5c3-f3d7-468c-aef2-4fec7a540d43.gif)

## Installation

Clone the repository.

```bash
git clone git@github.com:luchonetvv/posted-article.git
git checkout develop
git status
```

You have to install Java 8 and Java 11.

Install Android Studio and then open the project...
Only need to execute the run button and will build the project satisfactory.

Or if you want to build and install via terminal, this are steps:

> Note: Set `Java 11` is required for execute gradle tools.
> Note: The `Physical Device` have to have configure the [Developer Options, Debugging USB](https://developer.android.com/studio/debug/dev-options) and connected the device to laptop.

On Mac or Linux
```bash
./gradlew installDebug
```

On Windows
```bash
gradlew.bat installDebug
```

## License

Apache License, Version 2.0

**Free Software, Hell Yeah!**


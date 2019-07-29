# Testcoding - Android #


## Project Description ##
This project is created using java language in android studio.  This project includes Retrofit for fetching data from api
and MVVM as design pattren and Room.db for local storage ap get data from api when internet is connected and when internet
is not connected it gets data from local storage.

## Dependencies ##
 * Android design support library.
 * MVVM life cycle library .
 * Room.db library (For local storage) .
 * Retrofits library (for Api call) .
 


## Configurations ##
Note your package name and the application ID of the project!

Open project using Android Studio...
Open Android Studio and launch the Android SDK manager from it (Tools | Android | SDK Manager)
Ensure the following components are installed and updated to the latest version.
Android SDK Platform-Tools
Android Support Repository
Google Repository
Return to Android Studio and select Open an existing Android Studio project
compile and run

## Project Installation ##

Download or Clone:

```$ git clone https://github.com/adilehsan/Testcoding.git ```

Import Project by Android Studio Menu > File > Import Project...
Run MuviNow application by Android Studio Menu > Run > Android.
If some issues are happened, try "Sync Project with Gradle Files" or "Rebuild Project" at Android Studio Menu

Building
To build the samples after you have applied the changes above, you can use the build/run option in Android Studio, or build directly from the command line if you prefer.
IMPORTANT Ensure you have set the ANDROID_HOME environment variable.

cd /path/to/android-muvinow-samples
export ANDROID_HOME = /path/to/android/sdk
./gradlew build

## Directory ##
.
├── ...
├── java                   # Main Folder Source code 
│   ├── Model             # Folder contains models for api data
│   ├── Network             # Api calling files
│   ├── Repositories            # Folder contains all repo files for api call
│   ├── Roomdb            # Room datbase, tables, repositories for room db and entities
│   ├── Util            # project supported files and constat values
│   ├── ViewModels            # Folder contain all viewModel files for api call
│   └── ...      
├── res                   # Resource files 
│   ├── drawable              # drawable and icons.
│   ├── layout            # Project layout files
│   ├── menu            # menu files
│   ├── mipmap            # Icons
│   ├── value          # Project strings, vlaues and colors
│   └── ...                 # etc.
└── ...
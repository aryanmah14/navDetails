# NavDetails Android App

NavDetails is a modern Android application built using Jetpack Compose that demonstrates dynamic navigation drawer implementation with remote API integration. The app fetches navigation data from a backend service and displays it in a structured, interactive drawer layout.

## 🚀 Features

- **Dynamic Navigation Drawer**: Seamlessly integrated navigation menu populated from remote data.
- **REST API Integration**: Uses Retrofit for efficient network requests.
- **Modern UI/UX**: Built entirely with Jetpack Compose for a reactive and fluid user experience.
- **MVVM Architecture**: Follows Android best practices for clean code and separation of concerns.
- **Repository Pattern**: Centralized data management for better testability and scalability.

## 📸 Screenshots

| Screen 1 | Screen 2 | Screen 3 |
| :---: | :---: | :---: |
| ![Screen 1](https://via.placeholder.com/300x600?text=Navigation+Drawer) | ![Screen 2](https://via.placeholder.com/300x600?text=API+Data+View) | ![Screen 3](https://via.placeholder.com/300x600?text=App+Landing) |

## 🛠️ Tech Stack

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Networking**: [Retrofit](https://square.github.io/retrofit/) & [Gson](https://github.com/google/gson)
- **Architecture**: MVVM (Model-View-ViewModel)
- **Dependency Management**: Gradle (Kotlin DSL)

## 🏗️ Project Structure

```text
app/src/main/java/com/example/
├── data/
│   ├── model/         # Data models for API responses
│   └── network/       # Retrofit Service and Instance
├── presentation/
│   ├── screens/       # Compose UI Screens
│   └── viewmodel/     # ViewModel logic
├── repository/        # Data Repository
└── ui/theme/          # Design system (Colors, Typography, Theme)
```

## ⚙️ Getting Started

### Prerequisites
- Android Studio Ladybug or newer.
- Android SDK 24+ (Android 7.0 Nougat).

### Build and Run
1. Clone the repository.
2. Open the project in Android Studio.
3. Sync Gradle and build the project.
4. Run on an emulator or a physical device.

# YDailyPulse


A **Kotlin Multiplatform (KMP)** application designed to demonstrate the power of multiplatform development. It shares all data and domain layer between **Android** and **iOS** platforms. For presentation layer, more specific, Presenter / View Model classes also being shared in KMP module, while maintaining the UI (View) components in native way.

## Technologies Used

*   **Kotlin Multiplatform (KMP):**  Enables code sharing between Android and iOS.
*   **Kotlin:** Version 2.0.0
*   **Gradle:** Version 8.7
*   **Android:**
    *   **UI:** Jetpack Compose for building the native Android UI.
    *   **Navigation:** Navigation Compose for in-app navigation.
*   **iOS:**
    *   **UI:** SwiftUI for building the native iOS UI.
*   **SKIE:** Swift API Generator for Kotlin Multiplatform.
*   **Networking:** Ktor client for making REST API calls.
*   **Database:** SQLDelight for local data persistence.
*   **Dependency Injection:** Koin for managing dependencies.
*   **Concurrency:** Kotlin Coroutines for asynchronous operations.

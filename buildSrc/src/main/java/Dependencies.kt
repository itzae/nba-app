import Versions.lottie_version
import sun.misc.Version

object Versions {
    const val kotlin_version = "1.3.72"
    const val core_ktx_version = "1.3.2"
    const val appcompat_version = "1.2.0"
    const val material_design_version = "1.2.1"
    const val constraintlayout_version = "2.0.4"
    const val junit_version = "4.13.1"
    const val ext_unit_version = "1.1.2"
    const val espresso_core_version = "3.3.0"
    const val navigation_version = "2.3.2"
    const val retrofit2_version = "2.9.0"
    const val coroutine_version = "1.3.6"
    const val lifecycle_version = "2.2.0"
    const val activity_version = "1.1.0"
    const val fragment_version = "1.2.5"
    const val loggin_interceptor_version = "4.9.0"
    const val lottie_version = "3.4.0"
}

object Dependencies {
    const val kotlin_lib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
    const val core_ktx_lib = "androidx.core:core-ktx:${Versions.core_ktx_version}"
    const val appcompat_lib = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
    const val material_design_lib = "com.google.android.material:material:${Versions.material_design_version}"
    const val constraintlayout_lib = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout_version}"
    const val junit_lib = "junit:junit:${Versions.junit_version}"
    const val ext_junit_lib = "androidx.test.ext:junit:${Versions.ext_unit_version}"
    const val espresso_core_lib = "androidx.test.espresso:espresso-core:${Versions.espresso_core_version}"
    const val navigation_fragment_lib = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation_version}"
    const val navigation_ui_lib = "androidx.navigation:navigation-ui-ktx:${Versions.navigation_version}"
    const val retrofit2_lib = "com.squareup.retrofit2:retrofit:${Versions.retrofit2_version}"
    const val retrofit2_gson_lib = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2_version}"
    const val kotlin_coroutines_lib = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine_version}"
    const val viewmodel_lib = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    const val livedata_lib = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    const val lifecycle_extensions_lib = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_version}"
    const val activity_ktx_lib = "androidx.activity:activity-ktx:${Versions.activity_version}"
    const val fragment_ktx_lib = "androidx.fragment:fragment-ktx:${Versions.fragment_version}"
    const val logging_interceptor_lib = "com.squareup.okhttp3:logging-interceptor:${Versions.loggin_interceptor_version}"
    const val lottie_lib = "com.airbnb.android:lottie:$lottie_version"
}
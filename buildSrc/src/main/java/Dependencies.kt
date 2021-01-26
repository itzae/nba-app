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
}
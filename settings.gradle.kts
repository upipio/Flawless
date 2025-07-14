pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        // TAMBAHKAN BARIS INI
        maven("https://s01.oss.sonatype.org/content/repositories/releases/")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // DAN TAMBAHKAN BARIS INI JUGA
        maven("https://s01.oss.sonatype.org/content/repositories/releases/")
    }
}

rootProject.name = "Flawless"
include(":app")
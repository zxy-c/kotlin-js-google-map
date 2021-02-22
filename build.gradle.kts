plugins {
    id("org.jetbrains.kotlin.js") version "1.4.21"
    `maven-publish`
}

group = "org.zxy"
version = "0.0.1"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(npm("@googlemaps/js-api-loader","1.11.1"))
}

kotlin {
    js {
        browser {
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}

publishing {
    repositories {
        mavenLocal()
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = groupId
            artifactId = "kotlin-js-google-map"
            version = version

            from(components["kotlin"])
        }
    }
}
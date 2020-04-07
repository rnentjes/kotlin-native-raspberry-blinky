plugins {
    kotlin("multiplatform") version "1.4-M1"
}

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenCentral()
}

kotlin {
    linuxArm32Hfp("pi") {
        binaries {
            executable {
                // Change to specify fully qualified name of your application's entry point:
                entryPoint = "main"
                // Specify command-line arguments, if necessary:
                runTask?.args("")
            }
        }
        compilations.getByName("main") {
            val wiringPi by cinterops.creating {
                includeDirs {
                    allHeaders ("src/include/wiringPi")
                }
            }
        }
        sourceSets {
            // Note: To enable common source sets please comment out 'kotlin.import.noCommonSourceSets' property
            // in gradle.properties file and re-import your project in IDE.
            val piMain by getting {}
        }
    }
}

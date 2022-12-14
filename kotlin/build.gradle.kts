plugins {
    kotlin("jvm") version "1.7.22"
    id("io.kotlintest") version "1.1.1"
}

repositories {
    mavenCentral()
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.22")
    implementation("org.junit.jupiter:junit-jupiter:5.9.0")
    implementation("io.kotest:kotest-runner-junit5:5.5.4")
    implementation("io.kotest:kotest-framework-datatest:5.5.4")
    implementation("io.mockk:mockk:1.13.2")

//    implementation("org.bytedeco:tesseract:5.0.1-1.5.7")
//    implementation("org.bytedeco:tesseract-platform:5.0.1-1.5.7")
//    implementation("net.sourceforge.tess4j:tess4j:5.4.0")
//    implementation("com.databricks.labs:tika-ocr:0.1.2")
    implementation("org.apache.tika:tika-core:2.6.0")


}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks {
    sourceSets {
        main {
            java.srcDirs("src")

        }
    }

    wrapper {
        gradleVersion = "7.6"
    }
}

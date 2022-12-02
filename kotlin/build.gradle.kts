plugins {
    kotlin("jvm") version "1.7.22"
    id("io.kotlintest") version "1.1.1"
}

repositories {
    mavenCentral()
}


dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.junit.jupiter:junit-jupiter:5.5.2")
    implementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    implementation("io.mockk:mockk:1.9.3.kotlin12")
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

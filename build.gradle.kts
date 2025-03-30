plugins {
    `java-library`
    id("com.gradleup.shadow") version "9.0.0-beta10"
}

repositories {
    mavenCentral()
    gradlePluginPortal()

    flatDir {
        dirs("libs")
    }
}

dependencies {
    implementation("com.kibo.pgar.lib:kibo-pgar-lib:1.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.12.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.12.1")
}

group = "it.unibs.fp.Planetarium"
version = "1.0.0"
description = "it-unibs-Planetarium"
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}


tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<AbstractArchiveTask>().configureEach {
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
}

val testJar by tasks.registering(Jar::class) {
    manifest {
        attributes["Manifest-Version"] = "0.0.1"
        attributes["Multi-Release"] = "false"
        attributes["reproducibleFileOrder"] = "true"
        attributes["preserveFileTimestamps"] = "false"
        attributes["source"] = "true"
    }
}

tasks.shadowJar {
    archiveClassifier = "shadowjar"

    from(sourceSets.main.get().allSource)

    manifest.inheritFrom(testJar.get().manifest)

    dependencies {
        exclude(dependency("org.junit.jupiter:junit-jupiter:5.12.1"))
        exclude(dependency("org.junit.platform:junit-platform-launcher:1.12.1"))

        configurations = provider { listOf(project.configurations.runtimeClasspath.get()) }
    }

    minimize()
}

plugins {
    `kotlin-dsl`
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            group = "n7"
            artifactId = "convention"
            version = "1.0"
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/i30mb1/convention.settings")
            credentials {
                username = findProperty("user") as? String ?: System.getenv("USER")
                password = findProperty("key") as? String ?: System.getenv("KEY")
            }
        }
    }
}
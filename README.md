## Spring Kotlin with Rx Bus Events

Spring Kotlin Rx is project based on [Spring Boot Kotlin Sample Project](https://github.com/sdeleuze/spring-boot-kotlin-demo).

Goal was to create project for follwoing requirements:
- Application will simulate traffic lights by the roundabout
- Application will change lights by itself
- Application will will have 2 algorithms for changing traffic lights
- Application will allow to get current state of lights
- Application will allow to turn off lights - they they won't be able to turn green
- Number of traffic lights will be configured by properties file
- Application will start with randomly chosen algorithm

You can launch the application with by running:

		$ ./gradlew bootRun

This project is Apache 2.0 licensed.
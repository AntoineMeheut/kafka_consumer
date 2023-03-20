<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![GNU License][license-shield]][license-url]

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/AntoineMeheut/GoodDevPractices">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center"></h3>

  <p align="center">
    Code produced to check the technical feasibility of reading a topic events from Kafka from java code. This project is the part that consumes the events in Kafka. This code can be used to read events.
    <br />
    <a href="https://github.com/AntoineMeheut/GoodDevPractices/tree/master/docs"><strong>Explore Kafka docs</strong></a>
    <br />
    <br />
    <a href="https://github.com/AntoineMeheut/kafka_consumer">View Demo</a>
    ·
    <a href="https://github.com/AntoineMeheut/kafka_consumer/issues">Report Bug</a>
    ·
    <a href="https://github.com/AntoineMeheut/kafka_consumer/issues">Request Feature</a>
  </p>
</p>

<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [The code is based on](#The-code-is-based-on)
  * [The components of this project](#The-components-of-this-project)
* [Getting Started](#getting-started)
  * [Installation](#installation)
* [Usage](#usage)
  * [Build for the first time](#Build-for-the-first-time)
  * [Execute the project](#Execute-the-project)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)

<!-- ABOUT THE PROJECT -->
## About The Project
Code produced to check the technical feasibility of reading a topic events from Kafka from java code.

This project is the part that consumes the events in Kafka.

### The code is based on
* springframework.boot: to save time and quickly create an application executable on RHEL
* org.apache.kafka: which allows to open the connection with the Kafka machine, connect to topics and read their content
* springframework.kafka: which saves time for everything concerns the use of Kafka in a Spring project

### The components of this project are
* a src/main/resources/application.properties file which contains the address of the Kafka machine and the name of the topic to listen to
* src/main/java/com/ame/messages/SubscribedReader.java: which is the main java class, it launch the connection to the Kafka machine and to the topic and especially it realizes topic reading and displaying System.out for each messages
* src/main/java/com/ame/messages/config/ConsumerChannelConfig.java: which is the java class in which we find the methods that perform access to the Kafka machine and to the topic

The project opens on Eclipse or IntelliJ.

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Installation
 
1. Clone the repo
```
git clone https://github.com/AntoineMeheut/kafka_consumer
```

<!-- USAGE EXAMPLES -->
## Usage
### Build for the first time

```
mvn clean install -U
```

### Execute the project
#### Method 1
* Copy the sources on an RHEL, go to the directory where is located
the pom of the project namely kafka_consumer and type the command:

```
mvn clean install -U spring-boot:run -Dspring.kafka.consumer.group-id="consumer1" -Drun.arguments="AME"
```

* the argument spring.kafka.consumer.group-id allows to execute several consumers
* the argument run.arguments allows you to choose what type of event you want listen
* to use method 1: you must have maven on the RHEL machine

#### Method 2
* Build a jar and copy it to the RHEL machine, go to the directory
where the jar is and type the following command:

```
nohup java -jar kafka_consumer.jar -Dspring.kafka.consumer.group-id="consumer1" -Drun.arguments="AME" &
```

<!-- ROADMAP -->
## Roadmap

See the [Project](https://github.com/AntoineMeheut/kafka_consumer/projects) for a list of proposed features (and known issues).

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the GNU General Public License v3.0 License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

If you want to contact me [just clic](mailto:github.contacts@protonmail.com)

Project Link: [https://github.com/AntoineMeheut/kafka_consumer](https://github.com/AntoineMeheut/kafka_consumer)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/AntoineMeheut/kafka_consumer?color=green
[contributors-url]: https://github.com/AntoineMeheut/kafka_consumer/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/AntoineMeheut/kafka_consumer
[forks-url]: https://github.com/AntoineMeheut/kafka_consumer/network/members
[stars-shield]: https://img.shields.io/github/stars/AntoineMeheut/kafka_consumer
[stars-url]: https://github.com/AntoineMeheut/kafka_consumer/stargazers
[issues-shield]: https://img.shields.io/github/issues/AntoineMeheut/kafka_consumer
[issues-url]: https://github.com/AntoineMeheut/kafka_consumer/issues
[license-shield]: https://img.shields.io/github/license/AntoineMeheut/kafka_consumer
[license-url]: https://github.com/AntoineMeheut/kafka_consumer/blob/master/LICENSE

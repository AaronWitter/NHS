NHS QS Portal
=====================

### About this application

This application is written using the [Dropwizard](http://www.dropwizard.io/) Java framework.

It is backed by a [MySQL](https://www.mysql.com/) database.

### Prerequisites

In order to run the tool locally you'll need the following installed on your machine, alternatively you can provision a virtual machine
using Vagrant [here](#vagrant).

- [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [MySQL](https://www.mysql.com/)
- [Git](https://git-scm.com/downloads)

### Getting Started

Run the following from the command line to download the repository and change into the directory:

```
git clone git@github.com:AaronWitter/nhs.git

cd nhs
```

### Running the development server

To run the server type the following command in your terminal

```bash
./run.sh
```

or on windows

```
mvn clean package
java -jar target/webportal-1.0-SNAPSHOT.jar server configuration.yml

```

Then you can now visit [http://localhost:8080/](http://localhost:8080/) in your browser

## Tests

### Running the test suite

We are using [JUnit](http://junit.org/) the unit testing framework for the back end test suite. To run the tests:

```bash
mvn test
```

We are using [Cucumber](https://cucumber.io/docs) for our automated integration testing. To run the test suite
including both unit and integration tests:

```bash
mvn verify
```

## Installing to run on a VM

### Required Software

Ensure you have [VirtualBox](https://www.virtualbox.org/) and [Vagrant](https://www.vagrantup.com/) installed first.

Also ensure you have the VBGuest plugin for Vagrant installed, you can do this with this command.

```bash
vagrant plugin install vagrant-vbguest
```

### Starting the Development Environment

To start the development environment, on the commandline move to the directory this README.md is in on the command line
and type. This will start the VM where you can run the server.

```bash
vagrant up
```

To migrate the database type the following command

```bash
vagrant ssh -c "cd /vagrant && java -jar target/webportal-1.0-SNAPSHOT.jar db migrate configuration.yml"
```

To import the data type

```bash
vagrant ssh -c "cd /vagrant && ./bootstrap.sh"
```

To run the server type the following command

```bash
vagrant ssh -c "cd /vagrant && ./run.sh"
```

Then you can now visit [http://192.168.33.10:8080/](http://192.168.33.10:8080/) in your browser

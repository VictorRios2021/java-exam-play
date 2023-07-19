# Java Exam

Clean Java template project for beign completed as an exam to apply for hiring.

## Software stack

Tools needed to work on:

- **Operative System**:
  - Ubuntu/Debian/CentOS/RHEL/OpenSUSE
- **Java**:
  - [Java Development Kit 8](https://www.oracle.com/mx/java/)
- ***IDE***:
  - [Apache Netbeans](https://netbeans.apache.org/)
- **Build & Package**:
  - [Apache Ant](https://ant.apache.org/)
  - [Apaache Maven](https://maven.apache.org/)
  - [Apache Ivy](https://ant.apache.org/ivy/)

## Statement

1. Import project to a personal git-based storage.
1. Create a branch to make changes:
   - Following the [technical statement](#technical-statement).
   - Meeting [requirements](requirements.md).
1. [Compile](#compile) and test.
1. Create a merge request (or pull request) for:
   - Describing changes
   - Reviewing changes
1. Share your solution.

## Technical statement

It is necessary to develop a little application that creates at least 3 threads for listening 1 emulated serial port each one.

- When a message from one port is received, it must be interpretated and deserializated.
- The messages must be defined under a communication frame.
- The unique message, for now, is detect an *ACK* from devices. For example: `ID#MESSAGE#CHECKSUM`. Where:
  - `ID`: Number as the identificator for the serial port device. For example: `3`
  - `MESSAGE`: String as identificator for the message sent. It must be a string. For example: `ACK`.
  - `CHECKSUM`: Number as a custom verification sum to validate the integrity of the whole message sent. For example: `122` decimal for `7A` hexadecimal, as result of sum all ASCII of whole previuos characters of message without `#`.
- When the message:
  - Is correctly identified (under communication frame): It must be logged with:
    - Local time
    - Message
    - Device
    - Checksum
  - Is not correctly identified or any error occurs (interruption or incomplete message): It must log an error.
- A timer must detect inactivity from any thread and show that the device is offline after `3s`.

## Compile

- With ant: `ant compile jar`

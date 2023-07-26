This application was developed based on the guidelines described in: [Readme](../../README.md)

## Requirements

- **Operative System**:
  - Ubuntu/Debian/CentOS/RHEL/OpenSUSE/macos
- **Java**:
  - [Java Development Kit 8](https://www.oracle.com/mx/java/)
- ***IDE***:
  - [Apache Netbeans](https://netbeans.apache.org/)
- **dependencies**:
  - jssc-2.8.0
  - log4j-core-2.20.0
  - junit-4.12
  - hamcrest-core-1.3
- **Serial port emulator**:
  - socat v1.7.4.4 
### Code structure

The code is composed of the following classes

+ [/src/main/JavaApplication.java](../../src/main/JavaApplication.java): main app
+ [/src/main/SerialPortListener.java](../../src/main/SerialPortListener.java): 
Serial port class, implementing runnable, listens to a serial port, with the mask `MASK_RXCHAR`, receives the message, sends it to validate and prints it. 
It also contains a timer that checks if the thread is inactive for 3 seconds and alerts by log
+ [/src/main/utils/LoadAppProperties.java](../../src/main/utils/LoadAppProperties.java): 
This class reads the necessary configuration properties from the AppSettings.properties file.
+ [/src/main/utils/MessageValidator.java](../../src/main/utils/MessageValidator.java):  
This class validates the message format and checksum
    - The message must have the following format: `ID#MESSAGE#CHECKSUM`. Where:
        - `ID`: Number as the identificator for the serial port device. For example: `3`
        - `MESSAGE`: String as identificator for the message sent. It must be a string. For example: `ACK`.
        - `CHECKSUM`: Number as a custom verification sum to validate the integrity of the whole message sent. For example: `122` decimal for `7A` hexadecimal, as result of sum all ASCII of whole previuos characters of message without `#`.
+ [./test/main/](../../test/main/): 
contains unit tests with junit

+ [/src/main/models/Message.java](../../src/main/models/Message.java): 
 (unused) use if is required insert db etc.

+ [/src/AppSettings.properties](../../src/AppSettings.properties): 
    Contains the configuration properties of the application



# Computer hardware inventory management

This app lets you manage your computer hardware inventory

## Installation

Download and install [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html).
To make sure the JDK was successfully installed, in command line or terminal run:


```bash
java -version
```

## Usage
1. Download and install MySQL database and run init.sql script to initiate the computer_hardware database.
2. To avoid "Unable to load authentication plugin 'caching_sha2_password'" exception please run "ALTER USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';" query in a newly created database.
3. Run "mvn clean install" in terminal
4. Run "java -jar target\computer-hardware-1.0-SNAPSHOT.jar"
5. Enjoy!   

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.


## License
None

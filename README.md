# To run this project, you'll need:
* The Java SE Development Kit (JDK 7 has been selected in this example)
	- For Microsoft Windows, Solaris OS, and Linux: Java SE: https://www.oracle.com/java/technologies/javase-downloads.html
	- For Mac OS X: developer.apple.com
* NetBeans IDE 8.2 

# This project will simply display the communicate messages between Client and Server using Kerberos protocol. To run this:
* Clone this project with git bash: 

		git clone https://github.com/hungtrongdoang/Simple-Simu-Kerberos.git

* When you open this project, you need an environment in which to build and run this application. You need to set the environment variables.


		JAVA_HOME : C:\Program Files\Java\jdk1.8.0_11

		JDK_HOME  : %JAVA_HOME%

		JRE_HOME  : %JAVA_HOME%\jre

		CLASSPATH : .;%JAVA_HOME%\lib;%JAVA_HOME%\jre\lib

		PATH      : your-unique-entries;%JAVA_HOME%\bin (make sure that the longish your-unique-entries does not contain any other references to another Java installation folder.)


* Compile the source file: Client.java; Server1.java into a .class file

		The IDE invokes the Java programming language compiler (javac), which takes your source file and translates its text into instructions that the Java virtual machine can understand. The instructions contained within this file are known as bytecodes. The IDE invokes the Java application launcher tool (java), which uses the Java virtual machine to run your application.

* First, you need to run Client.java to start the socket connection. Then, run Server1.java (which serves as both AS and TGS) which will display the necessary information like plaintext, ticket, ticket-validation,.. While Server 1’s process is completed, you can run Server2.java (which serves as V) which will display the final part of the program.

   

# To run this project, you'll need:
* The Java SE Development Kit (JDK 7 has been selected in this example)
	- For Microsoft Windows, Solaris OS, and Linux: Java SE: https://www.oracle.com/java/technologies/javase-downloads.html
	- For Mac OS X: developer.apple.com
* NetBeans IDE 8.2 

# This project will simply display the communicate messages between Client and Server using Kerberos protocol. To run this:
* Clone this project with git bash: git clone "https://github.com/hungtrongdoang/Simple-Simu-Kerberos.git" 

* When you open this project, you need an environment in which to build and run this application. You need to set the environment variables.

	JAVA_HOME : C:\Program Files\Java\jdk1.8.0_11
	
	JDK_HOME  : %JAVA_HOME%
	
	JRE_HOME  : %JAVA_HOME%\jre
	
	CLASSPATH : .;%JAVA_HOME%\lib;%JAVA_HOME%\jre\lib
	
	PATH      : your-unique-entries;%JAVA_HOME%\bin (make sure that the longish your-unique-entries does not contain any other references to another Java installation folder.)
	

* Compile the source file: Client.java; Server1.java into a .class file
	The IDE invokes the Java programming language compiler (javac), which takes your source file and translates its text into instructions that the Java virtual machine can understand. The instructions contained within this file are known as bytecodes. The IDE invokes the Java application launcher tool (java), which uses the Java virtual machine to run your application.

* Run Client.java to open session lasts as long as Server1.java or Server2.java runs (Accept new connection will from 127.0.0.1).

* Run Server1.java to receive the message from Client and check the availability of ticket.

   

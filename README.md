# common-framework
Please follow the steps to use this package in your code .

1. Download the package to your local system
2. Do an mvn clean 
3. Run command "mvn package"
4. Run the below install command 

mvn install:install-file -Dfile=<<Path of the downloaded project>>\AolStackDriverLogging\target\AolStackDriverLogging-1.0.0.jar -DgroupId=com.ingka.aol.StackDriverLogging -DartifactId=AolStackDriverLogging -Dversion=1.0.0 -Dpackaging=jar

5. In the pom file of your working code which needs the dependency for this utility jar file add the below dependency 
    	<dependency>
      <groupId>com.ingka.aol.StackDriverLogging</groupId>
      <artifactId>AolStackDriverLogging</artifactId>
      <version>1.0.0</version>
    </dependency>
	
 


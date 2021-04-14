FROM java:8-jre

LABEL maintainers="burakkilincofficial@gmail.com" \ 
	  image_description="nokia-0.0.1-SNAPSHOT jar app" \
	  app_environment="dev" \
	  app_version='0.0.1-SNAPSHOT.jar"
	  
COPY ./target/nokia-0.0.1-SNAPSHOT.jar

EXPOSE 8080
CMD ["java", "-jar", "nokia-0.0.1-SNAPSHOT.jar"]
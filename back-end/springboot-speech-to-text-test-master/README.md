## Test project for Watson Speech to Text on IBM Cloud using Spring Boot Starter
Just a quick project to test a Watson Speech to Text service instance on IBM Cloud using Spring Boot Starter: https://github.com/watson-developer-cloud/spring-boot-starter. A sample flac audio file will be transcribed.

## Setup
1. You'll need ibm cloud CLI from https://cloud.ibm.com/docs/cli/reference/ibmcloud?topic=cloud-cli-install-ibmcloud-cli#install_use and bx cf installed and configured to talk to the appropriate cf org/spac etc.
2. You'll need to edit the application.properties with your own Discovery credentials

## Build
```
./mvnw package
```

## Deploy
```
bx cf push -b java_buildpack -p target/testapp-0.0.1-SNAPSHOT.jar YourAppname
```

## Verify
1. navigate to http://YourAppname.mybluemix.net/test
2. check log: 
```
bx cf logs YourAppname --recent
```
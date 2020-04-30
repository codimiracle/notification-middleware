# notification-middleware
Send a notification with the easy way.

## Installation 
includes in `pom.xml`
```xml
<dependency>
	<groupId>com.codimiracle.web</groupId>
	<artifactId>notification-middleware</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```
## Features
* Integrated with rabbitmq for calling async (see NotificationQueueService)
* Preset notification type for simple.
* Custom persisted logic (see NotificationPersistedHandler)

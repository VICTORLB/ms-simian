## SpringBoot 2.1.3 Redis


### Requirements
Describe all dependencies and why it's necessary
* [Redis 3.x for cache of objects]

### Development setup
Describe how to install all development dependencies and how to run an automated test-suite of some kind. 

#### Installing [redis]
```sh
$ [brew install redis]
```

### Compiling 
```sh
$ mvn clean install
```

### Starting 
```sh
$ mvn spring-boot:run
$ open http://$(hostname):8080
```

### Compiling and Starting
```sh
$ sh startup.sh
```

## MS-Simian


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
$ open http://$(hostname):9000
```

### Compiling and Starting
```sh
$ sh startup.sh
```
## Routes

GET http://localhost:9000/api/v1/stats

POST http://localhost:9000/api/v1/simian

Example 
```curl -X POST \
  http://localhost:9000/api/v1/simian/ \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 47c04b8c-5011-44d2-bd5f-886690626094' \
  -H 'cache-control: no-cache' \
  -d '{
      "dna": ["AAGAGA", "TCAAGC", "TTCTGT", "ACGCTG", "CTCGTT", "TGTCGA"]
}'
  ```

## MS-Simian

### Development setup
Describe how to install all development dependencies and how to run an automated test-suite of some kind. 

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
## Routes

GET http://ec2-18-222-132-15.us-east-2.compute.amazonaws.com:8080/stats

POST http://ec2-18-222-132-15.us-east-2.compute.amazonaws.com:8080/simian

Example 
```curl -X POST \
  http://ec2-18-222-132-15.us-east-2.compute.amazonaws.com:8080/simian/ \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 47c04b8c-5011-44d2-bd5f-886690626094' \
  -H 'cache-control: no-cache' \
  -d '{
      "dna": ["AAGAGA", "TCAAGC", "TTCTGT", "ACGCTG", "CTCGTT", "TGTCGA"]
}'
  ```

# micro-poc
POC of microservice approach/architecture.

## Configuration

### Server
* Server port=8888 (default)
* Default configuration (_classpath:/application.yml_): **http://localhost:8888/default/env/**
* Mycfg configuration (_classpath:/mycfg.yml_ + _classpath:/application.yml_): **http://localhost:8888/mycfg/env/**

### Client
* Server port=8088
* Distinguish between application.yml and application.yml ==> application.yml is load by the client. Therefore the properties 
can override some important configurations (e.g. server port).
* Property **spring.cloud.config.name** defines the configuration profile (e.g. 'mycfg' for configuration 
file _classpath:/mycfg.yml_).  If not define than only default (_classpath:/application.yml_) is considered.
* Each configuration is read by the key, e.g. **http://localhost:8088/env/foo**
* Sample REST: **http://localhost:8088/hello**


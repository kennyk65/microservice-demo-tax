# Demo Microservice Example:  Tax Service

This is a simple web / REST app that calculates taxes for a given item.

/taxes - Takes the given item and calculates tax.

The basic tax rate is %10.  Some products like EEE are tax exempt (%0 tax)

Example:  If you GET /taxes with this body:
{"code":"JJJ","price":99.00,"quantity":2}
...it will return this body:
{"code":"JJJ","price":99.00,"quantity":2,"taxes":19.8}


This code also demonstrates:
- Basic usage of Spring Boot
- Spring Cloud is included, but not really used.
- Spring Cloud AWS is included, but not really used.
- Runs nicely on or off AWS.
- Actuator endpoints are present.

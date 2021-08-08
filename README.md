# stack-api

###### This is a set of APIs Exposing functionalities of a Stack data structure using REST endpoints.

Following are the allowed functionalities:

push - push an item to the top of the stack

pop - remove and return the top element of the stack

peek - return the top element of the stack without removing it

size - return the current size, i.e. the number of elements in the stack

isEmpty - check whether the stack is empty

resize - resize the stack to  a new size while maintaining the stack order

Note - Stack starts with an initial capacity of **100** elements


## **How to use**
Clone the repository locally,
make sure that Java 8 (minimum) and Maven are
installed locally.

Go to the application root directory -
path/to/stack-api

Run **mvn clean install**

Run spring boot application by using below command 

**mvnw spring-boot:run**

Now you can run the different stack endpoints - 

**Push** - 

localhost:8080/stack/push/{value}

where {value} is the value to be pushed to the stack

e.g. http://localhost:8080/stack/push/50

returns - 

{
"value": 50,
**"success": true,**
"empty": false
}

if the stack is full then

returns -

{
"value": 50,
**"success": false,**
"empty": false
}



**Pop** -

http://localhost:8080/stack/pop

on successful pop, returns -

{
**"value": 50,**
"success": true,
"empty": false
}

if the stack is empty then returns -

Http 204 NO_CONTENT return value

**Peek** - 

http://localhost:8080/stack/peek

on successful peek, returns -

{
**"value": 50,**
"success": true,
"empty": false
}

if the stack is empty then returns -

Http 204 NO_CONTENT return value

**isEmpty** - 

http://localhost:8080/stack/isEmpty

if the stack is not empty, returns - 

{
"value": 0,
"success": true,
**"empty": false**
}

if the stack is empty then returns -

{
"value": 0,
"success": true,
**"empty": true**
}

**size** - 

http://localhost:8080/stack/size

If the stack has 2 elements it returns size 2

{
**"value": 2,**
"success": true,
"empty": false
}

**resize** - 

http://localhost:8080/stack/resize/{value}

where {value} is the new capacity of the stack

if this value is less han existing stack size then 
resize operation will be unsuccessful, otherwise the
stack will be resized to this new value.


if the resize operation is unsuccessful, 

e.g., http://localhost:8080/stack/resize/1

returns - 400 BAD_REQUEST 

if the resize operation is not successful 

e.g., http://localhost:8080/stack/resize/105

returns - 

{
**"value": 105,**
"success": true,
"empty": false
}

where value denotes the new capacity of the stack after successful resize operation.

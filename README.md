# EmployeeStatus
EmployeeStatus Test Task

The Following is easy installation & setup guide to start the demo app .

## Build Project
- Here we make a jar file using maven to use the extracted file later by the following command.
``` bash
./mvnw install
```

## Install

- let's make our build to run it later via the following docker command.

``` bash
docker build -t EmployeeStatus/app .
```

## Run

-Now lets run our build via the following docker command.
```bash
docker run -p 8080:8080 EmployeeStatus/app
```
After running this piece of code we shall see the spring boot starter window running:

- Now it should be started.


## Note 
You can use an OpenApi Contact using Swagger via this link

http://localhost:8080/swagger-ui.html

Skip the following guide if you will use swagger .

-------------- 

If not ,

## Now , Let's Continue testing our app via rest api

I attached a collection file of postman to be able to check all call requests , it is located in the project root path.
#### here we go,


### a Post Method => add an employee
```
http://localhost:8080/api/employees
```
```
{
    "name":"Ahmed Sakr",
    "email":"prog.sakr@gmail.com",
    "age":26,
    "contract":"it is my contract"
}
```

### a Put Method => update employee state
```
http://localhost:8080/api/employees/1/change-state
```
```
{
    "state":4
}
```

### a Get Method => get all employees
```
http://localhost:8080/api/employees
```
```
Results
[
    {
        "id": 1,
        "name": "Ahmed Sakr",
        "email": "prog.sakr@gmail.com",
        "age": 26,
        "state": 2,
        "contract": "it is my contract",
        "created": "2021-05-11T02:38:05.771+00:00",
        "updated": "2021-05-11T02:38:53.192+00:00"
    }
]
```

### a Get Method => get a specific employee
```
http://localhost:8080/api/employees/1
```
```
Results
[
    {
        "id": 1,
        "name": "Ahmed Sakr",
        "email": "prog.sakr@gmail.com",
        "age": 26,
        "state": 2,
        "contract": "it is my contract",
        "created": "2021-05-11T02:38:05.771+00:00",
        "updated": "2021-05-11T02:38:53.192+00:00"
    }
]
```
# For The Test Works

i used simulated data by making demo method to perform that . that's because i use in-memory database (h2),
and data is not persented at the first time of starting the project up.



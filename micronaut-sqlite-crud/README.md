# **Micronaut SQLite CRUD**
This project is a small *CRUD* built with [**Micronaut**](http://micronaut.io/) framework and [**BelleORM**](https://github.com/s4kibs4mi/BelleORM) as ORM for *SQLite*

## **Contents**
* General Context
* Compile
* Tests
* Run
* Endpoints
    * *Branch Offices*
    * *Job Positions*
    * *Salary Parameters*
    * *Employees*

## **General Context**
A System that allow to create employees for a company and add it's job position and salary for each one, in order to
do that, the system must accomplish with the following requirements:

* System must allow the creation of branch offices and tag one of them as HeadQuarter
* An employee should be associated to a branch office
* If a employee exist in the system then cannot be associated to more than one branch office at a time
* A employee must have only one job position
* Salary must be calculated based on a formula:
> S = JobPositionSalary*RelationToHeadQuarter(This parmeter show difference between salaries, example: In Spain the salary is 85% the salary in England, this must be configurable per each branch office)

## **Compile**
```
./gradlew build
```

## **Tests**
```
./gradlew Tests
```

## **Run**

## **Endpoints**

#### Branch Offices

##### *POST*
```
http://$host/$service-name/offices
```

*Body:*
```json
{
  "branchOffice": "Cuenca",
  "isHeadQuarter": true
}
```

##### *GET*

###### *GET* All registers
```
http://$host/$service-name/offices
```

*Response:*
```json
[
    {
      "id": 1,
      "branchOffice": "Cuenca",
      "isHeadQuarter": true
    },
    {
      "id": 2,
      "branchOffice": "Tallin",
      "isHeadQuarter": false
    }
]
```

###### *GET* Branch Offices by ID
```
http://$host/$service-name/offices/$id
```

*Response:*
```json
{
  "id": 1,
  "branchOffice": "Cuenca",
  "isHeadQuarter": true
}
```

#### Job Positions

##### *POST*
```
http://$host/$service-name/job-positions
```

*Body:*
```json
{
  "positionName": "Software Developer"
}
```

##### *GET*

###### *GET* All registers
```
http://$host/$service-name/job-positions
```

*Response:*
```json
[
    {
      "id": 1,
      "positionName": "Software Developer"
    },
    {
      "id": 2,
      "positionName": "Office Manager"
    }
]
```

###### *GET* Job Positions by ID
```
http://$host/$service-name/job-positions/$id
```

*Response:*
```json
{
  "id": 1,
  "positionName": "Software Developer"
}
```

#### Salary Parameters

##### *POST*
```
http://$host/$service-name/salary-parameters
```

*Body:*
```json
{
  "belongHeadQuarter": true,
  "jobPositionId": 1,
  "branchOfficeId": 1,
  "relationToHeadQuarter": 1
}
```

##### *GET*

###### *GET* All registers
```
http://$host/$service-name/salary-parameters
```

*Response:*
```json
[
    {
      "id": 1,
      "belongHeadQuarter": true,
      "jobPositionId": 1,
      "branchOfficeId": 1,
      "relationToHeadQuarter": 1
    },
    {
      "id": 2,
      "belongHeadQuarter": false,
      "jobPositionId": 3,
      "branchOfficeId": 2,
      "relationToHeadQuarter": 0.87
    }
]
```

###### *GET* Salary Parameter by ID
```
http://$host/$service-name/salary-parameters/$id
```

*Response:*
```json
{
  "id": 1,
  "belongHeadQuarter": true,
  "jobPositionId": 1,
  "branchOfficeId": 1,
  "relationToHeadQuarter": 1
}
```

#### Employees

##### *POST*
```
http://$host/$service-name/employees
```

*Body:*
```json
{
  "name": "Daniel",
  "lastName": "Córdova",
  "jobPositionId": 1,
  "branchOfficeId": 1
}
```

##### *GET*

###### *GET* All registers
```
http://$host/$service-name/employees
```

*Response:*
```json
[
    {
      "id": 1,
      "name": "Daniel",
      "lastName": "Córdova",
      "jobPositionId": 1,
      "branchOfficeId": 1
    },
    {
      "id": 1,
      "name": "Sophia",
      "lastName": "Svenskaya",
      "jobPositionId": 2,
      "branchOfficeId": 3
    }
]
```

###### *GET* Employees by ID
```
http://$host/$service-name/employees/$id
```

*Response:*
```json
{
  "id": 1,
  "name": "Daniel",
  "lastName": "Córdova",
  "jobPositionId": 1,
  "branchOfficeId": 1
}
```

# **Micronaut SQLite CRUD**
This project is a small *CRUD* built with [**Micronaut**](http://micronaut.io/) framework and [**BelleORM**](https://github.com/s4kibs4mi/BelleORM) as ORM for *SQLite*

## **Contents**
* General Context
* Compile
* Tests
* Run
* Endpoints
    * *Schools*
    * *Careers*
    * *Persons*
    * *Students*

## **General Context**
A System that allow to save some university information like Schools, Careers and Students. To make it work properly 
the system must have the following instructions implemented.

* A University has *schools* like medical school or engineering school
* A *School* has *careers* like Computer Science or Philosophy
* A *career* must have semesters like Computer Science took 10 semesters to obtain a title
* A *student* belongs to a *career*
* A *student* is being in some *semester* of his/her *career*

## **Compile**

```
./gradlew build
```

## **Tests**

```
./gradlew test
```

## **Run**

## **Endpoints**

#### Schools

##### *POST*

```
http://$host/$service-name/school
```

*Body:*

```json
{
  "schoolName": "Engineering School"
}
```

##### *GET*

###### *GET* All registers

```
http://$host/$service-name/school
```

*Response:*

```json
[
    {
      "id": 1,
      "schoolName": "Engineering School"
    },
    {
      "id": 2,
      "schoolName": "Philosophy School"
    }
]
```

###### *GET* School by ID

```
http://$host/$service-name/school/$id
```

*Response:*

```json
{
  "id": 1,
  "schoolName": "Engineering School"
}
```

#### Careers

##### *POST*

```
http://$host/$service-name/career
```

*Body:*

```json
{
  "schoolId": 1,
  "career": "Computer Science"
}
```

##### *GET*

###### *GET* All registers

```
http://$host/$service-name/career
```

*Response:*

```json
[
    {
      "id": 1,
      "schoolId": 1,
      "career": "Computer Science"
    },
    {
      "id": 2,
      "schoolId": 2,
      "career": "Medicine"
    }
]
```

###### *GET* Career by ID

```
http://$host/$service-name/career/$id
```

*Response:*

```json
{
  "schoolId": 1,
  "career": "Computer Science"
}
```

#### Persons

##### *POST*

```
http://$host/$service-name/person
```

*Body:*

```json
{
  "dni": "987654258-7A",
  "name": "Daniel",
  "lastName": "Córdova"
}
```

##### *GET*

###### *GET* All registers

```
http://$host/$service-name/person
```

*Response:*

```json
[
    {
      "id": 1,
      "dni": "987654258-7A",
      "name": "Daniel",
      "lastName": "Córdova"
    },
    {
      "id": 2,
      "dni": "8887415512-2S",
      "name": "Sophia",
      "lastName": "Svenskaya"
    }
]
```

###### *GET* Person by ID

```
http://$host/$service-name/person/$id
```

*Response:*

```json
{
  "id": 1,
  "dni": "987654258-7A",
  "name": "Daniel",
  "lastName": "Córdova"
}
```

#### Students

##### *POST*

```
http://$host/$service-name/student
```

*Body:*

```json
{
  "schoolId": 1,
  "careerId": 1,
  "name": "Daniel",
  "lastName": "Córdova"
}
```

##### *GET*

###### *GET* All registers

```
http://$host/$service-name/student
```

*Response:*

```json
[
    {
      "id": 1,
      "schoolId": 1,
      "careerId": 1,
      "name": "Daniel",
      "lastName": "Córdova"
    },
    {
      "id": 2,
      "schoolId": 1,
      "careerId": 1,
      "name": "Sophia",
      "lastName": "Svenskaya"
    }
]
```

###### *GET* Student by ID

```
http://$host/$service-name/student/$id
```

*Response:*

```json
{
  "id": 1,
  "schoolId": 1,
  "careerId": 1,
  "name": "Daniel",
  "lastName": "Córdova"
}
```

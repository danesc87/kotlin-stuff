# **SpringBoot JPA CRUD**
This project is a small *CRUD* built with [Springboot](https://spring.io/projects/spring-boot) and uses *JPA* as a layer to connect to the Database like [Hibernate](http://hibernate.org/orm/)

## **Contents**
* [General Context](#general-context)
* [Compile](#compile)
* [Tests](#tests)
* [Run](#run)
* [Endpoints](#endpoints)
    * [*Author*](#author)  
	    	* [*POST*](#post)
	    	* [*GET*](#get)
	    	* [*PUT*](#put)
	    	* [*PATCH*](#patch)
	    	* [*DELETE*](#delete)
    * [*Type*](#type)  
		    * [*POST*](#post-1)
	    	* [*GET*](#get-1)
	    	* [*PUT*](#put-1)
	    	* [*DELETE*](#delete-1)
    * [*Genre*](#genre)  
		    * [*POST*](#post-2)
	    	* [*GET*](#get-2)
	    	* [*PUT*](#put-2)
	    	* [*PATCH*](#patch-1)
	    	* [*DELETE*](#delete-2)
    * [*Book*](#book)  
		    * [*POST*](#post-3)
	    	* [*GET*](#get-3)
	    	* [*PUT*](#put-3)
	    	* [*PATCH*](#patch-2)
	    	* [*DELETE*](#delete-3)

## **General Context**
This *CRUD* is a small system that allow users save some information about books like name, genre, type and author.
To make it work properly the system must have the following instructions implemented.  

* An *Author* can write several books
* There are Some *Types* of books like, Novel, Comic, Manga, etc
* *Genres* depend on the *Type* of book like Novel -> Horror or Manga -> Shounen
* *Books* must have one or more *Authors*, just one *Type* and one or more *Genres*

## **Compile**

```
./gradlew build
```

## **Tests**

```
./gradlew test
```

## **Run**

```
./gradlew bootRun
```

## **Endpoints**

#### Author

##### *POST*

```
http://$host:$port/$context-path/author
```

*Body:*

```json
{
  "name": "John",
  "lastName": "Doe"
}
```
##### *GET*

###### *GET* All registers

```
http://$host:$port/$context-path/author
```

*Response:*

```json
[
    {
      "id": 1,
      "name": "John",
      "lastName": "Doe"
    },
    {
      "id": 2,
      "name": "Jill",
      "lastName": "James"
    }
]
```

###### *GET* Author by ID

```
http://$host:$port/$context-path/author/$id
```

*Response:*

```json
{
  "id": 1,
  "name": "John",
  "lastName": "Doe"
}
```

##### *PUT*

```
http://$host:$port/$context-path/author/$id
```

*Body:*

```json
{
  "name": "John",
  "lastName": "Doe"
}
```

##### *PATCH*

```
http://$host:$port/$context-path/author/$id
```

*Body:*

```json
{
  // Whatever field or fields of Author object could be patched
  "name": "Arthur"
}
```

##### *DELETE*

```
http://$host:$port/$context-path/author/$id
```

#### Type

##### *POST*

```
http://$host:$port/$context-path/type
```

*Body:*

```json
{
  "typeName": "Manga"
}
```
##### *GET*

###### *GET* All registers

```
http://$host:$port/$context-path/type
```

*Response:*

```json
[
    {
      "id": 1,
      "typeName": "Manga"
    },
    {
      "id": 2,
      "typeName": "Novel"
    }
]
```

###### *GET* Type by ID

```
http://$host:$port/$context-path/type/$id
```

*Response:*

```json
{
  "id": 1,
  "typeName": "Manga"
}
```

##### *PUT*

```
http://$host:$port/$context-path/type/$id
```

*Body:*

```json
{
  "typeName": "Manga"
}
```

##### *DELETE*

```
http://$host:$port/$context-path/type/$id
```

#### Genre

##### *POST*

```
http://$host:$port/$context-path/genre
```

*Body:*

```json
{
  "typeId": 1,
  "genreName": "Shounen"
}
```
##### *GET*

###### *GET* All registers

```
http://$host:$port/$context-path/genre
```

*Response:*

```json
[
    {
      "id": 1,
      "typeId": 1,
      "genreName": "Shounen"
    },
    {
      "id": 2,
      "typeId": 2,
      "genreName": "Science Fiction"
    }
]
```

###### *GET* Genre by ID

```
http://$host:$port/$context-path/genre/$id
```

*Response:*

```json
{
  "id": 1,
  "typeId": 1,
  "genreName": "Shounen"
}
```

##### *PUT*

```
http://$host:$port/$context-path/genre/$id
```

*Body:*

```json
{
  "typeId": 1,
  "genreName": "Shounen"
}
```

##### *PATCH*

```
http://$host:$port/$context-path/genre/$id
```

*Body:*

```json
{
  // Whatever field or fields of Genre object could be patched
  "genreName": "Sci-Fi"
}
```

##### *DELETE*

```
http://$host:$port/$context-path/genre/$id
```

#### Book

##### *POST*

```
http://$host:$port/$context-path/book
```

*Body:*

```json
{
  "authorIds": [1],
  "typeId": 2,
  "genreIds": [1],
  "bookName": "Ring World"
}
```
##### *GET*

###### *GET* All registers

```
http://$host:$port/$context-path/book
```

*Response:*

```json
[
    {
      "id": 1,
      "authorIds": [1],
      "typeId": 2,
      "genreIds": [1],
      "bookName": "Ring World"
    },
    {
      "id": 2,
      "authorIds": [3],
      "typeId": 2,
      "genreIds": [1,4],
      "bookName": "1984"
    }
]
```

###### *GET* Book by ID

```
http://$host:$port/$context-path/book/$id
```

*Response:*

```json
{
  "id": 1,
  "authorIds": [1],
  "typeId": 2,
  "genreIds": [1],
  "bookName": "Ring World"
}
```

##### *PUT*

```
http://$host:$port/$context-path/book/$id
```

*Body:*

```json
{
  "authorIds": [2,3],
  "typeId": 2,
  "genreIds": [1,4,8],
  "bookName": "Tyran"
}
```

##### *PATCH*

```
http://$host:$port/$context-path/book/$id
```

*Body:*

```json
{
  // Whatever field or fields of Book object could be patched
  "genreIds": [3],
  "bookName": "Sons of Ring World"
}
```

##### *DELETE*

```
http://$host:$port/$context-path/book/$id
```

# Spring Hibernate CRUD operations

Foobar is a Python library for dealing with word pluralization.

#### Excepted Output
```
Student ID 1
Name: Atindra
Age: 28
Marks: 78.0
--------------
---------Student 1 Found------
---------After Updation------
Student ID 1
Name: Arindam
Age: 21
Marks: 65.0
--------------
---------Student 1 Found------
---------After Deletion------
No Student Record Found
```

## Installation

### Create SQL query
~~~
CREATE TABLE `test`.`student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `marks` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idstudent_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
~~~



## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)

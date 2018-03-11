Project to configure multiple database.. 
For quick test added jdbcTemplate inside controller. Its bad from a design prespective. Hence do not do it in live projects. Instead write a service class to process data.

Sample configuration to connect multiple database
Check application.properties for config 
Connects MySQL & Postgres DB
Uses spring jdbc for DB communication. See config in config folder ( MultipleDBConfig.java ) 
Controllers with GET end point for mysql and postgres 

POSTGRES DB
Table: cities
	id
	code
	name
MYSQL
Table: city
	ID
	Name
	CountryCode
	District
	Population
	

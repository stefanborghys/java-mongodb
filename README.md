java-mongodb
============

MongoDB - terminology:
- collection: acts as a container for documents
- document: 
- field:

Install MongoDB
---------------
Tuturial: http://docs.mongodb.org/manual/tutorial/install-mongodb-on-os-x/

Mac manual installation summary:

1. download MongoDB: http://www.mongodb.org/downloads
- Mac OS X 64-bit version 2.6.1 is already included in the project

2. extract downloaded archive
- extracted in mongodb/mongodb-osx-x86_64-2.6.1

3. add MongoDB to the PATH
Console: export PATH=<java-mongodb-directory>/java-mongodb/mongodb/mongodb-osx-x86_64-2.6.1/bin:$PATH

Replace <java-mongodb-directory> by your local project path!

4. run MongoDB
4.1 create a data directoy
- already created in data/db

4.2 start MongoDB
Console: mongod --dbpath <java-mongodb-directory>/java-mongodb/data/db --config <java-mongodb-directory>/java-mongodb/mongodb/mongodb-osx-x86_64-2.6.1/bin/mongodb.config

Replace <java-mongodb-directory> by your local project path!


On start-up the MongodB's port number is shown.
This is important because it needs to be set in the spring application-config.xml
and can be used to get inspect the db using a web interface.
This can be found on http://localhost:<port-number>

Default port-number: 27017 or 28017

4.3 stop MongoDB
Console: ctrl + c 

Run Mongo Client
----------------
1. start Mongo
Can be found in: <java-mongodb-directory>/java-mongodb/mongodb/mongodb-osx-x86_64-2.6.1/bin/mongo

2. stop Mongo
Console: exit

Mongo Commands
--------------

db 				: shows the name of the current database (default database is 'test')
show dbs 		: show the list of databases
show databases
use <db-name>	: switch to a new database named <db-name>



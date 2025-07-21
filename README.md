Hibernate Overview :

    Hibernate is an open-source Object-Relational Mapping (ORM) framework for Java. 
    It simplifies database interactions by mapping Java classes to database tables and Java data types to SQL data types. It enables developers to interact with databases using Java objects without writing extensive SQL queries.

Core Features :

   > ORM (Object Relational Mapping)	Maps Java objects to relational database tables
   > Automatic Table Creation	Automatically generates schema from Java classes
   > HQL (Hibernate Query Language)	A powerful, object-oriented query language similar to SQL
   > Caching	Supports first-level and second-level caching for performance
   > Transactions	Built-in support for transaction management
   > Lazy Loading	Loads child objects on demand to optimize performance
   > Database Independence	Reduces coupling by abstracting SQL and DB-specific features

Architecture :

    > Configuration – Contains DB connection properties and mapping files.

    > SessionFactory – A heavyweight object created once per application to manage DB sessions.

    > Session – A lightweight object used to interact with the database.

    > Transaction – Ensures atomic operations during data manipulation.
 
    > Query – For executing HQL or native SQL queries.


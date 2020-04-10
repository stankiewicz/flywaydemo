## About the project
This is demo project to showcase schema migration with flyway.

It is based on flyway's [fork](https://github.com/stankiewicz/flyway/tree/release_core) with added release. 


## What is supported

1. DDL
2. DML
3. Mix of DDLs and DMLs

For DMLs, be aware of mutation limits - use partitioned DMLs wherever possible.

## What is not supported

1. Rollback of failed migrations.

    If there is failed migration, there were errors in the middle of migration:
    - it has to be manually rolled back (e.g. revert creation of index)
    - run flyway.repair() 
    - fix migration script, rerun migration
    
2. Locking - it's user responsibility to ensure migration is not run in parallel with other migrations. 


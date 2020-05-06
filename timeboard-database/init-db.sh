#!/bin/bash
echo "Initializing schema"

echo "Creating accounts and project_test database"
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "postgres" <<-EOSQL
    CREATE DATABASE accounts;
    GRANT ALL PRIVILEGES ON DATABASE accounts TO admin;

    CREATE DATABASE project_test;
    GRANT ALL PRIVILEGES ON DATABASE project_test TO admin;
EOSQL

echo "Executing >>> /sql-data/accounts_schema.sql"
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "accounts" < "/sql-data/accounts_schema.sql";

echo "Executing >>> /sql-data/projects_schema.sql"
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "project_test" < "/sql-data/projects_schema.sql";


echo "Finishing Initializing. Hooray"
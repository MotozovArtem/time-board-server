echo "Initializing schema"

echo "Executing >>> /sql-data/schema.sql"
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" < "/sql-data/schema.sql";
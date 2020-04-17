#!/bin/bash
echo "Initializing schema"

echo "Executing >>> /sql-data/schema.sql"
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" < "/sql-data/schema.sql";


FILES=(
"/sql-data-init/Accaunt.sql"
"/sql-data-init/GroupTask.sql"
"/sql-data-init/Task.sql"
"/sql-data-init/TaslAttachment.sql"
"/sql-data-init/ProjectSchema.sql"
"/sql-data-init/Step.sql"
"/sql-data-init/Role.sql"
"/sql-data-init/ProjectDashBoard.sql"
"/sql-data-init/GroupTask.sql"
"/sql-data-init/ProjectUser.sql"
"/sql-data-init/Task.sql"
"/sql-data-init/UserRole.sql"
"/sql-data-init/Commit.sql"
"/sql-data-init/Comment.sql"
"/sql-data-init/TaskCommit.sql"
"/sql-data-init/TaskObserver.sql"
"/sql-data-init/TaskAttachment.sql"
"/sql-data-init/CommentAttachment.sql"
)

echo "Starting loop";
for f in ${FILES[@]}
do
	if test -f "$f"; then
		echo "Executing $f"
		psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" < "$f" ;
	else
		echo "File $f not founded"
	fi
done

echo "Finishing Initializing. Hooray"
INSERT INTO project_user(id, project_schema, joining_date, leaving_date, project)
VALUES ('387909eb-7447-426a-b578-1447498be675', '87a8ed31-4d6c-4dad-b6c8-74b17f9a9d2c', '2020-01-02', NULL,
		'e0e8b93c-3c31-4c29-bd12-be6c37de01df');

INSERT INTO project_user(id, project_schema, joining_date, leaving_date, project)
VALUES ('a0de5ed5-1204-44b1-bc96-ceace661dd48', '7ef5adb2-156a-4066-b45e-439f5255337b', '2020-01-03', NULL,
		'e0e8b93c-3c31-4c29-bd12-be6c37de01df');

INSERT INTO project_user(id, project_schema, joining_date, leaving_date, project)
VALUES ('c109854b-2b99-417b-9d81-4fc23f5717a5', 'e5ba06fa-536a-4387-a706-351b7ce2e8be', '2020-01-03', NULL,
		'e0e8b93c-3c31-4c29-bd12-be6c37de01df');

INSERT INTO project_user(id, project_schema, joining_date, leaving_date, project)
VALUES ('c685721c-f704-493e-bebb-107766bbf25a', '23e8bf3c-6b34-41a8-a7ad-5fd6c438524c', '2020-01-05', NULL,
		'e0e8b93c-3c31-4c29-bd12-be6c37de01df');

INSERT INTO project_user(id, project_schema, joining_date, leaving_date, project)
VALUES ('33ddf909-9d85-46b2-9c2f-1ca686f4bdba', 'bc44de64-b317-4958-8e17-7dea21d59f13', '2020-01-05', NULL,
		'e0e8b93c-3c31-4c29-bd12-be6c37de01df');

INSERT INTO project_user(id, project_schema, joining_date, leaving_date, project)
VALUES ('31615395-8ad5-437c-9ab4-2eaea4e51552', '8a4a81a0-8fb7-4c1f-a918-63a73133d9e1', '2020-01-06', NULL,
		'e0e8b93c-3c31-4c29-bd12-be6c37de01df');


UPDATE accounts.project_schema
SET user_in_project='387909eb-7447-426a-b578-1447498be675'
WHERE id = '87a8ed31-4d6c-4dad-b6c8-74b17f9a9d2c';

UPDATE accounts.project_schema
SET user_in_project='a0de5ed5-1204-44b1-bc96-ceace661dd48'
WHERE id = '7ef5adb2-156a-4066-b45e-439f5255337b';

UPDATE accounts.project_schema
SET user_in_project='c109854b-2b99-417b-9d81-4fc23f5717a5'
WHERE id = 'e5ba06fa-536a-4387-a706-351b7ce2e8be';

UPDATE accounts.project_schema
SET user_in_project='c685721c-f704-493e-bebb-107766bbf25a'
WHERE id = '23e8bf3c-6b34-41a8-a7ad-5fd6c438524c';

UPDATE accounts.project_schema
SET user_in_project='33ddf909-9d85-46b2-9c2f-1ca686f4bdba'
WHERE id = 'bc44de64-b317-4958-8e17-7dea21d59f13';

UPDATE accounts.project_schema
SET user_in_project='31615395-8ad5-437c-9ab4-2eaea4e51552'
WHERE id = '8a4a81a0-8fb7-4c1f-a918-63a73133d9e1';


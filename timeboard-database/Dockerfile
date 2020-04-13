FROM library/postgres:11.6 AS clear

ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD admin
ENV POSTGRES_DB time_board_db

RUN mkdir /sql-data

COPY ./src/main/sql /sql-data

COPY init-db.sh /docker-entrypoint-initdb.d/init-db.sh
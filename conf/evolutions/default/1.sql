-- !Ups

CREATE SCHEMA test;

CREATE TABLE test.some_data(
  id_some_data SERIAL PRIMARY KEY,
  data VARCHAR(100)
);

-- !Downs

DROP TABLE test.some_data;
DROP SCHEMA test;




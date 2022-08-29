BEGIN;



DROP TABLE customer;
CREATE TABLE customer (id  PRIMARY KEY, title VARCHAR(255));
INSERT INTO customer (title) VALUES
('VLADIMIR'),
('ESSE');




COMMIT;
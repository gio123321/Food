CREATE TABLE ingredient(
id serial primary key,
name VARCHAR(30) NOT NULL,
quantity double NOT NULL,
quantity_type VARCHAR(15) NOT NULL,
comment VARCHAR(80)
)
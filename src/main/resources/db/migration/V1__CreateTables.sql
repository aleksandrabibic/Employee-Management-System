CREATE TABLE if not exists store_manager(
	id BIGSERIAL PRIMARY KEY,
    first_name varchar(40),
    last_name varchar(100),
    number_of_stores integer,
    number_of_employees integer
);

CREATE TABLE if not exists employee(
	id BIGSERIAL PRIMARY KEY,
    first_name varchar(40),
    last_name varchar(100),
	role varchar(40),
	store_name varchar(40) unique,
	store_manager_id BIGSERIAL references store_manager(id)
);

CREATE TABLE if not exists stores(
	id BIGSERIAL PRIMARY KEY,
	name varchar(40),
	address varchar(50),
	phone_number varchar(50),
	store_manager_id BIGSERIAL references store_manager(id)

);
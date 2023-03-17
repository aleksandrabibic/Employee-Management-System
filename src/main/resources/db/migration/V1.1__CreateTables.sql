CREATE TABLE if not exists users(
	id BIGSERIAL PRIMARY KEY,
	email varchar(40),
	password varchar(100),
	role varchar(40),
    first_name varchar(40),
    last_name varchar(100)

);

CREATE TABLE if not exists stores(
	id BIGSERIAL PRIMARY KEY,
	name varchar(40),
	address varchar(50),
	phone_number varchar(50),
	user_id BIGSERIAL references users(id)

);
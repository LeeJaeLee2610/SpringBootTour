create table users(
	uid serial primary key,
	username text not null,
	password varchar(100) not null,
	admin INTEGER
)

create table employee(
	employee_id INTEGER PRIMARY key,
	employee_name text  NOT NULL,
	dob date not null,
	address text not null,
	gmail text not null,
	department_id varchar(10) not null,
	foreign key (department_id) REFERENCES department(department_id),
	foreign key (employee_id) REFERENCES users(uid)
);

create table department(
	department_id varchar(10) primary key,
	department_name text NOT NULL
)

create table role(
	role_id varchar(10) PRIMARY key,
	role_name text not null
	foreign key (role_id) REFERENCES users(uid)
)

create table role_function(
	id varchar(10) primary key,
	role_id varchar(10) not null,
	function_id varchar(10) not null,
	foreign key (role_id) REFERENCES role(role_id),
	foreign key (function_id) REFERENCES function(function_id)
)

create table function(
	function_id varchar(10) PRIMARY key,
	function_name text not null
)

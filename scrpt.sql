CREATE TABLE Patients (
        id INTEGER IDENTITY PRIMARY KEY,
	firstName VARCHAR(50) NOT NULL,
        lastName VARCHAR(50) NOT NULL,
	patronymic VARCHAR(50) NOT NULL,
	telephone VARCHAR(50) NOT NULL);


CREATE TABLE DOCTORS (
        id INTEGER IDENTITY PRIMARY KEY,
	firstName VARCHAR(50) NOT NULL,
        lastName VARCHAR(50) NOT NULL,
	patronymic VARCHAR(50) NOT NULL,
	specialization VARCHAR(50) NOT NULL);

CREATE TABLE RECIPE (
        id INTEGER IDENTITY PRIMARY KEY,
description VARCHAR(300) NOT NULL,
	patient VARCHAR(100) NOT NULL,
        doctor VARCHAR(100) NOT NULL,
	dateCreate VARCHAR(100) NOT NULL,
	dateValid VARCHAR(100) NOT NULL,
	priority VARCHAR(100) NOT NULL);
CREATE SCHEMA IF NOT EXISTS coffee_shop_management;
CREATE TABLE coffee_shop (
    id SERIAL PRIMARY KEY,
    name varchar(100),
    location varchar(100),
    number_of_queue int,
    contact_detail varchar(100),
    open_time int,
    close_time int,
    created_by varchar(20),
    created_date timestamp without time zone,
    updated_by varchar(20),
    updated_date timestamp without time zone
);

CREATE TABLE menu (
     id SERIAL PRIMARY KEY,
     name varchar(50),
     price DECIMAL,
     created_by varchar(20),
     created_date timestamp without time zone,
     updated_by varchar(20),
     updated_date timestamp without time zone
);

CREATE TABLE menu_shop (
      menu_shop_id SERIAL PRIMARY KEY,
      coffee_shop_id int,
      menu_id int,
      expected_min_time int,
      expected_max_time int,
      created_by varchar(20),
      created_date timestamp without time zone,
      updated_by varchar(20),
      updated_date timestamp without time zone
);

CREATE SEQUENCE hibernate_sequence START 1;
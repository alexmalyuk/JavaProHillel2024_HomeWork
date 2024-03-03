drop database if exists hillel_orders;
create database hillel_orders;
use hillel_orders;

#
drop table if exists products;
drop table if exists orders;

#
CREATE TABLE if not exists orders
(
    id   varchar(36) not null
        primary key,
    date date,
    cost float
);

#
CREATE TABLE if not exists products
(
    id       varchar(36) not null
        primary key,
    name     varchar(100),
    cost     float,
    order_id varchar(36) not null,
    constraint order_products_order_id_fk
        foreign key (order_id) references orders (id)
            on update cascade on delete cascade
);

#
insert into orders(id, date, cost)
VALUES ('f2b68738-5f8a-4688-bdc2-41845ea45536', '2024-02-29', 25);

#
insert into products(id, name, cost, order_id)
VALUES ('5e73b742-c4de-4082-8cb9-6e9924b9b10a', 'Сало', 10, 'f2b68738-5f8a-4688-bdc2-41845ea45536');
insert into products(id, name, cost, order_id)
VALUES ('fb8354cb-dd07-4511-8a2f-8f0f48ae1ad6', 'Хрін', 12, 'f2b68738-5f8a-4688-bdc2-41845ea45536');
insert into products(id, name, cost, order_id)
VALUES ('4964071c-ee7a-48ef-b1b0-7ac003826e52', 'Цибуля', 3, 'f2b68738-5f8a-4688-bdc2-41845ea45536');



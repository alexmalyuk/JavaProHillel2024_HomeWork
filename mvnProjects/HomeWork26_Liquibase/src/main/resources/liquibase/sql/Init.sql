#
# Database initialization
#
drop database if exists hillel_test;
create database hillel_test;
use hillel_test;

#
drop table if exists lessons_schedules;
drop table if exists lesson;
drop table if exists homework;
drop table if exists schedule;

#
CREATE TABLE homework
(
    id          int          not null auto_increment
        primary key,
    name        varchar(35)  not null,
    description varchar(200) null
);

#
create table lesson
(
    id          int         not null auto_increment
        primary key,
    name        varchar(35) not null,
    updatedAt   datetime    not null
        default CURRENT_TIMESTAMP,
    homework_id int         null unique,
    constraint lesson_homework_id_fk
        foreign key (homework_id) references homework (id)
            on update cascade on delete cascade
);

#
CREATE TABLE schedule
(
    id        int         not null auto_increment
        primary key,
    name      varchar(35) not null,
    updatedAt datetime    not null
        default CURRENT_TIMESTAMP
);

#
create table lessons_schedules
(
    lesson_id   int not null,
    constraint lessons_schedules_lesson_id_fk
        foreign key (lesson_id) references homework (id)
            on update cascade on delete cascade,
    schedule_id int not null,
    constraint lessons_schedules_schedule_id_fk
        foreign key (schedule_id) references schedule (id)
            on update cascade on delete cascade
);

# Adding demo data
insert into homework (name, description) values ('TCLEOSE Instruction', 'et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient');
insert into homework (name, description) values ('Patient Safety', 'curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin');
insert into homework (name, description) values ('WS-*', 'nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem');
insert into homework (name, description) values ('IBC', 'quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi');
insert into homework (name, description) values ('NRSWA', 'viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non');
insert into homework (name, description) values ('VW', 'vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in');
insert into homework (name, description) values ('RSA Security', 'posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in');
insert into homework (name, description) values ('JCT', 'ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet');
insert into homework (name, description) values ('BTS', 'amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in');
insert into homework (name, description) values ('Lead Generation', 'proin risus praesent lectus vestibulum quam sapien varius ut blandit non interdum in ante vestibulum');
insert into homework (name, description) values ('Medical Education', 'nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit');
insert into homework (name, description) values ('Kodak', 'molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur');
insert into homework (name, description) values ('Socket.io', 'lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate');
insert into homework (name, description) values ('Youth Outreach', 'mi in porttitor pede justo eu massa donec dapibus duis at velit eu');
insert into homework (name, description) values ('Commercial Kitchen Design', 'eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus');
insert into homework (name, description) values ('DBC', 'erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla');
insert into homework (name, description) values ('Whole Life', 'nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor');
insert into homework (name, description) values ('Speech Writing', 'vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis');
insert into homework (name, description) values ('Physical Security', 'velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et');
insert into homework (name, description) values ('Content Strategy', 'quam pharetra magna ac consequat metus sapien ut nunc vestibulum');

#
insert into lesson (name, updatedAt, homework_id) values ('et', '2003-04-01 05:12:44', 2);
insert into lesson (name, updatedAt, homework_id) values ('sed ante', '2007-06-07 20:35:12', 20);
insert into lesson (name, updatedAt, homework_id) values ('integer', '2004-06-22 20:39:30', 1);
insert into lesson (name, updatedAt, homework_id) values ('libero nullam', '2020-07-23 22:54:05', 10);
insert into lesson (name, updatedAt, homework_id) values ('integer a nibh', '2007-09-16 09:00:48', null);
insert into lesson (name, homework_id) values ('sit amet nulla', 13);
insert into lesson (name, updatedAt, homework_id) values ('praesent blandit', '2013-03-18 23:34:07', null);
insert into lesson (name, updatedAt, homework_id) values ('in porttitor', '2007-12-03 04:49:12', 8);
insert into lesson (name, updatedAt, homework_id) values ('vestibulum quam', '2002-03-21 04:54:03', 6);
insert into lesson (name, updatedAt, homework_id) values ('in', '2014-02-07 15:26:30', 14);
insert into lesson (name, updatedAt, homework_id) values ('cubilia', '2009-04-22 02:14:10', null);
insert into lesson (name, updatedAt, homework_id) values ('ut', '2011-06-04 07:22:44', 11);
insert into lesson (name, updatedAt, homework_id) values ('scelerisque', '2005-01-22 04:37:19', 3);
insert into lesson (name, updatedAt, homework_id) values ('vel augue', '2015-01-22 23:33:23', 12);
insert into lesson (name, updatedAt, homework_id) values ('purus eu', '2013-02-23 07:08:22', 5);
insert into lesson (name, homework_id) values ('accumsan tortor', 4);
insert into lesson (name, updatedAt, homework_id) values ('ut', '2001-12-04 11:15:17', 15);
insert into lesson (name, updatedAt, homework_id) values ('pellentesque', '2017-03-18 20:26:35', 9);
insert into lesson (name, updatedAt, homework_id) values ('ridiculus', '2002-05-07 02:02:08', 16);
insert into lesson (name, updatedAt, homework_id) values ('luctus et ultrices', '2001-10-06 14:22:43', 18);
insert into lesson (name, updatedAt, homework_id) values ('et commodo vulputate', '2000-06-15 03:48:03', 7);
insert into lesson (name, updatedAt, homework_id) values ('sit amet lobortis', '2019-09-02 00:50:42', 19);

#
insert into schedule (name, updatedAt) values ('in hac', '2009-11-09 23:01:43');
insert into schedule (name, updatedAt) values ('diam in magna', '2014-05-24 23:48:22');
insert into schedule (name) values ('dictumst');
insert into schedule (name, updatedAt) values ('nulla facilisi', '2000-02-28 20:26:46');
insert into schedule (name, updatedAt) values ('blandit ultrices', '2045-11-26 20:08:24');
insert into schedule (name, updatedAt) values ('est phasellus', '2004-07-19 10:15:21');
insert into schedule (name, updatedAt) values ('bibendum', '2017-06-08 11:54:01');
insert into schedule (name, updatedAt) values ('venenatis non', '2046-07-16 16:08:52');
insert into schedule (name, updatedAt) values ('nibh', '2036-01-09 00:54:04');
insert into schedule (name, updatedAt) values ('tincidunt eu', '2028-01-14 01:52:22');
insert into schedule (name) values ('pretium nisl ut');
insert into schedule (name, updatedAt) values ('donec', '2016-07-31 18:06:01');
insert into schedule (name, updatedAt) values ('nulla mollis molestie', '2049-01-09 15:05:59');
insert into schedule (name, updatedAt) values ('dis parturient', '2011-05-16 20:44:31');
insert into schedule (name, updatedAt) values ('in imperdiet et', '2020-11-19 20:46:25');
insert into schedule (name, updatedAt) values ('ultrices phasellus', '2012-09-09 16:58:48');
insert into schedule (name, updatedAt) values ('maecenas', '2040-09-22 11:24:58');
insert into schedule (name, updatedAt) values ('amet nunc', '2017-02-15 07:47:43');
insert into schedule (name, updatedAt) values ('sit amet consectetuer', '2037-08-08 12:40:33');
insert into schedule (name, updatedAt) values ('quam turpis adipiscing', '2020-04-16 19:06:17');
insert into schedule (name, updatedAt) values ('gravida nisi', '2004-01-11 17:18:20');
insert into schedule (name, updatedAt) values ('cras in purus', '2037-05-06 01:45:36');
insert into schedule (name, updatedAt) values ('sem sed', '2044-12-12 00:18:33');
insert into schedule (name, updatedAt) values ('tempus', '2018-02-02 02:15:52');
insert into schedule (name) values ('sapien quis');
insert into schedule (name, updatedAt) values ('curabitur', '2037-10-18 04:14:41');
insert into schedule (name, updatedAt) values ('pretium nisl ut', '2041-03-28 11:25:36');
insert into schedule (name, updatedAt) values ('eget nunc', '2048-06-17 00:19:47');
insert into schedule (name, updatedAt) values ('amet', '2035-02-24 14:40:57');
insert into schedule (name, updatedAt) values ('nunc purus phasellus', '2010-09-04 04:22:01');

#
insert into lessons_schedules (lesson_id, schedule_id) values (13, 29);
insert into lessons_schedules (lesson_id, schedule_id) values (10, 8);
insert into lessons_schedules (lesson_id, schedule_id) values (11, 6);
insert into lessons_schedules (lesson_id, schedule_id) values (6, 17);
insert into lessons_schedules (lesson_id, schedule_id) values (16, 3);
insert into lessons_schedules (lesson_id, schedule_id) values (6, 2);
insert into lessons_schedules (lesson_id, schedule_id) values (15, 29);
insert into lessons_schedules (lesson_id, schedule_id) values (11, 16);
insert into lessons_schedules (lesson_id, schedule_id) values (20, 9);
insert into lessons_schedules (lesson_id, schedule_id) values (14, 15);
insert into lessons_schedules (lesson_id, schedule_id) values (15, 20);
insert into lessons_schedules (lesson_id, schedule_id) values (2, 9);
insert into lessons_schedules (lesson_id, schedule_id) values (1, 29);
insert into lessons_schedules (lesson_id, schedule_id) values (9, 11);
insert into lessons_schedules (lesson_id, schedule_id) values (1, 6);
insert into lessons_schedules (lesson_id, schedule_id) values (20, 20);
insert into lessons_schedules (lesson_id, schedule_id) values (4, 11);
insert into lessons_schedules (lesson_id, schedule_id) values (19, 10);
insert into lessons_schedules (lesson_id, schedule_id) values (7, 25);
insert into lessons_schedules (lesson_id, schedule_id) values (4, 14);
insert into lessons_schedules (lesson_id, schedule_id) values (17, 22);
insert into lessons_schedules (lesson_id, schedule_id) values (2, 23);
insert into lessons_schedules (lesson_id, schedule_id) values (10, 15);
insert into lessons_schedules (lesson_id, schedule_id) values (6, 7);
insert into lessons_schedules (lesson_id, schedule_id) values (16, 19);
insert into lessons_schedules (lesson_id, schedule_id) values (8, 30);
insert into lessons_schedules (lesson_id, schedule_id) values (3, 29);
insert into lessons_schedules (lesson_id, schedule_id) values (2, 4);
insert into lessons_schedules (lesson_id, schedule_id) values (4, 5);
insert into lessons_schedules (lesson_id, schedule_id) values (12, 25);
insert into lessons_schedules (lesson_id, schedule_id) values (17, 18);
insert into lessons_schedules (lesson_id, schedule_id) values (16, 30);
insert into lessons_schedules (lesson_id, schedule_id) values (11, 27);
insert into lessons_schedules (lesson_id, schedule_id) values (15, 26);
insert into lessons_schedules (lesson_id, schedule_id) values (2, 12);
insert into lessons_schedules (lesson_id, schedule_id) values (19, 26);
insert into lessons_schedules (lesson_id, schedule_id) values (20, 9);
insert into lessons_schedules (lesson_id, schedule_id) values (8, 20);
insert into lessons_schedules (lesson_id, schedule_id) values (3, 29);
insert into lessons_schedules (lesson_id, schedule_id) values (2, 1);
insert into lessons_schedules (lesson_id, schedule_id) values (5, 14);
insert into lessons_schedules (lesson_id, schedule_id) values (6, 29);
insert into lessons_schedules (lesson_id, schedule_id) values (11, 24);
insert into lessons_schedules (lesson_id, schedule_id) values (16, 2);
insert into lessons_schedules (lesson_id, schedule_id) values (7, 18);
insert into lessons_schedules (lesson_id, schedule_id) values (2, 11);
insert into lessons_schedules (lesson_id, schedule_id) values (18, 20);
insert into lessons_schedules (lesson_id, schedule_id) values (14, 29);
insert into lessons_schedules (lesson_id, schedule_id) values (7, 3);
insert into lessons_schedules (lesson_id, schedule_id) values (7, 11);
insert into lessons_schedules (lesson_id, schedule_id) values (17, 25);
insert into lessons_schedules (lesson_id, schedule_id) values (17, 25);
insert into lessons_schedules (lesson_id, schedule_id) values (15, 15);
insert into lessons_schedules (lesson_id, schedule_id) values (10, 23);

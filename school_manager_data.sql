delete from course_session;
delete from course;

-- COURSE
insert into course values('BD50','Learning Oracle Developpement');
insert into course values('FC20','AngularJS in Depth');
insert into course values('TO75','Ruby from Scratch');
insert into course values('LO43','Git Introduction');
insert into course values('LO54','Java for Entretprise Applications');
insert into course values('MT45','Mathematics for enginneer');
insert into course values('SA25','Microservices building with Flask');
insert into course values('PO31','Mastering Docker');
insert into course values('BO78','Designs Patterns in Java');
insert into course values('XS45','More agile Testing');

-- LOCATION
insert into location(city) values ('Paris');
insert into location(city) values ('Berlin');
insert into location(city) values ('Reykjavik');
insert into location(city) values ('Ottawa');
insert into location(city) values ('Dakar');
insert into location(city) values ('Madrid');
insert into location(city) values ('Strasbourg');
insert into location(city) values ('Sydney');

--COURSE SESSIONS
insert into course_session(course_code, location_id, start_date, end_date) values('BD50',2,'2017/12/12', '2017/12/16');
insert into course_session(course_code, location_id, start_date, end_date) values('BD50',3,'2017/12/28', '2017/12/31');
insert into course_session(course_code, location_id, start_date, end_date) values('BD50',4,'2017/12/1', '2017/12/11');
insert into course_session(course_code, location_id, start_date, end_date) values('BD50',1,'2017/1/7', '2017/1/9');
insert into course_session(course_code, location_id, start_date, end_date) values('BD50',5,'2017/2/19', '2017/2/22');

insert into course_session(course_code, location_id, start_date, end_date) values('FC20',6,'2017/1/16', '2017/1/19');
insert into course_session(course_code, location_id, start_date, end_date) values('FC20',7,'2017/1/21', '2017/2/3');
insert into course_session(course_code, location_id, start_date, end_date) values('FC20',8,'2017/2/5', '2017/2/11');
insert into course_session(course_code, location_id, start_date, end_date) values('FC20',5,'2017/12/12', '2017/12/16');
insert into course_session(course_code, location_id, start_date, end_date) values('FC20',2,'2017/7/25', '2017/7/30');
insert into course_session(course_code, location_id, start_date, end_date) values('FC20',3,'2017/03/17', '2017/03/22');

insert into course_session(course_code, location_id, start_date, end_date) values('TO75',3,'2017/06/05', '2017/05/11');
insert into course_session(course_code, location_id, start_date, end_date) values('TO75',4,'2017/04/13', '2017/04/19');
insert into course_session(course_code, location_id, start_date, end_date) values('TO75',5,'2017/10/1','2017/10/7');
insert into course_session(course_code, location_id, start_date, end_date) values('TO75',6,'2017/02/21', '2017/02/25');
insert into course_session(course_code, location_id, start_date, end_date) values('TO75',7,'2017/09/2', '2017/09/18');
insert into course_session(course_code, location_id, start_date, end_date) values('TO75',1,'2017/12/28', '2017/12/31');




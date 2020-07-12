create database animalsurvey;
use animalsurvey;

create table surveyresult (
    id int not null,
    surveyoption varchar(20) not null,
    votes int not null,
    constraint surveyresult_id primary key (id)
);

insert into surveyresult (id, surveyoption, votes) values (1, "Dog", 0);
insert into surveyresult (id, surveyoption, votes) values (2, "Cat", 0);
insert into surveyresult (id, surveyoption, votes) values (3, "Bird", 0);
insert into surveyresult (id, surveyoption, votes) values (4, "Snake", 0);
insert into surveyresult (id, surveyoption, votes) values (5, "None", 0);




use FinalProject;

drop table if exists Trainer_Workouts;
drop table if exists Personal_Records;

drop table if exists Workouts;
drop table if exists Trainers;

create table Trainers(
trainers_id int NOT NUll auto_increment,
name varchar (128) NOT NULL,
primary key (trainers_id));

create table Workouts(
workout_id int NOT NUll auto_increment,
workout varchar (128) ,
primary key (workout_id));

create table Personal_Records(
personal_records_id int NOT NUll auto_increment,
workout_id int,
weight int,
reps int Not Null,
primary key (personal_records_id),
foreign key (workout_id) references Workouts (workout_id));

create table Trainer_Workouts (
trainers_id int not null,
workout_id int not null,
foreign key (workout_id) references Workouts (workout_id),
foreign key (trainers_id) references Trainers (trainers_id),
unique key (workout_id, trainers_id));


insert INTO Workouts(
workout) Values (
"bench");

insert INTO Trainer_Workouts(
trainers_id, workout_id) Values (
1,1);
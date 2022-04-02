create database messages collate utf8mb4_general_ci;
use messages;

drop table userTable;
create table userTable(
userId int not null,
email varchar(50) not null,
username varchar(50) not null,
userPassword varchar(50) not null,

constraint userId_PK primary key(userId)
); 

drop table administratorTable;
create table administratorTable(
administratorId int not null,
email varchar(50) not null,
username varchar(50) not null,
administratorPassword varchar(50) not null,

constraint administratorId_PK primary key(administratorId)
); 

drop table messageStream;
create table messageStream(
messageStreamId int not null auto_increment,
senderId int not null,
recieverId int not null,
textmessage varchar(5000) null,
hashedMessage varchar(5000) not null,

constraint messageStreamId_PK primary key(messageStreamId),
constraint senderId_FK foreign key (senderId) references userTable(userId),
constraint recieverId_FK foreign key (recieverId) references userTable(userId)
);

-- check if tables work
insert into userTable values(1, "Pavel.Khakhlou@mail.ru", "Babeldir", "hasfash");
insert into userTable values(2, "Pavel.Khakhlou@gmx.ru", "Ridlebab", "hsafsah");

insert into messagestream values(null, 1, 2, "Hallo User 1!!!!", "afaf343r");
insert into messagestream values(null, 2, 1, "wie geht es dir?", "mrssc24545");


select * from userTable as uTsender join messageStream as mS on uTsender.userId = mS.messageStreamId join userTable as uTreciever on uTreciever.userId = mS.messageStreamId;


select * from userTable;

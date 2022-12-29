create database board;
use board;
create table user(
	userId varchar(300) primary key,
    userPw varchar(300) not null,
    userName varchar(300) not null
);

create table board(
	boardNum bigint primary key auto_increment,
    boardTitle varchar(300) not null,
    boardContents varchar(6000) not null,
    userId varchar(300),
    regDate datetime default now(),
    updateDate datetime default now(),
    constraint board_user_fk foreign key(userId) references user(userId)
);

select * from spring_user;
drop table spring_board;
drop table spring_user;
select * from board order by boardnum;

insert into user (userId, userPw, userName) values('user00','zxzz12', 'user00');
insert into user (userId, userPw, userName) values('user01','zxzz12', 'user01');
insert into board (boardTitle, boardContents, userId) values('테스트 제목', '테스트 내용', 'user00');

insert into board values
	('테스트 제목', '테스트 내용', 'user00'),
    ('테스트 제목', '테스트 내용', 'user01');
    


insert into board (boardTitle, boardContents, userId) (select boardTitle, boardContents, userId from board);
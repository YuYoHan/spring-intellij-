use web0315;

create table spring_user(
	userId varchar(300) primary key,
    userPw varchar(300) not null,
    userName varchar(300) not null
);

create table spring_board(
	boardNum bigint primary key auto_increment,
    boardTitle varchar(300) not null,
    boardContents varchar(6000) not null,
    userId varchar(300),
    regDate datetime default now(),
    updateDate datetime default now(),
    constraint board_user_fk foreign key(userId) references spring_user(userId)
);

select * from spring_user;
drop table spring_board;
drop table spring_user;
select * from spring_board order by boardnum desc;

insert into spring_board (boardTitle, boardContents, userId) values('테스트 제목1', 'apple이 작성한 테스트 내용1', 'apple');
insert into spring_board (boardTitle, boardContents, userId) values('테스트 제목2', 'banana이 작성한 테스트 내용2', 'banana');
insert into spring_board (boardTitle, boardContents, userId) values('테스트 제목3', 'cheery이 작성한 테스트 내용3', 'cheery');
insert into spring_board (boardTitle, boardContents, userId) values('테스트 제목4', 'durian이 작성한 테스트 내용4', 'durian');
insert into spring_board (boardTitle, boardContents, userId)
values	('테스트 제목1', 'apple이 작성한 테스트 내용1', 'apple'), 
		('테스트 제목2', 'banana이 작성한 테스트 내용2', 'banana'),
        ('테스트 제목3', 'cheery이 작성한 테스트 내용3', 'cheery'),
        ('테스트 제목4', 'durian이 작성한 테스트 내용4', 'durian');

insert into spring_board (boardTitle, boardContents, userId) (select boardTitle, boardContents, userId from spring_board);


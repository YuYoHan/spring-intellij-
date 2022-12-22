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
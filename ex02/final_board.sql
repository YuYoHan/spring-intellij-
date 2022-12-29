use web0315;
create table spring_user(
	userid varchar(300) primary key,
    userpw varchar(300) not null,
    username varchar(300) not null
);
create table spring_board(
	boardnum bigint primary key auto_increment,
	boardtitle varchar(300) not null,
    boardcontents varchar(6000) not null,
    userid varchar(300),
    regdate datetime default now(),
    updatedate datetime default now(),
    constraint board_user_fk foreign key(userid) references spring_user(userid)
);
drop table spring_user;
drop table spring_board;

select * from spring_user;
select * from spring_board order by boardnum desc;

insert into spring_board (boardtitle,boardcontents,userid) values('테스트 제목1','apple이 작성한 테스트 내용1','apple');
insert into spring_board (boardtitle,boardcontents,userid) values('테스트 제목2','banana가 작성한 테스트 내용2','banana');
insert into spring_board (boardtitle,boardcontents,userid) values('테스트 제목3','cherry가 작성한 테스트 내용3','cherry');
insert into spring_board (boardtitle,boardcontents,userid) values('테스트 제목4','durian이 작성한 테스트 내용4','durian');

insert into spring_board (boardtitle,boardcontents,userid) (select boardtitle,boardcontents,userid from spring_board);

create table spring_reply(
	replynum bigint primary key auto_increment,
	userid varchar(300),
    replycontents varchar(4000) not null,
    regdate datetime default now(),
    updatedate datetime default now(),
    boardnum bigint,
    constraint reply_user_fk foreign key(userid) references spring_user(userid),
    constraint reply_board_fk foreign key(boardnum) references spring_board(boardnum)
);

insert into spring_reply (userid,replycontents,boardnum) values('apple','테스트용 댓글',393174);
insert into spring_reply (userid,replycontents,boardnum) values('banana','테스트용 댓글2',393174);
insert into spring_reply (userid,replycontents,boardnum) values('cherry','테스트용 댓글3',393174);
insert into spring_reply (userid,replycontents,boardnum) values('durian','테스트용 댓글4',393174);

select * from spring_reply;



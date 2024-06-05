create table USERS (
    USER_ID varchar(10) primary key,
    PASS varchar(40) not null,
    MAIL varchar(100) not null,
    USER_NAME varchar(40) not null,
    DATEOFBIRTH date not null
);
insert into USERS (USER_ID, PASS, MAIL,USER_NAME, DATEOFBIRTH)
values ('minato', '1234', 'yusuke.minato@miyabilonk.jp','湊　雄輔', '2001-05-01');

create table TASKGROUP (
    TASKGROUP_ID integer primary key auto_increment,
    TASKGROUP_NAME varchar(50) not null
);
insert into TASKGROUP (TASKGROUP_NAME)
values ('メール');

create table TASKS (
    TASK_ID integer primary key auto_increment,
    USER_ID varchar(10) not null references USERS(USER_ID),
    TASKGROUP_ID integer not null references TASKGROUP(TASKGROUP_ID),
    TASK_CONTENT varchar(255) not null,
    TANTATIVE_START_DATETIME datetime not null,
    TANTATIVE_END_DATETIME datetime not null,
    START_DATETIME datetime,
    END_DATETIME datetime
);
insert into TASKS (USER_ID, TASKGROUP_ID, TASK_CONTENT, TANTATIVE_START_DATETIME, TANTATIVE_END_DATETIME)
values ('minato', '1', '午前中分メール対応', '2024-6-2 09:00:00','2024-6-2 09:15:00');

/data/workoptimizer
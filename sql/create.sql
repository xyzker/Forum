create table Board (
        id integer not null auto_increment,
        dateCreated datetime,
        deleted bit not null,
        version integer not null,
        description varchar(255),
        name varchar(255),
        replyCount integer not null,
        threadCount integer not null,
        category_id integer,
        last_reply_id integer,
        last_thread_id integer,
        primary key (id)
	);
 create table Category (
        id integer not null auto_increment,
        dateCreated datetime,
        deleted bit not null,
        version integer not null,
        name varchar(255),
        primary key (id)
    );
   create table Person (
        id integer not null auto_increment,
        dateCreated datetime,
        deleted bit not null,
        version integer not null,
        account varchar(255),
        birthday varchar(255),
        dateLastActived datetime,
        email varchar(255),
        ipCreated varchar(255),
        ipLastActived varchar(255),
        name varchar(255),
        password varchar(255),
        sex varchar(255),
        primary key (id)
    );
     create table Reply (
        id integer not null auto_increment,
        dateCreated datetime,
        deleted bit not null,
        version integer not null,
        content longtext,
        floor integer not null,
        ipCreated varchar(255),
        title varchar(255),
        author_id integer,
        thread_id integer,
        primary key (id)
    );
     create table Thread (
        id integer not null auto_increment,
        dateCreated datetime,
        deleted bit not null,
        version integer not null,
        content longtext,
        dateLastReplied datetime,
        hit integer not null,
        ipCreated varchar(255),
        readonly bit not null,
        replyCount integer not null,
        title varchar(255),
        topped bit not null,
        author_id integer,
        author_last_reply_id integer,
        board_id integer,
        primary key (id)
    );
    create table board_administrator (
        board_id integer not null,
        person_id integer not null,
        primary key (board_id, person_id)
    );
    alter table Board 
        add index FK3D5FEC67A28C6AC (category_id), 
        add constraint FK3D5FEC67A28C6AC 
        foreign key (category_id) 
        references Category (id);
    alter table Board 
        add index FK3D5FEC65368891 (last_reply_id), 
        add constraint FK3D5FEC65368891 
        foreign key (last_reply_id) 
        references Reply (id);
    alter table Board 
        add index FK3D5FEC661E62943 (last_thread_id), 
        add constraint FK3D5FEC661E62943 
        foreign key (last_thread_id) 
        references Thread (id);
    alter table Reply 
        add index FK4B322CA25005FAC (thread_id), 
        add constraint FK4B322CA25005FAC 
        foreign key (thread_id) 
        references Thread (id);
    alter table Reply 
        add index FK4B322CAD3149DD6 (author_id), 
        add constraint FK4B322CAD3149DD6 
        foreign key (author_id) 
        references Person (id);
    alter table Thread 
        add index FK9545FA2AD3149DD6 (author_id), 
        add constraint FK9545FA2AD3149DD6 
        foreign key (author_id) 
        references Person (id);
    alter table Thread 
        add index FK9545FA2AC21447EC (author_last_reply_id), 
        add constraint FK9545FA2AC21447EC 
        foreign key (author_last_reply_id) 
        references Person (id);
    alter table Thread 
        add index FK9545FA2A5AF80F88 (board_id), 
        add constraint FK9545FA2A5AF80F88 
        foreign key (board_id) 
        references Board (id);
    alter table board_administrator 
        add index FKBDEF7934ADFB57CC (person_id), 
        add constraint FKBDEF7934ADFB57CC 
        foreign key (person_id) 
        references Person (id);
    alter table board_administrator 
        add index FKBDEF79345AF80F88 (board_id), 
        add constraint FKBDEF79345AF80F88 
        foreign key (board_id) 
        references Board (id);
    

   
create table files (
    id int not null auto_increment primary key,
    institute varchar(128) not null,
    major varchar(128) not null,
    admission_info varchar(1024) not null,
    job_info varchar(1024) not null,
    teaching_quality varchar(1024) not null,
    construct_file varchar(1024),
    upload_time datetime not null default current_timestamp,
    note varchar(1024)
);
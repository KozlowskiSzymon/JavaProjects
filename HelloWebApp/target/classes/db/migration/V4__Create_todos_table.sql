create table importantTasks (
    id int unsigned primary key auto_increment,
    text varchar(100) not null,
    done bit
);
create table todoTasks (
    id int unsigned primary key auto_increment,
    text varchar(100) not null,
    done bit
);
create table anytimeTasks (
    id int unsigned primary key auto_increment,
    text varchar(100) not null,
    done bit
);
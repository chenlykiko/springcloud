create table payment(
    id bigint(20) not null auto_increment comment 'ID',
    serial varchar(200) default '',
    primary key(id)
)ENGINE=InnoDB auto_increment=1 default charset=utf8
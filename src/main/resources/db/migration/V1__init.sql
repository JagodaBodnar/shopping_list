create table pp_item
(
    id       bigint not null
        primary key,
    name     varchar(255),
    price    numeric(38, 2),
    quantity bigint not null
);
create sequence pp_item_seq
    increment by 1 cache 50;

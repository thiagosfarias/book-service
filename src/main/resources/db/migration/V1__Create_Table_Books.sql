create table if not exists books (
    id serial primary key,
    author varchar(100) not null,
    title  varchar(100) not null,
    price decimal(19,2) not null,
    launch_date date not null
)
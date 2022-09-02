create database exam;

use exam;
create table book
(
	id int primary key  auto_increment,
    author varchar(50),
    book_name varchar(50),
    publication_year int,
    pages int
);

insert  book(author,book_name,publication_year,pages)
	values("Author1","Book1",2021,123);
insert  book(author,book_name,publication_year,pages)
	values("Author2","Book2",2021,123);
insert  book(author,book_name,publication_year,pages)
	values("Author3","Book3",2021,123);
insert  book(author,book_name,publication_year,pages)
	values("Author4","Book4",2021,123);
insert  book(author,book_name,publication_year,pages)
	values("Author5","Book5",2021,123);
insert  book(author,book_name,publication_year,pages)
	values("Author6","Book6",2021,123);
    
    
use exam;
drop table messages;
create table messages
(
	id int primary key auto_increment,
    likes int default(0),
    dislike int default(0),
    text varchar(100)
);

insert messages(text)
	values("gweigpweijgopwjgewegoj");
insert messages(text)
	values("pweogjpwojgwpejewpogjg");
insert messages(text)
	values("ookowfpqjfjwp");

select * from messages;
update messages set likes=1 where id=1;

use exam;
create table account
(
	id int primary key auto_increment,
    login varchar(50),
    sum int default(0)
);

insert account(login)
	values("1111");
insert account(login)
	values("hateGnom");
insert account(login)
	values("1234");

select * from account;




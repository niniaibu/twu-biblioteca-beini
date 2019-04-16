select title from book where id in (select id from book except select distinct book_id from checkout_item)
union
select title from movie where id in (select id from movie except select distinct movie_id from checkout_item);


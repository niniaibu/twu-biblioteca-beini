select name from member where id in (select member_id from checkout_item where book_id is not null intersect select member_id from checkout_item where movie_id is not null);

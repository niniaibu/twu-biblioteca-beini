select name from member where id in (select member_id from checkout_item where book_id in (select id from book where title = "The Hobbit"));

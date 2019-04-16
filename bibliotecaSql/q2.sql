select count(*) from member where id in (select id from member except select distinct member_id from checkout_item);

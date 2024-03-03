# all orders
select *
from orders;

# order by id
select *
from orders
where id = 'f2b68738-5f8a-4688-bdc2-41845ea45536';

# products by order_id
select p.id, p.name, p.cost
from products p
where p.order_id = 'f2b68738-5f8a-4688-bdc2-41845ea45536'

#
delete FROM products WHERE order_id = 'sdsd' AND id='dsdsd'

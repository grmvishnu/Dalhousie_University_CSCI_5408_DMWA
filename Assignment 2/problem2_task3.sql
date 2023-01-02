USE a2rm286720;

SET autocommit = 0;

START TRANSACTION;

# insert statement 1
INSERT INTO olist_customers_dataset (customer_id, customer_unique_id, customer_zip_code_prefix, customer_city, customer_state) VALUES
	('yugrfo6i7fgqufyhgr36fre8', '3uygfi45f7evu6e74fr8u7we', '23453', 'halifax', 'NS'),
    ('eyrgfu5quyfu3y4rfvge6w483hrey', '437gf34gr79giwf84', '785', 'mumbai', 'Karnataka'),
    ('fyg7e5t3874witirwufhgrw4urhof83', 'i34gt7824tr93igrf723i', '1912', 'hyderabad' , 'telangana'),
    ('ugfo3746f73twrg7fi2qgefw', 'wu4tgr78wegtf7834gfu7wki7gf', '2119', 'hyderabad', 'telangana');

# insert statement 2
INSERT INTO product_category_name_translation (product_category_name, product_category_name_english) VALUES ('lait', 'milk'), 
	('yaourt', 'yogurt'), ('fromage', 'cheese'), ('beurre', 'butter');

# select statement 1   
SELECT * FROM olist_products_dataset INNER JOIN (SELECT product_id FROM olist_order_items_dataset ORDER BY (order_item_id*price) 
	DESC LIMIT 1) AS A ON A.product_id = olist_products_dataset.product_id;
    
# select statement 2
SELECT seller_id FROM olist_sellers_dataset WHERE sellser_zip_code_prefix IN (SELECT geolocation_zip_code_prefix 
	FROM olist_geolocation_dataset WHERE geolocation_zip_code_prefix BETWEEN '1000' AND '1100');

# select statement 3
SELECT olist_sellers_dataset.seller_id, olist_sellers_dataset.sellser_zip_code_prefix, olist_sellers_dataset.seller_city, 
	olist_sellers_dataset.seller_state FROM olist_sellers_dataset JOIN olist_order_items_dataset ON olist_sellers_dataset.seller_id = 
    olist_order_items_dataset.seller_id JOIN olist_orders_dataset ON olist_order_items_dataset.order_id = olist_orders_dataset.order_id 
    JOIN (SELECT order_id FROM olist_order_payments_dataset ORDER BY payment_installments DESC LIMIT 1) AS A ON 
    A.order_id = olist_orders_dataset.order_id;

# update statement 1
UPDATE olist_sellers_dataset JOIN olist_geolocation_dataset ON olist_sellers_dataset.sellser_zip_code_prefix = 
	olist_geolocation_dataset.geolocation_zip_code_prefix SET olist_sellers_dataset.sellser_zip_code_prefix = 143 AND 
    olist_sellers_dataset.seller_city = 'markapur' AND olist_geolocation_dataset.geolocation_zip_code_prefix = 143 AND
    olist_geolocation_dataset.geolocation_state = 'AP' WHERE olist_sellers_dataset.seller_state = 'PR';

# update statement 2
UPDATE olist_order_reviews_dataset JOIN olist_orders_dataset ON olist_order_reviews_dataset.order_id = olist_orders_dataset.order_id 
	JOIN olist_customers_dataset ON olist_orders_dataset.customer_id = olist_customers_dataset.customer_id SET 
    olist_order_reviews_dataset.review_comment_message = 'I am satisfied' WHERE olist_customers_dataset.customer_unique_id 
    = 'e90a1b194724309bbaa6228c398d1748';

# delete statement 1
DELETE olist_products_dataset FROM olist_products_dataset INNER JOIN olist_order_items_dataset ON olist_products_dataset.product_id = 
	olist_order_items_dataset.product_id INNER JOIN olist_sellers_dataset ON olist_order_items_dataset.seller_id = olist_sellers_dataset.seller_id
    WHERE olist_sellers_dataset.seller_id = '1025f0e2d44d7041d6cf58b6550e0bfa';

# delete statement 2
DELETE olist_customers_dataset FROM olist_customers_dataset INNER JOIN olist_orders_dataset ON olist_customers_dataset.customer_id = 
	olist_orders_dataset.customer_id INNER JOIN olist_order_payments_dataset ON olist_orders_dataset.order_id = olist_order_payments_dataset.
    order_id WHERE olist_order_payments_dataset.payment_installments = 24;

COMMIT;

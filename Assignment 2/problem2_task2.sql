USE a2rm286720;

SET autocommit = 0;

START TRANSACTION;

# select statement 1
SELECT order_id FROM olist_orders_dataset WHERE customer_id IN (SELECT customer_id FROM olist_customers_dataset WHERE 
	customer_city = 'sao paulo' OR 'curitiba');

# insert statement 1
INSERT INTO olist_sellers_dataset (seller_id, sellser_zip_code_prefix, seller_city, seller_state) VALUES 
	('shdvbjyshve87efe8ut7qwyd', '28', 'boleto', 'TS'), ('ebfyew6gi7rtg3i4fr723gyevdki7w6t47', '4', 'voucher', 'AP');

# update statement 1
UPDATE olist_products_dataset JOIN product_category_name_translation SET olist_products_dataset.product_category_name = 
product_category_name_translation.product_category_name WHERE olist_products_dataset.product_category_name = 
product_category_name_translation.product_category_name_english;

# select statement 2
SELECT customer_id FROM olist_customers_dataset WHERE customer_zip_code_prefix IN (SELECT geolocation_zip_code_prefix 
	FROM olist_geolocation_dataset WHERE geolocation_zip_code_prefix BETWEEN '1000' AND '1100');

# insert statement 2
INSERT INTO olist_products_dataset VALUES ('vefuyu4ryfswvyfuyfieuh783', 'market_place', '12', '1912', '9', '69', '73', '873', '25'), 
	('w78rwugfwurfg67fwyefv', 'cool_stuff', '16', '143', '3', '56', '34', '6772', '782');

# update statement 2
UPDATE olist_order_items_dataset AS i JOIN olist_orders_dataset AS o ON i.order_id = o.order_id JOIN olist_order_reviews_dataset AS r 
	ON r.order_id = o.order_id SET i.price = i.price - (i.price/1) WHERE r.review_score = 1;

# select statement 3
SELECT product_id, product_category_name FROM olist_products_dataset WHERE product_id = (SELECT product_id FROM olist_order_items_dataset 
	GROUP BY product_id ORDER BY sum(price) DESC LIMIT 1);

# delete statement 1
DELETE FROM olist_order_payments_dataset WHERE olist_order_payments_dataset.payment_type = 'not defined' AND 
	olist_order_payments_dataset.payment_value = 0;

# delete statement 2
DELETE olist_products_dataset FROM olist_products_dataset JOIN product_category_name_translation ON 
	olist_products_dataset.product_category_name = product_category_name_translation.product_category_name WHERE 
    olist_products_dataset.product_category_name = '';
    
COMMIT;
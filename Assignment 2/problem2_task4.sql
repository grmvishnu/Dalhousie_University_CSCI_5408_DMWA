USE a2rm286720;

SET autocommit = 0;

START TRANSACTION;

# insert statement 1
INSERT INTO olist_geolocation_dataset (geolocation_zip_code_prefix, geolocation_lat, geolocation_lng, geolocation_city, geolocation_state)
	VALUES ('10101', '-27.23737', '-46.64738', 'hyderabad', 'TS'), ('10102', '-87.23634', '-76.4847', 'bangalore', 'delhi'),
    ('10103', '-25.72528', '-26.926529', 'pune', 'maharashtra');
    
# insert statement 2     
INSERT INTO olist_order_reviews_dataset (review_id, order_id, review_score, review_comment_title, review_comment_message, review_creation_date, 
	review_answer_timestamp) VALUES ('8948949dfbviur79283', '009905140e9f8cc35d5be897937381db', '3', '', 'not bad and not good', '2/13/2022 0:00', 
    '2/14/2022 17:27'), ('ebf736gifwge7843', '00a379dfab816a83741012b71b264098', '4', 'review', 'good only', '12/19/2020 8:00', '5/9/2021 23:00');
    
# select statement 1
SELECT olist_customers_dataset.customer_id, olist_customers_dataset.customer_city, olist_customers_dataset.customer_state FROM 
	olist_customers_dataset JOIN olist_orders_dataset ON olist_customers_dataset.customer_id = olist_orders_dataset.customer_id WHERE 
    olist_orders_dataset.customer_id = (SELECT customer_id FROM olist_orders_dataset WHERE order_id = (SELECT order_id FROM 
    olist_order_payments_dataset GROUP BY order_id ORDER BY sum(payment_value) DESC LIMIT 1));

# select statement 2
SELECT MAX(olist_order_payments_dataset.payment_value) FROM olist_order_payments_dataset WHERE order_id IN (SELECT order_id FROM 
	olist_orders_dataset JOIN olist_customers_dataset ON olist_orders_dataset.customer_id = olist_customers_dataset.customer_id WHERE
    olist_orders_dataset.customer_id = '0004164d20a9e969af783496f3408652');

# select statement 3
SELECT olist_orders_dataset.customer_id FROM olist_orders_dataset JOIN olist_order_reviews_dataset ON olist_orders_dataset.order_id = 
	olist_order_reviews_dataset.order_id WHERE olist_orders_dataset.order_id IN (SELECT olist_order_reviews_dataset.order_id FROM 
    olist_order_reviews_dataset WHERE review_score = 1);

# update statement 1
UPDATE olist_order_items_dataset JOIN olist_products_dataset ON olist_order_items_dataset.product_id = olist_products_dataset.product_id SET
	olist_order_items_dataset.price = (olist_order_items_dataset.price * 1.1) WHERE olist_order_items_dataset.product_id IN (SELECT product_id 
    FROM olist_products_dataset WHERE product_weight_g > 10000 AND product_length_cm > 100);

# update statement 2
UPDATE olist_sellers_dataset JOIN olist_order_items_dataset ON olist_sellers_dataset.seller_id = olist_order_items_dataset.seller_id SET
	olist_sellers_dataset.sellser_zip_code_prefix = 190699 WHERE olist_sellers_dataset.seller_id IN (SELECT seller_id FROM 
    olist_order_items_dataset WHERE order_item_id >= 3);

# delete statement 1
DELETE FROM product_category_name_translation WHERE product_category_name_translation.product_category_name IN (SELECT product_category_name 
FROM olist_products_dataset WHERE product_description_lenght > 1000);

# delete statement 2
DELETE olist_products_dataset FROM olist_products_dataset WHERE olist_products_dataset.product_id IN (SELECT product_id FROM 
	olist_order_items_dataset WHERE seller_id IN (SELECT seller_id FROM olist_sellers_dataset WHERE sellser_zip_code_prefix = 14093));

COMMIT;
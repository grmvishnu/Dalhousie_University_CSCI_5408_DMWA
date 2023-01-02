import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Execution
{
    static List<String> localQueries;
    static List<String> gcpQueries;

    public static void transaction() throws Exception
    {
        localQueries = new ArrayList<>();
        gcpQueries = new ArrayList<>();

        localQueries.add("INSERT INTO olist_geolocation_dataset (geolocation_zip_code_prefix, geolocation_lat, " +
                "geolocation_lng, geolocation_city, geolocation_state) VALUES ('1011100', '-27.23737', '-46.64738', " +
                "'hyderabad', 'TS'), ('1011200', '-87.23634', '-76.4847', 'bangalore', 'delhi'), ('1011300', '-25.72528', " +
                "'-26.926529', 'pune', 'maharashtra');");

        localQueries.add("INSERT INTO olist_order_reviews_dataset (review_id, order_id, review_score, review_comment_title, " +
                "review_comment_message, review_creation_date, review_answer_timestamp) VALUES ('8948949dfbviur79283', " +
                "'009905140e9f8cc35d5be897937381db', '3', '', 'not bad and not good', '2/13/2022 0:00', '2/14/2022 17:27'), " +
                "('ebf736gifwge7843', '00a379dfab816a83741012b71b264098', '4', 'review', 'good only', '12/19/2020 8:00', " +
                "'5/9/2021 23:00');");

        localQueries.add("SELECT olist_customers_dataset.customer_id, olist_customers_dataset.customer_city, " +
                "olist_customers_dataset.customer_state FROM olist_customers_dataset JOIN olist_orders_dataset ON " +
                "olist_customers_dataset.customer_id = olist_orders_dataset.customer_id WHERE olist_orders_dataset." +
                "customer_id = (SELECT customer_id FROM olist_orders_dataset WHERE order_id = (SELECT order_id FROM " +
                "olist_order_payments_dataset GROUP BY order_id ORDER BY sum(payment_value) DESC LIMIT 1));");

        localQueries.add("SELECT MAX(olist_order_payments_dataset.payment_value) FROM olist_order_payments_dataset WHERE" +
                " order_id IN (SELECT order_id FROM olist_orders_dataset JOIN olist_customers_dataset ON " +
                "olist_orders_dataset.customer_id = olist_customers_dataset.customer_id WHERE olist_orders_dataset." +
                "customer_id = '0004164d20a9e969af783496f3408652');");

        localQueries.add("SELECT olist_orders_dataset.customer_id FROM olist_orders_dataset JOIN " +
                "olist_order_reviews_dataset ON olist_orders_dataset.order_id = olist_order_reviews_dataset.order_id " +
                "WHERE olist_orders_dataset.order_id IN (SELECT olist_order_reviews_dataset.order_id FROM " +
                "olist_order_reviews_dataset WHERE review_score = 1);");

        gcpQueries.add("UPDATE olist_order_items_dataset JOIN olist_products_dataset ON olist_order_items_dataset." +
                "product_id = olist_products_dataset.product_id SET olist_order_items_dataset.price = " +
                "(olist_order_items_dataset.price * 1.2) WHERE olist_order_items_dataset.product_id IN (SELECT product_id " +
                "FROM olist_products_dataset WHERE product_weight_g > 10000 AND product_length_cm > 100);");

        gcpQueries.add("UPDATE olist_sellers_dataset JOIN olist_order_items_dataset ON olist_sellers_dataset.seller_id " +
                "= olist_order_items_dataset.seller_id SET olist_sellers_dataset.sellser_zip_code_prefix = 210998 WHERE " +
                "olist_sellers_dataset.seller_id IN (SELECT seller_id FROM olist_order_items_dataset WHERE order_item_id >= 4);");

        gcpQueries.add("DELETE FROM product_category_name_translation WHERE product_category_name_translation." +
                "product_category_name IN (SELECT product_category_name FROM olist_products_dataset WHERE " +
                "product_description_lenght > 9000);");

        gcpQueries.add("DELETE olist_products_dataset FROM olist_products_dataset WHERE olist_products_dataset.product_id " +
                "IN (SELECT product_id FROM olist_order_items_dataset WHERE seller_id IN (SELECT seller_id FROM " +
                "olist_sellers_dataset WHERE sellser_zip_code_prefix = 14091));");

        String transactionStart = "START TRANSACTION;";
        String transactionEnd = "COMMIT;";
        long startTime = 0;
        long endTime = 0;

        try
        {
            Connection connect1;
            Connection connect2;

            Class.forName("com.mysql.cj.jdbc.Driver");
            connect1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/a2rm286720", "root", "Wishhh@2021");
            Statement stat1 = connect1.createStatement();
            connect1.setAutoCommit(false);
            startTime = System.currentTimeMillis();

            stat1.execute(transactionStart);
            System.out.println("Transaction started in local instance.");
            stat1.execute(localQueries.get(0));
            System.out.println("First insert query executed.");
            stat1.execute(localQueries.get(1));
            System.out.println("Second insert query executed.");
            stat1.execute(localQueries.get(2));
            System.out.println("First select query executed.");
            stat1.execute(localQueries.get(3));
            System.out.println("Second select query executed.");
            stat1.execute(localQueries.get(4));
            System.out.println("Third select query executed.");

            connect2 = DriverManager.getConnection("jdbc:mysql://34.72.255.252:3306/a2rm286720", "root", "Wishhh@2021");
            Statement stat2 = connect2.createStatement();
            connect2.setAutoCommit(false);

            stat2.execute(transactionStart);
            System.out.println("Transaction started in VM instance.");
            stat2.execute(gcpQueries.get(0));
            System.out.println("First update query executed.");
            stat2.execute(gcpQueries.get(1));
            System.out.println("Second update query executed.");
            stat2.execute(gcpQueries.get(2));
            System.out.println("First delete query executed.");
            stat2.execute(gcpQueries.get(3));
            System.out.println("Second delete query executed.");

            stat1.execute(transactionEnd);
            System.out.println("Transaction committed in local instance.");
            stat2.execute(transactionEnd);
            System.out.println("Transaction committed in VM instance.");
            endTime = System.currentTimeMillis();

            connect1.setAutoCommit(true);
            connect2.setAutoCommit(true);

            connect1.close();
            connect2.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Transaction start time is: " + startTime);
        System.out.println("Transaction end time is: " + endTime);
        System.out.println("The total transaction execution time is: " + ((endTime - startTime) / 1000) + " seconds");
    }

    public static void main(String[] args) throws Exception
    {
        transaction();
    }
}

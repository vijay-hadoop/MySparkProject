import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import javax.security.auth.login.Configuration;
import java.util.Arrays;

public class JavaSpark1 {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setMaster("local").setAppName("JavaSpark1");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext spark = new SQLContext(sc);

        JavaRDD<String> textdata = sc.textFile("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\dept.txt");
        JavaPairRDD<String, Integer> counts = textdata
                .flatMap(s -> Arrays.asList(s.split(",")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);

//        counts.saveAsTextFile("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\javaspark_dept");

        for (Tuple2 word:counts.collect()) {
            System.out.println(word);
        }

    }
}

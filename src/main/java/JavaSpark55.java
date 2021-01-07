import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;

import java.util.List;

public class JavaSpark55 {

    public static void main(String[] args) {

//        SparkSession javasparkSession = SparkSession.builder().appName("JavaSpark2").master("local").getOrCreate();

        SparkConf sparkConf = new SparkConf().setAppName("Read Text to RDD").setMaster("local[2]");

        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        String path = "C:\\Spark\\emp.csv";

//        RDD<String> lines_1 = javasparkSession.sparkContext().textFile(path,1);
//        JavaRDD<Integer> n_words_1 = lines_1.map(x -> x.split(" ").length);

        JavaRDD<String> lines = sc.textFile(path);

        JavaRDD<String[]> n_words = lines.map(x -> x.split(","));

//        for(int n:n_words){
//            System.out.println(n);
//        }

//        https://www.tutorialkart.com/apache-spark/spark-rdd-map-java-python-examples/

//        JavaRDD<List<String>> df_customized = javasparkSession.sparkContext()
//                .textFile(path,1)
//                .map(new Function <String, ArrayList<String>>() {
//            @Override
//            public ArrayList<String> call(String s) {
//                return (ArrayList<String>) Arrays.asList(s.split(","));
//            }
//        });

//        JavaRDD<String> words = javasparkSession.sparkContext()
//                .textFile(path,1)
//                .flatMap(
//                new FlatMapFunction<String, String>() { public Iterator<String> call(String s) {
//                    return (Iterator<String>) Arrays.asList(s.split("\\s*,\\s*"));
//                }});

//        javasparkSession.sparkContext().textFile(path,1).map(x -> x.split(","));
    }
}

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class JavaSpark22 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("JavaSpark2").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        List<Integer> lst_data = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> distData = sc.parallelize(lst_data);

//        distData.collect();

        for(Integer item:distData.collect()){
            System.out.println(item);
        }

    }
}

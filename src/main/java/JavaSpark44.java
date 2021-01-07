import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.List;

public class JavaSpark44 {

    public static void main(String[] args) {


        SparkSession sess_obj = SparkSession.builder().master("local").appName("JavaSpark44").getOrCreate();

        List<String> lst = Arrays.asList("one", "two", "three", "four", "five");
        Dataset<Row> df = sess_obj.createDataset(lst, Encoders.STRING()).toDF();
        df.show();





    }
}

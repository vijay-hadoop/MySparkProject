import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaSpark11 implements Serializable {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder().appName("JavaSpark1").master("local").getOrCreate();

        ArrayList<Row> arr = new ArrayList<Row>();
        arr.add(RowFactory.create("Vijay"));
        arr.add(RowFactory.create("Raji"));
        arr.add(RowFactory.create("Bhavya"));
        arr.add(RowFactory.create("Aadhya"));

        StructType schema = DataTypes.createStructType(new StructField[] {DataTypes.createStructField("name",DataTypes.StringType,true)});

        Dataset<Row> df = spark.createDataFrame(arr,schema);
        df.show();

        Dataset<Row> data = spark.read().csv("C://spark/emp.csv");
        data.show();



    }
}

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import scala.collection.Seq;


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class JavaSpark5 {
    public static void main(String[] args) {

//        SparkConf conf = new SparkConf().setAppName("JavaSpark2").setMaster("local");
//        JavaSparkContext sc = new JavaSparkContext(conf);

        SparkSession spark = SparkSession.builder().appName("JavaSpark5").master("local").getOrCreate();

        JavaSparkContext sparkContext = new JavaSparkContext(spark.sparkContext());

//        ArrayList<StructField> col = new ArrayList<StructField>();
//
//        col.add(DataTypes.createStructField("name",DataTypes.StringType,true));
//        col.add(DataTypes.createStructField("age",DataTypes.StringType,true));
//
//        StructType schema = DataTypes.createStructType(col);

        List<String[]> stringAsList = new ArrayList<String[]>();

        stringAsList.add( new String[] {"Vijay","30"});
        stringAsList.add( new String[] {"Bhavya","4"});

        JavaRDD<Row> rowRDD = sparkContext.parallelize(stringAsList).map((String[] row) -> RowFactory.create(row));

        // Creates schema
        StructType schema = DataTypes
                .createStructType(new StructField[]
                        { DataTypes.createStructField("foe1", DataTypes.StringType, false),
                        DataTypes.createStructField("foe2", DataTypes.StringType, false) });

        Dataset<Row> df = spark.sqlContext().createDataFrame(rowRDD, schema).toDF();

        df.show();



    }
}

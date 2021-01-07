import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.sql.types.StructField;

import java.util.ArrayList;
import java.util.List;


public class JavaSpark3 {
    public static void main(String[] args) {
        SparkSession javasparksession = SparkSession.builder().appName("JavaSpark3").master("local").getOrCreate();


        String path= "C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\k_means_data.txt";
        JavaRDD<Row> data = javasparksession.sparkContext().textFile(path,1).toJavaRDD()
                .map((Function<String, Row>) record -> {
            String[] attributes = record.split(" ");
            return RowFactory.create(attributes[0], attributes[1], attributes[2]);
        });

        List<StructField> column_list = new ArrayList<StructField>();

        column_list.add(DataTypes.createStructField("col1",DataTypes.StringType,true));
        column_list.add(DataTypes.createStructField("col2",DataTypes.StringType,true));
        column_list.add(DataTypes.createStructField("col3",DataTypes.StringType,true));

        StructType empschema = DataTypes.createStructType(column_list);

        Dataset<Row> empDF = javasparksession.createDataFrame(data,empschema);
        empDF.show();

        Dataset<Row> df = javasparksession.read().text(path).toDF();
        df.show();


//        System.out.println(data.getClass());

//        for (Row line:data.collect()) {
//            System.out.println(line);
//        }

    }
}

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.spark.api.java.function.Function;

import static org.apache.spark.sql.functions.max;

public class JavaSpark2 {
    public static void main(String[] args) {
//        SparkConf conf = new SparkConf().setAppName("JavaSpark2").setMaster("local");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//        SQLContext spark = new SQLContext(sc);

        SparkSession javasparkSession = SparkSession.builder().appName("JavaSpark2").master("local").getOrCreate();

        String empstr="empno ename job mgr hiredate sal comm deptno";

        List<StructField> column_list = new ArrayList<StructField>();
        for (String column:empstr.split(" ")){
            column_list.add(DataTypes.createStructField(column,DataTypes.StringType,true));
        }

        StructType empschema = DataTypes.createStructType(column_list);


        String path = "C:\\Spark\\emp.csv";

        JavaRDD<String> lines = javasparkSession.sparkContext().textFile(path,1).toJavaRDD();

        JavaRDD<Row> rowRDD = lines.map((Function<String, Row>) record -> {
            String[] attributes = record.split(",");
            return RowFactory.create(attributes[0], attributes[1],attributes[2],attributes[3],attributes[4], attributes[5],attributes[6],attributes[7]);
        });


//        printing lines from rdd collect
//        for (String line:lines.collect()) {
//            System.out.println(line);
//        }

//        printing schema
//        System.out.println(empschema);

        Dataset<Row> df = javasparkSession.createDataFrame(rowRDD,empschema);
//        df.show();

//

        Dataset<Row> df1 = javasparkSession.sqlContext().createDataFrame(rowRDD,empschema).toDF("empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno");
//        df1.show();

        Dataset<Row> df2 = javasparkSession.read().format("csv").load(path).toDF("empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno");
//        df2.show();

        Dataset<Row> df3 = javasparkSession.read().csv(path).toDF();
        df3.show();

        Dataset<Row> grpdf= df.groupBy("deptno").count();
        grpdf.show();
        Dataset<Row> likedf= df.where("length(ename)=4 and ename like '__R%'");
        likedf.show();
        Dataset<Row> maxsal = df.groupBy("deptno").count();
        maxsal.show();

    }
}

//import java.awt.List;
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.function.Function;


        import org.apache.commons.math3.geometry.spherical.oned.ArcsSet.Split;
        import org.apache.spark.api.java.function.Function;
        import org.apache.spark.api.java.function.MapFunction;
        import org.apache.spark.sql.*;

        import com.univocity.parsers.common.record.Record;

        import java.sql.Array;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;

public class JavaSpark33 {

    public static void main(String[] args) throws AnalysisException {

        SparkSession session_obj1 = SparkSession.builder().appName("javaspark_prac1").master("local").getOrCreate();

		Dataset<Row> obj1=session_obj1.read().csv("C://spark/emp.csv");
//        Dataset<String> obj1=session_obj1.read().textFile("C://spark/emp.csv");

//		ArrayList<String> array = new ArrayList<>();

		obj1.show();



//        for(Iterator<Row> iter = obj1.toLocalIterator(); iter.hasNext();) {
//            String item = (iter.next()).toString();
//            System.out.println(item.toString());
//        }

        ArrayList<Row> lst= new ArrayList<>();

        for(Iterator<Row> iter = obj1.toLocalIterator(); iter.hasNext();) {
            lst.add(iter.next());
        }
        System.out.println(lst);

        for(Row rec:lst) {
//            String[] header = lst.get(0).toString().split("    ");
            String[] header = rec.toString().split(",");
            for (String attr : header) {
                System.out.println(attr);
            }
        }
        System.out.println("==============================");



//        obj1.createTempView("emp");
//
//        Dataset<Row> obj2=session_obj1.sql("Select empid from emp");
//        obj2.show();

//        List<String> lst = obj2.map(row -> row.mkString(), Encoders.STRING()).collectAsList();




//        https://stackoverflow.com/questions/42389203/how-to-convert-the-datasets-of-spark-row-into-string
//        java.util.List<String> lst=obj2.as(Encoders.STRING()).collectAsList();
//
//        System.out.println(lst);
//        System.out.println(lst.get(0));


    }

}


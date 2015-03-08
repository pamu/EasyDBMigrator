import java.util.Iterator;

/**
 * Created by android on 3/3/15.
 */
public class JMain {
    public static void main(String[] args) {
        System.out.println("Easy Database Migrator");
        Conversions conversions = new Conversions();
        OracleResultSet resultSet = new OracleResultSet();
        Iterator iterator = resultSet.set.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            obj.getClass
            put(conversions.covert(obj)); //put method belogs to different database (mySQL datatype)
        }
    }
}

/**
 * Created by android on 3/3/15.
 */
public class Conversions {
    public MySQLInt convert(OracleInt oInt) {
        return new MySQLInt(oInt.i);
    }
}

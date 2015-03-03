import java.util.HashSet;
import java.util.Set;

/**
 * Created by android on 3/3/15.
 */
public class OracleResultSet {
    public final Set<OracleInt> set;
    
    public OracleResultSet() {
        set = new HashSet<OracleInt>();
        set.add(new OracleInt(1));
    }
}

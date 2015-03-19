import java.sql.{Timestamp, PreparedStatement}

/**
 * Created by android on 19/3/15.
 */
object Implicits {
  implicit class PutUtils(preparedStmt: PreparedStatement) {
    def put(timestamp: Timestamp): String = timestamp.toString
    def put(str: String): String = str
  }
}

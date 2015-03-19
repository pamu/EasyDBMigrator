import java.sql.{PreparedStatement, Timestamp}

/**
 * Created by android on 19/3/15.
 */
object Utils {
  def real(anyRef: AnyRef, preparedStatement: PreparedStatement): Unit = anyRef match {
    case x: String =>
    case x: Timestamp => x
    case _ => throw new Exception("donno how to deal with this type")
  }
}

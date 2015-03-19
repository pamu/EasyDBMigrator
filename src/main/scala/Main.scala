import java.sql.{DriverManager, Statement, Connection}

/**
 * Created by android on 19/3/15.
 */
object Main {
  def main(args: Array[String]): Unit = {
    var connection: Connection = null
    var statement: Statement = null
    try {
      connection = DriverManager.getConnection(Constants.dbURL, Constants.user, Constants.pass)

    }
    catch {
      case ex: Exception =>
        println(ex.getMessage)
    }

  }
}

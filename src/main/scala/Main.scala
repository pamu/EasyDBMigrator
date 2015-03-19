import java.sql.{DriverManager, Statement, Connection}

import scala.slick.jdbc.meta.MTable
import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by android on 19/3/15.
 */
object Main {
  def main(args: Array[String]): Unit = {

    DAO.db.withSession(implicit sx => {
      if(MTable.getTables("users").list.isEmpty) {
        DAO.users.ddl.create
      }
    })

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

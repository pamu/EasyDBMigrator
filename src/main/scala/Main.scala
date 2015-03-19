import java.sql._
import java.util.Date

import scala.slick.jdbc.meta.MTable
import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by android on 19/3/15.
 */
object Main {
  def main(args: Array[String]): Unit = {

    import DAO._
    db.withSession(implicit sx => {

      if(MTable.getTables("users").list.isEmpty) {
        users.ddl.create
        val q = for(user <- users) yield user
        if(q.countDistinct.run < 100) {
          for(no <- 1 to 100) {
            users += User(s"Jack Sparrow$no", s"jack$no@gmail.com",
              s"$no Am Caption Jack Sparrow, Savvy", new Timestamp(new Date().getTime))
          }
        }
      }

      if(MTable.getTables("dusers").list.isEmpty) {
        dusers.ddl.create
      }

    })

    var connection: Connection = null
    var stmt: Statement = null

    try {
      connection = DriverManager.getConnection(Constants.dbURL, Constants.user, Constants.pass)
      stmt = connection.createStatement()
      val query = "select * from users"
      val rs: ResultSet = stmt.executeQuery(query)
      while(rs.next()) {
        for(columnNo <- 0 until rs.getMetaData.getColumnCount) {
          println(rs.getObject(columnNo).getClass)
        }
      }
    }
    catch {
      case ex: Exception =>
        println(ex.getMessage)
    }

  }
}

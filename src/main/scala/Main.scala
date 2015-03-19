import java.sql._
import java.util.Date

import scala.slick.jdbc.meta.MTable
import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by android on 19/3/15.
 */
object Main {
  def main(args: scala.Array[String]): Unit = {

    import DAO._
    db.withSession(implicit sx => {

      if(MTable.getTables("users").list.isEmpty) {
        users.ddl.create
        for(no <- 1 to 100) {
          users += User(s"Jack Sparrow$no", s"jack$no@gmail.com",
            s"$no Am Caption Jack Sparrow, Savvy", new Timestamp(new Date().getTime))
        }
      }

      if(MTable.getTables("dusers").list.isEmpty) {
        dusers.ddl.create
      }

    })

    var connection: Connection = null
    var stmt: Statement = null
    var preparedStmt: PreparedStatement = null

    try {
      connection = DriverManager.getConnection(Constants.dbURL, Constants.user, Constants.pass)

      println("connection successful")

      stmt = connection.createStatement()


      val query = "select * from users"

      val insertQuery = "insert into dusers values(?, ?, ?, ?, ?)"

      val rs: ResultSet = stmt.executeQuery(query)

      preparedStmt = connection.prepareStatement(insertQuery);

      while(rs.next()) {
        println("transfering")
        for(columnNo <- 1 to rs.getMetaData.getColumnCount) {

          val columnValue = rs.getObject(columnNo)


        }
      }
    }
    catch {
      case ex: Exception =>
        println(ex.printStackTrace)
    }

  }
}

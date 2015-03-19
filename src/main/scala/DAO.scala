import java.sql.Timestamp

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by android on 19/3/15.
 */
object DAO {

  lazy val db = Database.forURL(
    url = Constants.dbURL,
    driver = Constants.jdbcDriver,
    user = Constants.user,
    password = Constants.pass)

  case class User(name: String, email: String, message: String, timestamp: Timestamp, id: Option[Long] = None)

  class Users(tag: Tag) extends Table[User](tag, "users") {
    def name = column[String]("name", O.NotNull)
    def email = column[String]("email", O.NotNull)
    def timestamp = column[Timestamp]("timestamp", O.NotNull)
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def * = (name, email, id.?) <> (User.tupled, User.unapply)
  }

  case class DUser(name: String, email: String, timestamp: String, id: Option[Long] = None)

  class DUsers(tag: Tag) extends Table[DUser](tag, "dusers") {
    def name = column[String]("name", O.NotNull)
    def email = column[String]("email", O.NotNull)
    def timestamp = column[String]("timestamp", O.NotNull)
    def id = column[Long]("id", O.PrimaryKey, O.NotNull)
    def * = (name, email, timestamp, id.?) <> (DUser.tupled, DUser.unapply)
  }

  lazy val users = TableQuery[Users]
  lazy val dusers = TableQuery[DUsers]

}

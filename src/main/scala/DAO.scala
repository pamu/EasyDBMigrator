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

  case class User(name: String, email: String, message: String, id: Option[Long] = None)

  case class Users(tag: Tag) extends Table[User](tag, "users") {
    def name = column[String]("name", O.NotNull)
    def email = column[String]("email", O.NotNull)
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def * = (name, email, id.?) <> (User.tupled, User.unapply)
  }

  val users = TableQuery[Users]
}

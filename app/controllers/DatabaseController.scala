package controllers

//import dao.SomeData
import play.api.db.slick.{DatabaseConfigProvider, DbName, HasDatabaseConfigProvider, SlickComponents}
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import slick.model.Table
import slick.relational.RelationalProfile

import scala.concurrent.ExecutionContext.Implicits.global
import slick.ast.ScalaBaseType._
import slick.dbio.DBIO
import slick.jdbc.JdbcProfile
import slick.lifted.TableQuery

import javax.inject.Inject
import scala.concurrent.ExecutionContext



class DatabaseController @Inject()(sc: SlickComponents, cc: ControllerComponents, protected val dbConfigProvider: DatabaseConfigProvider)
                                  (implicit ec: ExecutionContext)
  extends AbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile] {

  def doSomethingWithTheDb = Action { implicit request: Request[AnyContent] =>


    // works both
    val db2 = sc.slickApi.dbConfig(DbName("default")).db
    val db = dbConfigProvider.get[RelationalProfile].db
    // TODO: read the play-slick documentation see how far they get,
    //   probably they don't show the dao stuff, because they want
    //   codegen to be set up. So maybe you should set up codegen
    //   first.
    //val datas = TableQuery[SomeData]


    Ok("""{"message"="arbeitet"}""")
  }
}

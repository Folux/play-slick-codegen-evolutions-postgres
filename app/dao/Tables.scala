package dao

import slick.ast.ScalaBaseType._
import slick.jdbc.PostgresProfile._
import slick.lifted.{Tag}


// Definition of the some_data table
class SomeData(tag: Tag) extends Table[(Int, String)](tag, "some_data") {
  def idSomeData = column[Int]("id_some_data", O.PrimaryKey) // This is the primary key column
  def data = column[String]("data")
  // Every table needs a * projection with the same type as the table's type parameter
  def * = (idSomeData, data)
}
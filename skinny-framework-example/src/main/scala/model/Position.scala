package model

import skinny.orm._, feature._
import scalikejdbc._
import org.joda.time._

case class Position(
  id: Long,
  name: String,
  createdAt: DateTime,
  updatedAt: DateTime)

object Position extends SkinnyCRUDMapper[Position] with TimestampsFeature[Position] {
  override lazy val tableName = "positions"
  override lazy val defaultAlias = createAlias("p")
  override def extract(rs: WrappedResultSet, rn: ResultName[Position]): Position = autoConstruct(rs, rn)
}
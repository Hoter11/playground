package model

import skinny.orm._
import feature._
import scalikejdbc._
import org.joda.time._

case class Member(
  id: Long,
  name: String,
  nickname: String,
  birthday: Option[LocalDate] = None,
  companyId: Option[Long] = None,
  company: Option[Company] = None,
  positionId: Option[Long] = None,
  position: Option[Position] = None,
  createdAt: DateTime,
  updatedAt: DateTime)

object Member extends SkinnyCRUDMapper[Member] with TimestampsFeature[Member] {
  override lazy val tableName = "members"
  override lazy val defaultAlias = createAlias("m")
  override def extract(rs: WrappedResultSet, rn: ResultName[Member]): Member =
    autoConstruct(rs, rn, "company", "position")

  belongsTo[Company](
    Company, (member, company) => member.copy(company = company)).byDefault

  belongsTo[Position](
    Position, (member, position) => member.copy(position = position)).byDefault
}

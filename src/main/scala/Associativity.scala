/**
  * Created by mtumilowicz on 2018-12-27.
  */
class Associativity {

  def productTransformation[X, Y, Z](abc: ((X, Y), Z)): (X, (Y, Z)) = (abc._1._1, (abc._1._2, abc._2))

  def productTransformation_inv[X, Y, Z](abc: (X, (Y, Z))): ((X, Y), Z) = ((abc._1, abc._2._1), abc._2._2)

  def coproductTransformation[X, Y, Z](either: Either[Either[X, Y], Z]): Either[X, Either[Y, Z]] = either match {
    case Left(inner) => inner match {
      case Left(x) => Left(x)
      case Right(y) => Right(Left(y))
    }
    case Right(z) => Right(Right(z))
  }

  def coproductTransformation_inv[X, Y, Z](either: Either[X, Either[Y, Z]]): Either[Either[X, Y], Z] = either match {
    case Left(x) => Left(Left(x))
    case Right(inner) => inner match {
      case Left(y) => Left(Right(y))
      case Right(z) => Right(z)
    }
  }
}

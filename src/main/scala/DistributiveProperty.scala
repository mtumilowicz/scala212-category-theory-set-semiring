/**
  * Created by mtumilowicz on 2018-12-27.
  */
class DistributiveProperty {
  def prodToSum[X, Y, Z](prod: (X, Either[Y, Z])): Either[(X, Y), (X, Z)] = prod match {
    case (a, Left(inner)) => Left((a, inner))
    case (a, Right(inner)) => Right(a, inner)
  }

  def sumToProd[X, Y, Z](sum: Either[(X, Y), (X, Z)]): (X, Either[Y, Z]) = sum match {
    case Left((a, b)) => (a, Left(b))
    case Right((a, b)) => (a, Right(b))
  }
}

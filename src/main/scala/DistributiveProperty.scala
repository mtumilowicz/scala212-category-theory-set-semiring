/**
  * Created by mtumilowicz on 2018-12-27.
  */
class DistributiveProperty {
  def prodToSum[X, Y, Z](prod: (X, Either[Y, Z])): Either[(X, Y), (X, Z)] = prod match {
    case (x, Left(y)) => Left((x, y))
    case (a, Right(z)) => Right(a, z)
  }

  def sumToProd[X, Y, Z](sum: Either[(X, Y), (X, Z)]): (X, Either[Y, Z]) = sum match {
    case Left((x, y)) => (x, Left(y))
    case Right((x, z)) => (x, Right(z))
  }
}

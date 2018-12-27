import org.scalatest.FunSuite

/**
  * Created by mtumilowicz on 2018-12-27.
  */
class DistributivePropertyTest extends FunSuite {

  def distributive = new DistributiveProperty
  
  test("testSumToProd") {
    assert(distributive.sumToProd(Left((1, "String"))) == (1, Left("String")))
    assert(distributive.sumToProd(Right((1, "String"))) == (1, Right("String")))
  }

  test("testProdToSum") {
    assert(distributive.prodToSum((1, Left("String"))) == Left(1, "String"))
    assert(distributive.prodToSum((1, Right("String"))) == Right(1, "String"))
  }

}

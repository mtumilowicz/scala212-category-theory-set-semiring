import org.scalatest._

/**
  * Created by mtumilowicz on 2018-12-27.
  */
class DistributivePropertyTest extends FunSuite with Matchers {

  def distributive = new DistributiveProperty
  
  test("testSumToProd") {
    distributive.sumToProd(Left((1, "String"))) should be (1, Left("String"))
    distributive.sumToProd(Right((1, "String"))) should be (1, Right("String"))
  }

  test("testProdToSum") {
    distributive.prodToSum((1, Left("String"))) should be (Left(1, "String"))
    distributive.prodToSum((1, Right("String"))) should be (Right(1, "String"))
  }

}

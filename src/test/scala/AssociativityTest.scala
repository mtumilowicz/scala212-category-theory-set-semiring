import org.scalatest._

/**
  * Created by mtumilowicz on 2018-12-27.
  */
class AssociativityTest extends FunSuite with Matchers {

  def associativity = new Associativity

  test("testProductTransformation") {
    associativity.productTransformation(((1, "String"), 'c')) should be (1, ("String", 'c'))
  }

  test("testProductTransformation_inv") {
    associativity.productTransformation_inv((1, ("String", 'c'))) should be ((1, "String"), 'c')
  }

  test("testCoproductTransformation") {
    associativity.coproductTransformation(Left(Left(1))) should be (Left(1))
    associativity.coproductTransformation(Left(Right(1))) should be (Right(Left(1)))
    associativity.coproductTransformation(Right(1)) should be (Right(Right(1)))
  }

  test("testCoproductTransformation_inv") {
    associativity.coproductTransformation_inv(Left(1)) should be (Left(Left(1)))
    associativity.coproductTransformation_inv(Right(Left(1))) should be (Left(Right(1)))
    associativity.coproductTransformation_inv(Right(Right(1))) should be (Right(1))
  }

}

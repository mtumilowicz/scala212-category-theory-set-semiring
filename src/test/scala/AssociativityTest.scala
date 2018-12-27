import org.scalatest.FunSuite

/**
  * Created by mtumilowicz on 2018-12-27.
  */
class AssociativityTest extends FunSuite {

  def associativity = new Associativity

  test("testProductTransformation") {
    assert(associativity.productTransformation((1, "String"), 'c') == (1, ("String", 'c')))
  }

  test("testProductTransformation_inv") {
    assert(associativity.productTransformation_inv((1, ("String", 'c'))) == ((1, "String"), 'c'))
  }

  test("testCoproductTransformation") {
    assert(associativity.coproductTransformation(Left(Left(1))) == Left(1))
    assert(associativity.coproductTransformation(Left(Right(1))) == Right(Left(1)))
    assert(associativity.coproductTransformation(Right(1)) == Right(Right(1)))
  }

  test("testCoproductTransformation_inv") {
    assert(associativity.coproductTransformation_inv(Left(1)) == Left(Left(1)))
    assert(associativity.coproductTransformation_inv(Right(Left(1))) == Left(Right(1)))
    assert(associativity.coproductTransformation_inv(Right(Right(1))) == Right(1))
  }

}

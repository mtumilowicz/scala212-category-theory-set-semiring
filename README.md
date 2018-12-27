[![Build Status](https://travis-ci.com/mtumilowicz/scala212-category-theory-set-semiring.svg?branch=master)](https://travis-ci.com/mtumilowicz/scala212-category-theory-set-semiring)

# scala212-category-theory-set-semiring
_Reference_: https://bartoszmilewski.com/2015/01/13/simple-algebraic-data-types/  
_Reference_: https://github.com/mtumilowicz/java11-category-theory-set-coproduct  
_Reference_: https://github.com/mtumilowicz/java11-category-theory-set-product

# preface
_Reference_: https://en.wikipedia.org/wiki/Semiring

A **semiring** is a set `R` equipped with two binary 
operations `+` and `*`, called addition and multiplication, 
such that:
* `(R, +)` is a commutative monoid with identity element 0:
    * `(a + b) + c = a + (b + c)`
    * `0 + a = a + 0 = a`
    * `a + b = b + a`
* `(R, *)` is a monoid with identity element 1:
    * `(a * b) * c = a * (b * c)`
    * `1 * a = a * 1 = a`
* Multiplication left and right distributes over addition:
    * `a * (b + c) = (a * b) + (a * c)`
    * `(a + b) * c = (a * c) + (b * c)`
* Multiplication by 0 annihilates R:
    * `0 * a = a * 0 = 0`

# Set category is semiring with product and coproduct
* product as multiplication: `a * b := (a, b)`
    * we have isomorphism between `((a, b), c)` and `(a, (b, c))`
        ```
        alpha :: ((a, b), c) -> (a, (b, c))
        alpha ((x, y), z) = (x, (y, z))
        
        alpha_inv :: (a, (b, c)) -> ((a, b), c)
        alpha_inv  (x, (y, z)) = ((x, y), z)
        ```
    * identity element (`1`) is singleton `()` - 
    pairing element with singleton does not carry additional
    information than element itself
        ```
        rho :: (a, ()) -> a
        rho (x, ()) = x
        
        rho_inv :: a -> (a, ())
        rho_inv x = (x, ())
        ```
    * we have isomorphism between `(a, b)` and `(b, a)`
        ```
        swap :: (a, b) -> (b, a)
        swap (x, y) = (y, x)
        ```
* coproduct as addition: `a + b := Either(a, b)`
    * same methodology like with product
    * identity element (`0`) is `Void` (the uninhabited type - 
    empty set)
        * `Either a Void` is isomorphic to `a` - there is no way 
        of constructing `Right`

# project description
* `Associativity`
    ```
    def productTransformation[X, Y, Z](abc: ((X, Y), Z)): (X, (Y, Z)) = {
      val ((a, b), c) = abc
      
      (a, (b, c))
    }
    
    def productTransformation_inv[X, Y, Z](abc: (X, (Y, Z))): ((X, Y), Z) = {
      val (a, (b, c)) = abc
      
      ((a, b), c)
    }
    
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
    ```
* `DistributiveProperty`
    ```
    def prodToSum[X, Y, Z](prod: (X, Either[Y, Z])): Either[(X, Y), (X, Z)] = prod match {
      case (x, Left(y)) => Left((x, y))
      case (a, Right(z)) => Right(a, z)
    }
    
    def sumToProd[X, Y, Z](sum: Either[(X, Y), (X, Z)]): (X, Either[Y, Z]) = sum match {
      case Left((x, y)) => (x, Left(y))
      case Right((x, z)) => (x, Right(z))
    }
    ```
* tests: `AssociativityTest`, `DistributivePropertyTest`
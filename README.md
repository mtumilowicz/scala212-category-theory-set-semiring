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
* product as multiplication
    * we have isomorphism between `((a, b), c)` and `(a, (b, c))`
        ```
        alpha :: ((a, b), c) -> (a, (b, c))
        alpha ((x, y), z) = (x, (y, z))
        
        alpha_inv :: (a, (b, c)) -> ((a, b), c)
        alpha_inv  (x, (y, z)) = ((x, y), z)
        ```
    * identity element (`1`) is singleton `()` - 
    pairing element with singleton does not carry additional
    information than element
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
* coproduct as addition


# project description
# hmrc-shoppingcart

Ive spent over the 40min so I will stop here.

From this point Id begin to think about refactoring the code, without thinking 
too far ahead, my line of thought would be to create an Offer Interface and 
have implementations of these. 
These Offer implementations could be canned in some sort of CurrentOffers Object
which would make up part of the Checkout class. Tests would be moved in the 
appropriate areas.

Also Id prefer the Shopping Items to have their own class which would include the 
description and price.

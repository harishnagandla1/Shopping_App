Feature: Shopping Cart Experience
   In order to manage items intended for purchase
   As a user
   I want an intuitive shopping cart experience with confirmation cues

Background:
   Given the user is browsing products

Scenario: Seamless Add to Cart Experience
   When the user adds a product to their cart from the product listing or detail page
   Then a confirmation message or visual cue should indicate the item has been added to the cart

Scenario: Accessible and Manageable Shopping Cart
   Given the user has items in their cart
   When the user accesses their cart from any page
   Then they should be able to view item summaries
   And change item quantities or remove items with immediate subtotal updates
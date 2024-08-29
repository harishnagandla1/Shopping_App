Feature: Secure User Login
  In order to access personalized features and order history
  As a user
  I want to securely log in using my username and password through the authentication page

Background:
  Given the user is directed to the login page at "https://www.saucedemo.com/"

Scenario: Successful Login
  When the user enters valid username and password
  And the user clicks on the login button
  Then the user should be logged in successfully
  And redirected to the inventory page

Scenario Outline: Unsuccessful Login Attempts
  When the user enters username "<username>" and password "<password>"
  And the user clicks on the login button
  Then the user should receive an error message "<error_message>"
  But the user should not be redirected to the inventory page

Examples:
  | username    | password     | error_message                  |
  | wronguser   | password123  | "Invalid username or password" |
  | user123     | wrongpassword| "Invalid username or password" |
  | ""          | password123  | "Username is required"         |
  | user123     | ""           | "Password is required"         |

Scenario: Secure Logout
  Given the user is logged in and on any page
  When the user clicks on the logout button
  Then the user should be logged out successfully
  And redirected to the login page

Feature: Product Browsing and Filtering
  In order to easily browse and find products
  As a user
  I want to view all available products on a single page with options to filter and sort

Background:
  Given the user is logged in and on the inventory page "https://www.saucedemo.com/inventory.html"

Scenario: View All Products
  When the user scrolls through the inventory page
  Then all available products should be displayed

Scenario: Filter Products by Category
  When the user selects a category filter option "electronics"
  Then only products related to "electronics" should be displayed

Scenario: Sort Products by Price
  When the user selects the sort option "price"
  Then the products should be sorted by price in ascending order

Feature: Product Details and Interaction
  In order to make well-informed purchase decisions
  As a user
  I want to access detailed product information and interact directly on the product page

Background:
  Given the user is logged in and viewing a product on "https://www.saucedemo.com/inventory-item.html"

Scenario: View Product Details
  When the user reviews the product page
  Then multiple high-resolution images, detailed description, price, availability status, and user reviews with ratings should be displayed

Scenario: Ask Questions About the Product
  When the user submits a question about the product
  Then the question should be posted for customer service or other users to answer

Feature: Shopping Cart Management
  In order to manage my potential purchases
  As a user
  I want to easily add products to my shopping cart, view a summary, and adjust quantities or remove items

Background:
  Given the user is logged in and browsing products

Scenario: Add Product to Shopping Cart
  When the user clicks the add to cart button for a product
  Then the product should be added to the shopping cart
  And a confirmation should be displayed

Scenario: Access Shopping Cart Summary
  When the user clicks on the shopping cart icon
  Then the user should be redirected to the cart page
  And see a summary of items in the cart

Scenario: Adjust Quantity in Shopping Cart
  When the user increases the quantity of a product in the cart
  Then the subtotal should be updated accordingly

Scenario: Remove Item from Shopping Cart
  When the user removes a product from the cart
  Then the item should be removed immediately
  And the subtotal should be updated

# Note: Due to the extensive list of user stories, this response includes a selection of scenarios to demonstrate how to structure Gherkin feature files for a variety of functionalities. Additional features and scenarios could be similarly structured based on the remaining user stories.
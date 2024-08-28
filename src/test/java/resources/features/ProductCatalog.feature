Feature: Product Catalog Browsing and Management
   In order to facilitate easy browsing of products
   As a user
   I want to view, filter, and sort products on a single page

Background:
   Given the user is logged in and on the "https://www.saucedemo.com/inventory.html" page

Scenario: Browse All Products
   When the user chooses to view all products
   Then all available products should be listed with their name, image, and price
   And the user should have the option to load more items

Scenario Outline: Filter and Sort Products
   When the user selects the filter category "<category>"
   And chooses the sorting criteria "<criteria>"
   Then the product list should update to show only products from the "<category>" category
   And the products should be sorted according to "<criteria>"

Examples:
   | category    | criteria   |
   | electronics | price      |
   | apparel     | popularity |
   | accessories | name       |
Feature: Detailed Product Information and Interactions
   In order to make informed purchase decisions
   As a user
   I want comprehensive product pages that allow for interaction

Background:
   Given the user is on a product page "https://www.saucedemo.com/inventory-item.html"

Scenario: Product Page Details
   When the user views a product page
   Then the page should include multiple images, a detailed description, price, availability, and user reviews with ratings

Scenario: Ask Questions on Product Pages
   When the user enters a question in the "Ask a Question" section
   And submits the question
   Then the question should be viewable by other users
   And customer service can respond to the question
Feature: Verify SHEIN application
#  Background:
#    Given Open SHEIN application


  @TC_01
  Scenario: Verify Product Detail
    Given Open Banggood Easy Online Shopping App
    When Change Currency to USD
    When CLick to the Category on footer menu
    And Scroll and click to Home and Garden in Left menu
    Then the right category displayed, click to the Home Decor Sticker
    When Click to the Filter and input price form "20" to "30"
    And Click Done
    And Click first product
    Then Verify product name should be displayed and product price in range "20" to "30"

  @TC_02
  Scenario: Verify Product Detail
    Given Open Banggood Easy Online Shopping App
    When Scoll to HOt Categories
    And Click to first category
    And Click to the first product
    Then The product detail page should be displayed:
      |ProductName          |  Yes  |
      |ProductPrice         |  Yes  |
      |BuyNowBtn            |  Yes  |
      |AddToCartBtn         |  Yes  |
    When Click Add to cart
    And Click to Add to Cart butotn
    And Click to Cart icon on footer
    Then Verify display
      |ProductName          |  Yes  |
      |ProductSize          |  Yes  |
      |ProductPrice         |  Yes  |
      |ProductQuantity      |  Yes  |

  @TC_03
  Scenario: Verify Product Detail
    Given Open Banggood Easy Online Shopping App
    When CLick Account on footer menu
    And Click View All Order
    Then Verify th login creen should be displayed with:
      |Email          |  Yes  |
      |Password       |  Yes  |
      |SignInBtn      |  Yes  |




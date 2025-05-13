Simple Selenium Automation framework to test the following flow:

1. Open Airalo's Website,Launch a browser and navigate to Airalo's website.
2. Search for Japan,"In the search field, type 'Japan' and select 'Japan' under the 'Local' section."
3. Select an eSIM Package,Choose the first eSIM package and click 'Buy Now'.
4. Verify Package Details,"In the popup, check: Title: Moshi Moshi, Coverage: Japan, Data: 1 GB, Validity: 7 days, Price: $4.50"

How to Run:
Clone the repo
Run using `mvn test` or right-click the test class in your IDE.

Approach
- I'm using Page Object Model (POM) to separate pages logic and elements from test cases and data
- I have added explicit wait before clicking the `Local Japan` option, to make sure it's displayed
- Similarly I have added an explicit wait to ensure at least one `Buy Now` button is visible.
- Return package details as a Map for cleaner assertions.

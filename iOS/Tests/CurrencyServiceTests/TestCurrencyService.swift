import XCTest
import Foundation

@testable import CurrencyService

class TestCurrencyService: XCTestCase {

  static var allTests: [(String, (TestCurrencyService) -> () throws -> Void)] {
      return [
          ("testGetCryptoCurrencyFromWebService", testGetCryptoCurrencyFromWebService)
      ]
  }

  var currencyService : CurrencyService!

  override func setUp() {
    super.setUp()
    currencyService = CurrencyService()
  }

  func testGetCryptoCurrencyFromWebService() {
    currencyService.getCurrencyData(cryptocurrency: "bitcoin")
    //XCTAssertEqual(luckyNumbers.count, shouldGenerateCountNumbers)
  }
}

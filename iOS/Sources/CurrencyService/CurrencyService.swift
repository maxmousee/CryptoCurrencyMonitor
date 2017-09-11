import Foundation

#if os(Linux)
import Glibc
#else
import Darwin.C
#endif

class CurrencyService {

    func getCurrencyURL(cryptocurrency: String) {
        let urlString = Constants.Defaults.baseURL + cryptocurrency
        return urlString
    }

    func getCurrencyData(cryptocurrency: String) {
        let urlString = getCurrencyURL
        guard let requestUrl = URL(string:urlString) else { return }
        let request = URLRequest(url:requestUrl)
        let task = URLSession.shared.dataTask(with: request) {
            (data, response, error) in
            if error == nil,let usableData = data {
                    print(usableData) //JSONSerialization
            }
        }
        task.resume()
    }
}


import Foundation

#if os(Linux)
import Glibc
#else
import Darwin.C
#endif

class CurrencyService {

func getCurrencyData() {

    let urlString = "http://jsonplaceholder.typicode.com/users/1"

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


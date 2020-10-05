//
//  Counter.swift
//  pacifySDK_rn
//
//  Created by Sean Zhang on 9/30/20.
//

import Foundation
import Kingfisher
import UIKit
import PacifySDK


@objc(PacifySDKModule)
class PacifySDKModule: NSObject {
  @objc
  func callPacify (_ args: NSDictionary, callback cb: RCTResponseSenderBlock) {
    
    print("Args");
    print(args);
    let apiKey:String = args["apiKey"] as? String ?? ""
    let userToken:String = args["userToken"] as? String ?? ""
    let coupon:String? = args["coupon"] as? String ?? nil
    
    print(apiKey)
    print(userToken)
     let userData = PacifyUserData(
         firstName: "Nick",
         lastName: "Bos", // optional, used for payment only
         email: "nick@matrix.com")
     
     let appearance = PacifyAppearance(
         backgroundColor: UIColor(red: 249.0 / 255, green: 249.0 / 255, blue: 249.0 / 255, alpha: 1),
         navigationBarTintColor: UIColor(red: 253.0 / 255, green: 217.0 / 255, blue: 123.0 / 255, alpha: 1),
         navigationBarTitleColor: UIColor.black.withAlphaComponent(0.8),
         buttonBackgroundColor: UIColor(red: 143.0 / 255, green: 98.0 / 255, blue: 146.0 / 255, alpha: 1),
         buttonTitleColor: UIColor.white,
         textColor: UIColor(red: 76.0 / 255, green: 0, blue: 82.0 / 255, alpha: 1),
         companyLogo: UIImage(named: "Logo"))
     
     let supportInfo = PacifySupportInfo(
         email: "support@company.com", //used on home screen as support email
         phone: "1234567890") // used on home screen as suppor email
     
     let settings = PacifySettings(
         appearance: appearance,
         environment: .testing,
         logLevel: .error,
         supportInfo: supportInfo,
         appTitle: "MyApp", //embedding application title, used in title of back button and in new user congratulation message
         language: .english_us,
         currency: .USD,
         signUpIntroConfig: PacifySignupIntroConfiguration(serviceDescription: "Talk to providers via video call. Access is unlimited, on-demand, and 24/7."),
         mainScreenConfig: PacifyMainScreenConfiguration(callButtonsTitleLabelText: "Who would you like to contact?", isDisplayVideoIcon: false), // optional
         audioOutput: .speaker // optional, available values: .default, .speaker
     )
       
    print("calling pacify from main thread")
    DispatchQueue.main.async {
      Pacify.call(apiKey: apiKey, userToken: userToken, coupon: coupon, userData: userData, settings: settings, delegate: nil)
    }
    
    cb([
      "pacifyCalled"
    ])
   }

}

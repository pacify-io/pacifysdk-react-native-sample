//
//  Counter.swift
//  pacifySDK_rn
//
//  Created by Sean Zhang on 9/30/20.
//

import Foundation
import Kingfisher
import UIKit
@objc(Counter)
class Counter: NSObject {
  

  
  private var count = 0
  
  @objc
  func hello() {
    print("say hello")
  }
  
  @objc
  func increment(_ callback: RCTResponseSenderBlock) {
    DispatchQueue.main.async {
      let myImageView: UIImageView = UIImageView();
      let url = URL(string: "https://i.imgur.com/6N3EnGu.png")
      myImageView.kf.setImage(with: url)
    }
    
    count += 1
    print("count is \(count)")
    callback([
      count
    ])
  }
}

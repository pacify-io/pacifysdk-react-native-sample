//
//  Counter.swift
//  pacifySDK_rn
//
//  Created by Sean Zhang on 9/30/20.
//

import Foundation

@objc(Counter)
class Counter: NSObject {
  
  private var count = 0
  
  @objc
  func hello() {
    print("say hello")
  }
  
  @objc
  func increment(_ callback: RCTResponseSenderBlock) {
    count += 1
    print("count is \(count)")
    callback([
      count
    ])
  }
}

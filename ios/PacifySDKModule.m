//
//  Counter.m
//  pacifySDK_rn
//
//  Created by Sean Zhang on 9/30/20.
//

#import <Foundation/Foundation.h>
#import "React/RCTBridgeModule.h"
@interface RCT_EXTERN_MODULE(PacifySDKModule, NSObject)

RCT_EXTERN_METHOD(callPacify:(NSDictionary *)args callback:(RCTResponseSenderBlock)callback)

+ (BOOL)requiresMainQueueSetup {
    return NO;
}

@end

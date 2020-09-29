#include <stdlib.h>

#import "CocoapodExample.h"
#import <React/RCTBridgeModule.h>

@implementation CocoapodExample : NSObject

RCT_EXPORT_MODULE();

@synthesize bridge = _bridge;

RCT_EXPORT_METHOD(random:(NSUInteger)length
                  callback:(RCTResponseSenderBlock)callback)
{
    callback(@[[NSNull null], [self random:length]]);
}

- (NSString *) random:(NSUInteger)length
{
    NSString* randString = [NSString stringWithFormat:@"%i", arc4random_uniform((int)length)];
    return randString;
}

+ (BOOL)requiresMainQueueSetup {
    return NO;
}

@end

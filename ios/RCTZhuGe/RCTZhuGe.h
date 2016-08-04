//
//  RCTZhuGe.h
//  RCTZhuGe
//
//  Created by Chao on 8/3/16.
//  Copyright © 2016 Chao. All rights reserved.
//
#import <UIKit/UIKit.h>
#import "RCTBridgeModule.h"

@interface RCTZhuGe : NSObject <RCTBridgeModule>
+ (void)startWithAppKey:(NSString *)appKey launchOptions:(NSDictionary *)launchOptions;
@end
//
//  RCTZhuGe.m
//  RCTZhuGe
//
//  Created by Chao on 8/3/16.
//  Copyright © 2016 Chao. All rights reserved.
//

#import "RCTZhuGe.h"
#import "Zhuge.h"

@implementation RCTZhuGe

+ (void)startWithAppKey:(NSString *)appKey launchOptions:(NSDictionary *)launchOptions
{
    Zhuge *zhuge = [Zhuge sharedInstance];
    
#ifdef DEBUG
    [zhuge.config setDebug : YES];
#endif

    [zhuge startWithAppKey:appKey
             launchOptions:launchOptions];
}

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(identify:(NSString *)userId location:(NSDictionary *)userInfo)
{
    [[Zhuge sharedInstance] identify:userId properties:userInfo];
}

RCT_EXPORT_METHOD(track:(NSString *)eventName location:(NSDictionary *)eventProps)
{
    [[Zhuge sharedInstance] track:eventName properties:eventProps];
}

@end

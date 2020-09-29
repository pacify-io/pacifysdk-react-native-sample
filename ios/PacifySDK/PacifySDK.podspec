Pod::Spec.new do |spec|

    spec.name    = 'PacifySDK'
    spec.version  = '1.0.9'
    spec.summary  = 'Pacify SDK'
    spec.description  = "Pacify SDK."
    spec.homepage = 'https://pacify.com'
    spec.platform     = :ios, "12.0"
    spec.swift_versions = ['5.1']
    spec.license  = {
    :type => "Commercial",
    :text => "Copyright Pacify Health, LLC. All rights reserved. Use of this software is subject to the terms and conditions of the Pacify Health, LLC Terms of Service."
    }
    spec.author  = { 'Pacify' => 'pacify-support@masslight.com' }
    spec.source  = { :http => 'https://s3.amazonaws.com/pacifysdk/releases/1.0.9/PacifySDK-1.0.9.zip' }

    spec.vendored_frameworks = 'PacifySDK.framework'

    spec.dependency 'PromiseKit/CorePromise', '= 6.10.0'
    spec.dependency 'PromiseKit/UIKit', '= 6.10.0'
    spec.dependency 'SVProgressHUD', '~> 2.1.2'
    spec.dependency 'Reachability', '~> 3.2'

    spec.dependency 'AFNetworking/Reachability', '~> 3.2.0'
    spec.dependency 'AFNetworking/Serialization', '~> 3.2.0'
    spec.dependency 'AFNetworking/Security', '~> 3.2.0'
    spec.dependency 'AFNetworking/NSURLSession', '~> 3.2.0'
    
    spec.dependency 'SimpleKeychain', '~> 0.7.0'
    spec.dependency 'CocoaLumberjack/Swift', '= 3.5.3'
    spec.dependency 'zipzap', '~> 8.1.1'
    spec.dependency 'DeviceKit', '~> 1.11.0'
    spec.dependency 'Kingfisher', '= 5.7.1'

    spec.dependency 'EDStarRating', '~> 1.1'
    spec.dependency 'UITextView+Placeholder', '~> 1.3.3'
    spec.dependency 'AWSMobileAnalytics', '= 2.10.3'
    spec.dependency 'AWSMobileAnalytics', '= 2.10.3'
end

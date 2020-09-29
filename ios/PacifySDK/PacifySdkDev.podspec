Pod::Spec.new do |spec|

spec.name    = 'PacifySDK'
spec.version  = '1.0.6-dev'
spec.summary  = 'Pacify SDK Dev'
spec.description  = "Pacify SDK Dev only."
spec.homepage = 'https://pacify.com'
spec.platform     = :ios, "10.0"
spec.swift_versions = ['5.0']
spec.license  = {
:type => "Commercial",
:text => "Copyright Pacify Health, LLC. All rights reserved. Use of this software is subject to the terms and conditions of the Pacify Health, LLC Terms of Service."
}
spec.author  = { 'Pacify' => 'pacify-support@masslight.com' }
spec.source  = { :http => 'https://s3.amazonaws.com/pacifysdk/releases/0.2.2-dev/PacifySDKDev-0.2.2.zip' }

spec.vendored_frameworks = 'PacifySDKDev.framework'

spec.dependency 'PromiseKit/CorePromise', '= 6.10.0'
spec.dependency 'PromiseKit/UIKit', '= 6.10.0'
spec.dependency 'SVProgressHUD', '~> 2.1.2'
spec.dependency 'Reachability', '~> 3.2'

spec.dependency 'AFNetworking', '~> 3.2.0', :subspecs => ['Reachability', 'Serialization', 'Security', 'NSURLSession']

spec.dependency 'SimpleKeychain', '~> 0.7.0'
spec.dependency 'CocoaLumberjack/Swift', '= 3.5.3'
spec.dependency 'zipzap', '~> 8.1.1'
spec.dependency 'DeviceKit', '~> 1.11.0'
spec.dependency 'Kingfisher', '= 4.1.0'

spec.dependency 'EDStarRating', '~> 1.1'
spec.dependency 'UITextView+Placeholder', '~> 1.2.0'
spec.dependency 'AWSMobileAnalytics', '= 2.10.3'

end


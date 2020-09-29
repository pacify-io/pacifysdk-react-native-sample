Pod::Spec.new do |s|
s.name              = 'PacifySDK'
s.version           = '0.0.5'
s.summary           = 'Pacify SDK'
s.homepage          = 'http://pacify.com'

s.author            = { 'Name' => 'pacify-support@masslight.com' }
s.license           = { :type => 'Apache-2.0', :file => 'LICENSE' }

s.platform          = :ios
s.source            = { :path => '/Users/Ihawk/Work/Pacify/Projects/pacify_ios_test/pacify_ios/PacifySDK/Archived/Development-universal/PacifySDK.framework' }

s.module_name      = 'PacifySDK'

s.ios.deployment_target = '8.1'
s.ios.vendored_frameworks = 'PacifySDK.framework'
end

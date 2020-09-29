Pod::Spec.new do |s|
  s.name         = "CocoapodExample"
  s.version      = "1.0.0"
  s.summary      = "example cocoapod dependency"
  s.author       = "sean7218"
  s.homepage     = "https://masslight.com"
  s.license      = "MIT"
  s.platform     = :ios, "10.0"
  s.source       = { :http => 'file:' + __dir__ + '/' }
  s.source_files = '**/*.{h,m}'
  s.dependency "React"
end

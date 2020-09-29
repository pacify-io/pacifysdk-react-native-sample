# PacifySDK
Allows embedding pacify calls into 3rd party apps

# Embedding PacifySDK into an Application 

Add pod PacifySDK
Add all pods PacifySDK depends on
Add privacy settings to info.plist

# PacifySDK Project Specifics

Use post archive phase to build fat framework usable for distribution through CocoaPod

# Building Fat framework
Product -> Archive
Result and archive log is Placed into PacifySDK/Archived/${CONFIGURATION}-universal
Building fat frameworks is made in 3 steps: 1) building  library for ios architecture (visible in xcode as normal archiving in progress) 2) build for symulator architecture (post-archive, progress is not visible in xcode) 3) liping ios and symalator frameworks into universal (post-archive, , progress is not visible in xcode). So PacifySDK.framework and PacifySDK_archive.log appears noticably later then xcode shows and of archiving. 

# Project -> Capabilities
Background Modes = Enabled
Audio, AirPlay and Picture in Picture
Voice over IP

# Project -> Info
Privacy - Microphone Usage Description: "We use this so you can talk face-to-face with our expert providers."
Privacy - Camera Usage Description: "We use this so you can talk face-to-face with our expert providers."

Required background modes:
    App plays audio or streams audio/video using AirPlay
    App provides Voice over IP services

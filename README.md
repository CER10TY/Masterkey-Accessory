# Masterkey Accessory application
### A basic application for use with KeePass 2.0, to store the Masterkey externally.

This app is obviously very basic, but it gets the job done. There's no internal security (such as encryption), it's just based on the user knowing the password and nobody getting access to the source code / the phone.
The actual masterkey is stored behind a password prompt, which the user will have to pass. At that point, the masterkey gets displayed in a simple text field below the prompt. 
There's no time limit, so it's recommended to reset (accessible at the top right, or via menu button) everything ASAP. 

This app is not guaranteed to work below Android 4.4 (KitKat). Currently, there's no permanent save of the data. That means, if you shut down your app, your Settings will do too. However, beyond that it should work as intended.

Get the latest version of KeePass here:
http://keepass.info/

## Version Control

### 0.3
- It is now possible to save the masterkey and password to a SharedPref file.
- Prompt now shows if Settings have been properly imported.
- TODO: Remove manual import and do it on startup instead. Might as well make full use of SharedPref and not use finish() on the ConfigActivity.

### 0.2
- Added Settings window, to manually configure a masterkey and password.

### 0.1

- Initial Commit
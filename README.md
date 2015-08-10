# Masterkey Accessory application
### A basic application for use with KeePass 2.0, to store the Masterkey externally.

This app is obviously very basic, but it gets the job done. There's no internal security (such as encryption), it's just based on the user knowing the password and nobody getting access to the source code / the phone.
The actual masterkey is stored behind a password prompt, which the user will have to pass. At that point, the masterkey gets displayed in a simple text field below the prompt. 
There's no time limit, so it's recommended to reset (accessible at the top right, or via menu button) everything ASAP. 

This app isn't guaranteed to work below Android 4.4, but you're welcome to try. Right now I won't include an .apk since you need to change your desired password and the Masterkey password in MainActivity.java anyway.
I'm working on including configuration at the start though. Once that's in I'll probably get an .apk in aswell.

Get the latest version of KeePass here:
http://keepass.info/
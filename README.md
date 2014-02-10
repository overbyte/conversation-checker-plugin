Conversation Checker plugin
===========================
This is a plugin for Phonegap for the Publicis Conversation Locker project.

It includes the following functionality:

* add a callable service to check over the phone to make sure of the following:
    * The application isn't switched
    * If the phone goes to sleep, it isn't started up again
    * If a phonecall comes in, it isn't answered
    * If a text comes in, it isn't answered
    * If any of the above, a call back to the server to notify the other phones in the conversation that you just couldn't keep your little hands off 

Important
=========
This requires that appropriately sized icons are available in R.drawable.ic_notify (for android - ios to come).
These assets need to be added to the project by hand when the plugin is added. I don't know why a workflow hasn't been created by Phonegap / cordova for this kind of basic functionality but there it is. Here are some articles to explain this:
* http://devgirl.org/2013/09/12/phonegap-icons-and-splash-screens-help/
* http://docs.phonegap.com/en/3.0.0/cordova_splashscreen_splashscreen.md.html

I've been using a grunt task to do this - I've been using grunt-contrib-copy. My task is set up as follows (adds app icon and notification icon from a folder called platform_merges):
	copy: {
	    main: {
	        files: [
	            // app icon
	            //main
	            { src: 'platform-merges/android/icon/drawable/icon.png', dest: 'platforms/android/res/drawable/icon.png' },
	            //ldpi
	            { src: 'platform-merges/android/icon/drawable-ldpi/icon.png', dest: 'platforms/android/res/drawable-ldpi/icon.png' },
	            //mdpi
	            { src: 'platform-merges/android/icon/drawable-mdpi/icon.png', dest: 'platforms/android/res/drawable-mdpi/icon.png' },
	            //hdpi
	            { src: 'platform-merges/android/icon/drawable-hdpi/icon.png', dest: 'platforms/android/res/drawable-hdpi/icon.png' },
	            //xhdpi
	            { src: 'platform-merges/android/icon/drawable-xhdpi/icon.png', dest: 'platforms/android/res/drawable-xhdpi/icon.png' },
	            
	            // notification icon
	            //main
	            { src: 'platform-merges/android/icon/drawable/ic_notify.png', dest: 'platforms/android/res/drawable/ic_notify.png' },
	            //ldpi
	            { src: 'platform-merges/android/icon/drawable-ldpi/ic_notify.png', dest: 'platforms/android/res/drawable-ldpi/ic_notify.png' },
	            //mdpi
	            { src: 'platform-merges/android/icon/drawable-mdpi/ic_notify.png', dest: 'platforms/android/res/drawable-mdpi/ic_notify.png' },
	            //hdpi
	            { src: 'platform-merges/android/icon/drawable-hdpi/ic_notify.png', dest: 'platforms/android/res/drawable-hdpi/ic_notify.png' },
	            //xhdpi
	            { src: 'platform-merges/android/icon/drawable-xhdpi/ic_notify.png', dest: 'platforms/android/res/drawable-xhdpi/ic_notify.png' },
	        ]
	    }
	}
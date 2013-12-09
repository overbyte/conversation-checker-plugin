/**
 * 
 */
package com.publicislondon.plugins.convchecker.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author AllandBi
 *
 */
public class ScreenReceiver extends BroadcastReceiver {
	
	public static boolean wasScreenOn = true;

	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
			wasScreenOn = true;
		} else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
			wasScreenOn = false;
		}
		Log.i("ScreenReceiver", "onReceive: " + wasScreenOn);
	}

}

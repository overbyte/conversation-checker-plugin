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
public class CallReceiver extends BroadcastReceiver {
	public static final	String	TAG = CallReceiver.class.getSimpleName();

	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "broadcast received");
		Log.i(TAG, intent.getAction());
	}

}

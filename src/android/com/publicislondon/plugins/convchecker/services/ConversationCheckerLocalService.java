/**
 * 
 */
package com.publicislondon.plugins.convchecker.services;

import com.publicislondon.apps.convlock.broadcastreceivers.ScreenReceiver;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * @author AllandBi
 *
 */
public class ConversationCheckerLocalService extends Service {
	/**
	 * leans heavily on http://developer.android.com/reference/android/app/Service.html#Permissions
	 */
	private int NOTIFICATION = R.string.local_service_started;
	public static final	String	TAG = "ConversationCheckerLocalService";
	
	private NotificationManager _notMan;
	private IBinder 			_binder;
	
	/**
     * Class for clients to access.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with
     * IPC.
     */
	public class LocalBinder extends Binder {
		public ConversationCheckerLocalService getService() {
			return ConversationCheckerLocalService.this;
		}
	}
	
	@Override
	public void onCreate() {
		_notMan = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		// show started notification
		showNotification();
	}

	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Received start id " + startId + ": " + intent);
        
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }
	
	@Override
	public void onDestroy() {
		_notMan.cancel(NOTIFICATION);
		
		Toast.makeText(this, R.string.local_service_stopped, Toast.LENGTH_SHORT)
			 .show();
	}
	
	/* This is the object that receives interactions from clients. See
	 * RemoteService for a more complete example.
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		return _binder;
	}
	
	/**
	 * show that service is running
	 */
	@SuppressWarnings("deprecation")
	private void showNotification() {
		CharSequence text = getText(R.string.local_service_started);
		
		// PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, RoomActivity.class), 0);
		
		// add icon, text and timestamp
		// reference for non-tutorial code which was deprecated:
		//http://stackoverflow.com/questions/6391870/how-exactly-to-use-notification-builder
		Notification notification = new Notification.Builder(this)
			.setContentTitle(getText(R.string.local_service_started))
			.setSmallIcon(R.drawable.ic_notify)
			//.setContentIntent(contentIntent)
			.getNotification();
		
		_notMan.notify(NOTIFICATION, notification);
	}

}

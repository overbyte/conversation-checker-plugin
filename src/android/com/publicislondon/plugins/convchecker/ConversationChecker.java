package com.publicislondon.plugins.convchecker;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;

public class ConversationChecker extends CordovaPlugin  {

	public static final String TAG = "ConversationChecker";
	public static final String ACTION_ECHO = "echo";

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (ACTION_ECHO.equals(action)) {

			Log.v(TAG, "execute: action=" + action);

			try {

				String message = args.getString(0);
				this.echo(message, callbackContext);
				return true;

			} catch (JSONException e) {

				Log.e(TAG, "execute: Got JSON Exception " + e.getMessage());
				result = false;
				callbackContext.error(e.getMessage());

			}
		}

		return false;
	}

	private void echo(String message, CallbackContext callbackContext) {
		if (message != null && message.length() > 0) {
			callbackContext.success(message);
		} else {
			callbackContext.error("Expected one non-empty string argument.");
		}
	}

}
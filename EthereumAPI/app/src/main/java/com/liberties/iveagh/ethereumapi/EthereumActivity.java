package com.liberties.iveagh.ethereumapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.ListActivity;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class EthereumActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new HttpGetTask().execute();
	}

	private class HttpGetTask extends AsyncTask<Void, Void, List<String>> {

		// Get your own user name at http://
		private static final String USER_NAME = "PFZSPQ73Z1NK42CH9S8G1Q3PSJC66WAN1Q";

		private static final String URL = "https://api.etherscan.io/api?module=account&action=balancemulti&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a,0x63a9975ba31b0b9626b34300f7f627147df1f526,0x198ef1ec325a96cc354c7266a038be8b5c558f67,0xe056203680db07c0f5006999fb3393da626b07c8&tag=latest&apikey="
				+ USER_NAME;

		AndroidHttpClient mClient = AndroidHttpClient.newInstance("");

		@Override
		protected List<String> doInBackground(Void... params) {
			HttpGet request = new HttpGet(URL);
			JSONResponseHandler responseHandler = new JSONResponseHandler();
			try {
				return mClient.execute(request, responseHandler);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(List<String> resultout) {
			if (null != mClient)
				mClient.close();
			setListAdapter(new ArrayAdapter<String>(
					EthereumActivity.this,
					R.layout.list_item, resultout));
		}
	}

	private class JSONResponseHandler implements ResponseHandler<List<String>> {

		//private static final String STATUS_TAG = "status";
		//private static final String MESSAGE_TAG = "message";
		private static final String RESULT_TAG = "result";
		private static final String ACCOUNT_TAG = "account";
		private static final String BALANCE_TAG = "balance";

		@Override
		public List<String> handleResponse(HttpResponse response)
				throws ClientProtocolException, IOException {
			List<String> resultout = new ArrayList<String>();
			String JSONResponse = new BasicResponseHandler()
					.handleResponse(response);
			try {

				// Get top-level JSON Object - a Map
				JSONObject responseObject = (JSONObject) new JSONTokener(
						JSONResponse).nextValue();

				// Extract value of "result" key -- a List
				JSONArray result = responseObject
						.getJSONArray(RESULT_TAG);

				// Iterate over result list
				for (int idx = 0; idx < result.length(); idx++) {

					// Get single earthquake data - a Map
					JSONObject ether = (JSONObject) result.get(idx);
					// Summarize ethereumdata as a string and add it to resultout

					//convert string element to int?
					//int BALANCE_TAG_INT = ether.get(BALANCE_TAG);

					resultout.add(ACCOUNT_TAG + ":\n"
							+ ether.get(ACCOUNT_TAG) + "\n"
							+ BALANCE_TAG + ":\n"
							+ ether.get(BALANCE_TAG));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return resultout;
		}
	}
}
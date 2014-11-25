package com.nexx.hits;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import android.app.Service;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DictionaryIndonesiaEnglish extends Fragment {

	private Button btn;
	private TextView tv;
	private EditText et;
	private ProgressBar sp;
	private InputMethodManager imm;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.activity_dictionary_indonesia_english, container, false);

		btn = (Button) v.findViewById(R.id.translateIE);
		sp = (ProgressBar) v.findViewById(R.id.progressBar);
		tv = (TextView) v.findViewById(R.id.resultIE);
		et = (EditText) v.findViewById(R.id.inputIE);
		et.requestFocus();
		imm = (InputMethodManager) getActivity().getSystemService(Service.INPUT_METHOD_SERVICE);
		imm.showSoftInput(et, 0);
		
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
				new translating().execute();
			}
		});
		
		return v;
	}

	public class translating extends AsyncTask<Void, Void, Void>{

		String translatedText = "";
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			sp.setVisibility(View.VISIBLE);
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				String text = et.getText().toString();
				translatedText = translateToEnglish(text);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				translatedText = e.toString();
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			tv.setText(translatedText);
			tv.setVisibility(View.VISIBLE);
			sp.setVisibility(View.GONE);
			super.onPostExecute(result);
		}

	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Translate.setClientId("HitsTranslator"); //Change this
		Translate.setClientSecret("B/VhSWrANAnGoR20Qjajte55keKXChReRPPmODjn8S8="); //change

		
	}
	
	public String translateToEnglish(String text) throws Exception{

		String translatedText = "";

		translatedText = Translate.execute(text,Language.ENGLISH);

		return translatedText;
	}
	
}

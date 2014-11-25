package com.nexx.hits;

import com.viewpagerindicator.TabPageIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Dictionary extends Fragment{

	private TabPageIndicator indicator;
	private CustomViewPager pager;
	private MyPagerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.dictionary, container, false);
        
		adapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());

		pager = (CustomViewPager) v.findViewById(R.id.pager2);
		
		pager.setAdapter(adapter);
		pager.setSwipeable(false);
		indicator = (TabPageIndicator) v.findViewById(R.id.tabs2);
		indicator.setViewPager(pager);
		
		return v;
	}
	
	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "English-Indonesia", "Indonesia-English" };

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				Fragment DictEngInd = new DictionaryEnglishIndonesia();
				return DictEngInd;
			case 1:
				Fragment DictIndEng = new DictionaryIndonesiaEnglish();
				return DictIndEng;
			default:
				return SuperAwesomeCardFragment.newInstance(position);
			}
		}

	}
	
}

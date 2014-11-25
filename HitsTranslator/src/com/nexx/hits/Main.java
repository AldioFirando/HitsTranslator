package com.nexx.hits;


import com.astuetz.PagerSlidingTabStrip;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;



public class Main extends FragmentActivity{

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private MyPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.mainactivity);
	
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.pager);
		adapter = new MyPagerAdapter(getSupportFragmentManager());

		pager.setAdapter(adapter);
		tabs.setIndicatorColor(Color.parseColor("#ff0e0e"));
		tabs.setIndicatorHeight(5);

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
				.getDisplayMetrics());
		pager.setPageMargin(pageMargin);

		tabs.setViewPager(pager);

	//	changeColor(currentColor);
		
    }
	
	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "Reading", "Games", "Dictionary" };

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
				Fragment home = new Home();
				return home;
			case 1:
				Fragment reading = new Reading();
				return reading;
			case 2:
				Fragment games = new Games();
				return games;
			case 3:
				Fragment dictionary = new Dictionary();
				return dictionary;
			default:
				return SuperAwesomeCardFragment.newInstance(position);
			}
		}

	}
	
	
}

	

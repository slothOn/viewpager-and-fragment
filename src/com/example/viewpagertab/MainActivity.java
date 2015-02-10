package com.example.viewpagertab;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity implements OnClickListener{
    private ViewPager viewpager;
    private LinearLayout weixin;
    private LinearLayout frd;
    private LinearLayout addr;
    private LinearLayout setting;
    private ImageButton weixinimg;
    private ImageButton frdimg;
    private ImageButton addrimg;
    private ImageButton settingimg;
    private List<View> pagelist=new ArrayList<View>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

	private void initEvent() {
		// TODO Auto-generated method stub
		weixin.setOnClickListener(this);
		frd.setOnClickListener(this);
		addr.setOnClickListener(this);
		setting.setOnClickListener(this);
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				resetimg();
				switch (arg0) {
				case 0:
					weixinimg.setImageResource(R.drawable.tab_weixin_pressed);
					break;
				case 1:
					frdimg.setImageResource(R.drawable.tab_find_frd_pressed);
					break;
				case 2:
					addrimg.setImageResource(R.drawable.tab_address_pressed);
					break;
				case 3:
					settingimg.setImageResource(R.drawable.tab_settings_pressed);
					break;
				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void initView() {
		// TODO Auto-generated method stub
		viewpager=(ViewPager) findViewById(R.id.id_viewpager);
		weixin=(LinearLayout) findViewById(R.id.id_tabweixin);
		frd=(LinearLayout) findViewById(R.id.id_tabfrd);
		addr=(LinearLayout) findViewById(R.id.id_tabaddress);
		setting=(LinearLayout) findViewById(R.id.id_tabsettings);
		weixinimg=(ImageButton) findViewById(R.id.id_tabweixinimg);
		frdimg=(ImageButton) findViewById(R.id.id_tabfrdimg);
		addrimg=(ImageButton) findViewById(R.id.id_tabaddressimg);
		settingimg=(ImageButton) findViewById(R.id.id_tabsettingsimg);
		LayoutInflater inflater=LayoutInflater.from(this);
		View v1=inflater.inflate(R.layout.tab1, null);
		View v2=inflater.inflate(R.layout.tab2, null);
		View v3=inflater.inflate(R.layout.tab3, null);
		View v4=inflater.inflate(R.layout.tab4, null);
		pagelist.add(v1);
		pagelist.add(v2);
		pagelist.add(v3);
		pagelist.add(v4);
		viewpager.setAdapter(new PagerAdapter() {
			
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				View v=pagelist.get(position);
				container.removeView(v);
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO Auto-generated method stub
				//≥ı ºªØviewpager
				View v=pagelist.get(position);
				container.addView(v);
				return v;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0==arg1;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return pagelist.size();
			}
		});
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		resetimg();
		switch (arg0.getId()) {
		case R.id.id_tabweixin:
			viewpager.setCurrentItem(0);
			weixinimg.setImageResource(R.drawable.tab_weixin_pressed);
			break;
        case R.id.id_tabfrd:
			viewpager.setCurrentItem(1);
			frdimg.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
        case R.id.id_tabaddress:
			viewpager.setCurrentItem(2);
			addrimg.setImageResource(R.drawable.tab_address_pressed);
			break;
        case R.id.id_tabsettings:
			viewpager.setCurrentItem(3);
			settingimg.setImageResource(R.drawable.tab_settings_pressed);
			break;
		default:
			break;
		}
	}

	private void resetimg() {
		// TODO Auto-generated method stub
		weixinimg.setImageResource(R.drawable.tab_weixin_normal);
		frdimg.setImageResource(R.drawable.tab_find_frd_normal);
		addrimg.setImageResource(R.drawable.tab_address_normal);
		settingimg.setImageResource(R.drawable.tab_settings_normal);
	}
}

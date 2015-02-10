package com.example.viewpagertab;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity implements OnClickListener{
    private LinearLayout weixin;
    private LinearLayout frd;
    private LinearLayout addr;
    private LinearLayout setting;
    private ImageButton weixinimg;
    private ImageButton frdimg;
    private ImageButton addrimg;
    private ImageButton settingimg;
    private Fragment weixinfrg;
    private Fragment frdfrg;
    private Fragment addrfrg;
    private Fragment settingfrg;
    private ViewPager viewpager;
    private MyFragmentAdapter adapter;
    List<Fragment> frgs=new ArrayList<Fragment>();
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
	}

	private void initView() {
		// TODO Auto-generated method stub
		
		weixin=(LinearLayout) findViewById(R.id.id_tabweixin);
		frd=(LinearLayout) findViewById(R.id.id_tabfrd);
		addr=(LinearLayout) findViewById(R.id.id_tabaddress);
		setting=(LinearLayout) findViewById(R.id.id_tabsettings);
		weixinimg=(ImageButton) findViewById(R.id.id_tabweixinimg);
		frdimg=(ImageButton) findViewById(R.id.id_tabfrdimg);
		addrimg=(ImageButton) findViewById(R.id.id_tabaddressimg);
		settingimg=(ImageButton) findViewById(R.id.id_tabsettingsimg);
		
		weixinfrg=new WeixinFragment();
		frdfrg=new FrdFragment();
		addrfrg=new AddrFragment();
		settingfrg=new SettingFragment();
		
		viewpager=(ViewPager) findViewById(R.id.id_viewpager);
	    frgs.add(weixinfrg);
	    frgs.add(frdfrg);
	    frgs.add(addrfrg);
	    frgs.add(settingfrg);
	    adapter=new MyFragmentAdapter(getFragmentManager()) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return frgs.size();
			}
			
			@Override
			public Fragment getItem(int position) {
				// TODO Auto-generated method stub
				return frgs.get(position);
			}
		};
	    viewpager.setAdapter(adapter);
	    viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
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

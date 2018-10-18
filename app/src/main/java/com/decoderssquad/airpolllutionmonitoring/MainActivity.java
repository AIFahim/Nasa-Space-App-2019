package com.decoderssquad.airpolllutionmonitoring;


import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;

import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    BoomMenuButton bmb;
    ArrayList<Integer> imageIdList;
    ArrayList<String> titleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmb = findViewById(R.id.bmb);
        imageIdList = new ArrayList<>();
        titleList = new ArrayList<>();
        setInitialData();
        setTitle("Air Pollution Monitoring");


        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            int position = i;
            if (position == 0) {
                TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                        .normalImageRes(imageIdList.get(i))
                        .normalText(titleList.get(i))
                        .normalTextColor(Color.BLACK)
                        .textSize(12)
                        .pieceColor(Color.WHITE)
                        .unableColor(Color.BLACK)

                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {


                                Intent intent = new Intent(MainActivity.this, Device.class);
                                startActivity(intent);


                            }

                        });
                bmb.addBuilder(builder);
            }
            else if (position == 1) {
                TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                        .normalImageRes(imageIdList.get(i))
                        .normalText(titleList.get(i))
                        .normalTextColor(Color.BLACK)
                        .textSize(12)

                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {


                                Intent intent = new Intent(MainActivity.this, Device.class);
                                startActivity(intent);


                            }

                        });
                bmb.addBuilder(builder);
            }


        }


        ViewPager viewPager = findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragments to adapter one by one
        adapter.addFragment(new Frag_One(), "Place");
        adapter.addFragment(new Frag_Two(), "Device");





        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }


    // Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void setInitialData() {

        imageIdList.add(R.drawable.ic_launcher_background);
        imageIdList.add(R.drawable.ic_launcher_background);

        titleList.add("আমাদের সম্পর্কে");
        titleList.add("ফোন করুন");

    }

}

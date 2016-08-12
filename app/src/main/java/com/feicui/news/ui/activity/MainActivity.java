package com.feicui.news.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.feicui.news.R;
import com.feicui.news.adapter.MainAdapter;
import com.feicui.news.adapter.MypagerAdapter;
import com.feicui.news.ui.fragment.CarFragment;
import com.feicui.news.ui.fragment.JokeFragment;
import com.feicui.news.ui.fragment.NBAFragment;
import com.feicui.news.ui.fragment.NewsFragment;
import com.feicui.news.ui.fragment.PictureFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainAdapter.MyItemClickListener,
        NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout          mDrawer;
    private ActionBarDrawerToggle mToggle;
    private NavigationView        mNavigationView;

    private RecyclerView          mRecyclerView;
    private Button                mBtnLogin;
    private ViewPager             mViewPager;
    private ArrayList<Fragment>   mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //左右滑动的viewpager
        mViewPager = (ViewPager) findViewById(R.id.vp_fragment);
        //设置适配器
        mList = new ArrayList<>();
        mList.add(new NewsFragment());
        mList.add(new CarFragment());
        mList.add(new JokeFragment());
        mList.add(new PictureFragment());
        mList.add(new NBAFragment());
        mViewPager.setAdapter(new MypagerAdapter(getSupportFragmentManager(),mList));
        mViewPager.setCurrentItem(0);
        //设置viewpager的监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void init() {
        mDrawer = (DrawerLayout) findViewById(R.id.root);
        mToggle = new ActionBarDrawerToggle(this,mDrawer,R.string.open,R.string.close);
        //
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();
        //显示mtoggle菜单
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        //获取头文件的点击事件
        View headerView = mNavigationView.getHeaderView(0);
        mBtnLogin = (Button) headerView.findViewById(R.id.btn_login);
        //设置监听
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });

        //给navigation设置点击监听
        mNavigationView.setNavigationItemSelectedListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_main);
        mRecyclerView.hasFixedSize();
        RecyclerView.LayoutManager manager = new
                LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(manager);

        MainAdapter mainAdapter = new MainAdapter(this);
        mainAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mainAdapter);
    }


    //点击mToggle打开抽屉
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return  mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);

    }

    //点击返回键处理
    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(View view, int postion) {
       mViewPager.setCurrentItem(postion);
    }


    //navigation的点击事件
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Toast.makeText(MainActivity.this, "点击了~~哈哈", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}

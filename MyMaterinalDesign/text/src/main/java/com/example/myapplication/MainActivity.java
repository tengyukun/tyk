package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.adapter.MainAdapter;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {


    @ViewInject(R.id.dl_main_content)
    private DrawerLayout dl_main_content;

    @ViewInject(R.id.nv_main_leftcontent)
    private NavigationView nv_main_leftcontent;

    @ViewInject(R.id.tb_main_toolbar)
    private Toolbar tb_main_toolbar;

    @ViewInject(R.id.rv_main_content)
    private RecyclerView rv_main_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x.view().inject(this);

        initView();
        initData();

    }

    private void initData() {


        nv_main_leftcontent.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                dl_main_content.closeDrawer(GravityCompat.START);

                switch (item.getItemId()) {
                    case R.id.nav_blog:
                        Toast.makeText(MainActivity.this,"blog",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_about:
                        Toast.makeText(MainActivity.this,"about",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_version:
                        Toast.makeText(MainActivity.this,"version",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_userinfo:
                        Toast.makeText(MainActivity.this,"userinfo",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_sub1:
                        Toast.makeText(MainActivity.this,"sub1",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_sub2:
                        Toast.makeText(MainActivity.this,"sub2",Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }
                return true;
            }
        });



    }

    private void initView() {

        //设置标题栏
        initToolbar();
        //设置侧滑栏
        initNavigation();
        //填充数据
        initRecyclerView();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main_toolbar,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.option_1:
                Toast.makeText(MainActivity.this,"选项一",Toast.LENGTH_SHORT).show();
                break;

            case R.id.option_2:
                Toast.makeText(MainActivity.this,"选项二",Toast.LENGTH_SHORT).show();
                break;

            case R.id.option_3:
                Toast.makeText(MainActivity.this,"选项三",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }


        return true;
    }

    private void initRecyclerView() {

        rv_main_content.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        MainAdapter adapter=new MainAdapter(MainActivity.this);
        rv_main_content.setAdapter(adapter);

        rv_main_content.setItemAnimator(new DefaultItemAnimator());

    }

    private void initNavigation() {
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(MainActivity.this,dl_main_content,tb_main_toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        dl_main_content.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void initToolbar() {

        tb_main_toolbar.setTitle("标题");
        tb_main_toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(tb_main_toolbar);

    }
}

package com.xbl.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * 简单的实现如何加载一个ToolBar
 * 模仿了知乎的toolbar，蓝色的toolbar背景
 * 为toolbar添加了 导航，标题，子标题，中心标题，右侧的菜单（以及点击事件）
 * 导航栏和菜单栏的icon是已经设置好的大小48*48，要是为toolbar中的icon设置大小要到style中设置，比较麻烦
 *
 */

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar_tb);
//        //表明了toolbar会继承ActionBar的一些属性
//        setSupportActionBar(toolbar);
        //不使用setSupportActionBar时标题的设定
        toolbar.setTitle("收藏");
     //   toolbar.setSubtitle("我是子标题");
        //设置导航栏
        toolbar.setNavigationIcon(R.drawable.daohang);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"导航栏~",Toast.LENGTH_LONG).show();
            }
        });
        //在右上角填充菜单
        toolbar.inflateMenu(R.menu.main);
        //菜单栏的点击事件
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.setting:
                        Toast.makeText(MainActivity.this,getResources().
                                getString(R.string.setting),Toast.LENGTH_LONG).show();
                        break;
                    case R.id.about:
                        Toast.makeText(MainActivity.this,getResources().
                                getString(R.string.about),Toast.LENGTH_LONG).show();
                        break;
                    case R.id.quit:
                        Toast.makeText(MainActivity.this,getResources().
                                getString(R.string.quit),Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });

    }
}

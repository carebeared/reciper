package com.alsash.reciper.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.alsash.reciper.R;
import com.alsash.reciper.view.adapter.RecipeCatPagerAdapter;
import com.alsash.reciper.view.xmlview.SwipeViewPager;

/**
 * An abstract Activity that holds tab layout
 */
public abstract class RecipeTabActivity extends BaseDrawerActivity {

    // Views
    protected Toolbar toolbar;
    protected SwipeViewPager pager;
    protected TabLayout tabs;
    protected FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        bindViews();
        setupToolbar();
        setupPager();
        setupTabs();
        setupFab();
    }

    private void bindViews() {
        toolbar = (Toolbar) findViewById(R.id.activity_tab_toolbar);
        pager = (SwipeViewPager) findViewById(R.id.activity_tab_svp);
        tabs = (TabLayout) findViewById(R.id.activity_tab_tabs);
        fab = (FloatingActionButton) findViewById(R.id.activity_tab_fab);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        setupDrawer(toolbar); // Call to parent BaseDrawerActivity
    }

    private void setupPager() {
        pager.setAdapter(getPagerAdapter());
        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                setToolbarTitle(getPagerAdapter().getPageTitle(position));
            }
        });
        setToolbarTitle(getPagerAdapter().getPageTitle(0));
    }

    private void setupTabs() {
        tabs.setupWithViewPager(pager);
        for (int i = 0; i < tabs.getTabCount(); i++) {
            TabLayout.Tab tab = tabs.getTabAt(i);
            assert tab != null;
            tab.setText(null); // Icons only
            tab.setIcon(getPagerAdapter().getPageIcon(i));
        }
    }

    protected void setToolbarTitle(CharSequence title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setTitle(title);
    }

    protected abstract RecipeCatPagerAdapter getPagerAdapter();

    protected abstract void setupFab();
}

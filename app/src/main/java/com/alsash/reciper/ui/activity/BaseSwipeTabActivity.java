package com.alsash.reciper.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.alsash.reciper.R;
import com.alsash.reciper.ui.adapter.SwipePagerAdapter;
import com.alsash.reciper.ui.view.SwipeViewPager;

/**
 * An abstract Activity that holds tab layout
 */
public abstract class BaseSwipeTabActivity extends BaseDrawerActivity {

    // Layout views
    protected Toolbar toolbar;
    protected SwipeViewPager pager;
    protected TabLayout tabs;
    protected FloatingActionButton fab;

    private SwipePagerAdapter adapter;

    protected abstract SwipePagerAdapter getPagerAdapter();

    protected abstract void setupFab();

    protected boolean isDrawTabTitleOnHeader() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_swipe_base);
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

    protected void setupPager() {
        adapter = getPagerAdapter();
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
        if (isDrawTabTitleOnHeader()) {
            pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    setToolbarTitle(position);
                }
            });
        }
    }

    protected void setupTabs() {
        for (int i = 0; i < tabs.getTabCount(); i++) {
            TabLayout.Tab tab = tabs.getTabAt(i);
            assert tab != null;
            if (isDrawTabTitleOnHeader()) {
                tab.setText(null);
            } else {
                tab.setText(adapter.getPageTitle(i, getResources()));
            }
            tab.setIcon(adapter.getPageIcon(i, getResources(), getTheme()));
        }
    }

    protected void setToolbarTitle(int adapterPosition) {
        String title = adapter.getPageTitle(adapterPosition, getResources());
        if (title == null) return;
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setTitle(title);
    }
}

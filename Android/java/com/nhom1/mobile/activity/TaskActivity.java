package com.nhom1.mobile.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import com.nhom1.mobile.R;
import com.nhom1.mobile.core.Task;
import com.nhom1.mobile.fragments.TaskListFragment;
import com.nhom1.mobile.fragments.DetailFragment;

public class TaskActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TaskListFragment taskListFragment;
    private ViewPagerAdapter adapterPager;
    private int[] tabIcons = {
            R.mipmap.task_list,
            R.mipmap.detail
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        taskListFragment = new TaskListFragment();
        taskListFragment.setArguments(getIntent().getExtras());
        adapterPager = new ViewPagerAdapter(getSupportFragmentManager());
        adapterPager.addFrag(taskListFragment, "Task List");
        viewPager.setAdapter(adapterPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        if (tabLayout.getTabCount() == 2) tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    public void openTask(int taskId, Task task)
    {
        adapterPager = new ViewPagerAdapter(getSupportFragmentManager());
        adapterPager.addFrag(taskListFragment, "Task List");

        //Create Detail fragment with task information
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Title", task.getTitle());
        bundle.putString("Descript", task.getDescript());
        bundle.putString("Team", task.getTeam());
        bundle.putString("Begin", task.getBegin());
        bundle.putString("End", task.getEnd());
        detailFragment.setArguments(bundle);

        adapterPager.addFrag(detailFragment, "Detail Task");

        //Update tabLayout
        adapterPager.notifyDataSetChanged();
        tabLayout.setTabsFromPagerAdapter(adapterPager);
        setupTabIcons();
        tabLayout.getTabAt(1).select();
    }

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

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

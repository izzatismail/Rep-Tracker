package com.izzatismail.reptracker.Activities;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.izzatismail.reptracker.Fragments.ChartFragment;
import com.izzatismail.reptracker.Fragments.HistoryFragment;
import com.izzatismail.reptracker.Fragments.HomeFragment;
import com.izzatismail.reptracker.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView mBottomNavView = findViewById(R.id.bottom_navigation);
        mBottomNavView.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment selectedFragment = null;

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                selectedFragment = new HomeFragment();
                break;
            case R.id.nav_history:
                selectedFragment = new HistoryFragment();
                break;
            case R.id.nav_chart:
                selectedFragment = new ChartFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedFragment).commit();

        return true;
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}

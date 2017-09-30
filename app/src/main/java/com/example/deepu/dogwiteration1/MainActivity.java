package com.example.deepu.dogwiteration1;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.deepu.dogwiteration1.BreedActivity.BreedBlak;
import com.example.deepu.dogwiteration1.BreedActivity.breed_details;
import com.example.deepu.dogwiteration1.Home.home_blank;
import com.example.deepu.dogwiteration1.drawerFragment.Body;
import com.example.deepu.dogwiteration1.drawerFragment.CalendarReminder;
import com.example.deepu.dogwiteration1.drawerFragment.DogPark;
import com.example.deepu.dogwiteration1.drawerFragment.Plant;
import com.example.deepu.dogwiteration1.drawerFragment.UnityPlayerNativeFragment;
import com.example.deepu.dogwiteration1.drawerFragment.Vet;
import com.example.deepu.dogwiteration1.drawerFragment.VetCare;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    private Body bodyFragment;
    private Plant plantFragment;
    private Vet vetFragment;
    private CalendarReminder calendarReminderFragment;
    private UnityPlayerNativeFragment upnf;
    private DogPark DogParkFragment;
    private VetCare vetCareFragment;
    private breed_details breed_detailsFragment;
    private BreedBlak breedblank;
    private home_blank hhbb;
    String breed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //window.setStatusBarColor(getColor(R.color.colorPrimary));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //change navigation drawer to colorful
        navigationView.setItemIconTintList(null);

//        bodyFragment = new Body();
//        getSupportFragmentManager().beginTransaction().add(R.id.content_main, bodyFragment).commit();
        upnf = new UnityPlayerNativeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, upnf).commit();
        plantFragment = new Plant();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, plantFragment).commit();
        vetFragment = new Vet();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, vetFragment).commit();
        calendarReminderFragment = new CalendarReminder();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, calendarReminderFragment).commit();
        DogParkFragment = new DogPark();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, DogParkFragment).commit();
        vetCareFragment = new VetCare();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, vetCareFragment).commit();

        breedblank = new BreedBlak();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main,breedblank).commit();
        hhbb =new home_blank();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main,hhbb).commit();


        //hide all fragment when calendar_reminder page start
        getSupportFragmentManager().beginTransaction().hide(plantFragment).commit();
        //getSupportFragmentManager().beginTransaction().hide(bodyFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(upnf).commit();
        getSupportFragmentManager().beginTransaction().hide(calendarReminderFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(vetFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(DogParkFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(vetCareFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(breedblank).commit();
        getSupportFragmentManager().beginTransaction().show(hhbb).commit();
    }

    //once go to the mainActivity, set the toolbar title to UPET
    @Override
    protected void onResume() {
        super.onResume();
        setTitle("UPET");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();


        if (id == R.id.nav_toxic) {
            showFragment(plantFragment, calendarReminderFragment, upnf, vetFragment,DogParkFragment,vetCareFragment,hhbb,breedblank);
        } else if (id == R.id.nav_body) {
//            upnf = new UnityPlayerNativeFragment();
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.content_main, upnf, "UnityPlayerNativeFragment")
//                    .commit();
            showFragment(upnf, plantFragment, calendarReminderFragment, vetFragment,DogParkFragment,vetCareFragment,hhbb,breedblank);
        } else if (id == R.id.nav_home) {
            showFragment(calendarReminderFragment, upnf, plantFragment, vetFragment,DogParkFragment,vetCareFragment,hhbb,breedblank);
        }
        else if(id == R.id.nav_dPark){
            showFragment(DogParkFragment, calendarReminderFragment,upnf,plantFragment,vetFragment,vetCareFragment,hhbb,breedblank);
        }else if (id==R.id.nav_vetCare){
            showFragment(vetCareFragment,calendarReminderFragment,upnf,plantFragment,vetFragment,DogParkFragment,hhbb,breedblank);
        }else
        if (id == R.id.nav_Home){
            showFragment(hhbb,calendarReminderFragment,upnf,plantFragment,vetFragment,DogParkFragment,vetCareFragment,breedblank);
        }else if(id == R.id.Breed){
            showFragment(breedblank,hhbb,calendarReminderFragment,upnf,plantFragment,vetFragment,DogParkFragment,vetCareFragment);

        }
        else if (id == R.id.nav_vet) {
//            viewPager = (ViewPager) findViewById(R.id.viewPager);
//            ViewPageAdapter viewPageAdapter = new ViewPageAdapter(this);
//
//            viewPager.setAdapter(viewPageAdapter);
            showFragment(vetFragment, plantFragment, upnf, calendarReminderFragment,DogParkFragment,vetCareFragment,hhbb,breedblank);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(Fragment fragmentShow, Fragment fragmentHide1, Fragment fragmentHide2, Fragment fragmentHide3,Fragment fragmentHide4,Fragment fragmentHide5,Fragment fragmentHide6,Fragment fragmentHide7) {
        getSupportFragmentManager().beginTransaction().show(fragmentShow).commit();
        getSupportFragmentManager().beginTransaction().hide(fragmentHide1).commit();
        getSupportFragmentManager().beginTransaction().hide(fragmentHide2).commit();
        getSupportFragmentManager().beginTransaction().hide(fragmentHide3).commit();
        getSupportFragmentManager().beginTransaction().hide(fragmentHide4).commit();
        getSupportFragmentManager().beginTransaction().hide(fragmentHide5).commit();
        getSupportFragmentManager().beginTransaction().hide(fragmentHide6).commit();
        getSupportFragmentManager().beginTransaction().hide(fragmentHide7).commit();
    }

}
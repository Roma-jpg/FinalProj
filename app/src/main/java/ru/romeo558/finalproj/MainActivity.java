package ru.romeo558.finalproj;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ListView myListView;
    private MyListAdapter myListAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Open the navigation drawer when the hamburger icon is clicked
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find the DrawerLayout and NavigationView in the layout
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        // Set the item selected listener on the NavigationView
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        // Handle navigation item clicks here
                        switch (item.getItemId()) {
                            case R.id.nav_home:
                                System.out.println("Home is called");
                                break;
                            case R.id.nav_profile:
                                System.out.println("Info is called");
                                break;
                            case R.id.nav_settings:
//                                startActivity(new Intent(MainActivity.this, ActivitySettings.class));
                                System.out.println("Settings is called");
                                break;
                        }
                        // Close the navigation drawer when an item is clicked
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // Add a hamburger icon to the action bar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        // Create some sample list items
        List<MyListItem> items = new ArrayList<>();
        items.add(new MyListItem("Русский язык", "Упражнение 666", "4"));
        items.add(new MyListItem("Литература", "Выучить 'Война и мир' наизусть", "-5"));
        items.add(new MyListItem("Алгебра", "Полностью вычислить число Пи, сделать лекарство от рака, пробуриться до центра земли, решить проблему мирового голода и остановить астероид движущийся на землю.", "5"));
        items.add(new MyListItem("Физическая культура", "Развитие силы", ""));
        items.add(new MyListItem("География", "Контурные карты", ""));
        items.add(new MyListItem("Английский", "Эссе", "5"));
        items.add(new MyListItem("Информатика", "Лабораторная работа", ""));
        items.add(new MyListItem("История", "§14 вопросы письменно", "4"));

        // Create the adapter and set it on the list view
        myListAdapter = new MyListAdapter(this, R.layout.row_my_list_item, items);
        myListView = findViewById(R.id.myListView);
        myListView.setAdapter(myListAdapter);
    }
}
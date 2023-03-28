package ru.romeo558.finalproj;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ListView myListView;
    private MyListAdapter myListAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


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
//                                System.out.println("Info is called");
                                startActivity(new Intent(MainActivity.this, ActivityInfo.class));
                                finish();
                                break;
                            case R.id.nav_settings:
                                startActivity(new Intent(MainActivity.this, ActivitySettings.class));
                                finish();
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

        Button shareButton = findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Привет! Это тестовое сообщение которое предназначается для кнопки `Поделиться`. \n\n=======================================\n\nHello! This is a test message for the `Share` button.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });


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

        TextView titleTextView = findViewById(R.id.student_name);
        titleTextView.setText("РОМАН");

        Button dateButton = findViewById(R.id.date_button);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(new Date());
        dateButton.setText(currentDate);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.close_menu) { // replace 'close_menu' with the ID of your close button in the menu xml file
//            drawerLayout.closeDrawer(GravityCompat.START); // closes the menu
//            return true;
//        } else
            if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START); // opens the menu
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
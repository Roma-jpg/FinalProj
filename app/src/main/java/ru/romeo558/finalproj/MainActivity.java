package ru.romeo558.finalproj;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView myListView;
    private MyListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create some sample list items
        List<MyListItem> items = new ArrayList<>();
        items.add(new MyListItem("Русский язык", "Упражнение 666", "4"));
        items.add(new MyListItem("Литература", "Выучить 'Война и мир' наизусть", "-5"));
        items.add(new MyListItem("Алгебра", "Полностью вычислить число Пи, сделать лекарство от рака, пробуриться до центра земли, решить проблему мирового голода и остановить астероид движущийся на землю.", "5"));
        items.add(new MyListItem("Физическая культура", "Развитие силы", ""));
        items.add(new MyListItem("География", "Контурные карты", ""));
        items.add(new MyListItem("Английский", "Эссе", "5"));
        items.add(new MyListItem("Информатика", "Лабораторная работа", "5"));
        items.add(new MyListItem("История", "§14 вопросы письменно", "4"));

        // Create the adapter and set it on the list view
        myListAdapter = new MyListAdapter(this, R.layout.row_my_list_item, items);
        myListView = findViewById(R.id.myListView);
        myListView.setAdapter(myListAdapter);
    }
}
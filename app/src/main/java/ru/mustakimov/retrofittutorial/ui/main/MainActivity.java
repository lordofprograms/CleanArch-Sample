package ru.mustakimov.retrofittutorial.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mustakimov.retrofittutorial.App;
import ru.mustakimov.retrofittutorial.PostModel;
import ru.mustakimov.retrofittutorial.R;
import ru.mustakimov.retrofittutorial.ui.main.adapter.PostsAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new MainFragment()).commit();
        }

    }
}

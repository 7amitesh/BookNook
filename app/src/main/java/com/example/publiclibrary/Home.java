package com.example.publiclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        Button btnbook = findViewById(R.id.btnbook);
        btnbook.setOnClickListener(v -> {
            startActivity(new Intent(Home.this, Book.class));
        });

        Button member = findViewById(R.id.btnmember);
        member.setOnClickListener(v -> {
            startActivity(new Intent(Home.this, Member.class));
        });

        Button lend = findViewById(R.id.btnlendbook);
        lend.setOnClickListener(v -> {
            startActivity(new Intent(Home.this, ReservationActivity.class));
        });

        Button returnbook = findViewById(R.id.btnreturn);
        returnbook.setOnClickListener(v -> {
            startActivity(new Intent(Home.this, ViewReservedBook.class));
        });

//        Button home = findViewById(R.id.btnhome);
//        home.setOnClickListener(v -> {
//            // Refresh the current activity
//            finish(); // Close current instance
//            startActivity(getIntent()); // Restart with same intent
//        });

//        Button store = findViewById(R.id.btnstore);
//        store.setOnClickListener(v -> {
//            startActivity(new Intent(Home.this, ViewBook.class));
//        });

        View rootView = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, systemBars.top, 0, 0); // Only apply top inset for status bar
            return WindowInsetsCompat.CONSUMED;
        });
    }
}

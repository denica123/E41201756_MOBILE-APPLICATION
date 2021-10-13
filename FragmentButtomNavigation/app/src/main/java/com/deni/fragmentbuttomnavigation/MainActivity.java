package com.deni.fragmentbuttomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    //Mendeklarasikan Buttom Navigation
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //agar secara default yang dijalankan pertama kali ketika membuka aplikasi adalah menu chat
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatsFragment()).commit();


        //memberikan aksi apa yang terjadi ketika buttom nya di klik
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //memberikan aksi ketika buttom di klik maka akan memunculkan fragment
                Fragment selectedFragment = null;

                //ketika item nav_chat,nav_status,atau nav_calls yang ada di buttom_navigation dipilih atau di klik maka
                //akan memanggil fragment yang ada di dalam selectionFragment

                switch (item.getItemId()) {
                    case R.id.nav_chats:
                        selectedFragment = new ChatsFragment();
                        break;
                    case R.id.nav_status:
                        selectedFragment = new StatusFragment();
                        break;
                    case R.id.nav_calls:
                        selectedFragment = new CallsFragment();
                        break;
                    case R.id.nav_search:
                        selectedFragment = new SearchFragment();
                        break;
                }

                //fungsi untuk mengubah setiap fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

    }
}
package com.awakelab.oskar.sprintfinalmodulo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.awakelab.oskar.sprintfinalmodulo4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnContactame.setOnClickListener(v -> {
            Intent intentListadoMenu = new Intent(MainActivity.this, ContactameActivity.class);
            startActivity(intentListadoMenu);
        });
    }
}
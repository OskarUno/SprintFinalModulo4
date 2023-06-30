package com.awakelab.oskar.sprintfinalmodulo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.awakelab.oskar.sprintfinalmodulo4.databinding.ActivityContactameBinding;

public class ContactameActivity extends AppCompatActivity {
    private ActivityContactameBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initList();


    }

    private void initList() {
        binding.btnLinkedin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicitIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/posts/sideshowinc_race-toward-productivity-with-the-flash-activity-7061844791638044672-Ugje/?originalSubdomain=uy"));
                startActivity(implicitIntent);
            }
        });




        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
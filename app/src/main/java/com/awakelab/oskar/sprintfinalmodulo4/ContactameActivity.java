package com.awakelab.oskar.sprintfinalmodulo4;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

        String textomail = String.valueOf(binding.editTextMail.getText());
        binding.btnEnviarMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outlookEmail =  getPackageManager().getLaunchIntentForPackage("com.microsoft.office.outlook");
                Intent gmailEmail = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
                if (gmailEmail  != null || outlookEmail !=null) {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","flash@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asunto");
                    emailIntent.putExtra(Intent.EXTRA_TEXT,textomail);
                    startActivity(Intent.createChooser(emailIntent, "Enviar reporte: "));
                }else{
                    Toast.makeText(getBaseContext(), "No posees una aplicación para realizar esta acción.", Toast.LENGTH_LONG).show();
                }

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
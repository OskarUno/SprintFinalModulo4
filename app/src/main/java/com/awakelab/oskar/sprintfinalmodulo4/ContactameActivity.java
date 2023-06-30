package com.awakelab.oskar.sprintfinalmodulo4;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        binding.btnLinkedin2.setOnClickListener(v -> {
            Intent implicitIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/posts/sideshowinc_race-toward-productivity-with-the-flash-activity-7061844791638044672-Ugje/?originalSubdomain=uy"));
            startActivity(implicitIntent);
        });

        binding.btnImgWzp.setOnClickListener(v -> {
            PackageManager pm = getPackageManager();
            try {
                Intent waIntent = new Intent(Intent.ACTION_SEND);
                waIntent.setType("text/plain");
                PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                waIntent.setPackage("com.whatsapp");
                waIntent.putExtra(Intent.EXTRA_TEXT, String.valueOf(binding.editTextMail.getText()));
                startActivity(Intent.createChooser(waIntent, "Compartir con:"));
            } catch (PackageManager.NameNotFoundException e) {
                Toast.makeText(getApplicationContext(), "WhatsApp no esta instalado!", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        binding.btnImgMail.setOnClickListener(v -> {
            String textomails = String.valueOf(binding.editTextMail.getText());
            if(textomails.trim().isEmpty()){
            Toast.makeText(this,"No puede tener el texto vacio",Toast.LENGTH_SHORT).show();
            }else {
                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.setType("text/plain");
                mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"flash@gmail.com"});
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Enviado desde App");//se usará por ejemplo para email
                mailIntent.putExtra(Intent.EXTRA_TEXT, textomails);
                startActivity(Intent.createChooser(mailIntent, "Creando correo...."));
            }
        });

        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }
}
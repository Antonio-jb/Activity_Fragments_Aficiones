package com.antoniojb.misaficiones;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.antoniojb.misaficiones.databinding.ActivitySobreMiBinding;
import com.antoniojb.misaficiones.ui.frmanager.PaginadorSobreMi;

public class SobreMi extends AppCompatActivity {

    private ActivitySobreMiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySobreMiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaginadorSobreMi PaginadorSobreMi = new PaginadorSobreMi(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;

        viewPager.setAdapter(PaginadorSobreMi);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.favButton) {
            Toast toast = Toast.makeText(this, "¡Aquí tienes cosas sobre mi!", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (id == R.id.aficionesButton) {
            Intent intent = new Intent(SobreMi.this, Aficiones.class);
            startActivity(intent);
        }
        if (id == R.id.aboutMeButton) {
            Intent intent = new Intent(SobreMi.this, SobreMi.class);
            startActivity(intent);
        }
        if (id == R.id.myCodeButton) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/Antonio-jb"));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
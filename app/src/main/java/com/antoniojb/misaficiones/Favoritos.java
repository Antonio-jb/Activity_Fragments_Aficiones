package com.antoniojb.misaficiones;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.antoniojb.misaficiones.databinding.ActivityFavoritosBinding;
import com.antoniojb.misaficiones.memoria.FavoritosList;
import com.antoniojb.misaficiones.ui.frmanager.PaginadorFavoritos;

public class Favoritos extends AppCompatActivity {

    private ActivityFavoritosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFavoritosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Aquí se verifica si hay algo añadido en favoritos.
        if (FavoritosList.getInstance().isEmpty()) {
            // Aquí se muestra el mensaje si no hay favoritos.
            binding.nullFavoritos.setVisibility(View.VISIBLE);
        } else {
            // Aquí se muestra el ViewPager si ya hay algo añadido en favoritos.
            binding.nullFavoritos.setVisibility(View.GONE);
        }

        PaginadorFavoritos paginadorFavoritos = new PaginadorFavoritos(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginadorFavoritos);

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

            int currentItem = binding.viewPager.getCurrentItem();
            Fragment currentFragment = getSupportFragmentManager().getFragments().get(currentItem);

            String fragmentName = "";
            if (currentFragment != null) {
                fragmentName = currentFragment.getClass().getSimpleName();
            }

            Toast toast = Toast.makeText(this, "¡Ahora estas en tus " + fragmentName + ".", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (id == R.id.aficionesButton) {
            Intent intent = new Intent(Favoritos.this, Aficiones.class);
            startActivity(intent);
        }
        if (id == R.id.aboutMeButton) {
            Intent intent = new Intent(Favoritos.this, SobreMi.class);
            startActivity(intent);
        }
        if (id == R.id.favoritosButton) {
            Intent intent = new Intent(Favoritos.this, Favoritos.class);
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
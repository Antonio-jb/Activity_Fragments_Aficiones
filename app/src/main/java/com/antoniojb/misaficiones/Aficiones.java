package com.antoniojb.misaficiones;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.antoniojb.misaficiones.databinding.ActivityAficionesBinding;
import com.antoniojb.misaficiones.memoria.FavoritosList;
import com.antoniojb.misaficiones.ui.frmanager.Paginador;

public class Aficiones extends AppCompatActivity {

    private ActivityAficionesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAficionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar el ViewPager con el Paginador de Fragmentos
        Paginador paginador = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.favButton) {
            // Obtener el índice del fragmento actual en el ViewPager
            ViewPager viewPager = binding.viewPager;
            int currentItem = viewPager.getCurrentItem();
            Paginador paginadorAficiones = (Paginador) viewPager.getAdapter();
            Fragment currentFragment = getSupportFragmentManager().getFragments().get(currentItem);

            String fragmentName = "";
            // Verificar que el fragmento no es nulo
            if (currentFragment != null) {
                // Obtener el nombre de la clase del fragmento para mostrarlo en el mensaje
                fragmentName = currentFragment.getClass().getSimpleName();
            } else {
                fragmentName = "Fragmento no disponible";
            }

            // Mostrar un mensaje con el nombre del fragmento que se ha agregado a favoritos
            Toast.makeText(this, "¡Estás viendo mis gusto por: " + fragmentName + "!", Toast.LENGTH_SHORT).show();


            if (paginadorAficiones != null){
                Fragment frActual = paginadorAficiones.getItem(currentItem);
                FavoritosList.getInstance().addFavorito(frActual);
                Toast.makeText(this, "¡Ahora tienes en favoritos el fragmento: " + fragmentName + "!", Toast.LENGTH_SHORT).show();
            }

        }

        if (id == R.id.aficionesButton) {
            Intent intent = new Intent(Aficiones.this, Aficiones.class);
            startActivity(intent);
        }

        if (id == R.id.aboutMeButton) {
            Intent intent = new Intent(Aficiones.this, SobreMi.class);
            startActivity(intent);
        }

        if (id == R.id.favoritosButton) {
            Intent intent = new Intent(Aficiones.this, Favoritos.class);
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

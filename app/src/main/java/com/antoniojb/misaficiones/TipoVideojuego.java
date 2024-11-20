package com.antoniojb.misaficiones;

import static android.app.PendingIntent.getActivity;

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

import com.google.android.material.tabs.TabLayout;
import com.antoniojb.misaficiones.databinding.ActivityTipovideojuegoBinding;
import com.antoniojb.misaficiones.ui.frmanager.PaginadorTipoVideojuego;

public class TipoVideojuego extends AppCompatActivity {

    private ActivityTipovideojuegoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTipovideojuegoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaginadorTipoVideojuego paginador = new PaginadorTipoVideojuego(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);

        TabLayout tabLayout = binding.tipoVideojuegoTabs;
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_tipoVideojuego);
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

            // Obtener el fragmento actual visible en el ViewPager.
            int currentItem = binding.viewPager.getCurrentItem();
            Fragment currentFragment = getSupportFragmentManager().getFragments().get(currentItem);

            // Si el fragmento actual existe se obtiene el nombre de la clase.
            String fragmentName = "";
            if (currentFragment != null) {
                fragmentName = currentFragment.getClass().getSimpleName(); // Aquí se obtiene el nombre de la clase.
            } else {
                // Si no hay fragmento se muestra un mensaje de error.
                fragmentName = "Fragmento no disponible";
            }
            // Mostrar el nombre del fragmento en el Toast.
            Toast toast = Toast.makeText(this, "¡Aquí tienes los videojuegos de tipo: "+ fragmentName +"!", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (id == R.id.aficionesButton) {
            Intent intent = new Intent(TipoVideojuego.this, Aficiones.class);
            startActivity(intent);
        }
        if (id == R.id.aboutMeButton) {
            Intent intent = new Intent(TipoVideojuego.this, SobreMi.class);
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




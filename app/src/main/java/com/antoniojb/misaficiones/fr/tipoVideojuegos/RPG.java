package com.antoniojb.misaficiones.fr.tipoVideojuegos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.antoniojb.misaficiones.R;

public class RPG extends Fragment {

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_videojuego1, container, false);

            // Inflar el layout para el fragmento
            // View view = inflater.inflate(R.layout.fragment_videojuego1, container, false);

            // Mostrar un Toast con el nombre de la clase actual
            // String className = getClass().getSimpleName(); // Obtiene el nombre de la clase
            // Toast.makeText(getContext(), "Estás en el fragmento: " + className, Toast.LENGTH_SHORT).show();

            // return view;
        }
    }



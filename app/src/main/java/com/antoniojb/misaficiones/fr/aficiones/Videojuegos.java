package com.antoniojb.misaficiones.fr.aficiones;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.antoniojb.misaficiones.R;
import com.antoniojb.misaficiones.TipoVideojuego;

public class Videojuegos extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videojuegos, container, false);

        Button button = view.findViewById(R.id.buttonVideojuego);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TipoVideojuego.class);
                startActivity(intent);
            }
        });

        return view;

    }
}


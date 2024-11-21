package com.antoniojb.misaficiones.memoria;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FavoritosList {

    private static FavoritosList instance;
    private final List<Fragment> favoritos;

    private FavoritosList() {
        favoritos = new ArrayList<>();
    }

    public static FavoritosList getInstance() {
        if (instance == null) {
            instance = new FavoritosList();
        }
        return instance;
    }

    public void addFavorito(Fragment fr) {
        if (fr != null && !favoritos.contains(fr)) {
            favoritos.add(fr);
        }
    }

    // Método para obtener la lista de favoritos
    public List<Fragment> getFavoritos() {
        return favoritos;
    }

    // Método para verificar si hay favoritos
    public boolean isEmpty() {
        return favoritos.isEmpty();
    }
}
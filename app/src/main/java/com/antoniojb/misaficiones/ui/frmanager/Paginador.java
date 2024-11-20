package com.antoniojb.misaficiones.ui.frmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.antoniojb.misaficiones.fr.aficiones.Ejercicio;
import com.antoniojb.misaficiones.fr.aficiones.Videojuegos;

public class Paginador extends FragmentPagerAdapter {

    private final Context mContext;

    public Paginador(Context context, FragmentManager fm) {
        super (fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Ejercicio();
            case 1:
                return new Videojuegos();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
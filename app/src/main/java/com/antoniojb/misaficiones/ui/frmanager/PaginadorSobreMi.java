package com.antoniojb.misaficiones.ui.frmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.antoniojb.misaficiones.fr.sobremi.Curso;
import com.antoniojb.misaficiones.fr.sobremi.Foto;
import com.antoniojb.misaficiones.fr.sobremi.Nombre;

public class PaginadorSobreMi extends FragmentPagerAdapter {

    private final Context mContext;

    public PaginadorSobreMi(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Nombre();
            case 1:
                return new Foto();
            case 2:
                return new Curso();
            default:
                return null;
        }
    }

    @Override
    public int getCount() { return 3; }
}
package com.antoniojb.misaficiones.ui.frmanager;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.antoniojb.misaficiones.R;
import com.antoniojb.misaficiones.fr.tipoVideojuegos.RPG;
import com.antoniojb.misaficiones.fr.tipoVideojuegos.Competitivo;

public class PaginadorTipoVideojuego extends FragmentPagerAdapter {

        private final Context mContext;

        public PaginadorTipoVideojuego(Context context, FragmentManager fm) {
            super(fm);
            mContext = context;
        }

        @StringRes
        private static final int[] TITULOS = new int[]{
                R.string.tipovideojuego1,
                R.string.tipovideojuego2
        };

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new RPG();
                case 1:
                    return new Competitivo();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mContext.getResources().getString(TITULOS[position]);
        }
    }



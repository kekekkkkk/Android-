package com.example.chaoxing;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MeFragment  extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup contsiner, Bundle savedInstanceState) {
        View meFragment = inflater.inflate(R.layout.me_layout, contsiner, false);
        return meFragment;
    }
}

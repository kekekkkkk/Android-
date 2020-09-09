package com.example.chaoxing;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup contsiner, Bundle savedInstanceState) {
        View homeFragment = inflater.inflate(R.layout.home_layout, contsiner, false);
        return homeFragment;
    }
}

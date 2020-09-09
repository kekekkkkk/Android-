package com.example.chaoxing;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MessFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup contsiner, Bundle savedInstanceState) {
        View messFragment = inflater.inflate(R.layout.mess_layout, contsiner, false);
        return messFragment;
    }
}

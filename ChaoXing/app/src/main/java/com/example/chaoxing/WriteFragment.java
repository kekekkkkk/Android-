package com.example.chaoxing;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WriteFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup contsiner, Bundle savedInstanceState) {
        View writeFragment = inflater.inflate(R.layout.write_layout, contsiner, false);
        return writeFragment;
    }
}

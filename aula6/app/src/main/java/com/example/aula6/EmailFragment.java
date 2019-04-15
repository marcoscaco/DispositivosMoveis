package com.example.aula6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmailFragment extends Fragment {

    private View view;
    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_email, container, false);
        }
        return view;
    }

}

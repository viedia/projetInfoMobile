package com.pm.heroofmylife;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pierr on 2018-03-24.
 */

public class NormalTodo extends Fragment {
    View view;

    public NormalTodo () {


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.normaltodo,container,false);
        return view;

    }
}

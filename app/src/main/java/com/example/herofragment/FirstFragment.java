package com.example.herofragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFragment extends Fragment {

    private Button btnNavigate;

    public FirstFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        btnNavigate = view.findViewById(R.id.btnNavigate);


        Warrior warrior = new Warrior("Aragorn", 100,34);

        btnNavigate.setOnClickListener(v -> {

            Bundle bundle = new Bundle();
            bundle.putSerializable("warrior", warrior);


            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);


            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, secondFragment)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}

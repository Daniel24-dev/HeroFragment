package com.example.herofragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView tvWarriorInfo;
    private Button btnBackToFirst;

    public SecondFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        tvWarriorInfo = view.findViewById(R.id.tvWarriorInfo);
        btnBackToFirst = view.findViewById(R.id.btnBackToFirst);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Warrior warrior = (Warrior) bundle.getSerializable("warrior");
            if (warrior != null) {

                tvWarriorInfo.setText("Name: " + warrior.getName() + "\nStrength: " + warrior.getHealth() + "\nDamage:" +warrior.getDamage());

            }
        }


        btnBackToFirst.setOnClickListener(v -> {

            getActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }
}


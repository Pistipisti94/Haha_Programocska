package com.example.hahaprogramocska;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hahaprogramocska.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    TextView showCountTextView;
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializáljuk a showCountTextView-t
        showCountTextView = view.findViewById(R.id.textview_first); // Azonosítsd be az XML-ben lévő TextView-t

        binding.randomButton.setOnClickListener(view1 -> NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment));
        view.findViewById(R.id.toast_button).setOnClickListener(view12 -> {
            Toast myToast = Toast.makeText(getActivity(), "Hello Kenyér!", Toast.LENGTH_SHORT);
            Log.d("MyFragment", "Toast() metódus meghívva");

            myToast.show();
        });
        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMe();
            }

            @SuppressLint("SetTextI18n")
            private void countMe() {
                Log.d("MyFragment", "countMe() metódus meghívva");
                if (showCountTextView != null && showCountTextView.getText() != null) {
                    String countString = showCountTextView.getText().toString();
                    int count = Integer.parseInt(countString);
                    count++;
                    showCountTextView.setText(Integer.toString(count));
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
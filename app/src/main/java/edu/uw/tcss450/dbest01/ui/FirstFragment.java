package edu.uw.tcss450.dbest01.ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.dbest01.R;
import edu.uw.tcss450.dbest01.databinding.FragmentFirstBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {
    private FragmentFirstBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonRed.setOnClickListener(this);
        binding.buttonGreen.setOnClickListener(button ->
                processColor(Color.GREEN));
        binding.buttonBlue.setOnClickListener(this::handleBlue);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void processColor(int color) {
        Log.d("ACTIVITY", "Red: " + Color.red(color) +
                " Green: " + Color.green(color) +
                " Blue: " + Color.blue(color));
        FirstFragmentDirections.ActionFirstFragmentToColorFragment directions =
                FirstFragmentDirections.actionFirstFragmentToColorFragment(color);
        Navigation.findNavController(getView()).navigate(directions);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.buttonRed) {
            processColor(Color.RED);
        }
    }

    private void handleBlue(View v) {
        if (v == binding.buttonBlue) {
            processColor(Color.BLUE);
        }
    }
}
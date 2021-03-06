package edu.uw.tcss450.dbest01.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.dbest01.R;
import edu.uw.tcss450.dbest01.databinding.FragmentColorBinding;
import edu.uw.tcss450.dbest01.databinding.FragmentFirstBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {
    private FragmentColorBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentColorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ColorFragmentArgs args = ColorFragmentArgs.fromBundle((getArguments()));

        binding.textLabel.setTextColor(args.getColor());
    }

    private void updateContent(int color) {
        binding.textLabel.setTextColor(color);
    }
}
package edu.uw.tcss450.dbest01.ui;

import android.graphics.Color;
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
        updateColorTextLabel(args.getColor());
    }

    private void updateContent(int color) {
        binding.textLabel.setTextColor(color);
    }

    private void updateColorTextLabel(int colorInt) {
        String colorString = String.format("#%06X", 0xFFFFFF & colorInt);
        switch (colorInt) {
            case Color.RED:
                binding.textLabel.setText(R.string.text_red);
                break;
            case Color.BLUE:
                binding.textLabel.setText(R.string.text_blue);
                break;
            case Color.GREEN:
                binding.textLabel.setText(R.string.text_green);
                break;
            default:
                binding.textLabel.setText(String.format("#%06X", 0xFFFFFF & colorInt));
                break;
        }
    }
}
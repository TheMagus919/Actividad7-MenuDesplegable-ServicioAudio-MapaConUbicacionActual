package com.agusoft.actividad7.ui.home;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.agusoft.actividad7.R;
import com.agusoft.actividad7.databinding.FragmentHomeBinding;
import com.google.android.gms.maps.SupportMapFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Context context;
    private HomeViewModel hm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        hm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(HomeViewModel.class);
        hm.mapeoPermanente();
        hm.getMp().observe(getViewLifecycleOwner(), new Observer<HomeViewModel.MapaActual>() {
            @Override
            public void onChanged(HomeViewModel.MapaActual mapaActual) {
                SupportMapFragment supportMapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                supportMapFragment.getMapAsync(mapaActual);
            }
        });
        hm.obtenerMapa();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
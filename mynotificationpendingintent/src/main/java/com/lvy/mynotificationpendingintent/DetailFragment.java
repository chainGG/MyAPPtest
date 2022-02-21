package com.lvy.mynotificationpendingintent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn=getView().findViewById(R.id.button2);

        Bundle args=getArguments();
        if (args!=null ){
           String name =args.getString("name");
           if (name!=null){
               Log.e("li","name:"+name);
           }
            String params =args.getString("params");
            if (params!=null){
                Log.e("li","params:"+params);
            }
        }

        btn.setOnClickListener(v -> {
            NavController navController= Navigation.findNavController(v);
            navController.navigate(R.id.action_detailFragment_to_mainFragment);
        });

    }
}
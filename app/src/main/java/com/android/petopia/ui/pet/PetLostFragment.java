package com.android.petopia.ui.pet;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.petopia.R;
import com.android.petopia.adapter.PetAdapter;
import com.android.petopia.event.MessageEvent;
import com.android.petopia.model.Pet;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PetLostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PetLostFragment extends Fragment {
    List<Pet> listPet = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PetLostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PetLostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PetLostFragment newInstance(String param1, String param2) {
        PetLostFragment fragment = new PetLostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pet_lost, container, false);
        RecyclerView rvPetLost = (RecyclerView) view.findViewById(R.id.rvPetLost);
//B1 data
        initData();

        //B2 Adapter
        PetAdapter adapter = new PetAdapter(getActivity(), listPet);

        //B3 Layout Manager
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        //B4 RecycleView
        rvPetLost.setLayoutManager(layoutManager);
        rvPetLost.setAdapter(adapter);
        return view;
    }


    private void initData() {
        for (int i = 0; i < 10; i++) {
            Pet pet = new Pet(1 + i,
                    "Little Boo " + i,
                    i + " month",
                    "Chihuahua",
                    "DaNang,VietNam",
                    "Female",
                    "",
                    "",
                    "",
                    "");
            listPet.add(pet);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void goToDetail(Pet pet) {
        Intent intent = new Intent(getActivity(), DetailPetActivity.class);
        intent.putExtra("PET", pet);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent.PetEvent petEvent) {
        Pet pet = petEvent.getPet();
        Log.d("TAG", "onMessageEvent: " + pet.getName());
        goToDetail(pet);
    }
}

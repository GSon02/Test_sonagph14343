package com.example.test_sonagph14343.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test_sonagph14343.Adapter.SachAdapter;
import com.example.test_sonagph14343.Database.SachHelper;
import com.example.test_sonagph14343.model.Sach;
import com.example.test_sonagph14343.R;

import java.util.List;

public class HienThiFragment extends Fragment {
    private RecyclerView rcvMain;

    private List<Sach> sachList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hien_thi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvMain = view.findViewById(R.id.rcvMain);
        SachHelper sachHelper = new SachHelper(getContext());
        sachList = sachHelper.getAllSach();
        SachAdapter sachAdapter = new SachAdapter(sachList);

        rcvMain.setAdapter(sachAdapter);
        rcvMain.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        rcvMain.setLayoutManager(linearLayoutManager);
    }
}
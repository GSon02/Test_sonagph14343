package com.example.test_sonagph14343.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.test_sonagph14343.Database.SachHelper;
import com.example.test_sonagph14343.R;
import com.example.test_sonagph14343.model.Sach;
import com.google.android.material.textfield.TextInputLayout;

public class ThemFragment extends Fragment {
    private TextInputLayout tilID;
    private TextInputLayout tilName;
    private TextInputLayout tilEmail;
    private Button btnThem;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_them, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tilID = (TextInputLayout) view.findViewById(R.id.tilID);
        tilName = (TextInputLayout) view.findViewById(R.id.tilName);
        tilEmail = (TextInputLayout) view.findViewById(R.id.tilEmail);
        btnThem = (Button) view.findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = tilID.getEditText().getText().toString();
                String name = tilName.getEditText().getText().toString();
                String email = tilEmail.getEditText().getText().toString();

                Sach sach = new Sach(Integer.parseInt(id),name,email);
                SachHelper sachHelper = new SachHelper(getContext());
                long check = sachHelper.insertSach(sach);
                if(check < 0){
                    Toast.makeText(getContext(), "Lỗi Thêm !!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Thêm Thành Công !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
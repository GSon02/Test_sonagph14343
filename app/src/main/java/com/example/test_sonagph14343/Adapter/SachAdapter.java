package com.example.test_sonagph14343.Adapter;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_sonagph14343.Database.SachHelper;
import com.example.test_sonagph14343.model.Sach;
import com.example.test_sonagph14343.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.SachHolder> {
    private TextInputLayout tilID;
    private TextInputLayout tilName;
    private TextInputLayout tilEmail;
    private Button btnThem;
    private List<Sach>sachList;
    private AlertDialog alertDialog;
    private SachHelper sachHelper;

    public SachAdapter(List<Sach> sachList) {
        this.sachList = sachList;
    }

    @NonNull
    @Override
    public SachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new SachHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SachHolder holder,int position) {
        final Sach sach =sachList.get(position);
        holder.tvRow.setText(sach.toString());
        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sachHelper = new SachHelper(v.getContext());
                sachHelper.deleteSach(sach);
                sachList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });

        holder.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                View view = LayoutInflater.from(v.getContext()).inflate(R.layout.fragment_sua,null);

                builder.setView(view);

                tilID = (TextInputLayout) view.findViewById(R.id.tilID);
                tilName = (TextInputLayout) view.findViewById(R.id.tilName);
                tilEmail = (TextInputLayout) view.findViewById(R.id.tilEmail);
                btnThem = (Button) view.findViewById(R.id.btnThem);

                tilID.getEditText().setText(String.valueOf(sach.getID()));
                tilID.setEnabled(false);
                builder.setView(view);

                btnThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String id = tilID.getEditText().getText().toString();
                        String name = tilName.getEditText().getText().toString();
                        String ma = tilEmail.getEditText().getText().toString();
                        sach.setID(Integer.parseInt(id));
                        sach.setName(name);
                        sach.setEmail(ma);

                        sachHelper = new SachHelper(v.getContext());
                        long check = sachHelper.updateSach(sach);
                        if (check<0){
                            Toast.makeText(v.getContext(), "Lỗi sửa", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(v.getContext(), "Sửa thành công!", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                        notifyItemChanged(holder.getAdapterPosition());
                        alertDialog.dismiss();
                    }
                });
                alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sachList.size();
    }

    public class SachHolder extends RecyclerView.ViewHolder {

        private TextView tvRow;
        private Button btnSua;
        private Button btnXoa;
        public SachHolder(@NonNull View itemView) {
            super(itemView);

            tvRow = (TextView) itemView.findViewById(R.id.tvRow);
            btnSua = (Button) itemView.findViewById(R.id.btnSua);
            btnXoa = (Button) itemView.findViewById(R.id.btnXoa);
        }
    }
}
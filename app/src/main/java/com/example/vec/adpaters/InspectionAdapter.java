package com.example.vec.adpaters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vec.R;
import com.example.vec.databinding.InspectionListItemBinding;
import com.example.vec.models.InspectionModel;

import java.util.ArrayList;

public class InspectionAdapter extends RecyclerView.Adapter<InspectionAdapter.InspectionViewHolder> {

    public ArrayList<InspectionModel> inspectionList = new ArrayList();
    TakePhotoAtMainActivity takePhotoAtMainActivity;
    int pos;
    Bitmap bitmap;
    Context context;

    public InspectionAdapter(TakePhotoAtMainActivity takePhotoAtMainActivity, Context context) {
        this.takePhotoAtMainActivity = takePhotoAtMainActivity;
        this.context = context;
    }

    @NonNull
    @Override
    public InspectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        InspectionListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.inspection_list_item
                , parent, false);
        return new InspectionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InspectionViewHolder holder, int position) {
        holder.binding.partName.setText(inspectionList.get(position).getPartName());
        bitmap = BitmapFactory.decodeFile(inspectionList.get(position).getProblemImagePath());
        holder.binding.ProblemPhoto2.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return inspectionList.size();
    }

    public void setList(ArrayList<InspectionModel> List) {
        this.inspectionList = List;
        notifyDataSetChanged();
    }

    public void setImageDataProblem(String path) {
        inspectionList.get(pos).setProblemImagePath(path);
        notifyItemChanged(pos);
    }

    public void setImageDataSol(String path) {
        inspectionList.get(pos).setSolutionImagePath(path);
        notifyItemChanged(pos);
    }

    public class InspectionViewHolder extends RecyclerView.ViewHolder {

        InspectionListItemBinding binding;
        Dialog dialog;

        public InspectionViewHolder(@NonNull InspectionListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.fixSpinner.setOnClickListener(view -> {
                dialog = new Dialog(context);
                dialog.setContentView(R.layout.dilaog_sreach_spinner);
                dialog.getWindow().setLayout(800, 1200);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                EditText editText = dialog.findViewById(R.id.problem_editText);
                ListView listView = dialog.findViewById(R.id.Problem_listView);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, inspectionList.get(1).getSolutionSpinnerItems());
                listView.setAdapter(adapter);
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                listView.setOnItemClickListener((adapterView, view1, i, l) -> {
                    binding.fixSpinner.setText(adapter.getItem(i));
                    inspectionList.get(getAdapterPosition()).setSolutionSpinnerData(adapter.getItem(i));
                    dialog.dismiss();
                });
            });
            binding.problemSpinner.setOnClickListener(view -> {

                dialog = new Dialog(context);
                dialog.setContentView(R.layout.dilaog_sreach_spinner);
                dialog.getWindow().setLayout(800, 1200);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                EditText editText = dialog.findViewById(R.id.problem_editText);
                ListView listView = dialog.findViewById(R.id.Problem_listView);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, inspectionList.get(1).getProblemSpinnerItems());
                listView.setAdapter(adapter);
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                listView.setOnItemClickListener((adapterView, view1, i, l) -> {
                    binding.problemSpinner.setText(adapter.getItem(i));
                    inspectionList.get(getAdapterPosition()).setProblemSpinnerData(adapter.getItem(i));
                    dialog.dismiss();
                });
            });
            binding.problemPhoto.setOnClickListener(view -> {
                pos = getAdapterPosition();
                takePhotoAtMainActivity.whenUserClick(1);
            });
            binding.fixPhoto.setOnClickListener(view -> {
                pos = getAdapterPosition();
                takePhotoAtMainActivity.whenUserClick(2);
            });
        }
    }

}

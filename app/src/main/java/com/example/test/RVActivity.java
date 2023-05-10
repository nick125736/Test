package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {

    public class BMIdata {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        String name;
        double height;
        double weight;

        public double getBmi() {
            return bmi;
        }

        public void setBmi(double bmi) {
            this.bmi = bmi;
        }

        double bmi;
    }

    public class BMIAdapter extends RecyclerView.Adapter<BMIAdapter.ViewHolder>{

        private ArrayList<BMIdata> bmIdataList;

        public class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView name;
            private final TextView height;
            private final TextView weight;
            private final TextView bmi;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name = findViewById(R.id.tvRowName);
                height = findViewById(R.id.tvRowHeight);
                weight = findViewById(R.id.tvRowWeight);
                bmi = findViewById(R.id.tvRowBMI);
            }
        }

        public BMIAdapter(ArrayList<BMIdata> bmIdataList) {
            this.bmIdataList = bmIdataList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.rowdata,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            BMIdata bmIdata = bmIdataList.get(position);
            holder.name.setText(bmIdata.getName());
            holder.height.setText(String.valueOf(bmIdata.getHeight()));
            holder.weight.setText(String.valueOf(bmIdata.getWeight()));
            holder.bmi.setText(String.valueOf(bmIdata.getBmi()));
        }

        @Override
        public int getItemCount() {
            return bmIdataList.size();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);
    }
}
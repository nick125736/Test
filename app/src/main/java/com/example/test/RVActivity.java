package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {

    public static class BMIdata {
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

        public ArrayList<BMIdata> bmIdataList;

        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView name;
            private TextView height;
            private TextView weight;
            private TextView bmi;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name =  itemView.findViewById(R.id.tvRowName);
                height = itemView.findViewById(R.id.tvRowHeight);
                weight = itemView.findViewById(R.id.tvRowWeight);
                bmi = itemView.findViewById(R.id.tvRowBMI);
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
            Log.d("BMIdata>>>",bmIdata.getName());
            holder.name.setText(bmIdata.getName());
            holder.height.setText(String.valueOf(bmIdata.getHeight()));
            holder.weight.setText(String.valueOf(bmIdata.getWeight()));
            holder.bmi.setText(String.valueOf(bmIdata.getBmi()));
        }

        @Override
        public int getItemCount() {
            Log.d("SIZE>>>>", String.valueOf(bmIdataList.size()));

            return bmIdataList.size();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);

        ArrayList<BMIdata> bmIdataArrayList = new ArrayList<>();
        BMIdata a = new BMIdata();
        for (int i = 0; i < 10; i++) {
            a.setName("cflin");
            a.setHeight(180.2+i);
            a.setWeight(80.5+i);
            a.setBmi(20.05+i);
            bmIdataArrayList.add(a);
        }
//        Log.d("SIZE>>>", String.valueOf(bmIdataArrayList.size()));
        RecyclerView recyclerView = findViewById(R.id.rvBMI);
        BMIAdapter adapter = new BMIAdapter(bmIdataArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(RVActivity.this));
        recyclerView.setAdapter(adapter);

        BMIdata b = new BMIdata();
        b.setName("AAAAAAA");
        b.setHeight(100);
        b.setWeight(50);
        b.setBmi(20);
        bmIdataArrayList.add(b);

    }
}
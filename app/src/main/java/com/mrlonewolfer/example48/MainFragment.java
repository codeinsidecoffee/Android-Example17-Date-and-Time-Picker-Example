package com.mrlonewolfer.example48;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    Button btnDatePicker,btnTimePicker;
    TextView txtResult;
    private int mYear, mMonth, mDay, mHour, mMinute;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        btnDatePicker=view.findViewById(R.id.btnDatePicker);
        btnTimePicker=view.findViewById(R.id.btnTimePicker);
        txtResult=view.findViewById(R.id.txtResult);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btnDatePicker){
            getcalenderInfo();
            DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    txtResult.setText("Date is: "+dayOfMonth+"-"+month+"-"+year);
                }
            },mYear,mMonth,mDay);
        datePickerDialog.show();
        }
        if(v.getId()==R.id.btnTimePicker){
            getcalenderInfo();
            TimePickerDialog timePickerDialog= new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    if(hourOfDay<=12){

                        txtResult.setText("Date is: "+hourOfDay+":"+minute+"A.M");
                    }
                    else
                    {

                        hourOfDay=hourOfDay-12;
                        txtResult.setText("Date is: "+hourOfDay+":"+minute+"P.M");
                    }

                }
            },mHour,mMinute,false);
            timePickerDialog.show();

        }

    }

    private void getcalenderInfo() {
        Calendar calendar=Calendar.getInstance();
        mYear=calendar.get(Calendar.YEAR);
        mMonth=calendar.get(Calendar.MONTH);
        mDay=calendar.get(Calendar.DAY_OF_MONTH);
        mHour=calendar.get(Calendar.HOUR);
        mMinute=calendar.get(Calendar.MINUTE);
    }
}

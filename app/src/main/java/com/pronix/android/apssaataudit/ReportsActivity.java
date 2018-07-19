package com.pronix.android.apssaataudit;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.pronix.android.apssaataudit.custom.XYMarkerView;
import com.pronix.android.apssaataudit.db.DBManager;
import com.pronix.android.apssaataudit.pojo.Format4Apojo;
import com.pronix.android.apssaataudit.render.ReportsAdapter4A;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ReportsActivity extends BaseActivity implements View.OnClickListener {

    private ArrayList<Format4Apojo> reports4A = new ArrayList<Format4Apojo>();
    Bundle bundle;
    RecyclerView rcyVw_reports;
    ReportsAdapter4A mAdapter;
    Context mCon = this;

    static  String dateType="";
    RelativeLayout fromDateLayout, toDateLayout;
    static TextView fromDateTxt, toDateTxt;
    int year, month, day;
    Button getReportsBtn, but_GetGraphReport;
    BarChart barChart;
    String sFromDate, sToDate;
    LinearLayout format4Aview;
    TextView format4Aheader,nodata;
    public static ArrayList<BarEntry> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_reports);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        initializeControls();

        final Calendar c = Calendar.getInstance();
        year  = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day   = c.get(Calendar.DAY_OF_MONTH);

    }

    public void initializeControls()
    {
        rcyVw_reports = (RecyclerView) findViewById(R.id.rcyVw_reports);
        bundle = getIntent().getExtras();
        mAdapter = new ReportsAdapter4A(mCon, reports4A);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcyVw_reports.setLayoutManager(mLayoutManager);
        rcyVw_reports.setNestedScrollingEnabled(false);
        rcyVw_reports.setAdapter(mAdapter);
        getReportsBtn = (Button) findViewById(R.id.getReportsBtn);
        but_GetGraphReport = (Button) findViewById(R.id.but_GetGraphReports);
        but_GetGraphReport.setOnClickListener(this);
        format4Aheader = (TextView) findViewById(R.id.format4Aheader);
        format4Aview = (LinearLayout) findViewById(R.id.format4Aview);
        nodata = (TextView) findViewById(R.id.nodata);

        fromDateLayout = (RelativeLayout) findViewById(R.id.fromDateLayout);
        toDateLayout = (RelativeLayout) findViewById(R.id.toDateLayout);

        fromDateTxt = (TextView) findViewById(R.id.fromDateTxt);
        toDateTxt = (TextView) findViewById(R.id.toDateTxt);

        barChart = (BarChart) findViewById(R.id.barchart);

        fromDateLayout.setOnClickListener(this);
        toDateLayout.setOnClickListener(this);
        getReportsBtn.setOnClickListener(this);
    }
    
    public void loadFormat4Areports(String fromDate, String toDate){
        reports4A.clear();
        try {

            Cursor cursorFormat4A =
                    DBManager.getInstance().getRawQuery("SELECT * FROM format4A Where date(created_date) BETWEEN date('" + fromDate + "') AND date('" + toDate + "')");
            //if the cursor has some data

            if (cursorFormat4A.moveToFirst()) {
                //looping through all the records
                int count = 1;
                do {
                    reports4A.add(new Format4Apojo(
                            String.valueOf(count++),
                            cursorFormat4A.getString(2),
                            cursorFormat4A.getString(3),
                            cursorFormat4A.getString(4),
                            cursorFormat4A.getString(5),
                            cursorFormat4A.getString(6),
                            cursorFormat4A.getString(7),
                            cursorFormat4A.getString(8),
                            cursorFormat4A.getString(9),
                            cursorFormat4A.getString(10),
                            cursorFormat4A.getString(11),
                            cursorFormat4A.getString(12),
                            cursorFormat4A.getString(13),
                            cursorFormat4A.getString(14),
                            cursorFormat4A.getString(15),
                            cursorFormat4A.getString(16),
                            cursorFormat4A.getString(17),
                            cursorFormat4A.getString(18),
                            cursorFormat4A.getString(19),
                            cursorFormat4A.getString(20),
                            cursorFormat4A.getString(21),
                            cursorFormat4A.getString(22),
                            cursorFormat4A.getString(23),
                            cursorFormat4A.getString(24),
                            cursorFormat4A.getString(25),
                            cursorFormat4A.getString(26),
                            cursorFormat4A.getString(27)));

                    System.out.println("in db date: " + cursorFormat4A.getString(22));
                } while (cursorFormat4A.moveToNext());
            }
            //closing the cursor
            cursorFormat4A.close();
            System.out.println("Format 4A Size: " + reports4A.size());
            loadListView(reports4A);
        }catch (SQLException error){
            System.out.println(error.toString());
        }
    }

    private void loadListView(ArrayList<Format4Apojo> reports4A) {
        if (reports4A.size() > 0) {
            mAdapter = new ReportsAdapter4A(mCon, reports4A);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            rcyVw_reports.setLayoutManager(mLayoutManager);
            rcyVw_reports.setAdapter(mAdapter);
            format4Aheader.setVisibility(View.VISIBLE);
            format4Aview.setVisibility(View.VISIBLE);
            nodata.setVisibility(View.GONE);
        } else {
            format4Aheader.setVisibility(View.GONE);
            format4Aview.setVisibility(View.GONE);
            nodata.setVisibility(View.VISIBLE);
            Toast.makeText(ReportsActivity.this, "No data found for the selected dates.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fromDateLayout:
                showDatePickerDialog();
                dateType = "FromDate";
                break;
            case R.id.toDateLayout:
                showDatePickerDialog();
                dateType = "ToDate";
                break;
            case R.id.getReportsBtn:
//                barChart.setVisibility(View.GONE);
                sFromDate = fromDateTxt.getText().toString();
                sToDate = toDateTxt.getText().toString();
                if(this.sFromDate.length() == 0 || this.sFromDate.isEmpty() || sFromDate.equalsIgnoreCase("from date") ||
                        this.sToDate.length() == 0 || this.sToDate.isEmpty() || sToDate.equalsIgnoreCase("to date") ){
                    Toast.makeText(ReportsActivity.this, "Both the dates are required",Toast.LENGTH_SHORT).show();
                }else{
                    loadFormat4Areports(sFromDate,sToDate);
                }
                break;
            case R.id.but_GetGraphReports:
                sFromDate = fromDateTxt.getText().toString();
                sToDate = toDateTxt.getText().toString();
                if(this.sFromDate.length() == 0 || this.sFromDate.isEmpty() || sFromDate.equalsIgnoreCase("from date") ||
                        this.sToDate.length() == 0 || this.sToDate.isEmpty() || sToDate.equalsIgnoreCase("to date") ){
                    Toast.makeText(ReportsActivity.this, "Both the dates are required",Toast.LENGTH_SHORT).show();
                }else{
                barChart.setVisibility(View.VISIBLE);
                format4Aheader.setVisibility(View.GONE);
                format4Aview.setVisibility(View.GONE);
                loadLabels();}
                break;
        }
    }

    public void showDatePickerDialog() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            int month1 = month+1;
            String inputTimeStamp = year+"-"+month1+"-"+day;
            System.out.println("dateformat: "+ inputTimeStamp);
            final String inputFormat = "yyyy-MM-dd";
            final String outputFormat = "yyyy-MM-dd";
            try {
                if (dateType.equalsIgnoreCase("FromDate")){
                    fromDateTxt.setText( TimeStampConverter(inputFormat, inputTimeStamp, outputFormat));
                }else  if (dateType.equalsIgnoreCase("ToDate")){
                    toDateTxt.setText(TimeStampConverter(inputFormat, inputTimeStamp, outputFormat));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            };
        }
    }

    private static String TimeStampConverter(final String inputFormat,
                                             String inputTimeStamp, final String outputFormat)
            throws ParseException {
        return new SimpleDateFormat(outputFormat).format(new SimpleDateFormat(
                inputFormat).parse(inputTimeStamp));
    }

    public void loadLabels()
    {
        Cursor c = null;
        String[] labels = new String[100];
        entries = new ArrayList<>();
        String query = "SELECT count(*), categoryone from format4A Where date(created_date) BETWEEN date('" + sFromDate + "') AND date('" + sToDate + "') Group by categoryone";
        c = DBManager.getInstance().getRawQuery(query);
        int i = 0;
        if(c.moveToFirst())
        {
            do {
                labels[i] = c.getString(1);
                entries.add(new BarEntry(i++, c.getInt(0)));

            }while (c.moveToNext());
        }


        if(entries.size() == 0)
        {
            barChart.clear();
        }
        else {
            IAxisValueFormatter xAxisFormatter = new LabelFormatter(labels);

//            barChart.getXAxis().setValueFormatter(xAxisFormatter);
            XAxis xAxis = barChart.getXAxis();
            xAxis.setGranularity(1f);
            xAxis.setGranularityEnabled(true);

            BarDataSet dataSets = new BarDataSet(entries, "Issues");
            dataSets.setColors(Color.rgb(1, 174, 240));
            BarData data = new BarData(dataSets);
            data.setBarWidth(0.4f);

            XYMarkerView mv = new XYMarkerView(this, xAxisFormatter);
            mv.setChartView(barChart); // For bounds control
            barChart.setMarker(mv); // Set the marker to the chart

//
            barChart.setData(data);
        }
    }

    public class LabelFormatter implements IAxisValueFormatter {
            private final String[] mLabels;

            public LabelFormatter(String[] labels) {
                mLabels = labels;
            }

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mLabels[(int) value];
            }
    }

}

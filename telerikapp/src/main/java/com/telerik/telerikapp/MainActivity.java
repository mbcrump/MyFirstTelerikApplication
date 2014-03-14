package com.telerik.telerikapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.telerik.widget.chart.visualization.cartesianChart.RadCartesianChartView;
import com.telerik.widget.chart.engine.databinding.DataPointBinding;
import com.telerik.widget.chart.visualization.cartesianChart.series.categorical.LineSeries;
import com.telerik.widget.chart.visualization.cartesianChart.axes.CategoricalAxis;
import com.telerik.widget.chart.visualization.cartesianChart.axes.LinearAxis;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private List<MonthResult> monthResults;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitData();

        RadCartesianChartView chartView = new RadCartesianChartView(this.getBaseContext());

        ViewGroup rootView = (ViewGroup)findViewById(R.id.container);
        rootView.addView(chartView);

        LineSeries lineSeries = new LineSeries(this.getBaseContext());
        lineSeries.setCategoryBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) {
                return ((MonthResult) o).getMonth();
            }
        });

        lineSeries.setValueBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) {
                return ((MonthResult) o).getResult();
            }
        });
        lineSeries.setData(this.monthResults);
        chartView.getSeries().add(lineSeries);

        CategoricalAxis horizontalAxis = new CategoricalAxis(this.getBaseContext());
        chartView.setHorizontalAxis(horizontalAxis);

        LinearAxis verticalAxis = new LinearAxis(this.getBaseContext());
        chartView.setVerticalAxis(verticalAxis);

    }

    private void InitData() {
        monthResults = new ArrayList<MonthResult>();
        monthResults.add(new MonthResult("Jan", 12));
        monthResults.add(new MonthResult("Feb", 5));
        monthResults.add(new MonthResult("Mar", 10));
        monthResults.add(new MonthResult("Apr", 7));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}

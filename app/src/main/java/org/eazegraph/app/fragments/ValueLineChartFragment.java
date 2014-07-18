/**
 *
 *   Copyright (C) 2014 Paul Cech
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.eazegraph.app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.eazegraph.app.R;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.communication.IOnPointFocusedListener;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

public class ValueLineChartFragment extends ChartFragment {


    public ValueLineChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_value_line_chart, container, false);
        mValueLineChart = (ValueLineChart) view.findViewById(R.id.linechart);
        mValueLineChart2 = (ValueLineChart) view.findViewById(R.id.linechart2);
        mValueLineChart.setUseLegend(true);
        mValueLineChart2.setUseLegend(false);
        loadData();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mValueLineChart.startAnimation();
        mValueLineChart2.startAnimation();
    }

    @Override
    public void restartAnimation() {
        mValueLineChart.startAnimation();
        mValueLineChart2.startAnimation();
    }

    private void loadData() {


        ValueLineSeries series = new ValueLineSeries();
        series.setColor(0xFF63CBB0);

        series.addPoint(new ValueLinePoint(1.4f));
        series.addPoint(new ValueLinePoint(4.4f));
        series.addPoint(new ValueLinePoint(2.4f));
        series.addPoint(new ValueLinePoint(3.2f));
        series.addPoint(new ValueLinePoint(2.6f));
        series.addPoint(new ValueLinePoint(5.0f));
        series.addPoint(new ValueLinePoint(3.5f));
        series.addPoint(new ValueLinePoint(2.4f));
        series.addPoint(new ValueLinePoint(0.4f));
        series.addPoint(new ValueLinePoint(3.4f));
        series.addPoint(new ValueLinePoint(2.5f));
        series.addPoint(new ValueLinePoint(1.0f));
        series.addPoint(new ValueLinePoint(4.2f));
        series.addPoint(new ValueLinePoint(2.4f));
        series.addPoint(new ValueLinePoint(3.6f));
        series.addPoint(new ValueLinePoint(1.0f));
        series.addPoint(new ValueLinePoint(2.5f));
        series.addPoint(new ValueLinePoint(2.0f));
        series.addPoint(new ValueLinePoint(1.4f));

        mValueLineChart.addSeries(series);
        mValueLineChart.setOnPointFocusedListener(new IOnPointFocusedListener() {
            @Override
            public void onPointFocused(int _PointPos) {
                Log.d("Test", "Pos: " + _PointPos);
            }
        });
        mValueLineChart2.addSeries(series);
        mValueLineChart2.setOnPointFocusedListener(new IOnPointFocusedListener() {
            @Override
            public void onPointFocused(int _PointPos) {
                Log.d("Test", "Pos: " + _PointPos);
            }
        });

    }

    private ValueLineChart mValueLineChart;
    private ValueLineChart mValueLineChart2;
}

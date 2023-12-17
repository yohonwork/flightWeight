package work.yohon.weight;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;

import work.yohon.weight.common.Utils;
import work.yohon.weight.controller.MainController;

public class MainActivity extends AppCompatActivity {

    private MainController controller = new MainController(this);

    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(Utils.getLayout(this, "activity_main"));
        controller.createLayer();
//        ArrayList<Entry> entryChart1 = new ArrayList<>();
//
//        lineChart = (LineChart) findViewById(R.id.linechart);
//
//        LineData chartData = new LineData();
//
//        entryChart1.add(new Entry(1, 1));
//        entryChart1.add(new Entry(2, 2));
//        entryChart1.add(new Entry(3, 3));
//        entryChart1.add(new Entry(4, 4));
//        entryChart1.add(new Entry(5, 2));
//        entryChart1.add(new Entry(6, 7));
//
//        LineDataSet lineDataSet = new LineDataSet(entryChart1, "LineGraph1");
//        lineDataSet.setColor(Color.RED);
//        chartData.addDataSet(lineDataSet);
//
//        lineChart.setData(chartData);
//        lineChart.invalidate();
//        lineChart.setTouchEnabled(false);

    }
}
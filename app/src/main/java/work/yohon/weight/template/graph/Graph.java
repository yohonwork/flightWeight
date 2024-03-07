package work.yohon.weight.template.graph;

import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import work.yohon.weight.common.Utils;
import work.yohon.weight.repository.PointRepository;
import work.yohon.weight.repository.entity.Point;
import work.yohon.weight.repository.entity.Type;
import work.yohon.weight.template.finalplan.IndexDto;

public class Graph {

    private final AppCompatActivity context;
    private Type type;
    private IndexDto indexDto;
    private PointRepository repository;

    public Graph(AppCompatActivity context,Type type, IndexDto indexDto) {
        this.context    = context;
        this.type       = type;
        this.indexDto   = indexDto;
        this.repository = new PointRepository();
        writeGraph();
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private void writeGraph() {

        if (isNull(indexDto) || isNull(indexDto.getZfw()) || isNull(indexDto.getLdw()) || isNull(indexDto.getTow()) || isNull(indexDto.getLdwIndex()) || isNull(indexDto.getTowIndex()) || isNull(indexDto.getZfwIndex())) {
            return;
        }

        LineChart linechart = (LineChart) Utils.findViewId(this.context, "linechart");
        List<Point> pointList = repository.findByTypeSeqAndAircraft(type.getSeq(), type.getAircraft());

        settingChartStyle(linechart);
        drawAxis(linechart);

        LineData chartData = new LineData();

        ArrayList<Entry> zfw = new ArrayList<>();
        ArrayList<Entry> tow = new ArrayList<>();
        ArrayList<Entry> ldw = new ArrayList<>();

        LineDataSet mtowLineDataSet = getMTOWDataSet(pointList);
        chartData.addDataSet(mtowLineDataSet);
        LineDataSet mldwLineDataSet = getMLDWDataSet(pointList);
        chartData.addDataSet(mldwLineDataSet);
        LineDataSet mzfwLineDataSet = getMZFWDataSet(pointList);
        chartData.addDataSet(mzfwLineDataSet);
        LineDataSet mzfwLineDataSet2 = getMZFW2DataSet(pointList);
        chartData.addDataSet(mzfwLineDataSet2);

        zfw.add(new Entry(indexDto.getZfwIndex().floatValue(), indexDto.getZfw().floatValue()));
        tow.add(new Entry(indexDto.getTowIndex().floatValue(), indexDto.getTow().floatValue()));
        ldw.add(new Entry(indexDto.getLdwIndex().floatValue(), indexDto.getLdw().floatValue()));

        LineDataSet zfwDataSet = new LineDataSet(zfw, "CG ZFW");
        LineDataSet towDataSet = new LineDataSet(tow, "CG TOW");
        LineDataSet ldwDataSet = new LineDataSet(ldw, "CG LDW");

        zfwDataSet.setColor(Color.YELLOW);
        zfwDataSet.setCircleColor(Color.YELLOW);
        towDataSet.setColor(Color.RED);
        towDataSet.setCircleColor(Color.RED);
        ldwDataSet.setColor(Color.DKGRAY);
        ldwDataSet.setCircleColor(Color.DKGRAY);

        chartData.addDataSet(zfwDataSet);
        chartData.addDataSet(towDataSet);
        chartData.addDataSet(ldwDataSet);

        linechart.setData(chartData);
        linechart.invalidate();
        linechart.setTouchEnabled(false);
    }

    private void settingChartStyle(LineChart lineChart) {
        lineChart.setDrawGridBackground(true); // 차트격자그리드 적용
        lineChart.setDrawBorders(true);        // 차트격자선진하게
    }

    private void drawAxis(LineChart linechart) {
        XAxis xAxis = linechart.getXAxis();
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0.0f);
        xAxis.setAxisMaximum(120f);
        xAxis.setLabelCount(10);

        YAxis yAxis = linechart.getAxisLeft();
        yAxis.setAxisMaximum(92000);
        yAxis.setAxisMinimum(45000);
        yAxis.setDrawAxisLine(true);
        yAxis.setGranularity(1000);
        yAxis.setLabelCount(10);

        YAxis yAxisRight = linechart.getAxisRight();
        yAxisRight.setDrawLabels(false);
    }

    private LineDataSet drawBoudary(List<Point> dataList, String dataName) {
        ArrayList<Entry> entries = new ArrayList<>();
        for(Point point: dataList) {
            if (point.getName().equals(dataName)) {
                entries.add(new Entry(point.getX(), point.getY()));
            }
        }

        return  new LineDataSet(entries, dataName);
    }

    private LineDataSet getMTOWDataSet(List<Point> pointList) {
        LineDataSet mtowLineDataSet =  drawBoudary(pointList, "MTOW");
        mtowLineDataSet.setLineWidth(2);         // 라인굵기
        mtowLineDataSet.setColor(Color.RED);     // 라인색상
        mtowLineDataSet.setDrawCircles(false);   // 점 표시
        mtowLineDataSet.setValueTextSize(0);     // 점 표시 데이터 텍스트 크기
        return  mtowLineDataSet;
    }

    private LineDataSet getMLDWDataSet(List<Point> pointList) {
        LineDataSet mldwLineDataSet = drawBoudary(pointList, "MLDW");
        mldwLineDataSet.setLineWidth(2);
        mldwLineDataSet.setColor(Color.BLUE);
        mldwLineDataSet.setDrawCircles(false);
        mldwLineDataSet.setValueTextSize(0);
        return mldwLineDataSet;
    }
    private LineDataSet getMZFWDataSet(List<Point> pointList) {
        LineDataSet mzfwLineDataSet = drawBoudary(pointList, "MZFW");
        mzfwLineDataSet.setLineWidth(1);
        mzfwLineDataSet.setColor(Color.GREEN);
        mzfwLineDataSet.setDrawCircles(false);
        mzfwLineDataSet.setValueTextSize(0);
        return mzfwLineDataSet;
    }

    private LineDataSet getMZFW2DataSet(List<Point> pointList) {
        LineDataSet mzfwLineDataSet2 = drawBoudary(pointList, "MZFW2");
        mzfwLineDataSet2.setLineWidth(2);
        mzfwLineDataSet2.setColor(Color.GREEN);
        mzfwLineDataSet2.setDrawCircles(false);
        mzfwLineDataSet2.setValueTextSize(0);
        return mzfwLineDataSet2;
    }

}


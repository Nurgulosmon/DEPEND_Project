package views;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.*;
import org.jfree.data.*;

public class plotXYline {


 public void plotData(double[] x, double[] y, String titleText, String xLabel, String yLabel, String FrameName){
XYSeries series = new XYSeries("");
int N=x.length;
for (int k=0;k<N;k++){
series.add(x[k], y[k]);
}

 XYDataset xyDataset = new XYSeriesCollection(series);
JFreeChart chart = ChartFactory.createXYLineChart
(titleText, xLabel, yLabel,
xyDataset, PlotOrientation.VERTICAL, false, true, false);
ChartPanel chartpanel = new ChartPanel(chart);
chartpanel.setDomainZoomable(true);
chartpanel.setRangeZoomable(true);

 JPanel jPanel1 = new JPanel();
jPanel1.setLayout(new BorderLayout());
jPanel1.add(chartpanel, BorderLayout.NORTH);

 JFrame frame = new JFrame();
frame.add(jPanel1);
frame.pack();
frame.setVisible(true);

double[] yBounds=getYBound(y);
chart.getXYPlot().getRangeAxis().setLowerBound(yBounds[0]);
chart.getXYPlot().getRangeAxis().setUpperBound(yBounds[1]);
chart.getXYPlot().getDomainAxis().setLowerBound(0);
double[] xBounds=getxBound(x);
chart.getXYPlot().getDomainAxis().setLowerBound(xBounds[0]);
chart.getXYPlot().getDomainAxis().setUpperBound(xBounds[1]);

}

public static double[] getxBound(double[] x) {
double[] xBounds=new double[2];
xBounds[0]=x[0];
int N=x.length;
xBounds[1]=x[N-1];
return xBounds;
}
public static double[] getYBound(double[] y) {
int N=y.length;
double[] yBounds=new double[2];
Arrays.sort(y);
double Minimum =y[0];
double Maximum=y[N-1];
yBounds[0]=1.5*Minimum;
yBounds[1]=1.5*Maximum;
return yBounds;
}
}
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.Calendar;
import java.util.Date;

/**
 * A simple demonstration application showing how to create a Gantt chart.
 * <P>
 * This demo is intended to show the conceptual approach rather than being a polished
 * implementation.
 *
 *
 */
public class DrawGantt extends ApplicationFrame {
    Instance i = new Instance();

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public DrawGantt(final String title) {

        super(title);

        final IntervalCategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    *
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************

    /**
     * Creates a sample dataset for a Gantt chart.
     *
     * @return The dataset.
     */
    public static IntervalCategoryDataset createDataset() {

        final TaskSeries s1 = new TaskSeries("Scheduled");




        s1.add(new Task("Write Proposal",
                new SimpleTimePeriod(date(1, Calendar.APRIL, 2017,
                        Instance.heureDebutTaskOfSpecifiWorker(121,2)),
                        date(1, Calendar.APRIL, 2017,
                                Instance.heureFinTaskOfSpecifiWorker(121,2)))));
        s1.add(new Task("Obtain Approval",
                new SimpleTimePeriod(date(1, Calendar.APRIL, 2017,
                        Instance.heureDebutTaskOfSpecifiWorker(1,2)),
                        date(1, Calendar.APRIL, 2017,
                                Instance.heureFinTaskOfSpecifiWorker(1,2)))));


        final TaskSeries s2 = new TaskSeries("Actual");
        s2.add(new Task("Write Proposal",
                new SimpleTimePeriod(date(1, Calendar.APRIL, 2017,
                        Instance.heureDebutTaskOfSpecifiWorker(2,1)),
                        date(1, Calendar.APRIL, 2017,
                                Instance.heureFinTaskOfSpecifiWorker(2,1)))));
        s2.add(new Task("Obtain Approval",
                new SimpleTimePeriod(date(1, Calendar.APRIL, 2017,
                        Instance.heureDebutTaskOfSpecifiWorker(2,2)),
                        date(1, Calendar.APRIL, 2017,
                                Instance.heureFinTaskOfSpecifiWorker(2,2)))));

        final TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(s1);
        collection.add(s2);

        return collection;
    }

    /**
     * Utility method for creating <code>Date</code> objects.
     *
     * @param day  the date.
     * @param month  the month.
     * @param year  the year.
     *
     * @return a date.
     */
    private static Date date(final int day, final int month, final int year) {

        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        final Date result = calendar.getTime();
        return result;

    }

    /**
     * Utility method for creating <code>Date</code> objects.
     *
     * @param day  the date.
     * @param month  the month.
     * @param year  the year.
     *
     * @return a date.
     */
    private static Date date(final int day, final int month, final int year, final Integer[] hourAndMinuteOfDay) {

        int hour;
        int minute;
        hour = Integer.parseInt(hourAndMinuteOfDay[0] + "" + hourAndMinuteOfDay[1]);
        minute = Integer.parseInt(hourAndMinuteOfDay[2] + "" + hourAndMinuteOfDay[3]);

        final Calendar calendar = Calendar.getInstance();
        calendar.set(day,month,year,hour,minute);
        final Date result = calendar.getTime();
        return result;

    }

    /**
     * Creates a chart.
     *
     * @param dataset  the dataset.
     *
     * @return The chart.
     */
    private JFreeChart createChart(final IntervalCategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createGanttChart(
                "Gantt Chart Demo",  // chart title
                "Task",              // domain axis label
                "Date",              // range axis label
                dataset,             // data
                true,                // include legend
                true,                // tooltips
                true                // urls
        );
//        chart.getCategoryPlot().getDomainAxis().setMaxCategoryLabelWidthRatio(10.0f);
        return chart;
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {


    }

}
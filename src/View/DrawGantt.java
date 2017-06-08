package View;

import Model.Instance;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.ApplicationFrame;

import java.util.Calendar;
import java.util.Date;

/**
 * A simple demonstration application showing how to create a Gantt chart.
 * <p>
 * This demo is intended to show the conceptual approach rather than being a polished
 * implementation.
 */
public class DrawGantt extends ApplicationFrame {
    static int idDuChauffeur;

    /**
     * Creates a new demo.
     *
     * @param title the frame title.
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


        TaskSeries[] s = new TaskSeries[Instance.tasksOfSpecificWorker(idDuChauffeur).size()];
        TaskSeriesCollection collection = new TaskSeriesCollection();


        for (int it = 0; it < Instance.tasksOfSpecificWorker(idDuChauffeur).size(); ++it) {
            s[it] = new TaskSeries("tâche " + (it + 1));

            s[it].add(new Task("",
                    new SimpleTimePeriod(date(1, Calendar.APRIL, 2017,
                            Instance.heureDebutTaskOfSpecifiWorker(idDuChauffeur, it + 1)),
                            date(1, Calendar.APRIL, 2017,
                                    Instance.heureFinTaskOfSpecifiWorker(idDuChauffeur, it + 1)))));
            collection.add(s[it]);
        }
        return collection;
    }

    /**
     * Utility method for creating <code>Date</code> objects.
     *
     * @param day   the date.
     * @param month the month.
     * @param year  the year.
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
     * @param day   the date.
     * @param month the month.
     * @param year  the year.
     * @return a date.
     */
    private static Date date(final int day, final int month, final int year, final Integer[] hourAndMinuteOfDay) {

        int hour;
        int minute;
        hour = Integer.parseInt(hourAndMinuteOfDay[0] + "" + hourAndMinuteOfDay[1]);
        minute = Integer.parseInt(hourAndMinuteOfDay[2] + "" + hourAndMinuteOfDay[3]);

        final Calendar calendar = Calendar.getInstance();
        calendar.set(day, month, year, hour, minute);
        final Date result = calendar.getTime();
        return result;

    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(final String[] args) {


    }

    /**
     * Creates a chart.
     *
     * @param dataset the dataset.
     * @return The chart.
     */
    private JFreeChart createChart(final IntervalCategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createGanttChart(
                "Diagramme de Gantt du chauffeur N° " + idDuChauffeur,  // chart title
                "tâches",              // domain axis label
                "Jour",              // range axis label
                dataset,             // data
                true,                // include legend
                false,                // tooltips
                true                // urls
        );
//        chart.getCategoryPlot().getDomainAxis().setMaxCategoryLabelWidthRatio(10.0f);
        return chart;
    }

}
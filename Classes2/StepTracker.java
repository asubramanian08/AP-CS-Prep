package Classes2;

public class StepTracker {
    private int activeDayThreshold, totalSteps, activeCt, totalDays;

    public StepTracker(int activeDayThreshold) {
        this.activeDayThreshold = activeDayThreshold;
        totalSteps = activeCt = totalDays = 0;
    }

    public void addDailySteps(int dailySteps) {
        totalSteps += dailySteps;
        totalDays++;
        if (dailySteps >= activeDayThreshold)
            activeCt++;
    }

    public int activeDays() {
        return activeCt;
    }

    public double averageSteps() {
        if (totalDays == 0)
            return 0.0;
        return (double) totalSteps / totalDays;
    }

    public static void main() {
        StepTracker tr = new StepTracker(10000);
        tr.activeDays();
        tr.averageSteps();
        tr.addDailySteps(9000);
        tr.addDailySteps(5000);
        tr.activeDays();
        tr.averageSteps();
        tr.addDailySteps(13000);
    }
}
import java.util.*;

class Activity implements Comparable<Activity> {
    public int startTime;
    public int finishTime;
    public Activity(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
    public int compareTo(Activity activity) {
        return (this.finishTime - activity.finishTime);
    }
    @Override
    public String toString() {
        return startTime + " " + finishTime;
    }

}

public class ActivitySelection {
    public static void activityPerformed(PriorityQueue<Activity> pq)  {
        Activity lastActivity = pq.peek();
        System.out.println("the activities are:");
        System.out.println(lastActivity);
        for (Activity x : pq) {
            if (x.startTime > lastActivity.finishTime) {
                System.out.println(x);
                lastActivity = x;
            }
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Activity> pq = new PriorityQueue<Activity>();
        pq.add(new Activity(1, 2));
        pq.add(new Activity(3,4));
        pq.add(new Activity(0,6));
        pq.add(new Activity(5, 7));
        pq.add(new Activity(8,9));
        pq.add(new Activity(5,9));
        pq.stream().forEach(x -> System.out.println(x.startTime + " " + x.finishTime));
        ActivitySelection.activityPerformed(pq);
    }
}
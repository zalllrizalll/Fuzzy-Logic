import java.util.Scanner;

public class AdaptiveRewardDemo {
    public static void main(String[] args) {
        // Create Instance Object of Class
        AdaptiveReward eksLvl = new AdaptiveReward();
        AdaptiveReward eksTime = new AdaptiveReward();

        // Input Nilai
        Scanner sc = new Scanner(System.in);
        System.out.print("Input nilai x untuk Eksplorasi Level : ");
        eksLvl.eksplorasiLevel = sc.nextFloat();
        System.out.print("Input nilai x untuk Eksplorasi Time : ");
        eksTime.eksplorasiTime = sc.nextFloat();

        // Logic Fuzzification Level Eksplorasi
        eksLvl.fuzzification(eksLvl.eksplorasiLevel, 40, 60, 80);

        System.out.println("\nFuzzification of exploration level : ");
        System.out.print("Low\t : " + eksLvl.leftTrapezoid);
        System.out.println();
        System.out.print("Medium\t : " + eksLvl.centerTriangle);
        System.out.println();
        System.out.print("High\t : " + eksLvl.rightTrapezoid);

        // Logic Fuzzification Waktu Eksplorasi
        eksTime.fuzzification(eksTime.eksplorasiTime, 15, 30, 45);

        System.out.println("\n\nFuzzification of exploration time : ");
        System.out.print("Fast\t : " + eksTime.leftTrapezoid);
        System.out.println();
        System.out.print("Normal\t : " + eksTime.centerTriangle);
        System.out.println();
        System.out.print("Slow\t : " + eksTime.rightTrapezoid);

        // Rules IF Then
        // Poor
        AdaptiveReward.rules(eksLvl.leftTrapezoid, eksTime.leftTrapezoid, "poor");
        AdaptiveReward.rules(eksLvl.leftTrapezoid, eksTime.centerTriangle, "poor");

        // Average
        AdaptiveReward.rules(eksLvl.leftTrapezoid, eksTime.rightTrapezoid, "average");
        AdaptiveReward.rules(eksLvl.centerTriangle, eksTime.leftTrapezoid, "average");
        AdaptiveReward.rules(eksLvl.centerTriangle, eksTime.centerTriangle, "average");
        AdaptiveReward.rules(eksLvl.rightTrapezoid, eksTime.leftTrapezoid, "average");

        // Awesome
        AdaptiveReward.rules(eksLvl.centerTriangle, eksTime.rightTrapezoid, "awesome");
        AdaptiveReward.rules(eksLvl.rightTrapezoid, eksTime.centerTriangle, "awesome");
        AdaptiveReward.rules(eksLvl.rightTrapezoid, eksTime.rightTrapezoid, "awesome");

        // Conclusion
        System.out.println("\n\nConclusion : ");
        System.out.println("Poor\t : "+AdaptiveReward.poor);
        System.out.println("Average\t : "+AdaptiveReward.average);
        System.out.println("Awesome\t : "+AdaptiveReward.awesome);

        // Sample for Defuzzification
        AdaptiveReward.sampleData(0, 40, 80, 100);
        System.out.println("\nSample Data for Defuzzification : ");
        System.out.println("Sample 1 : "+AdaptiveReward.sample1);
        System.out.println("Sample 2 : "+AdaptiveReward.sample2);
        System.out.println("Sample 3 : "+AdaptiveReward.sample3);

        // Reward
        AdaptiveReward.defuzzification(AdaptiveReward.poor, AdaptiveReward.average, AdaptiveReward.awesome, AdaptiveReward.sample1, AdaptiveReward.sample2, AdaptiveReward.sample3);
        System.out.println("\nReward : "+AdaptiveReward.result);

        sc.close();
    }
}

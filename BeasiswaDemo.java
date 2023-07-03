import java.util.Scanner;

public class BeasiswaDemo {
    public static void main(String[] args) {
        Beasiswa nilai = new Beasiswa();
        Beasiswa gaji = new Beasiswa();

        Scanner sc = new Scanner(System.in);
        System.out.print("Input nilai x untuk IPK : ");
        nilai.ipk = sc.nextFloat();
        System.out.print("Input nilai x untuk gaji ortu : ");
        gaji.gajiOrtu = sc.nextFloat();

        // Logic Fuzzification IPK
        nilai.fuzzification(nilai.ipk, (float)2.0, (float)3.0, (float)3.5);

        System.out.println("\nFuzzification of IPK : ");
        System.out.print("Jelek\t : " + nilai.leftTrapezoid);
        System.out.println();
        System.out.print("Cukup\t : " + nilai.centerTriangle);
        System.out.println();
        System.out.print("Bagus\t : " + nilai.rightTrapezoid);

        // Logic Fuzzification Gaji Ortu
        gaji.fuzzification(gaji.gajiOrtu, (float)2.5, (float)5.0, (float)7.0);

        System.out.println("\n\nFuzzification of Parents' Salary : ");
        System.out.print("Rendah\t : " + gaji.leftTrapezoid);
        System.out.println();
        System.out.print("Standar\t : " + gaji.centerTriangle);
        System.out.println();
        System.out.print("Tinggi\t : " + gaji.rightTrapezoid);

        // Rules IF Then
        // Kurang
        Beasiswa.rules(nilai.leftTrapezoid, gaji.leftTrapezoid, "kurang");
        Beasiswa.rules(nilai.leftTrapezoid, gaji.centerTriangle, "kurang");
        Beasiswa.rules(nilai.leftTrapezoid, gaji.rightTrapezoid, "kurang");
        Beasiswa.rules(nilai.centerTriangle, gaji.centerTriangle, "kurang");
        Beasiswa.rules(nilai.centerTriangle, gaji.rightTrapezoid, "kurang");

        // Lumayan
        Beasiswa.rules(nilai.centerTriangle, gaji.leftTrapezoid, "lumayan");
        Beasiswa.rules(nilai.rightTrapezoid, gaji.centerTriangle, "lumayan");
        Beasiswa.rules(nilai.rightTrapezoid, gaji.rightTrapezoid, "lumayan");

        // Layak
        Beasiswa.rules(nilai.rightTrapezoid, gaji.leftTrapezoid, "layak");

        // Conclusion
        System.out.println("\n\nConclusion : ");
        System.out.println("Kurang\t : "+Beasiswa.kurang);
        System.out.println("Lumayan\t : "+Beasiswa.lumayan);
        System.out.println("Layak\t : "+Beasiswa.layak);

        // Sample for Defuzzification
        Beasiswa.sampleData(0, 50, 70, 100);
        System.out.println("\nSample Data for Defuzzification : ");
        System.out.println("Sample 1 : "+Beasiswa.sample1);
        System.out.println("Sample 2 : "+Beasiswa.sample2);
        System.out.println("Sample 3 : "+Beasiswa.sample3);

        // Reward
        Beasiswa.defuzzification(Beasiswa.kurang, Beasiswa.lumayan, Beasiswa.layak, Beasiswa.sample1, Beasiswa.sample2, Beasiswa.sample3);
        System.out.println("\nReward : "+Beasiswa.result);

        sc.close();
    }
}

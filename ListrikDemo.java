import java.util.Scanner;

public class ListrikDemo {
    public static void main(String[] args) {
        // Create Instance Object of Class
        PemakaianListrik luas = new PemakaianListrik();
        PemakaianListrik teganganListrik = new PemakaianListrik();
        PemakaianListrik perabotanRumah = new PemakaianListrik();

        // Input Nilai
        Scanner sc = new Scanner(System.in);
        System.out.print("Input nilai x untuk Luas Rumah [m^2]: ");
        luas.luasRumah = sc.nextFloat();
        System.out.print("Input nilai x untuk Tegangan Listrik [kWh] : ");
        teganganListrik.tegangan = sc.nextFloat();
        System.out.print("Input nilai x untuk banyaknya Perabotan : ");
        perabotanRumah.perabotan = sc.nextFloat();

        // Logic Fuzzification Luas Rumah
        luas.fuzzification(luas.luasRumah, 40, 60, 80);

        System.out.println("\nFuzzification of House Size : ");
        System.out.print("Standar\t : " + luas.leftTrapezoid);
        System.out.println();
        System.out.print("Medium\t : " + luas.centerTriangle);
        System.out.println();
        System.out.print("Besar\t : " + luas.rightTrapezoid);

        // Logic Fuzzification Tegangan Listrik
        teganganListrik.fuzzification(teganganListrik.tegangan, 70, 90, 110);

        System.out.println("\n\nFuzzification of Mains Voltage : ");
        System.out.print("Rendah\t : " + teganganListrik.leftTrapezoid);
        System.out.println();
        System.out.print("Sedang\t : " + teganganListrik.centerTriangle);
        System.out.println();
        System.out.print("Tinggi\t : " + teganganListrik.rightTrapezoid);

        // Logic Fuzzification Banyaknya Perabotan Rumah
        perabotanRumah.fuzzification(perabotanRumah.perabotan, 15, 30, 45);

        System.out.println("\n\nFuzzification of Home Furnishings : ");
        System.out.print("Sedikit\t : " + perabotanRumah.leftTrapezoid);
        System.out.println();
        System.out.print("Normal\t : " + perabotanRumah.centerTriangle);
        System.out.println();
        System.out.print("Banyak\t : " + perabotanRumah.rightTrapezoid);

        // Rules IF Then
        // Rendah
        PemakaianListrik.rules(luas.leftTrapezoid, teganganListrik.leftTrapezoid, perabotanRumah.leftTrapezoid, "rendah");
        PemakaianListrik.rules(luas.leftTrapezoid, teganganListrik.centerTriangle, perabotanRumah.leftTrapezoid, "rendah");
        PemakaianListrik.rules(luas.leftTrapezoid, teganganListrik.rightTrapezoid, perabotanRumah.leftTrapezoid, "rendah");
        PemakaianListrik.rules(luas.centerTriangle, teganganListrik.leftTrapezoid, perabotanRumah.centerTriangle, "rendah");

        // Sedang
        PemakaianListrik.rules(luas.centerTriangle, teganganListrik.centerTriangle, perabotanRumah.centerTriangle, "sedang");
        PemakaianListrik.rules(luas.centerTriangle, teganganListrik.rightTrapezoid, perabotanRumah.centerTriangle, "sedang");
        PemakaianListrik.rules(luas.rightTrapezoid, teganganListrik.leftTrapezoid, perabotanRumah.rightTrapezoid, "sedang");

        // Tinggi
        PemakaianListrik.rules(luas.rightTrapezoid, teganganListrik.centerTriangle, perabotanRumah.rightTrapezoid, "tinggi");

        // Conclusion
        System.out.println("\n\nConclusion : ");
        System.out.println("Rendah\t : "+PemakaianListrik.rendah);
        System.out.println("Sedang\t : "+PemakaianListrik.sedang);
        System.out.println("Tinggi\t : "+PemakaianListrik.tinggi);

        // Sample for Defuzzification
        PemakaianListrik.sampleData(0, 60, 80, 100);
        System.out.println("\nSample Data for Defuzzification : ");
        System.out.println("Sample 1 : "+PemakaianListrik.sample1);
        System.out.println("Sample 2 : "+PemakaianListrik.sample2);
        System.out.println("Sample 3 : "+PemakaianListrik.sample3);

        // Reward
        PemakaianListrik.defuzzification(PemakaianListrik.rendah, PemakaianListrik.sedang, PemakaianListrik.tinggi, PemakaianListrik.sample1, PemakaianListrik.sample2, PemakaianListrik.sample3);
        System.out.println("\nReward : "+PemakaianListrik.result);

        sc.close();
        
    }
}

public class Fuzzy{
    float leftTrapezoid; // Membership Values Trapesium Sisi Kiri
    float centerTriangle; // Membership Values Segitiga Tengah
    float rightTrapezoid; // Membership Values Trapesium Sisi Kanan
    float leftTrapezoidA, leftTrapezoidB;
    float centerTriangleA, centerTriangleB, centerTriangleC;
    float rightTrapezoidA, rightTrapezoidB;
    static float temp = 0, result = 0;
    static float sample1, sample2, sample3;

    public Fuzzy(){}

    public void fuzzification(float x, float a, float b, float c){
        leftTrapezoidA = a;
        leftTrapezoidB = b;
        centerTriangleA = a;
        centerTriangleB = b;
        centerTriangleC = c;
        rightTrapezoidA = b;
        rightTrapezoidB = c;

        setAsLocation(x);
    }

    public void setAsLocation(float x){
        // Left Trapezoid
        if(x <= leftTrapezoidA){
            leftTrapezoid = 1;
        } else if (x > leftTrapezoidA && x < leftTrapezoidB){
            leftTrapezoid = (leftTrapezoidB - x) / (leftTrapezoidB - leftTrapezoidA);
        } else {
            leftTrapezoid = 0;
        }

        // Center Triangle
        if(x <= centerTriangleA || x >= centerTriangleC){
            centerTriangle = 0;
        } else if(x > centerTriangleA && x < centerTriangleB){
            centerTriangle = (x - centerTriangleA) / (centerTriangleB - centerTriangleA);
        } else if(x == centerTriangleB){
            centerTriangle = 1;
        } else {
            centerTriangle = (centerTriangleC - x) / (centerTriangleC - centerTriangleB);
        }

        // Right Trapezoid
        if(x <= rightTrapezoidA){
            rightTrapezoid = 0;
        } else if(x > rightTrapezoidA && x < rightTrapezoidB){
            rightTrapezoid = (x - rightTrapezoidA) / (rightTrapezoidB - rightTrapezoidA);
        } else {
            rightTrapezoid = 1;
        }
    }

    public static void sampleData(float a, float b, float c, float d){
        sample1 = (a + b) / 2;
        sample2 = (b + c) / 2;
        sample3 = (c + d) / 2;
    }

    public static void defuzzification(float u_Left, float u_Center, float u_Right, float s1, float s2, float s3){
        result = ((u_Left * s1) + (u_Center * s2) + (u_Right * s3)) / (u_Left+u_Center+u_Right);
    }
}
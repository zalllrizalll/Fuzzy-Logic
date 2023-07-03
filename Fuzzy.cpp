//
//  main.cpp
//  fuzzy
//
//  Created by Hanny Haryanto on 21/06/23.
//

#include <iostream>
#include <iomanip>

using namespace std;

void fuzzification(float x, float a, float b, float c, float &u1, float &u2, float &u3) {
    float uLeft;  //membership value for half trapezoid (left)
    float uCenter; //membership value for trapezoid
    float uRight; //membership value for half trapezoid (right)

    float left_c, left_d; //c, d value for left trapezoid
    float ctr_a, ctr_b, ctr_c; //a,b,c, d value for center triangle
    float right_a, right_b; //a,b value for right trapezoid

    left_c = a;
    left_d = b;
    ctr_a = a;
    ctr_b = b;
    ctr_c = c;
    right_a = b;
    right_b = c;

    //left trapezoid
    if (x <= left_c) uLeft = 1;
    if (x > left_c && x < left_d) {
        uLeft = (left_d - x) / (left_d - left_c);
    }
    if (x >= left_d) uLeft = 0;

    //cout << "uLeft : " << uLeft << endl;   //to be replaced
    u1 = uLeft;

    //center triangle
    if (x <= ctr_a || x >= ctr_c) uCenter = 0;
    if (x > ctr_a && x < ctr_b) {
        uCenter = (x - ctr_a)/(ctr_b-ctr_a);
    }
    if (x == ctr_b) uCenter = 1;
    if (x > ctr_b && x < ctr_c) {
        uCenter = (ctr_c-x) / (ctr_c-ctr_b);
    }
    //cout << "uCenter : " << uCenter << endl;//to be replaced
    u2 = uCenter;

    //right trapezoid
    if (x <= right_a) uRight = 0;
    if (x > right_a && x < right_b) {
        uRight = (x-right_a)/(right_b-right_a);
    }
    if (x >= right_b) uRight = 1;
    //cout << "uRight : " << uRight << endl;//to be replaced
    u3 = uRight;
}

void and_rules(float f1, float f2, float temp, float &conclusion) {
    if (f1 >= f2) temp = f2; else temp = f1;
    if (temp >= conclusion) conclusion = temp;
}

void determine_sample(float a, float b, float c, float d, float &s1, float &s2, float &s3) {  //from output fuzzy
    s1 = (a+b)/2;
    s2 = (b+c)/2;
    s3 = (c+d)/2;
}

void defuzzification(float u1, float u2, float u3, float s1, float s2, float s3, float &result) {
    result = ((u1*s1)+(u2*s2)+(u3*s3))/(u1+u2+u3);
}

int main()
{
    float x_explv, uLow, uMedium, uHigh; //exploration level
    float x_exptm, uFast, uNormal, uSlow; //exploration time
    float poor, average, awesome; //conclusion
    float sample1, sample2, sample3; //for defuzzification
    float reward; //reward outcome
    cout << fixed << setprecision(2);

    cout << "Masukkan x untuk expl level : ";
    cin >> x_explv;
    cout << "Masukkan x untuk expl time : ";
    cin >> x_exptm;
    fuzzification(x_explv, 40, 60, 80, uLow, uMedium, uHigh); //exploration level
    fuzzification(x_exptm, 15, 30, 45, uFast, uNormal, uSlow); //exploration time

    cout << "Fuzzification of exploration level : " << endl;
    cout << "uLow = " << uLow << endl;
    cout << "uMedium = " << uMedium << endl;
    cout << "uHigh = " << uHigh << endl;

    cout << "Fuzzification of exploration time : " << endl;
    cout << "uFast = " << uFast << endl;
    cout << "uNormal = " << uNormal << endl;
    cout << "uSlow = " << uSlow << endl;

    //rules
    and_rules(uLow, uFast, poor, poor);
    and_rules(uLow, uNormal, poor, poor);
    and_rules(uLow, uSlow, average, average);
    and_rules(uMedium, uFast, average, average);
    and_rules(uMedium, uNormal, average,average);
    and_rules(uMedium, uSlow, awesome, awesome);
    and_rules(uHigh, uFast, average, average);
    and_rules(uHigh, uNormal, awesome, awesome);
    and_rules(uHigh, uSlow, awesome, awesome);

    cout << "\nConclusion : " << endl;
    cout << "uPoor = " << poor << endl;
    cout << "uAverage = " << average << endl;
    cout << "uAwesome = " << awesome << endl;

    //sample for defuzzification
    determine_sample(0,40,80,100,sample1,sample2,sample3);
    cout << "\nSample value for defuzzification : " << endl;
    cout << "Sample 1 = " << sample1 << endl;
    cout << "Sample 2 = " << sample2 << endl;
    cout << "Sample 3 = " << sample3 << endl;

    //defuzzification
    defuzzification(poor, average, awesome, sample1, sample2, sample3, reward);
    cout << "\n\nREWARD :" << endl;
    cout << reward << endl;
    return 0;
}
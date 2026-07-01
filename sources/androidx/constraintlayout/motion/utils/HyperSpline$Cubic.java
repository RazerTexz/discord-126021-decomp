package androidx.constraintlayout.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class HyperSpline$Cubic {
    public static final double HALF = 0.5d;
    public static final double THIRD = 0.3333333333333333d;
    public double mA;
    public double mB;
    public double mC;
    public double mD;

    public HyperSpline$Cubic(double d, double d2, double d3, double d4) {
        this.mA = d;
        this.mB = d2;
        this.mC = d3;
        this.mD = d4;
    }

    public double eval(double d) {
        return (((((this.mD * d) + this.mC) * d) + this.mB) * d) + this.mA;
    }

    public double vel(double d) {
        return (((this.mC * 0.5d) + (this.mD * 0.3333333333333333d * d)) * d) + this.mB;
    }
}

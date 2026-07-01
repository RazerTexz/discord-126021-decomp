package androidx.constraintlayout.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class Easing$CubicEasing extends Easing {
    private static double d_error = 1.0E-4d;
    private static double error = 0.01d;
    public double x1;
    public double x2;
    public double y1;
    public double y2;

    public Easing$CubicEasing(String str) {
        this.str = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.x1 = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i = iIndexOf2 + 1;
        int iIndexOf3 = str.indexOf(44, i);
        this.y1 = Double.parseDouble(str.substring(i, iIndexOf3).trim());
        int i2 = iIndexOf3 + 1;
        int iIndexOf4 = str.indexOf(44, i2);
        this.x2 = Double.parseDouble(str.substring(i2, iIndexOf4).trim());
        int i3 = iIndexOf4 + 1;
        this.y2 = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
    }

    private double getDiffX(double d) {
        double d2 = 1.0d - d;
        double d3 = this.x1;
        double d4 = d2 * 3.0d * d2 * d3;
        double d5 = this.x2;
        return ((1.0d - d5) * 3.0d * d * d) + ((d5 - d3) * d2 * 6.0d * d) + d4;
    }

    private double getDiffY(double d) {
        double d2 = 1.0d - d;
        double d3 = this.y1;
        double d4 = d2 * 3.0d * d2 * d3;
        double d5 = this.y2;
        return ((1.0d - d5) * 3.0d * d * d) + ((d5 - d3) * d2 * 6.0d * d) + d4;
    }

    private double getX(double d) {
        double d2 = 1.0d - d;
        double d3 = 3.0d * d2;
        double d4 = d2 * d3 * d;
        double d5 = d3 * d * d;
        return (this.x2 * d5) + (this.x1 * d4) + (d * d * d);
    }

    private double getY(double d) {
        double d2 = 1.0d - d;
        double d3 = 3.0d * d2;
        double d4 = d2 * d3 * d;
        double d5 = d3 * d * d;
        return (this.y2 * d5) + (this.y1 * d4) + (d * d * d);
    }

    @Override // androidx.constraintlayout.motion.utils.Easing
    public double get(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        double d2 = 0.5d;
        double d3 = 0.5d;
        while (d2 > error) {
            d2 *= 0.5d;
            d3 = getX(d3) < d ? d3 + d2 : d3 - d2;
        }
        double d4 = d3 - d2;
        double x2 = getX(d4);
        double d5 = d3 + d2;
        double x3 = getX(d5);
        double y2 = getY(d4);
        return (((d - x2) * (getY(d5) - y2)) / (x3 - x2)) + y2;
    }

    @Override // androidx.constraintlayout.motion.utils.Easing
    public double getDiff(double d) {
        double d2 = 0.5d;
        double d3 = 0.5d;
        while (d2 > d_error) {
            d2 *= 0.5d;
            d3 = getX(d3) < d ? d3 + d2 : d3 - d2;
        }
        double d4 = d3 - d2;
        double d5 = d3 + d2;
        return (getY(d5) - getY(d4)) / (getX(d5) - getX(d4));
    }

    public void setup(double d, double d2, double d3, double d4) {
        this.x1 = d;
        this.y1 = d2;
        this.x2 = d3;
        this.y2 = d4;
    }

    public Easing$CubicEasing(double d, double d2, double d3, double d4) {
        setup(d, d2, d3, d4);
    }
}

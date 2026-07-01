package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArcCurveFit$Arc {
    private static final double EPSILON = 0.001d;
    private static final String TAG = "Arc";
    private static double[] ourPercent = new double[91];
    public boolean linear;
    public double mArcDistance;
    public double mArcVelocity;
    public double mEllipseA;
    public double mEllipseB;
    public double mEllipseCenterX;
    public double mEllipseCenterY;
    public double[] mLut;
    public double mOneOverDeltaTime;
    public double mTime1;
    public double mTime2;
    public double mTmpCosAngle;
    public double mTmpSinAngle;
    public boolean mVertical;
    public double mX1;
    public double mX2;
    public double mY1;
    public double mY2;

    public ArcCurveFit$Arc(int i, double d, double d2, double d3, double d4, double d5, double d6) {
        this.linear = false;
        this.mVertical = i == 1;
        this.mTime1 = d;
        this.mTime2 = d2;
        this.mOneOverDeltaTime = 1.0d / (d2 - d);
        if (3 == i) {
            this.linear = true;
        }
        double d7 = d5 - d3;
        double d8 = d6 - d4;
        if (!this.linear && Math.abs(d7) >= EPSILON && Math.abs(d8) >= EPSILON) {
            this.mLut = new double[101];
            boolean z2 = this.mVertical;
            this.mEllipseA = d7 * ((double) (z2 ? -1 : 1));
            this.mEllipseB = d8 * ((double) (z2 ? 1 : -1));
            this.mEllipseCenterX = z2 ? d5 : d3;
            this.mEllipseCenterY = z2 ? d4 : d6;
            buildTable(d3, d4, d5, d6);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
            return;
        }
        this.linear = true;
        this.mX1 = d3;
        this.mX2 = d5;
        this.mY1 = d4;
        this.mY2 = d6;
        double dHypot = Math.hypot(d8, d7);
        this.mArcDistance = dHypot;
        this.mArcVelocity = dHypot * this.mOneOverDeltaTime;
        double d9 = this.mTime2;
        double d10 = this.mTime1;
        this.mEllipseCenterX = d7 / (d9 - d10);
        this.mEllipseCenterY = d8 / (d9 - d10);
    }

    private void buildTable(double d, double d2, double d3, double d4) {
        double dHypot;
        double d5 = d3 - d;
        double d6 = d2 - d4;
        int i = 0;
        double d7 = 0.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        while (true) {
            double[] dArr = ourPercent;
            if (i >= dArr.length) {
                break;
            }
            double d10 = d7;
            double radians = Math.toRadians((((double) i) * 90.0d) / ((double) (dArr.length - 1)));
            double dSin = Math.sin(radians) * d5;
            double dCos = Math.cos(radians) * d6;
            if (i > 0) {
                dHypot = Math.hypot(dSin - d8, dCos - d9) + d10;
                ourPercent[i] = dHypot;
            } else {
                dHypot = d10;
            }
            i++;
            d9 = dCos;
            d7 = dHypot;
            d8 = dSin;
        }
        double d11 = d7;
        this.mArcDistance = d11;
        int i2 = 0;
        while (true) {
            double[] dArr2 = ourPercent;
            if (i2 >= dArr2.length) {
                break;
            }
            dArr2[i2] = dArr2[i2] / d11;
            i2++;
        }
        int i3 = 0;
        while (true) {
            double[] dArr3 = this.mLut;
            if (i3 >= dArr3.length) {
                return;
            }
            double length = ((double) i3) / ((double) (dArr3.length - 1));
            int iBinarySearch = Arrays.binarySearch(ourPercent, length);
            if (iBinarySearch >= 0) {
                this.mLut[i3] = iBinarySearch / (ourPercent.length - 1);
            } else if (iBinarySearch == -1) {
                this.mLut[i3] = 0.0d;
            } else {
                int i4 = -iBinarySearch;
                int i5 = i4 - 2;
                double[] dArr4 = ourPercent;
                this.mLut[i3] = (((length - dArr4[i5]) / (dArr4[i4 - 1] - dArr4[i5])) + ((double) i5)) / ((double) (dArr4.length - 1));
            }
            i3++;
        }
    }

    public double getDX() {
        double d = this.mEllipseA * this.mTmpCosAngle;
        double dHypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
        if (this.mVertical) {
            d = -d;
        }
        return d * dHypot;
    }

    public double getDY() {
        double d = this.mEllipseA * this.mTmpCosAngle;
        double d2 = (-this.mEllipseB) * this.mTmpSinAngle;
        double dHypot = this.mArcVelocity / Math.hypot(d, d2);
        return this.mVertical ? (-d2) * dHypot : d2 * dHypot;
    }

    public double getLinearDX(double d) {
        return this.mEllipseCenterX;
    }

    public double getLinearDY(double d) {
        return this.mEllipseCenterY;
    }

    public double getLinearX(double d) {
        double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
        double d3 = this.mX1;
        return ((this.mX2 - d3) * d2) + d3;
    }

    public double getLinearY(double d) {
        double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
        double d3 = this.mY1;
        return ((this.mY2 - d3) * d2) + d3;
    }

    public double getX() {
        return (this.mEllipseA * this.mTmpSinAngle) + this.mEllipseCenterX;
    }

    public double getY() {
        return (this.mEllipseB * this.mTmpCosAngle) + this.mEllipseCenterY;
    }

    public double lookup(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        double[] dArr = this.mLut;
        double length = d * ((double) (dArr.length - 1));
        int i = (int) length;
        return ((dArr[i + 1] - dArr[i]) * (length - ((double) i))) + dArr[i];
    }

    public void setPoint(double d) {
        double dLookup = lookup((this.mVertical ? this.mTime2 - d : d - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
        this.mTmpSinAngle = Math.sin(dLookup);
        this.mTmpCosAngle = Math.cos(dLookup);
    }
}

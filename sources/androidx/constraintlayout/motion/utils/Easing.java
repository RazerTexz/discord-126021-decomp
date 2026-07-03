package androidx.constraintlayout.motion.utils;

import android.util.Log;
import com.discord.analytics.utils.RegistrationSteps;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    public String str = RegistrationSteps.IDENTITY;
    public static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        str.hashCode();
        switch (str) {
            case "accelerate":
                return new CubicEasing(ACCELERATE);
            case "decelerate":
                return new CubicEasing(DECELERATE);
            case "linear":
                return new CubicEasing(LINEAR);
            case "standard":
                return new CubicEasing(STANDARD);
            default:
                StringBuilder sbM833U = C1643a.m833U("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
                sbM833U.append(Arrays.toString(NAMED_EASING));
                Log.e("ConstraintSet", sbM833U.toString());
                return sDefault;
        }
    }

    public double get(double d) {
        return d;
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* JADX INFO: renamed from: x1 */
        public double f92x1;

        /* JADX INFO: renamed from: x2 */
        public double f93x2;

        /* JADX INFO: renamed from: y1 */
        public double f94y1;

        /* JADX INFO: renamed from: y2 */
        public double f95y2;

        public CubicEasing(String str) {
            this.str = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f92x1 = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i);
            this.f94y1 = Double.parseDouble(str.substring(i, iIndexOf3).trim());
            int i2 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i2);
            this.f93x2 = Double.parseDouble(str.substring(i2, iIndexOf4).trim());
            int i3 = iIndexOf4 + 1;
            this.f95y2 = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
        }

        private double getDiffX(double d) {
            double d2 = 1.0d - d;
            double d3 = this.f92x1;
            double d4 = d2 * 3.0d * d2 * d3;
            double d5 = this.f93x2;
            return ((1.0d - d5) * 3.0d * d * d) + ((d5 - d3) * d2 * 6.0d * d) + d4;
        }

        private double getDiffY(double d) {
            double d2 = 1.0d - d;
            double d3 = this.f94y1;
            double d4 = d2 * 3.0d * d2 * d3;
            double d5 = this.f95y2;
            return ((1.0d - d5) * 3.0d * d * d) + ((d5 - d3) * d2 * 6.0d * d) + d4;
        }

        private double getX(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            double d4 = d2 * d3 * d;
            double d5 = d3 * d * d;
            return (this.f93x2 * d5) + (this.f92x1 * d4) + (d * d * d);
        }

        private double getY(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            double d4 = d2 * d3 * d;
            double d5 = d3 * d * d;
            return (this.f95y2 * d5) + (this.f94y1 * d4) + (d * d * d);
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
            this.f92x1 = d;
            this.f94y1 = d2;
            this.f93x2 = d3;
            this.f95y2 = d4;
        }

        public CubicEasing(double d, double d2, double d3, double d4) {
            setup(d, d2, d3, d4);
        }
    }
}

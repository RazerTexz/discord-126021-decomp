package androidx.constraintlayout.motion.utils;

import android.util.Log;
import b.d.b.a.a;
import com.discord.analytics.utils.RegistrationSteps;
import java.util.Arrays;

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
            return new Easing$CubicEasing(str);
        }
        str.hashCode();
        switch (str) {
            case "accelerate":
                return new Easing$CubicEasing(ACCELERATE);
            case "decelerate":
                return new Easing$CubicEasing(DECELERATE);
            case "linear":
                return new Easing$CubicEasing(LINEAR);
            case "standard":
                return new Easing$CubicEasing(STANDARD);
            default:
                StringBuilder sbU = a.U("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
                sbU.append(Arrays.toString(NAMED_EASING));
                Log.e("ConstraintSet", sbU.toString());
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
}

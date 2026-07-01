package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import b.d.b.a.a;
import java.lang.reflect.Array;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class KeyCycleOscillator$CycleOscillator {
    private static final String TAG = "CycleOscillator";
    public static final int UNSET = -1;
    public CurveFit mCurveFit;
    public float[] mOffset;
    public float mPathLength;
    public float[] mPeriod;
    public double[] mPosition;
    public float[] mScale;
    public double[] mSplineSlopeCache;
    public double[] mSplineValueCache;
    public float[] mValues;
    private final int mVariesBy;
    public int mWaveShape;
    public Oscillator mOscillator = new Oscillator();
    public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

    public KeyCycleOscillator$CycleOscillator(int i, int i2, int i3) {
        this.mWaveShape = i;
        this.mVariesBy = i2;
        this.mOscillator.setType(i);
        this.mValues = new float[i3];
        this.mPosition = new double[i3];
        this.mPeriod = new float[i3];
        this.mOffset = new float[i3];
        this.mScale = new float[i3];
    }

    private ConstraintAttribute get(String str, ConstraintAttribute$AttributeType constraintAttribute$AttributeType) {
        if (!this.mCustomConstraints.containsKey(str)) {
            ConstraintAttribute constraintAttribute = new ConstraintAttribute(str, constraintAttribute$AttributeType);
            this.mCustomConstraints.put(str, constraintAttribute);
            return constraintAttribute;
        }
        ConstraintAttribute constraintAttribute2 = this.mCustomConstraints.get(str);
        if (constraintAttribute2.getType() == constraintAttribute$AttributeType) {
            return constraintAttribute2;
        }
        StringBuilder sbU = a.U("ConstraintAttribute is already a ");
        sbU.append(constraintAttribute2.getType().name());
        throw new IllegalArgumentException(sbU.toString());
    }

    public double getSlope(float f) {
        CurveFit curveFit = this.mCurveFit;
        if (curveFit != null) {
            double d = f;
            curveFit.getSlope(d, this.mSplineSlopeCache);
            this.mCurveFit.getPos(d, this.mSplineValueCache);
        } else {
            double[] dArr = this.mSplineSlopeCache;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        double d2 = f;
        double value = this.mOscillator.getValue(d2);
        double slope = this.mOscillator.getSlope(d2);
        double[] dArr2 = this.mSplineSlopeCache;
        return (slope * this.mSplineValueCache[1]) + (value * dArr2[1]) + dArr2[0];
    }

    public double getValues(float f) {
        CurveFit curveFit = this.mCurveFit;
        if (curveFit != null) {
            curveFit.getPos(f, this.mSplineValueCache);
        } else {
            double[] dArr = this.mSplineValueCache;
            dArr[0] = this.mOffset[0];
            dArr[1] = this.mValues[0];
        }
        return (this.mOscillator.getValue(f) * this.mSplineValueCache[1]) + this.mSplineValueCache[0];
    }

    public void setPoint(int i, int i2, float f, float f2, float f3) {
        this.mPosition[i] = ((double) i2) / 100.0d;
        this.mPeriod[i] = f;
        this.mOffset[i] = f2;
        this.mValues[i] = f3;
    }

    public void setup(float f) {
        this.mPathLength = f;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, this.mPosition.length, 2);
        float[] fArr = this.mValues;
        this.mSplineValueCache = new double[fArr.length + 1];
        this.mSplineSlopeCache = new double[fArr.length + 1];
        if (this.mPosition[0] > 0.0d) {
            this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
        }
        double[] dArr2 = this.mPosition;
        int length = dArr2.length - 1;
        if (dArr2[length] < 1.0d) {
            this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
        }
        for (int i = 0; i < dArr.length; i++) {
            dArr[i][0] = this.mOffset[i];
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.mValues;
                if (i2 < fArr2.length) {
                    dArr[i2][1] = fArr2[i2];
                    i2++;
                }
            }
            this.mOscillator.addPoint(this.mPosition[i], this.mPeriod[i]);
        }
        this.mOscillator.normalize();
        double[] dArr3 = this.mPosition;
        if (dArr3.length > 1) {
            this.mCurveFit = CurveFit.get(0, dArr3, dArr);
        } else {
            this.mCurveFit = null;
        }
    }
}

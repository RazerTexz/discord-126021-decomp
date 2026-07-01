package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import b.d.b.a.a;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    public long last_time;
    public CurveFit mCurveFit;
    private String mType;
    public int mWaveShape = 0;
    public int[] mTimePoints = new int[10];
    public float[][] mValues = (float[][]) Array.newInstance((Class<?>) float.class, 10, 3);
    private float[] mCache = new float[3];
    public boolean mContinue = false;
    public float last_cycle = Float.NaN;

    public static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new TimeCycleSplineSet$CustomSet(str, sparseArray);
    }

    public static TimeCycleSplineSet makeSpline(String str, long j) {
        TimeCycleSplineSet timeCycleSplineSet$RotationXset;
        str.hashCode();
        switch (str) {
            case "rotationX":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$RotationXset();
                break;
            case "rotationY":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$RotationYset();
                break;
            case "translationX":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$TranslationXset();
                break;
            case "translationY":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$TranslationYset();
                break;
            case "translationZ":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$TranslationZset();
                break;
            case "progress":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$ProgressSet();
                break;
            case "scaleX":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$ScaleXset();
                break;
            case "scaleY":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$ScaleYset();
                break;
            case "rotation":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$RotationSet();
                break;
            case "elevation":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$ElevationSet();
                break;
            case "transitionPathRotate":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$PathRotate();
                break;
            case "alpha":
                timeCycleSplineSet$RotationXset = new TimeCycleSplineSet$AlphaSet();
                break;
            default:
                return null;
        }
        timeCycleSplineSet$RotationXset.setStartTime(j);
        return timeCycleSplineSet$RotationXset;
    }

    public float calcWave(float f) {
        float fAbs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f * VAL_2PI);
            case 2:
                fAbs = Math.abs(f);
                break;
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                fAbs = ((f * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f * VAL_2PI);
            case 6:
                float fAbs2 = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                fAbs = fAbs2 * fAbs2;
                break;
            default:
                return (float) Math.sin(f * VAL_2PI);
        }
        return 1.0f - fAbs;
    }

    public float get(float f, long j, View view, KeyCache keyCache) {
        this.mCurveFit.getPos(f, this.mCache);
        float[] fArr = this.mCache;
        float f2 = fArr[1];
        if (f2 == 0.0f) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f3 = (float) (((((j - this.last_time) * 1.0E-9d) * ((double) f2)) + ((double) this.last_cycle)) % 1.0d);
        this.last_cycle = f3;
        keyCache.setFloatValue(view, this.mType, 0, f3);
        this.last_time = j;
        float f4 = this.mCache[0];
        float fCalcWave = (calcWave(this.last_cycle) * f4) + this.mCache[2];
        this.mContinue = (f4 == 0.0f && f2 == 0.0f) ? false : true;
        return fCalcWave;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i, float f, float f2, int i2, float f3) {
        int[] iArr = this.mTimePoints;
        int i3 = this.count;
        iArr[i3] = i;
        float[][] fArr = this.mValues;
        fArr[i3][0] = f;
        fArr[i3][1] = f2;
        fArr[i3][2] = f3;
        this.mWaveShape = Math.max(this.mWaveShape, i2);
        this.count++;
    }

    public abstract boolean setProperty(View view, float f, long j, KeyCache keyCache);

    public void setStartTime(long j) {
        this.last_time = j;
    }

    public void setType(String str) {
        this.mType = str;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    public void setup(int i) {
        int i2 = this.count;
        if (i2 == 0) {
            StringBuilder sbU = a.U("Error no points added to ");
            sbU.append(this.mType);
            Log.e(TAG, sbU.toString());
            return;
        }
        TimeCycleSplineSet$Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i2 - 1);
        int i3 = 1;
        int i4 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i3 >= iArr.length) {
                break;
            }
            if (iArr[i3] != iArr[i3 - 1]) {
                i4++;
            }
            i3++;
        }
        if (i4 == 0) {
            i4 = 1;
        }
        double[] dArr = new double[i4];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, i4, 3);
        int i5 = 0;
        for (int i6 = 0; i6 < this.count; i6++) {
            if (i6 > 0) {
                int[] iArr2 = this.mTimePoints;
                if (iArr2[i6] != iArr2[i6 - 1]) {
                    dArr[i5] = ((double) this.mTimePoints[i6]) * 0.01d;
                    double[] dArr3 = dArr2[i5];
                    float[][] fArr = this.mValues;
                    dArr3[0] = fArr[i6][0];
                    dArr2[i5][1] = fArr[i6][1];
                    dArr2[i5][2] = fArr[i6][2];
                    i5++;
                }
            } else {
                dArr[i5] = ((double) this.mTimePoints[i6]) * 0.01d;
                double[] dArr4 = dArr2[i5];
                float[][] fArr2 = this.mValues;
                dArr4[0] = fArr2[i6][0];
                dArr2[i5][1] = fArr2[i6][1];
                dArr2[i5][2] = fArr2[i6][2];
                i5++;
            }
        }
        this.mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.count; i++) {
            StringBuilder sbX = a.X(string, "[");
            sbX.append(this.mTimePoints[i]);
            sbX.append(" , ");
            sbX.append(decimalFormat.format(this.mValues[i]));
            sbX.append("] ");
            string = sbX.toString();
        }
        return string;
    }
}

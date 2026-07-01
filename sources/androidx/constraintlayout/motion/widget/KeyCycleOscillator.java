package androidx.constraintlayout.motion.widget;

import android.annotation.TargetApi;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import b.d.b.a.a;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    public ConstraintAttribute mCustom;
    private KeyCycleOscillator$CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    public int mVariesBy = 0;
    public ArrayList<KeyCycleOscillator$WavePoint> mWavePoints = new ArrayList<>();

    public static KeyCycleOscillator makeSpline(String str) {
        if (str.startsWith(Key.CUSTOM)) {
            return new KeyCycleOscillator$CustomSet();
        }
        switch (str) {
            case "rotationX":
                return new KeyCycleOscillator$RotationXset();
            case "rotationY":
                return new KeyCycleOscillator$RotationYset();
            case "translationX":
                return new KeyCycleOscillator$TranslationXset();
            case "translationY":
                return new KeyCycleOscillator$TranslationYset();
            case "translationZ":
                return new KeyCycleOscillator$TranslationZset();
            case "progress":
                return new KeyCycleOscillator$ProgressSet();
            case "scaleX":
                return new KeyCycleOscillator$ScaleXset();
            case "scaleY":
                return new KeyCycleOscillator$ScaleYset();
            case "waveVariesBy":
                return new KeyCycleOscillator$AlphaSet();
            case "rotation":
                return new KeyCycleOscillator$RotationSet();
            case "elevation":
                return new KeyCycleOscillator$ElevationSet();
            case "transitionPathRotate":
                return new KeyCycleOscillator$PathRotateSet();
            case "alpha":
                return new KeyCycleOscillator$AlphaSet();
            case "waveOffset":
                return new KeyCycleOscillator$AlphaSet();
            default:
                return null;
        }
    }

    public float get(float f) {
        return (float) this.mCycleOscillator.getValues(f);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float) this.mCycleOscillator.getSlope(f);
    }

    public void setPoint(int i, int i2, int i3, float f, float f2, float f3, ConstraintAttribute constraintAttribute) {
        this.mWavePoints.add(new KeyCycleOscillator$WavePoint(i, f, f2, f3));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.mWaveShape = i2;
        this.mCustom = constraintAttribute;
    }

    public abstract void setProperty(View view, float f);

    public void setType(String str) {
        this.mType = str;
    }

    @TargetApi(19)
    public void setup(float f) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new KeyCycleOscillator$1(this));
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, 2);
        this.mCycleOscillator = new KeyCycleOscillator$CycleOscillator(this.mWaveShape, this.mVariesBy, size);
        int i = 0;
        for (KeyCycleOscillator$WavePoint keyCycleOscillator$WavePoint : this.mWavePoints) {
            float f2 = keyCycleOscillator$WavePoint.mPeriod;
            dArr[i] = ((double) f2) * 0.01d;
            double[] dArr3 = dArr2[i];
            float f3 = keyCycleOscillator$WavePoint.mValue;
            dArr3[0] = f3;
            double[] dArr4 = dArr2[i];
            float f4 = keyCycleOscillator$WavePoint.mOffset;
            dArr4[1] = f4;
            this.mCycleOscillator.setPoint(i, keyCycleOscillator$WavePoint.mPosition, f2, f4, f3);
            i++;
        }
        this.mCycleOscillator.setup(f);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (KeyCycleOscillator$WavePoint keyCycleOscillator$WavePoint : this.mWavePoints) {
            StringBuilder sbX = a.X(string, "[");
            sbX.append(keyCycleOscillator$WavePoint.mPosition);
            sbX.append(" , ");
            sbX.append(decimalFormat.format(keyCycleOscillator$WavePoint.mValue));
            sbX.append("] ");
            string = sbX.toString();
        }
        return string;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i, int i2, int i3, float f, float f2, float f3) {
        this.mWavePoints.add(new KeyCycleOscillator$WavePoint(i, f, f2, f3));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.mWaveShape = i2;
    }
}

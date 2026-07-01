package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class TimeCycleSplineSet$CustomSet extends TimeCycleSplineSet {
    public String mAttributeName;
    public float[] mCache;
    public SparseArray<ConstraintAttribute> mConstraintAttributeList;
    public float[] mTempValues;
    public SparseArray<float[]> mWaveProperties = new SparseArray<>();

    public TimeCycleSplineSet$CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
        this.mAttributeName = str.split(",")[1];
        this.mConstraintAttributeList = sparseArray;
    }

    @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
    public void setPoint(int i, float f, float f2, int i2, float f3) {
        throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
    }

    @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
    public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        this.mCurveFit.getPos(f, this.mTempValues);
        float[] fArr = this.mTempValues;
        float f2 = fArr[fArr.length - 2];
        float f3 = fArr[fArr.length - 1];
        long j2 = j - this.last_time;
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mAttributeName, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f4 = (float) ((((j2 * 1.0E-9d) * ((double) f2)) + ((double) this.last_cycle)) % 1.0d);
        this.last_cycle = f4;
        this.last_time = j;
        float fCalcWave = calcWave(f4);
        this.mContinue = false;
        int i = 0;
        while (true) {
            float[] fArr2 = this.mCache;
            if (i >= fArr2.length) {
                break;
            }
            boolean z2 = this.mContinue;
            float[] fArr3 = this.mTempValues;
            this.mContinue = z2 | (((double) fArr3[i]) != 0.0d);
            fArr2[i] = (fArr3[i] * fCalcWave) + f3;
            i++;
        }
        this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
        if (f2 != 0.0f) {
            this.mContinue = true;
        }
        return this.mContinue;
    }

    @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
    public void setup(int i) {
        int size = this.mConstraintAttributeList.size();
        int iNoOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
        double[] dArr = new double[size];
        int i2 = iNoOfInterpValues + 2;
        this.mTempValues = new float[i2];
        this.mCache = new float[iNoOfInterpValues];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, i2);
        for (int i3 = 0; i3 < size; i3++) {
            int iKeyAt = this.mConstraintAttributeList.keyAt(i3);
            ConstraintAttribute constraintAttributeValueAt = this.mConstraintAttributeList.valueAt(i3);
            float[] fArrValueAt = this.mWaveProperties.valueAt(i3);
            dArr[i3] = ((double) iKeyAt) * 0.01d;
            constraintAttributeValueAt.getValuesToInterpolate(this.mTempValues);
            int i4 = 0;
            while (true) {
                float[] fArr = this.mTempValues;
                if (i4 < fArr.length) {
                    dArr2[i3][i4] = fArr[i4];
                    i4++;
                }
            }
            dArr2[i3][iNoOfInterpValues] = fArrValueAt[0];
            dArr2[i3][iNoOfInterpValues + 1] = fArrValueAt[1];
        }
        this.mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    public void setPoint(int i, ConstraintAttribute constraintAttribute, float f, int i2, float f2) {
        this.mConstraintAttributeList.append(i, constraintAttribute);
        this.mWaveProperties.append(i, new float[]{f, f2});
        this.mWaveShape = Math.max(this.mWaveShape, i2);
    }
}

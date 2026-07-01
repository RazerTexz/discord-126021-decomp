package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class SplineSet$CustomSet extends SplineSet {
    public String mAttributeName;
    public SparseArray<ConstraintAttribute> mConstraintAttributeList;
    public float[] mTempValues;

    public SplineSet$CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
        this.mAttributeName = str.split(",")[1];
        this.mConstraintAttributeList = sparseArray;
    }

    @Override // androidx.constraintlayout.motion.widget.SplineSet
    public void setPoint(int i, float f) {
        throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
    }

    @Override // androidx.constraintlayout.motion.widget.SplineSet
    public void setProperty(View view, float f) {
        this.mCurveFit.getPos(f, this.mTempValues);
        this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
    }

    @Override // androidx.constraintlayout.motion.widget.SplineSet
    public void setup(int i) {
        int size = this.mConstraintAttributeList.size();
        int iNoOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
        double[] dArr = new double[size];
        this.mTempValues = new float[iNoOfInterpValues];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, iNoOfInterpValues);
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = this.mConstraintAttributeList.keyAt(i2);
            ConstraintAttribute constraintAttributeValueAt = this.mConstraintAttributeList.valueAt(i2);
            dArr[i2] = ((double) iKeyAt) * 0.01d;
            constraintAttributeValueAt.getValuesToInterpolate(this.mTempValues);
            int i3 = 0;
            while (true) {
                float[] fArr = this.mTempValues;
                if (i3 < fArr.length) {
                    dArr2[i2][i3] = fArr[i3];
                    i3++;
                }
            }
        }
        this.mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    public void setPoint(int i, ConstraintAttribute constraintAttribute) {
        this.mConstraintAttributeList.append(i, constraintAttribute);
    }
}

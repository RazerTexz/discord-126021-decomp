package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes.dex */
public class TransitionUtils$MatrixEvaluator implements TypeEvaluator<Matrix> {
    public final float[] mTempStartValues = new float[9];
    public final float[] mTempEndValues = new float[9];
    public final Matrix mTempMatrix = new Matrix();

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        return evaluate2(f, matrix, matrix2);
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Matrix evaluate2(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.mTempStartValues);
        matrix2.getValues(this.mTempEndValues);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.mTempEndValues;
            float f2 = fArr[i];
            float[] fArr2 = this.mTempStartValues;
            fArr[i] = ((f2 - fArr2[i]) * f) + fArr2[i];
        }
        this.mTempMatrix.setValues(this.mTempEndValues);
        return this.mTempMatrix;
    }
}

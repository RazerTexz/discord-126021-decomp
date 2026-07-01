package androidx.transition;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform$PathAnimatorMatrix {
    private final Matrix mMatrix = new Matrix();
    private float mTranslationX;
    private float mTranslationY;
    private final float[] mValues;
    private final View mView;

    public ChangeTransform$PathAnimatorMatrix(View view, float[] fArr) {
        this.mView = view;
        float[] fArr2 = (float[]) fArr.clone();
        this.mValues = fArr2;
        this.mTranslationX = fArr2[2];
        this.mTranslationY = fArr2[5];
        setAnimationMatrix();
    }

    private void setAnimationMatrix() {
        float[] fArr = this.mValues;
        fArr[2] = this.mTranslationX;
        fArr[5] = this.mTranslationY;
        this.mMatrix.setValues(fArr);
        ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public void setTranslation(PointF pointF) {
        this.mTranslationX = pointF.x;
        this.mTranslationY = pointF.y;
        setAnimationMatrix();
    }

    public void setValues(float[] fArr) {
        System.arraycopy(fArr, 0, this.mValues, 0, fArr.length);
        setAnimationMatrix();
    }
}

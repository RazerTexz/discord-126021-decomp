package androidx.transition;

import android.animation.TypeEvaluator;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ float[] evaluate(float f, float[] fArr, float[] fArr2) {
        return evaluate2(f, fArr, fArr2);
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public float[] evaluate2(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = a.a(fArr2[i], f2, f, f2);
        }
        return fArr3;
    }
}

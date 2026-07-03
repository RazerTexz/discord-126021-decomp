package p007b.p109f.p132g.p142e;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: renamed from: b.f.g.e.q */
/* JADX INFO: compiled from: ScalingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1783q implements ScalingUtils$ScaleType {
    @Override // com.facebook.drawee.drawable.ScalingUtils$ScaleType
    /* JADX INFO: renamed from: a */
    public Matrix mo1121a(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
        mo1092b(matrix, rect, i, i2, f, f2, rect.width() / i, rect.height() / i2);
        return matrix;
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo1092b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4);
}

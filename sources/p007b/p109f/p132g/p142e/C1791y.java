package p007b.p109f.p132g.p142e;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: renamed from: b.f.g.e.y */
/* JADX INFO: compiled from: ScalingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1791y extends AbstractC1783q {

    /* JADX INFO: renamed from: l */
    public static final ScalingUtils$ScaleType f3449l = new C1791y();

    @Override // p007b.p109f.p132g.p142e.AbstractC1783q
    /* JADX INFO: renamed from: b */
    public void mo1092b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float f5 = rect.left;
        float fHeight = ((rect.height() - (i2 * f3)) * 0.5f) + rect.top;
        matrix.setScale(f3, f3);
        matrix.postTranslate((int) (f5 + 0.5f), (int) (fHeight + 0.5f));
    }

    public String toString() {
        return "fit_x";
    }
}

package p007b.p109f.p132g.p142e;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: renamed from: b.f.g.e.a0 */
/* JADX INFO: compiled from: ScalingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1761a0 extends AbstractC1783q {

    /* JADX INFO: renamed from: l */
    public static final ScalingUtils$ScaleType f3325l = new C1761a0();

    @Override // p007b.p109f.p132g.p142e.AbstractC1783q
    /* JADX INFO: renamed from: b */
    public void mo1092b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fWidth = ((rect.width() - (i * f4)) * 0.5f) + rect.left;
        float f5 = rect.top;
        matrix.setScale(f4, f4);
        matrix.postTranslate((int) (fWidth + 0.5f), (int) (f5 + 0.5f));
    }

    public String toString() {
        return "fit_y";
    }
}

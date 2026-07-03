package p007b.p109f.p132g.p142e;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: renamed from: b.f.g.e.t */
/* JADX INFO: compiled from: ScalingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1786t extends AbstractC1783q {

    /* JADX INFO: renamed from: l */
    public static final ScalingUtils$ScaleType f3444l = new C1786t();

    @Override // p007b.p109f.p132g.p142e.AbstractC1783q
    /* JADX INFO: renamed from: b */
    public void mo1092b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fMin = Math.min(Math.min(f3, f4), 1.0f);
        float fWidth = ((rect.width() - (i * fMin)) * 0.5f) + rect.left;
        float fHeight = ((rect.height() - (i2 * fMin)) * 0.5f) + rect.top;
        matrix.setScale(fMin, fMin);
        matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
    }

    public String toString() {
        return "center_inside";
    }
}

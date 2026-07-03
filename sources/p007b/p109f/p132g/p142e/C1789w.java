package p007b.p109f.p132g.p142e;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: renamed from: b.f.g.e.w */
/* JADX INFO: compiled from: ScalingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1789w extends AbstractC1783q {

    /* JADX INFO: renamed from: l */
    public static final ScalingUtils$ScaleType f3447l = new C1789w();

    @Override // p007b.p109f.p132g.p142e.AbstractC1783q
    /* JADX INFO: renamed from: b */
    public void mo1092b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fMin = Math.min(f3, f4);
        float fWidth = (rect.width() - (i * fMin)) + rect.left;
        float fHeight = (rect.height() - (i2 * fMin)) + rect.top;
        matrix.setScale(fMin, fMin);
        matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
    }

    public String toString() {
        return "fit_end";
    }
}

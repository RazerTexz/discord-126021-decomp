package p007b.p109f.p132g.p142e;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: renamed from: b.f.g.e.s */
/* JADX INFO: compiled from: ScalingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1785s extends AbstractC1783q {

    /* JADX INFO: renamed from: l */
    public static final ScalingUtils$ScaleType f3443l = new C1785s();

    @Override // p007b.p109f.p132g.p142e.AbstractC1783q
    /* JADX INFO: renamed from: b */
    public void mo1092b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fWidth;
        float fHeight;
        if (f4 > f3) {
            fWidth = ((rect.width() - (i * f4)) * 0.5f) + rect.left;
            fHeight = rect.top;
            f3 = f4;
        } else {
            fWidth = rect.left;
            fHeight = ((rect.height() - (i2 * f3)) * 0.5f) + rect.top;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
    }

    public String toString() {
        return "center_crop";
    }
}

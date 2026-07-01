package b.f.g.e;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: compiled from: ScalingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a0 extends q {
    public static final ScalingUtils$ScaleType l = new a0();

    @Override // b.f.g.e.q
    public void b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fWidth = ((rect.width() - (i * f4)) * 0.5f) + rect.left;
        float f5 = rect.top;
        matrix.setScale(f4, f4);
        matrix.postTranslate((int) (fWidth + 0.5f), (int) (f5 + 0.5f));
    }

    public String toString() {
        return "fit_y";
    }
}

package b.f.g.e;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: compiled from: ScalingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b0 extends q {
    public static final ScalingUtils$ScaleType l = new b0();

    @Override // b.f.g.e.q
    public void b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fMax;
        float fMax2;
        if (f4 > f3) {
            float f5 = i * f4;
            fMax = Math.max(Math.min((rect.width() * 0.5f) - (f * f5), 0.0f), rect.width() - f5) + rect.left;
            fMax2 = rect.top;
            f3 = f4;
        } else {
            fMax = rect.left;
            float f6 = i2 * f3;
            fMax2 = Math.max(Math.min((rect.height() * 0.5f) - (f2 * f6), 0.0f), rect.height() - f6) + rect.top;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate((int) (fMax + 0.5f), (int) (fMax2 + 0.5f));
    }

    public String toString() {
        return "focus_crop";
    }
}

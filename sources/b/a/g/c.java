package b.a.g;

import d0.z.d.m;

/* JADX INFO: compiled from: ColorUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final void a(int i, int i2, int i3, float[] fArr) {
        float f;
        float fAbs;
        m.checkNotNullParameter(fArr, "hsl");
        float f2 = i / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float fMax = Math.max(f2, Math.max(f3, f4));
        float fMin = Math.min(f2, Math.min(f3, f4));
        float f5 = fMax - fMin;
        float f6 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f = 0.0f;
            fAbs = 0.0f;
        } else {
            if (fMax == f2) {
                f = ((f3 - f4) / f5) % 6.0f;
            } else {
                f = fMax == f3 ? ((f4 - f2) / f5) + 2.0f : ((f2 - f3) / f5) + 4.0f;
            }
            fAbs = f5 / (1.0f - Math.abs((2.0f * f6) - 1.0f));
        }
        fArr[0] = (f * 60.0f) % 360.0f;
        fArr[1] = fAbs;
        fArr[2] = f6;
    }
}

package b.i.a.g.g;

import android.util.Property;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a extends Property<d, Float> {
    public d$a(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public Float get(d dVar) {
        return Float.valueOf(dVar.n);
    }

    @Override // android.util.Property
    public void set(d dVar, Float f) {
        d dVar2 = dVar;
        float fFloatValue = f.floatValue();
        dVar2.n = fFloatValue;
        int i = (int) (5400.0f * fFloatValue);
        float[] fArr = dVar2.f1623b;
        float f2 = fFloatValue * 1520.0f;
        fArr[0] = (-20.0f) + f2;
        fArr[1] = f2;
        for (int i2 = 0; i2 < 4; i2++) {
            float fB = dVar2.b(i, d.d[i2], 667);
            float[] fArr2 = dVar2.f1623b;
            fArr2[1] = (dVar2.k.getInterpolation(fB) * 250.0f) + fArr2[1];
            float fB2 = dVar2.b(i, d.e[i2], 667);
            float[] fArr3 = dVar2.f1623b;
            fArr3[0] = (dVar2.k.getInterpolation(fB2) * 250.0f) + fArr3[0];
        }
        float[] fArr4 = dVar2.f1623b;
        fArr4[0] = ((fArr4[1] - fArr4[0]) * dVar2.o) + fArr4[0];
        fArr4[0] = fArr4[0] / 360.0f;
        fArr4[1] = fArr4[1] / 360.0f;
        for (int i3 = 0; i3 < 4; i3++) {
            float fB3 = dVar2.b(i, d.f[i3], 333);
            if (fB3 >= 0.0f && fB3 <= 1.0f) {
                int i4 = i3 + dVar2.m;
                int[] iArr = dVar2.l.indicatorColors;
                int length = i4 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(iArr[length], dVar2.a.getAlpha());
                int iCompositeARGBWithAlpha2 = MaterialColors.compositeARGBWithAlpha(dVar2.l.indicatorColors[length2], dVar2.a.getAlpha());
                dVar2.c[0] = ArgbEvaluatorCompat.getInstance().evaluate2(dVar2.k.getInterpolation(fB3), Integer.valueOf(iCompositeARGBWithAlpha), Integer.valueOf(iCompositeARGBWithAlpha2)).intValue();
                break;
            }
        }
        dVar2.a.invalidateSelf();
    }
}

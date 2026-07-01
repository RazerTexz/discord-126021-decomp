package b.i.a.g.g;

import android.util.Property;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

/* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class l$a extends Property<l, Float> {
    public l$a(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public Float get(l lVar) {
        return Float.valueOf(lVar.l);
    }

    @Override // android.util.Property
    public void set(l lVar, Float f) {
        l lVar2 = lVar;
        float fFloatValue = f.floatValue();
        lVar2.l = fFloatValue;
        int i = (int) (fFloatValue * 1800.0f);
        for (int i2 = 0; i2 < 4; i2++) {
            lVar2.f1623b[i2] = Math.max(0.0f, Math.min(1.0f, lVar2.h[i2].getInterpolation(lVar2.b(i, l.e[i2], l.d[i2]))));
        }
        if (lVar2.k) {
            Arrays.fill(lVar2.c, MaterialColors.compositeARGBWithAlpha(lVar2.i.indicatorColors[lVar2.j], lVar2.a.getAlpha()));
            lVar2.k = false;
        }
        lVar2.a.invalidateSelf();
    }
}

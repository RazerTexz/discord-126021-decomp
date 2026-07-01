package b.i.a.g.g;

import android.util.Property;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class j$a extends Property<j, Float> {
    public j$a(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public Float get(j jVar) {
        return Float.valueOf(jVar.j);
    }

    @Override // android.util.Property
    public void set(j jVar, Float f) {
        j jVar2 = jVar;
        float fFloatValue = f.floatValue();
        jVar2.j = fFloatValue;
        jVar2.f1623b[0] = 0.0f;
        float fB = jVar2.b((int) (fFloatValue * 333.0f), 0, 667);
        float[] fArr = jVar2.f1623b;
        float interpolation = jVar2.f.getInterpolation(fB);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = jVar2.f1623b;
        float interpolation2 = jVar2.f.getInterpolation(fB + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        float[] fArr3 = jVar2.f1623b;
        fArr3[5] = 1.0f;
        if (jVar2.i && fArr3[3] < 1.0f) {
            int[] iArr = jVar2.c;
            iArr[2] = iArr[1];
            iArr[1] = iArr[0];
            iArr[0] = MaterialColors.compositeARGBWithAlpha(jVar2.g.indicatorColors[jVar2.h], jVar2.a.getAlpha());
            jVar2.i = false;
        }
        jVar2.a.invalidateSelf();
    }
}

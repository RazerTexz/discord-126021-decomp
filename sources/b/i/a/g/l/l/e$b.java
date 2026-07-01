package b.i.a.g.l.l;

import android.graphics.RectF;

/* JADX INFO: compiled from: FitModeEvaluators.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$b implements d {
    @Override // b.i.a.g.l.l.d
    public f a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = k.f(f5, f7, f2, f3, f, true);
        float f9 = f8 / f5;
        float f10 = f8 / f7;
        return new f(f9, f10, f4 * f9, f8, f6 * f10, f8);
    }

    @Override // b.i.a.g.l.l.d
    public boolean b(f fVar) {
        return fVar.c > fVar.e;
    }

    @Override // b.i.a.g.l.l.d
    public void c(RectF rectF, float f, f fVar) {
        float fAbs = (Math.abs(fVar.e - fVar.c) / 2.0f) * f;
        rectF.left += fAbs;
        rectF.right -= fAbs;
    }
}

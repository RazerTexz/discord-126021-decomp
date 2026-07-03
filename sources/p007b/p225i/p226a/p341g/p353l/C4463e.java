package p007b.p225i.p226a.p341g.p353l;

import android.graphics.RectF;

/* JADX INFO: renamed from: b.i.a.g.l.e */
/* JADX INFO: compiled from: FitModeEvaluators.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4463e {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4462d f11901a = new a();

    /* JADX INFO: renamed from: b */
    public static final InterfaceC4462d f11902b = new b();

    /* JADX INFO: renamed from: b.i.a.g.l.e$a */
    /* JADX INFO: compiled from: FitModeEvaluators.java */
    public static class a implements InterfaceC4462d {
        @Override // p007b.p225i.p226a.p341g.p353l.InterfaceC4462d
        /* JADX INFO: renamed from: a */
        public C4464f mo6183a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fM6191f = C4469k.m6191f(f4, f6, f2, f3, f, true);
            float f8 = fM6191f / f4;
            float f9 = fM6191f / f6;
            return new C4464f(f8, f9, fM6191f, f5 * f8, fM6191f, f7 * f9);
        }

        @Override // p007b.p225i.p226a.p341g.p353l.InterfaceC4462d
        /* JADX INFO: renamed from: b */
        public boolean mo6184b(C4464f c4464f) {
            return c4464f.f11906d > c4464f.f11908f;
        }

        @Override // p007b.p225i.p226a.p341g.p353l.InterfaceC4462d
        /* JADX INFO: renamed from: c */
        public void mo6185c(RectF rectF, float f, C4464f c4464f) {
            rectF.bottom -= Math.abs(c4464f.f11908f - c4464f.f11906d) * f;
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.e$b */
    /* JADX INFO: compiled from: FitModeEvaluators.java */
    public static class b implements InterfaceC4462d {
        @Override // p007b.p225i.p226a.p341g.p353l.InterfaceC4462d
        /* JADX INFO: renamed from: a */
        public C4464f mo6183a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fM6191f = C4469k.m6191f(f5, f7, f2, f3, f, true);
            float f8 = fM6191f / f5;
            float f9 = fM6191f / f7;
            return new C4464f(f8, f9, f4 * f8, fM6191f, f6 * f9, fM6191f);
        }

        @Override // p007b.p225i.p226a.p341g.p353l.InterfaceC4462d
        /* JADX INFO: renamed from: b */
        public boolean mo6184b(C4464f c4464f) {
            return c4464f.f11905c > c4464f.f11907e;
        }

        @Override // p007b.p225i.p226a.p341g.p353l.InterfaceC4462d
        /* JADX INFO: renamed from: c */
        public void mo6185c(RectF rectF, float f, C4464f c4464f) {
            float fAbs = (Math.abs(c4464f.f11907e - c4464f.f11905c) / 2.0f) * f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    }
}

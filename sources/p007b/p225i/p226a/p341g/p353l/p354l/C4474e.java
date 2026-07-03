package p007b.p225i.p226a.p341g.p353l.p354l;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.i.a.g.l.l.e */
/* JADX INFO: compiled from: FitModeEvaluators.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C4474e {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4473d f11923a = new a();

    /* JADX INFO: renamed from: b */
    public static final InterfaceC4473d f11924b = new b();

    /* JADX INFO: renamed from: b.i.a.g.l.l.e$a */
    /* JADX INFO: compiled from: FitModeEvaluators.java */
    public static class a implements InterfaceC4473d {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4473d
        /* JADX INFO: renamed from: a */
        public C4475f mo6197a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fM6205f = C4480k.m6205f(f4, f6, f2, f3, f, true);
            float f8 = fM6205f / f4;
            float f9 = fM6205f / f6;
            return new C4475f(f8, f9, fM6205f, f5 * f8, fM6205f, f7 * f9);
        }

        @Override // p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4473d
        /* JADX INFO: renamed from: b */
        public boolean mo6198b(C4475f c4475f) {
            return c4475f.f11928d > c4475f.f11930f;
        }

        @Override // p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4473d
        /* JADX INFO: renamed from: c */
        public void mo6199c(RectF rectF, float f, C4475f c4475f) {
            rectF.bottom -= Math.abs(c4475f.f11930f - c4475f.f11928d) * f;
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.l.e$b */
    /* JADX INFO: compiled from: FitModeEvaluators.java */
    public static class b implements InterfaceC4473d {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4473d
        /* JADX INFO: renamed from: a */
        public C4475f mo6197a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fM6205f = C4480k.m6205f(f5, f7, f2, f3, f, true);
            float f8 = fM6205f / f5;
            float f9 = fM6205f / f7;
            return new C4475f(f8, f9, f4 * f8, fM6205f, f6 * f9, fM6205f);
        }

        @Override // p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4473d
        /* JADX INFO: renamed from: b */
        public boolean mo6198b(C4475f c4475f) {
            return c4475f.f11927c > c4475f.f11929e;
        }

        @Override // p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4473d
        /* JADX INFO: renamed from: c */
        public void mo6199c(RectF rectF, float f, C4475f c4475f) {
            float fAbs = (Math.abs(c4475f.f11929e - c4475f.f11927c) / 2.0f) * f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    }
}

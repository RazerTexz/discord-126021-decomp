package b.i.a.g.l.l;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.i.a.g.l.l.e, reason: use source file name */
/* JADX INFO: compiled from: FitModeEvaluators.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class FitModeEvaluators2 {
    public static final FitModeEvaluator2 a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FitModeEvaluator2 f1638b = new b();

    /* JADX INFO: renamed from: b.i.a.g.l.l.e$a */
    /* JADX INFO: compiled from: FitModeEvaluators.java */
    public static class a implements FitModeEvaluator2 {
        @Override // b.i.a.g.l.l.FitModeEvaluator2
        public FitModeResult2 a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float f8 = TransitionUtils5.f(f4, f6, f2, f3, f, true);
            float f9 = f8 / f4;
            float f10 = f8 / f6;
            return new FitModeResult2(f9, f10, f8, f5 * f9, f8, f7 * f10);
        }

        @Override // b.i.a.g.l.l.FitModeEvaluator2
        public boolean b(FitModeResult2 fitModeResult2) {
            return fitModeResult2.d > fitModeResult2.f;
        }

        @Override // b.i.a.g.l.l.FitModeEvaluator2
        public void c(RectF rectF, float f, FitModeResult2 fitModeResult2) {
            rectF.bottom -= Math.abs(fitModeResult2.f - fitModeResult2.d) * f;
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.l.e$b */
    /* JADX INFO: compiled from: FitModeEvaluators.java */
    public static class b implements FitModeEvaluator2 {
        @Override // b.i.a.g.l.l.FitModeEvaluator2
        public FitModeResult2 a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float f8 = TransitionUtils5.f(f5, f7, f2, f3, f, true);
            float f9 = f8 / f5;
            float f10 = f8 / f7;
            return new FitModeResult2(f9, f10, f4 * f9, f8, f6 * f10, f8);
        }

        @Override // b.i.a.g.l.l.FitModeEvaluator2
        public boolean b(FitModeResult2 fitModeResult2) {
            return fitModeResult2.c > fitModeResult2.e;
        }

        @Override // b.i.a.g.l.l.FitModeEvaluator2
        public void c(RectF rectF, float f, FitModeResult2 fitModeResult2) {
            float fAbs = (Math.abs(fitModeResult2.e - fitModeResult2.c) / 2.0f) * f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    }
}

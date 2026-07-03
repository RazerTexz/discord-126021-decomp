package p007b.p225i.p226a.p341g.p353l;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.g.l.k */
/* JADX INFO: compiled from: TransitionUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4469k {

    /* JADX INFO: renamed from: a */
    public static final RectF f11915a = new RectF();

    /* JADX INFO: renamed from: b.i.a.g.l.k$a */
    /* JADX INFO: compiled from: TransitionUtils.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo6194a(Canvas canvas);
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static <T> T m6186a(@Nullable T t, @NonNull T t2) {
        return t != null ? t : t2;
    }

    /* JADX INFO: renamed from: b */
    public static View m6187b(View view, @IdRes int i) {
        String resourceName = view.getResources().getResourceName(i);
        while (view != null) {
            if (view.getId() != i) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(C1643a.m883w(resourceName, " is not a valid ancestor"));
    }

    /* JADX INFO: renamed from: c */
    public static RectF m6188c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new RectF(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    /* JADX INFO: renamed from: d */
    public static float m6189d(float f, float f2, float f3) {
        return C1643a.m839a(f2, f, f3, f);
    }

    /* JADX INFO: renamed from: e */
    public static float m6190e(float f, float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3, @FloatRange(from = 0.0d, m75to = 1.0d) float f4, @FloatRange(from = 0.0d, m75to = 1.0d) float f5) {
        return m6191f(f, f2, f3, f4, f5, false);
    }

    /* JADX INFO: renamed from: f */
    public static float m6191f(float f, float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3, @FloatRange(from = 0.0d, m75to = 1.0d) float f4, @FloatRange(from = 0.0d) float f5, boolean z2) {
        if (z2 && (f5 < 0.0f || f5 > 1.0f)) {
            return m6189d(f, f2, f5);
        }
        if (f5 < f3) {
            return f;
        }
        return f5 > f4 ? f2 : m6189d(f, f2, (f5 - f3) / (f4 - f3));
    }

    /* JADX INFO: renamed from: g */
    public static int m6192g(int i, int i2, @FloatRange(from = 0.0d, m75to = 1.0d) float f, @FloatRange(from = 0.0d, m75to = 1.0d) float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3) {
        if (f3 < f) {
            return i;
        }
        return f3 > f2 ? i2 : (int) m6189d(i, i2, (f3 - f) / (f2 - f));
    }

    /* JADX INFO: renamed from: h */
    public static void m6193h(Canvas canvas, Rect rect, float f, float f2, float f3, int i, a aVar) {
        if (i <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f3, f3);
        if (i < 255) {
            RectF rectF = f11915a;
            rectF.set(rect);
            canvas.saveLayerAlpha(rectF, i);
        }
        aVar.mo6194a(canvas);
        canvas.restoreToCount(iSave);
    }
}

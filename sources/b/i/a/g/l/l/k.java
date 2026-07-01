package b.i.a.g.l.l;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: TransitionUtils.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class k {
    public static final RectF a = new RectF();

    @NonNull
    public static <T> T a(@Nullable T t, @NonNull T t2) {
        return t != null ? t : t2;
    }

    public static View b(View view, @IdRes int i) {
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
        throw new IllegalArgumentException(b.d.b.a.a.w(resourceName, " is not a valid ancestor"));
    }

    public static RectF c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new RectF(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    public static float d(float f, float f2, float f3) {
        return b.d.b.a.a.a(f2, f, f3, f);
    }

    public static float e(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        return f(f, f2, f3, f4, f5, false);
    }

    public static float f(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d) float f5, boolean z2) {
        if (z2 && (f5 < 0.0f || f5 > 1.0f)) {
            return d(f, f2, f5);
        }
        if (f5 < f3) {
            return f;
        }
        return f5 > f4 ? f2 : d(f, f2, (f5 - f3) / (f4 - f3));
    }

    public static int g(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        if (f3 < f) {
            return i;
        }
        return f3 > f2 ? i2 : (int) d(i, i2, (f3 - f) / (f2 - f));
    }

    public static void h(Canvas canvas, Rect rect, float f, float f2, float f3, int i, k$a k_a) {
        if (i <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f3, f3);
        if (i < 255) {
            RectF rectF = a;
            rectF.set(rect);
            canvas.saveLayerAlpha(rectF, i);
        }
        k_a.a(canvas);
        canvas.restoreToCount(iSave);
    }
}

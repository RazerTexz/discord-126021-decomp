package b.i.a.g.g;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: renamed from: b.i.a.g.g.f, reason: use source file name */
/* JADX INFO: compiled from: DrawingDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    public S a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DrawableWithAnimatedVisibilityChange f1622b;

    public DrawingDelegate(S s2) {
        this.a = s2;
    }

    public abstract void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f);

    public abstract void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @ColorInt int i);

    public abstract void c(@NonNull Canvas canvas, @NonNull Paint paint);

    public abstract int d();

    public abstract int e();
}

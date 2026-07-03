package p007b.p225i.p226a.p341g.p348g;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: renamed from: b.i.a.g.g.f */
/* JADX INFO: compiled from: DrawingDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4420f<S extends BaseProgressIndicatorSpec> {

    /* JADX INFO: renamed from: a */
    public S f11734a;

    /* JADX INFO: renamed from: b */
    public AbstractC4419e f11735b;

    public AbstractC4420f(S s2) {
        this.f11734a = s2;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo6117a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, m75to = 1.0d) float f);

    /* JADX INFO: renamed from: b */
    public abstract void mo6118b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, m75to = 1.0d) float f, @FloatRange(from = 0.0d, m75to = 1.0d) float f2, @ColorInt int i);

    /* JADX INFO: renamed from: c */
    public abstract void mo6119c(@NonNull Canvas canvas, @NonNull Paint paint);

    /* JADX INFO: renamed from: d */
    public abstract int mo6120d();

    /* JADX INFO: renamed from: e */
    public abstract int mo6121e();
}

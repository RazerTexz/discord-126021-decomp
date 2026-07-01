package b.o.a.q;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: GestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public a f1947b;
    public PointF[] c;

    public c(@NonNull c$a c_a, int i) {
        this.c = new PointF[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.c[i2] = new PointF(0.0f, 0.0f);
        }
    }

    public final float a(float f, float f2, float f3) {
        float fB = b(f, f2, f3);
        if (fB < f2) {
            fB = f2;
        }
        if (fB > f3) {
            fB = f3;
        }
        float f4 = ((f3 - f2) / 50.0f) / 2.0f;
        return (fB < f - f4 || fB > f4 + f) ? fB : f;
    }

    public abstract float b(float f, float f2, float f3);
}

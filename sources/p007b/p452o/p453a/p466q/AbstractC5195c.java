package p007b.p452o.p453a.p466q;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: renamed from: b.o.a.q.c */
/* JADX INFO: compiled from: GestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5195c {

    /* JADX INFO: renamed from: a */
    public boolean f14081a;

    /* JADX INFO: renamed from: b */
    @VisibleForTesting
    public EnumC5193a f14082b;

    /* JADX INFO: renamed from: c */
    public PointF[] f14083c;

    /* JADX INFO: renamed from: b.o.a.q.c$a */
    /* JADX INFO: compiled from: GestureFinder.java */
    public interface a {
    }

    public AbstractC5195c(@NonNull a aVar, int i) {
        this.f14083c = new PointF[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f14083c[i2] = new PointF(0.0f, 0.0f);
        }
    }

    /* JADX INFO: renamed from: a */
    public final float m7392a(float f, float f2, float f3) {
        float fMo7393b = mo7393b(f, f2, f3);
        if (fMo7393b < f2) {
            fMo7393b = f2;
        }
        if (fMo7393b > f3) {
            fMo7393b = f3;
        }
        float f4 = ((f3 - f2) / 50.0f) / 2.0f;
        return (fMo7393b < f - f4 || fMo7393b > f4 + f) ? fMo7393b : f;
    }

    /* JADX INFO: renamed from: b */
    public abstract float mo7393b(float f, float f2, float f3);
}

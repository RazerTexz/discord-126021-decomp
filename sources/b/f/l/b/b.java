package b.f.l.b;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AnimatedZoomableController.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ValueAnimator f649s;

    @SuppressLint({"NewApi"})
    public b(b.f.l.a.b bVar) {
        super(bVar);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f649s = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
    }

    @Override // b.f.l.b.a
    public Class<?> m() {
        return b.class;
    }

    @Override // b.f.l.b.a
    @SuppressLint({"NewApi"})
    public void n(Matrix matrix, long j, @Nullable Runnable runnable) {
        int i = b.f.d.e.a.a;
        o();
        b.c.a.a0.d.i(Boolean.valueOf(j > 0));
        b.c.a.a0.d.B(!this.m);
        this.m = true;
        this.f649s.setDuration(j);
        this.h.getValues(this.n);
        matrix.getValues(this.o);
        this.f649s.addUpdateListener(new b$a(this));
        this.f649s.addListener(new b$b(this, runnable));
        this.f649s.start();
    }

    @Override // b.f.l.b.a
    @SuppressLint({"NewApi"})
    public void o() {
        if (this.m) {
            b.f.d.e.a.i(b.class, "stopAnimation");
            this.f649s.cancel();
            this.f649s.removeAllUpdateListeners();
            this.f649s.removeAllListeners();
        }
    }
}

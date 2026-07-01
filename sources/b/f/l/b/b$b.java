package b.f.l.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.Objects;

/* JADX INFO: compiled from: AnimatedZoomableController.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$b extends AnimatorListenerAdapter {
    public final /* synthetic */ Runnable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f650b;

    public b$b(b bVar, Runnable runnable) {
        this.f650b = bVar;
        this.a = runnable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Objects.requireNonNull(this.f650b);
        b.f.d.e.a.i(b.class, "setTransformAnimated: animation cancelled");
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
        b bVar = this.f650b;
        bVar.m = false;
        bVar.a.d();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Objects.requireNonNull(this.f650b);
        b.f.d.e.a.i(b.class, "setTransformAnimated: animation finished");
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
        b bVar = this.f650b;
        bVar.m = false;
        bVar.a.d();
    }
}

package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton$a;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f$f f1614b;
    public final /* synthetic */ f c;

    public e(f fVar, boolean z2, f$f f_f) {
        this.c = fVar;
        this.a = z2;
        this.f1614b = f_f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        f fVar = this.c;
        fVar.B = 0;
        fVar.v = null;
        f$f f_f = this.f1614b;
        if (f_f != null) {
            FloatingActionButton$a floatingActionButton$a = (FloatingActionButton$a) f_f;
            floatingActionButton$a.a.onShown(floatingActionButton$a.f3040b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.c.F.internalSetVisibility(0, this.a);
        f fVar = this.c;
        fVar.B = 2;
        fVar.v = animator;
    }
}

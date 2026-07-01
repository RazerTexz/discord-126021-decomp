package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton$a;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends AnimatorListenerAdapter {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1613b;
    public final /* synthetic */ f$f c;
    public final /* synthetic */ f d;

    public d(f fVar, boolean z2, f$f f_f) {
        this.d = fVar;
        this.f1613b = z2;
        this.c = f_f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        f fVar = this.d;
        fVar.B = 0;
        fVar.v = null;
        if (this.a) {
            return;
        }
        FloatingActionButton floatingActionButton = fVar.F;
        boolean z2 = this.f1613b;
        floatingActionButton.internalSetVisibility(z2 ? 8 : 4, z2);
        f$f f_f = this.c;
        if (f_f != null) {
            FloatingActionButton$a floatingActionButton$a = (FloatingActionButton$a) f_f;
            floatingActionButton$a.a.onHidden(floatingActionButton$a.f3040b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.F.internalSetVisibility(0, this.f1613b);
        f fVar = this.d;
        fVar.B = 1;
        fVar.v = animator;
        this.a = false;
    }
}

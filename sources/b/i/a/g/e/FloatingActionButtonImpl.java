package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import b.i.a.g.e.FloatingActionButtonImpl3;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: renamed from: b.i.a.g.e.d, reason: use source file name */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButtonImpl extends AnimatorListenerAdapter {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1613b;
    public final /* synthetic */ FloatingActionButtonImpl3.f c;
    public final /* synthetic */ FloatingActionButtonImpl3 d;

    public FloatingActionButtonImpl(FloatingActionButtonImpl3 floatingActionButtonImpl3, boolean z2, FloatingActionButtonImpl3.f fVar) {
        this.d = floatingActionButtonImpl3;
        this.f1613b = z2;
        this.c = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        FloatingActionButtonImpl3 floatingActionButtonImpl3 = this.d;
        floatingActionButtonImpl3.B = 0;
        floatingActionButtonImpl3.v = null;
        if (this.a) {
            return;
        }
        FloatingActionButton floatingActionButton = floatingActionButtonImpl3.F;
        boolean z2 = this.f1613b;
        floatingActionButton.internalSetVisibility(z2 ? 8 : 4, z2);
        FloatingActionButtonImpl3.f fVar = this.c;
        if (fVar != null) {
            FloatingActionButton.a aVar = (FloatingActionButton.a) fVar;
            aVar.a.onHidden(FloatingActionButton.this);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.F.internalSetVisibility(0, this.f1613b);
        FloatingActionButtonImpl3 floatingActionButtonImpl3 = this.d;
        floatingActionButtonImpl3.B = 1;
        floatingActionButtonImpl3.v = animator;
        this.a = false;
    }
}

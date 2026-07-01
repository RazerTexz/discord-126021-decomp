package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import b.i.a.g.e.FloatingActionButtonImpl3;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: renamed from: b.i.a.g.e.e, reason: use source file name */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButtonImpl2 extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FloatingActionButtonImpl3.f f1614b;
    public final /* synthetic */ FloatingActionButtonImpl3 c;

    public FloatingActionButtonImpl2(FloatingActionButtonImpl3 floatingActionButtonImpl3, boolean z2, FloatingActionButtonImpl3.f fVar) {
        this.c = floatingActionButtonImpl3;
        this.a = z2;
        this.f1614b = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        FloatingActionButtonImpl3 floatingActionButtonImpl3 = this.c;
        floatingActionButtonImpl3.B = 0;
        floatingActionButtonImpl3.v = null;
        FloatingActionButtonImpl3.f fVar = this.f1614b;
        if (fVar != null) {
            FloatingActionButton.a aVar = (FloatingActionButton.a) fVar;
            aVar.a.onShown(FloatingActionButton.this);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.c.F.internalSetVisibility(0, this.a);
        FloatingActionButtonImpl3 floatingActionButtonImpl3 = this.c;
        floatingActionButtonImpl3.B = 2;
        floatingActionButtonImpl3.v = animator;
    }
}

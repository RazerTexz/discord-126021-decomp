package p007b.p225i.p226a.p341g.p346e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: renamed from: b.i.a.g.e.e */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4407e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ boolean f11649a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C4408f.f f11650b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C4408f f11651c;

    public C4407e(C4408f c4408f, boolean z2, C4408f.f fVar) {
        this.f11651c = c4408f;
        this.f11649a = z2;
        this.f11650b = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C4408f c4408f = this.f11651c;
        c4408f.f11660B = 0;
        c4408f.f11685v = null;
        C4408f.f fVar = this.f11650b;
        if (fVar != null) {
            FloatingActionButton.C10919a c10919a = (FloatingActionButton.C10919a) fVar;
            c10919a.f21018a.onShown(FloatingActionButton.this);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f11651c.f11664F.internalSetVisibility(0, this.f11649a);
        C4408f c4408f = this.f11651c;
        c4408f.f11660B = 2;
        c4408f.f11685v = animator;
    }
}

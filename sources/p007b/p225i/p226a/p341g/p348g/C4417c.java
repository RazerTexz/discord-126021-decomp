package p007b.p225i.p226a.p341g.p348g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.g.c */
/* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4417c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4418d f11718a;

    public C4417c(C4418d c4418d) {
        this.f11718a = c4418d;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.f11718a.mo6123a();
        C4418d c4418d = this.f11718a;
        c4418d.f11731p.onAnimationEnd(c4418d.f11736a);
    }
}

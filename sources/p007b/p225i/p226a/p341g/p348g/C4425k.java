package p007b.p225i.p226a.p341g.p348g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.g.k */
/* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4425k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4426l f11750a;

    public C4425k(C4426l c4426l) {
        this.f11750a = c4426l;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        C4426l c4426l = this.f11750a;
        if (c4426l.f11760m) {
            c4426l.f11754g.setRepeatCount(-1);
            C4426l c4426l2 = this.f11750a;
            c4426l2.f11761n.onAnimationEnd(c4426l2.f11736a);
            this.f11750a.f11760m = false;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        C4426l c4426l = this.f11750a;
        c4426l.f11757j = (c4426l.f11757j + 1) % c4426l.f11756i.indicatorColors.length;
        c4426l.f11758k = true;
    }
}

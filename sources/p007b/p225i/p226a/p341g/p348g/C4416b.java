package p007b.p225i.p226a.p341g.p348g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.g.b */
/* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4416b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4418d f11717a;

    public C4416b(C4418d c4418d) {
        this.f11717a = c4418d;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        C4418d c4418d = this.f11717a;
        c4418d.f11728m = (c4418d.f11728m + 4) % c4418d.f11727l.indicatorColors.length;
    }
}

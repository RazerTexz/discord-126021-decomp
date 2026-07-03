package p007b.p225i.p226a.p341g.p348g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.g.i */
/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4423i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4424j f11742a;

    public C4423i(C4424j c4424j) {
        this.f11742a = c4424j;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        C4424j c4424j = this.f11742a;
        c4424j.f11747h = (c4424j.f11747h + 1) % c4424j.f11746g.indicatorColors.length;
        c4424j.f11748i = true;
    }
}

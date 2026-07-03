package p007b.p225i.p226a.p341g.p351j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.j.b */
/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4431b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4430a f11784a;

    public C4431b(C4430a c4430a) {
        this.f11784a = c4430a;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f11784a.f11819a.setEndIconVisible(true);
    }
}

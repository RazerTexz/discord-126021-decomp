package p007b.p225i.p226a.p341g.p351j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.j.c */
/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4432c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4430a f11785a;

    public C4432c(C4430a c4430a) {
        this.f11785a = c4430a;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f11785a.f11819a.setEndIconVisible(false);
    }
}

package p007b.p225i.p226a.p341g.p351j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.j.l */
/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4441l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4437h f11818a;

    public C4441l(C4437h c4437h) {
        this.f11818a = c4437h;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C4437h c4437h = this.f11818a;
        c4437h.f11821c.setChecked(c4437h.f11797j);
        this.f11818a.f11803p.start();
    }
}

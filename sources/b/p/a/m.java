package b.p.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup$LayoutParams;

/* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup$LayoutParams f1975b;
    public final /* synthetic */ int c;

    public m(l lVar, ViewGroup$LayoutParams viewGroup$LayoutParams, int i) {
        this.a = lVar;
        this.f1975b = viewGroup$LayoutParams;
        this.c = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d0.z.d.m.checkNotNullParameter(animator, "animation");
        l lVar = this.a;
        lVar.u.onDismiss(lVar.t);
        this.a.t.setAlpha(1.0f);
        this.a.t.setTranslationX(0.0f);
        ViewGroup$LayoutParams viewGroup$LayoutParams = this.f1975b;
        viewGroup$LayoutParams.height = this.c;
        this.a.t.setLayoutParams(viewGroup$LayoutParams);
    }
}

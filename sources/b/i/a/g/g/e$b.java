package b.i.a.g.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$b extends AnimatorListenerAdapter {
    public final /* synthetic */ e a;

    public e$b(e eVar) {
        this.a = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        e.access$101(this.a, false, false);
        e.access$200(this.a);
    }
}

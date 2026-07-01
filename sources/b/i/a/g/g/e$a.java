package b.i.a.g.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$a extends AnimatorListenerAdapter {
    public final /* synthetic */ e a;

    public e$a(e eVar) {
        this.a = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        e.access$000(this.a);
    }
}

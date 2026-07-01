package b.a.y;

import android.animation.Animator;
import android.view.View;
import android.view.View$OnAttachStateChangeListener;

/* JADX INFO: compiled from: OverlayAppDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l$b implements View$OnAttachStateChangeListener {
    public final /* synthetic */ Animator j;

    public l$b(Animator animator) {
        this.j = animator;
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.j.end();
    }
}

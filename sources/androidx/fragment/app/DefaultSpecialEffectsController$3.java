package androidx.fragment.app;

import android.animation.Animator;
import androidx.core.os.CancellationSignal$OnCancelListener;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$3 implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ Animator val$animator;

    public DefaultSpecialEffectsController$3(DefaultSpecialEffectsController defaultSpecialEffectsController, Animator animator) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$animator = animator;
    }

    @Override // androidx.core.os.CancellationSignal$OnCancelListener
    public void onCancel() {
        this.val$animator.end();
    }
}

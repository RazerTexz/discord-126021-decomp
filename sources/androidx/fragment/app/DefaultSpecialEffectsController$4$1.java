package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$4$1 implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController$4 this$1;

    public DefaultSpecialEffectsController$4$1(DefaultSpecialEffectsController$4 defaultSpecialEffectsController$4) {
        this.this$1 = defaultSpecialEffectsController$4;
    }

    @Override // java.lang.Runnable
    public void run() {
        DefaultSpecialEffectsController$4 defaultSpecialEffectsController$4 = this.this$1;
        defaultSpecialEffectsController$4.val$container.endViewTransition(defaultSpecialEffectsController$4.val$viewToAnimate);
        this.this$1.val$animationInfo.completeSpecialEffect();
    }
}

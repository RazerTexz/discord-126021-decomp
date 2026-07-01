package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$9 implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ DefaultSpecialEffectsController$TransitionInfo val$transitionInfo;

    public DefaultSpecialEffectsController$9(DefaultSpecialEffectsController defaultSpecialEffectsController, DefaultSpecialEffectsController$TransitionInfo defaultSpecialEffectsController$TransitionInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$transitionInfo = defaultSpecialEffectsController$TransitionInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$transitionInfo.completeSpecialEffect();
    }
}

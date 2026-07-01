package androidx.fragment.app;

import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$6 implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ SpecialEffectsController$Operation val$firstOut;
    public final /* synthetic */ boolean val$isPop;
    public final /* synthetic */ SpecialEffectsController$Operation val$lastIn;
    public final /* synthetic */ ArrayMap val$lastInViews;

    public DefaultSpecialEffectsController$6(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController$Operation specialEffectsController$Operation, SpecialEffectsController$Operation specialEffectsController$Operation2, boolean z2, ArrayMap arrayMap) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$lastIn = specialEffectsController$Operation;
        this.val$firstOut = specialEffectsController$Operation2;
        this.val$isPop = z2;
        this.val$lastInViews = arrayMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        FragmentTransition.callSharedElementStartEnd(this.val$lastIn.getFragment(), this.val$firstOut.getFragment(), this.val$isPop, this.val$lastInViews, false);
    }
}

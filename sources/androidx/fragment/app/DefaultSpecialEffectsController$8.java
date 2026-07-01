package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$8 implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ ArrayList val$transitioningViews;

    public DefaultSpecialEffectsController$8(DefaultSpecialEffectsController defaultSpecialEffectsController, ArrayList arrayList) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$transitioningViews = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        FragmentTransition.setViewVisibility(this.val$transitioningViews, 4);
    }
}

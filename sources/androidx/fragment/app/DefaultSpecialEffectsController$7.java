package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$7 implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ FragmentTransitionImpl val$impl;
    public final /* synthetic */ Rect val$lastInEpicenterRect;
    public final /* synthetic */ View val$lastInEpicenterView;

    public DefaultSpecialEffectsController$7(DefaultSpecialEffectsController defaultSpecialEffectsController, FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$impl = fragmentTransitionImpl;
        this.val$lastInEpicenterView = view;
        this.val$lastInEpicenterRect = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$impl.getBoundsOnScreen(this.val$lastInEpicenterView, this.val$lastInEpicenterRect);
    }
}

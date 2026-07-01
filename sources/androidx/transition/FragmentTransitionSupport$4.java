package androidx.transition;

import android.graphics.Rect;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransitionSupport$4 extends Transition$EpicenterCallback {
    public final /* synthetic */ FragmentTransitionSupport this$0;
    public final /* synthetic */ Rect val$epicenter;

    public FragmentTransitionSupport$4(FragmentTransitionSupport fragmentTransitionSupport, Rect rect) {
        this.this$0 = fragmentTransitionSupport;
        this.val$epicenter = rect;
    }

    @Override // androidx.transition.Transition$EpicenterCallback
    public Rect onGetEpicenter(@NonNull Transition transition) {
        Rect rect = this.val$epicenter;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.val$epicenter;
    }
}

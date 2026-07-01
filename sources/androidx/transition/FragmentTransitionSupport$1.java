package androidx.transition;

import android.graphics.Rect;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransitionSupport$1 extends Transition$EpicenterCallback {
    public final /* synthetic */ FragmentTransitionSupport this$0;
    public final /* synthetic */ Rect val$epicenter;

    public FragmentTransitionSupport$1(FragmentTransitionSupport fragmentTransitionSupport, Rect rect) {
        this.this$0 = fragmentTransitionSupport;
        this.val$epicenter = rect;
    }

    @Override // androidx.transition.Transition$EpicenterCallback
    public Rect onGetEpicenter(@NonNull Transition transition) {
        return this.val$epicenter;
    }
}

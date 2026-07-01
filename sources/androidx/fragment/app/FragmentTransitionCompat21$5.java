package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition$EpicenterCallback;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransitionCompat21$5 extends Transition$EpicenterCallback {
    public final /* synthetic */ FragmentTransitionCompat21 this$0;
    public final /* synthetic */ Rect val$epicenter;

    public FragmentTransitionCompat21$5(FragmentTransitionCompat21 fragmentTransitionCompat21, Rect rect) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$epicenter = rect;
    }

    @Override // android.transition.Transition$EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        Rect rect = this.val$epicenter;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.val$epicenter;
    }
}

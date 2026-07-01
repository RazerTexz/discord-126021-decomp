package androidx.transition;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds$9 extends TransitionListenerAdapter {
    public boolean mCanceled = false;
    public final /* synthetic */ ChangeBounds this$0;
    public final /* synthetic */ ViewGroup val$parent;

    public ChangeBounds$9(ChangeBounds changeBounds, ViewGroup viewGroup) {
        this.this$0 = changeBounds;
        this.val$parent = viewGroup;
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionCancel(@NonNull Transition transition) {
        ViewGroupUtils.suppressLayout(this.val$parent, false);
        this.mCanceled = true;
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        if (!this.mCanceled) {
            ViewGroupUtils.suppressLayout(this.val$parent, false);
        }
        transition.removeListener(this);
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionPause(@NonNull Transition transition) {
        ViewGroupUtils.suppressLayout(this.val$parent, false);
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionResume(@NonNull Transition transition) {
        ViewGroupUtils.suppressLayout(this.val$parent, true);
    }
}

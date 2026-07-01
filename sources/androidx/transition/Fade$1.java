package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class Fade$1 extends TransitionListenerAdapter {
    public final /* synthetic */ Fade this$0;
    public final /* synthetic */ View val$view;

    public Fade$1(Fade fade, View view) {
        this.this$0 = fade;
        this.val$view = view;
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        ViewUtils.setTransitionAlpha(this.val$view, 1.0f);
        ViewUtils.clearNonTransitionAlpha(this.val$view);
        transition.removeListener(this);
    }
}

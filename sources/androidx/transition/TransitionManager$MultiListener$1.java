package androidx.transition;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TransitionManager$MultiListener$1 extends TransitionListenerAdapter {
    public final /* synthetic */ TransitionManager$MultiListener this$0;
    public final /* synthetic */ ArrayMap val$runningTransitions;

    public TransitionManager$MultiListener$1(TransitionManager$MultiListener transitionManager$MultiListener, ArrayMap arrayMap) {
        this.this$0 = transitionManager$MultiListener;
        this.val$runningTransitions = arrayMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        ((ArrayList) this.val$runningTransitions.get(this.this$0.mSceneRoot)).remove(transition);
        transition.removeListener(this);
    }
}

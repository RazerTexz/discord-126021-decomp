package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransitionSupport$2 implements Transition$TransitionListener {
    public final /* synthetic */ FragmentTransitionSupport this$0;
    public final /* synthetic */ ArrayList val$exitingViews;
    public final /* synthetic */ View val$fragmentView;

    public FragmentTransitionSupport$2(FragmentTransitionSupport fragmentTransitionSupport, View view, ArrayList arrayList) {
        this.this$0 = fragmentTransitionSupport;
        this.val$fragmentView = view;
        this.val$exitingViews = arrayList;
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionCancel(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        transition.removeListener(this);
        this.val$fragmentView.setVisibility(8);
        int size = this.val$exitingViews.size();
        for (int i = 0; i < size; i++) {
            ((View) this.val$exitingViews.get(i)).setVisibility(0);
        }
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionPause(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionResume(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionStart(@NonNull Transition transition) {
    }
}

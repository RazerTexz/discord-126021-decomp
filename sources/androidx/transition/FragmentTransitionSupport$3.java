package androidx.transition;

import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransitionSupport$3 extends TransitionListenerAdapter {
    public final /* synthetic */ FragmentTransitionSupport this$0;
    public final /* synthetic */ Object val$enterTransition;
    public final /* synthetic */ ArrayList val$enteringViews;
    public final /* synthetic */ Object val$exitTransition;
    public final /* synthetic */ ArrayList val$exitingViews;
    public final /* synthetic */ Object val$sharedElementTransition;
    public final /* synthetic */ ArrayList val$sharedElementsIn;

    public FragmentTransitionSupport$3(FragmentTransitionSupport fragmentTransitionSupport, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.this$0 = fragmentTransitionSupport;
        this.val$enterTransition = obj;
        this.val$enteringViews = arrayList;
        this.val$exitTransition = obj2;
        this.val$exitingViews = arrayList2;
        this.val$sharedElementTransition = obj3;
        this.val$sharedElementsIn = arrayList3;
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        transition.removeListener(this);
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionStart(@NonNull Transition transition) {
        Object obj = this.val$enterTransition;
        if (obj != null) {
            this.this$0.replaceTargets(obj, this.val$enteringViews, null);
        }
        Object obj2 = this.val$exitTransition;
        if (obj2 != null) {
            this.this$0.replaceTargets(obj2, this.val$exitingViews, null);
        }
        Object obj3 = this.val$sharedElementTransition;
        if (obj3 != null) {
            this.this$0.replaceTargets(obj3, this.val$sharedElementsIn, null);
        }
    }
}

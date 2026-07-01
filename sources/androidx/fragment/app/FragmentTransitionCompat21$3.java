package androidx.fragment.app;

import android.transition.Transition;
import android.transition.Transition$TransitionListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransitionCompat21$3 implements Transition$TransitionListener {
    public final /* synthetic */ FragmentTransitionCompat21 this$0;
    public final /* synthetic */ Object val$enterTransition;
    public final /* synthetic */ ArrayList val$enteringViews;
    public final /* synthetic */ Object val$exitTransition;
    public final /* synthetic */ ArrayList val$exitingViews;
    public final /* synthetic */ Object val$sharedElementTransition;
    public final /* synthetic */ ArrayList val$sharedElementsIn;

    public FragmentTransitionCompat21$3(FragmentTransitionCompat21 fragmentTransitionCompat21, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$enterTransition = obj;
        this.val$enteringViews = arrayList;
        this.val$exitTransition = obj2;
        this.val$exitingViews = arrayList2;
        this.val$sharedElementTransition = obj3;
        this.val$sharedElementsIn = arrayList3;
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionStart(Transition transition) {
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

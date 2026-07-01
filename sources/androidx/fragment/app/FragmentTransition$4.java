package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransition$4 implements Runnable {
    public final /* synthetic */ Object val$enterTransition;
    public final /* synthetic */ ArrayList val$enteringViews;
    public final /* synthetic */ Object val$exitTransition;
    public final /* synthetic */ ArrayList val$exitingViews;
    public final /* synthetic */ FragmentTransitionImpl val$impl;
    public final /* synthetic */ Fragment val$inFragment;
    public final /* synthetic */ View val$nonExistentView;
    public final /* synthetic */ ArrayList val$sharedElementsIn;

    public FragmentTransition$4(Object obj, FragmentTransitionImpl fragmentTransitionImpl, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.val$enterTransition = obj;
        this.val$impl = fragmentTransitionImpl;
        this.val$nonExistentView = view;
        this.val$inFragment = fragment;
        this.val$sharedElementsIn = arrayList;
        this.val$enteringViews = arrayList2;
        this.val$exitingViews = arrayList3;
        this.val$exitTransition = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.val$enterTransition;
        if (obj != null) {
            this.val$impl.removeTarget(obj, this.val$nonExistentView);
            this.val$enteringViews.addAll(FragmentTransition.configureEnteringExitingViews(this.val$impl, this.val$enterTransition, this.val$inFragment, this.val$sharedElementsIn, this.val$nonExistentView));
        }
        if (this.val$exitingViews != null) {
            if (this.val$exitTransition != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.val$nonExistentView);
                this.val$impl.replaceTargets(this.val$exitTransition, this.val$exitingViews, arrayList);
            }
            this.val$exitingViews.clear();
            this.val$exitingViews.add(this.val$nonExistentView);
        }
    }
}

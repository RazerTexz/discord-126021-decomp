package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransition$5 implements Runnable {
    public final /* synthetic */ Rect val$epicenter;
    public final /* synthetic */ View val$epicenterView;
    public final /* synthetic */ FragmentTransitionImpl val$impl;
    public final /* synthetic */ Fragment val$inFragment;
    public final /* synthetic */ boolean val$inIsPop;
    public final /* synthetic */ ArrayMap val$inSharedElements;
    public final /* synthetic */ Fragment val$outFragment;

    public FragmentTransition$5(Fragment fragment, Fragment fragment2, boolean z2, ArrayMap arrayMap, View view, FragmentTransitionImpl fragmentTransitionImpl, Rect rect) {
        this.val$inFragment = fragment;
        this.val$outFragment = fragment2;
        this.val$inIsPop = z2;
        this.val$inSharedElements = arrayMap;
        this.val$epicenterView = view;
        this.val$impl = fragmentTransitionImpl;
        this.val$epicenter = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
        View view = this.val$epicenterView;
        if (view != null) {
            this.val$impl.getBoundsOnScreen(view, this.val$epicenter);
        }
    }
}

package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransition$6 implements Runnable {
    public final /* synthetic */ Object val$enterTransition;
    public final /* synthetic */ Object val$finalSharedElementTransition;
    public final /* synthetic */ FragmentTransition$FragmentContainerTransition val$fragments;
    public final /* synthetic */ FragmentTransitionImpl val$impl;
    public final /* synthetic */ Rect val$inEpicenter;
    public final /* synthetic */ Fragment val$inFragment;
    public final /* synthetic */ boolean val$inIsPop;
    public final /* synthetic */ ArrayMap val$nameOverrides;
    public final /* synthetic */ View val$nonExistentView;
    public final /* synthetic */ Fragment val$outFragment;
    public final /* synthetic */ ArrayList val$sharedElementsIn;
    public final /* synthetic */ ArrayList val$sharedElementsOut;

    public FragmentTransition$6(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap arrayMap, Object obj, FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z2, ArrayList arrayList2, Object obj2, Rect rect) {
        this.val$impl = fragmentTransitionImpl;
        this.val$nameOverrides = arrayMap;
        this.val$finalSharedElementTransition = obj;
        this.val$fragments = fragmentTransition$FragmentContainerTransition;
        this.val$sharedElementsIn = arrayList;
        this.val$nonExistentView = view;
        this.val$inFragment = fragment;
        this.val$outFragment = fragment2;
        this.val$inIsPop = z2;
        this.val$sharedElementsOut = arrayList2;
        this.val$enterTransition = obj2;
        this.val$inEpicenter = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayMap<String, View> arrayMapCaptureInSharedElements = FragmentTransition.captureInSharedElements(this.val$impl, this.val$nameOverrides, this.val$finalSharedElementTransition, this.val$fragments);
        if (arrayMapCaptureInSharedElements != null) {
            this.val$sharedElementsIn.addAll(arrayMapCaptureInSharedElements.values());
            this.val$sharedElementsIn.add(this.val$nonExistentView);
        }
        FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, arrayMapCaptureInSharedElements, false);
        Object obj = this.val$finalSharedElementTransition;
        if (obj != null) {
            this.val$impl.swapSharedElementTargets(obj, this.val$sharedElementsOut, this.val$sharedElementsIn);
            View inEpicenterView = FragmentTransition.getInEpicenterView(arrayMapCaptureInSharedElements, this.val$fragments, this.val$enterTransition, this.val$inIsPop);
            if (inEpicenterView != null) {
                this.val$impl.getBoundsOnScreen(inEpicenterView, this.val$inEpicenter);
            }
        }
    }
}

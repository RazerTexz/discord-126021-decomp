package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransition$2 implements Runnable {
    public final /* synthetic */ ArrayList val$exitingViews;

    public FragmentTransition$2(ArrayList arrayList) {
        this.val$exitingViews = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        FragmentTransition.setViewVisibility(this.val$exitingViews, 4);
    }
}

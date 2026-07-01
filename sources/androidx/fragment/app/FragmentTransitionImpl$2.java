package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransitionImpl$2 implements Runnable {
    public final /* synthetic */ FragmentTransitionImpl this$0;
    public final /* synthetic */ Map val$nameOverrides;
    public final /* synthetic */ ArrayList val$sharedElementsIn;

    public FragmentTransitionImpl$2(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
        this.this$0 = fragmentTransitionImpl;
        this.val$sharedElementsIn = arrayList;
        this.val$nameOverrides = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.val$sharedElementsIn.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.val$sharedElementsIn.get(i);
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                ViewCompat.setTransitionName(view, FragmentTransitionImpl.findKeyForValue(this.val$nameOverrides, transitionName));
            }
        }
    }
}

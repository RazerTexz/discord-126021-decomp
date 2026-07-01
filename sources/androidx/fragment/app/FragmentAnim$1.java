package androidx.fragment.app;

import android.view.View;
import androidx.core.os.CancellationSignal$OnCancelListener;

/* JADX INFO: loaded from: classes.dex */
public class FragmentAnim$1 implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ Fragment val$fragment;

    public FragmentAnim$1(Fragment fragment) {
        this.val$fragment = fragment;
    }

    @Override // androidx.core.os.CancellationSignal$OnCancelListener
    public void onCancel() {
        if (this.val$fragment.getAnimatingAway() != null) {
            View animatingAway = this.val$fragment.getAnimatingAway();
            this.val$fragment.setAnimatingAway(null);
            animatingAway.clearAnimation();
        }
        this.val$fragment.setAnimator(null);
    }
}

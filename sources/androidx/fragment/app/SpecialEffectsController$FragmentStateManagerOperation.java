package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public class SpecialEffectsController$FragmentStateManagerOperation extends SpecialEffectsController$Operation {

    @NonNull
    private final FragmentStateManager mFragmentStateManager;

    public SpecialEffectsController$FragmentStateManagerOperation(@NonNull SpecialEffectsController$Operation$State specialEffectsController$Operation$State, @NonNull SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact, @NonNull FragmentStateManager fragmentStateManager, @NonNull CancellationSignal cancellationSignal) {
        super(specialEffectsController$Operation$State, specialEffectsController$Operation$LifecycleImpact, fragmentStateManager.getFragment(), cancellationSignal);
        this.mFragmentStateManager = fragmentStateManager;
    }

    @Override // androidx.fragment.app.SpecialEffectsController$Operation
    public void complete() {
        super.complete();
        this.mFragmentStateManager.moveToExpectedState();
    }

    @Override // androidx.fragment.app.SpecialEffectsController$Operation
    public void onStart() {
        Fragment fragment = this.mFragmentStateManager.getFragment();
        View viewFindFocus = fragment.mView.findFocus();
        if (viewFindFocus != null) {
            fragment.setFocusedView(viewFindFocus);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment);
            }
        }
        if (getLifecycleImpact() == SpecialEffectsController$Operation$LifecycleImpact.ADDING) {
            View viewRequireView = getFragment().requireView();
            if (viewRequireView.getParent() == null) {
                this.mFragmentStateManager.addViewToContainer();
                viewRequireView.setAlpha(0.0f);
            }
            if (viewRequireView.getAlpha() == 0.0f && viewRequireView.getVisibility() == 0) {
                viewRequireView.setVisibility(4);
            }
            viewRequireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
        }
    }
}

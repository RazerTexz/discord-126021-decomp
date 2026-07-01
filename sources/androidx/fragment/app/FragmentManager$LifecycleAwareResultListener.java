package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.view.Lifecycle;
import androidx.view.Lifecycle$State;
import androidx.view.LifecycleEventObserver;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$LifecycleAwareResultListener implements FragmentResultListener {
    private final Lifecycle mLifecycle;
    private final FragmentResultListener mListener;
    private final LifecycleEventObserver mObserver;

    public FragmentManager$LifecycleAwareResultListener(@NonNull Lifecycle lifecycle, @NonNull FragmentResultListener fragmentResultListener, @NonNull LifecycleEventObserver lifecycleEventObserver) {
        this.mLifecycle = lifecycle;
        this.mListener = fragmentResultListener;
        this.mObserver = lifecycleEventObserver;
    }

    public boolean isAtLeast(Lifecycle$State lifecycle$State) {
        return this.mLifecycle.getCurrentState().isAtLeast(lifecycle$State);
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public void onFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        this.mListener.onFragmentResult(str, bundle);
    }

    public void removeObserver() {
        this.mLifecycle.removeObserver(this.mObserver);
    }
}

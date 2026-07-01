package androidx.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.view.Lifecycle;
import androidx.view.Lifecycle$Event;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

    @Nullable
    private Cancellable mCurrentCancellable;
    private final Lifecycle mLifecycle;
    private final OnBackPressedCallback mOnBackPressedCallback;
    public final /* synthetic */ OnBackPressedDispatcher this$0;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(@NonNull OnBackPressedDispatcher onBackPressedDispatcher, @NonNull Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
        this.this$0 = onBackPressedDispatcher;
        this.mLifecycle = lifecycle;
        this.mOnBackPressedCallback = onBackPressedCallback;
        lifecycle.addObserver(this);
    }

    @Override // androidx.activity.Cancellable
    public void cancel() {
        this.mLifecycle.removeObserver(this);
        this.mOnBackPressedCallback.removeCancellable(this);
        Cancellable cancellable = this.mCurrentCancellable;
        if (cancellable != null) {
            cancellable.cancel();
            this.mCurrentCancellable = null;
        }
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_START) {
            this.mCurrentCancellable = this.this$0.addCancellableCallback(this.mOnBackPressedCallback);
            return;
        }
        if (lifecycle$Event != Lifecycle$Event.ON_STOP) {
            if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
                cancel();
            }
        } else {
            Cancellable cancellable = this.mCurrentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
        }
    }
}

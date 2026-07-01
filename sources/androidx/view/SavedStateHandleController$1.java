package androidx.view;

import androidx.annotation.NonNull;
import androidx.view.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public class SavedStateHandleController$1 implements LifecycleEventObserver {
    public final /* synthetic */ Lifecycle val$lifecycle;
    public final /* synthetic */ SavedStateRegistry val$registry;

    public SavedStateHandleController$1(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry) {
        this.val$lifecycle = lifecycle;
        this.val$registry = savedStateRegistry;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_START) {
            this.val$lifecycle.removeObserver(this);
            this.val$registry.runOnNextRecreation(SavedStateHandleController$OnRecreation.class);
        }
    }
}

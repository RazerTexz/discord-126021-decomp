package androidx.view;

import androidx.view.GenericLifecycleObserver;
import androidx.view.Lifecycle$Event;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class SavedStateRegistry$1 implements GenericLifecycleObserver {
    public final /* synthetic */ SavedStateRegistry this$0;

    public SavedStateRegistry$1(SavedStateRegistry savedStateRegistry) {
        this.this$0 = savedStateRegistry;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_START) {
            this.this$0.mAllowingSavingState = true;
        } else if (lifecycle$Event == Lifecycle$Event.ON_STOP) {
            this.this$0.mAllowingSavingState = false;
        }
    }
}

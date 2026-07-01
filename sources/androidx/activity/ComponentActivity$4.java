package androidx.activity;

import androidx.annotation.NonNull;
import androidx.view.Lifecycle$Event;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity$4 implements LifecycleEventObserver {
    public final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$4(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
            this.this$0.mContextAwareHelper.clearAvailableContext();
            if (this.this$0.isChangingConfigurations()) {
                return;
            }
            this.this$0.getViewModelStore().clear();
        }
    }
}

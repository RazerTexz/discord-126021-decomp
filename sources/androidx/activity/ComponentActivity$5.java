package androidx.activity;

import androidx.annotation.NonNull;
import androidx.view.Lifecycle$Event;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity$5 implements LifecycleEventObserver {
    public final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$5(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        this.this$0.ensureViewModelStore();
        this.this$0.getLifecycle().removeObserver(this);
    }
}

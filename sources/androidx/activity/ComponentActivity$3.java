package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.view.Lifecycle$Event;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity$3 implements LifecycleEventObserver {
    public final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$3(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_STOP) {
            Window window = this.this$0.getWindow();
            View viewPeekDecorView = window != null ? window.peekDecorView() : null;
            if (viewPeekDecorView != null) {
                viewPeekDecorView.cancelPendingInputEvents();
            }
        }
    }
}

package androidx.fragment.app;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.view.Lifecycle$Event;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class Fragment$5 implements LifecycleEventObserver {
    public final /* synthetic */ Fragment this$0;

    public Fragment$5(Fragment fragment) {
        this.this$0 = fragment;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        View view;
        if (lifecycle$Event != Lifecycle$Event.ON_STOP || (view = this.this$0.mView) == null) {
            return;
        }
        view.cancelPendingInputEvents();
    }
}

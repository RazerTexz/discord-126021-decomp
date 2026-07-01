package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.view.Lifecycle$Event;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStateAdapter$5 implements LifecycleEventObserver {
    public final /* synthetic */ FragmentStateAdapter this$0;
    public final /* synthetic */ Handler val$handler;
    public final /* synthetic */ Runnable val$runnable;

    public FragmentStateAdapter$5(FragmentStateAdapter fragmentStateAdapter, Handler handler, Runnable runnable) {
        this.this$0 = fragmentStateAdapter;
        this.val$handler = handler;
        this.val$runnable = runnable;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
            this.val$handler.removeCallbacks(this.val$runnable);
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}

package androidx.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.view.Lifecycle$Event;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStateAdapter$2 implements LifecycleEventObserver {
    public final /* synthetic */ FragmentStateAdapter this$0;
    public final /* synthetic */ FragmentViewHolder val$holder;

    public FragmentStateAdapter$2(FragmentStateAdapter fragmentStateAdapter, FragmentViewHolder fragmentViewHolder) {
        this.this$0 = fragmentStateAdapter;
        this.val$holder = fragmentViewHolder;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        if (this.this$0.shouldDelayFragmentTransactions()) {
            return;
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
        if (ViewCompat.isAttachedToWindow(this.val$holder.getContainer())) {
            this.this$0.placeFragmentInViewHolder(this.val$holder);
        }
    }
}

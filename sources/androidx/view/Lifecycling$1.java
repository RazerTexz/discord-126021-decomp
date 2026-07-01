package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class Lifecycling$1 implements GenericLifecycleObserver {
    public final /* synthetic */ LifecycleEventObserver val$observer;

    public Lifecycling$1(LifecycleEventObserver lifecycleEventObserver) {
        this.val$observer = lifecycleEventObserver;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        this.val$observer.onStateChanged(lifecycleOwner, lifecycle$Event);
    }
}

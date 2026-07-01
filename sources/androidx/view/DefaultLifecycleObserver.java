package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface DefaultLifecycleObserver extends FullLifecycleObserver {
    @Override // androidx.view.FullLifecycleObserver
    void onCreate(@NonNull LifecycleOwner lifecycleOwner);

    @Override // androidx.view.FullLifecycleObserver
    void onDestroy(@NonNull LifecycleOwner lifecycleOwner);

    @Override // androidx.view.FullLifecycleObserver
    void onPause(@NonNull LifecycleOwner lifecycleOwner);

    @Override // androidx.view.FullLifecycleObserver
    void onResume(@NonNull LifecycleOwner lifecycleOwner);

    @Override // androidx.view.FullLifecycleObserver
    void onStart(@NonNull LifecycleOwner lifecycleOwner);

    @Override // androidx.view.FullLifecycleObserver
    void onStop(@NonNull LifecycleOwner lifecycleOwner);
}

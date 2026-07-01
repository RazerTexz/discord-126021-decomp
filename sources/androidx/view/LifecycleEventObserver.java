package androidx.view;

import androidx.annotation.NonNull;
import androidx.view.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event);
}

package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface LifecycleRegistryOwner extends LifecycleOwner {
    @Override // androidx.view.LifecycleOwner
    @NonNull
    LifecycleRegistry getLifecycle();
}

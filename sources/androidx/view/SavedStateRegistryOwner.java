package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    @NonNull
    SavedStateRegistry getSavedStateRegistry();
}

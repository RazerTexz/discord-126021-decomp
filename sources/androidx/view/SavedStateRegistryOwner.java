package androidx.view;

import androidx.annotation.NonNull;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    @NonNull
    SavedStateRegistry getSavedStateRegistry();
}

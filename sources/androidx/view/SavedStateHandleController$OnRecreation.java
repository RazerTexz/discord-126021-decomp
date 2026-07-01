package androidx.view;

import androidx.annotation.NonNull;
import androidx.view.SavedStateRegistry;
import androidx.view.SavedStateRegistry$AutoRecreated;
import androidx.view.SavedStateRegistryOwner;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController$OnRecreation implements SavedStateRegistry$AutoRecreated {
    @Override // androidx.view.SavedStateRegistry$AutoRecreated
    public void onRecreated(@NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
        if (!(savedStateRegistryOwner instanceof ViewModelStoreOwner)) {
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
        ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
        SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        Iterator<String> it = viewModelStore.keys().iterator();
        while (it.hasNext()) {
            SavedStateHandleController.attachHandleIfNeeded(viewModelStore.get(it.next()), savedStateRegistry, savedStateRegistryOwner.getLifecycle());
        }
        if (viewModelStore.keys().isEmpty()) {
            return;
        }
        savedStateRegistry.runOnNextRecreation(SavedStateHandleController$OnRecreation.class);
    }
}

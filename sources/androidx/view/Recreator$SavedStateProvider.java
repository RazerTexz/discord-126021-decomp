package androidx.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Recreator$SavedStateProvider implements SavedStateRegistry$SavedStateProvider {
    public final Set<String> mClasses = new HashSet();

    public Recreator$SavedStateProvider(SavedStateRegistry savedStateRegistry) {
        savedStateRegistry.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
    }

    public void add(String str) {
        this.mClasses.add(str);
    }

    @Override // androidx.view.SavedStateRegistry$SavedStateProvider
    @NonNull
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(Recreator.CLASSES_KEY, new ArrayList<>(this.mClasses));
        return bundle;
    }
}

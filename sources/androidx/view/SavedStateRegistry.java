package androidx.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap$IteratorWithAdditions;
import androidx.view.Lifecycle;
import b.d.b.a.a;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private Recreator$SavedStateProvider mRecreatorProvider;
    private boolean mRestored;

    @Nullable
    private Bundle mRestoredState;
    private SafeIterableMap<String, SavedStateRegistry$SavedStateProvider> mComponents = new SafeIterableMap<>();
    public boolean mAllowingSavingState = true;

    @Nullable
    @MainThread
    public Bundle consumeRestoredStateForKey(@NonNull String str) {
        if (!this.mRestored) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.mRestoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.mRestoredState.remove(str);
        if (this.mRestoredState.isEmpty()) {
            this.mRestoredState = null;
        }
        return bundle2;
    }

    @MainThread
    public boolean isRestored() {
        return this.mRestored;
    }

    @MainThread
    public void performRestore(@NonNull Lifecycle lifecycle, @Nullable Bundle bundle) {
        if (this.mRestored) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.mRestoredState = bundle.getBundle(SAVED_COMPONENTS_KEY);
        }
        lifecycle.addObserver(new SavedStateRegistry$1(this));
        this.mRestored = true;
    }

    @MainThread
    public void performSave(@NonNull Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.mRestoredState;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap$IteratorWithAdditions safeIterableMap$IteratorWithAdditionsIteratorWithAdditions = this.mComponents.iteratorWithAdditions();
        while (safeIterableMap$IteratorWithAdditionsIteratorWithAdditions.hasNext()) {
            Map$Entry next = safeIterableMap$IteratorWithAdditionsIteratorWithAdditions.next();
            bundle2.putBundle((String) next.getKey(), ((SavedStateRegistry$SavedStateProvider) next.getValue()).saveState());
        }
        bundle.putBundle(SAVED_COMPONENTS_KEY, bundle2);
    }

    @MainThread
    public void registerSavedStateProvider(@NonNull String str, @NonNull SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider) {
        if (this.mComponents.putIfAbsent(str, savedStateRegistry$SavedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    @MainThread
    public void runOnNextRecreation(@NonNull Class<? extends SavedStateRegistry$AutoRecreated> cls) {
        if (!this.mAllowingSavingState) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.mRecreatorProvider == null) {
            this.mRecreatorProvider = new Recreator$SavedStateProvider(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.mRecreatorProvider.add(cls.getName());
        } catch (NoSuchMethodException e) {
            StringBuilder sbU = a.U("Class");
            sbU.append(cls.getSimpleName());
            sbU.append(" must have default constructor in order to be automatically recreated");
            throw new IllegalArgumentException(sbU.toString(), e);
        }
    }

    @MainThread
    public void unregisterSavedStateProvider(@NonNull String str) {
        this.mComponents.remove(str);
    }
}

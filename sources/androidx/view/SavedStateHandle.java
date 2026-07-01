package androidx.view;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.view.SavedStateRegistry$SavedStateProvider;
import b.d.b.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandle {
    private static final Class[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map<String, SavedStateHandle$SavingStateLiveData<?>> mLiveDatas;
    public final Map<String, Object> mRegular;
    private final SavedStateRegistry$SavedStateProvider mSavedStateProvider;
    public final Map<String, SavedStateRegistry$SavedStateProvider> mSavedStateProviders;

    public SavedStateHandle(@NonNull Map<String, Object> map) {
        this.mSavedStateProviders = new HashMap();
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new SavedStateHandle$1(this);
        this.mRegular = new HashMap(map);
    }

    public static SavedStateHandle createHandle(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new SavedStateHandle();
        }
        HashMap map = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                map.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new SavedStateHandle(map);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEYS);
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(VALUES);
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            map.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
        }
        return new SavedStateHandle(map);
    }

    @NonNull
    private <T> MutableLiveData<T> getLiveDataInternal(@NonNull String str, boolean z2, @Nullable T t) {
        SavedStateHandle$SavingStateLiveData<?> savedStateHandle$SavingStateLiveData;
        SavedStateHandle$SavingStateLiveData<?> savedStateHandle$SavingStateLiveData2 = this.mLiveDatas.get(str);
        if (savedStateHandle$SavingStateLiveData2 != null) {
            return savedStateHandle$SavingStateLiveData2;
        }
        if (this.mRegular.containsKey(str)) {
            savedStateHandle$SavingStateLiveData = new SavedStateHandle$SavingStateLiveData<>(this, str, this.mRegular.get(str));
        } else {
            savedStateHandle$SavingStateLiveData = z2 ? new SavedStateHandle$SavingStateLiveData<>(this, str, t) : new SavedStateHandle$SavingStateLiveData<>(this, str);
        }
        this.mLiveDatas.put(str, savedStateHandle$SavingStateLiveData);
        return savedStateHandle$SavingStateLiveData;
    }

    private static void validateValue(Object obj) {
        if (obj == null) {
            return;
        }
        for (Class cls : ACCEPTABLE_CLASSES) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        StringBuilder sbU = a.U("Can't put value with type ");
        sbU.append(obj.getClass());
        sbU.append(" into saved state");
        throw new IllegalArgumentException(sbU.toString());
    }

    @MainThread
    public void clearSavedStateProvider(@NonNull String str) {
        this.mSavedStateProviders.remove(str);
    }

    @MainThread
    public boolean contains(@NonNull String str) {
        return this.mRegular.containsKey(str);
    }

    @Nullable
    @MainThread
    public <T> T get(@NonNull String str) {
        return (T) this.mRegular.get(str);
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str) {
        return getLiveDataInternal(str, false, null);
    }

    @NonNull
    @MainThread
    public Set<String> keys() {
        HashSet hashSet = new HashSet(this.mRegular.keySet());
        hashSet.addAll(this.mSavedStateProviders.keySet());
        hashSet.addAll(this.mLiveDatas.keySet());
        return hashSet;
    }

    @Nullable
    @MainThread
    public <T> T remove(@NonNull String str) {
        T t = (T) this.mRegular.remove(str);
        SavedStateHandle$SavingStateLiveData<?> savedStateHandle$SavingStateLiveDataRemove = this.mLiveDatas.remove(str);
        if (savedStateHandle$SavingStateLiveDataRemove != null) {
            savedStateHandle$SavingStateLiveDataRemove.detach();
        }
        return t;
    }

    @NonNull
    public SavedStateRegistry$SavedStateProvider savedStateProvider() {
        return this.mSavedStateProvider;
    }

    @MainThread
    public <T> void set(@NonNull String str, @Nullable T t) {
        validateValue(t);
        SavedStateHandle$SavingStateLiveData<?> savedStateHandle$SavingStateLiveData = this.mLiveDatas.get(str);
        if (savedStateHandle$SavingStateLiveData != null) {
            savedStateHandle$SavingStateLiveData.setValue(t);
        } else {
            this.mRegular.put(str, t);
        }
    }

    @MainThread
    public void setSavedStateProvider(@NonNull String str, @NonNull SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider) {
        this.mSavedStateProviders.put(str, savedStateRegistry$SavedStateProvider);
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str, @SuppressLint({"UnknownNullness"}) T t) {
        return getLiveDataInternal(str, true, t);
    }

    public SavedStateHandle() {
        this.mSavedStateProviders = new HashMap();
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new SavedStateHandle$1(this);
        this.mRegular = new HashMap();
    }
}

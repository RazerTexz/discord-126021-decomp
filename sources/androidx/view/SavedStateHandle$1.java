package androidx.view;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.view.SavedStateRegistry$SavedStateProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map$Entry;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SavedStateHandle$1 implements SavedStateRegistry$SavedStateProvider {
    public final /* synthetic */ SavedStateHandle this$0;

    public SavedStateHandle$1(SavedStateHandle savedStateHandle) {
        this.this$0 = savedStateHandle;
    }

    @Override // androidx.view.SavedStateRegistry$SavedStateProvider
    @NonNull
    public Bundle saveState() {
        for (Map$Entry map$Entry : new HashMap(this.this$0.mSavedStateProviders).entrySet()) {
            this.this$0.set((String) map$Entry.getKey(), ((SavedStateRegistry$SavedStateProvider) map$Entry.getValue()).saveState());
        }
        Set<String> setKeySet = this.this$0.mRegular.keySet();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(setKeySet.size());
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(this.this$0.mRegular.get(str));
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("keys", arrayList);
        bundle.putParcelableArrayList("values", arrayList2);
        return bundle;
    }
}

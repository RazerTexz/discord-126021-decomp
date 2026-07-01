package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface ViewModelProvider$Factory {
    @NonNull
    <T extends ViewModel> T create(@NonNull Class<T> cls);
}

package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewModelProvider$KeyedFactory extends ViewModelProvider$OnRequeryFactory implements ViewModelProvider$Factory {
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }

    @NonNull
    public abstract <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls);
}

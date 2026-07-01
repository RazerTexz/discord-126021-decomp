package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelProvider$NewInstanceFactory implements ViewModelProvider$Factory {
    private static ViewModelProvider$NewInstanceFactory sInstance;

    @NonNull
    public static ViewModelProvider$NewInstanceFactory getInstance() {
        if (sInstance == null) {
            sInstance = new ViewModelProvider$NewInstanceFactory();
        }
        return sInstance;
    }

    @Override // androidx.view.ViewModelProvider$Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        }
    }
}

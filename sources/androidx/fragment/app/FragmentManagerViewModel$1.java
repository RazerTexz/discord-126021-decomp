package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.view.ViewModel;
import androidx.view.ViewModelProvider$Factory;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManagerViewModel$1 implements ViewModelProvider$Factory {
    @Override // androidx.view.ViewModelProvider$Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        return new FragmentManagerViewModel(true);
    }
}

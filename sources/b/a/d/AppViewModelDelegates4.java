package b.a.d;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.d.h0, reason: use source file name */
/* JADX INFO: compiled from: AppViewModelDelegates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppViewModelDelegates4 implements ViewModelProvider.Factory {
    public final /* synthetic */ AppViewModelDelegates5 a;

    public AppViewModelDelegates4(AppViewModelDelegates5 appViewModelDelegates5) {
        this.a = appViewModelDelegates5;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics3.checkNotNullParameter(cls, "modelClass");
        return (T) this.a.$viewModelProducer.invoke();
    }
}

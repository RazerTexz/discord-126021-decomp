package b.a.d;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider$Factory;

/* JADX INFO: compiled from: AppViewModelDelegates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements ViewModelProvider$Factory {
    public final /* synthetic */ i0 a;

    public h0(i0 i0Var) {
        this.a = i0Var;
    }

    @Override // androidx.view.ViewModelProvider$Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "modelClass");
        return (T) this.a.$viewModelProducer.invoke();
    }
}

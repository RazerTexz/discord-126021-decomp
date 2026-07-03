package p007b.p008a.p018d;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.d.e0 */
/* JADX INFO: compiled from: AppViewModelDelegates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0861e0 implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0863f0 f506a;

    public C0861e0(C0863f0 c0863f0) {
        this.f506a = c0863f0;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        C12238m.checkNotNullParameter(cls, "modelClass");
        return (T) this.f506a.$viewModelProducer.invoke();
    }
}

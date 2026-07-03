package p007b.p008a.p018d;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.d.h0 */
/* JADX INFO: compiled from: AppViewModelDelegates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0867h0 implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0869i0 f516a;

    public C0867h0(C0869i0 c0869i0) {
        this.f516a = c0869i0;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        C12238m.checkNotNullParameter(cls, "modelClass");
        return (T) this.f516a.$viewModelProducer.invoke();
    }
}

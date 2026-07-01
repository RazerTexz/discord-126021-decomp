package androidx.view;

import androidx.annotation.MainThread;
import d0.z.d.m;

/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelProviderKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        m.checkNotNullParameter(viewModelProvider, "$this$get");
        m.reifiedOperationMarker(4, "VM");
        VM vm = (VM) viewModelProvider.get(ViewModel.class);
        m.checkNotNullExpressionValue(vm, "get(VM::class.java)");
        return vm;
    }
}

package androidx.view;

import androidx.annotation.MainThread;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelProviderKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        C12238m.checkNotNullParameter(viewModelProvider, "$this$get");
        C12238m.reifiedOperationMarker(4, "VM");
        VM vm = (VM) viewModelProvider.get(ViewModel.class);
        C12238m.checkNotNullExpressionValue(vm, "get(VM::class.java)");
        return vm;
    }
}

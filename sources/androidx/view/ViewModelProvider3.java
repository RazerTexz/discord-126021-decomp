package androidx.view;

import androidx.annotation.MainThread;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.lifecycle.ViewModelProviderKt, reason: use source file name */
/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelProvider3 {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        Intrinsics3.checkNotNullParameter(viewModelProvider, "$this$get");
        Intrinsics3.reifiedOperationMarker(4, "VM");
        VM vm = (VM) viewModelProvider.get(ViewModel.class);
        Intrinsics3.checkNotNullExpressionValue(vm, "get(VM::class.java)");
        return vm;
    }
}

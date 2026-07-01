package androidx.view;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import d0.e0.KClass;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: androidx.lifecycle.ViewModelLazy, reason: use source file name */
/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelProvider2<VM extends ViewModel> implements Lazy<VM> {
    private VM cached;
    private final Function0<ViewModelProvider.Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final KClass<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelProvider2(KClass<VM> kClass, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function1) {
        Intrinsics3.checkNotNullParameter(kClass, "viewModelClass");
        Intrinsics3.checkNotNullParameter(function0, "storeProducer");
        Intrinsics3.checkNotNullParameter(function1, "factoryProducer");
        this.viewModelClass = kClass;
        this.storeProducer = function0;
        this.factoryProducer = function1;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // kotlin.Lazy
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(JvmClassMapping.getJavaClass(this.viewModelClass));
        this.cached = vm2;
        Intrinsics3.checkNotNullExpressionValue(vm2, "ViewModelProvider(store,…ed = it\n                }");
        return vm2;
    }
}

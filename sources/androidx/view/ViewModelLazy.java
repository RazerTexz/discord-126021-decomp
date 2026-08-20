package androidx.view;

import androidx.view.ViewModel;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p592z.C12209a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    private VM cached;
    private final Function0<ViewModelProvider.Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final InterfaceC11230c<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(InterfaceC11230c<VM> interfaceC11230c, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function1) {
        C12238m.checkNotNullParameter(interfaceC11230c, "viewModelClass");
        C12238m.checkNotNullParameter(function0, "storeProducer");
        C12238m.checkNotNullParameter(function1, "factoryProducer");
        this.viewModelClass = interfaceC11230c;
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
        VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(C12209a.getJavaClass(this.viewModelClass));
        this.cached = vm2;
        C12238m.checkNotNullExpressionValue(vm2, "ViewModelProvider(store,…ed = it\n                }");
        return vm2;
    }
}

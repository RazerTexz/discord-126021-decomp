package androidx.view;

import androidx.view.ViewModel;
import d0.e0.c;
import d0.z.a;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    private VM cached;
    private final Function0<ViewModelProvider$Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final c<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(c<VM> cVar, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider$Factory> function1) {
        m.checkNotNullParameter(cVar, "viewModelClass");
        m.checkNotNullParameter(function0, "storeProducer");
        m.checkNotNullParameter(function1, "factoryProducer");
        this.viewModelClass = cVar;
        this.storeProducer = function0;
        this.factoryProducer = function1;
    }

    @Override // kotlin.Lazy
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
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
        VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(a.getJavaClass(this.viewModelClass));
        this.cached = vm2;
        m.checkNotNullExpressionValue(vm2, "ViewModelProvider(store,…ed = it\n                }");
        return vm2;
    }
}

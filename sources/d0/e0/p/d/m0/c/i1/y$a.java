package d0.e0.p.d.m0.c.i1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y$a extends d0.z.d.o implements Function0<j> {
    public final /* synthetic */ y this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y$a(y yVar) {
        super(0);
        this.this$0 = yVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ j invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final j invoke() {
        w wVarAccess$getDependencies$p = y.access$getDependencies$p(this.this$0);
        y yVar = this.this$0;
        if (wVarAccess$getDependencies$p == null) {
            StringBuilder sbU = b.d.b.a.a.U("Dependencies of module ");
            sbU.append(y.access$getId(yVar));
            sbU.append(" were not set before querying module content");
            throw new AssertionError(sbU.toString());
        }
        List<y> allDependencies = wVarAccess$getDependencies$p.getAllDependencies();
        allDependencies.contains(this.this$0);
        Iterator<T> it = allDependencies.iterator();
        while (it.hasNext()) {
            y.access$isInitialized((y) it.next());
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(allDependencies, 10));
        Iterator<T> it2 = allDependencies.iterator();
        while (it2.hasNext()) {
            d0.e0.p.d.m0.c.f0 f0VarAccess$getPackageFragmentProviderForModuleContent$p = y.access$getPackageFragmentProviderForModuleContent$p((y) it2.next());
            d0.z.d.m.checkNotNull(f0VarAccess$getPackageFragmentProviderForModuleContent$p);
            arrayList.add(f0VarAccess$getPackageFragmentProviderForModuleContent$p);
        }
        return new j(arrayList);
    }
}

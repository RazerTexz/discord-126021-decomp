package d0.e0.p.d.m0.b.p;

import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.k.a0.GivenFunctionsMemberScope;
import d0.e0.p.d.m0.m.StorageManager;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.d, reason: use source file name */
/* JADX INFO: compiled from: FunctionClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FunctionClassScope extends GivenFunctionsMemberScope {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionClassScope(StorageManager storageManager, FunctionClassDescriptor functionClassDescriptor) {
        super(storageManager, functionClassDescriptor);
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(functionClassDescriptor, "containingClass");
    }

    @Override // d0.e0.p.d.m0.k.a0.GivenFunctionsMemberScope
    public List<FunctionDescriptor> a() {
        int iOrdinal = ((FunctionClassDescriptor) this.c).getFunctionKind().ordinal();
        if (iOrdinal != 0) {
            return iOrdinal != 1 ? Collections2.emptyList() : CollectionsJVM.listOf(FunctionInvokeDescriptor.M.create((FunctionClassDescriptor) this.c, true));
        }
        return CollectionsJVM.listOf(FunctionInvokeDescriptor.M.create((FunctionClassDescriptor) this.c, false));
    }
}

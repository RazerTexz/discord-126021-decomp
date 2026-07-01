package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.o.c;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public final c check(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        for (d dVar : getChecks$descriptors()) {
            if (dVar.isApplicable(functionDescriptor)) {
                return dVar.checkAll(functionDescriptor);
            }
        }
        return c.a.f3545b;
    }

    public abstract List<d> getChecks$descriptors();
}

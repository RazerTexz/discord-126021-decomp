package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.e0;
import d0.t.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends d0.z.d.o implements Function1<c0, d0.e0.p.d.m0.b.b> {
    public static final e$a j = new e$a();

    public e$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.b.b invoke(c0 c0Var) {
        return invoke2(c0Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.b.b invoke2(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        List<e0> fragments = c0Var.getPackage(e.access$getKOTLIN_FQ_NAME$cp()).getFragments();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof d0.e0.p.d.m0.b.b) {
                arrayList.add(obj);
            }
        }
        return (d0.e0.p.d.m0.b.b) u.first((List) arrayList);
    }
}

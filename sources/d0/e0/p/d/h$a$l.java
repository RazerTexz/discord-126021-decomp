package d0.e0.p.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a$l extends d0.z.d.o implements Function0<List<? extends h<? extends Object>>> {
    public final /* synthetic */ h$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a$l(h$a h_a) {
        super(0);
        this.this$0 = h_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends h<? extends Object>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends h<? extends Object>> invoke2() {
        Collection contributedDescriptors$default = d0.e0.p.d.m0.k.a0.l$a.getContributedDescriptors$default(this.this$0.getDescriptor().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
        ArrayList<d0.e0.p.d.m0.c.m> arrayList = new ArrayList();
        for (Object obj : contributedDescriptors$default) {
            if (!d0.e0.p.d.m0.k.e.isEnumEntry((d0.e0.p.d.m0.c.m) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (d0.e0.p.d.m0.c.m mVar : arrayList) {
            Objects.requireNonNull(mVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> javaClass = j0.toJavaClass((d0.e0.p.d.m0.c.e) mVar);
            h hVar = javaClass != null ? new h(javaClass) : null;
            if (hVar != null) {
                arrayList2.add(hVar);
            }
        }
        return arrayList2;
    }
}

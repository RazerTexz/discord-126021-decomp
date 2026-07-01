package d0.e0.p.d;

import d0.e0.p.d.m0.n.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a$q extends d0.z.d.o implements Function0<List<? extends x>> {
    public final /* synthetic */ h$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a$q(h$a h_a) {
        super(0);
        this.this$0 = h_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends x> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends x> invoke2() {
        d0.e0.p.d.m0.c.f kind;
        u0 typeConstructor = this.this$0.getDescriptor().getTypeConstructor();
        d0.z.d.m.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        Collection<d0.e0.p.d.m0.n.c0> supertypes = typeConstructor.getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "descriptor.typeConstructor.supertypes");
        ArrayList arrayList = new ArrayList(supertypes.size());
        for (d0.e0.p.d.m0.n.c0 c0Var : supertypes) {
            d0.z.d.m.checkNotNullExpressionValue(c0Var, "kotlinType");
            arrayList.add(new x(c0Var, new h$a$q$a(c0Var, this)));
        }
        if (!d0.e0.p.d.m0.b.h.isSpecialClassWithNoSupertypes(this.this$0.getDescriptor())) {
            boolean z2 = false;
            if (arrayList.isEmpty()) {
                z2 = true;
                break;
            }
            Iterator it = arrayList.iterator();
            do {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                d0.e0.p.d.m0.c.e classDescriptorForType = d0.e0.p.d.m0.k.e.getClassDescriptorForType(((x) it.next()).getType());
                d0.z.d.m.checkNotNullExpressionValue(classDescriptorForType, "DescriptorUtils.getClassDescriptorForType(it.type)");
                kind = classDescriptorForType.getKind();
                d0.z.d.m.checkNotNullExpressionValue(kind, "DescriptorUtils.getClass…ptorForType(it.type).kind");
            } while (kind == d0.e0.p.d.m0.c.f.INTERFACE || kind == d0.e0.p.d.m0.c.f.ANNOTATION_CLASS);
            if (z2) {
                d0.e0.p.d.m0.n.j0 anyType = d0.e0.p.d.m0.k.x.a.getBuiltIns(this.this$0.getDescriptor()).getAnyType();
                d0.z.d.m.checkNotNullExpressionValue(anyType, "descriptor.builtIns.anyType");
                arrayList.add(new x(anyType, h$a$q$b.j));
            }
        }
        return d0.e0.p.d.m0.p.a.compact(arrayList);
    }
}

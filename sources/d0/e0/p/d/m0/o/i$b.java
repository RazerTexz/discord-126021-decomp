package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$b extends o implements Function1<x, String> {
    public static final i$b j = new i$b();

    public i$b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(x xVar) {
        return invoke2(xVar);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(x xVar) {
        boolean z2;
        boolean z3;
        m.checkNotNullParameter(xVar, "<this>");
        i iVar = i.a;
        d0.e0.p.d.m0.c.m containingDeclaration = xVar.getContainingDeclaration();
        m.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        if (!((containingDeclaration instanceof d0.e0.p.d.m0.c.e) && d0.e0.p.d.m0.b.h.isAny((d0.e0.p.d.m0.c.e) containingDeclaration))) {
            Collection<? extends x> overriddenDescriptors = xVar.getOverriddenDescriptors();
            m.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            if (!overriddenDescriptors.isEmpty()) {
                Iterator<T> it = overriddenDescriptors.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    }
                    d0.e0.p.d.m0.c.m containingDeclaration2 = ((x) it.next()).getContainingDeclaration();
                    m.checkNotNullExpressionValue(containingDeclaration2, "it.containingDeclaration");
                    if ((containingDeclaration2 instanceof d0.e0.p.d.m0.c.e) && d0.e0.p.d.m0.b.h.isAny((d0.e0.p.d.m0.c.e) containingDeclaration2)) {
                        z3 = true;
                        break;
                    }
                }
            } else {
                z3 = false;
                break;
            }
            z2 = z3;
        }
        if (z2) {
            return null;
        }
        return "must override ''equals()'' in Any";
    }
}

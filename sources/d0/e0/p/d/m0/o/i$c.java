package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.n.c0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$c extends o implements Function1<x, String> {
    public static final i$c j = new i$c();

    public i$c() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(x xVar) {
        return invoke2(xVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(x xVar) {
        boolean zIsSubtypeOf;
        m.checkNotNullParameter(xVar, "<this>");
        q0 dispatchReceiverParameter = xVar.getDispatchReceiverParameter();
        if (dispatchReceiverParameter == null) {
            dispatchReceiverParameter = xVar.getExtensionReceiverParameter();
        }
        i iVar = i.a;
        boolean z2 = false;
        if (dispatchReceiverParameter != null) {
            c0 returnType = xVar.getReturnType();
            if (returnType == null) {
                zIsSubtypeOf = false;
            } else {
                c0 type = dispatchReceiverParameter.getType();
                m.checkNotNullExpressionValue(type, "receiver.type");
                zIsSubtypeOf = d0.e0.p.d.m0.n.o1.a.isSubtypeOf(returnType, type);
            }
            if (zIsSubtypeOf) {
                z2 = true;
            }
        }
        if (z2) {
            return null;
        }
        return "receiver must be a supertype of the return type";
    }
}

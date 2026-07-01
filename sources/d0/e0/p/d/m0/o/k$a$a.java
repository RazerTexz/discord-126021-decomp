package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$a$a extends o implements Function1<d0.e0.p.d.m0.b.h, c0> {
    public static final k$a$a j = new k$a$a();

    public k$a$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ c0 invoke(d0.e0.p.d.m0.b.h hVar) {
        return invoke2(hVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c0 invoke2(d0.e0.p.d.m0.b.h hVar) {
        m.checkNotNullParameter(hVar, "<this>");
        j0 booleanType = hVar.getBooleanType();
        m.checkNotNullExpressionValue(booleanType, "booleanType");
        return booleanType;
    }
}

package d0.e0.p.d.m0.n;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$e extends d0.z.d.o implements Function1<g$b, Unit> {
    public final /* synthetic */ g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g$e(g gVar) {
        super(1);
        this.this$0 = gVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(g$b g_b) {
        invoke2(g_b);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(g$b g_b) {
        d0.z.d.m.checkNotNullParameter(g_b, "supertypes");
        Collection<c0> collectionFindLoopsInSupertypesAndDisconnect = this.this$0.d().findLoopsInSupertypesAndDisconnect(this.this$0, g_b.getAllSupertypes(), new g$e$a(this.this$0), new g$e$b(this.this$0));
        if (collectionFindLoopsInSupertypesAndDisconnect.isEmpty()) {
            c0 c0VarB = this.this$0.b();
            collectionFindLoopsInSupertypesAndDisconnect = c0VarB == null ? null : d0.t.m.listOf(c0VarB);
            if (collectionFindLoopsInSupertypesAndDisconnect == null) {
                collectionFindLoopsInSupertypesAndDisconnect = d0.t.n.emptyList();
            }
        }
        Objects.requireNonNull(this.this$0);
        g gVar = this.this$0;
        List<c0> list = collectionFindLoopsInSupertypesAndDisconnect instanceof List ? (List) collectionFindLoopsInSupertypesAndDisconnect : null;
        if (list == null) {
            list = d0.t.u.toList(collectionFindLoopsInSupertypesAndDisconnect);
        }
        g_b.setSupertypesWithoutCycles(gVar.e(list));
    }
}

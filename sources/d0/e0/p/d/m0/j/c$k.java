package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.c.y0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$k {
    public c$k(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final String getClassifierKindPrefix(d0.e0.p.d.m0.c.i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "classifier");
        if (iVar instanceof y0) {
            return "typealias";
        }
        if (!(iVar instanceof d0.e0.p.d.m0.c.e)) {
            throw new AssertionError(d0.z.d.m.stringPlus("Unexpected classifier: ", iVar));
        }
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) iVar;
        if (eVar.isCompanionObject()) {
            return "companion object";
        }
        int iOrdinal = eVar.getKind().ordinal();
        if (iOrdinal == 0) {
            return "class";
        }
        if (iOrdinal == 1) {
            return "interface";
        }
        if (iOrdinal == 2) {
            return "enum class";
        }
        if (iOrdinal == 3) {
            return "enum entry";
        }
        if (iOrdinal == 4) {
            return "annotation class";
        }
        if (iOrdinal == 5) {
            return "object";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final c withOptions(Function1<? super h, Unit> function1) {
        d0.z.d.m.checkNotNullParameter(function1, "changeOptions");
        i iVar = new i();
        function1.invoke(iVar);
        iVar.lock();
        return new d(iVar);
    }
}

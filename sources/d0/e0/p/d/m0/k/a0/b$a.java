package d0.e0.p.d.m0.k.a0;

import d0.t.r;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChainedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a {
    public b$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final i create(String str, Iterable<? extends i> iterable) {
        d0.z.d.m.checkNotNullParameter(str, "debugName");
        d0.z.d.m.checkNotNullParameter(iterable, "scopes");
        d0.e0.p.d.m0.p.i iVar = new d0.e0.p.d.m0.p.i();
        for (i iVar2 : iterable) {
            if (iVar2 != i$b.f3461b) {
                if (iVar2 instanceof b) {
                    r.addAll(iVar, b.access$getScopes$p((b) iVar2));
                } else {
                    iVar.add(iVar2);
                }
            }
        }
        return createOrSingle$descriptors(str, iVar);
    }

    public final i createOrSingle$descriptors(String str, List<? extends i> list) {
        d0.z.d.m.checkNotNullParameter(str, "debugName");
        d0.z.d.m.checkNotNullParameter(list, "scopes");
        int size = list.size();
        if (size == 0) {
            return i$b.f3461b;
        }
        if (size == 1) {
            return list.get(0);
        }
        Object[] array = list.toArray(new i[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return new b(str, (i[]) array, null);
    }
}

package d0.e0.p.d.m0.c;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ScopesHolderForClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r0$a {
    public r0$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final <T extends d0.e0.p.d.m0.k.a0.i> r0<T> create(e eVar, d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.n.l1.g gVar, Function1<? super d0.e0.p.d.m0.n.l1.g, ? extends T> function1) {
        d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefinerForOwnerModule");
        d0.z.d.m.checkNotNullParameter(function1, "scopeFactory");
        return new r0<>(eVar, oVar, function1, gVar, null);
    }
}

package d0.e0.p.d.m0.c.g1;

import d0.t.u;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$b extends o implements Function1<g, Sequence<? extends c>> {
    public static final k$b j = new k$b();

    public k$b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Sequence<? extends c> invoke(g gVar) {
        return invoke2(gVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Sequence<c> invoke2(g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "it");
        return u.asSequence(gVar);
    }
}

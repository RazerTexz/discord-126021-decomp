package d0.e0.p.d.m0.l.b.e0;

import d0.t.u;
import d0.z.d.o;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$d extends o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
    public final /* synthetic */ Function0<Collection<d0.e0.p.d.m0.g.e>> $classNames;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h$d(Function0<? extends Collection<d0.e0.p.d.m0.g.e>> function0) {
        super(0);
        this.$classNames = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
        return u.toSet(this.$classNames.invoke());
    }
}

package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.p.b$b;
import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends b$b<d0.e0.p.d.m0.c.e, Unit> {
    public final /* synthetic */ d0.e0.p.d.m0.c.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set<R> f3338b;
    public final /* synthetic */ Function1<d0.e0.p.d.m0.k.a0.i, Collection<R>> c;

    /* JADX WARN: Multi-variable type inference failed */
    public q(d0.e0.p.d.m0.c.e eVar, Set<R> set, Function1<? super d0.e0.p.d.m0.k.a0.i, ? extends Collection<? extends R>> function1) {
        this.a = eVar;
        this.f3338b = set;
        this.c = function1;
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public /* bridge */ /* synthetic */ boolean beforeChildren(Object obj) {
        return beforeChildren((d0.e0.p.d.m0.c.e) obj);
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public /* bridge */ /* synthetic */ Object result() {
        m87result();
        return Unit.a;
    }

    /* JADX INFO: renamed from: result, reason: collision with other method in class */
    public void m87result() {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public boolean beforeChildren(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "current");
        if (eVar == this.a) {
            return true;
        }
        d0.e0.p.d.m0.k.a0.i staticScope = eVar.getStaticScope();
        d0.z.d.m.checkNotNullExpressionValue(staticScope, "current.staticScope");
        if (!(staticScope instanceof r)) {
            return true;
        }
        this.f3338b.addAll((Collection<? extends R>) ((Collection) this.c.invoke(staticScope)));
        return false;
    }
}

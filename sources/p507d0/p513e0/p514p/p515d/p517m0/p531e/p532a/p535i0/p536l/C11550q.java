package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.q */
/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11550q extends C12034b.b<InterfaceC11330e, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ InterfaceC11330e f23415a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Set<R> f23416b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Function1<InterfaceC11770i, Collection<R>> f23417c;

    /* JADX WARN: Multi-variable type inference failed */
    public C11550q(InterfaceC11330e interfaceC11330e, Set<R> set, Function1<? super InterfaceC11770i, ? extends Collection<? extends R>> function1) {
        this.f23415a = interfaceC11330e;
        this.f23416b = set;
        this.f23417c = function1;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.d
    public /* bridge */ /* synthetic */ Object result() {
        m11464result();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: result, reason: collision with other method in class */
    public void m11464result() {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.d
    public boolean beforeChildren(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "current");
        if (interfaceC11330e == this.f23415a) {
            return true;
        }
        InterfaceC11770i staticScope = interfaceC11330e.getStaticScope();
        C12238m.checkNotNullExpressionValue(staticScope, "current.staticScope");
        if (!(staticScope instanceof AbstractC11551r)) {
            return true;
        }
        this.f23416b.addAll((Collection<? extends R>) ((Collection) this.f23417c.invoke(staticScope)));
        return false;
    }
}

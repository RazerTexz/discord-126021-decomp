package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements u0 {
    public static final n$a a = new n$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3475b;
    public final c0 c;
    public final Set<d0.e0.p.d.m0.n.c0> d;
    public final j0 e;
    public final Lazy f;

    public n(long j, c0 c0Var, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        d0 d0Var = d0.a;
        this.e = d0.integerLiteralType(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), this, false);
        this.f = d0.g.lazy(new n$b(this));
        this.f3475b = j;
        this.c = c0Var;
        this.d = set;
    }

    public static final /* synthetic */ c0 access$getModule$p(n nVar) {
        return nVar.c;
    }

    public static final /* synthetic */ j0 access$getType$p(n nVar) {
        return nVar.e;
    }

    public static final /* synthetic */ long access$getValue$p(n nVar) {
        return nVar.f3475b;
    }

    public static final boolean access$isContainsOnlyUnsignedTypes(n nVar) {
        Collection<d0.e0.p.d.m0.n.c0> allSignedLiteralTypes = u.getAllSignedLiteralTypes(nVar.c);
        if ((allSignedLiteralTypes instanceof Collection) && allSignedLiteralTypes.isEmpty()) {
            return true;
        }
        Iterator<T> it = allSignedLiteralTypes.iterator();
        while (it.hasNext()) {
            if (!(!nVar.getPossibleTypes().contains((d0.e0.p.d.m0.n.c0) it.next()))) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkConstructor(u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        Set<d0.e0.p.d.m0.n.c0> set = this.d;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (d0.z.d.m.areEqual(((d0.e0.p.d.m0.n.c0) it.next()).getConstructor(), u0Var)) {
                return true;
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        return this.c.getBuiltIns();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<z0> getParameters() {
        return d0.t.n.emptyList();
    }

    public final Set<d0.e0.p.d.m0.n.c0> getPossibleTypes() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public Collection<d0.e0.p.d.m0.n.c0> getSupertypes() {
        return (List) this.f.getValue();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        StringBuilder sbQ = b.d.b.a.a.Q('[');
        sbQ.append(d0.t.u.joinToString$default(this.d, ",", null, null, 0, null, o.j, 30, null));
        sbQ.append(']');
        return d0.z.d.m.stringPlus("IntegerLiteralType", sbQ.toString());
    }
}

package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.l.b.p;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: DescriptorResolverUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a extends d0.e0.p.d.m0.k.i {
    public final /* synthetic */ p a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f3313b;
    public final /* synthetic */ boolean c;

    public a$a(p pVar, Set set, boolean z2) {
        this.a = pVar;
        this.f3313b = set;
        this.c = z2;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "fromSuper";
        } else if (i == 2) {
            objArr[0] = "fromCurrent";
        } else if (i == 3) {
            objArr[0] = "member";
        } else if (i != 4) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "overridden";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
        if (i == 1 || i == 2) {
            objArr[2] = "conflict";
        } else if (i == 3 || i == 4) {
            objArr[2] = "setOverriddenDescriptors";
        } else {
            objArr[2] = "addFakeOverride";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // d0.e0.p.d.m0.k.j
    public void addFakeOverride(d0.e0.p.d.m0.c.b bVar) {
        if (bVar == null) {
            a(0);
            throw null;
        }
        d0.e0.p.d.m0.k.k.resolveUnknownVisibilityForMember(bVar, new a$a$a(this));
        this.f3313b.add(bVar);
    }

    @Override // d0.e0.p.d.m0.k.i
    public void conflict(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.b bVar2) {
        if (bVar == null) {
            a(1);
            throw null;
        }
        if (bVar2 != null) {
            return;
        }
        a(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.j
    public void setOverriddenDescriptors(d0.e0.p.d.m0.c.b bVar, Collection<? extends d0.e0.p.d.m0.c.b> collection) {
        if (bVar == null) {
            a(3);
            throw null;
        }
        if (collection == null) {
            a(4);
            throw null;
        }
        if (!this.c || bVar.getKind() == d0.e0.p.d.m0.c.b$a.FAKE_OVERRIDE) {
            super.setOverriddenDescriptors(bVar, collection);
        }
    }
}

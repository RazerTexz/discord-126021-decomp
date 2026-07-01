package d0.e0.p.d.m0.n;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ErrorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$b implements u0 {
    public final /* synthetic */ t$c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3539b;

    public t$b(t$c t_c, String str) {
        this.a = t_c;
        this.f3539b = str;
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i != 3 ? 2 : 3];
        if (i != 3) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
        } else {
            objArr[0] = "kotlinTypeRefiner";
        }
        if (i == 1) {
            objArr[1] = "getSupertypes";
        } else if (i == 2) {
            objArr[1] = "getBuiltIns";
        } else if (i == 3) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
        } else if (i != 4) {
            objArr[1] = "getParameters";
        } else {
            objArr[1] = "refine";
        }
        if (i == 3) {
            objArr[2] = "refine";
        }
        String str2 = String.format(str, objArr);
        if (i == 3) {
            throw new IllegalArgumentException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        d0.e0.p.d.m0.b.e eVar = d0.e0.p.d.m0.b.e.getInstance();
        if (eVar != null) {
            return eVar;
        }
        a(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<d0.e0.p.d.m0.c.z0> getParameters() {
        List<d0.e0.p.d.m0.c.z0> listEmptyList = d0.t.n.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(0);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public Collection<c0> getSupertypes() {
        List listEmptyList = d0.t.n.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        if (gVar != null) {
            return this;
        }
        a(3);
        throw null;
    }

    public String toString() {
        return this.f3539b;
    }
}

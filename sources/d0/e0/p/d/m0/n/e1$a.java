package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: TypeUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class e1$a extends m {
    public final String k;

    public e1$a(String str) {
        this.k = str;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0030  */
    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
        } else if (i == 2) {
            objArr[0] = "delegate";
        } else if (i == 3) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i != 4) {
            objArr[0] = "newAnnotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
        }
        if (i == 1) {
            objArr[1] = "toString";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
        } else {
            objArr[1] = "refine";
        }
        if (i != 1) {
            if (i == 2) {
                objArr[2] = "replaceDelegate";
            } else if (i == 3) {
                objArr[2] = "refine";
            } else if (i != 4) {
                objArr[2] = "replaceAnnotations";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.n.m
    public j0 getDelegate() {
        throw new IllegalStateException(this.k);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public e1$a refine(d0.e0.p.d.m0.n.l1.g gVar) {
        if (gVar != null) {
            return this;
        }
        a(3);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.m
    public m replaceDelegate(j0 j0Var) {
        if (j0Var != null) {
            throw new IllegalStateException(this.k);
        }
        a(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.j0
    public String toString() {
        String str = this.k;
        if (str != null) {
            return str;
        }
        a(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 makeNullableAsSpecified(boolean z2) {
        throw new IllegalStateException(this.k);
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ j0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        if (gVar != null) {
            throw new IllegalStateException(this.k);
        }
        a(0);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }
}

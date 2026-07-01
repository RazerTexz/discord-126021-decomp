package d0.e0.p.d.m0.c.i1;

/* JADX INFO: compiled from: LazyClassReceiverParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends c {
    public final d0.e0.p.d.m0.c.e m;
    public final d0.e0.p.d.m0.k.a0.p.c n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(d0.e0.p.d.m0.c.e eVar) {
        super(d0.e0.p.d.m0.c.g1.g.f.getEMPTY());
        if (eVar == null) {
            a(0);
            throw null;
        }
        this.m = eVar;
        this.n = new d0.e0.p.d.m0.k.a0.p.c(eVar, null);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.m getContainingDeclaration() {
        d0.e0.p.d.m0.c.e eVar = this.m;
        if (eVar != null) {
            return eVar;
        }
        a(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.q0
    public d0.e0.p.d.m0.k.a0.p.d getValue() {
        d0.e0.p.d.m0.k.a0.p.c cVar = this.n;
        if (cVar != null) {
            return cVar;
        }
        a(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.k
    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("class ");
        sbU.append(this.m.getName());
        sbU.append("::this");
        return sbU.toString();
    }
}

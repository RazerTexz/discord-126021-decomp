package d0.e0.p.d.m0.c.i1;

/* JADX INFO: compiled from: ReceiverParameterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class f0 extends c {
    public final d0.e0.p.d.m0.c.m m;
    public final d0.e0.p.d.m0.k.a0.p.d n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.k.a0.p.d dVar, d0.e0.p.d.m0.c.g1.g gVar) {
        super(gVar);
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (dVar == null) {
            a(1);
            throw null;
        }
        if (gVar == null) {
            a(2);
            throw null;
        }
        this.m = mVar;
        this.n = dVar;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "value";
        } else if (i == 2) {
            objArr[0] = "annotations";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else if (i != 5) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 3) {
            objArr[1] = "getValue";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 3 && i != 4) {
            if (i != 5) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.m getContainingDeclaration() {
        d0.e0.p.d.m0.c.m mVar = this.m;
        if (mVar != null) {
            return mVar;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.q0
    public d0.e0.p.d.m0.k.a0.p.d getValue() {
        d0.e0.p.d.m0.k.a0.p.d dVar = this.n;
        if (dVar != null) {
            return dVar;
        }
        a(3);
        throw null;
    }
}

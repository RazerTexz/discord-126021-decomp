package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: DescriptorVisibilities.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$f extends r {
    public t$f(f1 f1Var) {
        super(f1Var);
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "from";
        } else if (i == 2) {
            objArr[0] = "whatDeclaration";
        } else if (i != 3) {
            objArr[0] = "what";
        } else {
            objArr[0] = "fromClass";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
        if (i == 2 || i == 3) {
            objArr[2] = "doesReceiverFitForProtectedVisibility";
        } else {
            objArr[2] = "isVisible";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: Code duplicated, block: B:47:0x007b  */
    @Override // d0.e0.p.d.m0.c.u
    public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
        e eVar;
        boolean z2 = false;
        if (qVar == null) {
            a(0);
            throw null;
        }
        if (mVar == null) {
            a(1);
            throw null;
        }
        e eVar2 = (e) d0.e0.p.d.m0.k.e.getParentOfType(qVar, e.class);
        e eVar3 = (e) d0.e0.p.d.m0.k.e.getParentOfType(mVar, e.class, false);
        if (eVar3 == null) {
            return false;
        }
        if (eVar2 != null && d0.e0.p.d.m0.k.e.isCompanionObject(eVar2) && (eVar = (e) d0.e0.p.d.m0.k.e.getParentOfType(eVar2, e.class)) != null && d0.e0.p.d.m0.k.e.isSubclass(eVar3, eVar)) {
            return true;
        }
        q qVarUnwrapFakeOverrideToAnyDeclaration = d0.e0.p.d.m0.k.e.unwrapFakeOverrideToAnyDeclaration(qVar);
        e eVar4 = (e) d0.e0.p.d.m0.k.e.getParentOfType(qVarUnwrapFakeOverrideToAnyDeclaration, e.class);
        if (eVar4 == null) {
            return false;
        }
        if (d0.e0.p.d.m0.k.e.isSubclass(eVar3, eVar4)) {
            if (qVarUnwrapFakeOverrideToAnyDeclaration == null) {
                a(2);
                throw null;
            }
            if (dVar != t.n) {
                if (!(qVarUnwrapFakeOverrideToAnyDeclaration instanceof b) || (qVarUnwrapFakeOverrideToAnyDeclaration instanceof l) || dVar == t.m) {
                    z2 = true;
                } else if (dVar != t.l && dVar != null) {
                    d0.e0.p.d.m0.n.c0 thisType = dVar instanceof d0.e0.p.d.m0.k.a0.p.e ? ((d0.e0.p.d.m0.k.a0.p.e) dVar).getThisType() : dVar.getType();
                    if (d0.e0.p.d.m0.k.e.isSubtypeOfClass(thisType, eVar3) || d0.e0.p.d.m0.n.r.isDynamic(thisType)) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                return true;
            }
        }
        return isVisible(dVar, qVar, eVar3.getContainingDeclaration());
    }
}

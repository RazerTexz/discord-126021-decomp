package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: DescriptorVisibilities.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$d extends r {
    public t$d(f1 f1Var) {
        super(f1Var);
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "what";
        } else if (i != 2) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "from";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
        if (i == 1 || i == 2) {
            objArr[2] = "isVisible";
        } else {
            objArr[2] = "hasContainingSourceFile";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.c.u
    public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
        if (qVar == 0) {
            a(1);
            throw null;
        }
        if (mVar == null) {
            a(2);
            throw null;
        }
        if (d0.e0.p.d.m0.k.e.isTopLevelDeclaration(qVar)) {
            if (mVar == null) {
                a(0);
                throw null;
            }
            if (d0.e0.p.d.m0.k.e.getContainingSourceFile(mVar) != v0.a) {
                return t.inSameFile(qVar, mVar);
            }
        }
        if (qVar instanceof l) {
            i containingDeclaration = ((l) qVar).getContainingDeclaration();
            if (d0.e0.p.d.m0.k.e.isSealedClass(containingDeclaration) && d0.e0.p.d.m0.k.e.isTopLevelDeclaration(containingDeclaration) && (mVar instanceof l) && d0.e0.p.d.m0.k.e.isTopLevelDeclaration(mVar.getContainingDeclaration()) && t.inSameFile(qVar, mVar)) {
                return true;
            }
        }
        while (qVar != 0) {
            qVar = qVar.getContainingDeclaration();
            if (((qVar instanceof e) && !d0.e0.p.d.m0.k.e.isCompanionObject(qVar)) || (qVar instanceof e0)) {
                break;
            }
        }
        if (qVar == 0) {
            return false;
        }
        while (mVar != null) {
            if (qVar == mVar) {
                return true;
            }
            if (mVar instanceof e0) {
                return (qVar instanceof e0) && ((e0) qVar).getFqName().equals(((e0) mVar).getFqName()) && d0.e0.p.d.m0.k.e.areInSameModule(mVar, qVar);
            }
            mVar = mVar.getContainingDeclaration();
        }
        return false;
    }
}

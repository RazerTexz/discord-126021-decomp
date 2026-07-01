package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: DescriptorVisibilities.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$e extends r {
    public t$e(f1 f1Var) {
        super(f1Var);
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "what";
        } else {
            objArr[0] = "from";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
        objArr[2] = "isVisible";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // d0.e0.p.d.m0.c.u
    public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
        m parentOfType;
        if (qVar == null) {
            a(0);
            throw null;
        }
        if (mVar == null) {
            a(1);
            throw null;
        }
        if (t.a.isVisible(dVar, qVar, mVar)) {
            if (dVar == t.m) {
                return true;
            }
            if (dVar != t.l && (parentOfType = d0.e0.p.d.m0.k.e.getParentOfType(qVar, e.class)) != null && (dVar instanceof d0.e0.p.d.m0.k.a0.p.f)) {
                return ((d0.e0.p.d.m0.k.a0.p.f) dVar).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
            }
        }
        return false;
    }
}

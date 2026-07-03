package p007b.p195g.p196a.p205c.p218h0;

import p007b.p195g.p196a.p205c.AbstractC2360j;

/* JADX INFO: renamed from: b.g.a.c.h0.j */
/* JADX INFO: compiled from: ResolvedRecursiveType.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2331j extends AbstractC2333l {
    private static final long serialVersionUID = 1;
    public AbstractC2360j _referencedType;

    public C2331j(Class<?> cls, C2334m c2334m) {
        super(cls, c2334m, null, null, 0, null, null, false);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: C */
    public AbstractC2360j mo2093C(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr) {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: D */
    public AbstractC2360j mo2094D(AbstractC2360j abstractC2360j) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: E */
    public AbstractC2360j mo2095E(Object obj) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: G */
    public AbstractC2360j mo2129M() {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: H */
    public AbstractC2360j mo2130N(Object obj) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: I */
    public AbstractC2360j mo2131O(Object obj) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == C2331j.class) {
        }
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.AbstractC2333l, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: j */
    public C2334m mo2136j() {
        AbstractC2360j abstractC2360j = this._referencedType;
        return abstractC2360j != null ? abstractC2360j.mo2136j() : this._bindings;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        AbstractC2360j abstractC2360j = this._referencedType;
        return abstractC2360j != null ? abstractC2360j.mo2100l(sb) : sb;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        AbstractC2360j abstractC2360j = this._referencedType;
        if (abstractC2360j != null) {
            return abstractC2360j.mo2100l(sb);
        }
        sb.append("?");
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.AbstractC2333l, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: q */
    public AbstractC2360j mo2137q() {
        AbstractC2360j abstractC2360j = this._referencedType;
        return abstractC2360j != null ? abstractC2360j.mo2137q() : this._superClass;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[recursive type; ");
        AbstractC2360j abstractC2360j = this._referencedType;
        if (abstractC2360j == null) {
            sb.append("UNRESOLVED");
        } else {
            sb.append(abstractC2360j._class.getName());
        }
        return sb.toString();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: v */
    public boolean mo2104v() {
        return false;
    }
}

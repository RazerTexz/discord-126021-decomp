package p007b.p195g.p196a.p205c.p218h0;

import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;

/* JADX INFO: renamed from: b.g.a.c.h0.d */
/* JADX INFO: compiled from: CollectionLikeType.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2325d extends AbstractC2333l {
    private static final long serialVersionUID = 1;
    public final AbstractC2360j _elementType;

    public C2325d(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr, AbstractC2360j abstractC2360j2, Object obj, Object obj2, boolean z2) {
        super(cls, c2334m, abstractC2360j, abstractC2360jArr, abstractC2360j2._hash, obj, obj2, z2);
        this._elementType = abstractC2360j2;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: C */
    public AbstractC2360j mo2093C(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr) {
        return new C2325d(cls, c2334m, abstractC2360j, abstractC2360jArr, this._elementType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: D */
    public AbstractC2360j mo2094D(AbstractC2360j abstractC2360j) {
        return this._elementType == abstractC2360j ? this : new C2325d(this._class, this._bindings, this._superClass, this._superInterfaces, abstractC2360j, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: F */
    public AbstractC2360j mo2105F(AbstractC2360j abstractC2360j) {
        AbstractC2360j abstractC2360jMo2105F;
        AbstractC2360j abstractC2360jMo2105F2 = super.mo2105F(abstractC2360j);
        AbstractC2360j abstractC2360jMo2099k = abstractC2360j.mo2099k();
        return (abstractC2360jMo2099k == null || (abstractC2360jMo2105F = this._elementType.mo2105F(abstractC2360jMo2099k)) == this._elementType) ? abstractC2360jMo2105F2 : abstractC2360jMo2105F2.mo2094D(abstractC2360jMo2105F);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.AbstractC2333l
    /* JADX INFO: renamed from: K */
    public String mo2106K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._elementType != null) {
            sb.append('<');
            sb.append(this._elementType.mo1729e());
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public C2325d mo2095E(Object obj) {
        return new C2325d(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.mo2130N(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public C2325d mo2129M() {
        return this._asStatic ? this : new C2325d(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.mo2129M(), this._valueHandler, this._typeHandler, true);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public C2325d mo2130N(Object obj) {
        return new C2325d(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, this._valueHandler, obj, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public C2325d mo2131O(Object obj) {
        return new C2325d(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        C2325d c2325d = (C2325d) obj;
        return this._class == c2325d._class && this._elementType.equals(c2325d._elementType);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: k */
    public AbstractC2360j mo2099k() {
        return this._elementType;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        AbstractC2333l.m2139J(this._class, sb, true);
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        AbstractC2333l.m2139J(this._class, sb, false);
        sb.append('<');
        this._elementType.mo2101m(sb);
        sb.append(">;");
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: s */
    public boolean mo2103s() {
        return super.mo2103s() || this._elementType.mo2103s();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[collection-like type; class ");
        C1643a.m860k0(this._class, sbM833U, ", contains ");
        sbM833U.append(this._elementType);
        sbM833U.append("]");
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: u */
    public boolean mo2111u() {
        return true;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: v */
    public boolean mo2104v() {
        return true;
    }
}

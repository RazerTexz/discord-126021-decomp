package p007b.p195g.p196a.p205c.p218h0;

import p007b.p195g.p196a.p198b.p203s.AbstractC2137a;
import p007b.p195g.p196a.p205c.AbstractC2360j;

/* JADX INFO: renamed from: b.g.a.c.h0.i */
/* JADX INFO: compiled from: ReferenceType.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2330i extends C2332k {
    private static final long serialVersionUID = 1;
    public final AbstractC2360j _anchorType;
    public final AbstractC2360j _referencedType;

    public C2330i(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr, AbstractC2360j abstractC2360j2, AbstractC2360j abstractC2360j3, Object obj, Object obj2, boolean z2) {
        super(cls, c2334m, abstractC2360j, abstractC2360jArr, abstractC2360j2._hash, obj, obj2, z2);
        this._referencedType = abstractC2360j2;
        this._anchorType = abstractC2360j3 == null ? this : abstractC2360j3;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: C */
    public AbstractC2360j mo2093C(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr) {
        return new C2330i(cls, this._bindings, abstractC2360j, abstractC2360jArr, this._referencedType, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: D */
    public AbstractC2360j mo2094D(AbstractC2360j abstractC2360j) {
        return this._referencedType == abstractC2360j ? this : new C2330i(this._class, this._bindings, this._superClass, this._superInterfaces, abstractC2360j, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: E */
    public AbstractC2360j mo2095E(Object obj) {
        AbstractC2360j abstractC2360j = this._referencedType;
        return obj == abstractC2360j._typeHandler ? this : new C2330i(this._class, this._bindings, this._superClass, this._superInterfaces, abstractC2360j.mo2130N(obj), this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k, p007b.p195g.p196a.p205c.p218h0.AbstractC2333l
    /* JADX INFO: renamed from: K */
    public String mo2106K() {
        return this._class.getName() + '<' + this._referencedType.mo1729e() + '>';
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C2330i mo2129M() {
        return this._asStatic ? this : new C2330i(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType.mo2129M(), this._anchorType, this._valueHandler, this._typeHandler, true);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C2330i mo2130N(Object obj) {
        return obj == this._typeHandler ? this : new C2330i(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, this._valueHandler, obj, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C2330i mo2131O(Object obj) {
        return obj == this._valueHandler ? this : new C2330i(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j, p007b.p195g.p196a.p198b.p203s.AbstractC2137a
    /* JADX INFO: renamed from: a */
    public AbstractC2137a mo1727a() {
        return this._referencedType;
    }

    @Override // p007b.p195g.p196a.p198b.p203s.AbstractC2137a
    /* JADX INFO: renamed from: b */
    public boolean mo1728b() {
        return true;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k, p007b.p195g.p196a.p205c.AbstractC2360j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C2330i.class) {
            return false;
        }
        C2330i c2330i = (C2330i) obj;
        if (c2330i._class != this._class) {
            return false;
        }
        return this._referencedType.equals(c2330i._referencedType);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: k */
    public AbstractC2360j mo2099k() {
        return this._referencedType;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        AbstractC2333l.m2139J(this._class, sb, true);
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        AbstractC2333l.m2139J(this._class, sb, false);
        sb.append('<');
        StringBuilder sbMo2101m = this._referencedType.mo2101m(sb);
        sbMo2101m.append(">;");
        return sbMo2101m;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: p */
    public AbstractC2360j mo1727a() {
        return this._referencedType;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2332k
    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[reference type, class ");
        sb.append(mo2106K());
        sb.append('<');
        sb.append(this._referencedType);
        sb.append('>');
        sb.append(']');
        return sb.toString();
    }
}

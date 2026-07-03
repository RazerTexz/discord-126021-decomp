package p007b.p195g.p196a.p205c.p218h0;

import p007b.p195g.p196a.p205c.AbstractC2360j;

/* JADX INFO: renamed from: b.g.a.c.h0.k */
/* JADX INFO: compiled from: SimpleType.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2332k extends AbstractC2333l {
    private static final long serialVersionUID = 1;

    public C2332k(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr, Object obj, Object obj2, boolean z2) {
        super(cls, c2334m, abstractC2360j, abstractC2360jArr, 0, obj, obj2, z2);
    }

    /* JADX INFO: renamed from: L */
    public static C2332k m2138L(Class<?> cls) {
        return new C2332k(cls, null, null, null, null, null, false);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: C */
    public AbstractC2360j mo2093C(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr) {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: D */
    public AbstractC2360j mo2094D(AbstractC2360j abstractC2360j) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: E */
    public AbstractC2360j mo2095E(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.AbstractC2333l
    /* JADX INFO: renamed from: K */
    public String mo2106K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        int iM2155j = this._bindings.m2155j();
        if (iM2155j > 0) {
            sb.append('<');
            for (int i = 0; i < iM2155j; i++) {
                AbstractC2360j abstractC2360jMo2142f = mo2142f(i);
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(abstractC2360jMo2142f.mo1729e());
            }
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: M */
    public C2332k mo2129M() {
        return this._asStatic ? this : new C2332k(this._class, this._bindings, this._superClass, this._superInterfaces, this._valueHandler, this._typeHandler, true);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: N */
    public C2332k mo2130N(Object obj) {
        return this._typeHandler == obj ? this : new C2332k(this._class, this._bindings, this._superClass, this._superInterfaces, this._valueHandler, obj, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: O */
    public C2332k mo2131O(Object obj) {
        return obj == this._valueHandler ? this : new C2332k(this._class, this._bindings, this._superClass, this._superInterfaces, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        C2332k c2332k = (C2332k) obj;
        if (c2332k._class != this._class) {
            return false;
        }
        return this._bindings.equals(c2332k._bindings);
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
        int iM2155j = this._bindings.m2155j();
        if (iM2155j > 0) {
            sb.append('<');
            for (int i = 0; i < iM2155j; i++) {
                sb = mo2142f(i).mo2101m(sb);
            }
            sb.append('>');
        }
        sb.append(';');
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[simple type, class ");
        sb.append(mo2106K());
        sb.append(']');
        return sb.toString();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: v */
    public boolean mo2104v() {
        return false;
    }

    public C2332k(Class<?> cls) {
        this(cls, C2334m.f4908l, null, null, null, null, false);
    }

    public C2332k(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr, int i, Object obj, Object obj2, boolean z2) {
        super(cls, c2334m, abstractC2360j, abstractC2360jArr, i, obj, obj2, z2);
    }
}

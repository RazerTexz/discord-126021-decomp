package p007b.p195g.p196a.p205c.p218h0;

import java.lang.reflect.Array;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;

/* JADX INFO: renamed from: b.g.a.c.h0.a */
/* JADX INFO: compiled from: ArrayType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2322a extends AbstractC2333l {
    private static final long serialVersionUID = 1;
    public final AbstractC2360j _componentType;
    public final Object _emptyArray;

    public C2322a(AbstractC2360j abstractC2360j, C2334m c2334m, Object obj, Object obj2, Object obj3, boolean z2) {
        super(obj.getClass(), c2334m, null, null, abstractC2360j._hash, obj2, obj3, z2);
        this._componentType = abstractC2360j;
        this._emptyArray = obj;
    }

    /* JADX INFO: renamed from: L */
    public static C2322a m2092L(AbstractC2360j abstractC2360j, C2334m c2334m) {
        return new C2322a(abstractC2360j, c2334m, Array.newInstance(abstractC2360j._class, 0), null, null, false);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: C */
    public AbstractC2360j mo2093C(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr) {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: D */
    public AbstractC2360j mo2094D(AbstractC2360j abstractC2360j) {
        return new C2322a(abstractC2360j, this._bindings, Array.newInstance(abstractC2360j._class, 0), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: E */
    public AbstractC2360j mo2095E(Object obj) {
        AbstractC2360j abstractC2360j = this._componentType;
        return obj == abstractC2360j._typeHandler ? this : new C2322a(abstractC2360j.mo2130N(obj), this._bindings, this._emptyArray, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: G */
    public AbstractC2360j mo2129M() {
        return this._asStatic ? this : new C2322a(this._componentType.mo2129M(), this._bindings, this._emptyArray, this._valueHandler, this._typeHandler, true);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: H */
    public AbstractC2360j mo2130N(Object obj) {
        return obj == this._typeHandler ? this : new C2322a(this._componentType, this._bindings, this._emptyArray, this._valueHandler, obj, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: I */
    public AbstractC2360j mo2131O(Object obj) {
        return obj == this._valueHandler ? this : new C2322a(this._componentType, this._bindings, this._emptyArray, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == C2322a.class) {
            return this._componentType.equals(((C2322a) obj)._componentType);
        }
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: k */
    public AbstractC2360j mo2099k() {
        return this._componentType;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        sb.append('[');
        return this._componentType.mo2100l(sb);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        sb.append('[');
        return this._componentType.mo2101m(sb);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: r */
    public boolean mo2102r() {
        return this._componentType.mo2102r();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: s */
    public boolean mo2103s() {
        return super.mo2103s() || this._componentType.mo2103s();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[array type, component type: ");
        sbM833U.append(this._componentType);
        sbM833U.append("]");
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: v */
    public boolean mo2104v() {
        return true;
    }
}

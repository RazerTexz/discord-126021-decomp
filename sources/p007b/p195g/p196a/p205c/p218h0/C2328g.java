package p007b.p195g.p196a.p205c.p218h0;

import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;

/* JADX INFO: renamed from: b.g.a.c.h0.g */
/* JADX INFO: compiled from: MapType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2328g extends C2327f {
    private static final long serialVersionUID = 1;

    public C2328g(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr, AbstractC2360j abstractC2360j2, AbstractC2360j abstractC2360j3, Object obj, Object obj2, boolean z2) {
        super(cls, c2334m, abstractC2360j, abstractC2360jArr, abstractC2360j2, abstractC2360j3, obj, obj2, z2);
    }

    /* JADX INFO: renamed from: Q */
    public static C2328g m2123Q(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr, AbstractC2360j abstractC2360j2, AbstractC2360j abstractC2360j3) {
        return new C2328g(cls, c2334m, abstractC2360j, abstractC2360jArr, abstractC2360j2, abstractC2360j3, null, null, false);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2327f, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: C */
    public AbstractC2360j mo2093C(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr) {
        return new C2328g(cls, c2334m, abstractC2360j, abstractC2360jArr, this._keyType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2327f, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: D */
    public AbstractC2360j mo2094D(AbstractC2360j abstractC2360j) {
        return this._valueType == abstractC2360j ? this : new C2328g(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, abstractC2360j, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2327f
    /* JADX INFO: renamed from: M */
    public C2327f mo2117M(AbstractC2360j abstractC2360j) {
        return abstractC2360j == this._keyType ? this : new C2328g(this._class, this._bindings, this._superClass, this._superInterfaces, abstractC2360j, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2327f
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public C2328g mo2095E(Object obj) {
        return new C2328g(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.mo2130N(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2327f
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public C2328g mo2096G() {
        return this._asStatic ? this : new C2328g(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType.mo2129M(), this._valueType.mo2129M(), this._valueHandler, this._typeHandler, true);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2327f
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public C2328g mo2097H(Object obj) {
        return new C2328g(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, this._valueHandler, obj, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2327f
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public C2328g mo2098I(Object obj) {
        return new C2328g(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2327f
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[map type; class ");
        C1643a.m860k0(this._class, sbM833U, ", ");
        sbM833U.append(this._keyType);
        sbM833U.append(" -> ");
        sbM833U.append(this._valueType);
        sbM833U.append("]");
        return sbM833U.toString();
    }
}

package p007b.p195g.p196a.p205c.p218h0;

import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;

/* JADX INFO: renamed from: b.g.a.c.h0.e */
/* JADX INFO: compiled from: CollectionType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2326e extends C2325d {
    private static final long serialVersionUID = 1;

    public C2326e(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr, AbstractC2360j abstractC2360j2, Object obj, Object obj2, boolean z2) {
        super(cls, c2334m, abstractC2360j, abstractC2360jArr, abstractC2360j2, obj, obj2, z2);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2325d, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: C */
    public AbstractC2360j mo2093C(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr) {
        return new C2326e(cls, c2334m, abstractC2360j, abstractC2360jArr, this._elementType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2325d, p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: D */
    public AbstractC2360j mo2094D(AbstractC2360j abstractC2360j) {
        return this._elementType == abstractC2360j ? this : new C2326e(this._class, this._bindings, this._superClass, this._superInterfaces, abstractC2360j, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2325d
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public C2326e mo2095E(Object obj) {
        return new C2326e(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.mo2130N(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2325d
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public C2326e mo2096G() {
        return this._asStatic ? this : new C2326e(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.mo2129M(), this._valueHandler, this._typeHandler, true);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2325d
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public C2326e mo2097H(Object obj) {
        return new C2326e(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, this._valueHandler, obj, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2325d
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public C2326e mo2098I(Object obj) {
        return new C2326e(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.C2325d
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[collection type; class ");
        C1643a.m860k0(this._class, sbM833U, ", contains ");
        sbM833U.append(this._elementType);
        sbM833U.append("]");
        return sbM833U.toString();
    }
}

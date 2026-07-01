package b.g.a.c.h0;

/* JADX INFO: compiled from: CollectionType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends d {
    private static final long serialVersionUID = 1;

    public e(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr, b.g.a.c.j jVar2, Object obj, Object obj2, boolean z2) {
        super(cls, mVar, jVar, jVarArr, jVar2, obj, obj2, z2);
    }

    @Override // b.g.a.c.h0.d, b.g.a.c.j
    public b.g.a.c.j C(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr) {
        return new e(cls, mVar, jVar, jVarArr, this._elementType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.d, b.g.a.c.j
    public b.g.a.c.j D(b.g.a.c.j jVar) {
        return this._elementType == jVar ? this : new e(this._class, this._bindings, this._superClass, this._superInterfaces, jVar, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.d, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j E(Object obj) {
        return P(obj);
    }

    @Override // b.g.a.c.h0.d, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j G() {
        return Q();
    }

    @Override // b.g.a.c.h0.d, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j H(Object obj) {
        return R(obj);
    }

    @Override // b.g.a.c.h0.d, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j I(Object obj) {
        return S(obj);
    }

    @Override // b.g.a.c.h0.d
    public /* bridge */ /* synthetic */ d L(Object obj) {
        return P(obj);
    }

    @Override // b.g.a.c.h0.d
    public /* bridge */ /* synthetic */ d M() {
        return Q();
    }

    @Override // b.g.a.c.h0.d
    public /* bridge */ /* synthetic */ d N(Object obj) {
        return R(obj);
    }

    @Override // b.g.a.c.h0.d
    public /* bridge */ /* synthetic */ d O(Object obj) {
        return S(obj);
    }

    public e P(Object obj) {
        return new e(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.H(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public e Q() {
        return this._asStatic ? this : new e(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.G(), this._valueHandler, this._typeHandler, true);
    }

    public e R(Object obj) {
        return new e(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, this._valueHandler, obj, this._asStatic);
    }

    public e S(Object obj) {
        return new e(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.d
    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[collection type; class ");
        b.d.b.a.a.k0(this._class, sbU, ", contains ");
        sbU.append(this._elementType);
        sbU.append("]");
        return sbU.toString();
    }
}

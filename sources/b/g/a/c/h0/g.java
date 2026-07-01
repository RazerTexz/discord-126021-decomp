package b.g.a.c.h0;

/* JADX INFO: compiled from: MapType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends f {
    private static final long serialVersionUID = 1;

    public g(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr, b.g.a.c.j jVar2, b.g.a.c.j jVar3, Object obj, Object obj2, boolean z2) {
        super(cls, mVar, jVar, jVarArr, jVar2, jVar3, obj, obj2, z2);
    }

    public static g Q(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr, b.g.a.c.j jVar2, b.g.a.c.j jVar3) {
        return new g(cls, mVar, jVar, jVarArr, jVar2, jVar3, null, null, false);
    }

    @Override // b.g.a.c.h0.f, b.g.a.c.j
    public b.g.a.c.j C(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr) {
        return new g(cls, mVar, jVar, jVarArr, this._keyType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.f, b.g.a.c.j
    public b.g.a.c.j D(b.g.a.c.j jVar) {
        return this._valueType == jVar ? this : new g(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, jVar, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.f, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j E(Object obj) {
        return R(obj);
    }

    @Override // b.g.a.c.h0.f, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j G() {
        return S();
    }

    @Override // b.g.a.c.h0.f, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j H(Object obj) {
        return T(obj);
    }

    @Override // b.g.a.c.h0.f, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j I(Object obj) {
        return U(obj);
    }

    @Override // b.g.a.c.h0.f
    public /* bridge */ /* synthetic */ f L(Object obj) {
        return R(obj);
    }

    @Override // b.g.a.c.h0.f
    public f M(b.g.a.c.j jVar) {
        return jVar == this._keyType ? this : new g(this._class, this._bindings, this._superClass, this._superInterfaces, jVar, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.f
    public /* bridge */ /* synthetic */ f N() {
        return S();
    }

    @Override // b.g.a.c.h0.f
    public /* bridge */ /* synthetic */ f O(Object obj) {
        return T(obj);
    }

    @Override // b.g.a.c.h0.f
    public /* bridge */ /* synthetic */ f P(Object obj) {
        return U(obj);
    }

    public g R(Object obj) {
        return new g(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.H(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public g S() {
        return this._asStatic ? this : new g(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType.G(), this._valueType.G(), this._valueHandler, this._typeHandler, true);
    }

    public g T(Object obj) {
        return new g(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, this._valueHandler, obj, this._asStatic);
    }

    public g U(Object obj) {
        return new g(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.f
    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[map type; class ");
        b.d.b.a.a.k0(this._class, sbU, ", ");
        sbU.append(this._keyType);
        sbU.append(" -> ");
        sbU.append(this._valueType);
        sbU.append("]");
        return sbU.toString();
    }
}

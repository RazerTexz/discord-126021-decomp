package b.g.a.c.h0;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: ArrayType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends l {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.j _componentType;
    public final Object _emptyArray;

    public a(b.g.a.c.j jVar, m mVar, Object obj, Object obj2, Object obj3, boolean z2) {
        super(obj.getClass(), mVar, null, null, jVar._hash, obj2, obj3, z2);
        this._componentType = jVar;
        this._emptyArray = obj;
    }

    public static a L(b.g.a.c.j jVar, m mVar) {
        return new a(jVar, mVar, Array.newInstance(jVar._class, 0), null, null, false);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j C(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr) {
        return null;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j D(b.g.a.c.j jVar) {
        return new a(jVar, this._bindings, Array.newInstance(jVar._class, 0), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j E(Object obj) {
        b.g.a.c.j jVar = this._componentType;
        return obj == jVar._typeHandler ? this : new a(jVar.H(obj), this._bindings, this._emptyArray, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j G() {
        return this._asStatic ? this : new a(this._componentType.G(), this._bindings, this._emptyArray, this._valueHandler, this._typeHandler, true);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j H(Object obj) {
        return obj == this._typeHandler ? this : new a(this._componentType, this._bindings, this._emptyArray, this._valueHandler, obj, this._asStatic);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j I(Object obj) {
        return obj == this._valueHandler ? this : new a(this._componentType, this._bindings, this._emptyArray, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == a.class) {
            return this._componentType.equals(((a) obj)._componentType);
        }
        return false;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j k() {
        return this._componentType;
    }

    @Override // b.g.a.c.j
    public StringBuilder l(StringBuilder sb) {
        sb.append('[');
        return this._componentType.l(sb);
    }

    @Override // b.g.a.c.j
    public StringBuilder m(StringBuilder sb) {
        sb.append('[');
        return this._componentType.m(sb);
    }

    @Override // b.g.a.c.j
    public boolean r() {
        return this._componentType.r();
    }

    @Override // b.g.a.c.j
    public boolean s() {
        return super.s() || this._componentType.s();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[array type, component type: ");
        sbU.append(this._componentType);
        sbU.append("]");
        return sbU.toString();
    }

    @Override // b.g.a.c.j
    public boolean v() {
        return true;
    }
}

package b.g.a.c.h0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;
import java.lang.reflect.Array;

/* JADX INFO: renamed from: b.g.a.c.h0.a, reason: use source file name */
/* JADX INFO: compiled from: ArrayType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ArrayType extends TypeBase {
    private static final long serialVersionUID = 1;
    public final JavaType _componentType;
    public final Object _emptyArray;

    public ArrayType(JavaType javaType, TypeBindings typeBindings, Object obj, Object obj2, Object obj3, boolean z2) {
        super(obj.getClass(), typeBindings, null, null, javaType._hash, obj2, obj3, z2);
        this._componentType = javaType;
        this._emptyArray = obj;
    }

    public static ArrayType L(JavaType javaType, TypeBindings typeBindings) {
        return new ArrayType(javaType, typeBindings, Array.newInstance(javaType._class, 0), null, null, false);
    }

    @Override // b.g.a.c.JavaType
    public JavaType C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    @Override // b.g.a.c.JavaType
    public JavaType D(JavaType javaType) {
        return new ArrayType(javaType, this._bindings, Array.newInstance(javaType._class, 0), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    public JavaType E(Object obj) {
        JavaType javaType = this._componentType;
        return obj == javaType._typeHandler ? this : new ArrayType(javaType.N(obj), this._bindings, this._emptyArray, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: G */
    public JavaType M() {
        return this._asStatic ? this : new ArrayType(this._componentType.M(), this._bindings, this._emptyArray, this._valueHandler, this._typeHandler, true);
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: H */
    public JavaType N(Object obj) {
        return obj == this._typeHandler ? this : new ArrayType(this._componentType, this._bindings, this._emptyArray, this._valueHandler, obj, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: I */
    public JavaType O(Object obj) {
        return obj == this._valueHandler ? this : new ArrayType(this._componentType, this._bindings, this._emptyArray, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == ArrayType.class) {
            return this._componentType.equals(((ArrayType) obj)._componentType);
        }
        return false;
    }

    @Override // b.g.a.c.JavaType
    public JavaType k() {
        return this._componentType;
    }

    @Override // b.g.a.c.JavaType
    public StringBuilder l(StringBuilder sb) {
        sb.append('[');
        return this._componentType.l(sb);
    }

    @Override // b.g.a.c.JavaType
    public StringBuilder m(StringBuilder sb) {
        sb.append('[');
        return this._componentType.m(sb);
    }

    @Override // b.g.a.c.JavaType
    public boolean r() {
        return this._componentType.r();
    }

    @Override // b.g.a.c.JavaType
    public boolean s() {
        return super.s() || this._componentType.s();
    }

    public String toString() {
        StringBuilder sbU = outline.U("[array type, component type: ");
        sbU.append(this._componentType);
        sbU.append("]");
        return sbU.toString();
    }

    @Override // b.g.a.c.JavaType
    public boolean v() {
        return true;
    }
}

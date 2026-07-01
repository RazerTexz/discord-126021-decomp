package b.g.a.c.h0;

import b.g.a.c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.f, reason: use source file name */
/* JADX INFO: compiled from: MapLikeType.java */
/* JADX INFO: loaded from: classes3.dex */
public class MapLikeType extends TypeBase {
    private static final long serialVersionUID = 1;
    public final JavaType _keyType;
    public final JavaType _valueType;

    public MapLikeType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, JavaType javaType3, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2._hash ^ javaType3._hash, obj, obj2, z2);
        this._keyType = javaType2;
        this._valueType = javaType3;
    }

    @Override // b.g.a.c.JavaType
    public JavaType C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new MapLikeType(cls, typeBindings, javaType, javaTypeArr, this._keyType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    public JavaType D(JavaType javaType) {
        return this._valueType == javaType ? this : new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, javaType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    public JavaType F(JavaType javaType) {
        JavaType javaTypeF;
        JavaType javaTypeF2;
        JavaType javaTypeF3 = super.F(javaType);
        JavaType javaTypeO = javaType.o();
        if ((javaTypeF3 instanceof MapLikeType) && javaTypeO != null && (javaTypeF2 = this._keyType.F(javaTypeO)) != this._keyType) {
            javaTypeF3 = ((MapLikeType) javaTypeF3).M(javaTypeF2);
        }
        JavaType javaTypeK = javaType.k();
        return (javaTypeK == null || (javaTypeF = this._valueType.F(javaTypeK)) == this._valueType) ? javaTypeF3 : javaTypeF3.D(javaTypeF);
    }

    @Override // b.g.a.c.h0.TypeBase
    public String K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._keyType != null) {
            sb.append('<');
            sb.append(this._keyType.e());
            sb.append(',');
            sb.append(this._valueType.e());
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public MapLikeType E(Object obj) {
        return new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.N(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public MapLikeType M(JavaType javaType) {
        return javaType == this._keyType ? this : new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public MapLikeType M() {
        return this._asStatic ? this : new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.M(), this._valueHandler, this._typeHandler, true);
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public MapLikeType N(Object obj) {
        return new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, this._valueHandler, obj, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public MapLikeType O(Object obj) {
        return new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MapLikeType mapLikeType = (MapLikeType) obj;
        return this._class == mapLikeType._class && this._keyType.equals(mapLikeType._keyType) && this._valueType.equals(mapLikeType._valueType);
    }

    @Override // b.g.a.c.JavaType
    public JavaType k() {
        return this._valueType;
    }

    @Override // b.g.a.c.JavaType
    public StringBuilder l(StringBuilder sb) {
        TypeBase.J(this._class, sb, true);
        return sb;
    }

    @Override // b.g.a.c.JavaType
    public StringBuilder m(StringBuilder sb) {
        TypeBase.J(this._class, sb, false);
        sb.append('<');
        this._keyType.m(sb);
        this._valueType.m(sb);
        sb.append(">;");
        return sb;
    }

    @Override // b.g.a.c.JavaType
    public JavaType o() {
        return this._keyType;
    }

    @Override // b.g.a.c.JavaType
    public boolean s() {
        return super.s() || this._valueType.s() || this._keyType.s();
    }

    public String toString() {
        return String.format("[map-like type; class %s, %s -> %s]", this._class.getName(), this._keyType, this._valueType);
    }

    @Override // b.g.a.c.JavaType
    public boolean v() {
        return true;
    }

    @Override // b.g.a.c.JavaType
    public boolean z() {
        return true;
    }
}

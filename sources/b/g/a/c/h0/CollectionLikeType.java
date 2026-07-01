package b.g.a.c.h0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.d, reason: use source file name */
/* JADX INFO: compiled from: CollectionLikeType.java */
/* JADX INFO: loaded from: classes3.dex */
public class CollectionLikeType extends TypeBase {
    private static final long serialVersionUID = 1;
    public final JavaType _elementType;

    public CollectionLikeType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2._hash, obj, obj2, z2);
        this._elementType = javaType2;
    }

    @Override // b.g.a.c.JavaType
    public JavaType C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new CollectionLikeType(cls, typeBindings, javaType, javaTypeArr, this._elementType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    public JavaType D(JavaType javaType) {
        return this._elementType == javaType ? this : new CollectionLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    public JavaType F(JavaType javaType) {
        JavaType javaTypeF;
        JavaType javaTypeF2 = super.F(javaType);
        JavaType javaTypeK = javaType.k();
        return (javaTypeK == null || (javaTypeF = this._elementType.F(javaTypeK)) == this._elementType) ? javaTypeF2 : javaTypeF2.D(javaTypeF);
    }

    @Override // b.g.a.c.h0.TypeBase
    public String K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._elementType != null) {
            sb.append('<');
            sb.append(this._elementType.e());
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public CollectionLikeType E(Object obj) {
        return new CollectionLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.N(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public CollectionLikeType M() {
        return this._asStatic ? this : new CollectionLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.M(), this._valueHandler, this._typeHandler, true);
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public CollectionLikeType N(Object obj) {
        return new CollectionLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, this._valueHandler, obj, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public CollectionLikeType O(Object obj) {
        return new CollectionLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        CollectionLikeType collectionLikeType = (CollectionLikeType) obj;
        return this._class == collectionLikeType._class && this._elementType.equals(collectionLikeType._elementType);
    }

    @Override // b.g.a.c.JavaType
    public JavaType k() {
        return this._elementType;
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
        this._elementType.m(sb);
        sb.append(">;");
        return sb;
    }

    @Override // b.g.a.c.JavaType
    public boolean s() {
        return super.s() || this._elementType.s();
    }

    public String toString() {
        StringBuilder sbU = outline.U("[collection-like type; class ");
        outline.k0(this._class, sbU, ", contains ");
        sbU.append(this._elementType);
        sbU.append("]");
        return sbU.toString();
    }

    @Override // b.g.a.c.JavaType
    public boolean u() {
        return true;
    }

    @Override // b.g.a.c.JavaType
    public boolean v() {
        return true;
    }
}

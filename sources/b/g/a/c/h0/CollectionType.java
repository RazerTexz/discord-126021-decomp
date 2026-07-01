package b.g.a.c.h0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.e, reason: use source file name */
/* JADX INFO: compiled from: CollectionType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CollectionType extends CollectionLikeType {
    private static final long serialVersionUID = 1;

    public CollectionType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2, obj, obj2, z2);
    }

    @Override // b.g.a.c.h0.CollectionLikeType, b.g.a.c.JavaType
    public JavaType C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new CollectionType(cls, typeBindings, javaType, javaTypeArr, this._elementType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.CollectionLikeType, b.g.a.c.JavaType
    public JavaType D(JavaType javaType) {
        return this._elementType == javaType ? this : new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.CollectionLikeType
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public CollectionType E(Object obj) {
        return new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.N(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.CollectionLikeType
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public CollectionType G() {
        return this._asStatic ? this : new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.M(), this._valueHandler, this._typeHandler, true);
    }

    @Override // b.g.a.c.h0.CollectionLikeType
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public CollectionType H(Object obj) {
        return new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, this._valueHandler, obj, this._asStatic);
    }

    @Override // b.g.a.c.h0.CollectionLikeType
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public CollectionType I(Object obj) {
        return new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.CollectionLikeType
    public String toString() {
        StringBuilder sbU = outline.U("[collection type; class ");
        outline.k0(this._class, sbU, ", contains ");
        sbU.append(this._elementType);
        sbU.append("]");
        return sbU.toString();
    }
}

package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.b.PrimitiveType;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.l, reason: use source file name */
/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface typeSignatureMapping3<T> {
    T boxType(T t);

    T createFromString(String str);

    T createObjectType(String str);

    T createPrimitiveType(PrimitiveType primitiveType);

    T getJavaLangClassType();

    String toString(T t);
}

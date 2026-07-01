package b.g.a.c.h0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.h, reason: use source file name */
/* JADX INFO: compiled from: PlaceholderForType.java */
/* JADX INFO: loaded from: classes3.dex */
public class PlaceholderForType extends TypeBase {
    private static final long serialVersionUID = 1;
    public JavaType _actualType;
    public final int _ordinal;

    public PlaceholderForType(int i) {
        super(Object.class, TypeBindings.l, TypeFactory.k(), null, 1, null, null, false);
        this._ordinal = i;
    }

    @Override // b.g.a.c.JavaType
    public JavaType C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        L();
        throw null;
    }

    @Override // b.g.a.c.JavaType
    public JavaType D(JavaType javaType) {
        L();
        throw null;
    }

    @Override // b.g.a.c.JavaType
    public JavaType E(Object obj) {
        L();
        throw null;
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: G */
    public JavaType M() {
        L();
        throw null;
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: H */
    public JavaType N(Object obj) {
        L();
        throw null;
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: I */
    public JavaType O(Object obj) {
        L();
        throw null;
    }

    @Override // b.g.a.c.h0.TypeBase
    public String K() {
        return toString();
    }

    public final <T> T L() {
        StringBuilder sbU = outline.U("Operation should not be attempted on ");
        sbU.append(PlaceholderForType.class.getName());
        throw new UnsupportedOperationException(sbU.toString());
    }

    @Override // b.g.a.c.JavaType
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // b.g.a.c.JavaType
    public StringBuilder l(StringBuilder sb) {
        sb.append('$');
        sb.append(this._ordinal + 1);
        return sb;
    }

    @Override // b.g.a.c.JavaType
    public StringBuilder m(StringBuilder sb) {
        l(sb);
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        l(sb);
        return sb.toString();
    }

    @Override // b.g.a.c.JavaType
    public boolean v() {
        return false;
    }
}

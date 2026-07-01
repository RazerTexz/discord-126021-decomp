package b.g.a.c.e0.h;

import b.g.a.c.JavaType;
import b.g.a.c.e0.TypeIdResolver;
import b.g.a.c.h0.TypeFactory;

/* JADX INFO: renamed from: b.g.a.c.e0.h.k, reason: use source file name */
/* JADX INFO: compiled from: TypeIdResolverBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeIdResolverBase implements TypeIdResolver {
    public final TypeFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JavaType f698b;

    public TypeIdResolverBase(JavaType javaType, TypeFactory typeFactory) {
        this.f698b = javaType;
        this.a = typeFactory;
    }

    @Override // b.g.a.c.e0.TypeIdResolver
    public void b(JavaType javaType) {
    }
}

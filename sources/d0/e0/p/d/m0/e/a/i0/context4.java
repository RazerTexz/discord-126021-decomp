package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.e.a.JavaTypeQualifiersByElementType;
import d0.e0.p.d.m0.e.a.i0.m.JavaTypeResolver4;
import d0.e0.p.d.m0.m.StorageManager;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.g, reason: use source file name */
/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class context4 {
    public final context2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final resolvers2 f3323b;
    public final Lazy<JavaTypeQualifiersByElementType> c;
    public final Lazy d;
    public final JavaTypeResolver4 e;

    public context4(context2 context2Var, resolvers2 resolvers2Var, Lazy<JavaTypeQualifiersByElementType> lazy) {
        Intrinsics3.checkNotNullParameter(context2Var, "components");
        Intrinsics3.checkNotNullParameter(resolvers2Var, "typeParameterResolver");
        Intrinsics3.checkNotNullParameter(lazy, "delegateForDefaultTypeQualifiers");
        this.a = context2Var;
        this.f3323b = resolvers2Var;
        this.c = lazy;
        this.d = lazy;
        this.e = new JavaTypeResolver4(this, resolvers2Var);
    }

    public final context2 getComponents() {
        return this.a;
    }

    public final JavaTypeQualifiersByElementType getDefaultTypeQualifiers() {
        return (JavaTypeQualifiersByElementType) this.d.getValue();
    }

    public final Lazy<JavaTypeQualifiersByElementType> getDelegateForDefaultTypeQualifiers$descriptors_jvm() {
        return this.c;
    }

    public final ModuleDescriptor2 getModule() {
        return this.a.getModule();
    }

    public final StorageManager getStorageManager() {
        return this.a.getStorageManager();
    }

    public final resolvers2 getTypeParameterResolver() {
        return this.f3323b;
    }

    public final JavaTypeResolver4 getTypeResolver() {
        return this.e;
    }
}

package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.e.a.y;
import d0.e0.p.d.m0.m.o;
import d0.z.d.m;
import kotlin.Lazy;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f3323b;
    public final Lazy<y> c;
    public final Lazy d;
    public final d0.e0.p.d.m0.e.a.i0.m.d e;

    public g(b bVar, k kVar, Lazy<y> lazy) {
        m.checkNotNullParameter(bVar, "components");
        m.checkNotNullParameter(kVar, "typeParameterResolver");
        m.checkNotNullParameter(lazy, "delegateForDefaultTypeQualifiers");
        this.a = bVar;
        this.f3323b = kVar;
        this.c = lazy;
        this.d = lazy;
        this.e = new d0.e0.p.d.m0.e.a.i0.m.d(this, kVar);
    }

    public final b getComponents() {
        return this.a;
    }

    public final y getDefaultTypeQualifiers() {
        return (y) this.d.getValue();
    }

    public final Lazy<y> getDelegateForDefaultTypeQualifiers$descriptors_jvm() {
        return this.c;
    }

    public final c0 getModule() {
        return this.a.getModule();
    }

    public final o getStorageManager() {
        return this.a.getStorageManager();
    }

    public final k getTypeParameterResolver() {
        return this.f3323b;
    }

    public final d0.e0.p.d.m0.e.a.i0.m.d getTypeResolver() {
        return this.e;
    }
}

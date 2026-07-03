package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import kotlin.Lazy;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11631y;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.C11556d;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.g */
/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11529g {

    /* JADX INFO: renamed from: a */
    public final C11524b f23310a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11533k f23311b;

    /* JADX INFO: renamed from: c */
    public final Lazy<C11631y> f23312c;

    /* JADX INFO: renamed from: d */
    public final Lazy f23313d;

    /* JADX INFO: renamed from: e */
    public final C11556d f23314e;

    public C11529g(C11524b c11524b, InterfaceC11533k interfaceC11533k, Lazy<C11631y> lazy) {
        C12238m.checkNotNullParameter(c11524b, "components");
        C12238m.checkNotNullParameter(interfaceC11533k, "typeParameterResolver");
        C12238m.checkNotNullParameter(lazy, "delegateForDefaultTypeQualifiers");
        this.f23310a = c11524b;
        this.f23311b = interfaceC11533k;
        this.f23312c = lazy;
        this.f23313d = lazy;
        this.f23314e = new C11556d(this, interfaceC11533k);
    }

    public final C11524b getComponents() {
        return this.f23310a;
    }

    public final C11631y getDefaultTypeQualifiers() {
        return (C11631y) this.f23313d.getValue();
    }

    public final Lazy<C11631y> getDelegateForDefaultTypeQualifiers$descriptors_jvm() {
        return this.f23312c;
    }

    public final InterfaceC11325c0 getModule() {
        return this.f23310a.getModule();
    }

    public final InterfaceC11905o getStorageManager() {
        return this.f23310a.getStorageManager();
    }

    public final InterfaceC11533k getTypeParameterResolver() {
        return this.f23311b;
    }

    public final C11556d getTypeResolver() {
        return this.f23314e;
    }
}

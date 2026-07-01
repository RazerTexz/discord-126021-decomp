package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.c0;

/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$b {
    public final c0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3239b;

    public f$b(c0 c0Var, boolean z2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "ownerModuleDescriptor");
        this.a = c0Var;
        this.f3239b = z2;
    }

    public final c0 getOwnerModuleDescriptor() {
        return this.a;
    }

    public final boolean isAdditionalBuiltInsFeatureSupported() {
        return this.f3239b;
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.C11838b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.j */
/* JADX INFO: compiled from: ModuleClassResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11532j implements InterfaceC11531i {

    /* JADX INFO: renamed from: a */
    public C11838b f23320a;

    public final C11838b getResolver() {
        C11838b c11838b = this.f23320a;
        if (c11838b != null) {
            return c11838b;
        }
        C12238m.throwUninitializedPropertyAccessException("resolver");
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.InterfaceC11531i
    public InterfaceC11330e resolveClass(InterfaceC11574g interfaceC11574g) {
        C12238m.checkNotNullParameter(interfaceC11574g, "javaClass");
        return getResolver().resolveClass(interfaceC11574g);
    }

    public final void setResolver(C11838b c11838b) {
        C12238m.checkNotNullParameter(c11838b, "<set-?>");
        this.f23320a = c11838b;
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.C11542i;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.q */
/* JADX INFO: compiled from: KotlinJvmBinaryPackageSourceElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11656q implements InterfaceC11467u0 {

    /* JADX INFO: renamed from: b */
    public final C11542i f23631b;

    public C11656q(C11542i c11542i) {
        C12238m.checkNotNullParameter(c11542i, "packageFragment");
        this.f23631b = c11542i;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0
    public InterfaceC11469v0 getContainingFile() {
        InterfaceC11469v0 interfaceC11469v0 = InterfaceC11469v0.f23100a;
        C12238m.checkNotNullExpressionValue(interfaceC11469v0, "NO_SOURCE_FILE");
        return interfaceC11469v0;
    }

    public String toString() {
        return this.f23631b + ": " + this.f23631b.getBinaryClasses$descriptors_jvm().keySet();
    }
}

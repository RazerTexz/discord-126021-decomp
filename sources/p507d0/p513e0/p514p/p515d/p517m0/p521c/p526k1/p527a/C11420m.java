package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11435n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.InterfaceC11561a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.InterfaceC11562b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11579l;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.m */
/* JADX INFO: compiled from: RuntimeSourceElementFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11420m implements InterfaceC11562b {

    /* JADX INFO: renamed from: a */
    public static final C11420m f23025a = new C11420m();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.m$a */
    /* JADX INFO: compiled from: RuntimeSourceElementFactory.kt */
    public static final class a implements InterfaceC11561a {

        /* JADX INFO: renamed from: b */
        public final AbstractC11435n f23026b;

        public a(AbstractC11435n abstractC11435n) {
            C12238m.checkNotNullParameter(abstractC11435n, "javaElement");
            this.f23026b = abstractC11435n;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0
        public InterfaceC11469v0 getContainingFile() {
            InterfaceC11469v0 interfaceC11469v0 = InterfaceC11469v0.f23100a;
            C12238m.checkNotNullExpressionValue(interfaceC11469v0, "NO_SOURCE_FILE");
            return interfaceC11469v0;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.InterfaceC11561a
        public AbstractC11435n getJavaElement() {
            return this.f23026b;
        }

        public String toString() {
            return a.class.getName() + ": " + getJavaElement();
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.InterfaceC11562b
    public InterfaceC11561a source(InterfaceC11579l interfaceC11579l) {
        C12238m.checkNotNullParameter(interfaceC11579l, "javaElement");
        return new a((AbstractC11435n) interfaceC11579l);
    }
}

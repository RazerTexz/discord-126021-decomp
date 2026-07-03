package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11673f;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11882r;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.EnumC11860e;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11861f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.r */
/* JADX INFO: compiled from: KotlinJvmBinarySourceElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11657r implements InterfaceC11861f {

    /* JADX INFO: renamed from: b */
    public final InterfaceC11655p f23632b;

    public C11657r(InterfaceC11655p interfaceC11655p, C11882r<C11673f> c11882r, boolean z2, EnumC11860e enumC11860e) {
        C12238m.checkNotNullParameter(interfaceC11655p, "binaryClass");
        C12238m.checkNotNullParameter(enumC11860e, "abiStability");
        this.f23632b = interfaceC11655p;
    }

    public final InterfaceC11655p getBinaryClass() {
        return this.f23632b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0
    public InterfaceC11469v0 getContainingFile() {
        InterfaceC11469v0 interfaceC11469v0 = InterfaceC11469v0.f23100a;
        C12238m.checkNotNullExpressionValue(interfaceC11469v0, "NO_SOURCE_FILE");
        return interfaceC11469v0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11861f
    public String getPresentableString() {
        StringBuilder sbM833U = C1643a.m833U("Class '");
        sbM833U.append(this.f23632b.getClassId().asSingleFqName().asString());
        sbM833U.append('\'');
        return sbM833U.toString();
    }

    public String toString() {
        return ((Object) C11657r.class.getSimpleName()) + ": " + this.f23632b;
    }
}

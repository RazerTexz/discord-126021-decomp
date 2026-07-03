package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import java.util.Iterator;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.b */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11596b implements InterfaceC11344g {

    /* JADX INFO: renamed from: j */
    public final C11713b f23442j;

    public C11596b(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqNameToMatch");
        this.f23442j = c11713b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean hasAnnotation(C11713b c11713b) {
        return InterfaceC11344g.b.hasAnnotation(this, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<InterfaceC11340c> iterator() {
        return C12147n.emptyList().iterator();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public C11595a findAnnotation(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        if (C12238m.areEqual(c11713b, this.f23442j)) {
            return C11595a.f23441a;
        }
        return null;
    }
}

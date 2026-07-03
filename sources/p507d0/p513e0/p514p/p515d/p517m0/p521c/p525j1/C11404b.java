package p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11335f1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11332e1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.j1.b */
/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11404b extends AbstractC11335f1 {

    /* JADX INFO: renamed from: c */
    public static final C11404b f23007c = new C11404b();

    public C11404b() {
        super("protected_and_package", true);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11335f1
    public Integer compareTo(AbstractC11335f1 abstractC11335f1) {
        C12238m.checkNotNullParameter(abstractC11335f1, "visibility");
        if (C12238m.areEqual(this, abstractC11335f1)) {
            return 0;
        }
        if (abstractC11335f1 == C11332e1.b.f22697c) {
            return null;
        }
        return Integer.valueOf(C11332e1.f22694a.isPrivate(abstractC11335f1) ? 1 : -1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11335f1
    public String getInternalDisplayName() {
        return "protected/*protected and package*/";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11335f1
    public AbstractC11335f1 normalize() {
        return C11332e1.g.f22702c;
    }
}

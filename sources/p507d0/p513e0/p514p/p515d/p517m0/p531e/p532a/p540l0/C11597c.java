package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.c */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11597c<T> {

    /* JADX INFO: renamed from: a */
    public final T f23443a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11344g f23444b;

    public C11597c(T t, InterfaceC11344g interfaceC11344g) {
        this.f23443a = t;
        this.f23444b = interfaceC11344g;
    }

    public final T component1() {
        return this.f23443a;
    }

    public final InterfaceC11344g component2() {
        return this.f23444b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11597c)) {
            return false;
        }
        C11597c c11597c = (C11597c) obj;
        return C12238m.areEqual(this.f23443a, c11597c.f23443a) && C12238m.areEqual(this.f23444b, c11597c.f23444b);
    }

    public int hashCode() {
        T t = this.f23443a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        InterfaceC11344g interfaceC11344g = this.f23444b;
        return iHashCode + (interfaceC11344g != null ? interfaceC11344g.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EnhancementResult(result=");
        sbM833U.append(this.f23443a);
        sbM833U.append(", enhancementAnnotations=");
        sbM833U.append(this.f23444b);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}

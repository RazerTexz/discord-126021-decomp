package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.p.g */
/* JADX INFO: compiled from: TransientReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11783g extends AbstractC11777a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11783g(AbstractC11913c0 abstractC11913c0) {
        super(abstractC11913c0, null);
        if (abstractC11913c0 == null) {
            m9916a(0);
            throw null;
        }
        if (abstractC11913c0 != null) {
        } else {
            m9916a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9916a(int i) {
        Object[] objArr = new Object[3];
        if (i != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("{Transient} : ");
        sbM833U.append(getType());
        return sbM833U.toString();
    }
}

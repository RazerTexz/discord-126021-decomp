package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.p.a */
/* JADX INFO: compiled from: AbstractReceiverValue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11777a implements InterfaceC11780d {

    /* JADX INFO: renamed from: a */
    public final AbstractC11913c0 f24386a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11780d f24387b;

    public AbstractC11777a(AbstractC11913c0 abstractC11913c0, InterfaceC11780d interfaceC11780d) {
        if (abstractC11913c0 == null) {
            m9914a(0);
            throw null;
        }
        this.f24386a = abstractC11913c0;
        this.f24387b = interfaceC11780d == null ? this : interfaceC11780d;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9914a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i == 1) {
            objArr[1] = "getType";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 1 && i != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11780d
    public AbstractC11913c0 getType() {
        AbstractC11913c0 abstractC11913c0 = this.f24386a;
        if (abstractC11913c0 != null) {
            return abstractC11913c0;
        }
        m9914a(1);
        throw null;
    }
}

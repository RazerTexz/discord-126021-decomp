package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.c */
/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11764c {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.c$a */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class a extends AbstractC11764c {

        /* JADX INFO: renamed from: a */
        public static final a f24336a = new a();

        /* JADX INFO: renamed from: b */
        public static final int f24337b;

        static {
            C11765d.a aVar = C11765d.f24339a;
            f24337b = (~(aVar.getVARIABLES_MASK() | aVar.getFUNCTIONS_MASK())) & aVar.getALL_KINDS_MASK();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11764c
        public int getFullyExcludedDescriptorKinds() {
            return f24337b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.c$b */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class b extends AbstractC11764c {

        /* JADX INFO: renamed from: a */
        public static final b f24338a = new b();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11764c
        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }
    }

    public abstract int getFullyExcludedDescriptorKinds();

    public String toString() {
        return getClass().getSimpleName();
    }
}

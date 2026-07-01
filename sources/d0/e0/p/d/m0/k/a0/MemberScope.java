package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.k.a0.MemberScope2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.c, reason: use source file name */
/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MemberScope {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.c$a */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class a extends MemberScope {
        public static final a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f3452b;

        static {
            MemberScope2.a aVar = MemberScope2.a;
            f3452b = (~(aVar.getVARIABLES_MASK() | aVar.getFUNCTIONS_MASK())) & aVar.getALL_KINDS_MASK();
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope
        public int getFullyExcludedDescriptorKinds() {
            return f3452b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.c$b */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class b extends MemberScope {
        public static final b a = new b();

        @Override // d0.e0.p.d.m0.k.a0.MemberScope
        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }
    }

    public abstract int getFullyExcludedDescriptorKinds();

    public String toString() {
        return getClass().getSimpleName();
    }
}

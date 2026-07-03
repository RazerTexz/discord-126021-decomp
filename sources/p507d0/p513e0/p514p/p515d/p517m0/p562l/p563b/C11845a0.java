package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11685j;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11699x;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a0 */
/* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11845a0 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a0$a */
    /* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f24495a;

        /* JADX INFO: renamed from: b */
        public static final /* synthetic */ int[] f24496b;

        static {
            EnumC11685j.values();
            f24495a = new int[]{1, 2, 3, 4};
            InterfaceC11321b.a.values();
            EnumC11699x.values();
            f24496b = new int[]{1, 2, 4, 5, 3, 6};
        }
    }

    public static final AbstractC11466u descriptorVisibility(C11890z c11890z, EnumC11699x enumC11699x) {
        C12238m.checkNotNullParameter(c11890z, "<this>");
        switch (enumC11699x == null ? -1 : a.f24496b[enumC11699x.ordinal()]) {
            case 1:
                AbstractC11466u abstractC11466u = C11464t.f23086d;
                C12238m.checkNotNullExpressionValue(abstractC11466u, "INTERNAL");
                return abstractC11466u;
            case 2:
                AbstractC11466u abstractC11466u2 = C11464t.f23083a;
                C12238m.checkNotNullExpressionValue(abstractC11466u2, "PRIVATE");
                return abstractC11466u2;
            case 3:
                AbstractC11466u abstractC11466u3 = C11464t.f23084b;
                C12238m.checkNotNullExpressionValue(abstractC11466u3, "PRIVATE_TO_THIS");
                return abstractC11466u3;
            case 4:
                AbstractC11466u abstractC11466u4 = C11464t.f23085c;
                C12238m.checkNotNullExpressionValue(abstractC11466u4, "PROTECTED");
                return abstractC11466u4;
            case 5:
                AbstractC11466u abstractC11466u5 = C11464t.f23087e;
                C12238m.checkNotNullExpressionValue(abstractC11466u5, "PUBLIC");
                return abstractC11466u5;
            case 6:
                AbstractC11466u abstractC11466u6 = C11464t.f23088f;
                C12238m.checkNotNullExpressionValue(abstractC11466u6, "LOCAL");
                return abstractC11466u6;
            default:
                AbstractC11466u abstractC11466u7 = C11464t.f23083a;
                C12238m.checkNotNullExpressionValue(abstractC11466u7, "PRIVATE");
                return abstractC11466u7;
        }
    }

    public static final InterfaceC11321b.a memberKind(C11890z c11890z, EnumC11685j enumC11685j) {
        InterfaceC11321b.a aVar = InterfaceC11321b.a.DECLARATION;
        C12238m.checkNotNullParameter(c11890z, "<this>");
        int i = enumC11685j == null ? -1 : a.f24495a[enumC11685j.ordinal()];
        if (i == 1) {
            return aVar;
        }
        if (i == 2) {
            return InterfaceC11321b.a.FAKE_OVERRIDE;
        }
        if (i != 3) {
            return i != 4 ? aVar : InterfaceC11321b.a.SYNTHESIZED;
        }
        return InterfaceC11321b.a.DELEGATION;
    }
}

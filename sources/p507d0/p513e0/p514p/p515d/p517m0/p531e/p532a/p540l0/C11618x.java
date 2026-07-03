package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11304d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.C11348k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11486a0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11956p;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.x */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11618x {

    /* JADX INFO: renamed from: a */
    public static final C11596b f23508a;

    /* JADX INFO: renamed from: b */
    public static final C11596b f23509b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.x$a */
    /* JADX INFO: compiled from: typeEnhancement.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f23510a;

        /* JADX INFO: renamed from: b */
        public static final /* synthetic */ int[] f23511b;

        static {
            EnumC11600f.valuesCustom();
            f23510a = new int[]{1, 2};
            EnumC11602h.valuesCustom();
            f23511b = new int[]{1, 2, 0};
        }
    }

    static {
        C11713b c11713b = C11486a0.f23161o;
        C12238m.checkNotNullExpressionValue(c11713b, "ENHANCED_NULLABILITY_ANNOTATION");
        f23508a = new C11596b(c11713b);
        C11713b c11713b2 = C11486a0.f23162p;
        C12238m.checkNotNullExpressionValue(c11713b2, "ENHANCED_MUTABILITY_ANNOTATION");
        f23509b = new C11596b(c11713b2);
    }

    /* JADX INFO: renamed from: a */
    public static final <T> C11597c<T> m9516a(T t) {
        return new C11597c<>(t, null);
    }

    public static final InterfaceC11344g access$compositeAnnotationsOrSingle(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? new C11348k((List<? extends InterfaceC11344g>) C12163u.toList(list)) : (InterfaceC11344g) C12163u.single(list);
        }
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    public static final C11597c access$enhanceMutability(InterfaceC11352h interfaceC11352h, C11599e c11599e, EnumC11614t enumC11614t) {
        C11597c c11597c;
        if (C11615u.shouldEnhance(enumC11614t) && (interfaceC11352h instanceof InterfaceC11330e)) {
            C11304d c11304d = C11304d.f22630a;
            EnumC11600f mutability = c11599e.getMutability();
            int i = mutability == null ? -1 : a.f23510a[mutability.ordinal()];
            if (i == 1) {
                if (enumC11614t == EnumC11614t.FLEXIBLE_LOWER) {
                    InterfaceC11330e interfaceC11330e = (InterfaceC11330e) interfaceC11352h;
                    if (c11304d.isMutable(interfaceC11330e)) {
                        c11597c = new C11597c(c11304d.convertMutableToReadOnly(interfaceC11330e), f23509b);
                        return c11597c;
                    }
                }
                return m9516a(interfaceC11352h);
            }
            if (i == 2 && enumC11614t == EnumC11614t.FLEXIBLE_UPPER) {
                InterfaceC11330e interfaceC11330e2 = (InterfaceC11330e) interfaceC11352h;
                if (c11304d.isReadOnly(interfaceC11330e2)) {
                    c11597c = new C11597c(c11304d.convertReadOnlyToMutable(interfaceC11330e2), f23509b);
                    return c11597c;
                }
            }
            return m9516a(interfaceC11352h);
        }
        return m9516a(interfaceC11352h);
    }

    public static final C11597c access$getEnhancedNullability(AbstractC11913c0 abstractC11913c0, C11599e c11599e, EnumC11614t enumC11614t) {
        C11597c c11597c;
        if (!C11615u.shouldEnhance(enumC11614t)) {
            return m9516a(Boolean.valueOf(abstractC11913c0.isMarkedNullable()));
        }
        EnumC11602h nullability = c11599e.getNullability();
        int i = nullability == null ? -1 : a.f23511b[nullability.ordinal()];
        if (i == 1) {
            c11597c = new C11597c(Boolean.TRUE, f23508a);
        } else {
            if (i != 2) {
                return m9516a(Boolean.valueOf(abstractC11913c0.isMarkedNullable()));
            }
            c11597c = new C11597c(Boolean.FALSE, f23508a);
        }
        return c11597c;
    }

    public static final boolean hasEnhancedNullability(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return C11616v.hasEnhancedNullability(C11956p.f24827a, abstractC11913c0);
    }
}

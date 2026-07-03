package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import com.adjust.sdk.Constants;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11486a0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p580t.C12150o0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.v */
/* JADX INFO: compiled from: typeEnchancementUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11616v {
    public static final C11599e createJavaTypeQualifiers(EnumC11602h enumC11602h, EnumC11600f enumC11600f, boolean z2, boolean z3) {
        return (z3 && enumC11602h == EnumC11602h.NOT_NULL) ? new C11599e(enumC11602h, enumC11600f, true, z2) : new C11599e(enumC11602h, enumC11600f, false, z2);
    }

    public static final boolean hasEnhancedNullability(InterfaceC11917d1 interfaceC11917d1, InterfaceC11979h interfaceC11979h) {
        C12238m.checkNotNullParameter(interfaceC11917d1, "<this>");
        C12238m.checkNotNullParameter(interfaceC11979h, "type");
        C11713b c11713b = C11486a0.f23161o;
        C12238m.checkNotNullExpressionValue(c11713b, "ENHANCED_NULLABILITY_ANNOTATION");
        return interfaceC11917d1.hasAnnotation(interfaceC11979h, c11713b);
    }

    public static final <T> T select(Set<? extends T> set, T t, T t2, T t3, boolean z2) {
        Set<? extends T> set2;
        T t4;
        C12238m.checkNotNullParameter(set, "<this>");
        C12238m.checkNotNullParameter(t, Constants.LOW);
        C12238m.checkNotNullParameter(t2, Constants.HIGH);
        if (!z2) {
            if (t3 != null && (set2 = C12163u.toSet(C12150o0.plus(set, t3))) != null) {
                set = set2;
            }
            return (T) C12163u.singleOrNull(set);
        }
        if (set.contains(t)) {
            t4 = t;
        } else {
            t4 = set.contains(t2) ? t2 : null;
        }
        if (C12238m.areEqual(t4, t) && C12238m.areEqual(t3, t2)) {
            return null;
        }
        return t3 == null ? t4 : t3;
    }

    public static final EnumC11602h select(Set<? extends EnumC11602h> set, EnumC11602h enumC11602h, boolean z2) {
        C12238m.checkNotNullParameter(set, "<this>");
        EnumC11602h enumC11602h2 = EnumC11602h.FORCE_FLEXIBILITY;
        return enumC11602h == enumC11602h2 ? enumC11602h2 : (EnumC11602h) select(set, EnumC11602h.NOT_NULL, EnumC11602h.NULLABLE, enumC11602h, z2);
    }
}

package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.n.u0;
import java.util.Map;

/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class k$e extends d0.e0.p.d.m0.n.l1.a {
    public final Map<u0, u0> j;
    public final /* synthetic */ k k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$e(k kVar, Map<u0, u0> map) {
        super(true, true, true, kVar.d);
        this.k = kVar;
        this.j = map;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1 || i == 3) {
            objArr[0] = "b";
        } else {
            objArr[0] = "a";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverridingUtilTypeCheckerContext";
        if (i == 2 || i == 3) {
            objArr[2] = "areEqualTypeConstructorsByAxioms";
        } else {
            objArr[2] = "areEqualTypeConstructors";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003f  */
    @Override // d0.e0.p.d.m0.n.l1.a
    public boolean areEqualTypeConstructors(u0 u0Var, u0 u0Var2) {
        boolean z2;
        if (u0Var == null) {
            a(0);
            throw null;
        }
        if (u0Var2 == null) {
            a(1);
            throw null;
        }
        if (!super.areEqualTypeConstructors(u0Var, u0Var2)) {
            if (u0Var == null) {
                a(2);
                throw null;
            }
            if (u0Var2 == null) {
                a(3);
                throw null;
            }
            if (this.k.e.equals(u0Var, u0Var2)) {
                z2 = true;
            } else {
                Map<u0, u0> map = this.j;
                if (map != null) {
                    u0 u0Var3 = map.get(u0Var);
                    u0 u0Var4 = this.j.get(u0Var2);
                    if ((u0Var3 != null && u0Var3.equals(u0Var2)) || (u0Var4 != null && u0Var4.equals(u0Var))) {
                        z2 = true;
                    }
                }
                z2 = false;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }
}

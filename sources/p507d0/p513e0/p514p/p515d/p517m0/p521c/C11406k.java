package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11295o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k */
/* JADX INFO: compiled from: ConstUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11406k {
    /* JADX WARN: Code duplicated, block: B:11:0x0020 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x0013  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    public static final boolean canBeUsedForConstVal(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        if (!AbstractC11288h.isPrimitiveType(abstractC11913c0)) {
            C11295o c11295o = C11295o.f22584a;
            if (C11295o.isUnsignedType(abstractC11913c0)) {
                if (C11920e1.isNullableType(abstractC11913c0)) {
                    if (!AbstractC11288h.isString(abstractC11913c0)) {
                        return false;
                    }
                }
            } else if (!AbstractC11288h.isString(abstractC11913c0)) {
                return false;
            }
        } else if (C11920e1.isNullableType(abstractC11913c0)) {
            if (!AbstractC11288h.isString(abstractC11913c0)) {
                return false;
            }
        }
        return true;
    }
}

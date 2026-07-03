package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.z */
/* JADX INFO: compiled from: Modality.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11476z {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;


    /* JADX INFO: renamed from: j */
    public static final a f23104j = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.z$a */
    /* JADX INFO: compiled from: Modality.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final EnumC11476z convertFromFlags(boolean z2, boolean z3, boolean z4) {
            if (z2) {
                return EnumC11476z.SEALED;
            }
            if (z3) {
                return EnumC11476z.ABSTRACT;
            }
            return z4 ? EnumC11476z.OPEN : EnumC11476z.FINAL;
        }
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11476z[] valuesCustom() {
        EnumC11476z[] enumC11476zArrValuesCustom = values();
        EnumC11476z[] enumC11476zArr = new EnumC11476z[enumC11476zArrValuesCustom.length];
        System.arraycopy(enumC11476zArrValuesCustom, 0, enumC11476zArr, 0, enumC11476zArrValuesCustom.length);
        return enumC11476zArr;
    }
}

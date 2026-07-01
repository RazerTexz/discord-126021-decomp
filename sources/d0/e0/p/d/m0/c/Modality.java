package d0.e0.p.d.m0.c;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.z, reason: use source file name */
/* JADX INFO: compiled from: Modality.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;

    public static final a j = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.z$a */
    /* JADX INFO: compiled from: Modality.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Modality convertFromFlags(boolean z2, boolean z3, boolean z4) {
            if (z2) {
                return Modality.SEALED;
            }
            if (z3) {
                return Modality.ABSTRACT;
            }
            return z4 ? Modality.OPEN : Modality.FINAL;
        }
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static Modality[] valuesCustom() {
        Modality[] modalityArrValuesCustom = values();
        Modality[] modalityArr = new Modality[modalityArrValuesCustom.length];
        System.arraycopy(modalityArrValuesCustom, 0, modalityArr, 0, modalityArrValuesCustom.length);
        return modalityArr;
    }
}

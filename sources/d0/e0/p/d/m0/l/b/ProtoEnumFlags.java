package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.n.Variance;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.z, reason: use source file name */
/* JADX INFO: compiled from: ProtoEnumFlags.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ProtoEnumFlags {
    public static final ProtoEnumFlags a = new ProtoEnumFlags();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.z$a */
    /* JADX INFO: compiled from: ProtoEnumFlags.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3511b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;

        static {
            d0.e0.p.d.m0.f.k.values();
            a = new int[]{1, 2, 3, 4};
            Modality.valuesCustom();
            Modality modality = Modality.FINAL;
            Modality modality2 = Modality.OPEN;
            Modality modality3 = Modality.ABSTRACT;
            Modality modality4 = Modality.SEALED;
            d0.e0.p.d.m0.f.x.values();
            c.EnumC0397c.values();
            f3511b = new int[]{1, 2, 3, 4, 5, 6, 7};
            ClassKind.values();
            s.c.values();
            c = new int[]{1, 2, 3};
            q.b.c.values();
            d = new int[]{1, 2, 3, 4};
            Variance.valuesCustom();
        }
    }

    public final ClassKind classKind(c.EnumC0397c enumC0397c) {
        ClassKind classKind = ClassKind.CLASS;
        switch (enumC0397c == null ? -1 : a.f3511b[enumC0397c.ordinal()]) {
            case 1:
            default:
                return classKind;
            case 2:
                return ClassKind.INTERFACE;
            case 3:
                return ClassKind.ENUM_CLASS;
            case 4:
                return ClassKind.ENUM_ENTRY;
            case 5:
                return ClassKind.ANNOTATION_CLASS;
            case 6:
            case 7:
                return ClassKind.OBJECT;
        }
    }

    public final Modality modality(d0.e0.p.d.m0.f.k kVar) {
        int i = kVar == null ? -1 : a.a[kVar.ordinal()];
        if (i == 1) {
            return Modality.FINAL;
        }
        if (i == 2) {
            return Modality.OPEN;
        }
        if (i != 3) {
            return i != 4 ? Modality.FINAL : Modality.SEALED;
        }
        return Modality.ABSTRACT;
    }

    public final Variance variance(s.c cVar) {
        Intrinsics3.checkNotNullParameter(cVar, "variance");
        int iOrdinal = cVar.ordinal();
        if (iOrdinal == 0) {
            return Variance.IN_VARIANCE;
        }
        if (iOrdinal == 1) {
            return Variance.OUT_VARIANCE;
        }
        if (iOrdinal == 2) {
            return Variance.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Variance variance(q.b.c cVar) {
        Intrinsics3.checkNotNullParameter(cVar, "projection");
        int iOrdinal = cVar.ordinal();
        if (iOrdinal == 0) {
            return Variance.IN_VARIANCE;
        }
        if (iOrdinal == 1) {
            return Variance.OUT_VARIANCE;
        }
        if (iOrdinal == 2) {
            return Variance.INVARIANT;
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException(Intrinsics3.stringPlus("Only IN, OUT and INV are supported. Actual argument: ", cVar));
    }
}

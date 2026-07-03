package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import kotlin.NoWhenBranchMatchedException;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11686k;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11699x;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.z */
/* JADX INFO: compiled from: ProtoEnumFlags.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11890z {

    /* JADX INFO: renamed from: a */
    public static final C11890z f24700a = new C11890z();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.z$a */
    /* JADX INFO: compiled from: ProtoEnumFlags.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f24701a;

        /* JADX INFO: renamed from: b */
        public static final /* synthetic */ int[] f24702b;

        /* JADX INFO: renamed from: c */
        public static final /* synthetic */ int[] f24703c;

        /* JADX INFO: renamed from: d */
        public static final /* synthetic */ int[] f24704d;

        static {
            EnumC11686k.values();
            f24701a = new int[]{1, 2, 3, 4};
            EnumC11476z.valuesCustom();
            EnumC11476z enumC11476z = EnumC11476z.FINAL;
            EnumC11476z enumC11476z2 = EnumC11476z.OPEN;
            EnumC11476z enumC11476z3 = EnumC11476z.ABSTRACT;
            EnumC11476z enumC11476z4 = EnumC11476z.SEALED;
            EnumC11699x.values();
            C11678c.c.values();
            f24702b = new int[]{1, 2, 3, 4, 5, 6, 7};
            EnumC11333f.values();
            C11694s.c.values();
            f24703c = new int[]{1, 2, 3};
            C11692q.b.c.values();
            f24704d = new int[]{1, 2, 3, 4};
            EnumC11935j1.valuesCustom();
        }
    }

    public final EnumC11333f classKind(C11678c.c cVar) {
        EnumC11333f enumC11333f = EnumC11333f.CLASS;
        switch (cVar == null ? -1 : a.f24702b[cVar.ordinal()]) {
            case 1:
            default:
                return enumC11333f;
            case 2:
                return EnumC11333f.INTERFACE;
            case 3:
                return EnumC11333f.ENUM_CLASS;
            case 4:
                return EnumC11333f.ENUM_ENTRY;
            case 5:
                return EnumC11333f.ANNOTATION_CLASS;
            case 6:
            case 7:
                return EnumC11333f.OBJECT;
        }
    }

    public final EnumC11476z modality(EnumC11686k enumC11686k) {
        int i = enumC11686k == null ? -1 : a.f24701a[enumC11686k.ordinal()];
        if (i == 1) {
            return EnumC11476z.FINAL;
        }
        if (i == 2) {
            return EnumC11476z.OPEN;
        }
        if (i != 3) {
            return i != 4 ? EnumC11476z.FINAL : EnumC11476z.SEALED;
        }
        return EnumC11476z.ABSTRACT;
    }

    public final EnumC11935j1 variance(C11694s.c cVar) {
        C12238m.checkNotNullParameter(cVar, "variance");
        int iOrdinal = cVar.ordinal();
        if (iOrdinal == 0) {
            return EnumC11935j1.IN_VARIANCE;
        }
        if (iOrdinal == 1) {
            return EnumC11935j1.OUT_VARIANCE;
        }
        if (iOrdinal == 2) {
            return EnumC11935j1.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final EnumC11935j1 variance(C11692q.b.c cVar) {
        C12238m.checkNotNullParameter(cVar, "projection");
        int iOrdinal = cVar.ordinal();
        if (iOrdinal == 0) {
            return EnumC11935j1.IN_VARIANCE;
        }
        if (iOrdinal == 1) {
            return EnumC11935j1.OUT_VARIANCE;
        }
        if (iOrdinal == 2) {
            return EnumC11935j1.INVARIANT;
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException(C12238m.stringPlus("Only IN, OUT and INV are supported. Actual argument: ", cVar));
    }
}

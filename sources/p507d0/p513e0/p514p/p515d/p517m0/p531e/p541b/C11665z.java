package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.z */
/* JADX INFO: compiled from: TypeMappingMode.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11665z {

    /* JADX INFO: renamed from: a */
    public static final C11665z f23638a;

    /* JADX INFO: renamed from: b */
    public static final C11665z f23639b;

    /* JADX INFO: renamed from: c */
    public static final C11665z f23640c;

    /* JADX INFO: renamed from: d */
    public final boolean f23641d;

    /* JADX INFO: renamed from: e */
    public final boolean f23642e;

    /* JADX INFO: renamed from: f */
    public final boolean f23643f;

    /* JADX INFO: renamed from: g */
    public final boolean f23644g;

    /* JADX INFO: renamed from: h */
    public final boolean f23645h;

    /* JADX INFO: renamed from: i */
    public final C11665z f23646i;

    /* JADX INFO: renamed from: j */
    public final boolean f23647j;

    /* JADX INFO: renamed from: k */
    public final C11665z f23648k;

    /* JADX INFO: renamed from: l */
    public final C11665z f23649l;

    /* JADX INFO: renamed from: m */
    public final boolean f23650m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.z$a */
    /* JADX INFO: compiled from: TypeMappingMode.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        C11665z c11665z = null;
        boolean z6 = false;
        C11665z c11665z2 = null;
        C11665z c11665z3 = null;
        boolean z7 = false;
        DefaultConstructorMarker defaultConstructorMarker = null;
        C11665z c11665z4 = new C11665z(z2, false, z3, z4, z5, c11665z, z6, c11665z2, c11665z3, z7, AudioAttributesCompat.FLAG_ALL, defaultConstructorMarker);
        f23638a = c11665z4;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        C11665z c11665z5 = null;
        C11665z c11665z6 = null;
        boolean z14 = true;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        C11665z c11665z7 = new C11665z(z8, z9, z10, z11, z12, null, z13, c11665z5, c11665z6, z14, FrameMetricsAggregator.EVERY_DURATION, defaultConstructorMarker2);
        f23639b = c11665z7;
        new C11665z(z2, true, z3, z4, z5, c11665z, z6, c11665z2, c11665z3, z7, PointerIconCompat.TYPE_GRABBING, defaultConstructorMarker);
        int i = 988;
        f23640c = new C11665z(z2, false, z3, z4, z5, c11665z4, z6, c11665z2, c11665z3, z7, i, defaultConstructorMarker);
        new C11665z(z8, z9, z10, z11, z12, c11665z7, z13, c11665z5, c11665z6, z14, 476, defaultConstructorMarker2);
        new C11665z(z2, true, z3, z4, z5, c11665z4, z6, c11665z2, c11665z3, z7, i, defaultConstructorMarker);
        boolean z15 = false;
        boolean z16 = true;
        new C11665z(z2, z15, z3, z16, z5, c11665z4, z6, c11665z2, c11665z3, z7, 983, defaultConstructorMarker);
        new C11665z(z2, z15, z3, z16, z5, c11665z4, z6, c11665z2, c11665z3, z7, 919, defaultConstructorMarker);
        new C11665z(z2, z15, true, false, z5, c11665z4, z6, c11665z2, c11665z3, z7, 984, defaultConstructorMarker);
    }

    public C11665z(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, C11665z c11665z, boolean z7, C11665z c11665z2, C11665z c11665z3, boolean z8) {
        this.f23641d = z2;
        this.f23642e = z3;
        this.f23643f = z4;
        this.f23644g = z5;
        this.f23645h = z6;
        this.f23646i = c11665z;
        this.f23647j = z7;
        this.f23648k = c11665z2;
        this.f23649l = c11665z3;
        this.f23650m = z8;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.f23647j;
    }

    public final boolean getMapTypeAliases() {
        return this.f23650m;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.f23642e;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.f23641d;
    }

    public final boolean isForAnnotationParameter() {
        return this.f23643f;
    }

    public final C11665z toGenericArgumentMode(EnumC11935j1 enumC11935j1, boolean z2) {
        C12238m.checkNotNullParameter(enumC11935j1, "effectiveVariance");
        if (!z2 || !this.f23643f) {
            int iOrdinal = enumC11935j1.ordinal();
            if (iOrdinal == 0) {
                C11665z c11665z = this.f23649l;
                if (c11665z != null) {
                    return c11665z;
                }
            } else if (iOrdinal != 1) {
                C11665z c11665z2 = this.f23646i;
                if (c11665z2 != null) {
                    return c11665z2;
                }
            } else {
                C11665z c11665z3 = this.f23648k;
                if (c11665z3 != null) {
                    return c11665z3;
                }
            }
        }
        return this;
    }

    public final C11665z wrapInlineClassesMode() {
        return new C11665z(this.f23641d, true, this.f23643f, this.f23644g, this.f23645h, this.f23646i, this.f23647j, this.f23648k, this.f23649l, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C11665z(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, C11665z c11665z, boolean z7, C11665z c11665z2, C11665z c11665z3, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z9 = (i & 1) != 0 ? true : z2;
        boolean z10 = (i & 2) != 0 ? true : z3;
        boolean z11 = (i & 4) != 0 ? false : z4;
        boolean z12 = (i & 8) != 0 ? false : z5;
        boolean z13 = (i & 16) != 0 ? false : z6;
        C11665z c11665z4 = (i & 32) != 0 ? null : c11665z;
        this(z9, z10, z11, z12, z13, c11665z4, (i & 64) == 0 ? z7 : true, (i & 128) != 0 ? c11665z4 : c11665z2, (i & 256) != 0 ? c11665z4 : c11665z3, (i & 512) == 0 ? z8 : false);
    }
}

package d0.e0.p.d.m0.e.b;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import d0.e0.p.d.m0.n.Variance;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.z, reason: use source file name */
/* JADX INFO: compiled from: TypeMappingMode.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeMappingMode {
    public static final TypeMappingMode a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TypeMappingMode f3383b;
    public static final TypeMappingMode c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final TypeMappingMode i;
    public final boolean j;
    public final TypeMappingMode k;
    public final TypeMappingMode l;
    public final boolean m;

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
        TypeMappingMode typeMappingMode = null;
        boolean z6 = false;
        TypeMappingMode typeMappingMode2 = null;
        TypeMappingMode typeMappingMode3 = null;
        boolean z7 = false;
        DefaultConstructorMarker defaultConstructorMarker = null;
        TypeMappingMode typeMappingMode4 = new TypeMappingMode(z2, false, z3, z4, z5, typeMappingMode, z6, typeMappingMode2, typeMappingMode3, z7, AudioAttributesCompat.FLAG_ALL, defaultConstructorMarker);
        a = typeMappingMode4;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        TypeMappingMode typeMappingMode5 = null;
        TypeMappingMode typeMappingMode6 = null;
        boolean z14 = true;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        TypeMappingMode typeMappingMode7 = new TypeMappingMode(z8, z9, z10, z11, z12, null, z13, typeMappingMode5, typeMappingMode6, z14, FrameMetricsAggregator.EVERY_DURATION, defaultConstructorMarker2);
        f3383b = typeMappingMode7;
        new TypeMappingMode(z2, true, z3, z4, z5, typeMappingMode, z6, typeMappingMode2, typeMappingMode3, z7, PointerIconCompat.TYPE_GRABBING, defaultConstructorMarker);
        int i = 988;
        c = new TypeMappingMode(z2, false, z3, z4, z5, typeMappingMode4, z6, typeMappingMode2, typeMappingMode3, z7, i, defaultConstructorMarker);
        new TypeMappingMode(z8, z9, z10, z11, z12, typeMappingMode7, z13, typeMappingMode5, typeMappingMode6, z14, 476, defaultConstructorMarker2);
        new TypeMappingMode(z2, true, z3, z4, z5, typeMappingMode4, z6, typeMappingMode2, typeMappingMode3, z7, i, defaultConstructorMarker);
        boolean z15 = false;
        boolean z16 = true;
        new TypeMappingMode(z2, z15, z3, z16, z5, typeMappingMode4, z6, typeMappingMode2, typeMappingMode3, z7, 983, defaultConstructorMarker);
        new TypeMappingMode(z2, z15, z3, z16, z5, typeMappingMode4, z6, typeMappingMode2, typeMappingMode3, z7, 919, defaultConstructorMarker);
        new TypeMappingMode(z2, z15, true, false, z5, typeMappingMode4, z6, typeMappingMode2, typeMappingMode3, z7, 984, defaultConstructorMarker);
    }

    public TypeMappingMode(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, TypeMappingMode typeMappingMode, boolean z7, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z8) {
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = z6;
        this.i = typeMappingMode;
        this.j = z7;
        this.k = typeMappingMode2;
        this.l = typeMappingMode3;
        this.m = z8;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.j;
    }

    public final boolean getMapTypeAliases() {
        return this.m;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.e;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.d;
    }

    public final boolean isForAnnotationParameter() {
        return this.f;
    }

    public final TypeMappingMode toGenericArgumentMode(Variance variance, boolean z2) {
        Intrinsics3.checkNotNullParameter(variance, "effectiveVariance");
        if (!z2 || !this.f) {
            int iOrdinal = variance.ordinal();
            if (iOrdinal == 0) {
                TypeMappingMode typeMappingMode = this.l;
                if (typeMappingMode != null) {
                    return typeMappingMode;
                }
            } else if (iOrdinal != 1) {
                TypeMappingMode typeMappingMode2 = this.i;
                if (typeMappingMode2 != null) {
                    return typeMappingMode2;
                }
            } else {
                TypeMappingMode typeMappingMode3 = this.k;
                if (typeMappingMode3 != null) {
                    return typeMappingMode3;
                }
            }
        }
        return this;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.d, true, this.f, this.g, this.h, this.i, this.j, this.k, this.l, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TypeMappingMode(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, TypeMappingMode typeMappingMode, boolean z7, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z9 = (i & 1) != 0 ? true : z2;
        boolean z10 = (i & 2) != 0 ? true : z3;
        boolean z11 = (i & 4) != 0 ? false : z4;
        boolean z12 = (i & 8) != 0 ? false : z5;
        boolean z13 = (i & 16) != 0 ? false : z6;
        TypeMappingMode typeMappingMode4 = (i & 32) != 0 ? null : typeMappingMode;
        this(z9, z10, z11, z12, z13, typeMappingMode4, (i & 64) == 0 ? z7 : true, (i & 128) != 0 ? typeMappingMode4 : typeMappingMode2, (i & 256) != 0 ? typeMappingMode4 : typeMappingMode3, (i & 512) == 0 ? z8 : false);
    }
}

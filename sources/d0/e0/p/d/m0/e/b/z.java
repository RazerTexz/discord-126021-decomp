package d0.e0.p.d.m0.e.b;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import d0.e0.p.d.m0.n.j1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypeMappingMode.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public static final z a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f3383b;
    public static final z c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final z i;
    public final boolean j;
    public final z k;
    public final z l;
    public final boolean m;

    static {
        new z$a(null);
        z zVar = new z(false, false, false, false, false, null, false, null, null, false, AudioAttributesCompat.FLAG_ALL, null);
        a = zVar;
        z zVar2 = new z(false, false, false, false, false, null, false, null, null, true, FrameMetricsAggregator.EVERY_DURATION, null);
        f3383b = zVar2;
        new z(false, true, false, false, false, null, false, null, null, false, PointerIconCompat.TYPE_GRABBING, null);
        c = new z(false, false, false, false, false, zVar, false, null, null, false, 988, null);
        new z(false, false, false, false, false, zVar2, false, null, null, true, 476, null);
        new z(false, true, false, false, false, zVar, false, null, null, false, 988, null);
        new z(false, false, false, true, false, zVar, false, null, null, false, 983, null);
        new z(false, false, false, true, false, zVar, false, null, null, false, 919, null);
        new z(false, false, true, false, false, zVar, false, null, null, false, 984, null);
    }

    public z(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, z zVar, boolean z7, z zVar2, z zVar3, boolean z8) {
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = z6;
        this.i = zVar;
        this.j = z7;
        this.k = zVar2;
        this.l = zVar3;
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

    public final z toGenericArgumentMode(j1 j1Var, boolean z2) {
        d0.z.d.m.checkNotNullParameter(j1Var, "effectiveVariance");
        if (!z2 || !this.f) {
            int iOrdinal = j1Var.ordinal();
            if (iOrdinal == 0) {
                z zVar = this.l;
                if (zVar != null) {
                    return zVar;
                }
            } else if (iOrdinal != 1) {
                z zVar2 = this.i;
                if (zVar2 != null) {
                    return zVar2;
                }
            } else {
                z zVar3 = this.k;
                if (zVar3 != null) {
                    return zVar3;
                }
            }
        }
        return this;
    }

    public final z wrapInlineClassesMode() {
        return new z(this.d, true, this.f, this.g, this.h, this.i, this.j, this.k, this.l, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ z(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, z zVar, boolean z7, z zVar2, z zVar3, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z9 = (i & 1) != 0 ? true : z2;
        boolean z10 = (i & 2) != 0 ? true : z3;
        boolean z11 = (i & 4) != 0 ? false : z4;
        boolean z12 = (i & 8) != 0 ? false : z5;
        boolean z13 = (i & 16) != 0 ? false : z6;
        z zVar4 = (i & 32) != 0 ? null : zVar;
        this(z9, z10, z11, z12, z13, zVar4, (i & 64) == 0 ? z7 : true, (i & 128) != 0 ? zVar4 : zVar2, (i & 256) != 0 ? zVar4 : zVar3, (i & 512) == 0 ? z8 : false);
    }
}

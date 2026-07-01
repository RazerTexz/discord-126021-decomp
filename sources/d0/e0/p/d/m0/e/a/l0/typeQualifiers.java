package d0.e0.p.d.m0.e.a.l0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.e, reason: use source file name */
/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeQualifiers {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final typeQualifiers f3344b = new typeQualifiers(null, null, false, false, 8, null);
    public final typeQualifiers3 c;
    public final typeQualifiers2 d;
    public final boolean e;
    public final boolean f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.e$a */
    /* JADX INFO: compiled from: typeQualifiers.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final typeQualifiers getNONE() {
            return typeQualifiers.f3344b;
        }
    }

    public typeQualifiers(typeQualifiers3 typequalifiers3, typeQualifiers2 typequalifiers2, boolean z2, boolean z3) {
        this.c = typequalifiers3;
        this.d = typequalifiers2;
        this.e = z2;
        this.f = z3;
    }

    public final typeQualifiers2 getMutability() {
        return this.d;
    }

    public final typeQualifiers3 getNullability() {
        return this.c;
    }

    public final boolean isNotNullTypeParameter() {
        return this.e;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.f;
    }

    public /* synthetic */ typeQualifiers(typeQualifiers3 typequalifiers3, typeQualifiers2 typequalifiers2, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typequalifiers3, typequalifiers2, z2, (i & 8) != 0 ? false : z3);
    }
}

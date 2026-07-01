package d0.e0.p.d.m0.e.a.l0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final e$a a = new e$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f3344b = new e(null, null, false, false, 8, null);
    public final h c;
    public final f d;
    public final boolean e;
    public final boolean f;

    public e(h hVar, f fVar, boolean z2, boolean z3) {
        this.c = hVar;
        this.d = fVar;
        this.e = z2;
        this.f = z3;
    }

    public static final /* synthetic */ e access$getNONE$cp() {
        return f3344b;
    }

    public final f getMutability() {
        return this.d;
    }

    public final h getNullability() {
        return this.c;
    }

    public final boolean isNotNullTypeParameter() {
        return this.e;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.f;
    }

    public /* synthetic */ e(h hVar, f fVar, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hVar, fVar, z2, (i & 8) != 0 ? false : z3);
    }
}

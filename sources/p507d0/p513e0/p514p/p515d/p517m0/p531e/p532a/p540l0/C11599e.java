package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.e */
/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11599e {

    /* JADX INFO: renamed from: a */
    public static final a f23450a = new a(null);

    /* JADX INFO: renamed from: b */
    public static final C11599e f23451b = new C11599e(null, null, false, false, 8, null);

    /* JADX INFO: renamed from: c */
    public final EnumC11602h f23452c;

    /* JADX INFO: renamed from: d */
    public final EnumC11600f f23453d;

    /* JADX INFO: renamed from: e */
    public final boolean f23454e;

    /* JADX INFO: renamed from: f */
    public final boolean f23455f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.e$a */
    /* JADX INFO: compiled from: typeQualifiers.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11599e getNONE() {
            return C11599e.f23451b;
        }
    }

    public C11599e(EnumC11602h enumC11602h, EnumC11600f enumC11600f, boolean z2, boolean z3) {
        this.f23452c = enumC11602h;
        this.f23453d = enumC11600f;
        this.f23454e = z2;
        this.f23455f = z3;
    }

    public final EnumC11600f getMutability() {
        return this.f23453d;
    }

    public final EnumC11602h getNullability() {
        return this.f23452c;
    }

    public final boolean isNotNullTypeParameter() {
        return this.f23454e;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.f23455f;
    }

    public /* synthetic */ C11599e(EnumC11602h enumC11602h, EnumC11600f enumC11600f, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enumC11602h, enumC11600f, z2, (i & 8) != 0 ? false : z3);
    }
}

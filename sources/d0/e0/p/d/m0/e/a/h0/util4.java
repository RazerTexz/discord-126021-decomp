package d0.e0.p.d.m0.e.a.h0;

import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.l, reason: use source file name */
/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class util4 {
    public final KotlinType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3318b;

    public util4(KotlinType kotlinType, boolean z2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        this.a = kotlinType;
        this.f3318b = z2;
    }

    public final boolean getHasDefaultValue() {
        return this.f3318b;
    }

    public final KotlinType getType() {
        return this.a;
    }
}

package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.r, reason: use source file name */
/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class utils7 {
    public final KotlinType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final utils7 f3531b;

    public utils7(KotlinType kotlinType, utils7 utils7Var) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        this.a = kotlinType;
        this.f3531b = utils7Var;
    }

    public final utils7 getPrevious() {
        return this.f3531b;
    }

    public final KotlinType getType() {
        return this.a;
    }
}

package d0.e0.p.d.l0;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.l0.f, reason: use source file name */
/* JADX INFO: compiled from: Caller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Caller3 {
    public static final int getArity(Caller2<?> caller2) {
        Intrinsics3.checkNotNullParameter(caller2, "$this$arity");
        return caller2.getParameterTypes().size();
    }
}

package d0.e0.p.d;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.a0, reason: use source file name */
/* JADX INFO: compiled from: KotlinReflectionInternalError.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinReflectionInternalError extends Error {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinReflectionInternalError(String str) {
        super(str);
        Intrinsics3.checkNotNullParameter(str, "message");
    }
}

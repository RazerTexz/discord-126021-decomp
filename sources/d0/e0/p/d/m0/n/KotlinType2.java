package d0.e0.p.d.m0.n;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.e0, reason: use source file name */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinType2 {
    public static final boolean isError(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        return (kotlinType3Unwrap instanceof ErrorType2) || ((kotlinType3Unwrap instanceof KotlinType6) && (((KotlinType6) kotlinType3Unwrap).getDelegate() instanceof ErrorType2));
    }

    public static final boolean isNullable(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return TypeUtils.isNullableType(kotlinType);
    }
}

package d0.e0.p.d.m0.n;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.t0, reason: use source file name */
/* JADX INFO: compiled from: TypeCapabilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeCapabilities2 {
    public static final TypeCapabilities getCustomTypeVariable(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        d0.e0.p.d.m0.n.n1.h hVarUnwrap = kotlinType.unwrap();
        TypeCapabilities typeCapabilities = hVarUnwrap instanceof TypeCapabilities ? (TypeCapabilities) hVarUnwrap : null;
        if (typeCapabilities != null && typeCapabilities.isTypeVariable()) {
            return typeCapabilities;
        }
        return null;
    }

    public static final boolean isCustomTypeVariable(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        d0.e0.p.d.m0.n.n1.h hVarUnwrap = kotlinType.unwrap();
        TypeCapabilities typeCapabilities = hVarUnwrap instanceof TypeCapabilities ? (TypeCapabilities) hVarUnwrap : null;
        if (typeCapabilities == null) {
            return false;
        }
        return typeCapabilities.isTypeVariable();
    }
}

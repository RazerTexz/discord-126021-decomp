package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.d1, reason: use source file name */
/* JADX INFO: compiled from: TypeSystemCommonBackendContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface TypeSystemCommonBackendContext extends d0.e0.p.d.m0.n.n1.n {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d1$a */
    /* JADX INFO: compiled from: TypeSystemCommonBackendContext.kt */
    public static final class a {
        public static d0.e0.p.d.m0.n.n1.h makeNullable(TypeSystemCommonBackendContext typeSystemCommonBackendContext, d0.e0.p.d.m0.n.n1.h hVar) {
            Intrinsics3.checkNotNullParameter(typeSystemCommonBackendContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            d0.e0.p.d.m0.n.n1.i iVarAsSimpleType = typeSystemCommonBackendContext.asSimpleType(hVar);
            return iVarAsSimpleType == null ? hVar : typeSystemCommonBackendContext.withNullability(iVarAsSimpleType, true);
        }
    }

    FqNameUnsafe getClassFqNameUnsafe(d0.e0.p.d.m0.n.n1.l lVar);

    PrimitiveType getPrimitiveArrayType(d0.e0.p.d.m0.n.n1.l lVar);

    PrimitiveType getPrimitiveType(d0.e0.p.d.m0.n.n1.l lVar);

    d0.e0.p.d.m0.n.n1.h getRepresentativeUpperBound(d0.e0.p.d.m0.n.n1.m mVar);

    d0.e0.p.d.m0.n.n1.h getSubstitutedUnderlyingType(d0.e0.p.d.m0.n.n1.h hVar);

    d0.e0.p.d.m0.n.n1.m getTypeParameterClassifier(d0.e0.p.d.m0.n.n1.l lVar);

    boolean hasAnnotation(d0.e0.p.d.m0.n.n1.h hVar, FqName fqName);

    boolean isInlineClass(d0.e0.p.d.m0.n.n1.l lVar);

    boolean isUnderKotlinPackage(d0.e0.p.d.m0.n.n1.l lVar);

    d0.e0.p.d.m0.n.n1.h makeNullable(d0.e0.p.d.m0.n.n1.h hVar);
}

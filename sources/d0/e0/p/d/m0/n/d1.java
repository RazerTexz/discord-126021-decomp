package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: TypeSystemCommonBackendContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d1 extends d0.e0.p.d.m0.n.n1.n {
    d0.e0.p.d.m0.g.c getClassFqNameUnsafe(d0.e0.p.d.m0.n.n1.l lVar);

    d0.e0.p.d.m0.b.i getPrimitiveArrayType(d0.e0.p.d.m0.n.n1.l lVar);

    d0.e0.p.d.m0.b.i getPrimitiveType(d0.e0.p.d.m0.n.n1.l lVar);

    d0.e0.p.d.m0.n.n1.h getRepresentativeUpperBound(d0.e0.p.d.m0.n.n1.m mVar);

    d0.e0.p.d.m0.n.n1.h getSubstitutedUnderlyingType(d0.e0.p.d.m0.n.n1.h hVar);

    d0.e0.p.d.m0.n.n1.m getTypeParameterClassifier(d0.e0.p.d.m0.n.n1.l lVar);

    boolean hasAnnotation(d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.g.b bVar);

    boolean isInlineClass(d0.e0.p.d.m0.n.n1.l lVar);

    boolean isUnderKotlinPackage(d0.e0.p.d.m0.n.n1.l lVar);

    d0.e0.p.d.m0.n.n1.h makeNullable(d0.e0.p.d.m0.n.n1.h hVar);
}

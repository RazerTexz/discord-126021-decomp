package d0.e0.p.d.m0.l.b;

import java.util.List;

/* JADX INFO: compiled from: AnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface c<A, C> {
    List<A> loadCallableAnnotations(y yVar, d0.e0.p.d.m0.i.n nVar, b bVar);

    List<A> loadClassAnnotations(y$a y_a);

    List<A> loadEnumEntryAnnotations(y yVar, d0.e0.p.d.m0.f.g gVar);

    List<A> loadExtensionReceiverParameterAnnotations(y yVar, d0.e0.p.d.m0.i.n nVar, b bVar);

    List<A> loadPropertyBackingFieldAnnotations(y yVar, d0.e0.p.d.m0.f.n nVar);

    C loadPropertyConstant(y yVar, d0.e0.p.d.m0.f.n nVar, d0.e0.p.d.m0.n.c0 c0Var);

    List<A> loadPropertyDelegateFieldAnnotations(y yVar, d0.e0.p.d.m0.f.n nVar);

    List<A> loadTypeAnnotations(d0.e0.p.d.m0.f.q qVar, d0.e0.p.d.m0.f.z.c cVar);

    List<A> loadTypeParameterAnnotations(d0.e0.p.d.m0.f.s sVar, d0.e0.p.d.m0.f.z.c cVar);

    List<A> loadValueParameterAnnotations(y yVar, d0.e0.p.d.m0.i.n nVar, b bVar, int i, d0.e0.p.d.m0.f.u uVar);
}

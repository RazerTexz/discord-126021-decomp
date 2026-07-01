package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.l.b.ProtoContainer;
import d0.e0.p.d.m0.n.KotlinType;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.c, reason: use source file name */
/* JADX INFO: compiled from: AnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationAndConstantLoader<A, C> {
    List<A> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind);

    List<A> loadClassAnnotations(ProtoContainer.a aVar);

    List<A> loadEnumEntryAnnotations(ProtoContainer protoContainer, d0.e0.p.d.m0.f.g gVar);

    List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind);

    List<A> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, d0.e0.p.d.m0.f.n nVar);

    C loadPropertyConstant(ProtoContainer protoContainer, d0.e0.p.d.m0.f.n nVar, KotlinType kotlinType);

    List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, d0.e0.p.d.m0.f.n nVar);

    List<A> loadTypeAnnotations(d0.e0.p.d.m0.f.q qVar, NameResolver nameResolver);

    List<A> loadTypeParameterAnnotations(d0.e0.p.d.m0.f.s sVar, NameResolver nameResolver);

    List<A> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, d0.e0.p.d.m0.f.u uVar);
}

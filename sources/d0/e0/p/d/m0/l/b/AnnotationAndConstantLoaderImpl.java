package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.f.b;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.ProtoBufUtil;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.l.SerializerExtensionProtocol;
import d0.e0.p.d.m0.l.b.ProtoContainer;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d, reason: use source file name */
/* JADX INFO: compiled from: AnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, d0.e0.p.d.m0.k.v.g<?>> {
    public final SerializerExtensionProtocol a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnnotationDeserializer f3484b;

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor2 moduleDescriptor2, NotFoundClasses notFoundClasses, SerializerExtensionProtocol serializerExtensionProtocol) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(serializerExtensionProtocol, "protocol");
        this.a = serializerExtensionProtocol;
        this.f3484b = new AnnotationDeserializer(moduleDescriptor2, notFoundClasses);
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        List listEmptyList;
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "proto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        if (messageLite instanceof d0.e0.p.d.m0.f.d) {
            listEmptyList = (List) ((d0.e0.p.d.m0.f.d) messageLite).getExtension(this.a.getConstructorAnnotation());
        } else if (messageLite instanceof d0.e0.p.d.m0.f.i) {
            listEmptyList = (List) ((d0.e0.p.d.m0.f.i) messageLite).getExtension(this.a.getFunctionAnnotation());
        } else {
            if (!(messageLite instanceof d0.e0.p.d.m0.f.n)) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Unknown message: ", messageLite).toString());
            }
            int iOrdinal = annotatedCallableKind.ordinal();
            if (iOrdinal == 1) {
                listEmptyList = (List) ((d0.e0.p.d.m0.f.n) messageLite).getExtension(this.a.getPropertyAnnotation());
            } else if (iOrdinal == 2) {
                listEmptyList = (List) ((d0.e0.p.d.m0.f.n) messageLite).getExtension(this.a.getPropertyGetterAnnotation());
            } else {
                if (iOrdinal != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto".toString());
                }
                listEmptyList = (List) ((d0.e0.p.d.m0.f.n) messageLite).getExtension(this.a.getPropertySetterAnnotation());
            }
        }
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadClassAnnotations(ProtoContainer.a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "container");
        List listEmptyList = (List) aVar.getClassProto().getExtension(this.a.getClassAnnotation());
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), aVar.getNameResolver()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(ProtoContainer protoContainer, d0.e0.p.d.m0.f.g gVar) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(gVar, "proto");
        List listEmptyList = (List) gVar.getExtension(this.a.getEnumEntryAnnotation());
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "proto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, d0.e0.p.d.m0.f.n nVar) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(nVar, "proto");
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, d0.e0.p.d.m0.f.n nVar) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(nVar, "proto");
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadTypeAnnotations(d0.e0.p.d.m0.f.q qVar, NameResolver nameResolver) {
        Intrinsics3.checkNotNullParameter(qVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        List listEmptyList = (List) qVar.getExtension(this.a.getTypeAnnotation());
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(d0.e0.p.d.m0.f.s sVar, NameResolver nameResolver) {
        Intrinsics3.checkNotNullParameter(sVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        List listEmptyList = (List) sVar.getExtension(this.a.getTypeParameterAnnotation());
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, d0.e0.p.d.m0.f.u uVar) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "callableProto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        Intrinsics3.checkNotNullParameter(uVar, "proto");
        List listEmptyList = (List) uVar.getExtension(this.a.getParameterAnnotation());
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public d0.e0.p.d.m0.k.v.g<?> loadPropertyConstant(ProtoContainer protoContainer, d0.e0.p.d.m0.f.n nVar, KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(nVar, "proto");
        Intrinsics3.checkNotNullParameter(kotlinType, "expectedType");
        b.C0393b.c cVar = (b.C0393b.c) ProtoBufUtil.getExtensionOrNull(nVar, this.a.getCompileTimeValue());
        if (cVar == null) {
            return null;
        }
        return this.f3484b.resolveValue(kotlinType, cVar, protoContainer.getNameResolver());
    }
}
